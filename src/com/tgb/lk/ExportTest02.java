package com.tgb.lk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportTest02 {
	public static void main(String[] args) {
		// ��ʼ������
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < 10; i++) {
			Map map = new HashMap();
			map.put("id", i);
			map.put("name", "����" + i);
			list.add(map);
		}

		String[] alias = { "���", "����" };// excel����ͷ
		String[] names = { "id", "name" };// ����List�е�Map��keyֵ.
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("d:\\success2.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		exportExcel(list, alias, names, "ѧ����Ϣ��", 60000, out);
		System.out.println("----ִ�����----------");
	}

	/**
	 * ��list����Դ������������ݵ��뵽excel��
	 * 
	 * @param fieldName
	 *            [] ������excel�ļ���ı�ͷ��
	 * @param columnIt
	 *            [] ������excel�ļ���ı�ͷNAME
	 * @param sheetName
	 *            �����������
	 * @param sheetSize
	 *            ÿ��sheet�����ݵ�����,����ֵ����С��65536
	 * @param output
	 *            java�����
	 */
	public static boolean exportExcel(List list, String[] fieldName,
			Object[] columnIt, String sheetName, int sheetSize,
			OutputStream output) {
		HSSFWorkbook workbook = new HSSFWorkbook();// ��������������
		if (sheetSize >= 65536) {
			sheetSize = 65536;
		}
		double sheetNo = Math.ceil(list.size() / sheetSize);
		for (int index = 0; index <= sheetNo; index++) {
			HSSFSheet sheet = workbook.createSheet();// �������������
			workbook.setSheetName(index, sheetName+index);//���ù����������.
			HSSFRow row = sheet.createRow(0);// ����һ��
			HSSFCell cell;// ������Ԫ��

			// д������ֶε�����
			for (int i = 0; i < fieldName.length; i++) {
				cell = row.createCell(i); // ������һ�и����ֶ����Ƶĵ�Ԫ��
				cell.setCellType(HSSFCell.CELL_TYPE_STRING); // ���õ�Ԫ������Ϊ�ַ�����
				// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				// //Ϊ�����ڵ�Ԫ������������,�����ַ���ΪUTF_16
				cell.setCellValue(fieldName[i]); // ����Ԫ�����ݸ�ֵ
			}

			int startNo = index * sheetSize;
			int endNo = Math.min(startNo + sheetSize, list.size());
			// д�������¼,ÿ����¼��Ӧexcel���е�һ��
			for (int i = startNo; i < endNo; i++) {
				row = sheet.createRow(i + 1 - startNo);
				HashMap map = (HashMap) list.get(i);
				for (int j = 0; j < columnIt.length; j++) {
					cell = row.createCell(j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					Object value = map.get(columnIt[j]);
					if (value != null) {
						cell.setCellValue(map.get(columnIt[j]).toString());
					} else
						cell.setCellValue("");
				}
			}
		}
		try {
			output.flush();
			workbook.write(output);
			output.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Output is closed ");
			return false;
		}

	}
}
