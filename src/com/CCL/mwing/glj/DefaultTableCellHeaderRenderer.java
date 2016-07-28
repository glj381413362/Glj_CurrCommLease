package com.CCL.mwing.glj;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class DefaultTableCellHeaderRenderer extends DefaultTableCellRenderer
		implements UIResource {
	private boolean horizontalTextPositionSet;

	public DefaultTableCellHeaderRenderer() {
		super();
		setHorizontalAlignment(JLabel.CENTER);
	}

	public void setHorizontalTextPosition(int textPosition) {
		horizontalTextPositionSet = true;
		super.setHorizontalTextPosition(textPosition);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Vector<String> n = new Vector<String>();
		Vector<Object> tablehead = new Vector<Object>();
		Vector<Object> rowvalue1 = new Vector<Object>();
		Vector<Object> rowvalue2 = new Vector<Object>();
		Vector<Vector<Object>> tableValueV = new Vector<Vector<Object>>();
		
		if(column==0)
		{
			rowvalue1.add("单人车");
		}else if(column==1){
			rowvalue1.add("双人车");
		}else if(column==2){
			rowvalue1.add("四人车");
		}
		rowvalue2.add("");
		rowvalue2.add("");
		rowvalue2.add("");
		tablehead=rowvalue1;
		tableValueV.add(rowvalue1);
		tableValueV.add(rowvalue2);
		JTable value_table = new JTable(new DefaultTableModel(tableValueV,tablehead) )
		{

			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				// TODO Auto-generated method stub
				if(row==1&&column==0)
				{
					TableRender tableRender = new TableRender();
					tableRender.setHorizontalAlignment(JLabel.CENTER);
//					tableRender.setPreferredSize(55);
					return tableRender;
				}
				else
				return super.getCellRenderer(row, column);
			}
			
		};
		value_table.setRowHeight(20);
		
		return value_table;
	}
}