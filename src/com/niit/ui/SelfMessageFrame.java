package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.niit.client.StartClient;
import com.niit.entity.LoginUser;
import com.niit.image.SelfMsgPanel;
import com.niit.util.ReadAndWrite;

import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.Color;
import java.util.List;
/**
 * 个人资料窗口
 */
@SuppressWarnings("serial")
public class SelfMessageFrame extends JFrame {

	//定义内容面板
	private JPanel contentPane;
	//账号文本框
	private JTextField textField;
	//昵称文本框
	private JTextField textField_2;
	//年龄文本框
	private JTextField textField_1;
	//性别文本框
	private JTextField textField_4;
	//城市文本框
	private JTextField textField_3;
	
	private ReadAndWrite raw;

	/**
	 * Create the frame.
	 */
	public SelfMessageFrame(StartClient startClient, String account) {
		setResizable(false);
		//实例化ReadAndWrite类
		raw = new ReadAndWrite();
		init();
		List<LoginUser> userList = raw.readAll();
		for (LoginUser u : userList) {
			if(u.getAccount().equals(account)) {
				//得到账号信息
				textField.setText(u.getAccount());
				//得到昵称信息
				textField_2.setText(u.getName());
				//得到年龄信息
				textField_1.setText(u.getAge() + "");
				//得到性别信息
				textField_4.setText(u.getSex());
				//得到城市信息
				textField_3.setText(u.getCity());
			}
		}
	}
	
	public void init() {
		//标题栏图片
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\twins\\MiMi2015\\src\\com\\niit\\ui\\loginframe.jpg"));
		//标题
		setTitle("\u4E2A\u4EBA\u8D44\u6599");
		//窗体居中
		setLocationRelativeTo(null);
		//设置位置和大小
		setBounds(100, 100, 387, 293);
		//窗口居中
		setLocationRelativeTo(null);
		//实例化面板
		contentPane = new JPanel();
		//添加背景图片
		contentPane = new SelfMsgPanel();
		contentPane.setForeground(Color.RED);
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//设置布局为空
		contentPane.setLayout(null);
		
		//个人资料
		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u8D44\u6599");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 17));
		lblNewLabel.setBounds(142, 10, 80, 45);
		contentPane.add(lblNewLabel);
		
		//账号
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 69, 44, 21);
		contentPane.add(lblNewLabel_1);
		
		//账号文本框
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114, 69, 170, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//性别
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.BOLD, 12));
		label_2.setForeground(Color.RED);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(68, 163, 44, 21);
		contentPane.add(label_2);
		
		//性别文本框
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(114, 163, 170, 21);
		contentPane.add(textField_4);
		
		//年龄
		JLabel label_1 = new JLabel("\u5E74\u9F84");
		label_1.setFont(new Font("宋体", Font.BOLD, 12));
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(68, 131, 44, 21);
		contentPane.add(label_1);
		
		//年龄文本框
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(114, 131, 170, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//昵称
		JLabel label = new JLabel("\u6635\u79F0");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(68, 100, 44, 21);
		contentPane.add(label);
		
		//昵称文本框
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(114, 100, 170, 21);
		contentPane.add(textField_2);
		
		//城市
		JLabel label_3 = new JLabel("\u57CE\u5E02");
		label_3.setFont(new Font("宋体", Font.BOLD, 12));
		label_3.setForeground(Color.RED);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(68, 195, 44, 21);
		contentPane.add(label_3);
		
		//城市文本框
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(114, 195, 170, 21);
		contentPane.add(textField_3);
	}
}
