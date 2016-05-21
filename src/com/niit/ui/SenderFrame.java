package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.niit.client.StartClient;
import com.niit.image.SenderPanel;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 发送消息界面
 */

@SuppressWarnings("serial")
public class SenderFrame extends JFrame implements ActionListener{

	//内容面板
	private JPanel contentPane;
	//接收者
	private JTextField textField;
	//发送者
	private JTextField textField_1;
	//发送内容
	private JTextArea textArea;
	//发送按钮
	private JButton sendbutton;
	//关闭按钮
	private JButton closebutton;
	
	private StartClient startClient;
	private String account;
	private String receiveAcc;

	/**
	 * Create the frame.
	 */
	public SenderFrame(StartClient startClient, String account, String receiveAcc) {
		this.startClient = startClient;
		//设置窗口不可变
		setResizable(false);
		//标题图片
		setIconImage(Toolkit.getDefaultToolkit().getImage(SenderFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//标题
		setTitle("\u53D1\u9001\u6846");
		setBounds(100, 100, 440, 300);
		//设置背景图片
		contentPane = new SenderPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//接收者
		JLabel lblNewLabel = new JLabel("\u63A5 \u6536 \u8005:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 57, 75, 25);
		contentPane.add(lblNewLabel);
		
		//发送者
		JLabel label_1 = new JLabel("\u53D1 \u9001 \u8005:");
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(24, 22, 75, 25);
		contentPane.add(label_1);

		//发送内容
		JLabel label = new JLabel("\u53D1\u9001\u5185\u5BB9:");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(24, 92, 75, 25);
		contentPane.add(label);
		
		//接收者文本框
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 59, 261, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//将登录用户的好友设为接收者
		textField.setText(receiveAcc);
		
		//发送者文本框
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(100, 24, 261, 21);
		contentPane.add(textField_1);
		//将正在登录的账号设为发送者
		textField_1.setText(account);
		
		//发送内容文本域
		textArea = new JTextArea();
		textArea.setBounds(100, 92, 261, 114);
		contentPane.add(textArea);
		
		//发送按钮
		sendbutton = new JButton("\u53D1\u9001");
		sendbutton.setBounds(122, 229, 93, 23);
		contentPane.add(sendbutton);
		//给发送按钮添加事件
		sendbutton.addActionListener(this);
		
		//关闭按钮
		closebutton = new JButton("\u5173\u95ED");
		closebutton.setBounds(247, 229, 93, 23);
		contentPane.add(closebutton);
		//给关闭按钮添加事件
		closebutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.sendbutton) { //发送按钮
			//时间
			String time = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss").format(new Date());
			//取出发送者与接收者的账号
			String account = textField_1.getText();
			String receiveAcc = textField.getText();
			//取出要发送的消息
			String sendMsg = "[" + time + "]$$" + account + "对" + receiveAcc + "说:" + textArea.getText() + "$$";
			//通过client发送
			SenderFrame.this.startClient.sendPMessage(sendMsg);
			SenderFrame.this.startClient.getReceiverFrame().setVisible(true);
			SenderFrame.this.startClient.getReceiverFrame().setSAccount(account);
			SenderFrame.this.startClient.getReceiverFrame().setRAccount(receiveAcc);
			SenderFrame.this.setVisible(false);
		} else if(e.getSource() == this.closebutton) { //关闭按钮
			SenderFrame.this.setVisible(false);
		}
	}
	
	/**
	 * 添加私聊消息
	 */
	
	public void addMessageToTextArea(String pmsg) {
		pmsg = pmsg.replace("$$", "\n");
		//附加消息
		textArea.append(pmsg);
	}

	/**
	 * 设置发送者与接收者账号
	*/
	
	public void setSAccount(String account2) {
		this.account = account2;
		//将正在登录的账号设为发送者
		textField_1.setText(account2);
	}

	public void setRAccount(String receiveAcc2) {
		this.receiveAcc = receiveAcc2;
		//将登录用户的好友设为接收者
		textField.setText(receiveAcc2);
	}
}
