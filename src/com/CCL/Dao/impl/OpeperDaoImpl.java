package com.CCL.Dao.impl;

import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Opeper;

public class OpeperDaoImpl extends BaseDao<Opeper> implements OpeperDao {

	private final static Class mClassName = Opeper.class;

	@Override
	public Class getEntityClass() {
		return mClassName;
	}

}
