package com.tgb.lk.test04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tgb.lk.util.ExcelUtil;

public class ImportTest04 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("d:\\success4.xls");
			ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(
					StudentVO.class);
			List<StudentVO> list = util.importExcel("ѧ����Ϣ", fis);
			System.out.println(list);
			//���:[StudentVO [birthday=2012/9/22 15:44:10, clazz=������߰�, company=null, name=����, sex=��], StudentVO [birthday=null, clazz=������߰�, company=null, name=�ܹ���, sex=��], StudentVO [birthday=null, clazz=������߰�, company=null, name=��ѧ��, sex=Ů]]
			System.out.println(convertStu2VO(list));
			//���:[Student [birthday=Sat Sep 22 15:44:10 CST 2012, clazz=5, company=null, id=0, name=����, sex=0], Student [birthday=null, clazz=5, company=null, id=0, name=�ܹ���, sex=0], Student [birthday=null, clazz=6, company=null, id=0, name=��ѧ��, sex=1]]
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static List<Student> convertStu2VO(List<StudentVO> list) {
		List<Student> retList = new ArrayList<Student>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
		for (int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			Student student = new Student();
			student.setName(vo.getName());

			//����������л����Կ��Ʋ�����Ϊ��,����ֵ����С��0�����100���߼�.
			
			String sex = vo.getSex();
			if (sex.equals("��")) {
				student.setSex(0);
			} else {
				student.setSex(1);
			}
			
			if (vo.getBirthday()!=null && !vo.getBirthday().trim().equals("")) {
				try {
					student.setBirthday(sdf.parse(vo.getBirthday()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			String clazz = vo.getClazz();
			if (clazz != null) {
				if (clazz.equals("������߰�")) {
					student.setClazz(5);
				} else if (clazz.equals("������߰�")) {
					student.setClazz(6);
				} else if (clazz.equals("������߰�")) {
					student.setClazz(7);
				} else {
					System.out.println("��������ݲ��Ϸ�");
				}
			}
			retList.add(student);
		}
		return retList;
	}
}
