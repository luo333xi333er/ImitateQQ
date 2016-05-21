package com.niit.entity;

/**
 * 作为Tree中添加的 好友 节点值
 */
public class Node {
	
	private  String account;		//QQ号码
	private  String name;	//昵称
	private  String image;  //头像名称
	
	/**
	 * 带参的构造函数
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
	 * 提供get和set方法
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
