package com.tgb.lk.test03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.tgb.lk.util.ExcelUtil;

/*
 * ʹ�ò���:
 * 1.�½�һ����,����StudentVO.
 * 2.������Щ������Ҫ����,��Щ��Ҫ������ʾ.
 * 3.����ʵ������
 * 4.����exportExcel����.
 */
public class ExportTest03 {
	public static void main(String[] args) {
		// ��ʼ������
		List<StudentVO> list = new ArrayList<StudentVO>();

		StudentVO vo = new StudentVO();
		vo.setId(1);
		vo.setName("����");
		vo.setAge(26);
		vo.setClazz("������߰�");
		vo.setCompany("������");
		list.add(vo);

		StudentVO vo2 = new StudentVO();
		vo2.setId(2);
		vo2.setName("�ܹ���");
		vo2.setClazz("������߰�");
		vo2.setCompany("����");
		list.add(vo2);

		StudentVO vo3 = new StudentVO();
		vo3.setId(3);
		vo3.setName("����");
		vo3.setClazz("������߰�");
		list.add(vo3);

		FileOutputStream out = null;
		try {
			out = new FileOutputStream("d:\\success3.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(StudentVO.class);// ����������.
		util.exportExcel(list, "ѧ����Ϣ", 65536, out);// ����
		System.out.println("----ִ�����----------");
	}

}
