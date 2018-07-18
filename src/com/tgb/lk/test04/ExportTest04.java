package com.tgb.lk.test04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tgb.lk.util.ExcelUtil;

/*
 * ʹ�ò���:
 * 1.�½�һ����,����StudentVO.
 * 2.������Щ������Ҫ����,��Щ��Ҫ������ʾ.
 * 3.����ʵ������
 * 4.����exportExcel����.
 * ���������ṩ��������Ľ������:
 * 1.ʵ������ŵ�ֵ��Ҫת��Ϊ�������ֵ����,����:ʵ������0,1��ʾ��,Ů;�����뵼����excel�������ĵ�"��","Ů".
 * 2.ʵ������ʱ�����ʹ���.
 * 
 */
public class ExportTest04 {
	public static void main(String[] args) {
		// ��ʼ������
		List<Student> list = new ArrayList<Student>();

		Student stu = new Student();
		stu.setId(1);
		stu.setName("����");
		stu.setSex(0);
		stu.setClazz(5);
		stu.setCompany("������");
		stu.setBirthday(new Date());
		list.add(stu);

		Student stu2 = new Student();
		stu2.setId(2);
		stu2.setName("�ܹ���");
		stu2.setSex(0);
		stu2.setClazz(5);
		stu2.setCompany("����");
		list.add(stu2);

		Student stu3 = new Student();
		stu3.setId(3);
		stu3.setName("��ѧ��");
		stu3.setSex(1);
		stu3.setClazz(6);
		list.add(stu3);

		FileOutputStream out = null;
		try {
			out = new FileOutputStream("d:\\success4.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ExcelUtil<StudentVO> util = new ExcelUtil<StudentVO>(StudentVO.class);
		util.exportExcel(convertStu2VO(list), "ѧ����Ϣ", 60000, out);
		System.out.println("----ִ�����----------");
	}
	
	//��student����ת��ΪstudentVO���ڵ���.
	private static List<StudentVO> convertStu2VO(List<Student> list) {
		List<StudentVO> list2 = new ArrayList<StudentVO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
		for (int i = 0; i < list.size(); i++) {
			StudentVO stuVo = new StudentVO();
			Student stu = list.get(i);
			stuVo.setName(stu.getName());
			switch (stu.getSex()) {
			case 0:
				stuVo.setSex("��");
				break;
			case 1:
				stuVo.setSex("Ů");
				break;
			default:
				break;
			}
			//����ʱ��
			if (stu.getBirthday() != null) {
				stuVo.setBirthday(sdf.format(stu.getBirthday()));
			}

			switch (stu.getClazz()) {
			case 5:
				stuVo.setClazz("������߰�");
				break;
			case 6:
				stuVo.setClazz("������߰�");
				break;
			case 7:
				stuVo.setClazz("������߰�");
			default:
				break;
			}
			list2.add(stuVo);
		}

		return list2;
	}

}
