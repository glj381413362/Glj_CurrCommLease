package com.CCL.panel.glj.xitongguanli.son;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.CCL.beans.Bicycle;
import com.CCL.panel.MPanel;

public class AddPanelListPanel extends MPanel {
	private JList Id;
	private AddPanel addPanel;
	private JTable table ;
	public AddPanelListPanel(String imgaeUrl, AddPanel addPanel)
	{
		super(imgaeUrl);
		this.addPanel = addPanel;
		table = new JTable();
		this.setLayout(null);
		init();
		this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void init() {
		
		
		
		List<Bicycle> arraylist =addPanel.getShouFeiSet().getShouFeiSetService().getAllBicycleList();
		Vector bicycleVector =  new Vector() ;
//		Vector<Vector<Object>> listIteam = new  Vector<Vector<Object>>();
		for(int i=0;i<arraylist.size();i++)
		{
			if(arraylist.get(i) instanceof Bicycle)
			{
				String s= arraylist.get(i).toString()+"   车名："+arraylist.get(i).getName();
				
				bicycleVector.addElement(s);
			}
			
		}
		Id = new JList();
		if(bicycleVector!=null)
		{
			Id.setListData(bicycleVector);
			Id.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置list一次只能选择一个列表索引
			Id.setBounds(0, 0, 200, 330);
			Id.setSelectedIndex(0);
			Id.addMouseListener(new MouseAdapter(){  
			    public void mouseClicked(MouseEvent e){  
			        if(e.getClickCount()==2){   //When double click JList  
			        	String value = (String) Id.getSelectedValue();
						String name = value.substring(value.lastIndexOf("：")+1, value.length());
						addPanel.getjTextField6().setText(name);
						addPanel.getAddDialog().getAddpane().getAddDialogList().dispose();//关闭AddDialogList
						//addPanel.getAddDialog().getAddpane().setIsdispose("关闭");
						addPanel.getjTextField2().requestFocus();
			        }  
			    }  
			}); 
		
		}
		this.add(Id);
		
	}

	public JList getId() {
		return Id;
	}

	public void setId(JList id) {
		Id = id;
	}
	
	

}
