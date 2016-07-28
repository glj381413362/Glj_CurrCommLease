package com.CCL.view.operatormgr.subframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.CCL.beans.OpeUser;
import com.CCL.view.operatormgr.service.OpeUserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

	private JPanel contentPane;
	
	OpeUser updateOpeUser = null;
	private JLabel lblUserName;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				if(updateOpeUser==null) return;
				
				lblUserName.setText(updateOpeUser.getName());
				textPassword.setText(updateOpeUser.getPassword());
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setBounds(117, 233, 98, 40);
		contentPane.add(lblNewLabel);
		
		textPassword = new JTextField();
		textPassword.setBounds(225, 237, 200, 33);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("\u66F4\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateOpeUser==null) return;
				updateOpeUser.setPassword(textPassword.getText());
				if(OpeUserService.update(updateOpeUser)==true){
					JOptionPane.showMessageDialog(null, "用户修改成功");
				}
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(178, 366, 117, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(442, 365, 122, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237");
		lblNewLabel_1.setBounds(117, 154, 103, 53);
		contentPane.add(lblNewLabel_1);
		
		lblUserName = new JLabel("{\u3002\u3002\u3002}");
		lblUserName.setBounds(242, 148, 131, 65);
		contentPane.add(lblUserName);
		
		JLabel label = new JLabel("\u66F4\u65B0\u7528\u6237\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 26));
		label.setBounds(117, 43, 411, 72);
		contentPane.add(label);
	}

	public UpdateFrame(OpeUser delUser) {
		this();
		updateOpeUser = delUser;
	}
}
