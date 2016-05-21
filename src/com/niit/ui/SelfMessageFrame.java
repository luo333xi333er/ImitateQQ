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
 * �������ϴ���
 */
@SuppressWarnings("serial")
public class SelfMessageFrame extends JFrame {

	//�����������
	private JPanel contentPane;
	//�˺��ı���
	private JTextField textField;
	//�ǳ��ı���
	private JTextField textField_2;
	//�����ı���
	private JTextField textField_1;
	//�Ա��ı���
	private JTextField textField_4;
	//�����ı���
	private JTextField textField_3;
	
	private ReadAndWrite raw;

	/**
	 * Create the frame.
	 */
	public SelfMessageFrame(StartClient startClient, String account) {
		setResizable(false);
		//ʵ����ReadAndWrite��
		raw = new ReadAndWrite();
		init();
		List<LoginUser> userList = raw.readAll();
		for (LoginUser u : userList) {
			if(u.getAccount().equals(account)) {
				//�õ��˺���Ϣ
				textField.setText(u.getAccount());
				//�õ��ǳ���Ϣ
				textField_2.setText(u.getName());
				//�õ�������Ϣ
				textField_1.setText(u.getAge() + "");
				//�õ��Ա���Ϣ
				textField_4.setText(u.getSex());
				//�õ�������Ϣ
				textField_3.setText(u.getCity());
			}
		}
	}
	
	public void init() {
		//������ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\twins\\MiMi2015\\src\\com\\niit\\ui\\loginframe.jpg"));
		//����
		setTitle("\u4E2A\u4EBA\u8D44\u6599");
		//�������
		setLocationRelativeTo(null);
		//����λ�úʹ�С
		setBounds(100, 100, 387, 293);
		//���ھ���
		setLocationRelativeTo(null);
		//ʵ�������
		contentPane = new JPanel();
		//��ӱ���ͼƬ
		contentPane = new SelfMsgPanel();
		contentPane.setForeground(Color.RED);
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//���ò���Ϊ��
		contentPane.setLayout(null);
		
		//��������
		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u8D44\u6599");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("���Ŀ���", Font.BOLD, 17));
		lblNewLabel.setBounds(142, 10, 80, 45);
		contentPane.add(lblNewLabel);
		
		//�˺�
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 69, 44, 21);
		contentPane.add(lblNewLabel_1);
		
		//�˺��ı���
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114, 69, 170, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//�Ա�
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("����", Font.BOLD, 12));
		label_2.setForeground(Color.RED);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(68, 163, 44, 21);
		contentPane.add(label_2);
		
		//�Ա��ı���
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(114, 163, 170, 21);
		contentPane.add(textField_4);
		
		//����
		JLabel label_1 = new JLabel("\u5E74\u9F84");
		label_1.setFont(new Font("����", Font.BOLD, 12));
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(68, 131, 44, 21);
		contentPane.add(label_1);
		
		//�����ı���
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(114, 131, 170, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//�ǳ�
		JLabel label = new JLabel("\u6635\u79F0");
		label.setFont(new Font("����", Font.BOLD, 12));
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(68, 100, 44, 21);
		contentPane.add(label);
		
		//�ǳ��ı���
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(114, 100, 170, 21);
		contentPane.add(textField_2);
		
		//����
		JLabel label_3 = new JLabel("\u57CE\u5E02");
		label_3.setFont(new Font("����", Font.BOLD, 12));
		label_3.setForeground(Color.RED);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(68, 195, 44, 21);
		contentPane.add(label_3);
		
		//�����ı���
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(114, 195, 170, 21);
		contentPane.add(textField_3);
	}
}
