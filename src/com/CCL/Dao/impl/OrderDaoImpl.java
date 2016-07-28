package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.CCL.Dao.OrderDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	private final static Class mClassName = Order.class;

	@Override
	public List<Order> queryByState(OrderState bicycleState) {
		String hql = "from " + mClassName.getName() + " where ORDER_STATE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, bicycleState.getId());
		return query.list();
	}

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

	@Override
	public List<Order> queryAll() {
		Session session = getSession();
		return session.createQuery("from " + getEntityClass().getName() + " order by put_Time desc").list();
	}
}
