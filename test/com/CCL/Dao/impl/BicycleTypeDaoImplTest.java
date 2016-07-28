package com.CCL.Dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.beans.BicycleType;

public class BicycleTypeDaoImplTest {

	BicycleTypeDao dao = new BicycleTypeDaoImpl();

	@Test
	public void testGet() {
		BicycleType b = dao.get(2);

		System.out.println(b);
	}

	@Test
	public void testQueryAll() {
		List<BicycleType> queryAll = dao.queryAll();

		System.out.println(StringUtils.join(queryAll, "\n"));

	}

	@Test
	public void testRemove() {
		dao.remove(2);

	}

	@Test
	public void testAdd() {
		BicycleType bicycle = new BicycleType();
		bicycle.setId(32);
		bicycle.setName("abce");

		dao.add(bicycle);
		
//		
//		bicycle = new BicycleType();
//		bicycle.setName("abssce");
//		dao.add(bicycle);
//		
//		bicycle = new BicycleType();
//		bicycle.setName("eee");
//		dao.add(bicycle);
//		
//		bicycle = new BicycleType();
//		bicycle.setName("bbabadfdssce");
//		dao.add(bicycle);
		


	}

	@Test
	public void testUpdate() {
		BicycleType bicycle = dao.get(32);
		if(bicycle == null) return;
		bicycle.setName("323443");
		dao.update(bicycle);
		
		
		

	}

	public static void main(String[] args) {
		BicycleTypeDaoImplTest bicycleDaoTest = new BicycleTypeDaoImplTest();
		bicycleDaoTest.testAdd();
		
		
	}
	
	
}
