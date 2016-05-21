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
 * �����б����
 */
public class FriendListFrame extends JFrame implements ActionListener, MouseListener {

	//�������
	private JPanel contentPane;
	private JTree tree; 
	private  DefaultTreeModel  mode;
	//�û�account�ı���
	private static JTextField txtAccount; 
	//�������ϰ�ť
	private JButton btnNewButton;
	//�������
	private JScrollPane scrollPane ; 
	private StartClient  startClient;
	private JButton qlNewButton;
	private JTextField textField;
	//���Һ�������
	private JButton button;
	private JLabel lblNewLabel;
	
	//����ʽ�˵�
	private JPopupMenu popupMenu = null;
	//����ʽ�˵��Ĳ˵���
	private JMenuItem privateChatItem = null;
	private JMenuItem deleteItem = null;
	private JMenuItem findMessageItem = null; 
	private JMenuItem sendFile = null;
	private JMenuItem sendEmailItem = null;

	//��д
	private ReadAndWrite raw;
	
	
	/**
	 * ����ʽ�˵�
	 */
	private void showMenu() {
		this.privateChatItem = new JMenuItem("˽��");
		//���˽�ļ���
		this.privateChatItem.addActionListener(this);
		this.deleteItem = new JMenuItem("ɾ������");
		//���ɾ�����Ѽ���
		this.deleteItem.addActionListener(this);
		this.findMessageItem = new JMenuItem("�鿴��������");
		//��Ӳ鿴�������ϼ���
		this.findMessageItem.addActionListener(this);
		this.findMessageItem.addActionListener(this);
		this.sendFile = new JMenuItem("�����ļ�");
		this.sendFile.addActionListener(this);
		this.sendEmailItem = new JMenuItem("�����ʼ�");
		//����ʽ�˵������
		this.popupMenu = new JPopupMenu();
		this.popupMenu.add(this.privateChatItem);
		//����һ���µ�ˮƽ�ָ���
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.deleteItem);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.findMessageItem);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.sendFile);
		this.popupMenu.add(new JSeparator());
		this.popupMenu.add(this.sendEmailItem);
		//���Ϊ true��������������߽��ڵ��������ء�
		this.popupMenu.setOpaque(false);
	}

	
	/**
	 * Create the frame.
	 */
	public FriendListFrame(StartClient  startClient, String account) {
		this.startClient = startClient;
		//ʵ����
		raw = new ReadAndWrite();
		//���ô��ڲ��ɱ�
		setResizable(false);
		//���ñ���
		setTitle("\u597D\u53CB\u5217\u8868");
		//���ñ���ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\twins\\MiMi2015\\src\\com\\niit\\ui\\regest.jpg"));
		//ʵ����StartClient
		this.startClient = startClient;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����λ�úʹ�С
		setBounds(100, 100, 233, 519);
		//ʵ�������
		contentPane = new JPanel();	
		//��ӱ���ͼƬ
		contentPane = new FriendList();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ���ڵ��������
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAccount = new JTextField();
		txtAccount.setEditable(false);
		txtAccount.setHorizontalAlignment(SwingConstants.CENTER);
		//����λ�úʹ�С
		txtAccount.setBounds(45, 12, 66, 21);
		
		//��ʾ���ڵ�¼���û��˺���Ϣ
		txtAccount.setText(account);
		
		//���ı�����ӵ��������
		contentPane.add(txtAccount);
		//������Ϊ10
		txtAccount.setColumns(10); 
		
		//ʵ�����������ϰ�ť
		btnNewButton = new JButton("��������"); 
		btnNewButton.setFont(new Font("����", Font.BOLD, 13));
		//�����ı�����Ϊ��ɫ
		btnNewButton.setForeground(Color.RED);
		//����λ�úʹ�С
		btnNewButton.setBounds(121, 10, 94, 25);
		//����ť��ӵ����
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		//�˺�
		lblNewLabel = new JLabel("\u8D26\u53F7:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 12, 42, 21);
		contentPane.add(lblNewLabel);

		//Ⱥ�İ�ť
		qlNewButton = new JButton("\u7FA4\u804A");
		qlNewButton.setBounds(5, 456, 66, 25);
		qlNewButton.addActionListener(this);
		contentPane.add(qlNewButton);
		
		//���������Ϣ
		textField = new JTextField();
		textField.setBounds(93, 458, 58, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//���Ұ�ť
		button = new JButton("\u67E5\u627E");
		button.setBounds(149, 457, 66, 25);
		button.addActionListener(this);
		contentPane.add(button);
				
		//ʵ����һ���������
		scrollPane = new JScrollPane(); 
		//����λ�úʹ�С
		scrollPane.setBounds(5, 40, 215, 401);
		//�����������ӵ����
		contentPane.add(scrollPane);
		
		//���ڵ�
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Node("0","���ڵ�"));
		//ʵ����mode
		mode = new DefaultTreeModel(root);
		//ʵ����tree
		tree = new JTree();
		tree.setBackground(Color.WHITE);
		//����mode
		tree.setModel(mode);
		//����tree����Ⱦ��
		tree.setCellRenderer(new TreeCellRender());
		
		//���ú��ѽڵ�
		DefaultMutableTreeNode friends = new DefaultMutableTreeNode(new Node("1","������"));
		DefaultMutableTreeNode stranger = new DefaultMutableTreeNode(new Node("2","İ����"));
		//�������Ѻ�İ������ӵ����ڵ�
		root.add(friends);
		root.add(stranger);
		
		//��Ӻ���  ÿ��������һ�� Node
		//���÷���
		List<Friends> friendList = raw.readFriends();
		for(int i = 0; i < friendList.size(); i++) {
			//ȡ���˺�
			String acc = friendList.get(i).getAccount();
			//ȡ���ǳ�
			String name = friendList.get(i).getName();
			//���˺ź��ǳ���ӵ�node��
			friends.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + ".png")));
		}
		
		//���İ����
		//���÷���
		List<Stranger> strangerList = raw.readStranger();
		for(int i = 0; i < strangerList.size(); i++) {
			//ȡ��·���˺�
			String acc = strangerList.get(i).getAccount();
			//ȡ��·���ǳ�
			String name = strangerList.get(i).getName();
			//���˺ź��ǳ���ӵ�node��
			stranger.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + "33.png")));
		}
		
		scrollPane.setViewportView(tree);
		//չ�����ڵ�
		tree.expandRow(0);
		tree.setRootVisible(false);
		//��tree����¼�
		tree.addMouseListener(this);
	}
	
	/**
	 * ��������
	 */
	public void addFriends() {
		List<Friends> friendList = raw.readFriends();
		for(int i = 0; i < friendList.size(); i++) {
			//ȡ���˺�
			String acc = friendList.get(i).getAccount();
			//ȡ���ǳ�
			String name = friendList.get(i).getName();
			//���ú��ѽڵ�
			DefaultMutableTreeNode friends = new DefaultMutableTreeNode(new Node("1","������"));
			//���˺ź��ǳ���ӵ�node��
			friends.add(new DefaultMutableTreeNode(new Node(acc, name, "" + (i + 1) + ".png")));
		}
	}
	
	/**
	 * ��ȾTree
	 */
	class TreeCellRender extends DefaultTreeCellRenderer{
		@Override
		public Component getTreeCellRendererComponent(
				JTree tree, Object value,
				boolean sel, boolean expanded, 
				boolean leaf, int row,
				boolean hasFocus) {
			//����super
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			//�õ��ڵ�ת��
			DefaultMutableTreeNode treenode = (DefaultMutableTreeNode)value;
			//��Valueת��Ϊ Node;
			Node node = (Node)treenode.getUserObject();
			//ͨ��Node��getImage()�õ�ͼ��
			ImageIcon icon = new ImageIcon("images/" + node.getImage());
			//���ýڵ��ͼ��
			setIcon(icon);
			//���ýڵ���ʾ��ֵ
			if(node.getName().equals("������") || node.getName().equals("İ����")) {
				setText(node.getName());
			} else {
				setText(node.getName() + "(" + node.getAccount() + ")");
			}
			return this;
		}
	}
	
	/**
	 * ʵ�ְ�ť�¼�
	 * @param account 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) { //��������
			SelfMessageFrame messageFrame = new SelfMessageFrame(startClient, txtAccount.getText());
			messageFrame.setVisible(true);
		} else if(e.getSource() == qlNewButton) { //Ⱥ��
			FriendListFrame.this.startClient.getChatFrame().setVisible(true);
			FriendListFrame.this.startClient.getChatFrame().setAccount(txtAccount.getText());
		} else if(e.getSource() == button) { //���Һ���,����Ӻ���
			//���˺��ı���ȡ��������˺�  ��ȷ��ѯ
			String friendAcc = textField.getText();
			//��һ��Ҫ��ѯ�ĺ��ѵ��˺�
			addFriendFrame friendFrame = new addFriendFrame(friendAcc);
			friendFrame.setVisible(true);
		} else if(e.getSource() == this.privateChatItem) { //˽��
			//������¼�û��ķ��Ϳ�  ���� �������ߵ��˺�������ߵ��˺�
			String account = txtAccount.getText();
			/**
			 * ת��ΪDefaultMutableTreeNode
			 * //�������˺�
			 */
          	DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			Node  node = (Node)d.getUserObject();
			String receiveAcc = node.getAccount();
			FriendListFrame.this.startClient.getSenderFrame().setVisible(true);
			FriendListFrame.this.startClient.getSenderFrame().setSAccount(account);
			FriendListFrame.this.startClient.getSenderFrame().setRAccount(receiveAcc);
		} else if(e.getSource() == this.deleteItem) { //ɾ������
			//ʵ����mode
			DefaultTreeModel mode = (DefaultTreeModel)(tree.getModel());
			//ת��ΪDefaultMutableTreeNode
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.tree.getLastSelectedPathComponent();
			mode.removeNodeFromParent(node);
		} else if(e.getSource() == this.findMessageItem) { //�鿴��������
			//ת��ΪDefaultMutableTreeNode
          	DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			Node  node = (Node)d.getUserObject();
			FriendMessageFrame messageFrame = new FriendMessageFrame(startClient, node.getAccount());
			messageFrame.setVisible(true);
		}
	}

	/**
	 * ���õ�ǰ�û�
	 * @param username
	*/
	public static void setAccount(String account) {
		txtAccount.setText(account);
	}

	/**
	 * ʵ������¼�
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int selRow = tree.getRowForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getClickCount() == 1) {
	           	 //ת��ΪDefaultMutableTreeNode
	           	 DefaultMutableTreeNode d = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	           	 Node  node = (Node)d.getUserObject();
	           	 System.out.println("����:" + node.getName() + ":" + node.getAccount());  	
            } else if(e.getButton() == MouseEvent.BUTTON3) { //�һ�2�Σ����������б�
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
