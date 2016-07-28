package com.CCL.panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MPanel extends JPanel {             //在JPanel上绘制指定背景图片
	protected ImageIcon imico; 
	public MPanel(String imgUrl,int x,int y){
		super();                                  //继承父类构造方法
		this.setLayout(new GridBagLayout());
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置面板与图片等大
	}
	public MPanel(String imgUrl){
		super();                                  //继承父类构造方法
		this.setLayout(new GridBagLayout());
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置面板与图片等大
	}
	public MPanel(String imgUrl,GridLayout gridLayout){
		super();                                  //继承父类构造方法
		this.setLayout(gridLayout);
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置面板与图片等大
	}
	public MPanel(String imgUrl,BorderLayout borderLayout){
		super();                                  //继承父类构造方法
		this.setLayout(borderLayout);
		imico = new ImageIcon(imgUrl);
		this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置面板与图片等大
	}
	
	protected void paintComponent(Graphics g) {    //重写JPanel类的paintComponent(Graphics g)方法
		// TODO Auto-generated method stub
		super.paintComponent(g);                    // 调用JPanel类的paintComponent(Graphics g)方法
		Image image = imico.getImage();              //通过ImageIco对象获得Image对象
		g.drawImage(image, 0, 0, null);              //将图片绘制到面板上
	}
	

}
