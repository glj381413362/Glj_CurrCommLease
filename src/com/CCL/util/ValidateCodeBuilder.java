package com.CCL.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCodeBuilder {
	
	private static final String CHARLIST_STRING = "0123456789qwertyuiopasdfghjklzxcvbnm";
	
	private static Random random = new Random();
	
	public static String createValidateCode(int count)
	{
		String validateCode = "";
		for(int i = 0;i < count;i++)
		{
			int charIndex = random.nextInt(CHARLIST_STRING.length());
			char cr = CHARLIST_STRING.charAt(charIndex);
			if(cr >= 97 && cr <= 122)
			{
				if(random.nextBoolean())
				{
					cr = Character.toUpperCase(cr);
				}
			}
			
			validateCode += cr;
		}
		
		return validateCode;
	}
	
	private static void drawBackground(int width,int height,Graphics g)
	{
		int count = random.nextInt(width * height);
		
		if(count <=5)
		{
			count = (count + 1) * 10;
		}
		g.setColor(Color.yellow);
		g.fillRect(0, 0, width, height);
		for(int i = 0;i <17;i++){
			g.setColor(randomColor());
			g.setFont(new Font("ºÚÌå", 3, 28));
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width)+random.nextInt(12), random.nextInt(height)+random.nextInt(12));
		}
	}
	
	public static ValidateCode drawValidateCode(int width ,int height, int count)
	{
		String validateCodeString = createValidateCode(count);
		
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		
		drawBackground(width,height,g);
		
		g.setColor(randomColor());
		g.setFont(new Font("",Font.BOLD | Font.ITALIC,20));
		g.drawString(validateCodeString, (width - (count * 12)) / 2, (height + 12) / 2);
		
		ValidateCode validateCode = new ValidateCode(validateCodeString,bufferedImage);
		return validateCode;
	}
	
	private static Color randomColor()
	{
		int[] colorList = new int[3];
		
		for(int i = 0;i < 3;i++)
		{
			colorList[i] = random.nextInt(256);
		}
		
		return new Color(colorList[0],colorList[1],colorList[2]);
	}
}
