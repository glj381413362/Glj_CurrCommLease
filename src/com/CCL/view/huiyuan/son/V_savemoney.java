/*
 * V_savemoney.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.view.huiyuan.son;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.CCL.beans.Customer;
import com.CCL.util.DateUtil;
import com.CCL.view.huiyuan.service.CustomerService;
import com.CCL.view.kaitaimgr.subpanel.FindCustomerDialog;

/**
 *
 * @author __USER__
 */
public class V_savemoney extends javax.swing.JPanel {

	protected FindCustomerDialog findCustomerDialog =null;
	/** Creates new form V_savemoney */
	public V_savemoney() {
		setLayout(null);
		initComponents();
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JButton getJbt_cancle() {
		return jbt_cancle;
	}

	public void setJbt_cancle(javax.swing.JButton jbt_cancle) {
		this.jbt_cancle = jbt_cancle;
	}

	public javax.swing.JButton getJbt_sava() {
		return jbt_sava;
	}

	public void setJbt_sava(javax.swing.JButton jbt_sava) {
		this.jbt_sava = jbt_sava;
	}

	public javax.swing.JList getJlist_info() {
		return jlist_info;
	}

	public void setJlist_info(javax.swing.JList jlist_info) {
		this.jlist_info = jlist_info;
	}

	public javax.swing.JLabel getLbl_info() {
		return lbl_info;
	}

	public void setLbl_info(javax.swing.JLabel lbl_info) {
		this.lbl_info = lbl_info;
	}

	public javax.swing.JLabel getLbl_money() {
		return lbl_money;
	}

	public void setLbl_money(javax.swing.JLabel lbl_money) {
		this.lbl_money = lbl_money;
	}



	public javax.swing.JLabel getLbl_succese() {
		return lbl_succese;
	}

	public void setLbl_succese(javax.swing.JLabel lbl_succese) {
		this.lbl_succese = lbl_succese;
	}

	public javax.swing.JLabel getLbl_yuan() {
		return lbl_yuan;
	}

	public void setLbl_yuan(javax.swing.JLabel lbl_yuan) {
		this.lbl_yuan = lbl_yuan;
	}

	public javax.swing.JTextField getTxt_money() {
		return txt_money;
	}

	public void setTxt_money(javax.swing.JTextField txt_money) {
		this.txt_money = txt_money;
	}


	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(82, 148, 187, 203);
		lbl_info = new javax.swing.JLabel();
		lbl_info.setBounds(82, 111, 75, 15);
		lbl_money = new javax.swing.JLabel();
		lbl_money.setBounds(329, 111, 68, 15);
		txt_money = new javax.swing.JTextField();
		txt_money.setBounds(407, 108, 93, 21);
		lbl_yuan = new javax.swing.JLabel();
		lbl_yuan.setBounds(510, 111, 18, 15);
		jbt_sava = new javax.swing.JButton();
		
		jbt_sava.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				float money = Integer.parseInt(txt_money.getText());
				String name = txt_userId.getText();
				if("".equals(name)){
					JOptionPane.showMessageDialog(null, "请选择用户!");
					txt_name.setText("");
					txt_userId.setText("");
					return;
				}
				Customer ct = CustomerService.query(name);
				ct.setMoney(money);
				CustomerService.update(ct);
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
				lbl_succese.setText("你好！"+ct.getName()+"客户成功充值："+ct.getMoney()+"元");
				
				jlist_info.setModel(model);
			}
		});
		jbt_sava.setBounds(329, 315, 69, 23);
		jbt_cancle = new javax.swing.JButton();
		jbt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_name.setText(null);
				txt_userId.setText(null);
				txt_money.setText(null);
				DefaultListModel model = new DefaultListModel();
				jlist_info.setModel(model);
				
			}
			
		});
		jbt_cancle.setBounds(475, 315, 69, 23);
		lbl_succese = new javax.swing.JLabel();
		lbl_succese
				.setBorder(new TitledBorder(null, "\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lbl_succese.setBounds(329, 176, 236, 92);

		lbl_info.setText("\u4f1a\u5458\u4fe1\u606f\uff1a");

		lbl_money.setText("\u5145\u503c\u91d1\u989d\uff1a");

		lbl_yuan.setText(" \u5143");

		jbt_sava.setText("\u5145  \u503c");

		jbt_cancle.setText("\u53d6  \u6d88");
		setLayout(null);
		setLayout(null);
		add(jScrollPane1);
		jlist_info = new javax.swing.JList();
		jScrollPane1.setViewportView(jlist_info);
		add(lbl_info);
		add(lbl_money);
		add(txt_money);
		add(lbl_yuan);
		add(jbt_sava);
		add(jbt_cancle);
		add(lbl_succese);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "\u5F53\u524D\u9009\u62E9\u7684\u7528\u6237", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
		panel.setBounds(31, 20, 552, 84);
		add(panel);
		
		label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setBounds(10, 28, 80, 15);
		panel.add(label);
		
		txt_name = new JLabel();
		txt_name.setBounds(87, 25, 143, 18);
		panel.add(txt_name);
		
		label_2 = new JLabel();
		label_2.setText("\u4F1A\u5458ID\uFF1A");
		label_2.setBounds(270, 28, 60, 15);
		panel.add(label_2);
		
		txt_userId = new JLabel();
		txt_userId.setBounds(340, 25, 167, 21);
		panel.add(txt_userId);
		
		button = new JButton("\u9009\u62E9\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (findCustomerDialog == null) {
					findCustomerDialog = new FindCustomerDialog() {
						@Override
						public void selectUser(Customer currentUser) {
							txt_name.setText(currentUser.getName());
							txt_userId.setText(currentUser.getId() + "");
							
							
							Customer ct = currentUser;
							DefaultListModel model = new DefaultListModel();
							if (ct == null) {
								model.addElement("客户不存在！！！");
							} else {
								{
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
								}
							}
							jlist_info.setModel(model);
						}

					};
					findCustomerDialog.setModal(true);
				}
				findCustomerDialog.setVisible(true);
			}
		});
		button.setBounds(449, 51, 93, 23);
		panel.add(button);
	}// </editor-fold>

	// GEN-END:initComponents

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jbt_cancle;
	private javax.swing.JButton jbt_sava;
	private javax.swing.JList jlist_info;
	private javax.swing.JLabel lbl_info;
	private javax.swing.JLabel lbl_money;
	private javax.swing.JLabel lbl_succese;
	private javax.swing.JLabel lbl_yuan;
	private javax.swing.JTextField txt_money;
	private JPanel panel;
	private JLabel label;
	private JLabel txt_name;
	private JLabel label_2;
	private JLabel txt_userId;
	private JButton button;
}