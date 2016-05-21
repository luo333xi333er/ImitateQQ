package com.niit.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.niit.client.StartClient;
import com.niit.entity.LoginUser;
import com.niit.image.RegestPanel;
import com.niit.util.ReadAndWrite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
/**
 * �û�ע�����
 */
@SuppressWarnings("serial")
public class RegestFrame extends JFrame implements ActionListener {
	//�������
	private JPanel contentPane;
	//�˺��ı���
	private JTextField accTextField;
	//�ǳ��ı���
	private JTextField nameTextField;
	//�����ı���
	private JTextField pwdTextField;
	//�����ı���
	private JTextField ageTextField;
	//ע�ᰴť
	private JButton button;
	//���ð�ť
	private JButton button_1;
	
	//��
	private JRadioButton boyRadioButton;
	//Ů
	private JRadioButton girlRadioButton;
	//��ѡ��
	private JComboBox comboBox;
	//��ȡ��д��
	private ReadAndWrite raw;
	private StartClient startClient;
	private String account;
	
	//���췽��
	public RegestFrame(StartClient startClient) {
		this.startClient = startClient;
		setResizable(false);
		//ʵ����
		raw = new ReadAndWrite();
		//����init����
		init();
	}
	
	
	/**
	 * Create the frame.
	 */
	public void init() {
		//����ͼƬ
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegestFrame.class.getResource("/com/niit/ui/regest.jpg")));
		//����
		setTitle("MiMi\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����λ�úʹ�С
		setBounds(100, 100, 329, 338);
		//���ھ���
		setLocationRelativeTo(null);
		//ʵ�������
		contentPane = new JPanel();
		//�������ӱ���ͼƬ
		contentPane = new RegestPanel();
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//���������Ϊ������������
		setContentPane(contentPane);
		//���ò���Ϊnull
		contentPane.setLayout(null);
		
		//ʵ�����û��ǳ�
		JLabel nameLable = new JLabel("\u6635\u79F0\uFF1A");
		//����ˮƽ����
		nameLable.setHorizontalAlignment(SwingConstants.CENTER);
		//����λ�úʹ�С
		nameLable.setBounds(24, 61, 71, 24);
		//��lable���������
		contentPane.add(nameLable);
		
		//����
		JLabel pwdLable = new JLabel("\u5BC6\u7801\uFF1A");
		pwdLable.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLable.setBounds(24, 95, 71, 24);
		contentPane.add(pwdLable);
		
		//�Ա�
		JLabel sexLable = new JLabel("\u6027\u522B\uFF1A");
		sexLable.setHorizontalAlignment(SwingConstants.CENTER);
		sexLable.setBounds(24, 129, 71, 24);
		contentPane.add(sexLable);
		
		//����
		JLabel ageLable = new JLabel("\u5E74\u9F84\uFF1A");
		ageLable.setHorizontalAlignment(SwingConstants.CENTER);
		ageLable.setBounds(24, 163, 71, 24);
		contentPane.add(ageLable);
		
		//ʵ��������
		JLabel cityLable = new JLabel("\u57CE\u5E02\uFF1A");
		cityLable.setHorizontalAlignment(SwingConstants.CENTER);
		cityLable.setBounds(24, 197, 71, 24);
		contentPane.add(cityLable);
		
		//�˺��ı���
		accTextField = new JTextField();
		accTextField.setBounds(82, 27, 187, 24);
		contentPane.add(accTextField);
		accTextField.setColumns(10);
		
		//�ǳ��ı���
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(82, 61, 187, 24);
		contentPane.add(nameTextField);
		
		//�����ı���
		pwdTextField = new JTextField();
		pwdTextField.setColumns(10);
		pwdTextField.setBounds(82, 95, 187, 24);
		contentPane.add(pwdTextField);
		
		//�����ı���
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(82, 163, 187, 24);
		contentPane.add(ageTextField);
		
		//�˺�
		JLabel accLable = new JLabel("\u8D26\u53F7\uFF1A");
		//����ˮƽ����
		accLable.setHorizontalAlignment(SwingConstants.CENTER);
		accLable.setBounds(24, 27, 71, 24);
		contentPane.add(accLable);
		
		//��ѡ��
		boyRadioButton = new JRadioButton("\u7537");
		boyRadioButton.setBounds(114, 127, 46, 28);
		//���ñ���Ϊ͸��
		boyRadioButton.setOpaque(false);
		contentPane.add(boyRadioButton);
		
		girlRadioButton = new JRadioButton("\u5973");
		girlRadioButton.setBounds(188, 125, 46, 28);
		//���ñ���Ϊ͸��
		girlRadioButton.setOpaque(false);
		contentPane.add(girlRadioButton);
		
		//ʵ�������������б�
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u897F\u5B89", "\u5317\u4EAC", "\u5929\u6D25", "\u5357\u4EAC", "\u91CD\u5E86", "\u4E0A\u6D77"}));
		comboBox.setBounds(82, 197, 187, 21);
		contentPane.add(comboBox);
		
		//ע�ᰴť
		button = new JButton("\u6CE8\u518C");
		//��ע�ᰴť����¼�
		button.addActionListener(this);
		button.setBounds(50, 264, 93, 23);
		contentPane.add(button);
		
		//���ð�ť
		button_1 = new JButton("\u91CD\u7F6E");
		//�����ð�ť����¼�
		button_1.addActionListener(this);
		button_1.setBounds(176, 264, 93, 23);
		contentPane.add(button_1);
	}
	
	/**
	 * ��ע�ᰴť�����ð�ť����¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) { //ע�ᰴť
			LoginUser user = new LoginUser();//ʵ�����û���Ϣ
			//�ж�
			List<LoginUser> userList = raw.readAll();
			for (LoginUser loginUser : userList) {
				//ע���˺źͼ����е��û��˺��Ƿ���ͬ�������ͬ��ע��ʧ��
				if(accTextField.getText().equals(loginUser.getAccount())) {
					JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�������ע��!");
					break;
				} 
			}
			//�ǳ� �˺� ���� �Ա� ���� ����
			user.setName(nameTextField.getText());
			user.setAccount(accTextField.getText());
			user.setPassword(pwdTextField.getText());
			if (boyRadioButton.isSelected()) {
				user.setSex(boyRadioButton.getText());
			} else {
				user.setSex(girlRadioButton.getText());
			}
			user.setAge(Integer.parseInt(ageTextField.getText()));
			user.setCity(comboBox.getSelectedItem().toString());
			//����Ϣ��ӵ�����
			userList.add(user);
			//д���ļ�
			raw.writeAll();
			//��ȡ����
			raw.readAll();
			JOptionPane.showMessageDialog(null, "ע��ɹ�!");
			LoginFrame loginFrame = new LoginFrame(startClient, account);
			loginFrame.setVisible(true);
			//�Լ�����
			RegestFrame.this.setVisible(false);
		} else if(e.getSource() == button_1) {//���ð�ť
			accTextField.setText("");
			nameTextField.setText("");
			pwdTextField.setText("");
			ageTextField.setText("");
		}
	}
}
