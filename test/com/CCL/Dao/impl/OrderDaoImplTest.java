package com.CCL.Dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.OrderDao;
import com.CCL.beans.Order;

public class OrderDaoImplTest {

	public static void main(String[] args) {
		OrderDaoImplTest orderDaoTest = new OrderDaoImplTest();
		orderDaoTest.testAdd();
		
		
	}

	OrderDao dao = new OrderDaoImpl();

	@Test
	public void testAdd() {
		Order order = new Order();
		order.setId(32);
		order.setDeposit(545.6f);

		dao.add(order);
		
		
		order = new Order();
		order.setDeposit(5.6f);
		dao.add(order);
		
		
		


	}

	@Test
	public void testGet() {
		Order b = dao.get(2);

		System.out.println(b);
	}

	@Test
	public void testQueryAll() {
		List<Order> queryAll = dao.queryAll();

		for (Order order : queryAll) {
			System.out.println(order.getId()+":"+order.getPutTime().toGMTString());
		}

	}
	
	@Test
	public void testQueryByUseLikeAndPage() {
		List<Order> queryAll = dao.queryByUseLikeAndPage("ID", 3+"", 0, 30);

		System.out.println(StringUtils.join(queryAll, "\n"));

	}
	
	@Test
	public void testQueryByUseLikeAndPage2() {
		
		Map<String,String> entry2 = new HashMap<String,String>();
		entry2.put("id", "f");
		List<Order> queryAll = dao.queryByUseLikeAndPage(entry2, 1, 3);

		System.out.println(StringUtils.join(queryAll, "\n"));

	}

	
	@Test
	public void testRemove() {
		dao.remove(2);

	}

	@Test
	public void testUpdate() {
		Order order = dao.get(32);
		if(order == null) return;
		order.setPutTime(new Date());
		dao.update(order);
	}
	
	
}
