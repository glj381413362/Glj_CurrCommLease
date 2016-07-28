package com.CCL.view.huiyuan.son;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.CCL.beans.CustomerType;
import com.CCL.view.huiyuan.service.CustomerTypeService;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class V_typemanager extends JPanel {
	private JTextField txt_type;
	private JList<CustomerType> list;
	private JLabel lbl_resultinfo;

	/**
	 * Create the panel.
	 */
	public V_typemanager() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				txt_type.setText(null);
				lbl_resultinfo.setText(null);
				
				
			}
		});
		
		
		JLabel lbl_type = new JLabel("\u5BA2\u6237\u7C7B\u522B\uFF1A");
		
		txt_type = new JTextField();
		txt_type.setColumns(10);
		
		JLabel lbl_oldtype = new JLabel("\u539F\u6709\u7C7B\u522B\uFF1A");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton jbt_add = new JButton("\u6DFB  \u52A0");
		jbt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newtype = txt_type.getText();
				
				CustomerType newcustomerType = new CustomerType();
				newcustomerType.setName(newtype);
				
				CustomerTypeService.add(newcustomerType);
				
				lbl_resultinfo.setText("成功添加客户类型！");
				
				updateTypeList();
				
				
			}
		});
		
		JButton jbt_remove = new JButton("\u79FB  \u9664");
		jbt_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerType selectedValue = list.getSelectedValue();
				
				if(CustomerTypeService.delete(selectedValue)){
					lbl_resultinfo.setText("成功移除客户类型！");
					updateTypeList();
				}else{
					JOptionPane.showMessageDialog(null, "移除失败，此项已在数据中形成关系！", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				

			}
		});
		
		lbl_resultinfo = new JLabel("");
		lbl_resultinfo.setFont(new Font("宋体", Font.PLAIN, 16));
		lbl_resultinfo.setBorder(new TitledBorder(null, "\u64CD\u4F5C\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_oldtype)
								.addComponent(lbl_type)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(txt_type, 114, 114, 114)
							.addGap(44)
							.addComponent(jbt_add))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(jbt_remove)
							.addGap(91)
							.addComponent(lbl_resultinfo, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lbl_type)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbt_add))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lbl_oldtype)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbl_resultinfo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbt_remove))))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		
		list = new JList();
		updateTypeList();
		scrollPane.setViewportView(list);
		setLayout(groupLayout);

	}
	
	void updateTypeList(){
		
		list.setModel(new TypeListModel());
	}
	
	
	class TypeListModel extends AbstractListModel{

		List<CustomerType> types  =null;
		public TypeListModel() {
			types=CustomerTypeService.getAllType();
		}
		
		@Override
		public int getSize() {
			return types.size();
		}

		@Override
		public Object getElementAt(int index) {
			return types.get(index);
		}}
	
}
