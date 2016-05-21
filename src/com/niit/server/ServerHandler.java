package com.niit.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.niit.util.ReadAndWrite;

/**
 * 服务器处理程序
 */
public class ServerHandler extends IoHandlerAdapter{
	
	//存放群聊客户端的会话
	private  List<IoSession>  messageList = new ArrayList<IoSession>();
	//存放私聊客户端的会话
	private  List<IoSession>  pmessageList = new ArrayList<IoSession>();
	//存放在线人员的账号
	private  List<String> onlineUsers = new ArrayList<String>();
	
	private ReadAndWrite  rw;
	
	public ServerHandler() {
		rw = new ReadAndWrite();
	}
	
	/**
	 * 创建一次会话
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		//从集合中添加会话
		messageList.add(session);
		pmessageList.add(session);
		sendOnLineToAllClient();
		System.out.println("客户端连接:" + session.getRemoteAddress());;
	}
	
	/**
	 * 接收到客户端的消息  触发 多次
	 * 检查登录
	 * 消息
	 * 注销
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//得到客户端的IP和端口
		String  client = session.getRemoteAddress().toString();
		
		//客户端发送的消息
		String msg = message.toString();
		System.out.println("客户端["+client+"]发送消息:"+msg);
		//拆分
		String[] arr = msg.split(" ",3);
		//判断
		if(arr[0].equals("CheckLogin")){ //登录判断
			if(rw.login(arr[1], arr[2])){
				session.write("Login true "+ arr[1] + " " + arr[2]);
				//向在线列表中添加
				onlineUsers.add(arr[1]); 
				sendOnLineToAllClient();
			}else{
				session.write("Login false "+ arr[1] + " " + arr[2]);
			}
		} 
		//重新拆分消息
		String[] arr2 = msg.split(" ", 2);
		if(arr2[0].equals("Message")){ //1、群聊消息
			//发送信息
			sendMessageToAllClient(arr[1]);
		} else if(arr2[0].equals("PMessage")){ //2、私聊消息
			//发送信息
			sendPMessageToClient(arr[1]);
		}  else if(arr2[0].equals("P1Message")){ //2、私聊消息
			//发送信息
			sendP1MessageToClient(arr[1]);
		} else if(arr[0].equals("LogOut")){ //注销 离线
			System.out.println(arr[1]+" ，离线");
			onlineUsers.remove(arr[1]);
		}
	}

	/**
	 *  在线人员 的账号 发送给所有在线的客户端
	 */
	private  void  sendOnLineToAllClient(){
		//拼接一个人员列表   xxx,xxx,....
		String str = "";
		for(String user : onlineUsers){
			str += user + ",";
		}
		//发送给所有客户端
		for (IoSession s : messageList) {
			s.write("OnLine " + str);
		}
	}

	/**
	 * 把群聊信息 发送给所有在线的客户端
	 */
	private  void  sendMessageToAllClient(String message){
		for(IoSession s : messageList){
			s.write("MSG " + message);
		}
	}	
	

	/**
	 * 把私聊聊信息 发送给对应的客户端
	 */
	private void sendPMessageToClient(String sendMsg) {
		for (IoSession ios : pmessageList) {
			ios.write("PSMSG " + sendMsg);
		}
	}
	
	private void sendP1MessageToClient(String sendMsg) {
		for (IoSession ios : pmessageList) {
			ios.write("P1MSG " + sendMsg);
		}
	}
	
	/**
	 * 客户端关闭  触发 一次
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		//从集合中删除会话
		messageList.remove(session);
		//发送在线人员列表
		sendOnLineToAllClient();
		System.out.println("客户端断开:" + session.getRemoteAddress());
	}
}
