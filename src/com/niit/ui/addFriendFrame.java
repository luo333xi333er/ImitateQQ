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
 * ������Һ��Ѱ�ť��ʾ�ĺ������ϲ���Ӻ��Ѵ���
 */
public class addFriendFrame extends JFrame implements ActionListener{
	//�����������
	private JPanel contentPane;
	//�˺�
	private JTextField textField;
	//�ǳ�
	private JTextField textField_1;
	//����
	private JTextField textField_2;
	//�Ա�
	private JTextField textField_3;
	//����
	private JTextField textField_4;
	//��Ӻ���
	private JButton addbutton;
	//��д������Ϣ
	private ReadAndWrite raw;
	
	public void init() {
		//���ñ��� 
		setTitle("\u8DEF\u4EBA\u8D44\u6599");
		//���ñ���ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage(addFriendFrame.class.getResource("/com/niit/image/regest.jpg")));
		//�������
		setLocationRelativeTo(null);
		//����λ�úʹ�С
		setBounds(100, 100, 356, 294);
		//���ھ���
		setLocationRelativeTo(null);
		//ʵ�������
		contentPane = new JPanel();
		//��ӱ���ͼƬ
		contentPane = new AddFriendPanel();
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//���ò���Ϊ��
		contentPane.setLayout(null);

		//��������
		JLabel lblNewLabel = new JLabel("\u8DEF\u4EBA\u8D44\u6599");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("���Ŀ���", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 10, 124, 25);
		contentPane.add(lblNewLabel);
		
		//�˺�
		JLabel accNewLabel = new JLabel("\u8D26\u53F7");
		accNewLabel.setForeground(Color.RED);
		accNewLabel.setFont(new Font("����", Font.BOLD, 14));
		accNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accNewLabel.setBounds(40, 45, 54, 22);
		contentPane.add(accNewLabel);
		
		//�ǳ�
		JLabel namelabel = new JLabel("\u6635\u79F0");
		namelabel.setForeground(Color.RED);
		namelabel.setFont(new Font("����", Font.BOLD, 14));
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setBounds(40, 77, 54, 22);
		contentPane.add(namelabel);
		
		//����
		JLabel agelabel = new JLabel("\u5E74\u9F84");
		agelabel.setForeground(Color.RED);
		agelabel.setFont(new Font("����", Font.BOLD, 14));
		agelabel.setHorizontalAlignment(SwingConstants.CENTER);
		agelabel.setBounds(40, 109, 54, 22);
		contentPane.add(agelabel);
		
		//�Ա�
		JLabel sexlabel = new JLabel("\u6027\u522B");
		sexlabel.setForeground(Color.RED);
		sexlabel.setFont(new Font("����", Font.BOLD, 14));
		sexlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sexlabel.setBounds(40, 141, 54, 22);
		contentPane.add(sexlabel);
		
		//����
		JLabel citylabel = new JLabel("\u57CE\u5E02");
		citylabel.setForeground(Color.RED);
		citylabel.setFont(new Font("���Ŀ���", Font.BOLD, 14));
		citylabel.setHorizontalAlignment(SwingConstants.CENTER);
		citylabel.setBounds(40, 173, 54, 22);
		contentPane.add(citylabel);
		
		//�˺�
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114, 46, 142, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//�ǳ�
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(114, 78, 142, 21);
		contentPane.add(textField_1);
		
		//����
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(114, 110, 142, 21);
		contentPane.add(textField_2);
		
		//�Ա�
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(114, 142, 142, 21);
		contentPane.add(textField_3);
		
		//����
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(114, 174, 142, 21);
		contentPane.add(textField_4);
		
		//��Ӻ���
		addbutton = new JButton("\u6DFB\u52A0\u597D\u53CB");
		addbutton.setFont(new Font("���Ŀ���", Font.BOLD, 12));
		addbutton.setBounds(122, 220, 92, 25);
		contentPane.add(addbutton);
		//����Ӻ�����¼�
		addbutton.addActionListener(this);
	}
	
	public addFriendFrame(String friendAcc) {
		//���ڴ�С���ܸı�
		setResizable(false);
		init();
		//ʵ����
		raw = new ReadAndWrite();
		//����readAll����
		List<Stranger> strangerList = raw.readStranger();
		//�õ��˺�ΪaccMsg����Ϣ
		for (Stranger stranger : strangerList) {
			if(stranger.getAccount().equals(friendAcc)) {
				//�õ��˺���Ϣ
				textField.setText(stranger.getAccount());
				//�õ��ǳ���Ϣ
				textField_1.setText(stranger.getName());
				//�õ�������Ϣ
				textField_2.setText(stranger.getAge() + "");
				//�õ��Ա���Ϣ
				textField_3.setText(stranger.getSex());
				//�õ�������Ϣ
				textField_4.setText(stranger.getCity());
			} 
		}
	}

	/**
	 * ʵ��˽������Ӻ����¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.addbutton) { //��Ӻ���
			//ʵ��������
			Friends friends = new Friends();
			//ȡ��Ҫ��Ӻ��ѵ���Ϣ    �ǳ� �˺� ���� �Ա� ���� ����
			friends.setName(textField_1.getText());
			friends.setAccount(textField.getText());
			friends.setPassword("null");
			friends.setSex(textField_3.getText());
			friends.setAge(Integer.parseInt(textField_2.getText()));
			friends.setCity(textField_4.getText());
			//���÷���
			List<Friends> friendList = raw.readFriends();
			//��ӵ����Ѽ���
			friendList.add(friends);
			//д���ļ�
			raw.writeFriends();
			//��ȡ������
			raw.readFriends();
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
		}
	}
}
