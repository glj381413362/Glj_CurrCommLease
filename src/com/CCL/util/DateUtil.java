package com.CCL.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getDate(Date date){
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormater.format(date);
	}
}
