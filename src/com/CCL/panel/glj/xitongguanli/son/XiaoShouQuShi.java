/*
 * XiaoShouQuShi.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.panel.glj.xitongguanli.son;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;

import com.CCL.beans.OpeUser;
import com.CCL.panel.BarChart;
import com.CCL.panel.glj.BarChart_jidu;
import com.CCL.panel.glj.PieChart;
import com.CCL.panel.glj.TimeSeriesChart;
import com.CCL.service.glj.MingXiSelectService;
import com.CCL.service.glj.XiaoShouQuShiService;
import com.CCL.util.glj.DateUtil;

/**
 *
 * @author  __USER__
 */
public class XiaoShouQuShi extends javax.swing.JPanel {
	private javax.swing.JButton btn_exit;
	private javax.swing.JButton btn_save;
	private javax.swing.JButton btn_select;
	private JComboBox<OpeUser> cmb_OpeUser;
	private JComboBox<OpeUser> cmb_tutype;
	private javax.swing.JLabel lbl_etime;
	private javax.swing.JLabel lbl_stime;
	private javax.swing.JPanel panel_radio;
	private javax.swing.JRadioButton rad_all;
	private javax.swing.JRadioButton rad_huiyuan;
	private javax.swing.JRadioButton rad_xianjing;
	private static JTextField txt_etime;
	private static JTextField txt_stime;

	private JPanel panel_show;

