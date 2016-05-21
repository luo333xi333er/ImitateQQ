package com.niit.entity;
/**
 * 好友信息
 */
public class Stranger {
	
	//好友昵称
	private String name;
	//好友账号
	private String account;
	//密码
	private String password;
	//性别
	private String sex;
	//年龄
	private int age;
	//城市
	private String city;
	
	//构造方法
	public Stranger() {
	}
	
	public Stranger(String account) {
		this.account = account;
	}
	
	public Stranger(String account, String password) {
		this.account = account;
		this.password = password;
	}
	
	public Stranger(String name, String account, String password, String sex,
			int age, String city) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.city = city;
	}

	//提供get和set方法
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
	
	//打印
	public void print() {
		System.out.println(account + "\t" + password);
	}
}
