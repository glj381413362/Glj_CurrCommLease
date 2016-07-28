package com.CCL.view.huiyuan.test;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.CCL.Dao.CustomerDao;
import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;

public class MyCusDao implements CustomerDao {

	@Override
	public List<Customer> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean  remove(int id) {
		// TODO Auto-generated method stub
		return true;

	}

	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public boolean update(Customer customer) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> queryByType(CustomerType customerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryByState(CustomerState customerState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryByExample(Customer instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> queryByUsePage(String property, Object value, int pageSize, int pageNumber) {
		Customer ct = new Customer();
		ct.setName("520");
		ct.setPassword("520");
		ct.setId(1);
		ct.setMoney(40f);
		ct.setPhone("15569693235");
		ct.setSex("男");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		Date d;
		try {
			d = df.parse(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		ct.setBirthday(new Date());
		ct.setAddress("湖南农大");
		ct.setEmail("56565656@qq.com");
		CustomerType ctp =new CustomerType();
		ctp.setName("铂金");
		CustomerState cts = new CustomerState();
		cts.setName("激活");
		ct.setCustomerType(ctp);
		ct.setCustomerState(cts);
		ArrayList<Customer> lists = new ArrayList<Customer>();
		lists.add(ct);
		return lists;
	}

	@Override
	public List<Customer> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
