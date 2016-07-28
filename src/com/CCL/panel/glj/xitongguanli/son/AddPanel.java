/*
 * AddPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.CCL.panel.glj.xitongguanli.son;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.MPanel;
import com.CCL.view.glj.AddDialog;
import com.CCL.view.glj.AddDialogList;

/**
 * 
 * @author __USER__
 */
public final class AddPanel extends MPanel {
	private MButton btn_save;
	private MButton jButton2;
	private javax.swing.JComboBox jComboBox1, combox_dazhe, combox_jifen;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private MJLable jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9, lbl_jifen, lbl_dazhe;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private ShouFeiSet shouFeiSet;
	private AddDialog addDialog;
	private AddDialogList addDialogList = null;
	private String isdispose = "关闭";

	private BicycleType bicycleType1, bicycleType2, bicycleType3;

	/**
	 * Creates new form AddPanel
	 * 
	 * @param addDialog
	 */

	public AddPanel(String imageUrl, ShouFeiSet shouFeiSet, AddDialog addDialog) {
		// TODO Auto-generated constructor stub
		super(imageUrl);
		this.shouFeiSet = shouFeiSet;
		this.addDialog = addDialog;
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel4 = new MJLable("images/glj/shoufei/addtitle.gif",217,51);
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		lbl_jifen = new JLabel("   是  否  积  分  ：");
		lbl_dazhe = new JLabel("   是  否  打  折  ：");
		jComboBox1 = this.getCmb_BicycleType();
		combox_dazhe = new javax.swing.JComboBox();
		combox_dazhe.addItem("参加");
		combox_dazhe.addItem("不参加");
		combox_jifen = new javax.swing.JComboBox();
		combox_jifen.addItem("参加");
		combox_jifen.addItem("不参加");
		jTextField1 = new javax.swing.JTextField("0");
		jTextField2 = new javax.swing.JTextField("0");
		jTextField3 = new javax.swing.JTextField("0");
		jTextField4 = new javax.swing.JTextField("0");
		jTextField5 = new javax.swing.JTextField("0");
		jTextField6 = new javax.swing.JTextField("0");
		jTextField7 = new javax.swing.JTextField("0");
		
		btn_save = new MButton("images/glj/ButtonImages/btn_suer_off.jpg");
		btn_save.setPressedIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_suer_on.png"));
		btn_save.setRolloverIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_suer_on.png"));
		btn_save.setBounds(30, 380, 103, 30);
		jButton2 = new MButton("images/glj/ButtonImages/btn_cancle_off.png");
		jButton2.setPressedIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_cancle_on.png"));
		jButton2.setRolloverIcon(new ImageIcon(
				"images/glj/ButtonImages/btn_cancle_on.png"));
		jButton2.setBounds(160, 380, 103, 30);
//		
//		btn_save = new MButton("images/glj/ButtonImages/btn_suer_off.jpg");
//		btn_save.setPressedIcon(new ImageIcon("images/glj/ButtonImages/btn_suer_on.jpg"));
//		btn_save.setBounds(51, 380, 79, 21);
//
//		jButton2 = new MButton("images/glj/ButtonImages/btn_cancle_off.png");
//		jButton2.setPressedIcon(new ImageIcon("images/glj/ButtonImages/btn_cancle_on.png"));
//		jButton2.setBounds(160, 380, 59, 25);

		setLayout(null);

		jLabel1.setText("      \u6298   \u6263   \u503c   \uff1a");
		add(jLabel1);
		jLabel1.setBounds(20, 280, 110, 17);

//		jLabel4.setText("\u5927\u4e8e\u8ba1\u8d39\u65f6\u95f4\u4ef7\u683c\uff1a");
		add(jLabel4);
		jLabel4.setBounds(40, 10, 217, 51);

		jLabel5.setText("   \u8f66    \u7c7b    \u578b    \uff1a");
		add(jLabel5);
		jLabel5.setBounds(20, 100, 110, 17);

		jLabel6.setText("   \u57fa  \u672c  \u65f6  \u95f4   \uff1a");
		add(jLabel6);
		jLabel6.setBounds(20, 160, 110, 17);

		jLabel7.setText("        \u4ef7       \u683c   \uff1a");
		add(jLabel7);
		jLabel7.setBounds(20, 130, 110, 17);

		jLabel8.setText("   \u8ba1  \u8d39  \u65f6  \u95f4   \uff1a");
		add(jLabel8);
		jLabel8.setBounds(20, 190, 110, 17);

		jLabel9.setText("\u5927\u4e8e\u8ba1\u8d39\u65f6\u95f4\u4ef7\u683c\uff1a");
		add(jLabel9);
		jLabel9.setBounds(20, 220, 110, 17);

		jLabel10.setText("小于计费时间价格:");
		add(jLabel10);
		jLabel10.setBounds(20, 250, 110, 17);

		jLabel2.setText("       车       名      ：  ");
		add(jLabel2);
		jLabel2.setBounds(20, 70, 110, 17);

		// jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]
		// {
		// "单人车", "双人车", "Item 3", "Item 4" }));
		add(jComboBox1);
		jComboBox1.setBounds(140, 100, 110, 23);

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		add(jTextField1);
		jTextField1.setBounds(140, 190, 110, 23);

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});
		add(jTextField2);
		jTextField2.setBounds(140, 130, 110, 23);

		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});
		add(jTextField3);
		jTextField3.setBounds(140, 220, 110, 23);

		jTextField4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField4ActionPerformed(evt);
			}
		});
		add(jTextField4);
		jTextField4.setBounds(140, 250, 110, 23);

		jTextField5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField5ActionPerformed(evt);
			}
		});
		add(jTextField5);
		jTextField5.setBounds(140, 280, 110, 23);
		
		jTextField6.getDocument().addDocumentListener (new Swing_OnValueChanged (this));
		
		jTextField6.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) // 按下enter键
				{
					if (jTextField6.getText().trim().length() == 0) {
						Object[] options = { "OK", "CANCEL" };
						JOptionPane.showOptionDialog(null,
								"Click OK to continue", "Warning",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

					}
					String value = (String) addDialogList
							.getAddPanelListPanel().getId().getSelectedValue();
					int id = Integer.valueOf(value.substring(0, 1));
					int typeId = AddPanel.this.getShouFeiSet()
							.getShouFeiSetService().get(id).getType().getId();// 获得自行车类型
					jComboBox1.setSelectedIndex(typeId - 1);
//					jComboBox1.setEditable(false);
					jComboBox1.setEnabled(false);
					
					
					String name = value.substring(value.lastIndexOf("：")+1, value.length());
					jTextField6.setText(name);

				} else {
					String input = jTextField6.getText().trim(); // 车名输入
					List<Bicycle> bicycle = AddPanel.this.getShouFeiSet()
							.getShouFeiSetService().getAllByLikeName(input);// 模糊查询车名
					Vector<String> bicycleVector = new Vector<String>();
					for (int i = 0; i < bicycle.size(); i++) {
						if (bicycle.get(i) instanceof Bicycle) {
							String s = bicycle.get(i).toString() + "  车名："
									+ bicycle.get(i).getName();
							bicycleVector.addElement(s);
						}

					}
					// 更新list
					addDialogList.getAddPanelListPanel().getId()
							.setListData(bicycleVector);
					addDialogList.getAddPanelListPanel().getId().revalidate();
					addDialogList.getAddPanelListPanel().getId().repaint();
					addDialogList.getAddPanelListPanel().getId()
							.setSelectedIndex(0);

				}
			}

		});
		jTextField6.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String value = (String) addDialogList
						.getAddPanelListPanel().getId().getSelectedValue();
				if(value!=null)
				{
					String name = value.substring(value.lastIndexOf("：")+1, value.length());
					jTextField6.setText(name);
						jTextField6.setText(name);
						
				}else{
					if(jTextField6.getText().trim()!=null)
					{
						JOptionPane.showMessageDialog(null, "请选择已存在的车名", "注意", JOptionPane.ERROR_MESSAGE); 
						jTextField6.requestFocus();
					}
				}
				
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (isdispose.equals("关闭")) {
					addDialogList = new AddDialogList(AddPanel.this);
					addDialogList.setAlwaysOnTop(true);
					isdispose = "打开";
					addDialogList.setBounds(1027, 340, 200, 330);
					addDialogList.setUndecorated(true);
					// addDialogList.setModal(true);
					addDialogList.setVisible(true);
				}
			}
		});
		jTextField6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField6ActionPerformed(evt);
			}
		});
		add(lbl_dazhe);
		lbl_dazhe.setBounds(20, 340, 110, 23);
		add(combox_dazhe);
		combox_dazhe.setBounds(140, 340, 110, 23);

		add(lbl_jifen);
		lbl_jifen.setBounds(20, 310, 110, 23);
		add(combox_jifen);
		combox_jifen.setBounds(140, 310, 110, 23);

		add(jTextField6);
		jTextField6.setBounds(140, 70, 110, 23);

		jTextField7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField7ActionPerformed(evt);
			}
		});
		add(jTextField7);
		jTextField7.setBounds(140, 160, 110, 23);

