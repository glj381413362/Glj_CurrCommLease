package com.CCL.Dao.base;

import java.util.List;
import java.util.Map;

/**
 * 基本的数据访问层对象的接口
 * 
 * @author Jonney
 *
 * @param <T>
 *            Bean类的具体类型
 */
public interface BaseDaoInterface<T> {

	/**
	 * 根据ID获取某一数据库对象
	 * 
	 * @param id
	 * @return 返回改数据库查询结果封装后的对象
	 */
	T get(int id);

	/**
	 * 查询所以对象
	 * 
	 * @return 包含所有Bean的List的集合
	 */
	List<T> queryAll();

	/**
	 * 查询对象的数量
	 * 
	 * @return 对象所在数据库的记录条数
	 */
	long count();

	/**
	 * 根据ID删除某一数据记录
	 * 
	 * @param id
	 *            主键ID
	 * @return 删除是否成功
	 */
	boolean remove(int id);

	/**
	 * 把数据对象保存到数据库,试数据持久化
	 * 
	 * @param obj
	 *            待保存的数据对象
	 * @return 是否添加成功
	 */
	boolean add(T obj);

	/**
	 * 更新数据库中的对象 以主键为条件
	 * 
	 * @param obj
	 * @return 是否更新成功
	 */
	boolean update(T obj);

	// 通过对象查询
	List<T> queryByExample(T instance);

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
	List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber);

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
	List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber);

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
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber);

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
	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber);

}
