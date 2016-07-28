package com.CCL.view.other;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

import com.CCL.view.other.son.SMS_alerts;

import java.awt.BorderLayout;

public class OtherManager extends JPanel {

	/**
	 * Create the panel.
	 */
	public OtherManager() {
		setLayout(null);
		
		sms_Alerts = new SMS_alerts();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 860, 576);
		tabbedPane.addTab("∂Ã–≈Ã·–—≈‰÷√", sms_Alerts);
		add(tabbedPane);

	}
	
private SMS_alerts sms_Alerts;
}
