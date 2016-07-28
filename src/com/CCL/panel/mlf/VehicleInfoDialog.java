package com.CCL.panel.mlf;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleState;
import com.CCL.beans.BicycleType;
import com.CCL.panel.MPanel;


public class VehicleInfoDialog extends JDialog {
	private Bicycle biy;
	private Panel_setvehicle psc;
	private MPanel pnlMain;
	private JTextField txt_1;
	private JComboBox txt_2;
	private JComboBox txt_3;
	private JTextField txt_4;
	private JTextField txt_5;
	private JTextField txt_6;
	private JTextField txt_7;
	private JLabel  lbl_1;
	private JLabel  lbl_2;
	private JLabel  lbl_3;
	private JLabel  lbl_4;
	private JLabel  lbl_5;
	private JLabel  lbl_6;
	private JLabel  lbl_7;
	private JButton btnSave;
	private JButton btnDel;
	private JButton btnExit;
	private  BicycleState b1 =new BicycleState();
	private  BicycleState b2 =new BicycleState();
	private  BicycleState b3 =new BicycleState();
	private  BicycleType bs1 =new BicycleType();
	private  BicycleType bs2 =new BicycleType();
	private  BicycleType bs3 =new BicycleType();
	 
	private BicycleDao bdao;
	public Bicycle getBiy() {
		return biy;
	}

	public void setBiy(Bicycle biy) {
		this.biy = biy;
	}

	public Panel_setvehicle getPsc() {
		return psc;
	}

	public void setPsc(Panel_setvehicle psc) {
		this.psc = psc;
	}

	public MPanel getPnlMain() {
		return pnlMain;
	}

	public void setPnlMain(MPanel pnlMain) {
		this.pnlMain = pnlMain;
	}

	public JTextField getTxt_1() {
		return txt_1;
	}

	public void setTxt_1(JTextField txt_1) {
		this.txt_1 = txt_1;
	}

	public JComboBox getTxt_2() {
		return txt_2;
	}

	public void setTxt_2(JComboBox txt_2) {
		this.txt_2 = txt_2;
	}

	public JComboBox getTxt_3() {
		return txt_3;
	}

	public void setTxt_3(JComboBox txt_3) {
		this.txt_3 = txt_3;
	}

	public JTextField getTxt_4() {
		return txt_4;
	}

	public void setTxt_4(JTextField txt_4) {
		this.txt_4 = txt_4;
	}

	public JTextField getTxt_5() {
		return txt_5;
	}

	public void setTxt_5(JTextField txt_5) {
		this.txt_5 = txt_5;
	}

	public JTextField getTxt_6() {
		return txt_6;
	}

	public void setTxt_6(JTextField txt_6) {
		this.txt_6 = txt_6;
	}

	public JTextField getTxt_7() {
		return txt_7;
	}

	public void setTxt_7(JTextField txt_7) {
		this.txt_7 = txt_7;
	}

	public JLabel getLbl_1() {
		return lbl_1;
	}

	public void setLbl_1(JLabel lbl_1) {
		this.lbl_1 = lbl_1;
	}

	public JLabel getLbl_2() {
		return lbl_2;
	}

	public void setLbl_2(JLabel lbl_2) {
		this.lbl_2 = lbl_2;
	}

	public JLabel getLbl_3() {
		return lbl_3;
	}

	public void setLbl_3(JLabel lbl_3) {
		this.lbl_3 = lbl_3;
	}

	public JLabel getLbl_4() {
		return lbl_4;
	}

	public void setLbl_4(JLabel lbl_4) {
		this.lbl_4 = lbl_4;
	}

	public JLabel getLbl_5() {
		return lbl_5;
	}

	public void setLbl_5(JLabel lbl_5) {
		this.lbl_5 = lbl_5;
	}

	public JLabel getLbl_6() {
		return lbl_6;
	}

	public void setLbl_6(JLabel lbl_6) {
		this.lbl_6 = lbl_6;
	}

	public JLabel getLbl_7() {
		return lbl_7;
	}

