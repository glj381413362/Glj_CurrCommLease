package com.CCL.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

public class BicycleDaoImpl extends BaseDao<Bicycle> implements BicycleDao {

	private final static Class mClassName = Bicycle.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

	@Override
	public List<Bicycle> queryByType(BicycleType bicycleType) {
		String hql = "from " + mClassName.getName() + " where TYPE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, bicycleType.getId());
		return query.list();
	}

	@Override
	public List<Bicycle> queryByState(BicycleState bicycleState) {
		String hql = "from " + mClassName.getName() + " where STATE_ID=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, bicycleState.getId());
		return query.list();
	}

}
