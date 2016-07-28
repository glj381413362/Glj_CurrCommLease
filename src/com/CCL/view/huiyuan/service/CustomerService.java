package com.CCL.view.huiyuan.service;

import java.util.List;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.CustomerStateDao;
import com.CCL.Dao.impl.BillDaoImpl;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.Dao.impl.CustomerStateDaoImpl;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;

public class CustomerService {
	
	static CustomerDao cd = new CustomerDaoImpl();
	static CustomerStateDao csd = new CustomerStateDaoImpl();
	static BillDao bi = new BillDaoImpl();
	public static boolean add(Customer ct) {
		// TODO Auto-generated method stub
//		System.out.println("添加客户:"+ct.getName());	
		cd.add(ct);
		
		return true;
		
	}

	public static Customer query(String id) {
		
		Customer ct = cd.get(Integer.parseInt(id));
		 return ct;
		
	}

	public static boolean logoutCustomer(Customer ct) {
		CustomerState cst = getStateByName("注销");
		ct.setCustomerState(cst);
		boolean update = cd.update(ct);
		return update;
	}

	public static boolean existUsername(String text) {
		// TODO Auto-generated method stub
		return !cd.queryByUsePage("name", text, 20, 0).isEmpty();
		 
	}

	public static CustomerState getStateByName(String state) {
		// TODO Auto-generated method stub
		CustomerState cst = csd.queryByUseLikeAndPage("name", state, 10,0).get(0);
		
		if(cst==null){
			CustomerState newState = new CustomerState(state, null);
			csd.add(newState);
			cst=newState;
		}
		return cst;
	}

	public static List<Customer> queryUserByKeyWord(String text) {
		
		
		List<Customer> list1 = cd.queryByUseLikeAndPage("name", text, 100, 0);
		List<Customer> list2 = cd.queryByUseLikeAndPage("id", text, 100, 0);
		
		list1.removeAll(list2);
		list1.addAll(list2);
		
		
		return list1;
	}

	public static List<Bill> queryUserByName(String text) {
		return bi.queryByUsePage("CUSTOMER_NAME", text, 100, 0);
	}
	
	
	public static List<Bill> queryUserByCustomer(Customer c) {
		if(c==null) return null;
		return bi.queryByUsePage("CUSTOMER_ID", c.getId(), 100, 0);
	}

	public static boolean bubanCustomer(Customer ct, String newPassWord) {
		
		ct.setPassword(newPassWord);

		CustomerState cst = CustomerService.getStateByName("激活");

		ct.setCustomerState(cst);
		
		return cd.update(ct);
		
	}

	public static void update(Customer ct) {
		cd.update(ct);
	}
	


}
