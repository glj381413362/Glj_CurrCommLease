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
         * @Discribe �������ָ��λ��
         * @param path
         * @return String
         */
      public static boolean exportExcel(String path)
      {
    	  // ��һ��������һ��webbook����Ӧһ��Excel�ļ�  
          HSSFWorkbook wb = new HSSFWorkbook();  
          // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet  
          HSSFSheet sheet = wb.createSheet("ѧ����һ");  
          // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short  
          HSSFRow row = sheet.createRow((int) 0);  
          // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����  
          HSSFCellStyle style = wb.createCellStyle();  
          style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ  
    
          HSSFCell cell = row.createCell((short) 0);  
          cell.setCellValue("���");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 1);  
          cell.setCellValue("�˵����");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 2);  
          cell.setCellValue("ʱ��");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 3);  
          cell.setCellValue("������");  
          cell.setCellStyle(style); 
          cell = row.createCell((short) 4);  
          cell.setCellValue("���˳�");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 5);  
          cell.setCellValue("˫�˳�");  
          cell.setCellStyle(style);  
          cell = row.createCell((short) 6);  
          cell.setCellValue("���˳�");  
          cell.setCellStyle(style);  
    
    
          // ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
          
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
          // �����������ļ��浽ָ��λ��  
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