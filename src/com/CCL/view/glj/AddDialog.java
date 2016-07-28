package com.CCL.view.glj;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;

import com.CCL.panel.glj.xitongguanli.son.AddPanel;
import com.CCL.panel.glj.xitongguanli.son.ShouFeiSet;

public  final class AddDialog extends JDialog{
	
	private static AddPanel addpane;
	private ShouFeiSet shouFeiSet;

	public AddDialog(ShouFeiSet shouFeiSet) {
		this.shouFeiSet = shouFeiSet;
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setBounds(497, 230, 293, 440);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				addpane.getjLabel1().requestFocus();
				addpane.getjTextField1().requestFocus();
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
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
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
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("zhend");
			}
		});
		init();
		this.setVisible(true);
	}

	/**
	 * 
	 */
	private void init() {
		addpane = new AddPanel("images/glj/shoufei/addimages.png",shouFeiSet,this);
		addpane.setBounds(0, 0, 293, 440);
		this.setContentPane(addpane);
//		this.setModal(true);
		this.setUndecorated(true);
	}
	

	public static AddPanel getAddpane() {
		return addpane;
	}

	public void setAddpane(AddPanel addpane) {
		this.addpane = addpane;
	}

	public ShouFeiSet getShouFeiSet() {
		return shouFeiSet;
	}

	public void setShouFeiSet(ShouFeiSet shouFeiSet) {
		this.shouFeiSet = shouFeiSet;
	}

}
