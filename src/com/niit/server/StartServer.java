package com.niit.server;

import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * 启动服务器
 */
public class StartServer {
	public static void main(String[] args) throws Exception{
		//使用TCP/IP协议  nio 非阻塞的 socket  
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		
		//得到信息过滤器
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		
		//设置 过滤器  接收  一行一行的接收
		chain.addLast("chain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		
		//设置服务器处理程序
		acceptor.setHandler(new ServerHandler());
		//指定服务器端口
		int port = 10001;
		//绑定端口
		acceptor.bind(new InetSocketAddress(port));
		System.out.println("服务器启动了,监听端口:"+port+" .............");
	}
}
