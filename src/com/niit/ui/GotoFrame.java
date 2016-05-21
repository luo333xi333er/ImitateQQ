package com.niit.ui;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.niit.client.StartClient;
/*
 * ͼ�����
 */
public class GotoFrame extends JWindow {

	//�����������
	private JPanel contentPane;
	//�����ı���
	private JTextField txtMiMi;
	//ͼƬ��ť
	private JButton btnNewButton;
	//�����ͻ���
	private static  StartClient startClient;

	
	/**
	 * Create the frame.
	 */
	public GotoFrame(StartClient startClient) { //��һ��StartClient
		this.startClient = startClient;
		//����λ�úʹ�С
		setBounds(100, 100, 216, 280);
		//���ھ���
		setLocationRelativeTo(null);
		//ʵ�������
		contentPane = new JPanel();
		//���ñ�����ɫ
		contentPane.setBackground(Color.GREEN);
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//����Ϊnull
		contentPane.setLayout(null);
		
		//ʵ���������ı���
		txtMiMi = new JTextField();
		//������ɫ
		txtMiMi.setBackground(Color.PINK);
		//����
		txtMiMi.setFont(new Font("��������", Font.BOLD, 40));
		//�ı�������
		txtMiMi.setText("MiMi");
		//�����ı���ˮƽ���뷽ʽ
		txtMiMi.setHorizontalAlignment(SwingConstants.CENTER);
		//����λ�úʹ�С
		txtMiMi.setBounds(10, 210, 196, 60);
		//���ı�����ӵ��������
		contentPane.add(txtMiMi);
		//��������
		txtMiMi.setColumns(10);
		
		//ʵ����ͼƬ��ť
		btnNewButton = new JButton("twinsimage");
		//�õ�ͼƬ��ť��·��
		btnNewButton.setIcon(new ImageIcon(GotoFrame.class.getResource("/com/niit/ui/gotoframe.jpg")));
		//����λ�úʹ�С
		btnNewButton.setBounds(25, 10, 167, 181);
		//��ͼƬ��ť��ӵ������
		contentPane.add(btnNewButton);
		//��ͼƬ��ť����¼�
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//���õ�¼����
				GotoFrame.this.startClient.getLoginFrame().setVisible(true);
				//�Լ�����
				GotoFrame.this.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		GotoFrame frame = new GotoFrame(startClient);
	}
}
