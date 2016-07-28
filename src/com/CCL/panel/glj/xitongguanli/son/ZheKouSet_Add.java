/*
 * ZheKouSet_Add.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.panel.glj.xitongguanli.son;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.CCL.beans.BicycleType;
import com.CCL.beans.CustomerType;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet.ActionListener_btn;
import com.CCL.service.glj.ZheKouSetService;

/**
 * 
 * @author __USER__
 */
public class ZheKouSet_Add extends JPanel {

	private JComboBox<BicycleType> cmb_bicycle_type;
	private JComboBox<CustomerType> cmb_cus_type;
	private JLabel lbl_bicycle;
	private JLabel lbl_bicycle_zhekou;
	private JLabel lbl_cus_zhekou;
	private JLabel lbl_cusstype;
	private JLabel lbl_title;
	
	private MJLable tip_bicycle,tip_customer;
	
	private JPanel pane_bicycle;
	private JPanel panel_custuer;
	private JTextField txt_bicycle_zhekou;
	private JTextField txt_cus_zhekou;
	private ZheKouSet zheKouSet;
	private MButton btn_save, btn_cancle;

	private ZheKouSetService zheKouSetService;

	public ZheKouSet_Add(ZheKouSet zheKouSet) {
		this.zheKouSet = zheKouSet;
		zheKouSetService = zheKouSet.getZheKouSetService();
		initComponents();
		this.setVisible(true);

	}

	public ZheKouSet_Add() {
		this.zheKouSet = zheKouSet;
		this.setOpaque(true);
		zheKouSetService = zheKouSet.getZheKouSetService();
		initComponents();
		this.setVisible(true);

	}

