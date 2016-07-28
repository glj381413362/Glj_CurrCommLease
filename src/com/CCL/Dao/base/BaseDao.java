package com.CCL.Dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Customer;

/**
 * Hibernate Dao层的基类 把相同的方法抽象出来
 * 
 * @author Jonney
 *
 * @param <T>
 *            Bean类的具体类型
 */
public abstract class BaseDao<T> {

	public BaseDao() {
	}

	/**
	 * 获取 Hibernate Session 对象
	 * 
	 * @return 与数据库交互的 Session 对象
	 */
	protected static Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	/**
	 * 释放 Hibernate Session对象
	 */
	protected static void closeSession() {
		HibernateSessionFactory.closeSession();
	}

	/**
	 * 模板方法 子类实现 获取 Bean的Class对象 以供Hibernate与数据库进行交互
	 * 
	 * @return 当前要操作的 Bean 的 Class 对象
	 */
	public abstract Class getEntityClass();

	/**
	 * 根据某个关键字模糊匹配查询 ,并根据分页参数返回指定页的数据集合
	 * 
	 * @param property
	 *            匹配的属性字段 以数据库的字段为准
	 * @param value
	 *            进行模糊匹配的关键字的值
	 * @param pageSize
	 *            分页大小
	 * @param pageNumber
	 *            第几页
	 * @return 符合条件的数据集合
	 */
	public List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where " + property + " like '%" + value + "%'";
		Query query = getSession().createQuery(hql);
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 根据多个关键字同时成立的模糊匹配查询 ,并根据分页参数返回指定页的数据集合
	 * 
	 * @param entrys
	 *            属性与值的 键值对
	 * @param pageSize
	 *            分页大小
	 * @param pageNumber
	 *            第几页
	 * @return 符合条件的数据集合
	 */
	public List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {

		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql += " and " + property + " like ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for (int i = 0, n = keyOrder.size(); i < n; i++) {
			query.setString(i, "%" + entrys.get(keyOrder.get(i)) + "%");
		}
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @param instance
	 * @return
	 */
	public List<T> queryByExample(T instance) {
		Session session = getSession();
		List results = getSession().createCriteria(getEntityClass()).add(Example.create(instance)).list();
		return results;
	}

	/**
	 * 根据某个关键字精确匹配查询 ,并根据分页参数返回指定页的数据集合
	 * 
	 * @param property
	 *            匹配的属性字段 以数据库的字段为准
	 * @param value
	 *            进行模糊匹配的关键字的值
	 * @param pageSize
	 *            分页大小
	 * @param pageNumber
	 *            第几页
	 * @return 符合条件的数据集合
	 */
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		String hql = "from " + getEntityClass().getName() + " where " + property + "= ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, value);
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 根据多个关键字同时成立的精确匹配查询 ,并根据分页参数返回指定页的数据集合
	 * 
	 * @param entrys
	 *            属性与值的 键值对
	 * @param pageSize
	 *            分页大小
	 * @param pageNumber
	 *            第几页
	 * @return 符合条件的数据集合
	 */
	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {

		String hql = "from " + getEntityClass().getName() + " where 1=1";
		List<String> keyOrder = new ArrayList<String>();
		for (String property : entrys.keySet()) {
			hql += " and " + property + " = ?";
			keyOrder.add(property);
		}
		Query query = getSession().createQuery(hql);
		for (int i = 0, n = keyOrder.size(); i < n; i++) {
			query.setParameter(i, entrys.get(keyOrder.get(i)));
		}
		int i = pageSize * (pageNumber - 1);
		query.setFirstResult(i < 0 ? 0 : i);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 根据ID获取某一数据库对象
	 * 
	 * @param id
	 * @return 返回改数据库查询结果封装后的对象
	 */
	public T get(int id) {
		T bicycle = null;
		Session session = getSession();
		bicycle = (T) session.get(getEntityClass(), id);
		return bicycle;
	}

	/**
	 * 查询所以对象
	 * 
	 * @return 包含所有Bean的List的集合
	 */
	public List<T> queryAll() {
		Session session = getSession();
		return session.createQuery("from " + getEntityClass().getName()).list();
	}

	/**
	 * 根据ID删除某一数据记录
	 * 
	 * @param id
	 *            主键ID
	 * @return 删除是否成功
	 */
	public boolean remove(int id) {
		String hql = "delete " + getEntityClass().getName() + " where id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		try {
			query.executeUpdate();
			getSession().beginTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 把数据对象保存到数据库,试数据持久化
	 * 
	 * @param obj
	 *            待保存的数据对象
	 * @return 是否添加成功
	 */
	public boolean add(T obj) {
		Session session = getSession();
		Serializable result = session.save(obj);
		session.beginTransaction().commit();
		return result != null;

	}

	/**
	 * 更新数据库中的对象 以主键为条件
	 * 
	 * @param obj
	 * @return 是否更新成功
	 */
	public boolean update(T obj) {
		try {
			Session session = getSession();
			session.update(obj);
			session.beginTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * 查询对象的数量
	 * 
	 * @return 对象所在数据库的记录条数
	 */
	public long count() {
		String hql = "select count(*) from " + getEntityClass().getName();
		Query query = getSession().createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();

	}

}
