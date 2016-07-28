package com.CCL.Dao.impl;


import javax.swing.JFrame;

import com.CCL.panel.glj.xitongguanli.son.ShouFeiSet;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet_Add;



public class TestFrame extends JFrame {

	public TestFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestFrame testFramenew = new TestFrame();
		testFramenew.setBounds(100, 130,  403, 385);
//		testFramenew.setContentPane(new ZheKouSet("images/glj/shoufei/72.jpg"));
//		testFramenew.setContentPane(new ZheKouSet_Add(new ZheKouSet("")));
	}

}
