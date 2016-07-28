package com.CCL.view.other.son;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javassist.bytecode.analysis.Util;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class SMS_alerts extends JPanel {
	private JTextField txt_name;
	private JTextField txt_password;
	private JTextField txt_time;
	private JCheckBox cb_isEnableSms;
	public SMS_alerts() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				txt_name.setText(Util_pro.readData("id"));
				txt_password.setText(Util_pro.readData("key"));
				txt_time.setText(Util_pro.readData("time"));
				cb_isEnableSms.setSelected("true".equals(Util_pro.readData("sms.enable")));
			}
		});
		setLayout(null);
		
		JLabel lbl_message = new JLabel("\u77ED\u4FE1\u914D\u7F6E\uFF1A");
		lbl_message.setBounds(59, 33, 79, 15);
		add(lbl_message);
		
		JLabel lbl_fromname = new JLabel("\u53D1\u9001\u65B9\u7528\u6237\u540D\uFF1A");
		lbl_fromname.setBounds(111, 129, 95, 15);
		add(lbl_fromname);
		
		JLabel lbl_password = new JLabel("\u5BC6    \u94A5\uFF1A");
		lbl_password.setBounds(111, 166, 95, 15);
		add(lbl_password);
		
		txt_name = new JTextField();
		txt_name.setBounds(251, 125, 125, 21);
		add(txt_name);
		txt_name.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBounds(251, 162, 125, 21);
		add(txt_password);
		txt_password.setColumns(10);
		
		JButton jbt_save = new JButton("\u4FDD    \u5B58");
		jbt_save.setBounds(163, 281, 93, 23);
		jbt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Util_pro.writeData("id", txt_name.getText());
					Util_pro.writeData("key", txt_password.getText());
					Util_pro.writeData("time", txt_time.getText());
					Util_pro.writeData("sms.enable", cb_isEnableSms.isSelected()+"");
					
					JOptionPane.showMessageDialog(null, "短信提醒配置成功！");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add(jbt_save);
		
		JLabel lbl_time = new JLabel("\u901A\u77E5\u65F6\u95F4\uFF1A");
		lbl_time.setBounds(111, 214, 68, 15);
		add(lbl_time);
		
		txt_time = new JTextField();
		txt_time.setBounds(251, 210, 79, 21);
		add(txt_time);
		txt_time.setColumns(10);
		
		cb_isEnableSms = new JCheckBox("");
		cb_isEnableSms.setBounds(251, 79, 30, 30);
		add(cb_isEnableSms);
		
		JLabel label = new JLabel("\u662F\u5426\u542F\u52A8\u77ED\u4FE1\u901A\u77E5\uFF1A");
		label.setBounds(111, 87, 108, 15);
		add(label);
	}
}
