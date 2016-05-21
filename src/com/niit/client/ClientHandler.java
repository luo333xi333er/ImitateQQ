package com.niit.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * �ͻ��˴������
 */
public class ClientHandler extends IoHandlerAdapter{

	private  StartClient  startClient;
	
	/**
	 * ����
	 */
	public ClientHandler(StartClient  startClient){ //��һ��StartClient
		this.startClient = startClient;
	}
	
	/**
	 * ���յ���Ϣ����
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//���������͵���Ϣ
		String str = message.toString();
		System.out.println("���������͵���Ϣ:"+str); 
		//���
		String [] arr = str.split(" ",4);//Login true account password
		//�ж�
		if(arr[0].equals("Login")){ //��¼
			if(arr[1].equals("true")){
				startClient.checkLogin(true, arr[2], arr[3]);
			}else{
				startClient.checkLogin(false, arr[2], arr[3]);
			}
		}
		//���²��
		String[] arr2 = str.split(" ", 2);
		if(arr[0].equals("OnLine")){ //������Ա�б�
			startClient.updateOnlineUser(arr[1].split(","));
		} else if(arr2[0].equals("MSG")){ //1��Ⱥ����Ϣ
			startClient.show(arr[1]);
		} else if(arr2[0].equals("PSMSG")){ //2��˽����Ϣ
			startClient.pSendShow(arr[1]);
		} else if(arr2[0].equals("P1MSG")){ //2��˽����Ϣ
			startClient.pReceiveShow(arr[1]);
		}
		
		
		
		
		
	}
}