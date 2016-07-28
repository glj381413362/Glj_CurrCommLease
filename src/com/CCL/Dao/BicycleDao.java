package com.CCL.Dao;

import java.util.List;

import com.CCL.Dao.base.BaseDaoInterface;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;

/**
 * 用来封装基本的操作数据库方法，继承了BaseDaoInterface<T>
 * @author Jonney
 *
 */
public interface BicycleDao extends BaseDaoInterface<Bicycle>{

	
	List<Bicycle> queryByType(BicycleType bicycleType);

	List<Bicycle> queryByState(BicycleState bicycleState);

}