	public void setLbl_7(JLabel lbl_7) {
		this.lbl_7 = lbl_7;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnDel() {
		return btnDel;
	}

	public void setBtnDel(JButton btnDel) {
		this.btnDel = btnDel;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public VehicleInfoDialog(Frame owner, String title, boolean modal,Panel_setvehicle psc,Bicycle biy) {
		super(owner, title, modal);
		this.biy=biy;
		this.psc=psc;
		bdao=new BicycleDaoImpl();
		pnlMain=new MPanel("images/glj/shoufei/addimages.png");
		pnlMain.setLayout(null);
		  txt_1=new JTextField(15);
		  txt_2=new JComboBox();
		  txt_3=new JComboBox();
		  
		  txt_4=new JTextField(15);
		  txt_5=new JTextField(15);
		  txt_6=new JTextField(15);
		  txt_7=new JTextField(15);
		
		  b1.setId(1);
		  b1.setName("维修中");
		 
		  b2.setId(2);
		  b2.setName("正常");
		
		  b3.setId(3);
		  b3.setName("已出租");
		  txt_2.addItem(b1);
		  txt_2.addItem(b2);
		  txt_2.addItem(b3);
		  txt_2.setEditable(false);
		  
		 
		  bs1.setId(2);
		  bs1.setName("单人");
		  
		  bs2.setId(3);
		  bs2.setName("双人");
		  
		  bs3.setId(1);
		  bs3.setName("四人");
		  txt_3.addItem(bs1);
		  txt_3.addItem(bs2);
		  txt_3.addItem(bs3);
		  txt_3.setEditable(false);
		  btnSave=new JButton("保存");
		  btnSave.setBorder(BorderFactory.createLineBorder(Color.black));
		  btnSave.addMouseListener(new MouseAdapter() {
          
		
			public void mouseClicked(MouseEvent e) {			
				btnsave_mouseaction(e);			
			}
		    });
	      btnDel=new JButton("删除");
	      btnDel.setBorder(BorderFactory.createLineBorder(Color.black));
	      btnDel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
                      btndel_mouseClick(e);
			}
		});
		  btnExit=new JButton("退出");
		  btnExit.setBorder(BorderFactory.createLineBorder(Color.black));
		  btnExit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				VehicleInfoDialog.this.dispose();
			}
			  
		});
		init();
	}

	protected void btndel_mouseClick(MouseEvent e) {
	        bdao.remove(biy.getId());
	        this.psc.setTableDate(bdao.queryAll());
	        VehicleInfoDialog.this.dispose();
	}

	protected void btnsave_mouseaction(MouseEvent e) {
		int id=Integer.parseInt(this.txt_1.getText().trim());
		BicycleState state = (BicycleState) this.txt_2.getSelectedItem();
		BicycleType type = (BicycleType) this.txt_3.getSelectedItem();
		String name=this.txt_4.getText().trim();
		String descript=this.txt_5.getText().trim();
		int price=Integer.parseInt(this.txt_6.getText().trim());
		String factory=this.txt_7.getText().trim();
		Bicycle b=bdao.get(id);

	    b.setBicycleState(state);
		b.setType(type);
		b.setName(name);
		b.setDescript(descript);
		b.setPrice(price);
		b.setFactory(factory);
		bdao.update(b);
		this.psc.setTableDate(bdao.queryAll());
		VehicleInfoDialog.this.dispose();
	}



	private void init() {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(580, 250, 260, 340);
		
		  lbl_1=new JLabel("    ID");
		  lbl_2=new JLabel("    状态");
		  lbl_3=new JLabel("    类型");
		  lbl_4=new JLabel("    名称");
		  lbl_5=new JLabel("    描述");
		  lbl_6=new JLabel("    价格");
		  lbl_7=new JLabel("    厂商");
		txt_1.setText(String.valueOf(biy.getId()));

		if(biy.getBicycleState().getId()==1)
		{ 
			txt_2.setSelectedItem(b1);
		}else if(biy.getBicycleState().getId()==2)
		{    
			txt_2.setSelectedItem(b2);
		}else if(biy.getBicycleState().getId()==3)
		{
			txt_2.setSelectedItem(b3);
		}
		if(biy.getType().getId()==1)
		{
			txt_3.setSelectedItem(bs3);
		}else if(biy.getType().getId()==2)
		{
			txt_3.setSelectedItem(bs1);
		}else if(biy.getType().getId()==3)
		{   
			txt_3.setSelectedItem(bs2);
		}
		
		txt_4.setText(biy.getName());
		txt_5.setText(biy.getDescript());
		txt_6.setText(String.valueOf(biy.getPrice()));
		txt_7.setText(biy.getFactory());
		txt_1.setEditable(false);
		
		lbl_1.setBounds(40, 10, 50, 20);
		lbl_2.setBounds(40, 40, 50, 20);
		lbl_3.setBounds(40, 70, 50, 20);
		lbl_4.setBounds(40, 100, 50, 20);
		lbl_5.setBounds(40, 130, 50, 20);
		lbl_6.setBounds(40, 160, 50, 20);
		lbl_7.setBounds(40, 190, 50, 20);
		
		txt_1.setBounds(90, 10, 100, 20);
		txt_2.setBounds(90, 40, 100, 20);
		txt_3.setBounds(90, 70, 100, 20);
		txt_4.setBounds(90, 100, 100, 20);
		txt_5.setBounds(90, 130, 100, 20);
		txt_6.setBounds(90, 160,100, 20);
		txt_7.setBounds(90, 190, 100, 20);
		btnSave.setBounds(30, 260, 40, 30);
		btnDel.setBounds(110, 260, 40, 30);
		btnExit.setBounds(190, 260, 40,30);
    	pnlMain.add(lbl_1);
    	pnlMain.add(txt_1);
    	pnlMain.add(lbl_2);
    	pnlMain.add(txt_2);
    	pnlMain.add(lbl_3);
    	pnlMain.add(txt_3);
    	pnlMain.add(lbl_4);
    	pnlMain.add(txt_4);
    	pnlMain.add(lbl_5);
    	pnlMain.add(txt_5);
    	pnlMain.add(lbl_6);
    	pnlMain.add(txt_6);
    	pnlMain.add(lbl_7);
    	pnlMain.add(txt_7);
    	pnlMain.add(btnSave);
    	pnlMain.add(btnDel);
    	pnlMain.add(btnExit);
    	this.add(pnlMain);
    	this.setUndecorated(true);
    	
    	this.setVisible(true);
	}

	

}
