package com.CCL.Dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.CCL.Dao.BicycleDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class BicycleDaoImplTest {

	BicycleDao dao = new BicycleDaoImpl();

	@Test
	public void testGet() {
		Bicycle b = dao.get(2);

		System.out.println(b);
	}

	@Test
	public void testQueryAll() {
		List<Bicycle> queryAll = dao.queryAll();
		
		for (Bicycle bicycle : queryAll) {
			System.out.println(bicycle.getId()+"\t:\t"+bicycle.getIsShow());
		}
		
//		System.out.println(StringUtils.join(queryAll, "\n"));

	}

	@Test
	public void testRemove() {
		dao.remove(2);

	}

	@Test
	public void testAdd() {
		Bicycle bicycle = new Bicycle();
		bicycle.setName("tt");
		bicycle.setIsShow(true);
		dao.add(bicycle);
		
		
		bicycle = new Bicycle();
		bicycle.setName("ff");
		bicycle.setIsShow(false);
		dao.add(bicycle);
		
		bicycle = new Bicycle();
		bicycle.setName("nn");
		dao.add(bicycle);
		

		
//		BicycleStateDaoImpl bicycleDao = new BicycleStateDaoImpl();
//		bicycle.setName("false");
//		BicycleState bicycleState = bicycleDao.get(1);
//		bicycle.setBicycleState(bicycleState);
//		bicycle.setIsShow(false);
//		dao.add(bicycle);
//		
//		bicycle = new Bicycle();
//		bicycle.setName("true");
//		
//		bicycleState = new BicycleState();
//		bicycleState.setId(1);
//		bicycleState.setName("true");
//		bicycle.setBicycleState(bicycleState);
//		bicycle.setIsShow(true);
//		dao.add(bicycle);
//		
//		bicycle = new Bicycle();
//		bicycle.setName("null");
//		bicycle.setIsShow(null);
//		dao.add(bicycle);
//		
//		bicycle = new Bicycle();
//		bicycle.setName("bbabadfdssce");
//		bicycleState = bicycleDao.get(2);
//		bicycle.setBicycleState(bicycleState);
//		dao.add(bicycle);
		


	}

	@Test
	public void testUpdate() {
		Bicycle bicycle = dao.get(32);
		if(bicycle == null) return;
		bicycle.setName("323443");
		dao.update(bicycle);
		
		
		

	}

	public static void main(String[] args) {
		BicycleDaoImplTest bicycleDaoTest = new BicycleDaoImplTest();
		bicycleDaoTest.testAdd();
		
		bicycleDaoTest.testqueryByExample();
		
	}
	
	@Test
	public void testqueryByExample() {
		Bicycle instance = new Bicycle();
		
		BicycleType bicycleType = new BicycleType();
		
		bicycleType.setId(3);
		bicycleType.setName("ABC");
		instance.setType(bicycleType);
		instance.setName("abce");
		List<Bicycle> queryAll = dao.queryByExample(instance );
		System.out.println("list:");
		System.out.println(StringUtils.join(queryAll, "\n"));
	}
	
	@Test
	public void testqueryByLike() {
		
		//参数   数据库字段名  模糊匹配的值   分页大小   第几页
		List<Bicycle> queryAll = dao.queryByUseLikeAndPage("NAME", "值", 100, 0);
		System.out.println("list:");
		System.out.println(StringUtils.join(queryAll, "\n"));
	}
}
