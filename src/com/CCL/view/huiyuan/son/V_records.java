package com.CCL.view.huiyuan.son;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.CCL.beans.Bill;
import com.CCL.beans.Customer;
import com.CCL.view.huiyuan.model.BillTableModel;
import com.CCL.view.huiyuan.model.CustomerListModel;
import com.CCL.view.huiyuan.rend.CustomerListRenderer;
import com.CCL.view.huiyuan.service.CustomerService;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class V_records extends JPanel {
	private JTextField txt_name;
	List<Bill> billList=null;
	private JList<Customer> userList;
	private JTable tableBill;

	/**
	 * Create the panel.
	 */
	public V_records() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

				List<Customer> users = CustomerService.queryUserByKeyWord(txt_name.getText());
				
				userList.setModel(new CustomerListModel(users) );
			}
		});
		setLayout(null);
		
		JLabel lbl_title = new JLabel("\u5BA2\u6237\u6D88\u8D39\u8BB0\u5F55");
		lbl_title.setBounds(26, 21, 103, 15);
		add(lbl_title);
		
		JLabel lbl_naem = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		lbl_naem.setBounds(50, 62, 79, 15);
		add(lbl_naem);
		
		txt_name = new JTextField();
		txt_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String text = txt_name.getText();
				
				List<Customer> users = CustomerService.queryUserByKeyWord(text);
				
				userList.setModel(new CustomerListModel(users) );
			}
		});
		txt_name.setBounds(121, 59, 148, 21);
		add(txt_name);
		txt_name.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 87, 828, 2);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 114, 169, 311);
		add(scrollPane);
		
		userList = new JList<Customer>();
		userList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				Customer ct = userList.getSelectedValue();
				if(ct!=null){
					billList =CustomerService.queryUserByCustomer(ct);
					
					tableBill.setModel(new BillTableModel(billList));		
				}
					
			}
		});
		
		userList.setCellRenderer(new CustomerListRenderer());
		scrollPane.setViewportView(userList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(243, 115, 595, 311);
		add(scrollPane_1);
		
			tableBill=new JTable();
			scrollPane_1.setViewportView(tableBill);
		

	}
}
