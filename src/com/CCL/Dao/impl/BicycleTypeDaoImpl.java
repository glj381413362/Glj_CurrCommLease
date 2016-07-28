package com.CCL.Dao.impl;

import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.BicycleType;

public class BicycleTypeDaoImpl extends BaseDao<BicycleType> implements BicycleTypeDao {

	private final static Class mClassName = BicycleType.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
