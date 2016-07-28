package com.CCL.Dao.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BicycleStateDao;
import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.OrderStateDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

public class InitDB {

	private static org.hibernate.SessionFactory sessionFactory;
	private static Configuration configuration = new Configuration();
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static String configFile = CONFIG_FILE_LOCATION;

	

	public static void main(String[] args) {

		configuration.configure(configFile);
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		configuration.getProperties().list(System.out);
		sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// init bicycle type
		BicycleState bs1 = new BicycleState("维修中", "维修状态");
		BicycleState bs2 = new BicycleState("正常", "正常状态");
		BicycleState bs3 = new BicycleState("已出租", "已出租状态");
		session.save(bs1);
		session.save(bs2);
		session.save(bs3);

		BicycleType bt1 = new BicycleType("单人车", "A 类型", 8.5f);
		BicycleType bt2 = new BicycleType("双人车", "B 类型", 8f);
		BicycleType bt3 = new BicycleType("四人车", "C 类型", 7.5f);
		session.save(bt1);
		session.save(bt2);
		session.save(bt3);
//		BicycleState state,BicycleType type,String name,String descript,Integer price,Integer inventory,
//		String factory,Integer isDaZhe,Integer isJiFen,Integer baseTime,Integer chargeTime,Integer overTimePrice
		Bicycle b1 = new Bicycle(bs3, bt2, "A110", "蓝星赛车的描述", 5, 20, "凤凰", 1, 1, 60, 30, 3);
		Bicycle b2 = new Bicycle(bs1, bt1, "B111", "奥迪A8的描述", 7, 15, "永久",1, 1, 60,30, 4);
		Bicycle b3 = new Bicycle(bs2, bt3, "C111", "小刀电车的描述", 10, 14, "凤凰", 1, 1, 60, 30, 6);
		session.save(b1);
		session.save(b2);
		session.save(b3);

		CustomerState cs1 = new CustomerState("激活", "已激活");
		CustomerState cs2 = new CustomerState("注销", "已注销");
		// CustomerState cs3= new CustomerState("", "已激活");
		session.save(cs1);
		session.save(cs2);

		CustomerType ct1 = new CustomerType("白金", "", 7.5f);
		CustomerType ct2 = new CustomerType("黄金", "", 7f);
		CustomerType ct3= new CustomerType("金", "", 8f);
		CustomerType ct4= new CustomerType("普通", "", 9f);
		session.save(ct4);
		session.save(ct1);
		session.save(ct2);
		session.save(ct3);
//		CustomerState customerState,CustomerType customerType,String name,String sex,Date birthday,String password,
//		String phone,String email,String address,Integer integral,Float money
		
		Customer c1= new Customer(cs1, ct1, "张三", "男", new Date(), "000", "13077337409"," 38141436@qq.com"," 地球",30,12f );
		Customer c2= new Customer(cs1, ct4, "李四", "女", new Date(), "000", "13077337409", " 38145336@qq.com", " 地球",56,56f );
		Customer c3= new Customer(cs1, ct3, "王二",  "男", new Date(), "000", "13077337409", " 38161336@qq.com", " 地球",36,63f );
		Customer c4= new Customer(cs1, ct2, "赵五",  "男", new Date(), "000", "13077337409", " 38141336@qq.com", " 地球",86,56f );
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		
		OrderState os1 = new OrderState("准备就绪", null);
		OrderState os2 = new OrderState("正在进行", null);
		OrderState os3 = new OrderState("订单完成", null);
		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		Order o1 = new Order(c1, null, b2.getId()+":3", os3, new Date(2014,5,9),new Date(2016,5,9),new Date(2016,5,11), 0f);
		Order o2 = new Order(c3, null, b2.getId()+":3;"+b3.getId()+":4", os3, new Date(2016,11,7),new Date(2016,5,11),new Date(2014,5,9), 560f);
		Order o3 = new Order(c2, null, b2.getId()+":3", os3, new Date(2011,1,9), new Date(2016,5,9),new Date(2016,5,12),120f);
		session.save(o3);
		session.save(o2);
		session.save(o1);
		
		
		
		Bill bill1 = new Bill(new Date(), 20l,o1,c1.getName(),c1.getId(),"ZFB", 30);
		Bill bill2 = new Bill(new Date(), 20l,o2,c1.getName(),c1.getId(),"ZFB", 100);
		Bill bill3 = new Bill(new Date(), 20l,o3,c1.getName(),c1.getId(),"ZFB", 60);
//
//		session.save(bill1);
//		session.save(bill2);
//		session.save(bill3);
		
		
		//String userName, String password, Float salary, String name, String sex, Date birthday,String address, String phone, String photo, Opeper opePer
		
		OpeUser ou1=new OpeUser("abc", "123", 20f, "abc", "男", new Date(), "湖南", "18711180761", null, null);
		Opeper op1 = new Opeper(ou1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1,1, 1, 1);
		ou1.setOpePer(op1);
		session.save(ou1);

		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
		// System.exit(0);
	}

}
