package com.CCL.panel.glj;

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
 
public class BarChart_jidu {  
   ChartPanel frame1;  
   public  BarChart_jidu(String opeUser_name,String bill_payway,String stim, String etime){  
       CategoryDataset dataset = getDataSet(opeUser_name,bill_payway,stim,etime);  
       JFreeChart chart = ChartFactory.createBarChart3D(  
                            "自行车各季度销售情况", // 图表标题  
                           "自行车类型", // 目录轴的显示标签  
                           "数量", // 数值轴的显示标签  
                           dataset, // 数据集  
                           PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                           true,           // 是否显示图例(对于简单的柱状图必须是false)  
                           false,          // 是否生成工具  
                           false           // 是否生成URL链接  
                           );  
         
       //从这里开始  
       CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
       CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
         chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
         chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
           
         //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
           
        frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame  
          
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
        		  if(str[0].equals("单人车"))
        		  {
        			  String num = str[1].length()==2 ? str[1].substring(0,1) : str[1].substring(0,2);
        			  num1 = num1 + Integer.valueOf(num);
        		  }else if (str[0].equals("双人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  num2 = num2 + Integer.valueOf(num);
        		  }else if (str[0].equals("四人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  num4 = num4 + Integer.valueOf(num);
        		  }
        	  }
        	 
		}
          dataset.addValue(num1, "单人车", "春季");  
		  dataset.addValue(num2, "双人车", "春季");  
		  dataset.addValue(num4, "四人车", "春季");  
		  int x_num1= 0;
		  int x_num2 = 0;
		  int x_num4 = 0;
          for (Vector<Object> vector : tableValue) {
        	  String xiangxi = ((String) vector.get(11)).trim();
        	  String[] str =xiangxi.split(" "); 
    		 
        	  for(int i =0 ; i <str.length; i ++)
        	  {
        		  if(str[0].equals("单人车"))
        		  {
        			  String num = str[1].length()==2 ? str[1].substring(0,1) : str[1].substring(0,2);
        			  x_num1 = x_num1 + Integer.valueOf(num);
        		  }else if (str[0].equals("双人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  x_num2 = x_num2 + Integer.valueOf(num);
        		  }else if (str[0].equals("四人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  x_num4 = x_num4 + Integer.valueOf(num);
        		  }
        	  }
        	 
		}
          dataset.addValue(x_num1, "单人车", "夏季");  
		  dataset.addValue(x_num2, "双人车", "夏季");  
		  dataset.addValue(x_num4, "四人车", "夏季");  
		  int q_num1= 0;
		  int q_num2 = 0;
		  int q_num4 = 0;
          for (Vector<Object> vector : tableValue) {
        	  String xiangxi = ((String) vector.get(11)).trim();
        	  String[] str =xiangxi.split(" "); 
    		 
        	  for(int i =0 ; i <str.length; i ++)
        	  {
        		  if(str[0].equals("单人车"))
        		  {
        			  String num = str[1].length()==2 ? str[1].substring(0,1) : str[1].substring(0,2);
        			  q_num1 = q_num1 + Integer.valueOf(num);
        		  }else if (str[0].equals("双人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  q_num2 = q_num2 + Integer.valueOf(num);
        		  }else if (str[0].equals("四人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  q_num4 = q_num4 + Integer.valueOf(num);
        		  }
        	  }
        	 
		}
          dataset.addValue(q_num1, "单人车", "秋季");  
		  dataset.addValue(q_num2, "双人车", "秋季");  
		  dataset.addValue(q_num4, "四人车", "秋季");  
		  int d_num1= 0;
		  int d_num2 = 0;
		  int d_num4 = 0;
          for (Vector<Object> vector : tableValue) {
        	  String xiangxi = ((String) vector.get(11)).trim();
        	  String[] str =xiangxi.split(" "); 
    		 
        	  for(int i =0 ; i <str.length; i ++)
        	  {
        		  if(str[0].equals("单人车"))
        		  {
        			  String num = str[1].length()==2 ? str[1].substring(0,1) : str[1].substring(0,2);
        			  d_num1 = d_num1 + Integer.valueOf(num);
        		  }else if (str[0].equals("双人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  d_num2 = d_num2 + Integer.valueOf(num);
        		  }else if (str[0].equals("四人车"))
        		  {
        			  String num = str[1].substring(0,1);
        			  d_num4 = d_num4 + Integer.valueOf(num);
        		  }
        	  }
        	 
		}
          dataset.addValue(d_num1, "单人车", "冬季");  
		  dataset.addValue(d_num2, "双人车", "冬季");  
		  dataset.addValue(d_num4, "四人车", "冬季");  
        
          
          
          return dataset;  
}  
public ChartPanel getChartPanel(){  
   return frame1;  
     
}  
public static void main(String[] args) {
	JFrame frame=new JFrame("Java数据统计图");
	frame.setLayout(new GridLayout(1,1,10,10));
	frame.add(new BarChart_jidu("所有","所有","2012-1-1","2017-1-1").getChartPanel());           //添加柱形图
//	frame.add(new BarChart1().getChartPanel());          //添加柱形图的另一种效果
//	frame.add(new PieChart().getChartPanel());           //添加饼状图
//	frame.add(new TimeSeriesChart().getChartPanel());    //添加折线图
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
}
}  