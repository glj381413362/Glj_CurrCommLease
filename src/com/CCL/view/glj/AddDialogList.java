package com.CCL.view.glj;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.CCL.panel.glj.xitongguanli.son.AddPanel;
import com.CCL.panel.glj.xitongguanli.son.AddPanelListPanel;

public   class AddDialogList extends JDialog {
	private AddPanelListPanel addPanelListPanel;
	private AddPanel addPanel;
	
	private static AddDialogList instances;
	

	public AddDialogList(final AddPanel addPanel) {
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addPanel = addPanel;
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				addPanel.getjTextField6().requestFocus();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		init();
	}

	public static synchronized AddDialogList getInstances(AddPanel addPanel)
	{
		if(instances==null){
			instances = new AddDialogList(addPanel);
		}
		return instances;
	}
	private void init() {
		
		addPanelListPanel = new AddPanelListPanel("",addPanel);
		addPanelListPanel.setBounds(0, 0, 200, 200);
		this.setContentPane(addPanelListPanel);
		
//		
	}

	public AddPanelListPanel getAddPanelListPanel() {
		return addPanelListPanel;
	}

	public void setAddPanelListPanel(AddPanelListPanel addPanelListPanel) {
		this.addPanelListPanel = addPanelListPanel;
	}

}
