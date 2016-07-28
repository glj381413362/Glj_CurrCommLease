package com.CCL.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ProgressPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private JProgressBar jProgressBar = null;
  private BufferedImage bgimage;
  private JLabel jLabel = null;
  private JProgressBar progressBar;
  static int count = 0;
	static int f = 1;
	private static boolean isOver = false;
	
	 
	 
  public ProgressPanel()
  {
	  this.jLabel = new JLabel();
	  this.jLabel.setText("正在登录系统……");
    initialize();
  }
  
  public ProgressPanel(String tip)
  {
	  
	 
	  
	  this.jLabel = new JLabel();
	  this.jLabel.setText(tip);
    initialize();
  }
  private void initialize()
  {
    GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
    gridBagConstraints2.gridx = 0;
    gridBagConstraints2.gridy = 0;
//    this.jLabel = new JLabel();
//    this.jLabel.setText("正在登录系统……");
    
    this.jLabel.setFont(new Font("SansSerif", 1, 12));
    
    this.jLabel.setForeground(new Color(2646686));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.fill = 2;
    gridBagConstraints.weightx = 1.0D;
    gridBagConstraints.insets = new Insets(0, 50, 0, 50);
    gridBagConstraints.ipadx = 100;
    gridBagConstraints.ipady = 0;
    gridBagConstraints.gridy = 1;
    
    setLayout(new GridBagLayout());
    setSize(300, 200);
    
    setForeground(Color.white);
    setOpaque(false);
    
    add(getJProgressBar(), gridBagConstraints);
    
    add(this.jLabel, gridBagConstraints2);
  }
  
  private JProgressBar getJProgressBar()
  {
    if (this.jProgressBar == null)
    {
      this.jProgressBar = new JProgressBar();
      
      this.jProgressBar.setIndeterminate(true);
    }
    return this.jProgressBar;
  }
  
  protected void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g.create();
    if (this.bgimage != null) {
      g2.drawImage(this.bgimage, 0, 0, this);
    }
    g2.dispose();
    super.paintComponent(g);
  }
  
  public void setBackImage(BufferedImage bimage)
  {
    this.bgimage = bimage;
  }
}