	private JPanel sellpanel;
	public XiaoShouQuShi(String string, JPanel sellpanel) {
		this.sellpanel = sellpanel;
		this.setBounds(0, 0, 920, 520);
		initComponents();
		this.setVisible(true);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		lbl_stime = new javax.swing.JLabel();
		txt_etime = new javax.swing.JTextField();
		String now = DateUtil.formatDate1(new Date());
		txt_etime.setText(now);
		txt_etime.setEnabled(false);
		lbl_etime = new javax.swing.JLabel();
		txt_stime = new javax.swing.JTextField();
		txt_stime.setText(now);
		txt_stime.setEnabled(false);
		btn_select = new javax.swing.JButton();
		btn_select.setActionCommand("查询统计");
		btn_select.addActionListener(new ActionListener_btn(this));
		btn_save = new javax.swing.JButton();
		btn_save.setActionCommand("保存");
		btn_save.addActionListener(new ActionListener_btn(this));
		btn_exit = new javax.swing.JButton();
		btn_exit.setActionCommand("退出");
		btn_exit.addActionListener(new ActionListener_btn(this));
		panel_radio = new javax.swing.JPanel();
		panel_radio.setBorder(BorderFactory.createTitledBorder("支付方式"));
		rad_all = new javax.swing.JRadioButton();
		rad_xianjing = new javax.swing.JRadioButton();
		rad_huiyuan = new javax.swing.JRadioButton();
		cmb_OpeUser = getCmb_OpeUser();
		cmb_tutype = new javax.swing.JComboBox();
		panel_show = new javax.swing.JPanel();

		
		//分组，让其只能单选
		ButtonGroup grp = new ButtonGroup();
		grp.add(rad_all);
		grp.add(rad_huiyuan);
		grp.add(rad_xianjing);
		rad_all.setSelected(true);
		
		setLayout(null);

		lbl_stime.setText("\u8d77\u59cb");
		add(lbl_stime);
		lbl_stime.setBounds(20, 10, 30, 20);

		txt_etime
				.setToolTipText("\u53ef\u4ece\u53f3\u4fa7\u65e5\u5386\u53f3\u51fb\u9009\u62e9\u65f6\u95f4");
		add(txt_etime);
		txt_etime.setBounds(200, 10, 110, 23);

		lbl_etime.setText("\u622a\u81f3");
		add(lbl_etime);
		lbl_etime.setBounds(170, 10, 24, 20);

		txt_stime
				.setToolTipText("\u53ef\u4ece\u53f3\u4fa7\u65e5\u5386\u53f3\u51fb\u9009\u62e9\u65f6\u95f4");
		add(txt_stime);
		txt_stime.setBounds(50, 10, 110, 23);

		btn_select.setText("\u67e5\u8be2\u7edf\u8ba1");
		add(btn_select);
		btn_select.setBounds(330, 10, 81, 25);

		btn_save.setText("\u4fdd\u5b58");
		btn_save.setToolTipText("\u4fdd\u5b58\u4e3abmp\u6587\u4ef6");
		add(btn_save);
		btn_save.setBounds(430, 10, 57, 25);

		btn_exit.setText("\u9000\u51fa");
		add(btn_exit);
		btn_exit.setBounds(510, 10, 57, 25);

		panel_radio.setLayout(null);

		rad_all.setText("\u6240\u6709");
		panel_radio.add(rad_all);
		rad_all.setBounds(20, 20, 70, 25);

		rad_xianjing.setText("\u73b0\u91d1\u652f\u4ed8");
		panel_radio.add(rad_xianjing);
		rad_xianjing.setBounds(20, 60, 80, 25);

		rad_huiyuan.setText("\u4f1a\u5458\u5361");
		panel_radio.add(rad_huiyuan);
		rad_huiyuan.setBounds(20, 100, 70, 25);

		add(panel_radio);
		panel_radio.setBounds(680, 60, 120, 150);

		cmb_OpeUser.setBounds(680, 230, 118, 23);
		this.add(cmb_OpeUser);
		
		cmb_tutype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"自行车季度柱形图", "自行车柱形图", "自行车饼状图", "自行车折线图" }));
		cmb_tutype.setSelectedIndex(0);
		add(cmb_tutype);
		cmb_tutype.setBounds(680, 290, 118, 23);

		panel_show.setLayout(null);
		
		ChartPanel ChartPanel = new BarChart_jidu("所有","所有","1012-1-1","3017-1-1").getChartPanel();
		ChartPanel.setBounds(0, 0, 650, 400);
		panel_show.add(ChartPanel);
		add(panel_show);
		panel_show.setBounds(10, 50, 650, 400);
	}// </editor-fold>
	//GEN-END:initComponents

	/**  
	 *  
	 * @Description:查询数据库，将所有操作员加入cmb_OpeUser 
	 * @param null 
	 * @return  cmb_OpeUser
	 * @ReturnType JComboBox
	 *  @author:  龚梁钧
	 *@Created 2016-06-13 23：03
	 */
	private JComboBox<OpeUser> getCmb_OpeUser() {
		List<OpeUser> c_opeUser_list = MingXiSelectService.getAllOpeUser();
		cmb_OpeUser = new JComboBox<OpeUser>();
		OpeUser opeUser = new OpeUser();
		opeUser.setId(0);
		opeUser.setUser("所有");
		cmb_OpeUser.addItem(opeUser);
		for (OpeUser c_opeUser : c_opeUser_list) {
			if (c_opeUser instanceof OpeUser) {
				cmb_OpeUser.addItem(c_opeUser);
			}
		}
		return cmb_OpeUser;
	}
	/**
	 * @Discribe 判断单选框是否选中，并返回
	 * @return name
	 * @returnType String
	 * @param 
	 * @author 龚梁钧
	 *
	 */
	public String getRadioButtonName()
	{
		String result = "";
		if(rad_huiyuan.isSelected())
		{
			result = "余额支付"; 
		}else if(rad_xianjing.isSelected())
		{
			result = "现金支付"; 
		}else if(rad_all.isSelected())
		{
			result = "所有"; 
		}
		
		return result;
	}
	
	class ActionListener_btn implements ActionListener{

		private XiaoShouQuShi xiaoShouQuShi;
		public ActionListener_btn(XiaoShouQuShi xiaoShouQuShi) {

			this.xiaoShouQuShi = xiaoShouQuShi;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			if (command.equals("查询统计"))
			{
				String stime = txt_stime.getText();
				String etime = txt_etime.getText();
				String tutype1 = cmb_tutype.getSelectedItem().toString();
				String splstr_tiaojian1 = cmb_OpeUser.getSelectedItem().toString();//获得下拉列表框的值
				String splstr_tiaojian2 = getRadioButtonName();//判断单选框的值
				Vector<Vector<Object>> v= XiaoShouQuShiService.getTableDate(splstr_tiaojian1, splstr_tiaojian2, stime, etime);
				if(v.size()>0 )
				{
					panel_show.removeAll();
					if(tutype1.equals("自行车季度柱形图"))
					{
						ChartPanel ChartPanel = new BarChart_jidu(splstr_tiaojian1,splstr_tiaojian2,stime,etime).getChartPanel();
						ChartPanel.setBounds(0, 0, 650, 400);
						panel_show.add(ChartPanel);
					}else if(tutype1.equals("自行车柱形图"))
					{
						ChartPanel ChartPanel = new BarChart(splstr_tiaojian1,splstr_tiaojian2,stime,etime).getChartPanel();
						ChartPanel.setBounds(0, 0, 650, 400);
						panel_show.add(ChartPanel);
					}else if(tutype1.equals("自行车饼状图"))
					{
						ChartPanel ChartPanel = new PieChart(splstr_tiaojian1,splstr_tiaojian2,stime,etime).getChartPanel();
						ChartPanel.setBounds(0, 0, 650, 400);
						panel_show.add(ChartPanel);
					}else if(tutype1.equals("自行车折线图"))
					{
						ChartPanel ChartPanel = new TimeSeriesChart(splstr_tiaojian1,splstr_tiaojian2,stime,etime).getChartPanel();
						ChartPanel.setBounds(0, 0, 650, 400);
						panel_show.add(ChartPanel);
					}
					panel_show.repaint();
				}else{
					JOptionPane.showMessageDialog(null, etime+"当天无数据", "提醒", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}else if(command.equals("保存"))
			{
				
			}else if(command.equals("退出"))
			{
				
			}
		}
		
	}

	public javax.swing.JButton getBtn_exit() {
		return btn_exit;
	}

	public void setBtn_exit(javax.swing.JButton btn_exit) {
		this.btn_exit = btn_exit;
	}

	public javax.swing.JButton getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(javax.swing.JButton btn_save) {
		this.btn_save = btn_save;
	}

	public javax.swing.JButton getBtn_select() {
		return btn_select;
	}

	public void setBtn_select(javax.swing.JButton btn_select) {
		this.btn_select = btn_select;
	}

	public JComboBox<OpeUser> getCmb_tutype() {
		return cmb_tutype;
	}

	public void setCmb_tutype(JComboBox<OpeUser> cmb_tutype) {
		this.cmb_tutype = cmb_tutype;
	}

	public javax.swing.JLabel getLbl_etime() {
		return lbl_etime;
	}

	public void setLbl_etime(javax.swing.JLabel lbl_etime) {
		this.lbl_etime = lbl_etime;
	}

	public javax.swing.JLabel getLbl_stime() {
		return lbl_stime;
	}

	public void setLbl_stime(javax.swing.JLabel lbl_stime) {
		this.lbl_stime = lbl_stime;
	}

	public javax.swing.JPanel getPanel_radio() {
		return panel_radio;
	}

	public void setPanel_radio(javax.swing.JPanel panel_radio) {
		this.panel_radio = panel_radio;
	}

	public javax.swing.JRadioButton getRad_all() {
		return rad_all;
	}

	public void setRad_all(javax.swing.JRadioButton rad_all) {
		this.rad_all = rad_all;
	}

	public javax.swing.JRadioButton getRad_huiyuan() {
		return rad_huiyuan;
	}

	public void setRad_huiyuan(javax.swing.JRadioButton rad_huiyuan) {
		this.rad_huiyuan = rad_huiyuan;
	}

	public javax.swing.JRadioButton getRad_xianjing() {
		return rad_xianjing;
	}

	public void setRad_xianjing(javax.swing.JRadioButton rad_xianjing) {
		this.rad_xianjing = rad_xianjing;
	}

	public static JTextField getTxt_etime() {
		return txt_etime;
	}

	public static void setTxt_etime(javax.swing.JTextField txt_etime) {
	     XiaoShouQuShi.txt_etime = txt_etime;
	}

	public static JTextField getTxt_stime() {
		return txt_stime;
	}

	public static void setTxt_stime(javax.swing.JTextField txt_stime) {
		XiaoShouQuShi.txt_stime = txt_stime;
	}

	public JPanel getPanel_show() {
		return panel_show;
	}

	public void setPanel_show(JPanel panel_show) {
		this.panel_show = panel_show;
	}

	public void setCmb_OpeUser(JComboBox<OpeUser> cmb_OpeUser) {
		this.cmb_OpeUser = cmb_OpeUser;
	}

}