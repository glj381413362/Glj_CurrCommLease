package com.CCL.view.operatormgr.mydao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.CCL.Dao.OpeUserDao;
import com.CCL.beans.OpeUser;

public class MyOpeUserDaoImpl implements OpeUserDao {

	@Override
	public OpeUser get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpeUser> queryAll() {
		// TODO Auto-generated method stub
		List<OpeUser> all = new ArrayList<OpeUser>();

		OpeUser eaa = new OpeUser();
		eaa.setName("asdf");

		all.add(eaa);

		eaa = new OpeUser();
		eaa.setName("gafd");
		all.add(eaa);

		return all;
	}

//	@Override
//	public void remove(int id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void add(OpeUser opeUser) {
//		System.out.println("操作员：" + opeUser.getName() + "添加成功");
//
//	}

	
	@Override
	public List<OpeUser> queryByExample(OpeUser instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpeUser> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpeUser> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpeUser> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpeUser> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return true;
	}

	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(OpeUser bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OpeUser bicycle) {
		// TODO Auto-generated method stub
		return false;
	}

}
