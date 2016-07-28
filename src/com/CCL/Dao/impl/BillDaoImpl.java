package com.CCL.Dao.impl;

import com.CCL.Dao.BillDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bill;

public class BillDaoImpl extends BaseDao<Bill> implements BillDao {

	private final static Class mClassName = Bill.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
