package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.niit.client.StartClient;
import com.niit.entity.LoginUser;
import com.niit.image.RegestPanel;
import com.niit.util.ReadAndWrite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
/**
 * 用户注册界面
 */
@SuppressWarnings("serial")
public class RegestFrame extends JFrame implements ActionListener {
	//定义面板
	private JPanel contentPane;
	//账号文本框
	private JTextField accTextField;
	//昵称文本框
	private JTextField nameTextField;
	//密码文本框
	private JTextField pwdTextField;
	//年龄文本框
	private JTextField ageTextField;
	//注册按钮
	private JButton button;
	//重置按钮
	private JButton button_1;
	
	//男
	private JRadioButton boyRadioButton;
	//女
	private JRadioButton girlRadioButton;
	//复选框
	private JComboBox comboBox;
	//读取和写入
	private ReadAndWrite raw;
	private StartClient startClient;
	private String account;
	
	//构造方法
	public RegestFrame(StartClient startClient) {
		this.startClient = startClient;
		setResizable(false);
		//实例化
		raw = new ReadAndWrite();
		//调用init方法
		init();
	}
	
	
	/**
	 * Create the frame.
	 */
	public void init() {
		//标题图片
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegestFrame.class.getResource("/com/niit/ui/regest.jpg")));
		//标题
		setTitle("MiMi\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置位置和大小
		setBounds(100, 100, 329, 338);
		//窗口居中
		setLocationRelativeTo(null);
		//实例化面板
		contentPane = new JPanel();
		//给面板添加背景图片
		contentPane = new RegestPanel();
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//设置布局为null
		contentPane.setLayout(null);
		
		//实例化用户昵称
		JLabel nameLable = new JLabel("\u6635\u79F0\uFF1A");
		//设置水平居中
		nameLable.setHorizontalAlignment(SwingConstants.CENTER);
		//设置位置和大小
		nameLable.setBounds(24, 61, 71, 24);
		//将lable放在面板中
		contentPane.add(nameLable);
		
		//密码
		JLabel pwdLable = new JLabel("\u5BC6\u7801\uFF1A");
		pwdLable.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLable.setBounds(24, 95, 71, 24);
		contentPane.add(pwdLable);
		
		//性别
		JLabel sexLable = new JLabel("\u6027\u522B\uFF1A");
		sexLable.setHorizontalAlignment(SwingConstants.CENTER);
		sexLable.setBounds(24, 129, 71, 24);
		contentPane.add(sexLable);
		
		//年龄
		JLabel ageLable = new JLabel("\u5E74\u9F84\uFF1A");
		ageLable.setHorizontalAlignment(SwingConstants.CENTER);
		ageLable.setBounds(24, 163, 71, 24);
		contentPane.add(ageLable);
		
		//实例化城市
		JLabel cityLable = new JLabel("\u57CE\u5E02\uFF1A");
		cityLable.setHorizontalAlignment(SwingConstants.CENTER);
		cityLable.setBounds(24, 197, 71, 24);
		contentPane.add(cityLable);
		
		//账号文本框
		accTextField = new JTextField();
		accTextField.setBounds(82, 27, 187, 24);
		contentPane.add(accTextField);
		accTextField.setColumns(10);
		
		//昵称文本框
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(82, 61, 187, 24);
		contentPane.add(nameTextField);
		
		//密码文本框
		pwdTextField = new JTextField();
		pwdTextField.setColumns(10);
		pwdTextField.setBounds(82, 95, 187, 24);
		contentPane.add(pwdTextField);
		
		//年龄文本框
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(82, 163, 187, 24);
		contentPane.add(ageTextField);
		
		//账号
		JLabel accLable = new JLabel("\u8D26\u53F7\uFF1A");
		//设置水平居中
		accLable.setHorizontalAlignment(SwingConstants.CENTER);
		accLable.setBounds(24, 27, 71, 24);
		contentPane.add(accLable);
		
		//单选框
		boyRadioButton = new JRadioButton("\u7537");
		boyRadioButton.setBounds(114, 127, 46, 28);
		//设置背景为透明
		boyRadioButton.setOpaque(false);
		contentPane.add(boyRadioButton);
		
		girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.setBounds(188, 125, 46, 28);
		//设置背景为透明
		girlRadioButton.setOpaque(false);
		contentPane.add(girlRadioButton);
		
		//实例化城市下拉列表
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u897F\u5B89", "\u5317\u4EAC", "\u5929\u6D25", "\u5357\u4EAC", "\u91CD\u5E86", "\u4E0A\u6D77"}));
		comboBox.setBounds(82, 197, 187, 21);
		contentPane.add(comboBox);
		
		//注册按钮
		button = new JButton("\u6CE8\u518C");
		//给注册按钮添加事件
		button.addActionListener(this);
		button.setBounds(50, 264, 93, 23);
		contentPane.add(button);
		
		//重置按钮
		button_1 = new JButton("\u91CD\u7F6E");
		//给重置按钮添加事件
		button_1.addActionListener(this);
		button_1.setBounds(176, 264, 93, 23);
		contentPane.add(button_1);
	}
	
	/**
	 * 给注册按钮与重置按钮添加事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) { //注册按钮
			LoginUser user = new LoginUser();//实例化用户信息
			//判断
			List<LoginUser> userList = raw.readAll();
			for (LoginUser loginUser : userList) {
				//注册账号和集合中的用户账号是否相同，如果相同则注册失败
				if(accTextField.getText().equals(loginUser.getAccount())) {
					JOptionPane.showMessageDialog(null, "注册失败，请重新注册!");
					break;
				} 
			}
			//昵称 账号 密码 性别 年龄 城市
			user.setName(nameTextField.getText());
			user.setAccount(accTextField.getText());
			user.setPassword(pwdTextField.getText());
			if (boyRadioButton.isSelected()) {
				user.setSex(boyRadioButton.getText());
			} else {
				user.setSex(girlRadioButton.getText());
			}
			user.setAge(Integer.parseInt(ageTextField.getText()));
			user.setCity(comboBox.getSelectedItem().toString());
			//将信息添加到集合
			userList.add(user);
			//写入文件
			raw.writeAll();
			//读取集合
			raw.readAll();
			JOptionPane.showMessageDialog(null, "注册成功!");
			LoginFrame loginFrame = new LoginFrame(startClient, account);
			loginFrame.setVisible(true);
			//自己消逝
			RegestFrame.this.setVisible(false);
		} else if(e.getSource() == button_1) {//重置按钮
			accTextField.setText("");
			nameTextField.setText("");
			pwdTextField.setText("");
			ageTextField.setText("");
		}
	}
}
