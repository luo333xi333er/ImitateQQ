package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.niit.client.StartClient;
import com.niit.image.SelfMsgPanel;

import javax.swing.SwingConstants;
/**
 * 正在登录界面
 */
@SuppressWarnings("serial")
public class LoadingFrame extends JFrame {
	//定义面板
	private JPanel contentPane;
	//登录账号文本框
	private JTextField textField;
	//进程条
	private JProgressBar progressBar;
	//取消按钮
	private JButton button;
	//计时器
	private Timer timer;
	//账号
//	private String account;
	private StartClient startClient;

	
	/**
	 * Create the frame.
	 */
	public LoadingFrame(StartClient startClient,String account) { //传一个account
		this.startClient = startClient;
		//窗体居中
		setLocationRelativeTo(null);
		//背景颜色
		setBackground(new Color(224, 255, 255));
		//标题栏设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadingFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//设置标题
		setTitle("\u6B63\u5728\u767B\u5F55\u4E2D...");
		//设置位置和大小
		setBounds(100, 100, 400, 300);
		//实例化面板
		contentPane = new JPanel();
		//设置背景图片
		contentPane = new SelfMsgPanel();
		//给面板设置背景颜色
		contentPane.setBackground(new Color(224, 255, 255));
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//设布局为null
		contentPane.setLayout(null);
		
		//登录账号文本框
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		
		//设置位置和大小
		textField.setBounds(142, 158, 99, 21);
		//将文本框添加到面板中
		contentPane.add(textField);
		//设置列为10
		textField.setColumns(10);
		
		//实例化进程条
		progressBar = new JProgressBar();
		//设置背景颜色
		progressBar.setBackground(new Color(255, 192, 203));
		//设置位置和大小
		progressBar.setBounds(10, 189, 364, 31);
		//将进程条添加到内容面板中
		contentPane.add(progressBar);
		
		//实例化取消按钮
		button = new JButton("\u53D6\u6D88");
		//设置位置和大小
		button.setBounds(142, 231, 99, 21);
		//将取消按钮添加到内容面板中
		contentPane.add(button);
		//给取消按钮添加事件
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				//自己关闭
				LoadingFrame.this.dispose();
				//返回到登录界面
				LoadingFrame.this.startClient.getLoginFrame().setVisible(true);
			}
		});
		
		//图标
		JLabel lblNewLabel = new JLabel("New label");
		//给lblNewLabel中添加图片
		lblNewLabel.setIcon(new ImageIcon(LoadingFrame.class.getResource("/com/niit/ui/loadframe.jpg")));
		//设置位置和大小
		lblNewLabel.setBounds(92, 20, 195, 128);
		//将lblNewLabel添加到内容面板中
		contentPane.add(lblNewLabel);
		//窗体居中
		setLocationRelativeTo(null);
		//窗体总是显示在最前面
		setAlwaysOnTop(true);
	}
	

	/**
	 * 进度条  显示用户登录进度
	 */
	public void start(){
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = progressBar.getValue();
				value++;
				progressBar.setValue(value);
				if(value >= 50){
					timer.stop();
					//显示FriendListFrame
					LoadingFrame.this.startClient.getFriendListFrame().setVisible(true);
					//加载窗口关闭
					LoadingFrame.this.setVisible(false);
				}
			}
		});
		//启动计时器
		timer.start();
	}
	
	/**
	 * 设置当前用户
	 * @param username
	*/
	public void setAccount(String account) {
		//显示account信息
		textField.setText(account);
	}
}
