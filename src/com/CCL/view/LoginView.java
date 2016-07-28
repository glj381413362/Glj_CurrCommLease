package com.CCL.view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import com.CCL.Dao.base.HibernateSessionFactory;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.util.ValidateCode;
import com.CCL.util.ValidateCodeBuilder;
import com.CCL.util.mlf.PublicDate;
import com.CCL.view.other.son.Util_pro;

import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JPasswordField txt_password;
	private JTextField txt_checkcode;
	protected String loginErrorMsg;
	final CardLayout cl_CardPanel = new CardLayout(0, 0);
	
	SwingWorker<OpeUser,Void> loginWorker = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

//				System.out.println(32);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String rember = Util_pro.readData("login.rember");
				if("true".equals(rember)){
					String userName = Util_pro.readData("login.userName");
					String password = Util_pro.readData("login.password");
					txt_userName.setText(userName);
					txt_password.setText(password);
					chk_rember.setSelected(true);
				}
				
			}
		});
		setUndecorated(true);
		setBackground(null);
		setMinimumSize(new Dimension(590, 346));
		setTitle("\u901A\u7528\u51ED\u79DF\u7BA1\u7406\u7CFB\u7EDF(\u767B\u5F55)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 458);
		contentPane = new JPanel() {
			Image bgimage = new ImageIcon("images\\login.png").getImage();

			@Override
			protected void paintComponent(Graphics g) {
				// super.paintComponent(g);
				if ((getWidth() <= 0) || (getHeight() <= 0)) {
					return;
				}
				int clipX;
				int clipY;
				int clipW;
				int clipH;
				clipX = clipY = 3;
				clipW = getWidth() - 7;
				clipH = getHeight() - 7;
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setClip(new RoundRectangle2D.Float(clipX, clipY, clipW, clipH, 30, 30));
				g2d.setStroke(new BasicStroke(3));
				float alpha = 0.5f; // 透明度
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
				g2d.drawImage(bgimage, clipX, clipY, clipW, clipH, null);
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP));
				g2d.setColor(Color.darkGray);
				g2d.drawRoundRect(clipX, clipY, clipW, clipH, 20, 20);
			}

			@Override
			protected void paintChildren(Graphics g) {
				// TODO Auto-generated method stub
				super.paintChildren(g);
			}

			@Override
			protected void paintBorder(Graphics g) {
				// TODO Auto-generated method stub

				super.paintBorder(g);
			}

			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
			}

		};
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.ORANGE);
		setContentPane(contentPane);

		cardPanel = new JPanel();
		cardPanel.setOpaque(false);
		
		cardPanel.setLayout(cl_CardPanel);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		cardPanel.add(panel_1, "name_9759881975055");
		panel_1.setLayout(new BorderLayout(0, 0));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mx = e.getXOnScreen();
				my = e.getYOnScreen();
				jfx = LoginView.this.getX();
				jfy = LoginView.this.getY();
			}

		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				LoginView.this.setLocation(jfx + (e.getXOnScreen() - mx), jfy + (e.getYOnScreen() - my));
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(null);
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setOpaque(false);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 75, 0, 0};
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txt_userName = new JTextField();
		GridBagConstraints gbc_txt_userName = new GridBagConstraints();
		gbc_txt_userName.insets = new Insets(0, 0, 5, 5);
		gbc_txt_userName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_userName.gridx = 4;
		gbc_txt_userName.gridy = 1;
		panel_4.add(txt_userName, gbc_txt_userName);
		txt_userName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txt_password = new JPasswordField();
		GridBagConstraints gbc_txt_password = new GridBagConstraints();
		gbc_txt_password.insets = new Insets(0, 0, 5, 5);
		gbc_txt_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_password.gridx = 4;
		gbc_txt_password.gridy = 3;
		panel_4.add(txt_password, gbc_txt_password);
		txt_password.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u9A8C\u8BC1\u7801");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txt_checkcode = new JTextField();
		txt_checkcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					ActionListener[] actionListeners = btn_login.getActionListeners();
					for (ActionListener actionListener : actionListeners) {
						actionListener.actionPerformed(null);
					}
				}
			}
		});
		txt_checkcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt_checkcode.setText("");
			}
		});
		GridBagConstraints gbc_txt_checkcode = new GridBagConstraints();
		gbc_txt_checkcode.insets = new Insets(0, 0, 5, 5);
		gbc_txt_checkcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_checkcode.gridx = 4;
		gbc_txt_checkcode.gridy = 5;
		panel_4.add(txt_checkcode, gbc_txt_checkcode);
		txt_checkcode.setColumns(10);

		lblCheckCode = new CheckCode();
		lblCheckCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckCode.setOpaque(true);
		lblCheckCode.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblCheckCode = new GridBagConstraints();
		gbc_lblCheckCode.gridwidth = 2;
		gbc_lblCheckCode.fill = GridBagConstraints.BOTH;
		gbc_lblCheckCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckCode.gridx = 6;
		gbc_lblCheckCode.gridy = 5;
		panel_4.add(lblCheckCode, gbc_lblCheckCode);

		JLabel lblNewLabel_5 = new JLabel("\u7C7B\u522B");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 7;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u7BA1\u7406\u5458", "\u666E\u901A\u8D26\u6237" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 7;
		panel_4.add(comboBox, gbc_comboBox);
		panel_2.add(panel_4);
				
				chk_rember = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
				GridBagConstraints gbc_chk_rember = new GridBagConstraints();
				gbc_chk_rember.insets = new Insets(0, 0, 5, 5);
				gbc_chk_rember.gridx = 4;
				gbc_chk_rember.gridy = 9;
				panel_4.add(chk_rember, gbc_chk_rember);
		
				txt_tip = new JLabel("");
				txt_tip.setHorizontalTextPosition(SwingConstants.LEADING);
				txt_tip.setForeground(Color.RED);
				txt_tip.setHorizontalAlignment(SwingConstants.LEFT);
				txt_tip.setFont(new Font("宋体", Font.BOLD, 18));
				GridBagConstraints gbc_txt_tip = new GridBagConstraints();
				gbc_txt_tip.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_tip.gridwidth = 9;
				gbc_txt_tip.gridx = 0;
				gbc_txt_tip.gridy = 11;
				panel_4.add(txt_tip, gbc_txt_tip);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setOpaque(false);

		btn_login = new JButton("\u767B\u5F55");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("".equals(txt_userName.getText())){
					showTip("用户名不能为空!");
					JOptionPane.showMessageDialog(null, "用户名不能为空!","输入错误",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if("".equals(txt_password.getText())){
					showTip("密码不能为空!");
					JOptionPane.showMessageDialog(null, "密码不能为空!","输入错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(!lblCheckCode.getCode().equalsIgnoreCase(txt_checkcode.getText())){
					showTip("验证码错误!");
					JOptionPane.showMessageDialog(null, "验证码错误!","输入错误",JOptionPane.ERROR_MESSAGE);
					lblCheckCode.updateCode();
					return;
				}
				
				handleRemberPassword();
				cl_CardPanel.next(cardPanel);
				
//				loginWorker.
				if(loginWorker==null||loginWorker.isCancelled()||loginWorker.isDone()){
					loginWorker = new SwingWorker<OpeUser,Void>() {

						@Override
						protected OpeUser doInBackground() throws Exception {
							HibernateSessionFactory.getSession();
							OpeUserDaoImpl opeUserDaoImpl = new OpeUserDaoImpl();
							String userName = txt_userName.getText();
							String password = txt_password.getText();
							
							Map<String, Object> entrys = new HashMap<String, Object>();
							entrys.put("user_name", userName);
							entrys.put("password", password);
							List<OpeUser> queryByUsePage = opeUserDaoImpl.queryByUsePage(entrys, 1, 0);
							if(!queryByUsePage.isEmpty()){
								return queryByUsePage.get(0);
							}else{
								loginErrorMsg = "用户名或密码有误!";
							}
							return null;
						}
						
						protected void done() {
							boolean isSuccess = false;
							try {
								OpeUser user = get();
								if(user!=null){
									PublicDate.setOuser(user);
									isSuccess=true;
								}
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ExecutionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							cl_CardPanel.previous(cardPanel);
							if(isSuccess){
//								JOptionPane.showMessageDialog(null, "登录成功");
								LoginView.this.dispose();
								MainFrame.main(null);
							}else{
								JOptionPane.showMessageDialog(null, "登录失败");
								showTip("登录失败\n"+loginErrorMsg);
								
							}
							
							
						}
					};
				}
				loginWorker.execute();
			}
		});
		btn_login.setMargin(new Insets(15, 30, 15, 30));
		panel_3.add(btn_login);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(100, 0));
		panel_3.add(separator);

		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		
				JLabel lblNewLabel = new JLabel("\u901A\u7528\u79DF\u8D41\u7BA1\u7406\u7CFB\u7EDF") {
					@Override
					protected void paintBorder(Graphics g) {
						// super.paintBorder(g);
						g.setColor(Color.darkGray);
						g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
		
					}
		
					@Override
					protected void paintComponent(Graphics g) {
						// TODO Auto-generated method stub
						g.setColor(Color.BLACK);
						g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
						super.paintComponent(g);
		
					}
		
				};
				contentPane.add(lblNewLabel, BorderLayout.NORTH);
				lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBackground(Color.RED);
				lblNewLabel.setFont(new Font("楷体", Font.BOLD, 65));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setMargin(new Insets(15, 30, 15, 30));
		panel_3.add(btnNewButton_1);
		setIcon("images/loginview/btn_exit.png", btnNewButton_1);
		setIcon("images/loginview/btn_login.png", btn_login);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		cardPanel.add(panel_5, "name_9800922690675");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_6.setOpaque(false);
