/*
 * V_regist.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.son;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.CCL.beans.Customer;
import com.CCL.beans.CustomerState;
import com.CCL.beans.CustomerType;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.huiyuan.service.CustomerService;
import com.CCL.view.huiyuan.service.CustomerTypeService;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author  __USER__
 */
public class V_regist extends javax.swing.JPanel {

	//	VipManager parent = null;

	/** Creates new form V_regist 
	 * @param vipManager */
	public V_regist() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				updateTypeList();
			}
		});
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		lbl_name = new java.awt.Label();
		lbl_name.setBounds(115, 43, 80, 23);
		txt_name = new javax.swing.JTextField();
		txt_name.setBounds(199, 43, 159, 21);
		lbl_type = new javax.swing.JLabel();
		lbl_type.setBounds(115, 135, 73, 15);
		jComboBox1 = new javax.swing.JComboBox<CustomerType>();
		jComboBox1.setBounds(267, 132, 91, 21);
		lbl_tel = new javax.swing.JLabel();
		lbl_tel.setBounds(115, 335, 74, 15);
		txt_tel = new javax.swing.JTextField();
		txt_tel.setBounds(199, 332, 128, 21);
		lbl_email = new javax.swing.JLabel();
		lbl_email.setBounds(115, 296, 54, 15);
		txt_email = new javax.swing.JTextField();
		txt_email.setBounds(199, 293, 128, 21);
		lbl_address = new javax.swing.JLabel();
		lbl_address.setBounds(115, 366, 72, 15);
		txt_address = new javax.swing.JTextField();
		txt_address.setBounds(199, 363, 159, 21);
		lbl_birthday = new javax.swing.JLabel();
		lbl_birthday.setBounds(115, 241, 68, 15);
		jbt_save = new javax.swing.JButton();
		jbt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CustomerService.existUsername(txt_name.getText())){
					JOptionPane.showMessageDialog(null, "客户名已经存在,修改客户名！", "提示", JOptionPane.ERROR_MESSAGE);
					
					txt_address.setText(null);
					txt_email.setText(null);
					txt_name.setText(null);
					txt_password.setText(null);
					txt_tel.setText(null);	
					lbl_info.setText(null);
					return ;
				}
				
				Customer ct = new Customer();
				ct.setName(txt_name.getText());
				ct.setPassword(txt_password.getText());
				ct.setAddress(txt_address.getText());
				ct.setCustomerType((CustomerType) jComboBox1.getSelectedItem());
				ct.setEmail(txt_email.getText());
				ct.setPhone(txt_tel.getText());
				ct.setCustomerState(CustomerService.getStateByName("激活"));
				ct.setIntegral(0);
				ct.setMoney(0f);
				if(jc_male.isSelected())
				    ct.setSex(jc_male.getText());
				else if(jc_famale.isSelected())
					ct.setSex(jc_famale.getText());
				String y,m,d;
				
				y=(String)jComboBox2.getSelectedItem();
				m=(String)jComboBox3.getSelectedItem();
				d=(String)jComboBox4.getSelectedItem();
				String sb = new String();
				sb=y+"-"+m+"-"+d;
					
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
					Date date = df.parse(sb);
					ct.setBirthday(date);		
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				ct.setBirthday(new Date());	
				if(CustomerService.add(ct)){
					lbl_info.setText("您好！"+ct.getName()+"客户已成功办理会员卡！"+"会员卡号为："+ct.getId());
				}
				
			}
		});
		jbt_save.setBounds(444, 416, 69, 23);
		jbt_cancle = new javax.swing.JButton();
		jbt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_address.setText(null);
				txt_email.setText(null);
				txt_name.setText(null);
				txt_password.setText(null);
				txt_tel.setText(null);	
				lbl_info.setText(null);
				
			}
			
		});
		jbt_cancle.setBounds(559, 416, 69, 23);
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox2.setBounds(189, 238, 59, 21);
		jComboBox3 = new javax.swing.JComboBox();
		jComboBox3.setBounds(264, 238, 49, 21);
		jComboBox4 = new javax.swing.JComboBox();
		jComboBox4.setBounds(330, 238, 49, 21);
		lbl_sex = new javax.swing.JLabel();
		lbl_sex.setBounds(115, 184, 49, 15);
		jc_male = new JRadioButton();
		sex_group.add(jc_male);
		jc_male.setBounds(189, 180, 50, 23);
		jc_famale = new JRadioButton();
		sex_group.add(jc_famale);
		jc_famale.setBounds(267, 180, 51, 23);
		jc_male.setSelected(true);
		lbl_name.setText("\u5ba2\u6237\u59d3\u540d\uff1a");

		lbl_type.setText("\u5ba2\u6237\u7c7b\u578b\uff1a");

		

		lbl_tel.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");

		lbl_email.setText("EMAIL\uff1a");

		lbl_address.setText("\u8054\u7cfb\u5730\u5740\uff1a");

		lbl_birthday.setText("\u51fa\u751f\u65e5\u671f\uff1a");

		jbt_save.setText("\u4fdd  \u5b58");

		jbt_cancle.setText("\u53d6  \u6d88");

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987",
				"1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995",
				"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
				"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011",
				"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020" }));

		jComboBox3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		lbl_sex.setText("\u6027\u522b\uff1a");

		jc_male.setText("\u7537");

		jc_famale.setText("\u5973");
		setLayout(null);
		add(lbl_name);
		add(txt_name);
		add(lbl_type);
		add(jComboBox1);
		add(lbl_sex);
		add(jc_male);
		add(jc_famale);
		add(lbl_birthday);
		add(jComboBox2);
		add(jComboBox3);
		add(jComboBox4);
		add(lbl_email);
		add(txt_email);
		add(lbl_tel);
		add(txt_tel);
		add(lbl_address);
		add(txt_address);
		add(jbt_save);
		add(jbt_cancle);
		
		JLabel lbl_password = new JLabel("\u5BA2\u6237\u5BC6\u7801\uFF1A");
		lbl_password.setBounds(115, 90, 76, 15);
		add(lbl_password);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(199, 87, 159, 21);
		add(txt_password);
		
		lbl_info = new JLabel("");
		lbl_info.setBorder(new TitledBorder(null, "\u6CE8\u518C\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lbl_info.setBounds(413, 266, 333, 114);
		add(lbl_info);
	}// </editor-fold>
	//GEN-END:initComponents
	

	void updateTypeList(){
		jComboBox1.setModel(new DefaultComboBoxModel(CustomerTypeService.getAllType().toArray()));
	}
	
	
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JComboBox<CustomerType> jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JButton jbt_cancle;
	private javax.swing.JButton jbt_save;
	private JRadioButton jc_famale;
	private JRadioButton jc_male;
	private javax.swing.JLabel lbl_address;
	private javax.swing.JLabel lbl_birthday;
	private javax.swing.JLabel lbl_email;
	private java.awt.Label lbl_name;
	private javax.swing.JLabel lbl_sex;
	private javax.swing.JLabel lbl_tel;
	private javax.swing.JLabel lbl_type;
	private javax.swing.JTextField txt_address;
	private javax.swing.JTextField txt_email;
	private javax.swing.JTextField txt_name;
	private javax.swing.JTextField txt_tel;
	private JPasswordField txt_password;
	private final ButtonGroup sex_group = new ButtonGroup();
	private JLabel lbl_info;
}