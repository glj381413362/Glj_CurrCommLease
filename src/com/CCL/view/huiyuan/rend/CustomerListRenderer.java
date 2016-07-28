package com.CCL.view.huiyuan.rend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.CCL.beans.Customer;
public class CustomerListRenderer implements ListCellRenderer<Customer>{

	@Override
	public Component getListCellRendererComponent(JList list, Customer value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		JPanel jPanel = new JPanel(new BorderLayout());
		jPanel.add(new JLabel(new ImageIcon("images\\MJBtn\\man.png")),BorderLayout.WEST);
		jPanel.add(new JLabel(value.getName()));

		Color background;
		Color foreground;

		// check if this cell represents the current DnD drop location
		JList.DropLocation dropLocation = list.getDropLocation();
		if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

			background = Color.BLUE;
			foreground = Color.WHITE;

			// check if this cell is selected
		} else if (isSelected) {
			background = Color.gray;
			foreground = Color.WHITE;

			// unselected, and not the DnD drop location
		} else {
			background = Color.WHITE;
			foreground = Color.BLACK;
		}
		;

		jPanel.setBackground(background);
		jPanel.setForeground(foreground);
		
		
		
		return jPanel;
	}
}