package com.CCL.mwing.glj;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

	public class ComboboxRender extends JComboBox implements TableCellRenderer {
		public ComboboxRender(String[] items) {
		super(items);
		}

		public ComboboxRender getTableCellRendererComponent(JTable table, Object value,
		boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			this.
		setForeground(table.getSelectionForeground());
		super.setBackground(table.getSelectionBackground());
		} else {
		setForeground(table.getForeground());
		setBackground(table.getBackground());
		}

		// Select the current value
		setSelectedItem(value);
		return this;
		}
		}
