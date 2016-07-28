package com.CCL.view.operatormgr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.view.operatormgr.mydao.MyOpeUserDaoImpl;
import com.CCL.view.operatormgr.subframe.UpdateFrame;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class OperatorMgr extends JPanel {
	OpeUserDao opeUserDao = new MyOpeUserDaoImpl();

	private JTextField text_UserName;
	private JPasswordField passwordField;
	private JTextField text_name;
	private JTextField text_phone;
	private JButton btn_cancel;
	private final ButtonGroup sexGroup = new ButtonGroup();
	private JTextArea text_address;
	private JFileChooser chooser;
	private JList<OpeUser> list;
	private JTextField textField;
	private JTextField textUserNum;
	private JTextField textUserName;

	
	
	String photo=null;
	private JButton btn_photo;
	/**
	 * Create the panel.
	 */
	public OperatorMgr() {
		chooser = new JFileChooser();
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u589E\u52A0\u8BB0\u8D26\u5458", null, panel, null);

		JLabel lbl_username = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		lbl_username.setBounds(74, 54, 87, 18);

		text_UserName = new JTextField();
		text_UserName.setBounds(167, 48, 179, 30);
		text_UserName.setColumns(10);
		

		JButton btn_add = new JButton("\u6DFB\u52A0");
		btn_add.setBounds(194, 396, 72, 30);
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "确认", "是否确定添加", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					System.out.println("000");
					return;
				}

				OpeUser newOpeUser = new OpeUser();
				newOpeUser.setUser(text_UserName.getText());
				newOpeUser.setPassword( new String( passwordField.getPassword()));
				newOpeUser.setName(text_name.getText());
				newOpeUser.setPhone(text_phone.getText());
				newOpeUser.setPhoto(btn_photo.getIcon().toString());
				opeUserDao.add(newOpeUser);

			}
		});

		JLabel lbl_password = new JLabel("\u5BC6    \u7801\uFF1A");
		lbl_password.setBounds(74, 111, 62, 18);

		passwordField = new JPasswordField();
		passwordField.setBounds(167, 105, 179, 30);

		JLabel lblNewLabel_1 = new JLabel("\u59D3    \u540D\uFF1A");
		lblNewLabel_1.setBounds(74, 170, 60, 18);

		text_name = new JTextField();
		text_name.setBounds(167, 164, 84, 30);
		text_name.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_2.setBounds(277, 170, 59, 18);

		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(331, 167, 42, 24);
		sexGroup.add(radioButton);
		radioButton.setSelected(true);

		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(385, 167, 53, 24);
		sexGroup.add(radioButton_1);

		JLabel lbl_birthday = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lbl_birthday.setBounds(74, 217, 70, 18);

		JLabel lbl_photo = new JLabel("\u7167   \u7247\uFF1A");
		lbl_photo.setBounds(484, 54, 60, 18);

		JLabel lbl_phone = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lbl_phone.setBounds(74, 264, 70, 18);

		text_phone = new JTextField();
		text_phone.setBounds(167, 258, 165, 30);
		text_phone.setColumns(10);

		btn_photo = new JButton("\u6DFB\u52A0\u7167\u7247");
		btn_photo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

			}
		});
		btn_photo.setBounds(484, 107, 114, 144);
		btn_photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = chooser.showOpenDialog(null);
				if(value==  JFileChooser.APPROVE_OPTION){
					
					File imgFile = chooser.getSelectedFile();
					
					try {
						btn_photo.setIcon(new ImageIcon(imgFile.toURI().toURL()));
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});

		JLabel lbl_address = new JLabel("\u5730    \u5740\uFF1A");
		lbl_address.setBounds(74, 306, 70, 18);

		btn_cancel = new JButton("\u6E05\u7A7A");
		btn_cancel.setBounds(341, 396, 66, 30);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_name.setText("");
				text_UserName.setText("");
				text_phone.setText("");
				text_name.setToolTipText("");
				passwordField.setText("");
				text_address.setText("");

			}
		});

		JComboBox comboBox_month = new JComboBox();
		comboBox_month.setBounds(266, 212, 47, 28);
		comboBox_month.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		JComboBox comboBox_day = new JComboBox();
		comboBox_day.setBounds(341, 212, 47, 28);
		comboBox_day.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		JComboBox comboBox_year = new JComboBox();
		comboBox_year.setBounds(167, 212, 74, 28);
		comboBox_year.setModel(new DefaultComboBoxModel(
				new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990",
						"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
						"2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014",
						"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
		comboBox_year.setSelectedIndex(20);

		JLabel label = new JLabel("\u5E74");
		label.setBounds(248, 217, 18, 18);

		text_address = new JTextArea();
		text_address.setBounds(167, 306, 289, 72);
		text_address.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.add(lbl_username);
		panel.add(lbl_phone);
		panel.add(lblNewLabel_1);
		panel.add(lbl_password);
		panel.add(lbl_birthday);
		panel.add(lbl_address);
		panel.add(passwordField);
		panel.add(text_UserName);
		panel.add(comboBox_year);
		panel.add(label);
		panel.add(text_name);
		panel.add(btn_add);
		panel.add(comboBox_month);
		panel.add(lblNewLabel_2);
		panel.add(radioButton);
		panel.add(radioButton_1);
		panel.add(btn_cancel);
		panel.add(comboBox_day);
		panel.add(btn_photo);
		panel.add(lbl_photo);
		panel.add(text_phone);
		panel.add(text_address);

		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(325, 217, 18, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u65E5");
		label_2.setBounds(393, 217, 18, 18);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u7BA1\u7406\u8BB0\u8D26\u5458", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u8BB0\u8D26\u5458\uFF1A");
		lblNewLabel.setBounds(38, 51, 85, 30);
		panel_1.add(lblNewLabel);

		textField = new JTextField();
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				updateOpeUser();
			}
		});
		textField.setBounds(120, 51, 145, 30);
		panel_1.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 93, 237, 299);
		panel_1.add(scrollPane);

		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				OpeUser selectedUser = list.getSelectedValue();
				if(selectedUser==null){
					text_UserName.setText("当前未选中用户");
					return;
				}
				
				textUserName.setText(selectedUser.getName());
				textUserNum.setText(selectedUser.getUserName());
				
				
			}
		});
		list.setCellRenderer(new MyOpeUserListRenderer());

		updateOpeUser();
		scrollPane.setViewportView(list);

		JButton btnNewButton = new JButton("\u5220\u9664\u8BB0\u8D26\u5458");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpeUser delUser = list.getSelectedValue();
				
				int result = JOptionPane.showConfirmDialog(null, "是否删除操作员："+delUser.getName(), "确认删除", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.OK_OPTION){
					opeUserDao.remove(delUser.getId());
					
					updateOpeUser();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(307, 167, 104, 43);
		panel_1.add(btnNewButton);

		JButton button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OpeUser delUser = list.getSelectedValue();
				if(delUser!=null){
					new UpdateFrame(delUser).setVisible(true);
				}
				
			}
		});
		button.setBounds(307, 255, 104, 43);
		panel_1.add(button);

		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_3.setBounds(463, 215, 55, 18);
		panel_1.add(lblNewLabel_3);

		JLabel label_3 = new JLabel("\u8D26\u53F7");
		label_3.setBounds(463, 260, 55, 18);
		panel_1.add(label_3);

		textUserName = new JTextField();
		textUserName.setBounds(505, 209, 122, 30);
		panel_1.add(textUserName);
		textUserName.setColumns(10);

		textUserNum = new JTextField();
		textUserNum.setBounds(505, 254, 122, 30);
		panel_1.add(textUserNum);
		textUserNum.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u5934\u50CF");
		btnNewButton_1.setBounds(512, 68, 98, 123);
		panel_1.add(btnNewButton_1);

	}

	private void updateOpeUser() {
		List<OpeUser> queryAll = null ;
		String text = textField.getText();
		
		if("".equals(text)){
			 queryAll = opeUserDao.queryAll();
		}else{
//			 queryAll = opeUserDao.q
			List<OpeUser> list1 = opeUserDao.queryByUseLikeAndPage("user_name", text, 100, 0);
			List<OpeUser> list2 = opeUserDao.queryByUseLikeAndPage("name", text, 100, 0);
			queryAll=new ArrayList<OpeUser>();
			
			if(list1!=null)queryAll.addAll(list1);
			
			if(list2!=null){
				queryAll.removeAll(list2);
				queryAll.addAll(list2);
			}
			
			
		}
		
		
		list.setModel(new OpeUserListModel(queryAll));

	}

	class OpeUserListModel extends AbstractListModel<OpeUser> {
		List<OpeUser> lists = null;

		public OpeUserListModel(List<OpeUser> lists) {
			this.lists = lists;
		}

		@Override
		public int getSize() {

			return lists.size();
		}

		@Override
		public OpeUser getElementAt(int index) {

			return lists.get(index);
		}

	}

	class MyOpeUserListRenderer implements ListCellRenderer<OpeUser> {

		@Override
		public Component getListCellRendererComponent(JList list, OpeUser value, int index, boolean isSelected,
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
				background = Color.RED;
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
}
