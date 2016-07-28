package com.CCL.panel.glj.xitongguanli.son;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import com.CCL.mwing.glj.MButton;
import com.CCL.panel.MPanel;
import com.CCL.view.LoginView;
import com.CCL.view.MainFrame;

public class MenuPanel extends MPanel {

	private MainFrame mainFrame;
	private MButton btn_zhuxiao, btn_help, btn_about, btn_exitFrame,
			btn_fanhui;

	public MenuPanel(String imgUrl, MainFrame mainFrame) {
		super(imgUrl);
		this.mainFrame = mainFrame;
		this.setOpaque(false);
		this.setBounds(779, 7, 240, 40);
		this.setLayout(null);
		init();
		this.setVisible(false);
	}

	private void init() {

		btn_zhuxiao = new MButton("", "注销", 0, 5, 35, 30);
		btn_help = new MButton("", "帮助", 40, 5, 35, 30);
		btn_about = new MButton("", "关于", 80, 5, 35, 30);
		btn_exitFrame = new MButton("", "退出系统", 120, 5, 65, 30);
		btn_fanhui = new MButton("images/glj/ButtonImages/arraw_right1.png",
				"", 181, 5, 65, 30);
		
		btn_fanhui.setSelectedIcon(new ImageIcon(
				"images/glj/ButtonImages/arraw_right1.png"));
		btn_fanhui.setRolloverIcon(new ImageIcon(
				"images/glj/ButtonImages/arraw_right2.png"));
		btn_fanhui.setPressedIcon(new ImageIcon(
				"images/glj/ButtonImages/arraw_right1.png"));

		btn_zhuxiao.setActionCommand("注销");
		btn_zhuxiao.addActionListener(new ActionListener_btn(mainFrame));
		btn_help.setActionCommand("帮助");
		btn_help.addActionListener(new ActionListener_btn(mainFrame));
		btn_about.setActionCommand("关于");
		btn_about.addActionListener(new ActionListener_btn(mainFrame));
		btn_exitFrame.setActionCommand("退出系统");
		btn_exitFrame.addActionListener(new ActionListener_btn(mainFrame));
		btn_fanhui.setActionCommand("返回");
		btn_fanhui.addActionListener(new ActionListener_btn(mainFrame));

		this.add(btn_zhuxiao);
		this.add(btn_help);
		this.add(btn_about);
		this.add(btn_exitFrame);
		this.add(btn_fanhui);

	}

	class ActionListener_btn implements ActionListener {
		private MainFrame mainFrame;

		public ActionListener_btn(MainFrame mainFrame) {

			this.mainFrame = mainFrame;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();

			if (command.equals("注销")) {

				if(mainFrame.getFrame()!=null)
				{
					mainFrame.getFrame().dispose();
				}
				mainFrame.dispose();
				new LoginView().setVisible(true);
			} else if (command.equals("帮助")) {

			} else if (command.equals("关于")) {

			}else if (command.equals("退出系统")) {
				if(mainFrame.getFrame()!=null)
				{
					mainFrame.getFrame().dispose();
				}
				mainFrame.dispose();
			} else if (command.equals("返回")) {
//				mainFrame.getBtn_help().setBounds(181, 5, 65, 30);
				mainFrame.getMenuPanel().setVisible(false);
				mainFrame.getBtn_help().setVisible(true);
			}

		}

	}

	public MButton getBtn_fanhui() {
		return btn_fanhui;
	}

	public void setBtn_fanhui(MButton btn_fanhui) {
		this.btn_fanhui = btn_fanhui;
	}

}
