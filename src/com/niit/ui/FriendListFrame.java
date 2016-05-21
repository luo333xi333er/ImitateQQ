package com.niit.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import com.niit.client.StartClient;
import com.niit.entity.Friends;
import com.niit.entity.Node;
import com.niit.entity.Stranger;
import com.niit.image.FriendList;
import com.niit.util.ReadAndWrite;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * 好友列表界面
 */
public class FriendListFrame extends JFrame implements ActionListener, MouseListener {

	//内容面板
	private JPanel contentPane;
	private JTree tree; 
	private  DefaultTreeModel  mode;
	//用户account文本框
	private static JTextField txtAccount; 
	//个人资料按钮
	private JButton btnNewButton;
	//滚动面板
	private JScrollPane scrollPane ; 
	private StartClient  startClient;
	private JButton qlNewButton;
	private JTextField textField;
	//查找好友资料
	private JButton button;
	private JLabel lblNewLabel;
	
	//弹出式菜单
	private JPopupMenu popupMenu = null;
	//弹出式菜单的菜单项
	private JMenuItem privateChatItem = null;
	private JMenuItem deleteItem = null;
	private JMenuItem findMessageItem = null; 
	private JMenuItem sendFile = null;
	private JMenuItem sendEmailItem = null;

	//读写
	private ReadAndWrite raw;
	
	
	/**
	 * 弹出式菜单
	 */
	private void showMenu() {
		this.privateChatItem = new JMenuItem("私聊");
		//添加私聊监听
		this.privateChatItem.addActionListener(this);
		this.deleteItem = new JMenuItem("删除好友");
		//添加删除好友监听
		this.deleteItem.addActionListener(this);
		this.findMessageItem = new JMenuItem("查看好友资料");
		//添加查看好友资料监听
		this.findMessageItem.addActionListener(this);
		this.findMessageItem.addActionListener(this);
		this.sendFile = new JMenuItem("发送文件");
		this.sendFile.addActionListener(this);
		this.sendEmailItem = new JMenuItem("发送邮件");
		//弹出式菜单的添加
		this.popupMenu = new JPopupMenu();
		this.popupMenu.add(this.privateChatItem);
		//创建一个新的水平分隔符
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.deleteItem);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.findMessageItem);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.sendFile);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.sendEmailItem);
		//如果为 true，则该组件绘制其边界内的所有像素。
		this.popupMenu.setOpaque(false);
	}

	
	/**
	 * Create the frame.
	 */
	public FriendListFrame(StartClient  startClient, String account) {
		this.startClient = startClient;
		//实例化
		raw = new ReadAndWrite();
		//设置窗口不可变
		setResizable(false);
		//设置标题
		setTitle("\u597D\u53CB\u5217\u8868");
		//设置标题图片
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\twins\\MiMi2015\\src\\com\\niit\\ui\\regest.jpg"));
		//实例化StartClient
		this.startClient = startClient;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置位置和大小
		setBounds(100, 100, 233, 519);
		//实例化面板
		contentPane = new JPanel();	
		//添加背景图片
		contentPane = new FriendList();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//将面板设置为窗口的内容面板
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAccount = new JTextField();
		txtAccount.setEditable(false);
		txtAccount.setHorizontalAlignment(SwingConstants.CENTER);
		//设置位置和大小
		txtAccount.setBounds(45, 12, 66, 21);
		
		//显示正在登录的用户账号信息
		txtAccount.setText(account);
		
		//将文本框添加到内容面板
		contentPane.add(txtAccount);
		//设置列为10
		txtAccount.setColumns(10); 
		
		//实例化个人资料按钮
		btnNewButton = new JButton("个人资料"); 
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 13));
		//设置文本字体为红色
		btnNewButton.setForeground(Color.RED);
		//设置位置和大小
		btnNewButton.setBounds(121, 10, 94, 25);
		//将按钮添加到面板
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		//账号
		lblNewLabel = new JLabel("\u8D26\u53F7:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 12, 42, 21);
		contentPane.add(lblNewLabel);

		//群聊按钮
		qlNewButton = new JButton("\u7FA4\u804A");
		qlNewButton.setBounds(5, 456, 66, 25);
		qlNewButton.addActionListener(this);
		contentPane.add(qlNewButton);
		
		//输入查找信息
		textField = new JTextField();
		textField.setBounds(93, 458, 58, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//查找按钮
		button = new JButton("\u67E5\u627E");
		button.setBounds(149, 457, 66, 25);
		button.addActionListener(this);
		contentPane.add(button);
				
		//实例化一个滚动面板
		scrollPane = new JScrollPane(); 
		//设置位置和大小
		scrollPane.setBounds(5, 40, 215, 401);
		//将滚动面板添加到面板
		contentPane.add(scrollPane);
		
		//根节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Node("0","根节点"));
		//实例化mode
		mode = new DefaultTreeModel(root);
		//实例化tree
		tree = new JTree();
		tree.setBackground(Color.WHITE);
		//设置mode
		tree.setModel(mode);
		//设置tree的渲染器
		tree.setCellRenderer(new TreeCellRender());
		
		//设置好友节点
		DefaultMutableTreeNode friends = new DefaultMutableTreeNode(new Node("1","好朋友"));
		DefaultMutableTreeNode stranger = new DefaultMutableTreeNode(new Node("2","陌生人"));
		//将好朋友和陌生人添加到根节点
		root.add(friends);
		root.add(stranger);
		
		//添加好友  每个好友是一个 Node
		//调用方法
		List<Friends> friendList = raw.readFriends();
		for(int i = 0; i < friendList.size(); i++) {
			//取出账号
			String acc = friendList.get(i).getAccount();
			//取出昵称
			String name = friendList.get(i).getName();
			//将账号和昵称添加到node中
			friends.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + ".png")));
		}
		
		//添加陌生人
		//调用方法
		List<Stranger> strangerList = raw.readStranger();
		for(int i = 0; i < strangerList.size(); i++) {
			//取出路人账号
			String acc = strangerList.get(i).getAccount();
			//取出路人昵称
			String name = strangerList.get(i).getName();
			//将账号和昵称添加到node中
			stranger.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + "33.png")));
		}
		
		scrollPane.setViewportView(tree);
		//展开根节点
		tree.expandRow(0);
		tree.setRootVisible(false);
		//给tree添加事件
		tree.addMouseListener(this);
	}
	
	/**
	 * 新增好友
	 */
	public void addFriends() {
		List<Friends> friendList = raw.readFriends();
		for(int i = 0; i < friendList.size(); i++) {
			//取出账号
			String acc = friendList.get(i).getAccount();
			//取出昵称
			String name = friendList.get(i).getName();
			//设置好友节点
			DefaultMutableTreeNode friends = new DefaultMutableTreeNode(new Node("1","好朋友"));
			//将账号和昵称添加到node中
			friends.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + ".png")));
		}
	}
	
	/**
	 * 渲染Tree
	 */
	class TreeCellRender extends DefaultTreeCellRenderer{
		@Override
		public Component getTreeCellRendererComponent(
				JTree tree, Object value,
				boolean sel, boolean expanded, 
				boolean leaf, int row,
				boolean hasFocus) {
			//调用super
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			//得到节点转换
			DefaultMutableTreeNode treenode = (DefaultMutableTreeNode)value;
			//把Value转换为 Node;
			Node node = (Node)treenode.getUserObject();
			//通过Node的getImage()得到图标
			ImageIcon icon = new ImageIcon("images/" + node.getImage());
			//设置节点的图标
			setIcon(icon);
			//设置节点显示的值
			if(node.getName().equals("我朋友") || node.getName().equals("陌生人")) {
				setText(node.getName());
			} else {
				setText(node.getName() + "(" + node.getAccount() + ")");
			}
			return this;
		}
	}
	
	/**
	 * 实现按钮事件
	 * @param account 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) { //个人资料
			SelfMessageFrame messageFrame = new SelfMessageFrame(startClient, txtAccount.getText());
			messageFrame.setVisible(true);
		} else if(e.getSource() == qlNewButton) { //群聊
			FriendListFrame.this.startClient.getChatFrame().setVisible(true);
			FriendListFrame.this.startClient.getChatFrame().setAccount(txtAccount.getText());
		} else if(e.getSource() == button) { //查找好友,并添加好友
			//从账号文本框取到输入的账号  精确查询
			String friendAcc = textField.getText();
			//传一个要查询的好友的账号
			addFriendFrame friendFrame = new addFriendFrame(friendAcc);
			friendFrame.setVisible(true);
		} else if(e.getSource() == this.privateChatItem) { //私聊
			//弹出登录用户的发送框  —— 传发送者的账号与接收者的账号
			String account = txtAccount.getText();
			/**
			 * 转换为DefaultMutableTreeNode
			 * //接收者账号
			 */
          	DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			Node  node = (Node)d.getUserObject();
			String receiveAcc = node.getAccount();
			FriendListFrame.this.startClient.getSenderFrame().setVisible(true);
			FriendListFrame.this.startClient.getSenderFrame().setSAccount(account);
			FriendListFrame.this.startClient.getSenderFrame().setRAccount(receiveAcc);
		} else if(e.getSource() == this.deleteItem) { //删除好友
			//实例化mode
			DefaultTreeModel mode = (DefaultTreeModel)(tree.getModel());
			//转换为DefaultMutableTreeNode
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.tree.getLastSelectedPathComponent();
			mode.removeNodeFromParent(node);
		} else if(e.getSource() == this.findMessageItem) { //查看好友资料
			//转换为DefaultMutableTreeNode
          	DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			Node  node = (Node)d.getUserObject();
			FriendMessageFrame messageFrame = new FriendMessageFrame(startClient, node.getAccount());
			messageFrame.setVisible(true);
		}
	}

	/**
	 * 设置当前用户
	 * @param username
	*/
	public static void setAccount(String account) {
		txtAccount.setText(account);
	}

	/**
	 * 实现鼠标事件
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int selRow = tree.getRowForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getClickCount() == 1) {
	           	 //转换为DefaultMutableTreeNode
	           	 DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	           	 Node  node = (Node)d.getUserObject();
	           	 System.out.println("单击:" + node.getName() + ":" + node.getAccount());  	
            } else if(e.getButton() == MouseEvent.BUTTON3) { //右击2次，弹出下拉列表
            	this.showMenu();
    			this.popupMenu.show(this.getContentPane(), e.getX(), e.getY());
            }
        }
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
