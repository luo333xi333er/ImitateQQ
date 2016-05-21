package com.niit.server;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * ����������
 */
public class StartServer {
	public static void main(String[] args) throws Exception{
		//ʹ��TCP/IPЭ��  nio �������� socket  
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		
		//�õ���Ϣ������
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		
		//���� ������  ����  һ��һ�еĽ���
		chain.addLast("chain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		
		//���÷������������
		acceptor.setHandler(new ServerHandler());
		//ָ���������˿�
		int port = 10001;
		//�󶨶˿�
		acceptor.bind(new InetSocketAddress(port));
		System.out.println("������������,�����˿�:"+port+" .............");
	}
}
