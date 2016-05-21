package com.niit.ui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.niit.client.StartClient;
import com.niit.entity.LoginUser;
import com.niit.image.LoginPanel;
import com.niit.util.ReadAndWrite;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.List;
/**
 * 用户登录界面
 */
public class LoginFrame extends JFrame implements ActionListener {

	//内容面板
	private JPanel contentPane;
	//登录账号文本框
	private JTextField acctextField;
	//密码文本框
	private JPasswordField pwdtextField;
	//放置MiMi图标
	private JLabel lblNewLabel;
	private JLabel label;
	//记住密码
	private JRadioButton radioButton;
	//自动登录
	private JRadioButton radioButton_1;
	//重置
	private JButton button_1;
	//忘记密码
	private JButton button_2;
	//注册
	private JButton button;
	//登录
	private JButton btnNewButton;
	
	private StartClient startClient;
	//读写
	private ReadAndWrite raw;
	

	public LoginFrame(StartClient startClient, String account) {
		this.startClient = startClient;
		raw = new ReadAndWrite();
		init();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		//标题栏设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//设置标题
		setTitle("MiMi\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 287);
		//窗体居中
		setLocationRelativeTo(null);
		
		//添加背景图片
		contentPane = new LoginPanel();
		//设置组件的前景色
		contentPane.setForeground(new Color(255, 240, 245));
		//设置组件的背景色
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//面板的布局设置为空
		contentPane.setLayout(null);
		
		acctextField = new JTextField();
		//设置位置和大小
		acctextField.setBounds(144, 72, 139, 31);
		//将文本框添加到面板中
		contentPane.add(acctextField);
		//设置为10列
		acctextField.setColumns(10);
		
		pwdtextField = new JPasswordField();
		//设置为10列
		pwdtextField.setColumns(10);
		//设置位置和大小
		pwdtextField.setBounds(144, 128, 139, 31);
		//将密码框添加到面板中
		contentPane.add(pwdtextField);
		
		//登录按钮
		btnNewButton = new JButton("登录");
		//给登录按钮添加事件
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(81, 208, 93, 31);
		contentPane.add(btnNewButton);
		
		//注册按钮
		button = new JButton("\u6CE8\u518C");
		//给注册按钮添加事件
		button.addActionListener(this);
		button.setBounds(226, 208, 87, 31);
		contentPane.add(button);
		
		//显示图标
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		lblNewLabel.setBounds(10, 72, 79, 87);
		contentPane.add(lblNewLabel);
		
		//记住密码
		radioButton = new JRadioButton("\u8BB0\u4F4F\u5BC6\u7801");
		radioButton.setBounds(121, 179, 79, 23);
		//设置背景为透明
		radioButton.setOpaque(false);
		contentPane.add(radioButton);
		
		//自动登录
		radioButton_1 = new JRadioButton("\u81EA\u52A8\u767B\u5F55");
		radioButton_1.setBounds(204, 179, 79, 23);
		//设置背景为透明
		radioButton_1.setOpaque(false);
		contentPane.add(radioButton_1);
		
		//重置
		button_1 = new JButton("\u91CD\u7F6E");
		//给重置按钮添加事件
		button_1.addActionListener(this);
		button_1.setBounds(300, 72, 81, 31);
		contentPane.add(button_1);
		
		//忘记密码
		button_2 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		//设置透明
		button_2.setBounds(300, 128, 81, 31);
		contentPane.add(button_2);
		//给忘记密码添加监听
		button_2.addActionListener(this);
		
		//自动登录
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(99, 72, 46, 31);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(99, 128, 46, 31);
		contentPane.add(label);
	}

	//实现事件
	@Override
	public void actionPerformed(ActionEvent e) {
		//登录按钮事件
		if(e.getSource() == btnNewButton) {
			//从文本框中得到登录账号
			String account = acctextField.getText();
			//从密码框中得到密码
			String password = new String(pwdtextField.getPassword());
			if(account.trim().equals("")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "请输入账号！");
			} else {
				//调用 client
				LoginFrame.this.startClient.login(account, password);
			}
		}else if(e.getSource() == button) { //注册按钮添加事件
			//调用注册界面
			RegestFrame regestFrame = new RegestFrame(startClient);
			//显示登录界面
			regestFrame.setVisible(true);
			//自己消失
			LoginFrame.this.setVisible(false);
		} else if(e.getSource() == button_1) { //重置按钮添加事件
			acctextField.setText("");
		} else if(e.getSource() == button_2) {  //忘记密码
			//调用方法
			List<LoginUser> userList = raw.readAll();
			for (LoginUser User : userList) {
				if(User.getAccount().equals(acctextField.getText())) {
					//取出密码
					String pwd = User.getPassword();
					JOptionPane.showMessageDialog(null, "您的密码是" + pwd + ",请输入！");
				}
			}
		}
	}
}			
