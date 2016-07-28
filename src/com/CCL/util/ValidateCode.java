package com.CCL.util;

import java.awt.image.BufferedImage;

public class ValidateCode {
	
	private String validateCodeString;
	private BufferedImage bufferedImage;
	
	public ValidateCode()
	{
		
	}
	
	public ValidateCode(String validateCodeString,BufferedImage bufferedImage)
	{
		this.validateCodeString = validateCodeString;
		this.bufferedImage = bufferedImage;
	}
	
	public String getValidateCodeString() {
		return validateCodeString;
	}
	public void setValidateCodeString(String validateCodeString) {
		this.validateCodeString = validateCodeString;
	}
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}
