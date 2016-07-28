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
 * @Discribe �������ָ��λ��
 * @param path
 * @return String
 */
	public static boolean exportExcel(String path) {
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
		cell.setCellValue("����Ա");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("��Ա����");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("��Ա����");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("�Ǽ�ʱ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("����ʱ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("Ѻ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("���ѽ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("���˷�ʽ");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("����ʱ��");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("����");
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
		// �����������ļ��浽ָ��λ��
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