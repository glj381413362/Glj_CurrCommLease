package com.CCL.Dao;

import java.util.List;
import java.util.Map;

import com.CCL.Dao.base.BaseDaoInterface;
import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

//用来封装基本的操作数据库方法，继承了BaseDao
public interface CustomerDao  extends BaseDaoInterface<Customer> {

	
	List<Customer> queryByState(CustomerState customerState);
	
	List<Customer> queryByType(CustomerType customerType) ;
	
}