//		panel_6.setBackground(new Color(40,40,40));
		panel_5.add(panel_6, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u53D6\u6D88\u767B\u5F55");
		button.setIcon(new ImageIcon("images\\loginview\\btn_cancle.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_CardPanel.previous(cardPanel);
				loginWorker.cancel(true);
			}
		});
		button.setMargin(new Insets(15, 30, 15, 30));
		panel_6.add(button);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setOpaque(false);
		panel_7.setBackground(Color.GREEN);
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("\u767B\u5F55\u4E2D");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(new Color(40,40,40));
		lblNewLabel_7.setIcon(new ImageIcon("images\\loginview\\logining.gif"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_7, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(new Color(51,51,51));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon("images\\loginview\\ajax-loader.gif"));
		panel_7.add(lblNewLabel_8, BorderLayout.CENTER);
		contentPane.add(cardPanel);
	}

	protected boolean login() {
		
		HibernateSessionFactory.getSession();
		return false;
	}

	protected void handleRemberPassword() {
		
		if(chk_rember.isSelected()){
			try {
				Util_pro.writeData("login.userName", txt_userName.getText());
				Util_pro.writeData("login.password", txt_password.getText());
				Util_pro.writeData("login.rember", "true");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				Util_pro.writeData("login.rember", "false");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setIcon(String file, JButton com) {
		ImageIcon ico = new ImageIcon(file);
		Image temp = ico.getImage().getScaledInstance(50, 50, ico.getImage().SCALE_DEFAULT);
		ico = new ImageIcon(temp);
		com.setIcon(ico);
	}
	
	
	Timer tiphiddenWorker = new Timer(3000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			txt_tip.setText("");
		}
	});
	
	void showTip(String txt){
		txt_tip.setText(txt);
		tiphiddenWorker.restart();
	}

	int mx, my, jfx, jfy;
	private JPanel cardPanel;
	private JTextField txt_userName;
	private JCheckBox chk_rember;
	private JLabel txt_tip;
	private CheckCode lblCheckCode;
	private JButton btn_login;
	
	static class CheckCode extends JLabel {
		
		String code = null;
		
		ValidateCode vc = null;
		
		public CheckCode() {
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					updateCode();
				}
			});
			
			if(timer!=null)
				timer.start();
			
		}
		
		Timer timer =new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateCode();
				timer.stop();
				timer=null;
			}
		});
		public String updateCode() {
			if(getWidth()<=0||getHeight()<=0) {
				vc=null;
				return null;
			}
			vc = ValidateCodeBuilder.drawValidateCode(getWidth(), getHeight(), 4);
			code = vc.getValidateCodeString();
			this.setText(code);
			repaint();
			return code;
		}


		public String getCode(){
//			System.out.println(code);
			return code;
		}
		
		@Override
		public void paint(Graphics g) {
			if(vc!=null){
				g.drawImage(vc.getBufferedImage(), 0, 0, null);
			}else{
				super.paint(g);
			}
			
		}
		
	}
	
}
