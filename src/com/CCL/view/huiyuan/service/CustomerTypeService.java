package com.CCL.view.huiyuan.service;

import java.util.List;

import com.CCL.Dao.CustomerTypeDao;
import com.CCL.Dao.impl.CustomerTypeDaoImpl;
import com.CCL.beans.CustomerType;
import com.CCL.view.huiyuan.test.MyCustomerTypeDaoImpl;

public class CustomerTypeService {
	
	static CustomerTypeDao customerTypeDao = new CustomerTypeDaoImpl();

	public static List<CustomerType> getAllType() {
		
		return customerTypeDao.queryAll();
	}
	

	public static void add(CustomerType newcustomerType) {
		
		customerTypeDao.add(newcustomerType);
		
	}


	public static boolean delete(CustomerType selectedValue) {
		
		return customerTypeDao.remove(selectedValue.getId());
		
	}

}
