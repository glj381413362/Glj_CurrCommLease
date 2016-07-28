package com.CCL.panel.glj.xitongguanli.son;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


import com.CCL.model.glj.Excel_RiYingYe;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.ButtonRenderer;
import com.CCL.mwing.glj.DefaultTableCellHeaderRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.mwing.glj.TableRender;
import com.CCL.panel.MPanel;
import com.CCL.service.glj.RiYingYeSelectService;
import com.CCL.util.glj.DateUtil;
import com.CCL.util.glj.Today;


public class RiYinYeSelect extends MPanel {
	private MButton btn_select,btn_export,btn_exit;
	private FixedColumnTablePanel riYinYeTablePanel;
	private Vector<String> tableColumnV;//表格头字段
	private Vector<Vector<Object>> tableValueV;//表格数据
	private MJLable lbl_stime,lbl_etime;
	private JTextField txt_stime,txt_etime;
	private JTextField txt_stime_temp = new JTextField() ,txt_etime_temp= new JTextField();
	private JDialog calenderDialog;
	private JButton sbtn,ebtn;
	
	private JPanel sellPanel;

	public RiYinYeSelect(String imageUrl,JPanel sellPanel)
	{
		super(imageUrl);
		this.sellPanel = sellPanel;
		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);
		init();
		
	}

	private void init() {
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
		
		btn_select = new MButton("images/MJBtn/tree自行车.png","查询",340,15,60,30);
		btn_export = new MButton("images/MJBtn/tree自行车.png","导出",420,15,60,30);
		btn_exit = new MButton("images/MJBtn/tree自行车.png","退出",500,15,60,30);
		
		btn_select.setActionCommand("查询");
		btn_export.setActionCommand("导出");
		btn_exit.setActionCommand("退出");
		
		
		btn_select.addActionListener(new ActionListener_btn(this));
		btn_export.addActionListener(new ActionListener_btn(this));
		btn_exit.addActionListener(new ActionListener_btn(this));
		
		
		tableColumnV = new Vector<String>();
		tableColumnV.add("序号");
		tableColumnV.add("账单编号");
		tableColumnV.add("时间");
		tableColumnV.add("总收入(元)");
		tableColumnV.add("单人车");
		tableColumnV.add("双人车");
		tableColumnV.add("四人车");
		
//		tableColumnV.add("优惠金额");
		tableValueV = RiYingYeSelectService.getRiYinYeBill();//new Vector<Vector<Object>>(); 
		Vector<Object> row1 = new Vector<Object>();
		row1.add("1");
		row1.add("");
		row1.add("");
		row1.add("");
		
		row1.add("");
		row1.add("");
		row1.add("");
		
//		tableValueV.add(row1);
		int[] floatwidth ={40,130,130,80};
		int[] fixwidth ={140,140,140};
		riYinYeTablePanel = new FixedColumnTablePanel(tableColumnV,tableValueV,4,"images/glj/shoufei/72.jpg",floatwidth,fixwidth);
		//设置表格列高度
		riYinYeTablePanel.getFixedColumnTable().setRowHeight(22);
		riYinYeTablePanel.getFloatingColumnTable().setRowHeight(22);
		
		
		TableRender tableRender =new TableRender();
//		tableRender.setToolTipText("车数量-租赁时间-消费");
		riYinYeTablePanel.getFloatingColumnTable().getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer());//自定义表头渲染器
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("单人车").setCellRenderer(tableRender);
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("双人车").setCellRenderer(tableRender);
//		riYinYeTablePanel.getFloatingColumnTable().getColumn("四人车").setCellRenderer(tableRender);
		
		riYinYeTablePanel.getFloatingColumnTable().getTableHeader().setToolTipText("不同车类型");
		riYinYeTablePanel.getFixedColumnTable().getTableHeader().setToolTipText("日营业查询");
		
