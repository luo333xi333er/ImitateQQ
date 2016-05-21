package com.niit.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.niit.util.ReadAndWrite;

/**
 * �������������
 */
public class ServerHandler extends IoHandlerAdapter{
	
	//���Ⱥ�Ŀͻ��˵ĻỰ
	private  List<IoSession>  messageList = new ArrayList<IoSession>();
	//���˽�Ŀͻ��˵ĻỰ
	private  List<IoSession>  pmessageList = new ArrayList<IoSession>();
	//���������Ա���˺�
	private  List<String> onlineUsers = new ArrayList<String>();
	
	private ReadAndWrite  rw;
	
	public ServerHandler() {
		rw = new ReadAndWrite();
	}
	
	/**
	 * ����һ�λỰ
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		//�Ӽ�������ӻỰ
		messageList.add(session);
		pmessageList.add(session);
		sendOnLineToAllClient();
		System.out.println("�ͻ�������:" + session.getRemoteAddress());;
	}
	
	/**
	 * ���յ��ͻ��˵���Ϣ  ���� ���
	 * ����¼
	 * ��Ϣ
	 * ע��
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//�õ��ͻ��˵�IP�Ͷ˿�
		String  client = session.getRemoteAddress().toString();
		
		//�ͻ��˷��͵���Ϣ
		String msg = message.toString();
		System.out.println("�ͻ���["+client+"]������Ϣ:"+msg);
		//���
		String[] arr = msg.split(" ",3);
		//�ж�
		if(arr[0].equals("CheckLogin")){ //��¼�ж�
			if(rw.login(arr[1], arr[2])){
				session.write("Login true "+ arr[1] + " " + arr[2]);
				//�������б������
				onlineUsers.add(arr[1]); 
				sendOnLineToAllClient();
			}else{
				session.write("Login false "+ arr[1] + " " + arr[2]);
			}
		} 
		//���²����Ϣ
		String[] arr2 = msg.split(" ", 2);
		if(arr2[0].equals("Message")){ //1��Ⱥ����Ϣ
			//������Ϣ
			sendMessageToAllClient(arr[1]);
		} else if(arr2[0].equals("PMessage")){ //2��˽����Ϣ
			//������Ϣ
			sendPMessageToClient(arr[1]);
		}  else if(arr2[0].equals("P1Message")){ //2��˽����Ϣ
			//������Ϣ
			sendP1MessageToClient(arr[1]);
		} else if(arr[0].equals("LogOut")){ //ע�� ����
			System.out.println(arr[1]+" ������");
			onlineUsers.remove(arr[1]);
		}
	}

	/**
	 *  ������Ա ���˺� ���͸��������ߵĿͻ���
	 */
	private  void  sendOnLineToAllClient(){
		//ƴ��һ����Ա�б�   xxx,xxx,....
		String str = "";
		for(String user : onlineUsers){
			str += user + ",";
		}
		//���͸����пͻ���
		for (IoSession s : messageList) {
			s.write("OnLine " + str);
		}
	}

	/**
	 * ��Ⱥ����Ϣ ���͸��������ߵĿͻ���
	 */
	private  void  sendMessageToAllClient(String message){
		for(IoSession s : messageList){
			s.write("MSG " + message);
		}
	}	
	

	/**
	 * ��˽������Ϣ ���͸���Ӧ�Ŀͻ���
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
	 * �ͻ��˹ر�  ���� һ��
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		//�Ӽ�����ɾ���Ự
		messageList.remove(session);
		//����������Ա�б�
		sendOnLineToAllClient();
		System.out.println("�ͻ��˶Ͽ�:" + session.getRemoteAddress());
	}
}
