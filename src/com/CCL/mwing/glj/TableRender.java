package com.CCL.mwing.glj;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.hibernate.mapping.Table;

public class TableRender extends JLabel implements TableCellRenderer{

	public TableRender()
	{
		super();
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		Vector<String> n = new Vector<String>();
		Vector<Object> p = new Vector<Object>();
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();
		p.add("时长");
		p.add("数量");
		p.add("消费");
		tableValueV.add(p);
		JTable value_table = new JTable(new DefaultTableModel(tableValueV,p) );
		value_table.setRowHeight(22);
		
		value_table.getColumnModel().getColumn(1).setPreferredWidth(80);
		return value_table;
	}
	

}
