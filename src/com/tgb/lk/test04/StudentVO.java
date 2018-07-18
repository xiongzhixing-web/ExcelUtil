package com.tgb.lk.test04;

import com.tgb.lk.util.ExcelVOAttribute;

public class StudentVO {

	@ExcelVOAttribute(name = "����", column = "B", isExport = true, prompt = "����Ϊ������Ŷ!")
	private String name;

	@ExcelVOAttribute(name = "�Ա�", column = "C", combo = { "��", "Ů" })
	private String sex;

	@ExcelVOAttribute(name = "�༶", column = "D", combo = { "������߰�", "������߰�",
			"������߰�" })
	private String clazz;
	
	@ExcelVOAttribute(name="����",column="E")
	private String birthday;

	@ExcelVOAttribute(name = "��˾", column = "F")
	private String company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "StudentVO [birthday=" + birthday + ", clazz=" + clazz
				+ ", company=" + company + ", name=" + name + ", sex=" + sex
				+ "]";
	}
}
