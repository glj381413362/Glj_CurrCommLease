package com.CCL.view.huiyuan.model;

import java.util.List;

import javax.swing.AbstractListModel;

import com.CCL.beans.Customer;
public class CustomerListModel extends AbstractListModel<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Customer> users = null;
	

	public CustomerListModel(List<Customer> query) {
		users=query;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public Customer getElementAt(int index) {
		// TODO Auto-generated method stub
		return users.get(index);
	}

}