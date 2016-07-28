package com.CCL.view.kaitaimgr.render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.CCL.beans.Bicycle;

public class BicycleListRenderer extends JPanel implements ListCellRenderer<Bicycle> {
	ImageIcon BicycleImage =  new ImageIcon(new ImageIcon("images\\MJBtn\\自行车.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	JLabel txt_kc = new JLabel("",JLabel.CENTER);
	JLabel txt_name = new JLabel("",JLabel.CENTER);
	JLabel txt_price = new JLabel("",JLabel.CENTER);
	JLabel txt_desc = new JLabel("",JLabel.CENTER);
	JPanel msgPanel = new JPanel(new GridLayout(2, 2));

	public BicycleListRenderer() {
		this.setLayout(new BorderLayout());
		add(new JLabel(BicycleImage), BorderLayout.WEST);
		msgPanel.add(txt_kc);
		msgPanel.add(txt_name);
		msgPanel.add(txt_price);
		msgPanel.add(txt_desc);
		add(msgPanel);
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Bicycle value, int index, boolean isSelected,
			boolean cellHasFocus) {

		// removeAll();
		txt_kc.setText("库存: " + value.getInventory());
		txt_name.setText("名称: " + value.getName());
		txt_price.setText("原价: " + value.getPrice() + "\t" + "   折扣价:"
				+ (value.getPrice() * value.getType().getDiscount()));
		txt_desc.setText("介绍: " + value.getDescript());

		Color background;
		Color foreground;

		// check if this cell represents the current DnD drop location
		JList.DropLocation dropLocation = list.getDropLocation();
		if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

			background = Color.RED;
			foreground = Color.WHITE;

			// check if this cell is selected
		} else if (isSelected) {

			background = Color.BLUE;
			foreground = Color.WHITE;

			// unselected, and not the DnD drop location
		} else {
			background = Color.WHITE;
			foreground = Color.BLACK;
		}
		;

		setBackground(background);
		setForeground(foreground);
		txt_kc.setForeground(foreground);
		txt_name.setForeground(foreground);
		txt_price.setForeground(foreground);
		txt_desc.setForeground(foreground);

		txt_kc.setBackground(background);
		txt_name.setBackground(background);
		txt_price.setBackground(background);
		txt_desc.setBackground(background);

		msgPanel.setBackground(background);
		msgPanel.setForeground(foreground);

		return this;

	}

}