	private void initComponents() {

		pane_bicycle = new JPanel();
		lbl_bicycle_zhekou = new JLabel();
		lbl_bicycle = new JLabel();
		tip_bicycle = new MJLable("images/glj/error.png",90,24);
        tip_customer = new MJLable("images/glj/error.png",90,24);
		cmb_bicycle_type = getCmb_BicycleType();
		txt_bicycle_zhekou = new JTextField("1");
		txt_cus_zhekou = new JTextField("1");
		txt_cus_zhekou.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				String num = "0123456789";    //将允许输入的字符定义成字符串
				if(e.getKeyCode()==KeyEvent. VK_BACK_SPACE)
				{
					Float cus_zhekou =  txt_cus_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_cus_zhekou.getText().trim());
					if(cus_zhekou>=10||cus_zhekou<0)
					{
							e.consume();//撤销此次按键输入
							tip_customer.setVisible(true);
					}else{
						tip_customer.setVisible(false);
					}
				}else{
				if(num.indexOf(e.getKeyChar())>0)
				{
						Float cus_zhekou =  txt_cus_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_cus_zhekou.getText().trim());
					if(cus_zhekou>=10||cus_zhekou<0)
					{
							e.consume();//撤销此次按键输入
							tip_customer.setVisible(true);
					}else{
						tip_customer.setVisible(false);
					}
				}else{
						e.consume();//撤销此次按键输入
						txt_cus_zhekou.setText("1");
				}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
        txt_cus_zhekou.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Float cus_zhekou =  txt_cus_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_cus_zhekou.getText().trim());
				if(cus_zhekou>=10||cus_zhekou<0)
				{
						tip_customer.setVisible(true);
				}else{
					tip_customer.setVisible(false);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txt_cus_zhekou.setText(null);
			}
		});
		txt_bicycle_zhekou.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				String num = "0123456789";    //将允许输入的字符定义成字符串
				if(e.getKeyCode()==KeyEvent. VK_BACK_SPACE)
				{
					Float bicycle_zhekou =  txt_bicycle_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_bicycle_zhekou.getText().trim());
					if(bicycle_zhekou>=10||bicycle_zhekou<0)
					{
							e.consume();//撤销此次按键输入
							tip_bicycle.setVisible(true);
					}else{
						tip_bicycle.setVisible(false);
					}
				}else{
				if(num.indexOf(e.getKeyChar())>0)
				{
						Float bicycle_zhekou =  txt_bicycle_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_bicycle_zhekou.getText().trim());
					if(bicycle_zhekou>=10||bicycle_zhekou<0)
					{
							e.consume();//撤销此次按键输入
							tip_bicycle.setVisible(true);
					}else{
						tip_bicycle.setVisible(false);
					}
				}else{
						e.consume();//撤销此次按键输入
		            	txt_bicycle_zhekou.setText("1");
				}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		txt_bicycle_zhekou.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Float bicycle_zhekou =  txt_bicycle_zhekou.getText().isEmpty() ? 0 : Float.valueOf(txt_bicycle_zhekou.getText().trim());
				if(bicycle_zhekou>=10||bicycle_zhekou<0)
				{
						tip_bicycle.setVisible(true);
				}else{
					tip_bicycle.setVisible(false);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txt_bicycle_zhekou.setText(null);
			}
		});
		
		
		lbl_title = new JLabel();
		panel_custuer = new JPanel();
		lbl_cus_zhekou = new JLabel();
		lbl_cusstype = new JLabel();
		cmb_cus_type = getCmb_CustomerType();
		
		btn_save = new MButton("images/glj/ButtonImages/btn_suer_off.jpg");
		btn_save.setPressedIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_suer_on.png"));
		btn_save.setRolloverIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_suer_on.png"));
		btn_cancle = new MButton("images/glj/ButtonImages/btn_cancle_off.png");
		btn_cancle.setPressedIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_cancle_on.png"));
		btn_cancle.setRolloverIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_cancle_on.png"));

		btn_save.setActionCommand("确定");
		btn_cancle.setActionCommand("取消");
		btn_save.addActionListener(new ActionListener_btn(this));
		btn_cancle.addActionListener(new ActionListener_btn(this));

		lbl_title.setText("                               图片");
		lbl_title.setBounds(51, 17, 300, 50);

		lbl_bicycle_zhekou.setText("\u8f66\u7c7b\u578b\u6298\u6263 \uff1a");
		lbl_bicycle_zhekou.setBounds(40, 60, 95, 17);

		lbl_bicycle.setText("  \u8f66  \u7c7b  \u578b \uff1a");
		lbl_bicycle.setBounds(40, 20, 90, 17);

		tip_bicycle.setBounds(260, 60, 70, 23);
		tip_customer.setBounds(260, 60, 70, 23);
		tip_bicycle.setVisible(false);
		tip_customer.setVisible(false);
		
		
		txt_bicycle_zhekou.setBounds(140, 60, 130, 23);
		txt_cus_zhekou.setBounds(140, 60, 130, 23);

		lbl_cus_zhekou.setText("\u7528\u6237\u7c7b\u578b\u6298\u6263 \uff1a");
		lbl_cus_zhekou.setBounds(40, 60, 95, 17);

		btn_save.setBounds(80, 330, 103, 30);
		btn_cancle.setBounds(210, 330, 103, 30);

		lbl_cusstype.setText("\u7528  \u6237  \u7c7b  \u578b \uff1a");
		lbl_cusstype.setBounds(40, 20, 90, 17);

		cmb_cus_type.setBounds(140, 20, 130, 23);
		
		cmb_bicycle_type.setBounds(140, 20, 130, 23);
		cmb_cus_type.setEnabled(false);
		cmb_bicycle_type.setEnabled(false);

		this.setLayout(null);
		this.setBounds(0, 0, 403, 390);// ////////////
		pane_bicycle.setLayout(null);
		panel_custuer.setLayout(null);

		pane_bicycle.setBounds(18, 80, 320, 100);
		pane_bicycle.setBorder(BorderFactory.createTitledBorder("车类型折扣"));
		pane_bicycle.add(lbl_bicycle_zhekou);
		pane_bicycle.add(lbl_bicycle);
		pane_bicycle.add(cmb_bicycle_type);
		pane_bicycle.add(txt_bicycle_zhekou);
		pane_bicycle.add(tip_bicycle);

		panel_custuer.setBounds(18, 205, 320, 100);
		panel_custuer.setBorder(BorderFactory.createTitledBorder("用户类型折扣"));

		panel_custuer.add(lbl_cus_zhekou);
		panel_custuer.add(lbl_cusstype);
		panel_custuer.add(cmb_cus_type);
		panel_custuer.add(txt_cus_zhekou);
		panel_custuer.add(tip_customer);

		this.add(lbl_title);
		this.add(pane_bicycle);
		this.add(panel_custuer);
		this.add(btn_cancle);
		this.add(btn_save);

	}

	class ActionListener_btn implements ActionListener {

		private ZheKouSet_Add zheKouSet_Add;
		public ActionListener_btn(ZheKouSet_Add zheKouSet_Add) {

			this.zheKouSet_Add = zheKouSet_Add;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("确定")) {
				BicycleType bicycleType = (com.CCL.beans.BicycleType) cmb_bicycle_type.getSelectedItem();//获得combobox的值
				Float bicycle_zhekou =  txt_bicycle_zhekou.getText().isEmpty() ? 1 : Float.valueOf(txt_bicycle_zhekou.getText().trim());
				txt_bicycle_zhekou.setText(bicycle_zhekou+"");
				CustomerType customerType =(com.CCL.beans.CustomerType) cmb_cus_type.getSelectedItem();//获得combobox的值
				Float cus_zhekou = txt_cus_zhekou.getText().trim().isEmpty() ? 1 : Float.valueOf(txt_cus_zhekou.getText().trim());
				txt_cus_zhekou.setText(cus_zhekou+"");
				if(bicycleType.getIsShow())
				{
				    int n = JOptionPane.showConfirmDialog(null, bicycleType.getName()+"类型折扣已存在，是否修改", "Warning", JOptionPane.YES_NO_OPTION);  
		            if (n == JOptionPane.YES_OPTION) {  
						bicycleType.setDiscount(bicycle_zhekou);
						zheKouSetService.update(bicycleType);
						
		            } else if (n == JOptionPane.NO_OPTION) { 
		            }  
				}else{
					bicycleType.setIsShow(true);
	            	bicycleType.setDiscount(bicycle_zhekou);
					zheKouSetService.update(bicycleType);
				}
				
				if(customerType.getIsShow())
				{
				    int n = JOptionPane.showConfirmDialog(null, customerType.getName()+"类型折扣已存在，是否修改", "Warning", JOptionPane.YES_NO_OPTION);  
		            if (n == JOptionPane.YES_OPTION) {  
		            	System.out.println("gdfgfgggdhgfhgfh");
		            	customerType.setDiscount(cus_zhekou);
						zheKouSetService.update(customerType);
						
		            } else if (n == JOptionPane.NO_OPTION) { 
		            }  
				}else{
					customerType.setIsShow(true);
					customerType.setDiscount(cus_zhekou);
					zheKouSetService.update(customerType);
				}
				tip_bicycle.setVisible(false);
				tip_customer.setVisible(false);
				
				//刷新表格
			    Vector<Vector<Object>> tableValueV= zheKouSetService.getZheKouSetDate(); // 重新读取数据库值;
				Vector<Object> row1 = new Vector<Object>();
				row1.add("1");
				row1.add("");
				row1.add("");
				row1.add("");
				row1.add("");
				if (tableValueV.size() == 1 || tableValueV.size() == 0) {//当没数据时添加一个空白行
					tableValueV.add(row1);
				}

				zheKouSet.getZhekouTablePanel().setTableValueV(tableValueV);
				zheKouSet.add(zheKouSet.getZhekouTablePanel());

				zheKouSet.getZhekouTablePanel().revalidate(); // 重要、、、、、、、、、、、、、、
				zheKouSet.getZhekouTablePanel().repaint();
				
				this.removeZheKouSetPanel();
				
				
			} else if (command.equals("取消")) {
				this.removeZheKouSetPanel();
				zheKouSet.getBtn_add().requestFocus();//增加按钮获得焦点
				
			}
			
		}
		private void removeZheKouSetPanel()
		{
			zheKouSet.removeAll();
			//重新加入组件
			zheKouSet.add(zheKouSet.getLbl_left());
			zheKouSet.add(zheKouSet.getBtn_add());
			zheKouSet.add(zheKouSet.getBtn_delete());
			zheKouSet.add(zheKouSet.getBtn_exit());
			zheKouSet.add(zheKouSet.getBtn_xiugai());
			zheKouSet.add(zheKouSet.getZhekouTablePanel());
			
			zheKouSet.repaint();
		}

	}

	private JComboBox<BicycleType> getCmb_BicycleType() {
		List<BicycleType> b_type_list = zheKouSetService.getAllBicycleType();
		cmb_bicycle_type = new JComboBox<BicycleType>();
		for (BicycleType b_type : b_type_list) {
			if (b_type instanceof BicycleType) {
				cmb_bicycle_type.addItem(b_type);
			}
		}

		return cmb_bicycle_type;
	}

	private JComboBox<CustomerType> getCmb_CustomerType() {
		List<CustomerType> c_type_list = zheKouSetService.getAllCustomerType();
		cmb_cus_type = new JComboBox<CustomerType>();
		for (CustomerType c_type : c_type_list) {
			if (c_type instanceof CustomerType) {
				cmb_cus_type.addItem(c_type);
			}
		}

		return cmb_cus_type;
	}

	public JComboBox<BicycleType> getCmb_bicycle_type() {
		return cmb_bicycle_type;
	}

	public void setCmb_bicycle_type(JComboBox<BicycleType> cmb_bicycle_type) {
		this.cmb_bicycle_type = cmb_bicycle_type;
	}

	public JComboBox<CustomerType> getCmb_cus_type() {
		return cmb_cus_type;
	}

	public void setCmb_cus_type(JComboBox<CustomerType> cmb_cus_type) {
		this.cmb_cus_type = cmb_cus_type;
	}

	public JLabel getLbl_bicycle() {
		return lbl_bicycle;
	}

	public void setLbl_bicycle(JLabel lbl_bicycle) {
		this.lbl_bicycle = lbl_bicycle;
	}

	public JLabel getLbl_bicycle_zhekou() {
		return lbl_bicycle_zhekou;
	}

	public void setLbl_bicycle_zhekou(JLabel lbl_bicycle_zhekou) {
		this.lbl_bicycle_zhekou = lbl_bicycle_zhekou;
	}

	public JLabel getLbl_cus_zhekou() {
		return lbl_cus_zhekou;
	}

	public void setLbl_cus_zhekou(JLabel lbl_cus_zhekou) {
		this.lbl_cus_zhekou = lbl_cus_zhekou;
	}

	public JLabel getLbl_cusstype() {
		return lbl_cusstype;
	}

	public void setLbl_cusstype(JLabel lbl_cusstype) {
		this.lbl_cusstype = lbl_cusstype;
	}

	public JLabel getLbl_title() {
		return lbl_title;
	}

	public void setLbl_title(JLabel lbl_title) {
		this.lbl_title = lbl_title;
	}

	public JPanel getPane_bicycle() {
		return pane_bicycle;
	}

	public void setPane_bicycle(JPanel pane_bicycle) {
		this.pane_bicycle = pane_bicycle;
	}

	public JPanel getPanel_custuer() {
		return panel_custuer;
	}

	public void setPanel_custuer(JPanel panel_custuer) {
		this.panel_custuer = panel_custuer;
	}

	public JTextField getTxt_bicycle_zhekou() {
		return txt_bicycle_zhekou;
	}

	public void setTxt_bicycle_zhekou(JTextField txt_bicycle_zhekou) {
		this.txt_bicycle_zhekou = txt_bicycle_zhekou;
	}

	public JTextField getTxt_cus_zhekou() {
		return txt_cus_zhekou;
	}

	public void setTxt_cus_zhekou(JTextField txt_cus_zhekou) {
		this.txt_cus_zhekou = txt_cus_zhekou;
	}

	public ZheKouSet getZheKouSet() {
		return zheKouSet;
	}

	public void setZheKouSet(ZheKouSet zheKouSet) {
		this.zheKouSet = zheKouSet;
	}

	public ZheKouSetService getZheKouSetService() {
		return zheKouSetService;
	}

	public void setZheKouSetService(ZheKouSetService zheKouSetService) {
		this.zheKouSetService = zheKouSetService;
	}

	public MJLable getTip_bicycle() {
		return tip_bicycle;
	}

	public void setTip_bicycle(MJLable tip_bicycle) {
		this.tip_bicycle = tip_bicycle;
	}

	public MJLable getTip_customer() {
		return tip_customer;
	}

	public void setTip_customer(MJLable tip_customer) {
		this.tip_customer = tip_customer;
	}

	public MButton getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(MButton btn_save) {
		this.btn_save = btn_save;
	}

	public MButton getBtn_cancle() {
		return btn_cancle;
	}

	public void setBtn_cancle(MButton btn_cancle) {
		this.btn_cancle = btn_cancle;
	}

}