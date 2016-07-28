package com.CCL.service.glj;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.hibernate.SQLQuery;
import org.hibernate.Session;


import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BillDao;
import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.Dao.impl.OrderDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.beans.OpeUser;
import com.CCL.util.glj.DateUtil;

public class MingXiSelectService {

	static BillDao rry_billdao = new BillDaoImpl();
	static OrderDao rry_orderdao = new OrderDaoImpl();
	static BicycleDao bicycleDao = new BicycleDaoImpl();
	static OpeUserDao opeUserDao = new OpeUserDaoImpl();
	
	
	
	/**
	 * @Description:传入一个ope_user 的name返回一个完整的select语句
	 * @param splstr_tiaojian1
	 * @return  String
	 * @returnType String
	 * * @author 龚梁钧
	 * @Createed  2016-06-14 13:30
	 */
	public static String getSqlstr(String splstr_tiaojian1 , String splstr_tiaojian2,String stim, String etime)
	{
		String sqlstr_all = "select bill.id,ope_user.user_name,t_order.customer_id,bill.customer_name,t_order.start_time,t_order.stop_time,t_order.deposit,bill.total,bill.payway,bill.delay,t_order.bicycles from bill,t_order,ope_user where bill.order_id=t_order.id and t_order.opeuser_id=ope_user.id";
		sqlstr_all = splstr_tiaojian1.equals("所有") ? sqlstr_all :  sqlstr_all +" "+"and" + " "+"ope_user.user_name ="+"'"+splstr_tiaojian1+"'";
		System.out.println(sqlstr_all);
		sqlstr_all = splstr_tiaojian2.equals("所有") ? sqlstr_all+" "+"and" + " "+ "t_order.stop_time" + " between " +"to_timestamp('"+stim+"','yy-MM-dd')"+" and to_timestamp('" +etime+"','yy-MM-dd')":  sqlstr_all +" "+"and" + " "+"bill.payway ="+"'"+splstr_tiaojian2+"'"+" "+"and" + " "+ "t_order.stop_time" + " between " +"to_timestamp('"+stim+"','yy-MM-dd')"+" and to_timestamp('" +etime+"','yy-MM-dd')";
	
		return sqlstr_all;
	}
	
	/**  
	*  
	* @Description:返回所有操作员
	* @param null
	* @return  所有操作员
	* @ReturnType List
	*  @author:  龚梁钧
	*@Created 2016-06-13 22：03
	*/
	public static List<OpeUser> getAllOpeUser()
	{
		return opeUserDao.queryAll();
	}
	
	/**  
	*  
	* @Description:账单明细查询功能下的表格数据，传入操作员的名字，以 Vector<Vector<Object>>返回
	* @param opeUser_name
	* @return  tableValueV
	* @ReturnType Vector<Vector<Object>>
	*  @author:  龚梁钧
	*@Created 2016-06-13 21：03
	*/
	public static Vector<Vector<Object>> getTableDate(String opeUser_name,String bill_payway,String stim, String etime)
	{
		String sqlstr = getSqlstr(opeUser_name,bill_payway,stim,etime);
		List<Object[]> tableDate = getDateList(sqlstr);
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();
		Vector<Object> rowDate = null;
		int i = 1;
	for (Object[] objects : tableDate) {
		rowDate = new Vector<Object>();
		rowDate.add(i++);
		for (Object object : objects) {
			if(rowDate.size()==5||rowDate.size()==6)
			{
				String time =  object.toString();
				String str = time.substring(0,time.lastIndexOf(":"));
				object = str;
			}else if(rowDate.size()==7||rowDate.size()==8)
			{
				String money1 =  object.toString();
				String money = money1 + "元";
				object = money;
			}else if(rowDate.size()==9)
			{
				if(object.equals("现金支付"))
				{
					object = "现金支付";
				}else if(object.equals("余额支付")){
					object = "余额支付";
				}
				else{
					object = "支付宝";
				}
			}else if(rowDate.size()==10)
			{
				object = object + "分钟";
			}else if(rowDate.size()==11)
			{
				String[] entryStrs = object.toString().split(";");
				object = "";
				for (String string : entryStrs) {
					String[] entry = string.split(":");
					int bicycleId = Integer.parseInt(entry[0]);
					int num = Integer.parseInt(entry[1]);
					BicycleType bicycleType = bicycleDao.get(bicycleId).getType();
					object = object + bicycleType.toString() +" " + num + "辆"+"   ";
				}
			}
			rowDate.addElement(object);
		}
		tableValueV.add(rowDate);
	}
	return tableValueV;
	}
	
	
	/**  
	*  
	* @Description:传入一个sql语句查询数据库 
	* @param sqlStr 
	* @return  list
	* @ReturnType List<Object[]>
	*  @author:  龚梁钧
	*@Created 2016-06-13 20：03
	*/
	public static List<Object[]> getDateList(String sqlStr)
	{
		Session session = HibernateSessionFactory.getSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlStr);
		List<Object[]> list = sqlQuery.list();
		return list;
	}
	public static void main(String[] args) {
		System.out.println(MingXiSelectService.getSqlstr("所有","现金支付","2013-12-11","2017-12-11"));
	}
}
