package com.CCL.panel;

import java.awt.Font;  
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  

import com.CCL.service.glj.XiaoShouQuShiService;
 
public class BarChart {  
   ChartPanel frame1;  
   public  BarChart(String opeUser_name,String bill_payway,String stim, String etime){  
       CategoryDataset dataset = getDataSet(opeUser_name,bill_payway,stim,etime);  
       JFreeChart chart = ChartFactory.createBarChart3D(  
                            "���г��������������", // ͼ�����  
                           "���г�����", // Ŀ¼�����ʾ��ǩ  
                           "����", // ��ֵ�����ʾ��ǩ  
                           dataset, // ���ݼ�  
                           PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                           true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                           false,          // �Ƿ����ɹ���  
                           false           // �Ƿ�����URL����  
                           );  
         
       //�����￪ʼ  
       CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
       CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
        domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
        ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
         chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
         chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
           
         //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
           
        frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
          
   }  
      private static CategoryDataset getDataSet(String opeUser_name,String bill_payway,String stim, String etime) {  
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
          int num1= 0;
		  int num2 = 0;
		  int num4 = 0;
          Vector<Vector<Object>>  tableValue = XiaoShouQuShiService.getTableDate(opeUser_name, bill_payway, stim, etime);
          for (Vector<Object> vector : tableValue) {
        	  String xiangxi = ((String) vector.get(11)).trim();
        	  String[] str =xiangxi.split(" "); 
    		 
        	  for(int i =0 ; i <str.length; i ++)
        	  {
        		  if(str[0].equals("���˳�"))
        		  {
        			  String num = str[1].length()==2 ? str[1].substring(0,1) : str[1].substring(0,2);
        			  num1 = num1 + Integer.valueOf(num);
        		  }else if (str[0].equals("˫�˳�"))
        		  {
        			  String num = str[1].substring(0,1);
        			  num2 = num2 + Integer.valueOf(num);
        		  }else if (str[0].equals("���˳�"))
        		  {
        			  String num = str[1].substring(0,1);
        			  num4 = num4 + Integer.valueOf(num);
        		  }
        	  }
        	 
		}
          dataset.addValue(num1, "���˳�", "���˳�");  
		  dataset.addValue(num2, "˫�˳�", "˫�˳�");  
		  dataset.addValue(num4, "���˳�", "���˳�");  
          
          return dataset;  
}  
public ChartPanel getChartPanel(){  
   return frame1;  
     
}  
public static void main(String[] args) {
	JFrame frame=new JFrame("Java����ͳ��ͼ");
	frame.setLayout(new GridLayout(1,1,10,10));
	frame.add(new BarChart("����","����","2012-1-1","2017-1-1").getChartPanel());           //�������ͼ
//	frame.add(new BarChart1().getChartPanel());          //�������ͼ����һ��Ч��
//	frame.add(new PieChart().getChartPanel());           //��ӱ�״ͼ
//	frame.add(new TimeSeriesChart().getChartPanel());    //�������ͼ
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
}
}  