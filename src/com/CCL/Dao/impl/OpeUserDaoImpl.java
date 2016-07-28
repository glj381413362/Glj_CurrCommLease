package com.CCL.Dao.impl;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.base.BaseDao;
import com.CCL.beans.OpeUser;

public class OpeUserDaoImpl extends BaseDao<OpeUser> implements OpeUserDao {

	private final static Class mClassName = OpeUser.class;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return mClassName;
	}

	@Override
	public boolean remove(int id) {

		try {
			OpeUser opeUser = get(id);
			getSession().delete(opeUser);
			getSession().beginTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
