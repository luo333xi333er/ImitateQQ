package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.niit.client.StartClient;
import com.niit.image.SenderPanel;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ������Ϣ����
 */

@SuppressWarnings("serial")
public class SenderFrame extends JFrame implements ActionListener{

	//�������
	private JPanel contentPane;
	//������
	private JTextField textField;
	//������
	private JTextField textField_1;
	//��������
	private JTextArea textArea;
	//���Ͱ�ť
	private JButton sendbutton;
	//�رհ�ť
	private JButton closebutton;
	
	private StartClient startClient;
	private String account;
	private String receiveAcc;

	/**
	 * Create the frame.
	 */
	public SenderFrame(StartClient startClient, String account, String receiveAcc) {
		this.startClient = startClient;
		//���ô��ڲ��ɱ�
		setResizable(false);
		//����ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage(SenderFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//����
		setTitle("\u53D1\u9001\u6846");
		setBounds(100, 100, 440, 300);
		//���ñ���ͼƬ
		contentPane = new SenderPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//������
		JLabel lblNewLabel = new JLabel("\u63A5 \u6536 \u8005:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 57, 75, 25);
		contentPane.add(lblNewLabel);
		
		//������
		JLabel label_1 = new JLabel("\u53D1 \u9001 \u8005:");
		label_1.setForeground(Color.RED);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(24, 22, 75, 25);
		contentPane.add(label_1);

		//��������
		JLabel label = new JLabel("\u53D1\u9001\u5185\u5BB9:");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(24, 92, 75, 25);
		contentPane.add(label);
		
		//�������ı���
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 59, 261, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//����¼�û��ĺ�����Ϊ������
		textField.setText(receiveAcc);
		
		//�������ı���
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(100, 24, 261, 21);
		contentPane.add(textField_1);
		//�����ڵ�¼���˺���Ϊ������
		textField_1.setText(account);
		
		//���������ı���
		textArea = new JTextArea();
		textArea.setBounds(100, 92, 261, 114);
		contentPane.add(textArea);
		
		//���Ͱ�ť
		sendbutton = new JButton("\u53D1\u9001");
		sendbutton.setBounds(122, 229, 93, 23);
		contentPane.add(sendbutton);
		//�����Ͱ�ť����¼�
		sendbutton.addActionListener(this);
		
		//�رհ�ť
		closebutton = new JButton("\u5173\u95ED");
		closebutton.setBounds(247, 229, 93, 23);
		contentPane.add(closebutton);
		//���رհ�ť����¼�
		closebutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.sendbutton) { //���Ͱ�ť
			//ʱ��
			String time = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss").format(new Date());
			//ȡ��������������ߵ��˺�
			String account = textField_1.getText();
			String receiveAcc = textField.getText();
			//ȡ��Ҫ���͵���Ϣ
			String sendMsg = "[" + time + "]$$" + account + "��" + receiveAcc + "˵:" + textArea.getText() + "$$";
			//ͨ��client����
			SenderFrame.this.startClient.sendPMessage(sendMsg);
			SenderFrame.this.startClient.getReceiverFrame().setVisible(true);
			SenderFrame.this.startClient.getReceiverFrame().setSAccount(account);
			SenderFrame.this.startClient.getReceiverFrame().setRAccount(receiveAcc);
			SenderFrame.this.setVisible(false);
		} else if(e.getSource() == this.closebutton) { //�رհ�ť
			SenderFrame.this.setVisible(false);
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
		//�����ڵ�¼���˺���Ϊ������
		textField_1.setText(account2);
	}

	public void setRAccount(String receiveAcc2) {
		this.receiveAcc = receiveAcc2;
		//����¼�û��ĺ�����Ϊ������
		textField.setText(receiveAcc2);
	}
}
