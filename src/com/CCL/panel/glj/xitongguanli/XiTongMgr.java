package com.CCL.panel.glj.xitongguanli;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.CCL.panel.MPanel;
import com.CCL.panel.ProgressPanel;
import com.CCL.panel.glj.xitongguanli.son.RiYinYeSelect;
import com.CCL.panel.glj.xitongguanli.son.ShouFeiSet;
import com.CCL.panel.glj.xitongguanli.son.XiaoShouQuShi;
import com.CCL.panel.glj.xitongguanli.son.ZhangDanMingXiSelect;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet;
import com.CCL.panel.mlf.Opanel_opeuser_set;
import com.CCL.panel.mlf.Panel_setvehicle;
import com.CCL.panel.mlf.panel_UserAuthorzatiom;
import com.CCL.service.glj.OpeperSelect;
import com.CCL.view.MainFrame;
import com.CCL.view.other.OtherManager;

public class XiTongMgr extends JPanel{
	private JPanel sellPanel;
	private JTabbedPane tabbedPane , tabbed_zhangdangmgr;
	private MainFrame mainFrame;
	public XiTongMgr(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.sellPanel =mainFrame.getSellPanel();
		setLayout(new BorderLayout(0, 0));
		
		 tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane);
		
		ShouFeiSet panel = new ShouFeiSet("images/glj/shoufei/72.jpg",sellPanel);
		if(!OpeperSelect.preJudge("�շ�����"))
		{
			Component[] com = panel.getComponents();
			panel.getShouFeiTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("�շ�����", null, panel, null);
		
		ZheKouSet panel_1 = new ZheKouSet("images/glj/shoufei/72.jpg",sellPanel);
		if(!OpeperSelect.preJudge("�ۿ�����"))
		{
			Component[] com = panel_1.getComponents();
			panel_1.getZhekouTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("�ۿ�����", null, panel_1, null);
		
		tabbed_zhangdangmgr = new JTabbedPane(JTabbedPane.TOP);
		tabbed_zhangdangmgr.setOpaque(false);
		RiYinYeSelect panel_21 = new RiYinYeSelect("images/glj/shoufei/72.jpg",sellPanel);
		if(!OpeperSelect.preJudge("��Ӫҵ��ѯ"))
		{
			Component[] com = panel_21.getComponents();
			panel_21.getRiYinYeTablePanel().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbed_zhangdangmgr.addTab("��Ӫҵ��ѯ", null, panel_21, null);
		ZhangDanMingXiSelect panel_22 = new ZhangDanMingXiSelect("images/glj/shoufei/72.jpg",sellPanel);
		if(!OpeperSelect.preJudge("�˵���ϸ��ѯ"))
		{
			Component[] com = panel_22.getComponents();
			panel_22.getZhangdanmingxi().setEnabled(false);
//			panel_22.getRadPanel().setEnabled(false);
			panel_22.getRad_all().setEnabled(false);
			panel_22.getRad_huiyuan().setEnabled(false);
			panel_22.getRad_putong().setEnabled(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbed_zhangdangmgr.addTab("�˵���ϸ��ѯ", null, panel_22, null);
		XiaoShouQuShi panel_23 = new XiaoShouQuShi("images/glj/shoufei/72.jpg",sellPanel);
		panel_23.setName("�������Ʒ���");
		if(!OpeperSelect.preJudge("�������Ʒ���"))
		{
//			Component[] com = panel_23.getComponents();
//			for (Component component : com) {
//				component.setEnabled(false);
//			}
		}
		tabbed_zhangdangmgr.addTab("�������Ʒ���", null, panel_23, null);
		tabbedPane.addTab("�˵�����", null, tabbed_zhangdangmgr, null);
		
		
		Panel_setvehicle panel_4 = new Panel_setvehicle();
		if(!OpeperSelect.preJudge("�˵���ϸ��ѯ"))
		{
			Component[] com = panel_4.getComponents();
			panel_4.getTab_vehicleinfo().setEnabled(false);
			panel_4.getBtn_vrhicle_add().setVisible(false);
			panel_4.getBtn_Vehicle_search().setVisible(false);
			for (Component component : com) {
				component.setEnabled(false);
			}
		}
		tabbedPane.addTab("��������", null, panel_4, null);
		
		tabbed_zhangdangmgr.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {

				int selectedIndex = tabbed_zhangdangmgr.getSelectedIndex();
				String panelTitle = tabbed_zhangdangmgr.getTitleAt(selectedIndex);
				System.out.println(panelTitle);
				mainFrame.getFristLabel().setText(panelTitle);
				if(!OpeperSelect.preJudge(panelTitle))
				{
					JOptionPane.showMessageDialog(null, "��û��"+panelTitle+"��Ȩ��", "����", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
	
	
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabbedPane.getSelectedIndex();
					String title = tabbedPane.getTitleAt(selectedIndex);
				mainFrame.getFristLabel().setText(title);
				System.out.println(title);
					if(!OpeperSelect.preJudge(title))
					{
						JOptionPane.showMessageDialog(null, "��û��"+title+"��Ȩ��", "����", JOptionPane.ERROR_MESSAGE); 
					}
				}
		});
	}
	public JPanel getSellPanel() {
		return sellPanel;
	}
	public void setSellPanel(JPanel sellPanel) {
		this.sellPanel = sellPanel;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	public JTabbedPane getTabbed_zhangdangmgr() {
		return tabbed_zhangdangmgr;
	}
	public void setTabbed_zhangdangmgr(JTabbedPane tabbed_zhangdangmgr) {
		this.tabbed_zhangdangmgr = tabbed_zhangdangmgr;
	}

}
