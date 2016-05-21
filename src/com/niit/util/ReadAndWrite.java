package com.niit.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.niit.entity.Friends;
import com.niit.entity.Stranger;
import com.niit.entity.LoginUser;

public class ReadAndWrite {

	//定义存放 登录用户信息的集合
	private List<LoginUser> userList;
	//定义存放路人信息的集合
	private List<Stranger> strangerList;
	//定义存放好友信息的集合
	private List<Friends> friendList;
	
	//构造方法
	public ReadAndWrite() {
		//实例化用户集合
		userList = new ArrayList<LoginUser>();
		//实例化路人集合
		strangerList = new ArrayList<Stranger>();
		//实例化好友集合
		friendList = new ArrayList<Friends>();
	}
	
	/**
	 * 验证登录
	 */
	public boolean login(String account,String password){
		boolean flag = false;
		List<LoginUser> list = readAll();
		for (LoginUser loginUser : list) {
			if(loginUser.getAccount().equals(account) && loginUser.getPassword().equals(password)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 读取登录用户信息到集合
	 */
	public List<LoginUser> readAll() {
		//存放用户信息路径
		String path = "LoginUser.txt";
		//实例化文件对象
		File file = new File(path);
		if(file.exists()) {
			//定义字符缓冲流
			BufferedReader br = null;
			try {
				//实例化字符缓存流
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//判断@开头的跳过 用户信息标题
					if(line.startsWith("@")) {
						continue;
					}
					//判断#开头的是用户信息
					if(line.startsWith("#")) {
						//去除# 然后按照空格拆分
						String[] str = line.replace("#", "").split(" ");
						//实例化用户信息并赋予值  昵称 账号 密码 性别 年龄 城市
						LoginUser user = new LoginUser();
						user.setName(str[0]);
						user.setAccount(str[1]);
						user.setPassword(str[2]);
						user.setSex(str[3]);
						user.setAge(Integer.parseInt(str[4]));
						user.setCity(str[5]);
						//将信息放入用户集合
						userList.add(user);
					}
				}
			} catch (Exception e) {
				System.out.println("读取文件出错了！" + e.getMessage());
			} finally {
				try {
					if(br != null) {
						br.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return userList;
	}

	
	/**
	 * 将注册用户的信息写入到文件中
	 */
	public void writeAll() {
		//存放路径
		String path = "LoginUser.txt";
		//缓冲字符流
		BufferedWriter bw = null;
		try {
			//实例化缓冲字符流
			bw = new BufferedWriter(new FileWriter(path, true));
			String s = "#";
			s += userList.get(userList.size() - 1).getName() + " ";
			s += userList.get(userList.size() - 1).getAccount() + " ";
			s += userList.get(userList.size() - 1).getPassword() + " ";
			s += userList.get(userList.size() - 1).getSex() + " ";
			s += userList.get(userList.size() - 1).getAge() + " ";
			s += userList.get(userList.size() - 1).getCity();
			//写入
			bw.write("\r\n" + s);
			System.out.println("写入成功！");
		} catch (Exception e) {
			System.out.println("写入出错了:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
	
	
	/**
	 * 读取陌生人信息到集合
	 */
	public List<Stranger> readStranger() {
		//存放用户信息路径
		String path = "Stranger.txt";
		//实例化文件对象
		File file = new File(path);
		if(file.exists()) {
			//定义字符缓冲流
			BufferedReader br = null;
			try {
				//实例化字符缓存流
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//判断@开头的跳过 用户信息标题
					if(line.startsWith("@")) {
						continue;
					}
					//判断#开头的是用户信息
					if(line.startsWith("#")) {
						//去除# 然后按照空格拆分
						String[] str = line.replace("#", "").split(" ");
						//实例化路人信息并赋予值  昵称 账号 密码 性别 年龄 城市
						Stranger stranger = new Stranger();
						stranger.setName(str[0]);
						stranger.setAccount(str[1]);
						stranger.setPassword(str[2]);
						stranger.setSex(str[3]);
						stranger.setAge(Integer.parseInt(str[4]));
						stranger.setCity(str[5]);
						//将信息放入用户集合
						strangerList.add(stranger);
					}
				}
			} catch (Exception e) {
				System.out.println("读取文件出错了！" + e.getMessage());
			} finally {
				try {
					if(br != null) {
						br.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return strangerList;
	}
	
	/**
	 * 读取好友信息到集合
	 * @param friendList2 
	 */
	public List<Friends> readFriends() {
		//存放用户信息路径
		String path = "Friends.txt";
		//实例化文件对象
		File file = new File(path);
		if(file.exists()) {
			//定义字符缓冲流
			BufferedReader br = null;
			try {
				//实例化字符缓存流
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//判断@开头的跳过 用户信息标题
					if(line.startsWith("@")) {
						continue;
					}
					//判断#开头的是用户信息
					if(line.startsWith("#")) {
						//去除# 然后按照空格拆分
						String[] str = line.replace("#", "").split(" ");
						//实例化好友信息并赋予值  昵称 账号 密码 性别 年龄 城市
						Friends friends = new Friends();
						friends.setName(str[0]);
						friends.setAccount(str[1]);
						friends.setPassword(str[2]);
						friends.setSex(str[3]);
						friends.setAge(Integer.parseInt(str[4]));
						friends.setCity(str[5]);
						//将信息放入用户集合
						friendList.add(friends);
					}
				}
			} catch (Exception e) {
				System.out.println("读取文件出错了！" + e.getMessage());
			} finally {
				try {
					if(br != null) {
						br.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return friendList;
	}
	
	
	/**
	 * 将好友信息写入到文件中
	 */
	public void writeFriends() {
		//存放路径
		String path = "Friends.txt";
		//缓冲字符流
		BufferedWriter bw = null;
		try {
			//实例化缓冲字符流
			bw = new BufferedWriter(new FileWriter(path, true));
			String s = "#";
			s += friendList.get(friendList.size() - 1).getName() + " ";
			s += friendList.get(friendList.size() - 1).getAccount() + " ";
			s += friendList.get(friendList.size() - 1).getPassword() + " ";
			s += friendList.get(friendList.size() - 1).getSex() + " ";
			s += friendList.get(friendList.size() - 1).getAge() + " ";
			s += friendList.get(friendList.size() - 1).getCity();
			//写入
			bw.write("\r\n" + s);
			System.out.println("写入成功！");
		} catch (Exception e) {
			System.out.println("写入出错了:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
	
	public void writeFr() {
		//存放路径
		String path = "Friends.txt";
		//缓冲字符流
		BufferedWriter bw = null;
		try {
			//实例化缓冲字符流
			bw = new BufferedWriter(new FileWriter(path));
			//循环写入好友信息
			for (Friends friends : friendList) {
				String s = "#";
				s += friends.getName() + " ";
				s += friends.getAccount() + " ";
				s += friends.getPassword() + " ";
				s += friends.getSex() + " ";
				s += friends.getAge() + " ";
				s += friends.getCity();
				//写入
				bw.write("\r\n" + s);
				System.out.println("写入成功！");
			}
		} catch (Exception e) {
			System.out.println("写入出错了:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
}
