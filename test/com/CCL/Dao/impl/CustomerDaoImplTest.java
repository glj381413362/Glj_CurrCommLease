package com.CCL.Dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.CustomerDao;
import com.CCL.beans.Customer;

public class CustomerDaoImplTest {

	public static void main(String[] args) {
		CustomerDaoImplTest customerDaoTest = new CustomerDaoImplTest();
		customerDaoTest.testAdd();
		
		
	}

	CustomerDao dao = new CustomerDaoImpl();

	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setId(32);
		customer.setName("abce");

		dao.add(customer);
		
		
		customer = new Customer();
		customer.setName("abssce");
		dao.add(customer);
		
		customer = new Customer();
		customer.setName("eee");
		dao.add(customer);
		
		customer = new Customer();
		customer.setName("bbabadfdssce");
		dao.add(customer);
		


	}

	@Test
	public void testGet() {
		Customer b = dao.get(2);

		System.out.println(b);
	}

	@Test
	public void testQueryAll() {
		List<Customer> queryAll = dao.queryAll();

		System.out.println(StringUtils.join(queryAll, "\n"));

	}
	
	@Test
	public void testQueryByUseLikeAndPage() {
		List<Customer> queryAll = dao.queryByUseLikeAndPage("ID", 3+"", 0, 30);

		System.out.println(StringUtils.join(queryAll, "\n"));

	}
	
	@Test
	public void testQueryByUseLikeAndPage2() {
		
		Map<String,String> entry2 = new HashMap<String,String>();
		entry2.put("name", "f");
		List<Customer> queryAll = dao.queryByUseLikeAndPage(entry2, 1, 3);

		System.out.println(StringUtils.join(queryAll, "\n"));

	}

	
	@Test
	public void testRemove() {
		dao.remove(2);

	}
	
	@Test
	public void testCount() {
		System.out.println(dao.count());

	}


	@Test
	public void testUpdate() {
		Customer customer = dao.get(32);
		if(customer == null) return;
		customer.setName("323443");
		dao.update(customer);
	}
	
	
}