//		riYinYeTablePanel.getFloatingColumnTable().setEnabled(false);
		riYinYeTablePanel.setBounds(10, 70, 740, 420);
		
		this.add(lbl_stime);
		this.add(txt_stime);
		this.add(sbtn);
		this.add(lbl_etime);
		this.add(txt_etime);
		this.add(ebtn);
		
		this.add(btn_select);
		this.add(btn_export);
		this.add(btn_exit);
		
		this.add(riYinYeTablePanel);
		
		
	}
	
	
	
	class ActionListener_btn implements ActionListener{

		private RiYinYeSelect riYinYeSelect;
		public ActionListener_btn(RiYinYeSelect riYinYeSelect) {
			this.riYinYeSelect = riYinYeSelect;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			if(command.equals("查询"))
			{
				Date starttime =null;
				Date endtime =null;
					System.out.println(riYinYeSelect.getTxt_stime().getText().trim()+"jinlai"+endtime);
					
					String start = riYinYeSelect.getTxt_stime().getText().trim();
					String end =riYinYeSelect.getTxt_etime().getText().trim();
					starttime = DateUtil.paseDate(start);
					endtime =  DateUtil.paseDate(end);
				
				tableValueV = RiYingYeSelectService.getRiYinYeBill(starttime, endtime);
				riYinYeTablePanel.setTableValueV(tableValueV);
				RiYinYeSelect.this.add(riYinYeTablePanel);

				riYinYeTablePanel.revalidate(); // 重要、、、、、、、、、、、、、、
				riYinYeTablePanel.repaint();

				
				
			}else if (command.equals("导出"))
			{
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
				String path = chooser.getSelectedFile().getAbsolutePath();
				if(riYinYeTablePanel.getTableValueV().size()==0)
				{
					JOptionPane.showMessageDialog(null, "无数据导出", "提醒", JOptionPane.ERROR_MESSAGE);
				}else{
					
				new Excel_RiYingYe(riYinYeSelect);
				if(Excel_RiYingYe.exportExcel(path))
				{
					JOptionPane.showMessageDialog(null, "导出到 "+path+" 成功", "提醒", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "导出失败", "提醒", JOptionPane.ERROR_MESSAGE);
				}
				}	
			}else if (command.equals("退出"))
			{
				JFileChooser chooser = new JFileChooser();
				System.out.println(chooser);
				sellPanel.removeAll();
				sellPanel.repaint();
			}
		}
			
		
	}
	class MouseListener_sbtn implements ActionListener
	{
		private RiYinYeSelect ryd;
		public MouseListener_sbtn(RiYinYeSelect ryd)
		{
			this.ryd = ryd;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("起始时间"))
			{
				//缓存开始时间和结束时间
				ryd.getTxt_stime_temp().setText(ryd.getTxt_stime().getText());
				ryd.getTxt_etime_temp().setText(ryd.getTxt_etime().getText());
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
					MyCalenderPanel mc = new MyCalenderPanel(ryd,"起始时间");
					
				
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
				ryd.getTxt_stime_temp().setText(ryd.getTxt_stime().getText());
				ryd.getTxt_etime_temp().setText(ryd.getTxt_etime().getText());
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
					MyCalenderPanel mc = new MyCalenderPanel(ryd,"结束时间");
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
			private MyCalenderPanel mc;
			public MouseAdapter_btn_cancele(JDialog calDialog,MyCalenderPanel mc) {
				this.calDialog = calDialog;
				this.mc = mc;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("开始时间取消"))
				{
					ryd.getTxt_stime().setText(ryd.getTxt_stime_temp().getText());
					calDialog.dispose();
				}
				else if(e.getActionCommand().equals("结束时间取消")){
					ryd.getTxt_etime().setText(ryd.getTxt_etime_temp().getText());
					calDialog.dispose();
				}
				
			}
			
		}

		class MouseAdapter_btn_sure implements ActionListener
		{

			private JDialog calDialog;
			private MyCalenderPanel mc;
			public MouseAdapter_btn_sure(JDialog calDialog,MyCalenderPanel mc) {
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

	public FixedColumnTablePanel getRiYinYeTablePanel() {
		return riYinYeTablePanel;
	}

	public void setRiYinYeTablePanel(FixedColumnTablePanel riYinYeTablePanel) {
		this.riYinYeTablePanel = riYinYeTablePanel;
	}

}
