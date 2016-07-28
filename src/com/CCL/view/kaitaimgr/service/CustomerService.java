package com.CCL.view.kaitaimgr.service;

import java.util.ArrayList;
import java.util.List;

import com.CCL.Dao.CustomerDao;
import com.CCL.Dao.impl.CustomerDaoImpl;
import com.CCL.beans.Customer;

public class CustomerService {

	static CustomerDao customerDao = new CustomerDaoImpl();

	public static List<Customer> getAll() {

		return customerDao.queryAll();
	}

	public static List<Customer> getAllUseLike(String text) {
		List<Customer> likes = new ArrayList<Customer>();

		List<Customer> list_id = customerDao.queryByUseLikeAndPage("id", text, 20, 0);
		List<Customer> list_name = customerDao.queryByUseLikeAndPage("name", text, 20, 0);

		likes.addAll(list_id);
		likes.removeAll(list_name);
		likes.addAll(list_name);

		return likes;
	}
}
