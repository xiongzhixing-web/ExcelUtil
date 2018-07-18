package com.tgb.lk.test03;

import com.tgb.lk.util.ExcelVOAttribute;

public class StudentVO {
	@ExcelVOAttribute(name = "���", column = "A")
	private int id;

	@ExcelVOAttribute(name = "����", column = "B", isExport = true)
	private String name;

	@ExcelVOAttribute(name = "����", column = "C", prompt = "���䱣��Ŷ!", isExport = false)
	private int age;

	@ExcelVOAttribute(name = "�༶", column = "D", combo = { "������߰�", "������߰�",
			"������߰�" })
	private String clazz;

	@ExcelVOAttribute(name = "��˾", column = "F")
	private String company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", company="
				+ company + ", age=" + age + ", clazz=" + clazz + "]";
	}

}
