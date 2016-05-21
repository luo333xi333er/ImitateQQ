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
 * Ⱥ�Ľ���
 */
public class ChatFrame extends JFrame {

	//���
	private JPanel contentPane;
	//���Ϳ�
	private JTextField txt_send;
	private JTextArea txt_show;
	//������Ա�б�
	private JList list_online;
	//��Ա�б�
	private DefaultListModel mode;
	//���Ͱ�ť
	private JButton btn_send;
	//��ʾ����Ⱥ���û�
	private static JLabel lblNewLabel;

	private StartClient  startClient;
	private JScrollPane scrollPane_1;
	
	private  String account;
	

	/**
	 * Create the frame.
	 */
	public ChatFrame(StartClient  startClient,String account1) {
		this.account = account1;
		//ʵ����startClient
		this.startClient = startClient;
		//���ñ���ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//���ñ���
		setTitle("\u7FA4\u804A\u6846");
		//���ڲ��ɱ��
		setResizable(false);
		//����λ�úʹ�С
		setBounds(100, 100, 492, 451);
		//���ھ���
		setLocationRelativeTo(null);
		//���ñ���ͼƬ
		contentPane = new ChatPanel();
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ�������
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//��������������
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 359, 275);
		//���ɱ���
		scrollPane.setEnabled(false);
		//ȷ����ֱ��������ʱ��ʾ�ڹ���������
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//ȷ��ˮƽ��������ʱ��ʾ�ڹ���������
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//�����������ӵ������
		contentPane.add(scrollPane);
		
		//��ʾ��ǰ��¼���û�
		lblNewLabel = new JLabel();
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 25, 61, 25);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		//Ⱥ�ı�ǩ
		JLabel label = new JLabel("��Ⱥ�Ŀ�:");
		label.setBounds(73, 25, 71, 25);
		label.setForeground(Color.RED);
		label.setBackground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 14));
		contentPane.add(label);
		
		mode = new DefaultListModel();
		
		//����������Ϣ��
		txt_send = new JTextField();
		txt_send.setBounds(10, 362, 359, 32);
		contentPane.add(txt_send);
		txt_send.setColumns(10);
		
		//��Ϣ��ʾ��
		txt_show = new JTextArea();
		txt_show.setEditable(false);
		txt_show.setEnabled(false);
		scrollPane.setViewportView(txt_show);
		
		//���Ͱ�ť�¼�
		btn_send = new JButton("\u53D1\u9001");
		btn_send.setBounds(379, 365, 95, 25);
		//�����Ͱ�ť����¼�
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ʱ��
				String time = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss").format(new Date());
				//ȡ����Ϣ������
				String text = txt_send.getText();
				//����Ϣ�����
				txt_send.setText("");
				//��¼�û���ָ�����ߺ��ѻ��ߴ�ҷ�����Ϣ
				String receiver = list_online.getSelectedValue() == null
						?"���":list_online.getSelectedValue().toString();
				String sender = lblNewLabel.getText();
				//��Ϣ����
				String message = "[" + time + "]$$" + sender + "��" + receiver + "˵:" + text + "$$";
				//ͨ��client����
				ChatFrame.this.startClient.sendMessage(message);
			}
		});
		//�����Ͱ�ť��ӵ������
		contentPane.add(btn_send);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(379, 25, 93, 315);
		contentPane.add(scrollPane_1);
		
		//������Ա�б�
		list_online = new JList();
		scrollPane_1.setViewportView(list_online);
		list_online.setBorder(new TitledBorder(null, "������Ա", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_online.setModel(mode);
		
		
		//��Ӵ��ڹر��¼�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ChatFrame.this.startClient.logOut(account);
			}
		});
	}
	
	/**
	 * ����������Ա�б�
	 */
	public  void  setOnlineUser(String[] onlineUsers){
		//���������Ա��Ϣ
		mode.clear();
		for(String user : onlineUsers){
			mode.addElement(user);
		}
	}

	/**
	 * ���Ⱥ����Ϣ
	 */
	public  void  addMessageToTextArea(String msg){
		msg = msg.replace("$$", "\n");
		//������Ϣ
		System.out.println(msg);
		txt_show.append(msg);
	}
	
	/**
	 * ���õ�ǰ�û�
	 * @param username
	*/
	public  void setAccount(String account) {
		this.account = account;
		lblNewLabel.setText(account);
	}
}
