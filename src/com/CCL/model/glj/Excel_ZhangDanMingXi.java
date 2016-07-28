package com.CCL.model.glj;

import java.io.FileOutputStream;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.CCL.panel.glj.xitongguanli.son.ZhangDanMingXiSelect;

public class Excel_ZhangDanMingXi {

	private static ZhangDanMingXiSelect zhangDanMingXiSelect;

	public Excel_ZhangDanMingXi(ZhangDanMingXiSelect zhangDanMingXiSelect) {
		this.zhangDanMingXiSelect = zhangDanMingXiSelect;
	}

	private static Vector<Vector<Object>> getDate() throws Exception {
		Vector<Vector<Object>> tableValueV = zhangDanMingXiSelect
				.getZhangdanmingxi().getTableValueV();

		return tableValueV;
	}
/**
 * @Discribe 导出表格到指定位置
 * @param path
 * @return String
 */
	public static boolean exportExcel(String path) {
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
		cell.setCellValue("操作员");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("会员卡号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("会员姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("登记时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("结账时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("押金");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("消费金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("结账方式");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("消费时长");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("详情");
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
			int j = 0;
			row.createCell((short) 0).setCellValue(
					Integer.valueOf(vector.get(j++).toString()));
			row.createCell((short) 1).setCellValue(
					Integer.valueOf(vector.get(j++).toString()));
			row.createCell((short) 2).setCellValue(
					(String) vector.get(j++).toString());
			row.createCell((short) 3).setCellValue(
					(String) vector.get(j++).toString());
			row.createCell((short) 4).setCellValue(
					(String) vector.get(j++).toString());
			row.createCell((short) 5).setCellValue(
					(String) vector.get(j++).toString());
			row.createCell((short) 6).setCellValue((String) vector.get(j++));
			row.createCell((short) 7).setCellValue((String) vector.get(j++));
			row.createCell((short) 8).setCellValue((String) vector.get(j++));
			row.createCell((short) 9).setCellValue((String) vector.get(j++));
			row.createCell((short) 10).setCellValue((String) vector.get(j++));
			row.createCell((short) 11).setCellValue((String) vector.get(j++));

		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream(path);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}