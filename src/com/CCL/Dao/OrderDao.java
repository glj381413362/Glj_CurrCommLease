package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.Dao.base.BaseDaoInterface;
import com.CCL.beans.Customer;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Order;
import com.CCL.beans.OrderState;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface OrderDao    extends BaseDaoInterface<Order>  {

	
	
	List<Order> queryByState(OrderState bicycleState);
	
	
}
