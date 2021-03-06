package com.CCL.view.other.son;

import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.Properties;

 
public class Util_pro {  
	 
	private static String filePath = "config/sms_properties";

    private static Properties props = new Properties();  
	
	public static String readData(String key) {
		
        try {  
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));  
            props.load(in);  
            in.close();  
            String value = props.getProperty(key);  
            return value;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  

	}

	public  static void writeData(String key, String value) throws IOException {

		InputStream fis = new FileInputStream(filePath);
        //从输入流中读取属性列表（键和元素对）
        props.load(fis);
        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性,强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream fos = new FileOutputStream(filePath);
        props.setProperty(key, value);
        //以适合使用 load 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流
        props.store(fos, "Update '" + key + "' value");
       
		
	}
      
}  