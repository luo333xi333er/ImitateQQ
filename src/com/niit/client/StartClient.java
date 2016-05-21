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
	//定义一个图标窗口
	//定义一个图标窗口
	private GotoFrame gotoFrame;
	private  LoginFrame  loginFrame;
	private LoadingFrame  loadingFrame;
	private FriendListFrame friendListFrame;
	private SelfMessageFrame selfMessageFrame;
	private FriendMessageFrame friendMessageFrame;
	private addFriendFrame addFriendFrame;
	//群聊窗口
	private ChatFrame chatFrame;
	private SenderFrame senderFrame;
	private ReceiverFrame receiverFrame;
	
	//会话对象
	private IoSession session;
	//好友列表
	private static String account;
	private static String friendAcc;
	private static String friendAcc2;
	private static String receiveAcc;

	
	/**
	 * 初始化窗口
	 */
	public void init() {
		//实例化图标窗口
		gotoFrame = new GotoFrame(this);
		loginFrame =new LoginFrame(this, account);
		new RegestFrame(this);
		loadingFrame = new LoadingFrame(this,account);
		//实例化好友列表窗口
		friendListFrame = new FriendListFrame(this, account);
		selfMessageFrame = new SelfMessageFrame(this, account);
		friendMessageFrame = new FriendMessageFrame(this, friendAcc);
		addFriendFrame = new addFriendFrame(friendAcc2);
		//实例化聊天窗口
		chatFrame = new ChatFrame(this, account);
		senderFrame = new SenderFrame(this, account, receiveAcc);
		receiverFrame = new ReceiverFrame(this, receiveAcc, account);
		//连接服务器
		NioSocketConnector conn = new NioSocketConnector();
		//设置过滤器
		DefaultIoFilterChainBuilder chain = conn.getFilterChain();
		chain.addLast("chain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		//设置客户端 处理程序
		conn.setHandler(new ClientHandler(this));
		//连接服务器
		ConnectFuture future = conn.connect(new InetSocketAddress("192.168.5.182", 10000));
		future.awaitUninterruptibly();
		//得到会话
		session = future.getSession();
	}
	
	
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		StartClient startClient = new StartClient();
		startClient.start();
	}
	
	/**
	 * 启动客户端
	 */
	public void start() {
		init();
		gotoFrame.setVisible(true);
	}
	
	/**
	 * 注销  账号注销
	 */
	public  void logOut(String account) {
		session.write("LogOut " + account);
	}
	
	/**
	 * 登录   将登录账号和密码发送到服务器
	 */
	public void login(String account, String password) {
		session.write("CheckLogin " + account + " " + password);
		loadingFrame.setAccount(account);
	}
	
	/**
	 * 判断登录成功和失败
	 */
	public void  checkLogin(boolean  b, String account, String password){
		//判断
		if(b == true){
			loadingFrame.setVisible(true);
			loginFrame.setVisible(false);
			//将登录账号传到loadingFrame界面中
			loadingFrame.setAccount(account);
			//启动滚动条
			loadingFrame.start();
			//将账号传到FriendListFrame界面中
			FriendListFrame.setAccount(account);
			loginFrame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(loginFrame, "登录失败,请重新登录！");
		}
	}

	/**
	 * 更新在线人员列表
	 */
	public void updateOnlineUser(String[] account) {
		//更新聊天窗口中的List
		chatFrame.setOnlineUser(account);
	}
	
	/**
	 * 1、群聊发送消息
	 */
	public void sendMessage(String message) {
		session.write("Message " +  message);
	}
	
	/**
	 * 给群聊聊天窗口添加消息
	 */
	public void show(String msg) {
		chatFrame.addMessageToTextArea(msg);
	}	
	
	
	/**
	 * 2、私聊发送消息
	 */
	public void sendPMessage(String sendMsg) {
		session.write("PMessage " +  sendMsg);
	}
	
	/**
	 * 给私聊聊天窗口添加消息 ——  添加到对方的接收框中
	 */
	public void pSendShow(String pmsg) {
		receiverFrame.addMessageToTextArea(pmsg);
	}	
	
	/**
	 * 3、私聊回复消息
	 */
	public void sendP1Message(String sendMsg) {
		session.write("P1Message " +  sendMsg);
	}
	
	public void pReceiveShow(String pmsg) {
		senderFrame.addMessageToTextArea(pmsg);
	}

	
	//提供get和sat方法
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
