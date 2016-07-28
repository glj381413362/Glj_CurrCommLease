package com.CCL.view.huiyuan.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.CCL.beans.Bill;

public class BillTableModel implements TableModel {
	
	List<Bill> billList = new ArrayList<Bill>();
	
	String[] billColumn = new String[]{"编号","客户名","自行车","租赁时长","总金额","押金","操作员"};

	public BillTableModel(List<Bill> billList) {
		this.billList.addAll(billList);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return billList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return billColumn.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return billColumn[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Bill bill = billList.get(rowIndex);
		Object ret=null;
		switch (columnIndex) {
		case 0:
			ret=bill.getId();
			break;
		case 1:
			ret=bill.getCustomerName();
			break;
		case 2:
			ret=bill.getOrder().getBicycles();
			break;
		case 3:
			ret=bill.getDelay();
			break;
		case 4:
			ret=bill.getTotal();
			break;
		case 5:
			ret=bill.getOrder().getDeposit();
			break;
		case 6:
			ret=bill.getOrder().getOpeUser()==null?"":bill.getOrder().getOpeUser().getName();
		
		default:
			break;
		}
		
		return ret;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
