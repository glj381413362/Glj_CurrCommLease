package com.CCL.panel.glj.xitongguanli.son;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.CCL.Dao.impl.TestFrame;
import com.CCL.beans.Bicycle;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.ButtonRenderer;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.MPanel;
import com.CCL.service.glj.ShouFeiSetService;
import com.CCL.view.glj.AddDialog;

public class ShouFeiSet extends MPanel {
	private MButton btn_add, btn_delete, btn_save, btn_cancle, btn_exit;
	private FixedColumnTablePanel shouFeiTablePanel;
	private Vector<String> tableColumnV;// 表格头字段
	private Vector<Vector<Object>> tableValueV;// 表格数据
	private MJLable lbl_left;
	private ShouFeiSetService shouFeiSetService;
	private Vector<Object> row1, row2;
	private int xuhao = 1;
	private JPanel sellPanel;

	public ShouFeiSet(String imageUrl, JPanel sellPanel) {
		super(imageUrl);
		this.sellPanel = sellPanel;
		this.setSize(920, 520);
		this.setLayout(null);
		this.setVisible(true);

		init();

	}

	private void init() {
		shouFeiSetService = new ShouFeiSetService();

		lbl_left = new MJLable(new ImageIcon("images/glj/shoufei/shoufeititle1.gif"),253,52);
		lbl_left.setBounds(10, 5, 250, 50);
		btn_add = new MButton("images/MJBtn/tree自行车.png", "增加", 310, 10, 60, 30);
		btn_delete = new MButton("images/MJBtn/tree自行车.png", "删除", 390, 10, 60,
				30);
		btn_exit = new MButton("images/MJBtn/tree自行车.png", "退出", 470, 10, 60,
				30);
		tableColumnV = new Vector<String>();
		tableColumnV.add("序号");
		tableColumnV.add("车类型");
		tableColumnV.add("车名");
		tableColumnV.add("价格");
		tableColumnV.add("基本时间");
		tableColumnV.add("计费时间");
		tableColumnV.add("大于计费时间价格");
		tableColumnV.add("小于计费时间价格");
		tableColumnV.add("是否参加积分");
		tableColumnV.add("是否参加折扣");
		tableColumnV.add("折扣值");

		tableValueV = shouFeiSetService.getAllBicycle(); // 读取数据库值

		row1 = new Vector<Object>();
		row1.add(xuhao);
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
		if (tableValueV.size() == 1 || tableValueV.size() == 0) {// 当没数据时添加一个空白行
			tableValueV.add(row1);
		}

		int[] floatwidth = { 40, 100, 120 };
		int[] fixwidth = { 100, 100, 100, 100, 100, 100, 100 };
		shouFeiTablePanel = new FixedColumnTablePanel(tableColumnV,
				tableValueV, 3, "images/glj/shoufei/72.jpg", floatwidth,
				fixwidth);
		// 设置表格列高度
		shouFeiTablePanel.getFixedColumnTable().setRowHeight(22);
		shouFeiTablePanel.getFloatingColumnTable().setRowHeight(22);
		// 给指定列加入自己的渲染器
		String[] zixingche = { "单人车", "双人车", "四人车" };
		JComboBox com = new JComboBox(zixingche);
		shouFeiTablePanel.getFixedColumnTable().getColumnModel().getColumn(1)
				.setCellEditor(new DefaultCellEditor(com));
		shouFeiTablePanel.getFloatingColumnTable().getColumn("是否参加积分")
				.setCellRenderer(new ButtonRenderer());
		shouFeiTablePanel.getFloatingColumnTable().getColumn("是否参加折扣")
				.setCellRenderer(new ButtonRenderer());

		shouFeiTablePanel.setBounds(10, 70, 560, 420);
		this.add(lbl_left);
		this.add(btn_add);
		this.add(btn_delete);
		this.add(btn_exit);
		btn_add.setActionCommand("增加");
		btn_delete.setActionCommand("删除");
		btn_exit.setActionCommand("退出");
		btn_add.addActionListener(new ActionListener_btn(this));
		btn_delete.addActionListener(new ActionListener_btn(this));
		btn_exit.addActionListener(new ActionListener_btn(this));

		this.add(shouFeiTablePanel);
	}

	class ActionListener_btn implements ActionListener {
		private ShouFeiSet shouFeiSet;
		com.CCL.panel.glj.xitongguanli.son.FixedColumnTablePanel.MTable fixedColumnTable;
		com.CCL.panel.glj.xitongguanli.son.FixedColumnTablePanel.MTable floatingColumnTable;

		public ActionListener_btn(ShouFeiSet shouFeiSet) {

			this.shouFeiSet = shouFeiSet;
			// shouFeiSetService = new ShouFeiSetService();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actioncommand = e.getActionCommand();

			floatingColumnTable = shouFeiSet.getShouFeiTablePanel()
					.getFixedColumnTable();
			if (actioncommand.equals("增加")) {
				xuhao = floatingColumnTable.getRowCount() + 1;
				row2 = new Vector<Object>();
				row2.add(xuhao);
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("");
				row2.add("参加");
				row2.add("参加");
				row2.add("");
				if (!floatingColumnTable.getValueAt(floatingColumnTable.getRowCount() - 1, 2).equals("")) 
				{
					AddDialog adddialog = new AddDialog(shouFeiSet);
					adddialog.setBounds(740, 270, 293, 440);
				}
			} else if (actioncommand.equals("删除")) {

				int floatindex = floatingColumnTable.getSelectedRow();// 获得选择行下标
				if (floatindex > -1) {
					if (floatingColumnTable.getModel().getRowCount() > 1) {
					Bicycle bicycle = null;
					if (floatingColumnTable.getValueAt(floatindex, 2) instanceof Bicycle) {
						bicycle = (Bicycle) floatingColumnTable.getValueAt(
								floatindex, 2);
					}

					if (bicycle != null && floatindex > -1) {

						// 实现逻辑删除
						bicycle.setIsShow(false);
						shouFeiSet.getShouFeiSetService().update(bicycle);
						tableValueV = shouFeiSetService.getAllBicycle(); // 重新读取数据库值;
						row1 = new Vector<Object>();
						row1.add(xuhao);
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
						if (tableValueV.size() == 1 || tableValueV.size() == 0) {// 当没数据时添加一个空白行
							tableValueV.add(row1);
						}
						
						shouFeiTablePanel.setTableValueV(tableValueV);
						shouFeiSet.add(shouFeiTablePanel);

						shouFeiTablePanel.revalidate(); // 重要、、、、、、、、、、、、、、
						shouFeiTablePanel.repaint();

					}
				}
				}
			} 
			else if (actioncommand.equals("退出")) {
				sellPanel.removeAll();
				sellPanel.repaint();
				
			}
		}

	}

	public FixedColumnTablePanel getShouFeiTablePanel() {
		return shouFeiTablePanel;
	}

	public void setShouFeiTablePanel(FixedColumnTablePanel shouFeiTablePanel) {
		this.shouFeiTablePanel = shouFeiTablePanel;
	}

	public ShouFeiSetService getShouFeiSetService() {
		return shouFeiSetService;
	}

	public void setShouFeiSetService(ShouFeiSetService shouFeiSetService) {
		this.shouFeiSetService = shouFeiSetService;
	}

}
