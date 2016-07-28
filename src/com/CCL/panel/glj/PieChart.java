package com.CCL.panel.glj;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JFrame;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.CCL.service.glj.XiaoShouQuShiService;

public class PieChart {
	ChartPanel frame1;
	public PieChart(String opeUser_name,String bill_payway,String stime, String etime){
		  DefaultPieDataset data = getDataSet(opeUser_name,bill_payway,stime,etime);
	      JFreeChart chart = ChartFactory.createPieChart3D("自行车租赁",data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
    private static DefaultPieDataset getDataSet(String opeUser_name,String bill_payway,String stim, String etime) {
        DefaultPieDataset dataset = new DefaultPieDataset();
      
        
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
      	 dataset.setValue("单人车",num1);
         dataset.setValue("双人车",num2);
         dataset.setValue("四人车",num4);
		}        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
    public static void main(String[] args) {
    	JFrame frame=new JFrame("Java数据统计图");
    	frame.setLayout(new GridLayout(1,1,10,10));
    	frame.add(new PieChart("所有","所有","2012-1-1","2017-1-1").getChartPanel());           //添加柱形图
//    	frame.add(new BarChart1().getChartPanel());          //添加柱形图的另一种效果
//    	frame.add(new PieChart().getChartPanel());           //添加饼状图
//    	frame.add(new TimeSeriesChart().getChartPanel());    //添加折线图
    	frame.setBounds(50, 50, 800, 600);
    	frame.setVisible(true);
	}
}