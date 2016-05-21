package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.niit.client.StartClient;
import com.niit.image.SelfMsgPanel;

import javax.swing.SwingConstants;
/**
 * ���ڵ�¼����
 */
@SuppressWarnings("serial")
public class LoadingFrame extends JFrame {
	//�������
	private JPanel contentPane;
	//��¼�˺��ı���
	private JTextField textField;
	//������
	private JProgressBar progressBar;
	//ȡ����ť
	private JButton button;
	//��ʱ��
	private Timer timer;
	//�˺�
//	private String account;
	private StartClient startClient;

	
	/**
	 * Create the frame.
	 */
	public LoadingFrame(StartClient startClient,String account) { //��һ��account
		this.startClient = startClient;
		//�������
		setLocationRelativeTo(null);
		//������ɫ
		setBackground(new Color(224, 255, 255));
		//����������ͼ��
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadingFrame.class.getResource("/com/niit/ui/loginframe.jpg")));
		//���ñ���
		setTitle("\u6B63\u5728\u767B\u5F55\u4E2D...");
		//����λ�úʹ�С
		setBounds(100, 100, 400, 300);
		//ʵ�������
		contentPane = new JPanel();
		//���ñ���ͼƬ
		contentPane = new SelfMsgPanel();
		//��������ñ�����ɫ
		contentPane.setBackground(new Color(224, 255, 255));
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//�貼��Ϊnull
		contentPane.setLayout(null);
		
		//��¼�˺��ı���
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		
		//����λ�úʹ�С
		textField.setBounds(142, 158, 99, 21);
		//���ı�����ӵ������
		contentPane.add(textField);
		//������Ϊ10
		textField.setColumns(10);
		
		//ʵ����������
		progressBar = new JProgressBar();
		//���ñ�����ɫ
		progressBar.setBackground(new Color(255, 192, 203));
		//����λ�úʹ�С
		progressBar.setBounds(10, 189, 364, 31);
		//����������ӵ����������
		contentPane.add(progressBar);
		
		//ʵ����ȡ����ť
		button = new JButton("\u53D6\u6D88");
		//����λ�úʹ�С
		button.setBounds(142, 231, 99, 21);
		//��ȡ����ť��ӵ����������
		contentPane.add(button);
		//��ȡ����ť����¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				//�Լ��ر�
				LoadingFrame.this.dispose();
				//���ص���¼����
				LoadingFrame.this.startClient.getLoginFrame().setVisible(true);
			}
		});
		
		//ͼ��
		JLabel lblNewLabel = new JLabel("New label");
		//��lblNewLabel�����ͼƬ
		lblNewLabel.setIcon(new ImageIcon(LoadingFrame.class.getResource("/com/niit/ui/loadframe.jpg")));
		//����λ�úʹ�С
		lblNewLabel.setBounds(92, 20, 195, 128);
		//��lblNewLabel��ӵ����������
		contentPane.add(lblNewLabel);
		//�������
		setLocationRelativeTo(null);
		//����������ʾ����ǰ��
		setAlwaysOnTop(true);
	}
	

	/**
	 * ������  ��ʾ�û���¼����
	 */
	public void start(){
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = progressBar.getValue();
				value++;
				progressBar.setValue(value);
				if(value >= 50){
					timer.stop();
					//��ʾFriendListFrame
					LoadingFrame.this.startClient.getFriendListFrame().setVisible(true);
					//���ش��ڹر�
					LoadingFrame.this.setVisible(false);
				}
			}
		});
		//������ʱ��
		timer.start();
	}
	
	/**
	 * ���õ�ǰ�û�
	 * @param username
	*/
	public void setAccount(String account) {
		//��ʾaccount��Ϣ
		textField.setText(account);
	}
}
