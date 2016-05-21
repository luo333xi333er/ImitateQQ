package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.niit.client.StartClient;
import com.niit.image.ChatPanel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 群聊界面
 */
public class ChatFrame extends JFrame {

	//面板
	private JPanel contentPane;
	//发送框
	private JTextField txt_send;
	private JTextArea txt_show;
	//在线人员列表
	private JList list_online;
	//人员列表
	private DefaultListModel mode;
	//发送按钮
	private JButton btn_send;
	//显示正在群聊用户
	private static JLabel lblNewLabel;

	private StartClient  startClient;
	private JScrollPane scrollPane_1;
	
	private  String account;
	

	/**
	 * Create the frame.
	 */
	public ChatFrame(StartClient  startClient,String account1) {
		this.account = account1;
		//实例化startClient
		this.startClient = startClient;
		//设置标题图片
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//设置标题
		setTitle("\u7FA4\u804A\u6846");
		//窗口不可变的
		setResizable(false);
		//设置位置和大小
		setBounds(100, 100, 492, 451);
		//窗口居中
		setLocationRelativeTo(null);
		//设置背景图片
		contentPane = new ChatPanel();
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为内容面板
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//定义组件滚动面板
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 359, 275);
		//不可变形
		scrollPane.setEnabled(false);
		//确定垂直滚动条何时显示在滚动窗格上
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//确定水平滚动条何时显示在滚动窗格上
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//将滚动面板添加到面板中
		contentPane.add(scrollPane);
		
		//显示当前登录的用户
		lblNewLabel = new JLabel();
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 25, 61, 25);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		//群聊标签
		JLabel label = new JLabel("的群聊框:");
		label.setBounds(73, 25, 71, 25);
		label.setForeground(Color.RED);
		label.setBackground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		contentPane.add(label);
		
		mode = new DefaultListModel();
		
		//发送内容消息框
		txt_send = new JTextField();
		txt_send.setBounds(10, 362, 359, 32);
		contentPane.add(txt_send);
		txt_send.setColumns(10);
		
		//消息显示框
		txt_show = new JTextArea();
		txt_show.setEditable(false);
		txt_show.setEnabled(false);
		scrollPane.setViewportView(txt_show);
		
		//发送按钮事件
		btn_send = new JButton("\u53D1\u9001");
		btn_send.setBounds(379, 365, 95, 25);
		//给发送按钮添加事件
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//时间
				String time = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss").format(new Date());
				//取出消息框内容
				String text = txt_send.getText();
				//将消息框清空
				txt_send.setText("");
				//登录用户向指定在线好友或者大家发送消息
				String receiver = list_online.getSelectedValue() == null
						?"大家":list_online.getSelectedValue().toString();
				String sender = lblNewLabel.getText();
				//消息内容
				String message = "[" + time + "]$$" + sender + "对" + receiver + "说:" + text + "$$";
				//通过client发送
				ChatFrame.this.startClient.sendMessage(message);
			}
		});
		//将发送按钮添加到面板中
		contentPane.add(btn_send);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(379, 25, 93, 315);
		contentPane.add(scrollPane_1);
		
		//在线人员列表
		list_online = new JList();
		scrollPane_1.setViewportView(list_online);
		list_online.setBorder(new TitledBorder(null, "在线人员", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_online.setModel(mode);
		
		
		//添加窗口关闭事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ChatFrame.this.startClient.logOut(account);
			}
		});
	}
	
	/**
	 * 设置在线人员列表
	 */
	public  void  setOnlineUser(String[] onlineUsers){
		//清除在线人员信息
		mode.clear();
		for(String user : onlineUsers){
			mode.addElement(user);
		}
	}

	/**
	 * 添加群聊消息
	 */
	public  void  addMessageToTextArea(String msg){
		msg = msg.replace("$$", "\n");
		//附加消息
		System.out.println(msg);
		txt_show.append(msg);
	}
	
	/**
	 * 设置当前用户
	 * @param username
	*/
	public  void setAccount(String account) {
		this.account = account;
		lblNewLabel.setText(account);
	}
}