//		btn_save.setText("\u786e\u5b9a");
		btn_save.setActionCommand("确定");
		btn_save.addActionListener(new ActionListener_btn(this));
		add(btn_save);
		
//		jButton2.setText("\u53d6\u6d88");
		jButton2.setActionCommand("取消");
		jButton2.addActionListener(new ActionListener_btn(this));
		add(jButton2);
//		jButton2.setBounds(160, 380, 57, 25);
	}// </editor-fold>
	//根据接口TextListener定义新AWT_OnValue
     class AWT_OnValueChanged implements TextListener
     {
         public void textValueChanged(TextEvent e)  { //输出变化及结果
}
} 
     class Swing_OnValueChanged implements DocumentListener {

    	 private AddPanel addPanel;
		public Swing_OnValueChanged(AddPanel addPanel) {
			this.addPanel=addPanel;
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
//			if (isdispose.equals("关闭")) {
//				addDialogList = new AddDialogList(AddPanel.this);
//				addDialogList.setAlwaysOnTop(true);
//				isdispose = "打开";
//				addDialogList.setBounds(445, 22, 200, 330);
//				addDialogList.setUndecorated(true);
//				// addDialogList.setModal(true);
//				addDialogList.setVisible(true);
//			}
//		
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}//输出变化及结果

     }
	public javax.swing.JComboBox getCombox_dazhe() {
		return combox_dazhe;
	}

	public void setCombox_dazhe(javax.swing.JComboBox combox_dazhe) {
		this.combox_dazhe = combox_dazhe;
	}

	public javax.swing.JComboBox getCombox_jifen() {
		return combox_jifen;
	}

	public void setCombox_jifen(javax.swing.JComboBox combox_jifen) {
		this.combox_jifen = combox_jifen;
	}

	public javax.swing.JLabel getLbl_jifen() {
		return lbl_jifen;
	}

	public void setLbl_jifen(javax.swing.JLabel lbl_jifen) {
		this.lbl_jifen = lbl_jifen;
	}

	public javax.swing.JLabel getLbl_dazhe() {
		return lbl_dazhe;
	}

	public void setLbl_dazhe(javax.swing.JLabel lbl_dazhe) {
		this.lbl_dazhe = lbl_dazhe;
	}

	// GEN-END:initComponents
	class ActionListener_btn implements ActionListener {

		private AddPanel addPanel;

		public ActionListener_btn(AddPanel addPanel) {
			// TODO Auto-generated constructor stub
			this.addPanel = addPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			if (command.equals("确定")) {
				if (jTextField6.getText().trim().length() == 0) {
					Object[] options = { "OK", "CANCEL" };
					JOptionPane.showOptionDialog(null, "Click OK to continue",
							"Warning", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
				} else {
					String value = (String) addDialogList
							.getAddPanelListPanel().getId().getSelectedValue();
					String [] strArray = value.split(" ");
					System.out.println("aaaa"+strArray[0]+"a");
//					int id = Integer.valueOf(value.substring(0, 1));
					int id = Integer.valueOf(strArray[0]);
					String chargetime = addPanel.getjTextField1().getText()
							.trim();//
					BicycleType bstatye = (BicycleType) addPanel
							.getjComboBox1().getSelectedItem();//
					String price = addPanel.getjTextField2().getText().trim();//
					String overtimeRMB = addPanel.getjTextField3().getText()
							.trim();//
					String littiletimeRMB = addPanel.getjTextField4().getText()
							.trim();//
					String zhekou = addPanel.getjTextField5().getText().trim();//
					String name = addPanel.getjTextField6().getText().trim();//
					String basetime = addPanel.getjTextField7().getText()
							.trim();
					String jifentemp = (String) addPanel.getCombox_jifen()
							.getSelectedItem();//
					int jifen = 1;
					if (!jifentemp.equals("参加")) {
						jifen = 0;
					}

					String dazhetemp = (String) addPanel.getCombox_dazhe()
							.getSelectedItem();
					int dazhe = 1;
					if (!dazhetemp.equals("参加")) {
						dazhe = 0;
					}

					Bicycle bicycle = AddPanel.this.getShouFeiSet()
							.getShouFeiSetService().get(id);// new Bicycle();
					// bicycle.setName(name);
					 bicycle.setIsShow(true);
					bicycle.setPrice(Integer.valueOf(price));
					bicycle.setBaseTime(Integer.valueOf(basetime));
					bicycle.setChargeTime(Integer.valueOf(chargetime));
					bicycle.setOverTimePrice(Integer.valueOf(overtimeRMB));
					bicycle.setIsJiFen(Integer.valueOf(jifen));
					bicycle.setIsDaZhe(Integer.valueOf(dazhe));
System.out.println(bicycle.getName());
					if (shouFeiSet.getShouFeiSetService().update(bicycle)) {
						addDialogList.dispose();//关闭AddDialogList
						addDialog.dispose();
						System.out.println("chenggong");
					}
					shouFeiSet.getShouFeiSetService().getAllBicycle();
					Vector<Vector<Object>> tableValueV = shouFeiSet.getShouFeiSetService().getAllBicycle(); // 重新读取数据库值;
					shouFeiSet.getShouFeiTablePanel().setTableValueV(tableValueV);
					shouFeiSet.add(shouFeiSet.getShouFeiTablePanel());

					shouFeiSet.getShouFeiTablePanel().revalidate(); // 重要、、、、、、、、、、、、、、
					shouFeiSet.getShouFeiTablePanel().repaint();
					
				}

			} else if (command.equals("取消")) {
				if(isdispose.equals("打开"))
				{
				 addDialogList.dispose(); //关闭AddDialogList
				 isdispose="关闭";
				}
				addDialog.dispose();
			}
		}

	}

	private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
	private JComboBox<BicycleType> getCmb_BicycleType() {
		List<BicycleType> b_type_list = shouFeiSet.getShouFeiSetService().getAllBicycleType();
		jComboBox1 = new JComboBox<BicycleType>();
		for (BicycleType b_type : b_type_list) {
			if (b_type instanceof BicycleType) {
				jComboBox1.addItem(b_type);
			}
		}

		return jComboBox1;
	}
	public javax.swing.JButton getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(MButton btn_save) {
		this.btn_save = btn_save;
	}

	public MButton getjButton2() {
		return jButton2;
	}

	public void setjButton2(MButton jButton2) {
		this.jButton2 = jButton2;
	}

	public javax.swing.JComboBox getjComboBox1() {
		return jComboBox1;
	}

	public void setjComboBox1(javax.swing.JComboBox jComboBox1) {
		this.jComboBox1 = jComboBox1;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JLabel getjLabel10() {
		return jLabel10;
	}

	public void setjLabel10(javax.swing.JLabel jLabel10) {
		this.jLabel10 = jLabel10;
	}

	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}

	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public javax.swing.JLabel getjLabel4() {
		return jLabel4;
	}

	public void setjLabel4(MJLable jLabel4) {
		this.jLabel4 = jLabel4;
	}

	public javax.swing.JLabel getjLabel5() {
		return jLabel5;
	}

	public void setjLabel5(javax.swing.JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}

	public javax.swing.JLabel getjLabel6() {
		return jLabel6;
	}

	public void setjLabel6(javax.swing.JLabel jLabel6) {
		this.jLabel6 = jLabel6;
	}

	public javax.swing.JLabel getjLabel7() {
		return jLabel7;
	}

	public void setjLabel7(javax.swing.JLabel jLabel7) {
		this.jLabel7 = jLabel7;
	}

	public javax.swing.JLabel getjLabel8() {
		return jLabel8;
	}

	public void setjLabel8(javax.swing.JLabel jLabel8) {
		this.jLabel8 = jLabel8;
	}

	public javax.swing.JLabel getjLabel9() {
		return jLabel9;
	}

	public void setjLabel9(javax.swing.JLabel jLabel9) {
		this.jLabel9 = jLabel9;
	}

	public javax.swing.JTextField getjTextField1() {
		return jTextField1;
	}

	public void setjTextField1(javax.swing.JTextField jTextField1) {
		this.jTextField1 = jTextField1;
	}

	public javax.swing.JTextField getjTextField2() {
		return jTextField2;
	}

	public void setjTextField2(javax.swing.JTextField jTextField2) {
		this.jTextField2 = jTextField2;
	}

	public javax.swing.JTextField getjTextField3() {
		return jTextField3;
	}

	public void setjTextField3(javax.swing.JTextField jTextField3) {
		this.jTextField3 = jTextField3;
	}

	public javax.swing.JTextField getjTextField4() {
		return jTextField4;
	}

	public void setjTextField4(javax.swing.JTextField jTextField4) {
		this.jTextField4 = jTextField4;
	}

	public javax.swing.JTextField getjTextField5() {
		return jTextField5;
	}

	public void setjTextField5(javax.swing.JTextField jTextField5) {
		this.jTextField5 = jTextField5;
	}

	public javax.swing.JTextField getjTextField6() {
		return jTextField6;
	}

	public void setjTextField6(javax.swing.JTextField jTextField6) {
		this.jTextField6 = jTextField6;
	}

	public javax.swing.JTextField getjTextField7() {
		return jTextField7;
	}

	public void setjTextField7(javax.swing.JTextField jTextField7) {
		this.jTextField7 = jTextField7;
	}

	public ShouFeiSet getShouFeiSet() {
		return shouFeiSet;
	}

	public void setShouFeiSet(ShouFeiSet shouFeiSet) {
		this.shouFeiSet = shouFeiSet;
	}

	public AddDialog getAddDialog() {
		return addDialog;
	}

	public void setAddDialog(AddDialog addDialog) {
		this.addDialog = addDialog;
	}

	public BicycleType getBicycleType1() {
		return bicycleType1;
	}

	public void setBicycleType1(BicycleType bicycleType1) {
		this.bicycleType1 = bicycleType1;
	}

	public BicycleType getBicycleType2() {
		return bicycleType2;
	}

	public void setBicycleType2(BicycleType bicycleType2) {
		this.bicycleType2 = bicycleType2;
	}

	public BicycleType getBicycleType3() {
		return bicycleType3;
	}

	public void setBicycleType3(BicycleType bicycleType3) {
		this.bicycleType3 = bicycleType3;
	}

	public AddDialogList getAddDialogList() {
		return addDialogList;
	}

	public void setAddDialogList(AddDialogList addDialogList) {
		this.addDialogList = addDialogList;
	}

	public String getIsdispose() {
		return isdispose;
	}

	public void setIsdispose(String isdispose) {
		this.isdispose = isdispose;
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify

	// End of variables declaration//GEN-END:variables

}