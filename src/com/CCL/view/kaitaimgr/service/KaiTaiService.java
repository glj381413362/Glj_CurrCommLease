package com.CCL.view.kaitaimgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.Dao.impl.OrderStateDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;
import com.CCL.util.mlf.PublicDate;
import com.CCL.view.other.son.Send;
import com.CCL.view.other.son.Util_pro;

/**
 * 前台服务的核心逻辑 ,提供主要的前台的业务方法 连接数据层和视图层
 * 
 * @author Jonney
 * 
 */
public class KaiTaiService {

	// 加载数据库访问层的对象
	static OrderDao orderDao = new OrderDaoImpl();
	static OrderStateDao orderStateDao = new OrderStateDaoImpl();
	static BillDao billDao = new BillDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();
	static CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * 租车的业务方法 生成订单 并保存到数据库
	 * 
	 * @param currentCustomer
	 *            当前的需要租车的客户
	 * @param bicycles
	 *            要租的车辆和数量 的Map集合
	 * @return 订单对象
	 */
	public static Order rentCar(Customer currentCustomer,
			Map<Bicycle, Integer> bicycles) {

		if (bicycles == null) {
			return null;
		}

		boolean isCanRent = true;
		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			if (bicycleEntry.getKey().getInventory() < bicycleEntry.getValue()) {
				isCanRent = false;
			}
		}
		if (isCanRent == false) {
			return null;
		}
		Order newOrder = new Order(currentCustomer, PublicDate.getOuser(),
				converyBicycles2String(bicycles), getStateByName("准备就绪"),
				new Date(), null, null, 200f);
		if (orderDao.add(newOrder)) {
			return newOrder;
		} else {
			return null;
		}

	}

	/**
	 * 通过订单状态的名称获取对应状态对象
	 * 
	 * @param state
	 *            状态名称
	 * @return 状态对象
	 */
	public static OrderState getStateByName(String state) {
		List<OrderState> queryByUseLikeAndPage = orderStateDao
				.queryByUseLikeAndPage("name", state, 10, 0);
		OrderState cst = null;
		if (queryByUseLikeAndPage != null && queryByUseLikeAndPage.size() > 0) {
			cst = queryByUseLikeAndPage.get(0);
		} else {
			OrderState newState = new OrderState(state, null);
			orderStateDao.add(newState);
			cst = newState;
		}
		return cst;
	}

	/**
	 * 获取所以订单(默认是按订单生成时间排序)
	 * 
	 * @return 所以订单
	 */
	public static List<Order> getAllOrder() {

		List<Order> allOrder = orderDao.queryAll();

		return allOrder;
	}

	/**
	 * 开启订单,使订单从准备状态转换为运行状态 并对直行车做减库存的操作
	 * 
	 * @param corder
	 *            要操作的订单
	 * @return 返回操作成功还是失败
	 */
	public static boolean startOrder(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}
		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			if (entry.getKey().getInventory() < entry.getValue()) {
				return false;
			}
		}

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() - num);
			bicycleDao.update(bicyc);
		}

		corder.setStartTime(new Date());
		corder.setOrderState(getStateByName("正在进行"));
		return orderDao.update(corder);
	}

	/**
	 * 把订单的的 字符串编码的直行车集合数据 转换成 Map
	 * 
	 * @param corder
	 *            要操作的订单
	 */
	public static void writebicycleMap(Order corder) {

		Map<Bicycle, Integer> bicyclesMap = new HashMap<Bicycle, Integer>();
		String[] entryStrs = corder.getBicycles().split(";");

		for (String string : entryStrs) {
			String[] entry = string.split(":");
			int bicycleId = Integer.parseInt(entry[0]);
			Bicycle bicycle = bicycleDao.get(bicycleId);
			int num = entry.length == 2 ? Integer.parseInt(entry[1]) : 1;
			bicyclesMap.put(bicycle, num);
		}
		corder.setBicyclesMap(bicyclesMap);

	}

	/**
	 * 结账订单,生成账单 将订单的状态有进行转换成完成 ,并归还车辆
	 * 
	 * @param corder
	 *            要操作的订单
	 * @return 订单生成的账单
	 */
	public static Bill accountsOrder(Order corder) {
		corder.setStopTime(new Date());
		float spendTime = (float) ((corder.getStopTime().getTime() - corder
				.getStartTime().getTime()) / 1000.0 / 60);

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			bicyc.setInventory(bicyc.getInventory() + num);
			// originalCost += (bicyc.getIsDaZhe()?
			// bicyc.getType().getDiscount()/10:1) * bicyc.getPrice() * num;
			bicycleDao.update(bicyc);
		}

		// 计算花费
		float huafei = calcPrice(corder, spendTime);

		Customer customer = corder.getCustomer();
		Bill newBill = null;

		// 支付订单
		if (customer.getMoney() >= huafei) {
			newBill = new Bill(new Date(), (long) spendTime, corder, corder
					.getCustomer().getName(), corder.getCustomer().getId(),
					"余额支付", huafei);
			customer.setMoney(customer.getMoney() - huafei);
		} else {
			newBill = new Bill(new Date(), (long) spendTime, corder, corder
					.getCustomer().getName(), corder.getCustomer().getId(),
					"现金支付", huafei);
		}

		corder.setOrderState(getStateByName("订单完成"));
		orderDao.update(corder);
		billDao.add(newBill);

		// 计算积分
		customer.setIntegral((int) (customer.getIntegral() + calcJiFen(bicyclesMap)));
		customerDao.update(customer);

		return newBill;
	}

	/**
	 * 计算积分
	 * 
	 * @param bicyclesMap
	 * @return
	 */
	private static Float calcJiFen(Map<Bicycle, Integer> bicyclesMap) {
		Float jiFen = 0f;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			if (bicyc.getIsJiFen() == 1) {
				int num = entry.getValue();
				jiFen += bicyc.getPrice() * num;
			}
		}
		jiFen /= 100;
		return jiFen;
	}

	/**
	 * 删除未开始的订单 ,已经开始的订单无法删除
	 * 
	 * @param corder
	 * @return 是否删除成功
	 */
	public static boolean delOrder(Order corder) {
		boolean remove = orderDao.remove(corder.getId());
		return remove;
	}

	/**
	 * 将自信车 和 数量的Map集合 编码成 对应的字符串
	 * 
	 * @param bicycles
	 * @return 编码后的字符串
	 */
	public static String converyBicycles2String(Map<Bicycle, Integer> bicycles) {

		StringBuilder str = new StringBuilder();

		for (Entry<Bicycle, Integer> bicycleEntry : bicycles.entrySet()) {
			str.append(bicycleEntry.getKey().getId() + ":"
					+ bicycleEntry.getValue() + ";");
		}

		if (str.charAt(str.length() - 1) == ';') {
			str.deleteCharAt(str.length() - 1);
		}
		return str.toString();
	}

	/**
	 * 计算订单的价格
	 * 
	 * @param corder
	 *            订单
	 * @param spendTime
	 *            实际花费的时间(分钟)
	 * @return 价格
	 */
	public static float calcPrice(Order corder, float spendTime) {
		spendTime = (int) (spendTime + 0.5);

		Map<Bicycle, Integer> bicyclesMap = corder.getBicyclesMap();

		if (bicyclesMap == null) {
			writebicycleMap(corder);
			bicyclesMap = corder.getBicyclesMap();
		}

		float originalCost = 0;

		for (Entry<Bicycle, Integer> entry : bicyclesMap.entrySet()) {
			Bicycle bicyc = entry.getKey();
			int num = entry.getValue();
			float unit = (bicyc.getIsDaZhe() == 1 ? bicyc.getType()
					.getDiscount() / 10 : 1) * bicyc.getPrice();
			float unithuafei = (((int) spendTime) / bicyc.getBaseTime()) * unit;
			if ((spendTime % bicyc.getBaseTime()) > bicyc.getChargeTime()) {
				unithuafei += unit;
			} else {
				unithuafei += bicyc.getOverTimePrice();

			}

			originalCost += unithuafei * num;
		}
		float f = originalCost
				* (corder.getCustomer().getCustomerType().getDiscount() / 10);
		return f;

	}

	/**
	 * 获取所以可以准备就绪的订单
	 * 
	 * @return 订单集合
	 */
	public static List<Order> getAllPreOrder() {

		OrderState bicycleState = getStateByName("准备就绪");
		return orderDao.queryByState(bicycleState);
	}

	/**
	 * 更新订单
	 * 
	 * @param currentOrder
	 *            待更新的订单
	 */
	public static void updateOrder(Order currentOrder) {
		orderDao.update(currentOrder);
	}

	public static Bill getBillByOrder(Order order) {
		
		List<Bill> queryByUsePage = billDao.queryByUsePage("ORDER_ID", order.getId(), 1, 0);
		if(queryByUsePage.isEmpty()){
			return null;
		}
		else{
			return queryByUsePage.get(0);
		}
	}
	
	static boolean isEnableSmsNotice = "true".equals( Util_pro.readData("sms.enable"));
	static int noticeOverTime = Integer.parseInt( Util_pro.readData("time"));
	static Map<String,Boolean> isSended = new HashMap<String,Boolean>();
	public static int smsNotice(Order order) {
		if(isEnableSmsNotice){
			Date date = order.getStartTime();
			Date d1 = new Date();
			
			Date d2 = date;
			long diff = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别
			
			
			int hours = (int) (diff / (1000 * 60 * 60));
			Boolean issended = isSended.get(order.getId()+":"+hours);
			if(issended==null) issended=false;
			if(hours>0&&hours%noticeOverTime==0&&!issended){
				String tel = order.getCustomer().getPhone();
				if(tel!=null){
					String text = "您的租的商品快到归还时间了  ,请您尽快归还!";
					int sendMessage = Send.sendMessage(tel, text);
					System.out.println("发送短信返回码:"+sendMessage);
					isSended.put(order.getId()+":"+hours, true);
					return sendMessage;
					
				}
				
			}
			
			
		}
		return 0;
	}
	
}
