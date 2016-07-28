package com.CCL.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import sun.misc.Resource;

import com.CCL.model.MTree_fuzhuang;
import com.CCL.model.MTree_zixingche;
import com.CCL.mwing.MJLable;
import com.CCL.mwing.glj.MButton;
import com.CCL.panel.BGPanel;
import com.CCL.panel.CalenderPanel;
import com.CCL.panel.Clockpael;
import com.CCL.panel.GlassButton;
import com.CCL.panel.MPanel;
import com.CCL.panel.MemberManagePanel;
import com.CCL.panel.ProgressPanel;
import com.CCL.panel.SmallScrollPanel;
import com.CCL.panel.glj.qita.Other;
import com.CCL.panel.glj.xitongguanli.XiTongMgr;
import com.CCL.panel.glj.xitongguanli.son.AddPanel;
import com.CCL.panel.glj.xitongguanli.son.MenuPanel;
import com.CCL.panel.glj.xitongguanli.son.RiYinYeSelect;
import com.CCL.panel.glj.xitongguanli.son.ShouFeiSet;
import com.CCL.panel.glj.xitongguanli.son.ZheKouSet;
import com.CCL.panel.mlf.Panel_setvehicle;
import com.CCL.util.mlf.PublicDate;
import com.CCL.view.huiyuan.VipManager;
import com.CCL.view.kaitaimgr.KaiTaiMgr;
import com.CCL.view.other.OtherManager;


public class MainFrame extends JFrame {
	private final static int WIDTH=1346;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20;
	private final static int HEIGTH=688;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-80;
	
	private JSplitPane SpaneA,SpaneA2;
	private JPanel paneA1,paneA2,paneA2a,paneA2b;
	
	private JSplitPane SpaneA2a;
	private JPanel paneA2a1,paneA2a2;//  paneA2a2放日历
	
	private JSplitPane SpaneA2a1;  //放表和状态
	private JPanel paneA2a1a,paneA2a1b;
	
	private String whoShown;
	
	public JPanel getSellPanel() {
		return sellPanel;
	}

	public static TrayIcon trayicon;
	private SmallScrollPanel smallPanel;//移动面板
	/////////////////////////////////////////////////
	private BGPanel backPanel;
	private static JLabel fristLabel;
	private SmallScrollPanel moduleButtonGroup = null;
	private BGPanel jPanel = null;
	private ButtonGroup buttonGroup = null;
	private GlassButton qichebtn = null;
	private GlassButton fangzibtn = null;
	private GlassButton fuzhuangbtn = null;
	private GlassButton bookspaceButton = null;
	private GlassButton zixingchebtn = null;
	private GlassButton dianzishebeibtn = null;
	private GlassButton jianzugongjubtn = null;
	private JPanel panel_1;
	private  JPanel panel;
	private final JPanel sellPanel = new JPanel();
	private MButton btn_exit,btn_zuida,btn_help;
	private MJLable mainR;
	private MenuPanel menuPanel;
	private JFrame frame ;
	 private JTree zixingchetree,fuzhuangtree;
	 private JLabel label_1 = new JLabel("您当前的位置是:");
	///////////////////////////////////////////
	
	public MainFrame() throws MalformedURLException
	{
		this.setName("主窗体");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, WIDTH, HEIGTH);
		//this.setIconImage(new ImageIcon("image/ImageDialog.png").getImage());//设置窗体左上角图标
		initCom();
		initAction();
		
