package com.CCL.view.kaitaimgr.subpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.CCL.beans.Bicycle;
import com.CCL.beans.Order;
import com.CCL.view.kaitaimgr.render.BicyclesMapRenderer;
import com.CCL.view.kaitaimgr.service.KaiTaiService;

public class ChangeCarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8332471115840465738L;
	private JList<Order> list_order;
	private JList<Map<Bicycle, Integer>> list_bicycles;
	
	List<Order> orderList = new ArrayList<Order>();
	protected ChangeCarDialog changeCarDialog;
	private Map<Bicycle, Integer> currentBicyclesMap;
	private Order currentOrder;
	
	class SimpleListModel implements ListModel<Order> {

		@Override
		public int getSize() {
			int size = orderList.size();
			return size;
		}

		@Override
		public Order getElementAt(int index) {
			return orderList.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {

		}

		@Override
		public void removeListDataListener(ListDataListener l) {

		}
	}

	/**
	 * Create the panel.
	 */
	public ChangeCarPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				orderList.clear();
				orderList.addAll(KaiTaiService.getAllPreOrder());
				list_order.updateUI();
			}
		});
		setLayout(new BorderLayout(0, 0));
		
		JPanel checkCar = new JPanel();
		add(checkCar);
		checkCar.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		checkCar.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8BA2\u5355\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		splitPane.setLeftComponent(scrollPane);
		
		list_order = new JList<Order>();
		list_order.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Map<Bicycle, Integer> bicyclesMap = list_order.getSelectedValue().getBicyclesMap();
				setCurrentOrder(list_order.getSelectedValue());
				setCurrentBicyclesMap(bicyclesMap);
				list_bicycles.setModel(new BicyclesListModel(bicyclesMap) );
			}
		});
		list_order.setCellRenderer( new SimpleOrderListRender());
		list_order.setModel(new SimpleListModel());
		scrollPane.setViewportView(list_order);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "\u81EA\u884C\u8F66\u8BE6\u60C5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(scrollPane_1);
		
		list_bicycles = new JList<Map<Bicycle, Integer>>();
		list_bicycles.setCellRenderer(new BicyclesMapRenderer());
		scrollPane_1.setViewportView(list_bicycles);
		
		JLabel lblNewLabel = new JLabel("\u6362\u8F66");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkCar.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		checkCar.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (changeCarDialog == null) {
					changeCarDialog = new ChangeCarDialog(ChangeCarPanel.this);
					changeCarDialog.setModal(true);
				}else{
					changeCarDialog.dispose();
					changeCarDialog = new ChangeCarDialog(ChangeCarPanel.this);
					changeCarDialog.setModal(true);
				}
				changeCarDialog.setLocationRelativeTo(null);
				changeCarDialog.setVisible(true);
			}
		});
		panel.add(btnNewButton);

	}
	
	
	public Map<Bicycle, Integer> getCurrentBicyclesMap() {
		return currentBicyclesMap;
	}




	public void setCurrentBicyclesMap(Map<Bicycle, Integer> currentBicyclesMap) {
		this.currentBicyclesMap = currentBicyclesMap;
	}


	class SimpleOrderListRender  extends JPanel implements ListCellRenderer<Order> {
//		ImageIcon BicycleImage = new ImageIcon("images\\MJBtn\\自行车.png");
		JLabel txt_kc = new JLabel("",JLabel.CENTER);
		JLabel txt_name = new JLabel("",JLabel.CENTER);
		JLabel txt_price = new JLabel("",JLabel.CENTER);
		JLabel txt_desc = new JLabel("",JLabel.CENTER);
		JPanel msgPanel = new JPanel(new GridLayout(2, 2));

		public SimpleOrderListRender() {
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//			add(new JLabel(BicycleImage), BorderLayout.WEST);
			msgPanel.add(txt_kc);
			msgPanel.add(txt_name);
			msgPanel.add(txt_price);
			msgPanel.add(txt_desc);
			add(msgPanel);
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Order value, int index, boolean isSelected,
				boolean cellHasFocus) {

			// removeAll();
			txt_kc.setText("编号: " + value.getId());
			txt_name.setText("客户: " + value.getCustomer().getName());
			txt_price.setText("押金: " + value.getDeposit());
			txt_desc.setText("1小时总价: " + KaiTaiService.calcPrice(value,60f));

			Color background;
			Color foreground;

			// check if this cell represents the current DnD drop location
			JList.DropLocation dropLocation = list.getDropLocation();
			if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {

				background = Color.RED;
				foreground = Color.WHITE;

				// check if this cell is selected
			} else if (isSelected) {

				background = Color.BLUE;
				foreground = Color.WHITE;

				// unselected, and not the DnD drop location
			} else {
				background = Color.WHITE;
				foreground = Color.BLACK;
			}
			;

			setBackground(background);
			setForeground(foreground);
			txt_kc.setForeground(foreground);
			txt_name.setForeground(foreground);
			txt_price.setForeground(foreground);
			txt_desc.setForeground(foreground);

			txt_kc.setBackground(background);
			txt_name.setBackground(background);
			txt_price.setBackground(background);
			txt_desc.setBackground(background);

			msgPanel.setBackground(background);
			msgPanel.setForeground(foreground);

			return this;

		}

	}
	
	
	
	
	class BicyclesListModel implements ListModel<Map<Bicycle, Integer>> {

		private List<Map<Bicycle, Integer>> bicyclesList;

		public BicyclesListModel(Map<Bicycle, Integer> bicycmaps) {
			this.bicyclesList = new ArrayList<Map<Bicycle, Integer>>();

			for (Entry<Bicycle, Integer> entry : bicycmaps.entrySet()) {
				HashMap<Bicycle, Integer> newMap = new HashMap<Bicycle, Integer>();
				newMap.put(entry.getKey(), entry.getValue());
				this.bicyclesList.add(newMap);
			}

		}

		@Override
		public int getSize() {
			int size = bicyclesList.size();

			return size;
		}

		@Override
		public Map<Bicycle, Integer> getElementAt(int index) {

			return bicyclesList.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {

		}

		@Override
		public void removeListDataListener(ListDataListener l) {

		}
	}

	public void updateCurrentBicycMap(Map<Bicycle, Integer> bicyclesMap) {
		
		currentOrder.setBicycles(KaiTaiService.converyBicycles2String(bicyclesMap));
		currentOrder.setBicyclesMap(bicyclesMap);
		KaiTaiService.updateOrder(currentOrder);
		setCurrentBicyclesMap(bicyclesMap);
		list_bicycles.setModel(new BicyclesListModel(bicyclesMap) );
		this.updateUI();
		
	}


	public Order getCurrentOrder() {
		return currentOrder;
	}


	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	
	
}