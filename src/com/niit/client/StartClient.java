package com.niit.client;

import java.net.InetSocketAddress;

import javax.swing.JOptionPane;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.niit.ui.ChatFrame;
import com.niit.ui.FriendMessageFrame;
import com.niit.ui.GotoFrame;
import com.niit.ui.FriendListFrame;
import com.niit.ui.LoadingFrame;
import com.niit.ui.LoginFrame;
import com.niit.ui.ReceiverFrame;
import com.niit.ui.RegestFrame;
import com.niit.ui.SelfMessageFrame;
import com.niit.ui.SenderFrame;
import com.niit.ui.addFriendFrame;
public class StartClient {
	//����һ��ͼ�괰��
	//����һ��ͼ�괰��
	private GotoFrame gotoFrame;
	private  LoginFrame  loginFrame;
	private LoadingFrame  loadingFrame;
	private FriendListFrame friendListFrame;
	private SelfMessageFrame selfMessageFrame;
	private FriendMessageFrame friendMessageFrame;
	private addFriendFrame addFriendFrame;
	//Ⱥ�Ĵ���
	private ChatFrame chatFrame;
	private SenderFrame senderFrame;
	private ReceiverFrame receiverFrame;
	
	//�Ự����
	private IoSession session;
	//�����б�
	private static String account;
	private static String friendAcc;
	private static String friendAcc2;
	private static String receiveAcc;

	
	/**
	 * ��ʼ������
	 */
	public void init() {
		//ʵ����ͼ�괰��
		gotoFrame = new GotoFrame(this);
		loginFrame =new LoginFrame(this, account);
		new RegestFrame(this);
		loadingFrame = new LoadingFrame(this,account);
		//ʵ���������б���
		friendListFrame = new FriendListFrame(this, account);
		selfMessageFrame = new SelfMessageFrame(this, account);
		friendMessageFrame = new FriendMessageFrame(this, friendAcc);
		addFriendFrame = new addFriendFrame(friendAcc2);
		//ʵ�������촰��
		chatFrame = new ChatFrame(this, account);
		senderFrame = new SenderFrame(this, account, receiveAcc);
		receiverFrame = new ReceiverFrame(this, receiveAcc, account);
		//���ӷ�����
		NioSocketConnector conn = new NioSocketConnector();
		//���ù�����
		DefaultIoFilterChainBuilder chain = conn.getFilterChain();
		chain.addLast("chain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		//���ÿͻ��� �������
		conn.setHandler(new ClientHandler(this));
		//���ӷ�����
		ConnectFuture future = conn.connect(new InetSocketAddress("192.168.5.182", 10000));
		future.awaitUninterruptibly();
		//�õ��Ự
		session = future.getSession();
	}
	
	
	/**
	 * �������
	 */
	public static void main(String[] args) {
		StartClient startClient = new StartClient();
		startClient.start();
	}
	
	/**
	 * �����ͻ���
	 */
	public void start() {
		init();
		gotoFrame.setVisible(true);
	}
	
	/**
	 * ע��  �˺�ע��
	 */
	public  void logOut(String account) {
		session.write("LogOut " + account);
	}
	
	/**
	 * ��¼   ����¼�˺ź����뷢�͵�������
	 */
	public void login(String account, String password) {
		session.write("CheckLogin " + account + " " + password);
		loadingFrame.setAccount(account);
	}
	
	/**
	 * �жϵ�¼�ɹ���ʧ��
	 */
	public void  checkLogin(boolean  b, String account, String password){
		//�ж�
		if(b == true){
			loadingFrame.setVisible(true);
			loginFrame.setVisible(false);
			//����¼�˺Ŵ���loadingFrame������
			loadingFrame.setAccount(account);
			//����������
			loadingFrame.start();
			//���˺Ŵ���FriendListFrame������
			FriendListFrame.setAccount(account);
			loginFrame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(loginFrame, "��¼ʧ��,�����µ�¼��");
		}
	}

	/**
	 * ����������Ա�б�
	 */
	public void updateOnlineUser(String[] account) {
		//�������촰���е�List
		chatFrame.setOnlineUser(account);
	}
	
	/**
	 * 1��Ⱥ�ķ�����Ϣ
	 */
	public void sendMessage(String message) {
		session.write("Message " +  message);
	}
	
	/**
	 * ��Ⱥ�����촰�������Ϣ
	 */
	public void show(String msg) {
		chatFrame.addMessageToTextArea(msg);
	}	
	
	
	/**
	 * 2��˽�ķ�����Ϣ
	 */
	public void sendPMessage(String sendMsg) {
		session.write("PMessage " +  sendMsg);
	}
	
	/**
	 * ��˽�����촰�������Ϣ ����  ��ӵ��Է��Ľ��տ���
	 */
	public void pSendShow(String pmsg) {
		receiverFrame.addMessageToTextArea(pmsg);
	}	
	
	/**
	 * 3��˽�Ļظ���Ϣ
	 */
	public void sendP1Message(String sendMsg) {
		session.write("P1Message " +  sendMsg);
	}
	
	public void pReceiveShow(String pmsg) {
		senderFrame.addMessageToTextArea(pmsg);
	}

	
	//�ṩget��sat����
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public LoadingFrame getLoadingFrame() {
		return loadingFrame;
	}

	public void setLoadingFrame(LoadingFrame loadingFrame) {
		this.loadingFrame = loadingFrame;
	}

	public FriendListFrame getFriendListFrame() {
		return friendListFrame;
	}

	public void setFriendListFrame(FriendListFrame friendListFrame) {
		this.friendListFrame = friendListFrame;
	}

	public SelfMessageFrame getSelfMessageFrame() {
		return selfMessageFrame;
	}

	public void setSelfMessageFrame(SelfMessageFrame selfMessageFrame) {
		this.selfMessageFrame = selfMessageFrame;
	}

	public FriendMessageFrame getFriendMessageFrame() {
		return friendMessageFrame;
	}

	public void setFriendMessageFrame(FriendMessageFrame friendMessageFrame) {
		this.friendMessageFrame = friendMessageFrame;
	}

	public addFriendFrame getAddFriendFrame() {
		return addFriendFrame;
	}

	public void setAddFriendFrame(addFriendFrame addFriendFrame) {
		this.addFriendFrame = addFriendFrame;
	}

	public SenderFrame getSenderFrame() {
		return senderFrame;
	}

	public void setSenderFrame(SenderFrame senderFrame) {
		this.senderFrame = senderFrame;
	}

	public static String getAccount() {
		return account;
	}


	public static void setAccount(String account) {
		StartClient.account = account;
	}


	public ReceiverFrame getReceiverFrame() {
		return receiverFrame;
	}

	public void setReceiverFrame(ReceiverFrame receiverFrame) {
		this.receiverFrame = receiverFrame;
	}
	
	public ChatFrame getChatFrame() {
		return chatFrame;
	}

	public void setChatFrame(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
}