		this.setVisible(true);
		
	}

	private void initCom() throws MalformedURLException {
		fristLabel = new JLabel("");
		whoShown = "主窗体";
		
		 panel_1 = new JPanel();
		    panel_1.setLayout(null);
		
		paneA1 = new MPanel("images/背景up.jpg");
		paneA1.setLayout(null);
		paneA1.setSize(500, 100);
		
		MJLable titleImage = new MJLable("images/jpanel/calendar.jpg", 263, 90);
		titleImage.setBounds(0, 0, 293, 90);
		
		MJLable ImageR = new MJLable("images/背景up_r_lbl.gif", 350, 90);
		ImageR.setBounds(1000, 0, 383, 90);
		
		smallPanel = new SmallScrollPanel();//"images/jpanel/主背景.jpg");
		smallPanel.setBounds(328, 10, 363, 69);
		
		paneA1.add(ImageR);
//		paneA1.add(titleImage);
		/////////////////
		paneA1.add(getModuleButtonGroup());
		paneA2 = new JPanel();
		
		paneA2a = new JPanel();
		paneA2b = new MPanel("images/背景down.jpg");/////////////////////////////////////////////////////////
	    mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
		mainR.setBounds(780, 340, 300, 300);
		paneA2b.add(mainR);
		
		//添加右下角面板
		paneA2b.setLayout(null);
		backPanel=getZixingCheContentPanel("",this);
		paneA2a1 = new JPanel();
		paneA2a2 = new JPanel();
		
		paneA2a1b = new MPanel("images/jpanel/caltitle.jpg");// 你好，***已登录
		
		SpaneA = new JSplitPane();
		SpaneA2 = new JSplitPane();
		SpaneA2a = new JSplitPane();
		SpaneA2a1 = new JSplitPane();
		
		//以下是向SpaneA2a1a添加表
		Clockpael cp=new Clockpael(-47,-50);
		//放表
		SpaneA2a1.setOneTouchExpandable(true);//是分隔面板的分隔条显示出箭头
		SpaneA2a1.setContinuousLayout(true);
		SpaneA2a1.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA2a1.setLeftComponent(cp);
		SpaneA2a1.setRightComponent(paneA2a1b);
		SpaneA2a1.setOrientation(JSplitPane.VERTICAL_SPLIT);//设置为水平分隔
		SpaneA2a1.setDividerSize(3);//设置分割条大小
		SpaneA2a1.setDividerLocation(290);
		SpaneA2a1.setEnabled(false);//设置分割线不可移动
		
		//以下是向SpaneA2a添加日历
		JLabel label = new JLabel();
        CalenderPanel CalPanel = new CalenderPanel(label,this);
        String info = "<html><body><font color=#FFFFFF>你 好：</font><font color=yellow><b>" + 
        	      PublicDate.getOuser().getUserName() + "</b></font>" + 
        	      "<font color=#FFFFFF>                欢 迎 登 录</font>" + "</body></html>";
	    JLabel labeltip = new JLabel(info);
	    labeltip.setBounds(45, 210, 128, 35);
	    paneA2a1b.add(labeltip);
        /////////////////////
        //放日历
		SpaneA2a.setOneTouchExpandable(true);//是分隔面板的分隔条显示出箭头
		SpaneA2a.setContinuousLayout(true);
		SpaneA2a.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA2a.setLeftComponent(SpaneA2a1);
		SpaneA2a.setRightComponent(CalPanel);
		SpaneA2a.setOrientation(JSplitPane.VERTICAL_SPLIT);//设置为水平分隔
		SpaneA2a.setDividerSize(3);//设置分割条大小
		SpaneA2a.setDividerLocation(360);
		SpaneA2a.setEnabled(false);//设置分割线不可移动
		
		SpaneA2.setOneTouchExpandable(true);//是分隔面板的分隔条显示出箭头
		SpaneA2.setContinuousLayout(true);
		SpaneA2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//设置为水平分隔
		SpaneA2.setDividerSize(3);//设置分割条大小
		SpaneA2.setDividerLocation(263);
		SpaneA2.setLeftComponent(SpaneA2a);
		SpaneA2.setRightComponent(paneA2b);//////////记得修改paneA2b为jsplitpane
		SpaneA2.setEnabled(false);//设置分割线不可移动
		
		SpaneA.setOneTouchExpandable(true);//是分隔面板的分隔条显示出箭头
		SpaneA.setContinuousLayout(true);
		SpaneA.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		SpaneA.setLeftComponent(paneA1);
		SpaneA.setRightComponent(SpaneA2);
		SpaneA.setOrientation(JSplitPane.VERTICAL_SPLIT);//设置为水平分隔
		SpaneA.setDividerSize(3);//设置分割条大小
		SpaneA.setDividerLocation(90);
		SpaneA.setEnabled(false);//设置分割线不可移动
		
		this.setContentPane(SpaneA);
		this.pack();
		//增加JFrame窗体题；
		this.addWindowListener(new WindowAdapter(){
            //图标化窗口时调用事件
            public void windowIconified(WindowEvent e) {
                dispose(); //窗口最小化时dispose该窗口
            }
        });
	}
	
	private void initAction() {
		
	}
	
	private SmallScrollPanel getModuleButtonGroup()
	  {
	    if (this.moduleButtonGroup == null)
	    {
	      this.moduleButtonGroup = new SmallScrollPanel();
	      this.moduleButtonGroup.setBounds(560, 10, 334, 69);//设置移动面板位置
	      this.moduleButtonGroup.setOpaque(false);
	      
	      this.moduleButtonGroup.setViewportView(getJPanel());
	      this.moduleButtonGroup.getAlphaScrollPanel()
	        .setViewportView(getJPanel());
	    }
	    return this.moduleButtonGroup;
	  }/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//paneA2b右下角面板
	public BGPanel getZixingCheContentPanel(String title,JFrame frame)
	  {
	    
	      this.backPanel = new BGPanel();
	      backPanel.setOpaque(false);//面板透明
	      backPanel.setName(title);
	      this.backPanel.setSize(1079,595);//设置右下角面板paneA2b位置
	      this.backPanel.setLocation(10, 10);
	      this.backPanel.setLayout(null);
	      
	      /////////////////////////////////////////////
	      menuPanel = new MenuPanel("",this);
	      this.backPanel.add(menuPanel);
	      
	      btn_help= new MButton("images/glj/ButtonImages/arraw_left1.png");
	      btn_help.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/arraw_left1.png"));
	      btn_help.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/arraw_left2.png"));
	      btn_help.setPressedIcon(new ImageIcon("images/glj/ButtonImages/arraw_left1.png"));
	      if(whoShown.equals("小窗体"))
			{
	    	  btn_help.setBounds(1046, 15, 24, 24);
			}else{
				btn_help.setBounds(980, 15, 24, 24);
			}
	      btn_help.setBounds(980, 15, 24, 24);
	      btn_help.setToolTipText("帮助");
	      this.backPanel.add(btn_help);
	      
	      btn_exit= new MButton("images/glj/ButtonImages/close-3.png");
	      btn_exit.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/close-2.png"));
	      btn_exit.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/close-2.png"));
	      btn_exit.setPressedIcon(new ImageIcon("images/glj/ButtonImages/close-3.png"));
	      btn_exit.setBounds(1046, 15, 24, 24);
	      btn_exit.setToolTipText("关闭");
	      this.backPanel.add(btn_exit);
	      
	      btn_zuida = new MButton("images/glj/ButtonImages/zuida-1.png");
	      btn_zuida.setSelectedIcon(new ImageIcon("images/glj/ButtonImages/zuida-1.png"));
	      btn_zuida.setRolloverIcon(new ImageIcon("images/glj/ButtonImages/zuida-2.png"));
	      btn_zuida.setPressedIcon(new ImageIcon("images/glj/ButtonImages/zuida-2.png"));
	      btn_zuida.setBounds(1015, 15, 24, 24);
	      btn_exit.setToolTipText("独立显示");
	      this.backPanel.add(btn_zuida);
	      
	      btn_exit.setActionCommand("关闭");
	      btn_zuida.setActionCommand("最大化"); 
	      btn_help.setActionCommand("帮助");
	      btn_help.addActionListener(new ActionListener_btn_exit_zuida(this));
	      btn_exit.addActionListener(new ActionListener_btn_exit_zuida(this));
	      btn_zuida.addActionListener(new ActionListener_btn_exit_zuida(this));
	      
	      this.label_1.setHorizontalAlignment(4);
	      this.label_1.setVerticalAlignment(3);
	      this.label_1.setBounds(38, 38, 96, 15);//设置jlable”你当前的位置：“
	      
	      this.backPanel .setBorder(BorderFactory.createTitledBorder(null, title, 0,  2, new Font("sansserif", 1, 12), new Color(59, 59, 59)));
	      this.backPanel.add(this.label_1);
	      MainFrame.fristLabel.setBounds(139, 38, 123, 15);
	      MainFrame.fristLabel.setFont(new   java.awt.Font("宋体",   1,   12));   
	      this.backPanel.add(MainFrame.fristLabel);
	    
	      sellPanel.setBounds(178, 63, 920, 520);
	      sellPanel.setLayout(null);
	      sellPanel.setOpaque(false);
	      this.backPanel.add(sellPanel);
	      this.backPanel.add(getZiXingCheTree(frame));
	    
	    return this.backPanel;
	  }
	
	class ActionListener_btn_exit_zuida implements ActionListener
	{

		private MainFrame mainFrame;
		
		public ActionListener_btn_exit_zuida(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			if(command.equals("关闭"))
			{
				paneA2b.removeAll();
				paneA2b.add(mainR);
				paneA2b.repaint();
			}
			else if (command.equals("帮助"))
			{
				mainFrame.getBtn_help().setVisible(false);
				mainFrame.getMenuPanel().setVisible(true);
			}
			else if (command.equals("最大化"))
			{
				frame = new JFrame();
				mainFrame.setWhoShown("小窗体");
				final BGPanel zixingchePanel = getZixingCheContentPanel("自行车",frame);

				frame.setResizable(false);//设置窗体不可变
				frame.addWindowListener(new WindowAdapter()  
		        {  
		            public void windowClosing(WindowEvent e)  
		            { 
		            	mainFrame.setWhoShown("主窗体");
		            	MainFrame.this.getBtn_help().setBounds(980, 15, 24, 24);
						MainFrame.this.getMenuPanel().setBounds(779, 7, 240, 40);
						MainFrame.this.getMenuPanel().getBtn_fanhui().setBounds(181, 5, 65, 30);
						MainFrame.this.getMenuPanel().setVisible(true);
						MainFrame.this.getBtn_exit().setVisible(true);
						MainFrame.this.getBtn_zuida().setVisible(true);
		            	new SysTrayActionListener().actionPerformed(e);//调用系统托盘的双击事件，使mainFrame回复原始状态
		            	mainFrame.getPaneA2b().removeAll();
		            	mainFrame.getPaneA2b().add(zixingchePanel);
		            	
		            	mainFrame.repaint();
		            }  
		  
		            public void windowClosed(WindowEvent e)  
		            {  
//		                System.out.println("触发windowClosed事件");  
		            }  
		        });  
				
				
				frame.setName("小窗体");
				frame.setIconImage(new ImageIcon("images/glj/frametitle.png").getImage());//设置窗体左上角图标
				MPanel mianPanel = new MPanel("images/背景down1.jpg");
				mainFrame.setExtendedState(JFrame.ICONIFIED);//使主窗体最小化
				
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1123,638);
				mianPanel.setLayout(null);
				

				
				mianPanel.add(zixingchePanel);
				frame.setContentPane(mianPanel);
				
				frame.setVisible(true);
				if(mainFrame.getWhoShown().equals("小窗体"))
				{
					MainFrame.this.getBtn_help().setBounds(1046, 15, 24, 24);
					MainFrame.this.setVisible(true);
					MainFrame.this.getMenuPanel().setBounds(847, 7, 240, 40);
					MainFrame.this.getBtn_exit().setVisible(false);
					MainFrame.this.getBtn_zuida().setVisible(false);
					frame.repaint();
				}
			}
			
		}
		
	}
	public JPanel getZiXingCheTree(final JFrame frame)
	  {
		frame.getName();
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(5, 62, 168, 520);
		panel.setOpaque(false);
		 

	      MTree_zixingche zixingche= new MTree_zixingche();
		this.zixingchetree = zixingche.getTree();//添加自行车tree
		
		 JScrollPane scrollPane_1 = new JScrollPane(this.zixingchetree);
		  scrollPane_1.setBounds(0,0, 168, 520);
		  scrollPane_1.setOpaque(false);
	      this.panel.add(scrollPane_1);
	      
	      this.zixingchetree.getSelectionModel().setSelectionMode(1);
	  	      TreeSelectionModel treeSelectionModel = this.zixingchetree.getSelectionModel();
	  	      treeSelectionModel .setSelectionMode(2);
	  	    this.zixingchetree.addTreeSelectionListener(new TreeSelectionListener()
		      {
		        public void valueChanged(TreeSelectionEvent e)
		        {
		          if (!MainFrame.this.zixingchetree.isSelectionEmpty())
		          {
		            TreePath selectionPaths = MainFrame.this.zixingchetree.getSelectionPath();
		            Object path = selectionPaths.getLastPathComponent();
		            DefaultMutableTreeNode node = (DefaultMutableTreeNode)path;
		            String userObject = (String)node.getUserObject();
		            MainFrame.this.repaint();
		            if (userObject.equals("自行车"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            }
		            else if (userObject.equals("前台收银管理"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		            	 sellPanel.setLayout(null);
		            	sellPanel.removeAll();
		              KaiTaiMgr kaiTaiPanel= new KaiTaiMgr();
		              kaiTaiPanel.setBounds(0, 0,910, 515);
		              sellPanel.add(kaiTaiPanel);//                                       这里加功能窗口（替换new ProgressPanel()）
		          
		              if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            }
		            else if (userObject.equals("会员卡管理"))
		            {
		              MainFrame.fristLabel.setText(userObject);
		              sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              VipManager vipManager = new VipManager();//                         这里加功能窗口（替换new ProgressPanel()）
		              vipManager.setBounds(0, 0, 910, 515);
		               sellPanel.add(vipManager);
		          
		               if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            }//系统管理、、、、、、、、、、、、、、、、、、、、、、
		            else if (userObject.equals("系统管理"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              XiTongMgr shouFeiSet = new XiTongMgr(MainFrame.this);
		              shouFeiSet.setBounds(0, 0,910, 515);
		             sellPanel.add(shouFeiSet);//                                       这里加功能窗口（替换new ProgressPanel()）
		             if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            }
		            else if (userObject.equals("其它"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		            	sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              Other otherManager =new Other();
		              otherManager.setBounds(0, 0, 900, 515);
		               sellPanel.add(otherManager);//                                       这里加功能窗口（替换new ProgressPanel()）
		           
		               if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            } else if (userObject.equals("帮助"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              sellPanel.add(new ProgressPanel());
		              MainFrame.this.repaint();
		            
		              if(whoShown.equals("小窗体"))
		            	{
		            	 MainFrame.this.getFrame().repaint();
		            	}
		            }
		          }
		        }
		      });
	  	    return panel;
	  }
	private BGPanel getFuZhuangContentPanel(String title)
	  {
	      this.backPanel = new BGPanel();
	      backPanel.setName(title);
	      backPanel.setOpaque(false);
	      this.backPanel.setSize(1079,595);//设置右下角面板paneA2b位置
	      this.backPanel.setLocation(10, 10);
	      this.backPanel.setLayout(null);
	      
	      this.label_1.setHorizontalAlignment(4);
	      this.label_1.setVerticalAlignment(3);
	      this.label_1.setBounds(38, 38, 96, 15);//设置jlable”你当前的位置：“
	      this.backPanel .setBorder(BorderFactory.createTitledBorder(null, title, 0,  2, new Font("sansserif", 1, 12), new Color(59, 59, 59)));
	      this.backPanel.add(this.label_1);
	      MainFrame.fristLabel.setBounds(133, 38, 123, 15);
	      this.backPanel.add(MainFrame.fristLabel);
	    
	      sellPanel.setBounds(148, 63, 920, 520);
	     
	      sellPanel.setLayout(null);
	      this.backPanel.add(sellPanel);
	      this.backPanel.add(getFuZhuangTree());
	    
	    return this.backPanel;
	  }
	private JPanel getFuZhuangTree()
	{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(5, 62, 138, 520);
		
		  JScrollPane scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBounds(0,0, 138, 520);
	      MTree_fuzhuang fuzhuang = new MTree_fuzhuang();
	      this.fuzhuangtree =fuzhuang.getTree();
	      scrollPane_1.setColumnHeaderView(this.fuzhuangtree);
	      this.panel.add(scrollPane_1);
	      
	      this.fuzhuangtree.getSelectionModel().setSelectionMode(
	  	        1);
	  	      TreeSelectionModel treeSelectionModel = this.fuzhuangtree.getSelectionModel();
	  	      treeSelectionModel
	  	        .setSelectionMode(2);
	  	    this.fuzhuangtree.addTreeSelectionListener(new TreeSelectionListener()
		      {
		        public void valueChanged(TreeSelectionEvent e)
		        {
		          if (!MainFrame.this.fuzhuangtree.isSelectionEmpty())
		          {
		            TreePath selectionPaths = MainFrame.this.fuzhuangtree.getSelectionPath();
		            Object path = selectionPaths.getLastPathComponent();
		            DefaultMutableTreeNode node = (DefaultMutableTreeNode)path;
		            String userObject = (String)node.getUserObject();
		            MainFrame.this.repaint();
		            if (userObject.equals("1管理"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		            }
		            else if (userObject.equals("2管理"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              sellPanel.add(new ProgressPanel());
		            }
		            else if (userObject.equals("3管理"))
		            {
		              MainFrame.fristLabel.setText(userObject);
		              sellPanel.setLayout(null);
		              sellPanel.removeAll();
		              MemberManagePanel memberManagePanel = new MemberManagePanel();
		              memberManagePanel.setBounds(10, 11, 700, 500);
		               sellPanel.add(memberManagePanel);
		            }
		            else if (userObject.equals("管理"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		             sellPanel.add(new ProgressPanel());
		            }
		            else if (userObject.equals("系统维护"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		               sellPanel.add(new ProgressPanel());
		            } else if (userObject.equals("帮助"))
		            {
		            	MainFrame.fristLabel.setText(userObject);
		              sellPanel.removeAll();
		              sellPanel.add(new ProgressPanel());
		              MainFrame.this.repaint();
		            }
		          }
		        }
		      });
	  	    return panel;
	}
	public BGPanel getJPanel()
	  {
	    if (this.jPanel == null)
	    {
	      GridLayout gridLayout = new GridLayout();
	      gridLayout.setRows(1);
	      gridLayout.setHgap(0);
	      gridLayout.setVgap(5);
	      this.jPanel = new BGPanel();
	      
	      this.jPanel.setLayout(gridLayout);
	      
	      this.jPanel.setPreferredSize(new Dimension(400, 50));
	      this.jPanel.setOpaque(false);
	      //把按钮加入到移动面板
	      this.jPanel.add(getQiCheBtn(), null);
	      this.jPanel.add(getFangZiBtn(), null);
	      this.jPanel.add(getFuZhuangBtn(), null);
	      this.jPanel.add(getZiXingCheBtn(), null);
	      this.jPanel.add(getDianZiSheBeiBtn(), null);
	      this.jPanel.add(getJianZuGongJuBtn(), null);
	      this.jPanel.add(getBookspaceButton(), null);
	      if (this.buttonGroup == null) {
	        this.buttonGroup = new ButtonGroup();
	      }
	      this.buttonGroup.add(getFangZiBtn());
	      this.buttonGroup.add(getQiCheBtn());
	      this.buttonGroup.add(getFuZhuangBtn());
	      this.buttonGroup.add(getZiXingCheBtn());
	      this.buttonGroup.add(getDianZiSheBeiBtn());
	      this.buttonGroup.add(getJianZuGongJuBtn());
	      this.buttonGroup.add(getBookspaceButton());
	    }
	    return this.jPanel;
	  }
	private GlassButton getQiCheBtn()
	  {
	    if (this.qichebtn == null)
	    {
	      this.qichebtn = new GlassButton();
	      qichebtn.setToolTipText("汽车租赁");
	      this.qichebtn.setActionCommand("汽车");
	      this.qichebtn.setIcon(new ImageIcon(
	        "images/MJBtn/汽车.png"));
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/汽车.png");
	      this.qichebtn.setRolloverIcon(icon);
	      this.qichebtn.setSelectedIcon(icon);
	      this.qichebtn.setSelected(true);
	      this.qichebtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.qichebtn;
	  }
	  
	  private GlassButton getFangZiBtn()
	  {
	    if (this.fangzibtn == null)
	    {
	      this.fangzibtn = new GlassButton();
	      this.fangzibtn.setActionCommand("房子");
	      this.fangzibtn.setToolTipText("房子租赁");
	      this.fangzibtn.setIcon(new ImageIcon(
	        "images/MJBtn/房子.png"));
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/房子.png");
	      this.fangzibtn.setRolloverIcon(icon);
	      this.fangzibtn.setSelectedIcon(icon);
	      this.fangzibtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.fangzibtn;
	  }
	  
	  private GlassButton getFuZhuangBtn()
	  {
	    if (this.fuzhuangbtn == null)
	    {
	      this.fuzhuangbtn = new GlassButton();
	      this.fuzhuangbtn.setActionCommand("服装");
	      this.fuzhuangbtn.setToolTipText("服装租赁");
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/服装.png");
	      this.fuzhuangbtn.setSelectedIcon(icon);
	      this.fuzhuangbtn.setRolloverIcon(icon);
	      this.fuzhuangbtn.setIcon(new ImageIcon(
	        "images/MJBtn/服装.png"));
	      this.fuzhuangbtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.fuzhuangbtn;
	  }
	  
	  private GlassButton getZiXingCheBtn()
	  {
	    if (this.zixingchebtn == null)
	    {
	      this.zixingchebtn = new GlassButton();
	      this.zixingchebtn.setActionCommand("自行车");
	      this.zixingchebtn.setToolTipText("自行车租赁");
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/自行车.png");
	      this.zixingchebtn.setSelectedIcon(icon);
	      this.zixingchebtn.setRolloverIcon(icon);
	      this.zixingchebtn.setIcon(new ImageIcon(
	        "images/MJBtn/自行车.png"));
	      this.zixingchebtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.zixingchebtn;
	  }
	  
	  private GlassButton getBookspaceButton()
	  {
	    if (this.bookspaceButton == null)
	    {
	      this.bookspaceButton = new GlassButton();
	      
	      this.bookspaceButton.setActionCommand("书籍");
	      this.bookspaceButton.setToolTipText("书籍租赁");
	      
	      ImageIcon imageIcon = new ImageIcon(
	        "images/MJBtn/书籍.png");
	      this.bookspaceButton.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/书籍.png");
	      this.bookspaceButton.setRolloverIcon(icon);
	      this.bookspaceButton.setSelectedIcon(icon);
	      this.bookspaceButton.setFocusPainted(false);
	      this.bookspaceButton.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.bookspaceButton;
	  }
	  
	  private GlassButton getDianZiSheBeiBtn()
	  {
	    if (this.dianzishebeibtn == null)
	    {
	      this.dianzishebeibtn = new GlassButton();
	      
	      this.dianzishebeibtn.setActionCommand("电子设备");
	      this.dianzishebeibtn.setToolTipText("电子设备租赁");
	      
	      ImageIcon imageIcon = new ImageIcon(
	    		  "images/MJBtn/电子设备.png");
	      this.dianzishebeibtn.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/电子设备.png");
	      this.dianzishebeibtn.setRolloverIcon(icon);
	      this.dianzishebeibtn.setSelectedIcon(icon);
	      this.dianzishebeibtn.setFocusPainted(false);
	      this.dianzishebeibtn .addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.dianzishebeibtn;
	  }
	  
	  private GlassButton getJianZuGongJuBtn()
	  {
	    if (this.jianzugongjubtn == null)
	    {
	      this.jianzugongjubtn = new GlassButton();
	      
	      this.jianzugongjubtn.setActionCommand("建筑工具");
	      this.jianzugongjubtn.setToolTipText("建筑工具租赁");
	      
	      ImageIcon imageIcon = new ImageIcon(
	        "images/MJBtn/建筑工具.png");
	      this.jianzugongjubtn.setIcon(imageIcon);
	      ImageIcon icon = new ImageIcon(
	        "images/MJBtn/建筑工具.png");
	      this.jianzugongjubtn.setRolloverIcon(icon);
	      this.jianzugongjubtn.setSelectedIcon(icon);
	      this.jianzugongjubtn.setFocusPainted(false);
	      this.jianzugongjubtn.addActionListener(new toolsButtonActionAdapter());
	    }
	    return this.jianzugongjubtn;
	  }
	  //平移面板按钮监听器
	  class toolsButtonActionAdapter implements ActionListener
	  {
	    toolsButtonActionAdapter() {}
	    public void actionPerformed(ActionEvent e)
	    {
	    	String backpaneltitle=e.getActionCommand();
	      if (e.getSource() == MainFrame.this.qichebtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
	    	  MainFrame.this.sellPanel.removeAll();
	    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
	    	  MainFrame.fristLabel.setBounds(133, 38, 123, 15);
	    	  MainFrame.this.backPanel.add(MainFrame.fristLabel);
	    	  MainFrame.this.panel_1.setBounds(10, 63, 611, 376);
	    	  MainFrame.this.backPanel.add(new ProgressPanel("还在维护中。。。"));
	    	  
	    	  MainFrame.fristLabel.setText(backpaneltitle);
	    	  MainFrame.this.repaint();
	      }
	      if (e.getSource() == MainFrame.this.fangzibtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
	    	  MainFrame.this.sellPanel.removeAll();
	    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
	    	  MainFrame.fristLabel.setBounds(133, 38, 123, 15);
	        MainFrame.this.backPanel.add(MainFrame.fristLabel);
	        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
	        
	        MainFrame.fristLabel.setText(backpaneltitle);
	                                                                                   //重新加入要显示的面板
	        MainFrame.this.backPanel.add(new ProgressPanel("还在维护中。。。"));
	        MainFrame.this.repaint();
	      }
	      if (e.getSource() == MainFrame.this.fuzhuangbtn)
	      {
	    	  if(!backPanel.getName().equals("服装"))
	    	  {
		    	  MainFrame.this.paneA2b.removeAll();
		    	  MainFrame.this.sellPanel.removeAll();
		    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
		    	  MainFrame.fristLabel.setBounds(133, 38, 123, 15);
		          MainFrame.this.backPanel.add(MainFrame.fristLabel);
		          MainFrame.this.paneA2b.add(getFuZhuangContentPanel("服装"));//重新加入要显示的面板y
		          MainFrame.fristLabel.setText(backpaneltitle);
		          MainFrame.this.repaint();
	    	  }
	      }
	      if (e.getSource() == MainFrame.this.zixingchebtn)
	      {
	    	  if(!backPanel.getName().equals("自行车"))
	    	  {
		     	  MainFrame.this.paneA2b.removeAll();
		     	  MainFrame.this.sellPanel.removeAll();
		    	  MainFrame.this.backPanel.add(MainFrame.this.label_1);
		    	  MainFrame.fristLabel.setBounds(133, 38, 123, 15);
		          MainFrame.this.backPanel.add(MainFrame.fristLabel);
//		          MJLable mainR = new MJLable("images/beijin_r_lbl_end.gif", 300, 300);
//			  	  mainR.setBounds(780, 340, 300, 300);
//			   	  MainFrame.this.paneA2b.add(mainR);
		          MainFrame.this.paneA2b.add(getZixingCheContentPanel("自行车",MainFrame.this));//重新加入要显示的面板y
		          MainFrame.fristLabel.setText(backpaneltitle);
		          
		          MainFrame.this.repaint();
	    	  }
	      }
	      if (e.getSource() == MainFrame.this.bookspaceButton)
	      {
    	    MainFrame.this.backPanel.removeAll();
	        MainFrame.this.backPanel.add(MainFrame.this.label_1);
	        MainFrame.fristLabel.setBounds(133, 38, 123, 15);
	        MainFrame.this.backPanel.add(MainFrame.fristLabel);
	        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
	        
	        MainFrame.this.backPanel.add(new ProgressPanel("还在维护中。。。"));//重新加入要显示的面板
	        MainFrame.fristLabel.setText(backpaneltitle);
	        MainFrame.this.repaint();
	      
	    	 
	      }
	      if (e.getSource() == MainFrame.this.dianzishebeibtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
		        MainFrame.this.backPanel.add(MainFrame.this.label_1);
		        MainFrame.fristLabel.setBounds(133, 38, 123, 15);
		        MainFrame.this.backPanel.add(MainFrame.fristLabel);
		        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
		        
		        MainFrame.this.backPanel.add(new ProgressPanel("还在维护中。。。"));//重新加入要显示的面板
		        MainFrame.fristLabel.setText(backpaneltitle);
		        MainFrame.this.repaint();
	      }
	      if (e.getSource() == MainFrame.this.jianzugongjubtn)
	      {
	    	  MainFrame.this.backPanel.removeAll();
		        MainFrame.this.backPanel.add(MainFrame.this.label_1);
		        MainFrame.fristLabel.setBounds(133, 38, 123, 15);
		        MainFrame.this.backPanel.add(MainFrame.fristLabel);
		        MainFrame.this.panel_1.setBounds(10, 63, 611, 386);
		        
		        MainFrame.this.backPanel.add(new ProgressPanel("还在维护中。。。"));//重新加入要显示的面板
		        MainFrame.fristLabel.setText(backpaneltitle);
		        MainFrame.this.repaint();
	      }
	    }
	  }
	  
	  public void SystemTrayInitial() { // 系统栏初始化
			if (!SystemTray.isSupported()) // 判断当前系统是否支持系统栏
				return;
			try {
				String title = "通用商品租赁管理";
				String company = "";
				SystemTray sysTray = SystemTray.getSystemTray();
				Image image = Toolkit.getDefaultToolkit().getImage(
						MainFrame.class.getResource("/自行车.png"));// 系统栏图标
				trayicon = new TrayIcon(image, title + "\n" + company, createMenu());
				trayicon.setImageAutoSize(true);
				trayicon.addActionListener(new SysTrayActionListener());
				sysTray.add(trayicon);
				trayicon.displayMessage(title, company, MessageType.INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private PopupMenu createMenu() { // 创建系统栏菜单的方法
			PopupMenu menu = new PopupMenu();
			MenuItem exitItem = new MenuItem("退出");
			exitItem.addActionListener(new ActionListener() { // 系统栏退出事件
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
			MenuItem openItem = new MenuItem("打开");
			openItem.addActionListener(new ActionListener() {// 系统栏打开菜单项事件
						public void actionPerformed(ActionEvent e) {
							if (!isVisible()) {
								setVisible(true);
								toFront();
							} else
								toFront();
						}
					});

			// 系统栏的访问服务器菜单项事件
			menu.add(openItem);
			menu.addSeparator();
			menu.add(exitItem);
			return menu;
		}
		class SysTrayActionListener implements ActionListener {// 系统栏双击事件
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				toFront();
			}

		public void actionPerformed(WindowEvent e) {
			setVisible(true);
			toFront();
					
		}
		}
	  
	public static JLabel getFristLabel() {
			return fristLabel;
		}

		public void setFristLabel(JLabel fristLabel) {
			MainFrame.fristLabel = fristLabel;
		}

		public JLabel getLabel_1() {
			return label_1;
		}

		public void setLabel_1(JLabel label_1) {
			this.label_1 = label_1;
		}

	public JPanel getPaneA2b() {
			return paneA2b;
		}

		public void setPaneA2b(JPanel paneA2b) {
			this.paneA2b = paneA2b;
		}

	public JPanel getPanel_1() {
			return panel_1;
		}

		public void setPanel_1(JPanel panel_1) {
			this.panel_1 = panel_1;
		}

	public MButton getBtn_exit() {
			return btn_exit;
		}

		public void setBtn_exit(MButton btn_exit) {
			this.btn_exit = btn_exit;
		}

		public MButton getBtn_zuida() {
			return btn_zuida;
		}

		public void setBtn_zuida(MButton btn_zuida) {
			this.btn_zuida = btn_zuida;
		}

	public MenuPanel getMenuPanel() {
			return menuPanel;
		}

		public void setMenuPanel(MenuPanel menuPanel) {
			this.menuPanel = menuPanel;
		}

	public MButton getBtn_help() {
			return btn_help;
		}

		public void setBtn_help(MButton btn_help) {
			this.btn_help = btn_help;
		}

	public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

	public String getWhoShown() {
			return whoShown;
		}

		public void setWhoShown(String whoShown) {
			this.whoShown = whoShown;
		}

	public MJLable getMainR() {
			return mainR;
		}

		public void setMainR(MJLable mainR) {
			this.mainR = mainR;
		}

	public BGPanel getBackPanel() {
			return backPanel;
		}

		public void setBackPanel(BGPanel backPanel) {
			this.backPanel = backPanel;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			try {
				MainFrame mainFrame =new MainFrame();
				mainFrame.setResizable(false);
				mainFrame.SystemTrayInitial();// 初始化系统栏
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
