package com.niit.ui;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.niit.client.StartClient;
/*
 * 图标界面
 */
public class GotoFrame extends JWindow {

	//定义内容面板
	private JPanel contentPane;
	//主题文本框
	private JTextField txtMiMi;
	//图片按钮
	private JButton btnNewButton;
	//启动客户端
	private static  StartClient startClient;

	
	/**
	 * Create the frame.
	 */
	public GotoFrame(StartClient startClient) { //传一个StartClient
		this.startClient = startClient;
		//设置位置和大小
		setBounds(100, 100, 216, 280);
		//窗口居中
		setLocationRelativeTo(null);
		//实例化面板
		contentPane = new JPanel();
		//设置背景颜色
		contentPane.setBackground(Color.GREEN);
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//布局为null
		contentPane.setLayout(null);
		
		//实例化主题文本框
		txtMiMi = new JTextField();
		//背景颜色
		txtMiMi.setBackground(Color.PINK);
		//字体
		txtMiMi.setFont(new Font("华文隶书", Font.BOLD, 40));
		//文本框内容
		txtMiMi.setText("MiMi");
		//设置文本的水平对齐方式
		txtMiMi.setHorizontalAlignment(SwingConstants.CENTER);
		//设置位置和大小
		txtMiMi.setBounds(10, 210, 196, 60);
		//将文本框添加到内容面板
		contentPane.add(txtMiMi);
		//设置列数
		txtMiMi.setColumns(10);
		
		//实例化图片按钮
		btnNewButton = new JButton("twinsimage");
		//得到图片按钮的路径
		btnNewButton.setIcon(new ImageIcon(GotoFrame.class.getResource("/com/niit/ui/gotoframe.jpg")));
		//设置位置和大小
		btnNewButton.setBounds(25, 10, 167, 181);
		//将图片按钮添加到面板中
		contentPane.add(btnNewButton);
		//给图片按钮添加事件
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用登录界面
				GotoFrame.this.startClient.getLoginFrame().setVisible(true);
				//自己销毁
				GotoFrame.this.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		GotoFrame frame = new GotoFrame(startClient);
	}
}
