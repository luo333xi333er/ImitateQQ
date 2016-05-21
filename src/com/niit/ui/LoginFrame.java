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
 * �û���¼����
 */
public class LoginFrame extends JFrame implements ActionListener {

	//�������
	private JPanel contentPane;
	//��¼�˺��ı���
	private JTextField acctextField;
	//�����ı���
	private JPasswordField pwdtextField;
	//����MiMiͼ��
	private JLabel lblNewLabel;
	private JLabel label;
	//��ס����
	private JRadioButton radioButton;
	//�Զ���¼
	private JRadioButton radioButton_1;
	//����
	private JButton button_1;
	//��������
	private JButton button_2;
	//ע��
	private JButton button;
	//��¼
	private JButton btnNewButton;
	
	private StartClient startClient;
	//��д
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
		//����������ͼ��
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//���ñ���
		setTitle("MiMi\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 287);
		//�������
		setLocationRelativeTo(null);
		
		//��ӱ���ͼƬ
		contentPane = new LoginPanel();
		//���������ǰ��ɫ
		contentPane.setForeground(new Color(255, 240, 245));
		//��������ı���ɫ
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//���Ĳ�������Ϊ��
		contentPane.setLayout(null);
		
		acctextField = new JTextField();
		//����λ�úʹ�С
		acctextField.setBounds(144, 72, 139, 31);
		//���ı�����ӵ������
		contentPane.add(acctextField);
		//����Ϊ10��
		acctextField.setColumns(10);
		
		pwdtextField = new JPasswordField();
		//����Ϊ10��
		pwdtextField.setColumns(10);
		//����λ�úʹ�С
		pwdtextField.setBounds(144, 128, 139, 31);
		//���������ӵ������
		contentPane.add(pwdtextField);
		
		//��¼��ť
		btnNewButton = new JButton("��¼");
		//����¼��ť����¼�
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(81, 208, 93, 31);
		contentPane.add(btnNewButton);
		
		//ע�ᰴť
		button = new JButton("\u6CE8\u518C");
		//��ע�ᰴť����¼�
		button.addActionListener(this);
		button.setBounds(226, 208, 87, 31);
		contentPane.add(button);
		
		//��ʾͼ��
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		lblNewLabel.setBounds(10, 72, 79, 87);
		contentPane.add(lblNewLabel);
		
		//��ס����
		radioButton = new JRadioButton("\u8BB0\u4F4F\u5BC6\u7801");
		radioButton.setBounds(121, 179, 79, 23);
		//���ñ���Ϊ͸��
		radioButton.setOpaque(false);
		contentPane.add(radioButton);
		
		//�Զ���¼
		radioButton_1 = new JRadioButton("\u81EA\u52A8\u767B\u5F55");
		radioButton_1.setBounds(204, 179, 79, 23);
		//���ñ���Ϊ͸��
		radioButton_1.setOpaque(false);
		contentPane.add(radioButton_1);
		
		//����
		button_1 = new JButton("\u91CD\u7F6E");
		//�����ð�ť����¼�
		button_1.addActionListener(this);
		button_1.setBounds(300, 72, 81, 31);
		contentPane.add(button_1);
		
		//��������
		button_2 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		//����͸��
		button_2.setBounds(300, 128, 81, 31);
		contentPane.add(button_2);
		//������������Ӽ���
		button_2.addActionListener(this);
		
		//�Զ���¼
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(99, 72, 46, 31);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(99, 128, 46, 31);
		contentPane.add(label);
	}

	//ʵ���¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		//��¼��ť�¼�
		if(e.getSource() == btnNewButton) {
			//���ı����еõ���¼�˺�
			String account = acctextField.getText();
			//��������еõ�����
			String password = new String(pwdtextField.getPassword());
			if(account.trim().equals("")) {
				JOptionPane.showMessageDialog(LoginFrame.this, "�������˺ţ�");
			} else {
				//���� client
				LoginFrame.this.startClient.login(account, password);
			}
		}else if(e.getSource() == button) { //ע�ᰴť����¼�
			//����ע�����
			RegestFrame regestFrame = new RegestFrame(startClient);
			//��ʾ��¼����
			regestFrame.setVisible(true);
			//�Լ���ʧ
			LoginFrame.this.setVisible(false);
		} else if(e.getSource() == button_1) { //���ð�ť����¼�
			acctextField.setText("");
		} else if(e.getSource() == button_2) {  //��������
			//���÷���
			List<LoginUser> userList = raw.readAll();
			for (LoginUser User : userList) {
				if(User.getAccount().equals(acctextField.getText())) {
					//ȡ������
					String pwd = User.getPassword();
					JOptionPane.showMessageDialog(null, "����������" + pwd + ",�����룡");
				}
			}
		}
	}
}			
