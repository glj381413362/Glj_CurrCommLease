/*
 * V_update.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.son;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.util.DateUtil;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.huiyuan.service.CustomerService;
import com.CCL.view.huiyuan.service.OperUserPerService;
import com.CCL.view.kaitaimgr.subpanel.FindCustomerDialog;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 *
 * @author __USER__
 */
public class V_update extends javax.swing.JPanel {

	Customer currUser = null;
	protected FindCustomerDialog findCustomerDialog = null;

	/** Creates new form V_update */
	public V_update() {

		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		txt_name = new JLabel();
		txt_name.setBounds(116, 23, 131, 21);
		lbl_password = new javax.swing.JLabel();
		lbl_password.setBounds(306, 26, 78, 15);
		txt_userId = new JLabel();
		txt_userId.setBounds(370, 23, 135, 21);
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator1.setBounds(10, 99, 1517, 10);
		jbt_login = new javax.swing.JButton();
		jbt_login.setBounds(343, 66, 96, 23);
		jbt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (findCustomerDialog == null) {
					findCustomerDialog = new FindCustomerDialog() {
						@Override
						public void selectUser(Customer currentUser) {
							txt_name.setText(currentUser.getName());
							txt_userId.setText(currentUser.getId() + "");

							Customer ct = currentUser;
							currUser = ct;
							DefaultListModel model = new DefaultListModel();
							model.addElement("姓名:" + ct.getName());
							model.addElement("性别:" + ct.getSex());
							model.addElement("电话:" + ct.getPhone());
							model.addElement("类型：" + ct.getCustomerType().getName());
							model.addElement("余额:" + ct.getMoney());
							model.addElement("状态:" + ct.getCustomerState().getName());
							model.addElement("积分:" + ct.getIntegral());
							model.addElement("出生日期:" + DateUtil.getDate(ct.getBirthday()));
							model.addElement("地址:" + ct.getAddress());
							model.addElement("EMAIL:" + ct.getEmail());
							list.setModel(model);

							txt_newaddress.setText(ct.getAddress());
							txt_newemail.setText(ct.getEmail());
							txt_newpassword.setText(ct.getPassword());
							txt_newtel.setText(ct.getPhone());

							// JOptionPane.showMessageDialog(null,
							// "客户密码错误或客户不存在！");
							// txt_name.setText("");
							// txt_userId.setText("");
						}

					};
					findCustomerDialog.setModal(true);
				}
				findCustomerDialog.setVisible(true);

			}
		});
		jbt_cancle = new javax.swing.JButton();
		jbt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_name.setText("");
				txt_userId.setText("");
				DefaultListModel model = new DefaultListModel();
				list.setModel(model);
				currUser = null;
			}
		});
		jbt_cancle.setBounds(445, 66, 69, 23);
		lbl_info = new javax.swing.JLabel();
		lbl_info.setBounds(10, 127, 102, 15);
		lbl_newpassword = new javax.swing.JLabel();
		lbl_newpassword.setBounds(76, 167, 131, 15);
		txt_newpassword = new javax.swing.JPasswordField();
		txt_newpassword.setBounds(182, 164, 147, 21);
		lbl_newbirthday = new javax.swing.JLabel();
		lbl_newbirthday.setBounds(76, 281, 96, 15);
		lbl_newemail = new javax.swing.JLabel();
		lbl_newemail.setBounds(76, 320, 60, 15);
		txt_newemail = new javax.swing.JTextField();
		txt_newemail.setBounds(182, 317, 202, 21);
		lbl_newtel = new javax.swing.JLabel();
		lbl_newtel.setBounds(76, 359, 81, 15);
		txt_newtel = new javax.swing.JTextField();
		txt_newtel.setBounds(182, 356, 202, 21);
		lbl_newaddress = new javax.swing.JLabel();
		lbl_newaddress.setBounds(76, 398, 96, 15);
		txt_newaddress = new javax.swing.JTextField();
		txt_newaddress.setBounds(182, 395, 232, 21);
		jbt_newok = new javax.swing.JButton();

		jbt_newok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Customer ct = currUser;
				
				if(ct==null){
					JOptionPane.showMessageDialog(null, "请选择当前用户!");
					return;
				}

				ct.setName(txt_name.getText());
				ct.setAddress(txt_newaddress.getText());
				ct.setPassword(txt_newpassword.getText());
				ct.setEmail(txt_newemail.getText());
				ct.setPhone(txt_newtel.getText());

				if (jrdio_male.isSelected())
					ct.setSex(jrdio_male.getText());
				else if (jrdio_famale.isSelected())
					ct.setSex(jrdio_famale.getText());

				String y, m, d;

				y = (String) c_y.getSelectedItem();
				m = (String) c_m.getSelectedItem();
				d = (String) c_d.getSelectedItem();
				String sb = new String();
				sb = y + "-" + m + "-" + d;

				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					Date date = df.parse(sb);
					ct.setBirthday(date);

				} catch (java.text.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				DefaultListModel model = new DefaultListModel();
				model.addElement("姓名:" + ct.getName());
				model.addElement("性别:" + ct.getSex());
				model.addElement("电话:" + ct.getPhone());
				model.addElement("类型：" + ct.getCustomerType().getName());
				model.addElement("余额:" + ct.getMoney());
				model.addElement("状态:" + ct.getCustomerState().getName());
				model.addElement("积分:" + ct.getIntegral());
				model.addElement("出生日期:" + DateUtil.getDate(ct.getBirthday()));
				model.addElement("地址:" + ct.getAddress());
				model.addElement("EMAIL:" + ct.getEmail());

				list.setModel(model);
				CustomerService.update(ct);

				JOptionPane.showMessageDialog(null, "修改信息完成！！");
			}
		});
		jbt_newok.setBounds(456, 437, 99, 23);
		jButton1 = new javax.swing.JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_newaddress.setText(null);
				txt_newemail.setText(null);
				txt_newpassword.setText(null);
				txt_newtel.setText(null);
				lbl_info.setText(null);
				txt_name.setText("");
				txt_userId.setText("");
				DefaultListModel model = new DefaultListModel();
				list.setModel(model);
			}
		});
		jButton1.setBounds(565, 437, 81, 23);

		lbl_password.setText("\u4F1A\u5458\u7F16\u53F7\uFF1A");

		jbt_login.setText("\u5207\u6362\u7528\u6237");

		jbt_cancle.setText("\u53d6  \u6d88");

		lbl_info.setText("\u4fee\u6539\u4fe1\u606f\u5b57\u6bb5\uff1a");

		lbl_newpassword.setText("\u65b0\u5bc6\u7801\uff1a");

		lbl_newbirthday.setText("\u51fa\u751f\u65e5\u671f\uff1a");

		lbl_newemail.setText("EMAIL\uff1a");

		lbl_newtel.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");

		lbl_newaddress.setText("\u8054\u7cfb\u5730\u5740\uff1a");

		jbt_newok.setText("\u786e\u5b9a\u4fee\u6539");

		jButton1.setText("\u53D6    \u6D88");

		lbl_name = new JLabel("\u4F1A\u5458\u59D3\u540D\uFF1A");
		lbl_name.setBounds(38, 26, 74, 15);
		lbl_name.setHorizontalAlignment(SwingConstants.TRAILING);

		c_y = new JComboBox();
		c_y.setBounds(182, 278, 65, 21);
		c_y.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986",
				"1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

		c_m = new JComboBox();
		c_m.setBounds(250, 278, 38, 21);
		c_m.setModel(
				new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));

		c_d = new JComboBox();
		c_d.setBounds(291, 278, 38, 21);
		c_d.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		lbl_sex = new JLabel("\u6027\u522B\uFF1A");
		lbl_sex.setBounds(76, 221, 60, 15);

		jrdio_male = new JRadioButton("\u7537");

		jrdio_male.setBounds(182, 217, 65, 23);

		jrdio_famale = new JRadioButton("\u5973");
		jrdio_famale.setBounds(255, 217, 50, 23);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrdio_male);
		;
		bg.add(jrdio_famale);
		jrdio_male.setSelected(true);
		setLayout(null);
		add(lbl_name);
		add(txt_name);
		add(lbl_password);
		add(jbt_login);
		add(jbt_cancle);
		add(txt_userId);
		add(lbl_newbirthday);
		add(c_y);
		add(c_m);
		add(c_d);
		add(jrdio_famale);
		add(lbl_newaddress);
		add(lbl_newtel);
		add(txt_newtel);
		add(txt_newemail);
		add(txt_newaddress);
		add(lbl_newemail);
		add(lbl_sex);
		add(lbl_newpassword);
		add(txt_newpassword);
		add(jrdio_male);
		add(jbt_newok);
		add(jButton1);
		add(jSeparator1);
		add(lbl_info);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(456, 167, 190, 213);
		add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
	}// </editor-fold>
		// GEN-END:initComponents

	// GEN-BEGIN:variables
	// Variables declaration - do not modify

	private javax.swing.JButton jButton1;

	public javax.swing.JButton getjButton1() {
		return jButton1;
	}

	public void setjButton1(javax.swing.JButton jButton1) {
		this.jButton1 = jButton1;
	}

	public javax.swing.JSeparator getjSeparator1() {
		return jSeparator1;
	}

	public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
		this.jSeparator1 = jSeparator1;
	}

	public javax.swing.JButton getJbt_cancle() {
		return jbt_cancle;
	}

	public void setJbt_cancle(javax.swing.JButton jbt_cancle) {
		this.jbt_cancle = jbt_cancle;
	}

	public javax.swing.JButton getJbt_login() {
		return jbt_login;
	}

	public void setJbt_login(javax.swing.JButton jbt_login) {
		this.jbt_login = jbt_login;
	}

	public javax.swing.JButton getJbt_newok() {
		return jbt_newok;
	}

	public void setJbt_newok(javax.swing.JButton jbt_newok) {
		this.jbt_newok = jbt_newok;
	}

	public javax.swing.JLabel getLbl_info() {
		return lbl_info;
	}

	public void setLbl_info(javax.swing.JLabel lbl_info) {
		this.lbl_info = lbl_info;
	}

	public javax.swing.JLabel getLbl_newaddress() {
		return lbl_newaddress;
	}

	public void setLbl_newaddress(javax.swing.JLabel lbl_newaddress) {
		this.lbl_newaddress = lbl_newaddress;
	}

	public javax.swing.JLabel getLbl_newbirthday() {
		return lbl_newbirthday;
	}

	public void setLbl_newbirthday(javax.swing.JLabel lbl_newbirthday) {
		this.lbl_newbirthday = lbl_newbirthday;
	}

	public javax.swing.JLabel getLbl_newemail() {
		return lbl_newemail;
	}

	public void setLbl_newemail(javax.swing.JLabel lbl_newemail) {
		this.lbl_newemail = lbl_newemail;
	}

	public javax.swing.JLabel getLbl_newpassword() {
		return lbl_newpassword;
	}

	public void setLbl_newpassword(javax.swing.JLabel lbl_newpassword) {
		this.lbl_newpassword = lbl_newpassword;
	}

	public javax.swing.JLabel getLbl_newtel() {
		return lbl_newtel;
	}

	public void setLbl_newtel(javax.swing.JLabel lbl_newtel) {
		this.lbl_newtel = lbl_newtel;
	}

	public javax.swing.JLabel getLbl_password() {
		return lbl_password;
	}

	public void setLbl_password(javax.swing.JLabel lbl_password) {
		this.lbl_password = lbl_password;
	}

	public javax.swing.JTextField getTxt_newaddress() {
		return txt_newaddress;
	}

	public void setTxt_newaddress(javax.swing.JTextField txt_newaddress) {
		this.txt_newaddress = txt_newaddress;
	}

	public javax.swing.JTextField getTxt_newemail() {
		return txt_newemail;
	}

	public void setTxt_newemail(javax.swing.JTextField txt_newemail) {
		this.txt_newemail = txt_newemail;
	}

	public javax.swing.JPasswordField getTxt_newpassword() {
		return txt_newpassword;
	}

	public void setTxt_newpassword(javax.swing.JPasswordField txt_newpassword) {
		this.txt_newpassword = txt_newpassword;
	}

	public javax.swing.JTextField getTxt_newtel() {
		return txt_newtel;
	}

	public void setTxt_newtel(javax.swing.JTextField txt_newtel) {
		this.txt_newtel = txt_newtel;
	}


	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JButton jbt_cancle;
	private javax.swing.JButton jbt_login;
	private javax.swing.JButton jbt_newok;
	private javax.swing.JLabel lbl_info;
	private javax.swing.JLabel lbl_newaddress;
	private javax.swing.JLabel lbl_newbirthday;
	private javax.swing.JLabel lbl_newemail;
	private javax.swing.JLabel lbl_newpassword;
	private javax.swing.JLabel lbl_newtel;
	private javax.swing.JLabel lbl_password;
	private javax.swing.JTextField txt_newaddress;
	private javax.swing.JTextField txt_newemail;
	private javax.swing.JPasswordField txt_newpassword;
	private javax.swing.JTextField txt_newtel;
	private JLabel txt_userId;
	private JLabel txt_name;
	private JLabel lbl_name;
	private JLabel lbl_sex;
	private JScrollPane scrollPane;
	private JList list;
	private JRadioButton jrdio_male;
	private JRadioButton jrdio_famale;
	private JComboBox c_y;
	private JComboBox c_m;
	private JComboBox c_d;
}