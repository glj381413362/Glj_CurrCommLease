package com.CCL.panel.glj.xitongguanli.son;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.CCL.beans.CustomerType;
import com.CCL.beans.OpeUser;
import com.CCL.model.glj.Excel_RiYingYe;
import com.CCL.model.glj.Excel_ZhangDanMingXi;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.DefaultTableCellHeaderRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.mwing.glj.TableRender;
import com.CCL.panel.MPanel;
import com.CCL.service.glj.MingXiSelectService;
import com.CCL.service.glj.RiYingYeSelectService;
import com.CCL.util.glj.DateUtil;
import com.CCL.util.glj.Today;

public class ZhangDanMingXiSelect extends MPanel {
	private MButton btn_select,btn_export,btn_exit;
	private FixedColumnTablePanel zhangdanmingxi;
	private Vector<String> tableColumnV;//表格头字段
	private Vector<Vector<Object>> tableValueV;//表格数据
	private MJLable lbl_stime,lbl_etime;
	private JTextField txt_stime,txt_etime;
	private JTextField txt_stime_temp = new JTextField() ,txt_etime_temp= new JTextField();
	private JDialog calenderDialog;
	private JButton sbtn,ebtn;
	private JPanel radPanel;
	private JRadioButton rad_all,rad_huiyuan,rad_putong;
	private JComboBox<OpeUser> cmb_OpeUser;
	private JPanel sellPanel;
	public ZhangDanMingXiSelect(String imageUrl,JPanel sellPanel)
	{
		super(imageUrl);
		this.sellPanel = sellPanel;
		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);
		init();
		
		
	}
	

	private void init() {
		
		radPanel = new JPanel();
		radPanel.setBounds(411, 0, 200, 60);
		radPanel.setBorder(BorderFactory.createTitledBorder("消费类型"));
		radPanel.setOpaque(false);
		rad_all = new JRadioButton("所有");
		rad_all.setBounds(5, 0, 20, 15);
		rad_all.setOpaque(false);
		rad_huiyuan = new JRadioButton("会员卡");
		rad_huiyuan.setOpaque(false);
		rad_all.setBounds(30, 0, 25, 15);
		rad_putong = new JRadioButton("现金");
		rad_putong.setOpaque(false);
		rad_all.setBounds(55, 0, 20, 15);
		radPanel.add(rad_all);
		radPanel.add(rad_huiyuan);
		radPanel.add(rad_putong);
		
		//分组，让其只能单选
		ButtonGroup grp = new ButtonGroup();
		grp.add(rad_all);
		grp.add(rad_huiyuan);
		grp.add(rad_putong);
		rad_all.setSelected(true);
		
		cmb_OpeUser = getCmb_OpeUser();
		cmb_OpeUser.setBounds(308, 20, 95, 22);
		cmb_OpeUser.setOpaque(false);
		
		
		lbl_stime = new MJLable("",0,0);
		lbl_stime.setText("日期从");
		lbl_stime.setBounds(10, 17, 50, 25);
		txt_stime=new JTextField(Today.getDate()); 
		txt_stime.setBounds(60, 19, 90, 20);
		txt_stime.setHorizontalAlignment(SwingConstants.CENTER);
		sbtn = new JButton("...");
		sbtn.setBounds(151, 19, 20, 20);
		sbtn.setBorder(BorderFactory.createLineBorder(Color.white));
		sbtn.setContentAreaFilled(false);
		//设置ActionCommand
		sbtn.setActionCommand("起始时间");
//		String startTime = "起始时间";
		sbtn.addActionListener(new MouseListener_sbtn(this));
		
		lbl_etime = new MJLable("",0,0);
		lbl_etime.setText("到");
		lbl_etime.setBounds(170, 17, 20, 25);
		
		txt_etime=new JTextField(Today.getDate());
		txt_etime.setBounds(190, 19, 90, 20);
		txt_etime.setHorizontalAlignment(SwingConstants.CENTER);
		ebtn = new JButton("...");
		ebtn.setBounds(281, 19, 20, 20);
		ebtn.setBorder(BorderFactory.createLineBorder(Color.white));
		ebtn.setContentAreaFilled(false);
		//设置ActionCommand
	    ebtn.setActionCommand("结束时间");
	    ebtn.addActionListener(new MouseListener_sbtn(this));
		
		btn_select = new MButton("images/MJBtn/tree自行车.png","查询",615,15,60,30);
		btn_export = new MButton("images/MJBtn/tree自行车.png","导出",680,15,60,30);
		btn_exit = new MButton("images/MJBtn/tree自行车.png","退出",745,15,60,30);
		
		btn_select.setActionCommand("查询");
		btn_export.setActionCommand("导出");
		btn_exit.setActionCommand("退出");
		
		
		btn_select.addActionListener(new ActionListener_btn(this));
		btn_export.addActionListener(new ActionListener_btn(this));
		btn_exit.addActionListener(new ActionListener_btn(this));
		
		
		tableColumnV = new Vector<String>();
		tableColumnV.add("序号");
		tableColumnV.add("账单编号");
		tableColumnV.add("操作员");
		tableColumnV.add("会员卡号");
		
		tableColumnV.add("会员姓名");
		tableColumnV.add("登记时间");
		tableColumnV.add("结账时间");
		tableColumnV.add("押金");
		tableColumnV.add("消费金额");
		tableColumnV.add("结账方式");
		tableColumnV.add("消费时长");
		tableColumnV.add("详情");
		
		tableValueV =MingXiSelectService.getTableDate("所有","所有","","");//new Vector<Vector<Object>>();
		Vector<Object> row1 = new Vector<Object>();
		row1.add("1");
		row1.add("");
		row1.add("");
		row1.add("");
		
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		row1.add("");
		
		
//		tableValueV.add(row1);
		int[] fixwidth ={40,100,100,80};
		int[] floatwidth ={60,120,120,60,60,60,60,239};
		zhangdanmingxi = new FixedColumnTablePanel(tableColumnV,tableValueV,4,"images/glj/shoufei/72.jpg",fixwidth,floatwidth);
		//设置表格列高度
		zhangdanmingxi.getFixedColumnTable().setRowHeight(22);
		zhangdanmingxi.getFloatingColumnTable().setRowHeight(22);
		
		
//		zhangdanmingxi.getFloatingColumnTable().getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer());//自定义表头渲染器
		
		zhangdanmingxi.getFloatingColumnTable().getTableHeader().setToolTipText("不同车类型");
		zhangdanmingxi.getFixedColumnTable().getTableHeader().setToolTipText("账单明细查询");
		
		zhangdanmingxi.setBounds(10, 70, 742, 385);
		
		this.add(lbl_stime);
		this.add(txt_stime);
		this.add(sbtn);
		this.add(lbl_etime);
		this.add(txt_etime);
		this.add(ebtn);
		
		this.add(cmb_OpeUser);
		this.add(radPanel);
		this.add(btn_select);
		this.add(btn_export);
		this.add(btn_exit);
		
		this.add(zhangdanmingxi);
		
		
	}
	
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
	
	class ActionListener_btn implements ActionListener{

		private ZhangDanMingXiSelect zhangDanMingXiSelect;
		public ActionListener_btn(ZhangDanMingXiSelect zhangDanMingXiSelect) {
			this.zhangDanMingXiSelect = zhangDanMingXiSelect;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			if(command.equals("查询"))
			{
				Date starttime =null;
				Date endtime =null;
					
					String start = zhangDanMingXiSelect.getTxt_stime().getText().trim();
					String end =zhangDanMingXiSelect.getTxt_etime().getText().trim();
					starttime = DateUtil.paseDate(start);
					endtime =  DateUtil.paseDate(end);
					
					String splstr_tiaojian1 = cmb_OpeUser.getSelectedItem().toString();//获得下拉列表框的值
					String splstr_tiaojian2 = getRadioButtonName();//判断单选框的值
					
					tableValueV = MingXiSelectService.getTableDate(splstr_tiaojian1, splstr_tiaojian2,start,end);
					
				zhangdanmingxi.setTableValueV(tableValueV);
				ZhangDanMingXiSelect.this.add(zhangdanmingxi);

				zhangdanmingxi.revalidate(); // 重要、、、、、、、、、、、、、、
				zhangdanmingxi.repaint();

				
				
			}else if (command.equals("导出"))
			{
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				String path = chooser.getSelectedFile().getAbsolutePath();
				if(zhangdanmingxi.getTableValueV().size()==0)
				{
					JOptionPane.showMessageDialog(null, "无数据导出", "提醒", JOptionPane.ERROR_MESSAGE);
				}else{
				new Excel_ZhangDanMingXi(zhangDanMingXiSelect);
				if(Excel_ZhangDanMingXi.exportExcel(path))
				{
					JOptionPane.showMessageDialog(null, "导出到 "+path+" 成功", "提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "导出失败", "提醒", JOptionPane.ERROR_MESSAGE);
				}
				
				}	
			}else if (command.equals("退出"))
			{
				sellPanel.removeAll();
				sellPanel.repaint();
			}
		}
		
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
		}else if(rad_putong.isSelected())
		{
			result = "现金支付"; 
		}else if(rad_all.isSelected())
		{
			result = "所有"; 
		}
		
		return result;
	}
	
	
	class MouseListener_sbtn implements ActionListener
	{
		private ZhangDanMingXiSelect zdmx;
		public MouseListener_sbtn(ZhangDanMingXiSelect zdmx)
		{
			this.zdmx = zdmx;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("起始时间"))
			{
				//缓存开始时间和结束时间
				zdmx.getTxt_stime_temp().setText(zdmx.getTxt_stime().getText());
				zdmx.getTxt_etime_temp().setText(zdmx.getTxt_etime().getText());
//				if(calenderDialog==null){
					calenderDialog = new JDialog();
					MButton btn_sure=new MButton("");
					btn_sure.setText("确定");
					MButton btn_cancele=new MButton("");
					btn_cancele.setText("取消");
					btn_sure.setBounds(50, 200, 50, 30);
					btn_cancele.setBounds(118, 200, 50, 30);
					MPanel mainpanel = new MPanel("images/glj/日营业查询/日历背景.jpg");
					
					calenderDialog.setContentPane(mainpanel);
					calenderDialog.setLayout(null);
					
					calenderDialog.setUndecorated(true);
					calenderDialog.setBounds(612, 282, 230, 235);
					//设置dialog处在最顶层
					calenderDialog.setModal(true);
					MyCalenderPanel_ZhangDanMingXi mc = new MyCalenderPanel_ZhangDanMingXi(zdmx,"起始时间");
					
				
					mc.setBounds(0, 0, 230, 200);
					mainpanel.add(mc);
					mainpanel.add(btn_sure);
					mainpanel.add(btn_cancele);
					//设置dialog不失去焦点
					calenderDialog.setAlwaysOnTop(true);
					btn_sure.setActionCommand("开始时间确定");
					btn_cancele.setActionCommand("开始时间取消");
					btn_sure.addActionListener(new MouseAdapter_btn_sure(calenderDialog,mc));
					btn_cancele.addActionListener(new MouseAdapter_btn_cancele(calenderDialog,mc));
					calenderDialog.setVisible(true);
				
//				}
				
			}else if(e.getActionCommand().equals("结束时间"))
			{
				//缓存开始时间和结束时间
				zdmx.getTxt_stime_temp().setText(zdmx.getTxt_stime().getText());
				zdmx.getTxt_etime_temp().setText(zdmx.getTxt_etime().getText());
//				if(calenderDialog==null){
					calenderDialog = new JDialog();
					MButton btn_sure=new MButton("");
					btn_sure.setText("确定");
					MButton btn_cancele=new MButton("");
					btn_cancele.setText("取消");
					btn_sure.setBounds(50, 200, 50, 30);
					btn_cancele.setBounds(118, 200, 50, 30);
					MPanel mainpanel = new MPanel("images/glj/日营业查询/日历背景.jpg");
					
					calenderDialog.setContentPane(mainpanel);
					calenderDialog.setLayout(null);
					
					calenderDialog.setUndecorated(true);
					calenderDialog.setBounds(741, 282, 230, 235);
					calenderDialog.setModal(true);
					MyCalenderPanel_ZhangDanMingXi mc = new MyCalenderPanel_ZhangDanMingXi(zdmx,"结束时间");
					mc.setBounds(0, 0, 230, 200);
					mainpanel.add(mc);
					mainpanel.add(btn_sure);
					mainpanel.add(btn_cancele);
					//设置dialog不失去焦点
					calenderDialog.setAlwaysOnTop(true);
					btn_sure.setActionCommand("结束时间确定");
					btn_cancele.setActionCommand("结束时间取消");
					btn_sure.addActionListener(new MouseAdapter_btn_sure(calenderDialog,mc));
					btn_cancele.addActionListener(new MouseAdapter_btn_cancele(calenderDialog,mc));
					calenderDialog.setVisible(true);
				}
//			}
			
		}
		class MouseAdapter_btn_cancele implements ActionListener
		{

			private JDialog calDialog;
			private MyCalenderPanel_ZhangDanMingXi mc;
			public MouseAdapter_btn_cancele(JDialog calDialog,MyCalenderPanel_ZhangDanMingXi mc2) {
				this.calDialog = calDialog;
				this.mc = mc2;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("开始时间取消"))
				{
					zdmx.getTxt_stime().setText(zdmx.getTxt_stime_temp().getText());
					calDialog.dispose();
				}
				else if(e.getActionCommand().equals("结束时间取消")){
					zdmx.getTxt_etime().setText(zdmx.getTxt_etime_temp().getText());
					calDialog.dispose();
				}
				
			}
			
		}

		class MouseAdapter_btn_sure implements ActionListener
		{

			private JDialog calDialog;
			private MyCalenderPanel_ZhangDanMingXi mc;
			public MouseAdapter_btn_sure(JDialog calDialog,MyCalenderPanel_ZhangDanMingXi mc) {
				this.calDialog = calDialog;
				this.mc = mc;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("开始时间确定"))
				{
					calDialog.dispose();
				}
				else if(e.getActionCommand().equals("结束时间确定")){
					calDialog.dispose();
				}
				
			}
			
		}

		
		
	}
	
	
	public JTextField getTxt_stime_temp() {
		return txt_stime_temp;
	}

	public void setTxt_stime_temp(JTextField txt_stime_temp) {
		this.txt_stime_temp = txt_stime_temp;
	}

	public JTextField getTxt_etime_temp() {
		return txt_etime_temp;
	}

	public void setTxt_etime_temp(JTextField txt_etime_temp) {
		this.txt_etime_temp = txt_etime_temp;
	}

	public JTextField getTxt_stime() {
		return txt_stime;
	}

	public void setTxt_stime(JTextField txt_stime) {
		this.txt_stime = txt_stime;
	}

	public JTextField getTxt_etime() {
		return txt_etime;
	}

	public void setTxt_etime(JTextField txt_etime) {
		this.txt_etime = txt_etime;
	}


	public FixedColumnTablePanel getZhangdanmingxi() {
		return zhangdanmingxi;
	}


	public void setZhangdanmingxi(FixedColumnTablePanel zhangdanmingxi) {
		this.zhangdanmingxi = zhangdanmingxi;
	}


	public JPanel getRadPanel() {
		return radPanel;
	}


	public void setRadPanel(JPanel radPanel) {
		this.radPanel = radPanel;
	}


	public JRadioButton getRad_all() {
		return rad_all;
	}


	public void setRad_all(JRadioButton rad_all) {
		this.rad_all = rad_all;
	}


	public JRadioButton getRad_huiyuan() {
		return rad_huiyuan;
	}


	public void setRad_huiyuan(JRadioButton rad_huiyuan) {
		this.rad_huiyuan = rad_huiyuan;
	}


	public JRadioButton getRad_putong() {
		return rad_putong;
	}


	public void setRad_putong(JRadioButton rad_putong) {
		this.rad_putong = rad_putong;
	}


	public void setCmb_OpeUser(JComboBox<OpeUser> cmb_OpeUser) {
		this.cmb_OpeUser = cmb_OpeUser;
	}

}