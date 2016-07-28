package com.CCL.util;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public abstract class Globel {
	
	
    private Globel() {
		
	 }
	
	public static void centerByWindow(Window w) {
		//获得操作系统的分辨率
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int sw = (int)screen.getWidth();
		int sh = (int)screen.getHeight();
		
		int ww = w.getWidth();
		int wh = w.getHeight();
		
		if(ww > sw) {
			ww = sw;
		}
		if(wh > sh) {
			wh = sh;
		}
		
		w.setSize(ww, wh);
		
		w.setLocation((sw-ww)/2, (sh-wh)/2);
	}

}
