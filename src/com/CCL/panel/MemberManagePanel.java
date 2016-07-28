package com.CCL.panel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MemberManagePanel extends JPanel {
	public MemberManagePanel() {
		this.setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
		JTabbedPane jp = new JTabbedPane(); // 设置选项卡在坐标
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel(); // 创建多个容器
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();

		
		p1.setBackground(new Color(10, 20, 6));
		
		p2.setBackground(new Color(120, 20, 6));

		JButton jb = new JButton("123");
		p2.add(jb);

		jp.addTab(p1.getName(), p1);
		jp.addTab("会员卡挂失/补办", p2);
		jp.addTab("会员卡充值", p3);
		jp.addTab("会员升级", p4); // 添加子容器 并且为选项卡添加名字
		jp.addTab("会员卡信息修改", p5);
		jp.addTab("会员消费信息查询", p6);
		this.add(jp, BorderLayout.CENTER); // 将选项卡窗体添加到 主窗体上去
	}

}
