package com.niit.entity;
/**
 * ������Ϣ
 */
public class Friends {
	
	//�����ǳ�
	private String name;
	//�����˺�
	private String account;
	//����
	private String password;
	//�Ա�
	private String sex;
	//����
	private int age;
	//����
	private String city;
	
	//���췽��
	public Friends() {
	}
	
	public Friends(String account) {
		this.account = account;
	}
	
	public Friends(String account, String password) {
		this.account = account;
		this.password = password;
	}
	
	public Friends(String name, String account, String password, String sex,
			int age, String city) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.city = city;
	}

	//�ṩget��set����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	//��ӡ
	public void print() {
		System.out.println(account + "\t" + password);
	}
}
