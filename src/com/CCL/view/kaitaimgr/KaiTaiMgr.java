package com.CCL.view.kaitaimgr;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.CCL.view.MainFrame;
import com.CCL.view.kaitaimgr.subpanel.ChangeCarPanel;
import com.CCL.view.kaitaimgr.subpanel.CheckOutPanel;
import com.CCL.view.kaitaimgr.subpanel.KaiTaiPanel;

import java.awt.BorderLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class KaiTaiMgr extends JPanel {
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public KaiTaiMgr() {
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				JPanel panel = (JPanel) tabbedPane.getSelectedComponent();
				int selectedIndex = tabbedPane.getSelectedIndex();
				String panelTitle = tabbedPane.getTitleAt(selectedIndex);
				
				MainFrame.getFristLabel().setText(panelTitle);
			}
		});
		add(tabbedPane);
		
		KaiTaiPanel panel = new KaiTaiPanel();
		tabbedPane.addTab("\u5F00\u53F0", null, panel, null);
		
		CheckOutPanel panel_1 = new CheckOutPanel();
		tabbedPane.addTab("\u7ED3\u8D26", null, panel_1, null);
		
		ChangeCarPanel panel_2 = new ChangeCarPanel();
		tabbedPane.addTab("\u6362\u8F66", null, panel_2, null);

	}

}
