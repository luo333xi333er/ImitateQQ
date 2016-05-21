package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import com.niit.entity.Friends;
import com.niit.entity.Stranger;
import com.niit.image.AddFriendPanel;
import com.niit.util.ReadAndWrite;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * 点击查找好友按钮显示的好友资料并添加好友窗口
 */
public class addFriendFrame extends JFrame implements ActionListener{
	//定义内容面板
	private JPanel contentPane;
	//账号
	private JTextField textField;
	//昵称
	private JTextField textField_1;
	//年龄
	private JTextField textField_2;
	//性别
	private JTextField textField_3;
	//城市
	private JTextField textField_4;
	//添加好友
	private JButton addbutton;
	//读写好友信息
	private ReadAndWrite raw;
	
	public void init() {
		//设置标题 
		setTitle("\u8DEF\u4EBA\u8D44\u6599");
		//设置标题图片
		setIconImage(Toolkit.getDefaultToolkit().getImage(addFriendFrame.class.getResource("/com/niit/image/regest.jpg")));
		//窗体居中
		setLocationRelativeTo(null);
		//设置位置和大小
		setBounds(100, 100, 356, 294);
		//窗口居中
		setLocationRelativeTo(null);
		//实例化面板
		contentPane = new JPanel();
		//添加背景图片
		contentPane = new AddFriendPanel();
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗体的内容面板
		setContentPane(contentPane);
		//设置布局为空
		contentPane.setLayout(null);

		//好友资料
		JLabel lblNewLabel = new JLabel("\u8DEF\u4EBA\u8D44\u6599");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 10, 124, 25);
		contentPane.add(lblNewLabel);
		
		//账号
		JLabel accNewLabel = new JLabel("\u8D26\u53F7");
		accNewLabel.setForeground(Color.RED);
		accNewLabel.setFont(new Font("仿宋", Font.BOLD, 14));
		accNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accNewLabel.setBounds(40, 45, 54, 22);
		contentPane.add(accNewLabel);
		
		//昵称
		JLabel namelabel = new JLabel("\u6635\u79F0");
		namelabel.setForeground(Color.RED);
		namelabel.setFont(new Font("仿宋", Font.BOLD, 14));
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setBounds(40, 77, 54, 22);
		contentPane.add(namelabel);
		
		//年龄
		JLabel agelabel = new JLabel("\u5E74\u9F84");
		agelabel.setForeground(Color.RED);
		agelabel.setFont(new Font("仿宋", Font.BOLD, 14));
		agelabel.setHorizontalAlignment(SwingConstants.CENTER);
		agelabel.setBounds(40, 109, 54, 22);
		contentPane.add(agelabel);
		
		//性别
		JLabel sexlabel = new JLabel("\u6027\u522B");
		sexlabel.setForeground(Color.RED);
		sexlabel.setFont(new Font("仿宋", Font.BOLD, 14));
		sexlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexlabel.setBounds(40, 141, 54, 22);
		contentPane.add(sexlabel);
		
		//城市
		JLabel citylabel = new JLabel("\u57CE\u5E02");
		citylabel.setForeground(Color.RED);
		citylabel.setFont(new Font("华文楷体", Font.BOLD, 14));
		citylabel.setHorizontalAlignment(SwingConstants.CENTER);
		citylabel.setBounds(40, 173, 54, 22);
		contentPane.add(citylabel);
		
		//账号
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114, 46, 142, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//昵称
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(114, 78, 142, 21);
		contentPane.add(textField_1);
		
		//年龄
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(114, 110, 142, 21);
		contentPane.add(textField_2);
		
		//性别
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(114, 142, 142, 21);
		contentPane.add(textField_3);
		
		//城市
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(114, 174, 142, 21);
		contentPane.add(textField_4);
		
		//添加好友
		addbutton = new JButton("\u6DFB\u52A0\u597D\u53CB");
		addbutton.setFont(new Font("华文楷体", Font.BOLD, 12));
		addbutton.setBounds(122, 220, 92, 25);
		contentPane.add(addbutton);
		//给添加好添加事件
		addbutton.addActionListener(this);
	}
	
	public addFriendFrame(String friendAcc) {
		//窗口大小不能改变
		setResizable(false);
		init();
		//实例化
		raw = new ReadAndWrite();
		//调用readAll方法
		List<Stranger> strangerList = raw.readStranger();
		//得到账号为accMsg的信息
		for (Stranger stranger : strangerList) {
			if(stranger.getAccount().equals(friendAcc)) {
				//得到账号信息
				textField.setText(stranger.getAccount());
				//得到昵称信息
				textField_1.setText(stranger.getName());
				//得到年龄信息
				textField_2.setText(stranger.getAge() + "");
				//得到性别信息
				textField_3.setText(stranger.getSex());
				//得到城市信息
				textField_4.setText(stranger.getCity());
			} 
		}
	}

	/**
	 * 实现私聊与添加好友事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addbutton) { //添加好友
			//实例化好友
			Friends friends = new Friends();
			//取出要添加好友的信息    昵称 账号 密码 性别 年龄 城市
			friends.setName(textField_1.getText());
			friends.setAccount(textField.getText());
			friends.setPassword("null");
			friends.setSex(textField_3.getText());
			friends.setAge(Integer.parseInt(textField_2.getText()));
			friends.setCity(textField_4.getText());
			//调用方法
			List<Friends> friendList = raw.readFriends();
			//添加到好友集合
			friendList.add(friends);
			//写入文件
			raw.writeFriends();
			//读取到集合
			raw.readFriends();
			JOptionPane.showMessageDialog(null, "添加成功！");
		}
	}
}
