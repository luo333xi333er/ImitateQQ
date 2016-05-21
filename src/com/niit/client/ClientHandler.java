package com.niit.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端处理程序
 */
public class ClientHandler extends IoHandlerAdapter{

	private  StartClient  startClient;
	
	/**
	 * 构造
	 */
	public ClientHandler(StartClient  startClient){ //传一个StartClient
		this.startClient = startClient;
	}
	
	/**
	 * 接收到信息触发
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//服务器发送的信息
		String str = message.toString();
		System.out.println("服务器发送的信息:"+str); 
		//拆分
		String [] arr = str.split(" ",4);//Login true account password
		//判断
		if(arr[0].equals("Login")){ //登录
			if(arr[1].equals("true")){
				startClient.checkLogin(true, arr[2], arr[3]);
			}else{
				startClient.checkLogin(false, arr[2], arr[3]);
			}
		}
		//重新拆分
		String[] arr2 = str.split(" ", 2);
		if(arr[0].equals("OnLine")){ //在线人员列表
			startClient.updateOnlineUser(arr[1].split(","));
		} else if(arr2[0].equals("MSG")){ //1、群聊信息
			startClient.show(arr[1]);
		} else if(arr2[0].equals("PSMSG")){ //2、私聊信息
			startClient.pSendShow(arr[1]);
		} else if(arr2[0].equals("P1MSG")){ //2、私聊信息
			startClient.pReceiveShow(arr[1]);
		}
		
		
		
		
		
	}
}