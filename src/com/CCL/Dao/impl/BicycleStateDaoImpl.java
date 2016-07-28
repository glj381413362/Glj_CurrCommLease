package com.CCL.Dao.impl;

import com.CCL.Dao.BicycleStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.BicycleState;

public class BicycleStateDaoImpl extends BaseDao<BicycleState> implements BicycleStateDao {

	private final static Class mClassName = BicycleState.class;

	@Override
	public Class getEntityClass() {
		return mClassName;
	}

}
