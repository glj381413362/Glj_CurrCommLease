package com.CCL.Dao.impl;

import com.CCL.Dao.OrderStateDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OrderState;

public class OrderStateDaoImpl extends BaseDao<OrderState> implements OrderStateDao {

	private final static Class mClassName = OrderState.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

}
