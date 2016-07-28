package com.CCL.mwing;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class MJLable extends JLabel {
	protected ImageIcon imico;
	public MJLable(String imageUrl,int x,int y)
	{
		super();                                  //继承父类构造方法
		imico = new ImageIcon(imageUrl);
		//this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置jlable与图片等大
		this.setHorizontalAlignment(SwingConstants.CENTER);//设置图片或文字居中
		//this.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));//设置边框
		this.setPreferredSize(new Dimension(x,y));//设置图片大小
		this.setIcon(imico);
	}
	public MJLable(ImageIcon icon1 ,int x,int y)
	{
		super();                                  //继承父类构造方法
		//this.setSize(imico.getIconWidth(), imico.getIconHeight());//设置jlable与图片等大
		this.setHorizontalAlignment(SwingConstants.CENTER);//设置图片或文字居中
		//this.setBorder(new TitledBorder(null,"",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,null));//设置边框
		this.setPreferredSize(new Dimension(x,y));//设置图片大小
		this.setIcon(icon1);
	}

}
