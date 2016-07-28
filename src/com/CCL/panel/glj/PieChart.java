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
	      JFreeChart chart = ChartFactory.createPieChart3D("���г�����",data,true,false,false);
	    //���ðٷֱ�
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������
	      NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����
	      pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�
	  
	  //û�����ݵ�ʱ����ʾ������
	      pieplot.setNoDataMessage("��������ʾ");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ
	      pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
	      PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
	      piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������
	      chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
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
      	 dataset.setValue("���˳�",num1);
         dataset.setValue("˫�˳�",num2);
         dataset.setValue("���˳�",num4);
		}        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
    public static void main(String[] args) {
    	JFrame frame=new JFrame("Java����ͳ��ͼ");
    	frame.setLayout(new GridLayout(1,1,10,10));
    	frame.add(new PieChart("����","����","2012-1-1","2017-1-1").getChartPanel());           //�������ͼ
//    	frame.add(new BarChart1().getChartPanel());          //�������ͼ����һ��Ч��
//    	frame.add(new PieChart().getChartPanel());           //��ӱ�״ͼ
//    	frame.add(new TimeSeriesChart().getChartPanel());    //�������ͼ
    	frame.setBounds(50, 50, 800, 600);
    	frame.setVisible(true);
	}
}