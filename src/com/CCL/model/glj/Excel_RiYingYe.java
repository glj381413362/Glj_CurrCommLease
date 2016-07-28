package com.CCL.model.glj;
    import java.io.FileOutputStream;  
    import java.text.SimpleDateFormat;  
    import java.util.ArrayList;  
    import java.util.List;  
import java.util.Vector;
      
    import org.apache.poi.hssf.usermodel.HSSFCell;  
    import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
    import org.apache.poi.hssf.usermodel.HSSFRow;  
    import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

import com.CCL.panel.glj.xitongguanli.son.RiYinYeSelect;
      
    public class Excel_RiYingYe  
    {  
    	
    	private static  RiYinYeSelect riYinYeSelect;
    	
    	public Excel_RiYingYe(RiYinYeSelect riYinYeSelect)
    	{
    		this.riYinYeSelect = riYinYeSelect;
    	}
       
        private static Vector<Vector<Object>> getDate() throws Exception  
        {  
        	Vector<Vector<Object>> tableValueV = riYinYeSelect.getRiYinYeTablePanel().getTableValueV();
      
          
      
            return tableValueV;  
        }  
        /**
         * @Discribe 导出表格到指定位置
         * @param path
         * @return String
         */
      public static boolean exportExcel(String path)
      {
    	  // 第一步，创建一个webbook，对应一个Excel文件  
          HSSFWorkbook wb = new HSSFWorkbook();  
          // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
          HSSFSheet sheet = wb.createSheet("学生表一");  
          // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
          HSSFRow row = sheet.createRow((int) 0);  
          // 第四步，创建单元格，并设置值表头 设置表头居中  
          HSSFCellStyle style = wb.createCellStyle();  
          style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
    
          HSSFCell cell = row.createCell((short) 0);  
          cell.setCellValue("序号");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 1);  
          cell.setCellValue("账单编号");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 2);  
          cell.setCellValue("时间");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 3);  
          cell.setCellValue("总收入");  
          cell.setCellStyle(style); 
          cell = row.createCell((short) 4);  
          cell.setCellValue("单人车");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 5);  
          cell.setCellValue("双人车");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 6);  
          cell.setCellValue("四人车");  
          cell.setCellStyle(style);  
    
    
          // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
          
          Vector<Vector<Object>> value = null;
		try {
			value = getDate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          int i = 1;
          for (Vector<Object> vector : value) {
          	row = sheet.createRow((int) i++); 
          	int j =0;
          	row.createCell((short) 0).setCellValue((int) vector.get(j++));
          	row.createCell((short) 1).setCellValue(Integer.valueOf(vector.get(j++).toString()));
          	row.createCell((short) 2).setCellValue((String) vector.get(j++));
          	row.createCell((short) 3).setCellValue((String) vector.get(j++));
          	row.createCell((short) 4).setCellValue((String) vector.get(j++));
          	row.createCell((short) 5).setCellValue((String) vector.get(j++));
          	row.createCell((short) 6).setCellValue((String) vector.get(j++));
				
			}
          // 第六步，将文件存到指定位置  
          try  
          {  
              FileOutputStream fout = new FileOutputStream(path);  
              wb.write(fout);  
              fout.close();  
          }  
          catch (Exception e)  
          {  
              e.printStackTrace();  
          }  
      
          return true;
      }
    }  