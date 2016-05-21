package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.niit.client.StartClient;
import com.niit.image.ReceiverPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * ������Ϣ����
 */
public class ReceiverFrame extends JFrame implements ActionListener{

	//���
	private JPanel contentPane;
	//
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	//�ظ���ť
	private JButton replybutton;
	//�رհ�ť
	private JButton closebutton;
	private StartClient startClient;
	private String account;
	private String receiveAcc;

	/**
	 * Create the frame.
	 */
	public ReceiverFrame(StartClient startClient, String account, String receiveAcc) {
		this.startClient = startClient;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		setTitle("\u63A5\u6536\u6846");
		//���ñ���ͼƬ
		contentPane = new ReceiverPanel();
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//������
		JLabel lblNewLabel = new JLabel("\u53D1 \u9001 \u8005:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 57, 75, 25);
		contentPane.add(lblNewLabel);
		
		//��������
		JLabel label = new JLabel("\u63A5\u6536\u5185\u5BB9:");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(24, 92, 75, 25);
		contentPane.add(label);
		
		//������
		JLabel label_1 = new JLabel("\u63A5 \u6536 \u8005:");
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(24, 22, 75, 25);
		contentPane.add(label_1);
		
		//�������˺�
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 59, 261, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//�������˺�
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(100, 24, 261, 21);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(100, 92, 261, 114);
		contentPane.add(scrollPane);
		
		//���������ı���
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		 
		//�ظ���ť
		replybutton = new JButton("\u56DE\u590D");
		replybutton.setBounds(122, 229, 93, 23);
		contentPane.add(replybutton);
		//���ظ���ť����¼�
		replybutton.addActionListener(this);
		
		//�ر�
		closebutton = new JButton("\u5173\u95ED");
		closebutton.setBounds(247, 229, 93, 23);
		contentPane.add(closebutton);
		//���رհ�ť����¼�
		closebutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.replybutton) { //�ظ���ť
			//�Լ���ɷ�����
			String receiveAcc = textField_1.getText();
			String account = textField.getText();
			//ȡ��Ҫ���͵���Ϣ
			String sendMsg = receiveAcc + "��" + account + "˵:" + textArea.getText() + "$$";
			//ͨ��client����
			ReceiverFrame.this.startClient.sendP1Message(sendMsg);
			//����������Ϣ��
			SenderFrame frame = new SenderFrame(startClient, receiveAcc, account);
			frame.setVisible(true);
		} else if(e.getSource() == this.closebutton) { //�رհ�ť
			ReceiverFrame.this.setVisible(false);
		}
	}
	

	/**
	 * ���˽����Ϣ
	 */
	public void addMessageToTextArea(String pmsg) {
		pmsg = pmsg.replace("$$", "\n");
		//������Ϣ
		textArea.append(pmsg);
	}

	/**
	 * ���÷�������������˺�
	*/
	public void setSAccount(String account2) {
		this.account = account2;
		//ָ���������˺�
		textField.setText(account2);
	}

	public void setRAccount(String receiveAcc2) {
		this.receiveAcc = receiveAcc2;
		//����¼�û��ĺ�����Ϊ������
		textField_1.setText(receiveAcc2);
	}
}
