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

	//������ ��¼�û���Ϣ�ļ���
	private List<LoginUser> userList;
	//������·����Ϣ�ļ���
	private List<Stranger> strangerList;
	//�����ź�����Ϣ�ļ���
	private List<Friends> friendList;
	
	//���췽��
	public ReadAndWrite() {
		//ʵ�����û�����
		userList = new ArrayList<LoginUser>();
		//ʵ����·�˼���
		strangerList = new ArrayList<Stranger>();
		//ʵ�������Ѽ���
		friendList = new ArrayList<Friends>();
	}
	
	/**
	 * ��֤��¼
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
	 * ��ȡ��¼�û���Ϣ������
	 */
	public List<LoginUser> readAll() {
		//����û���Ϣ·��
		String path = "LoginUser.txt";
		//ʵ�����ļ�����
		File file = new File(path);
		if(file.exists()) {
			//�����ַ�������
			BufferedReader br = null;
			try {
				//ʵ�����ַ�������
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//�ж�@��ͷ������ �û���Ϣ����
					if(line.startsWith("@")) {
						continue;
					}
					//�ж�#��ͷ�����û���Ϣ
					if(line.startsWith("#")) {
						//ȥ��# Ȼ���տո���
						String[] str = line.replace("#", "").split(" ");
						//ʵ�����û���Ϣ������ֵ  �ǳ� �˺� ���� �Ա� ���� ����
						LoginUser user = new LoginUser();
						user.setName(str[0]);
						user.setAccount(str[1]);
						user.setPassword(str[2]);
						user.setSex(str[3]);
						user.setAge(Integer.parseInt(str[4]));
						user.setCity(str[5]);
						//����Ϣ�����û�����
						userList.add(user);
					}
				}
			} catch (Exception e) {
				System.out.println("��ȡ�ļ������ˣ�" + e.getMessage());
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
	 * ��ע���û�����Ϣд�뵽�ļ���
	 */
	public void writeAll() {
		//���·��
		String path = "LoginUser.txt";
		//�����ַ���
		BufferedWriter bw = null;
		try {
			//ʵ���������ַ���
			bw = new BufferedWriter(new FileWriter(path, true));
			String s = "#";
			s += userList.get(userList.size() - 1).getName() + " ";
			s += userList.get(userList.size() - 1).getAccount() + " ";
			s += userList.get(userList.size() - 1).getPassword() + " ";
			s += userList.get(userList.size() - 1).getSex() + " ";
			s += userList.get(userList.size() - 1).getAge() + " ";
			s += userList.get(userList.size() - 1).getCity();
			//д��
			bw.write("\r\n" + s);
			System.out.println("д��ɹ���");
		} catch (Exception e) {
			System.out.println("д�������:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
	
	
	/**
	 * ��ȡİ������Ϣ������
	 */
	public List<Stranger> readStranger() {
		//����û���Ϣ·��
		String path = "Stranger.txt";
		//ʵ�����ļ�����
		File file = new File(path);
		if(file.exists()) {
			//�����ַ�������
			BufferedReader br = null;
			try {
				//ʵ�����ַ�������
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//�ж�@��ͷ������ �û���Ϣ����
					if(line.startsWith("@")) {
						continue;
					}
					//�ж�#��ͷ�����û���Ϣ
					if(line.startsWith("#")) {
						//ȥ��# Ȼ���տո���
						String[] str = line.replace("#", "").split(" ");
						//ʵ����·����Ϣ������ֵ  �ǳ� �˺� ���� �Ա� ���� ����
						Stranger stranger = new Stranger();
						stranger.setName(str[0]);
						stranger.setAccount(str[1]);
						stranger.setPassword(str[2]);
						stranger.setSex(str[3]);
						stranger.setAge(Integer.parseInt(str[4]));
						stranger.setCity(str[5]);
						//����Ϣ�����û�����
						strangerList.add(stranger);
					}
				}
			} catch (Exception e) {
				System.out.println("��ȡ�ļ������ˣ�" + e.getMessage());
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
	 * ��ȡ������Ϣ������
	 * @param friendList2 
	 */
	public List<Friends> readFriends() {
		//����û���Ϣ·��
		String path = "Friends.txt";
		//ʵ�����ļ�����
		File file = new File(path);
		if(file.exists()) {
			//�����ַ�������
			BufferedReader br = null;
			try {
				//ʵ�����ַ�������
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = br.readLine()) != null) {
					//�ж�@��ͷ������ �û���Ϣ����
					if(line.startsWith("@")) {
						continue;
					}
					//�ж�#��ͷ�����û���Ϣ
					if(line.startsWith("#")) {
						//ȥ��# Ȼ���տո���
						String[] str = line.replace("#", "").split(" ");
						//ʵ����������Ϣ������ֵ  �ǳ� �˺� ���� �Ա� ���� ����
						Friends friends = new Friends();
						friends.setName(str[0]);
						friends.setAccount(str[1]);
						friends.setPassword(str[2]);
						friends.setSex(str[3]);
						friends.setAge(Integer.parseInt(str[4]));
						friends.setCity(str[5]);
						//����Ϣ�����û�����
						friendList.add(friends);
					}
				}
			} catch (Exception e) {
				System.out.println("��ȡ�ļ������ˣ�" + e.getMessage());
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
	 * ��������Ϣд�뵽�ļ���
	 */
	public void writeFriends() {
		//���·��
		String path = "Friends.txt";
		//�����ַ���
		BufferedWriter bw = null;
		try {
			//ʵ���������ַ���
			bw = new BufferedWriter(new FileWriter(path, true));
			String s = "#";
			s += friendList.get(friendList.size() - 1).getName() + " ";
			s += friendList.get(friendList.size() - 1).getAccount() + " ";
			s += friendList.get(friendList.size() - 1).getPassword() + " ";
			s += friendList.get(friendList.size() - 1).getSex() + " ";
			s += friendList.get(friendList.size() - 1).getAge() + " ";
			s += friendList.get(friendList.size() - 1).getCity();
			//д��
			bw.write("\r\n" + s);
			System.out.println("д��ɹ���");
		} catch (Exception e) {
			System.out.println("д�������:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
	
	public void writeFr() {
		//���·��
		String path = "Friends.txt";
		//�����ַ���
		BufferedWriter bw = null;
		try {
			//ʵ���������ַ���
			bw = new BufferedWriter(new FileWriter(path));
			//ѭ��д�������Ϣ
			for (Friends friends : friendList) {
				String s = "#";
				s += friends.getName() + " ";
				s += friends.getAccount() + " ";
				s += friends.getPassword() + " ";
				s += friends.getSex() + " ";
				s += friends.getAge() + " ";
				s += friends.getCity();
				//д��
				bw.write("\r\n" + s);
				System.out.println("д��ɹ���");
			}
		} catch (Exception e) {
			System.out.println("д�������:" + e.getMessage());
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
}
