package com.niit.entity;

/**
 * ��ΪTree����ӵ� ���� �ڵ�ֵ
 */
public class Node {
	
	private  String account;		//QQ����
	private  String name;	//�ǳ�
	private  String image;  //ͷ������
	
	/**
	 * ���εĹ��캯��
	 */
	public Node(String account, String name, String image) {
		this.account = account;
		this.name = name;
		this.image = image;
	}
	
	public Node(String account, String name) {
		this.account = account;
		this.name = name;
		this.image = "admin.png";
	}
	
	/**
	 * �ṩget��set����
	 */
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
