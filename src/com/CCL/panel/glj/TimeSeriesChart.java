package com.CCL.panel.glj;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.CCL.service.glj.XiaoShouQuShiService;
import com.CCL.util.glj.DateUtil;
import com.CCL.util.glj.DateUtils;

public class TimeSeriesChart {
	ChartPanel frame1;

	public TimeSeriesChart(String opeUser_name, String bill_payway,
			String stime, String etime) {
		XYDataset xydataset = createDataset(opeUser_name, bill_payway, stime,
				etime);
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("自行车租赁",
				"日期", "数量", xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
		dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
		frame1 = new ChartPanel(jfreechart, true);
		dateaxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		dateaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = xyplot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体

	}

	private static XYDataset createDataset(String opeUser_name,
			String bill_payway, String stime, String etime) { // 这个数据集有点多，但都不难理解
		@SuppressWarnings("deprecation")
		TimeSeries timeseries1 = new TimeSeries("单人车",
				Day.class);
		@SuppressWarnings("deprecation")
		TimeSeries timeseries2 = new TimeSeries("双人车",
				Day.class);
		@SuppressWarnings("deprecation")
		TimeSeries timeseries4 = new TimeSeries("四人车",
				Day.class);
		boolean result = false;
		boolean stop = false;
		int num1 = 0;
		int num2 = 0;
		int num4 = 0;
		Calendar x = Calendar.getInstance();
		x.setTime(DateUtil.paseDate(stime));// stime
		while (!stop) {
			System.out.println("jinglai");
			if (result) {
				x.add(Calendar.DAY_OF_YEAR, 1);
			}
//			Date stim = x.getTime();
			String stim = DateUtil.formatDate1(x.getTime());
			Vector<Vector<Object>> tableValue = XiaoShouQuShiService
					.getTableDate(opeUser_name, bill_payway, stime, etime);
			int j = 0;
			for (Vector<Object> vector : tableValue) {
				j++;
				Date time = DateUtil.paseDate(vector.get(6).toString());
				String xiangxi = ((String) vector.get(11)).trim();// 获得 详细 那一列
				String[] str = xiangxi.split(" ");
				if (DateUtils.isEqual(time, DateUtil.paseDate(stim))) {
					for (int i = 0; i < str.length; i++) {
						if (str[0].equals("单人车")) {
							String num = str[1].length() == 2 ? str[1]
									.substring(0, 1) : str[1].substring(0, 2);
							num1 = num1 + Integer.valueOf(num);
						} else if (str[0].equals("双人车")) {
							String num = str[1].substring(0, 1);
							num2 = num2 + Integer.valueOf(num);
						} else if (str[0].equals("四人车")) {
							String num = str[1].substring(0, 1);
							num4 = num4 + Integer.valueOf(num);
						}
					}
				}
				if (DateUtils.isEqual(DateUtil.paseDate(etime), DateUtil.paseDate(stim))
						&& j == tableValue.size()) {
					stop = true;
					System.out.println(xiangxi);
				}
			}
			result = true;
			timeseries1.add(new Day(DateUtil.paseDate(stim)), num1);
			timeseries2.add(new Day(DateUtil.paseDate(stim)), num2);
			timeseries4.add(new Day(DateUtil.paseDate(stim)), num4);
		}
		TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
		timeseriescollection.addSeries(timeseries1);
		timeseriescollection.addSeries(timeseries2);
		timeseriescollection.addSeries(timeseries4);

		return timeseriescollection;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}

}