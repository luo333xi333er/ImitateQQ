package com.niit.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ��Ⱥ�Ľ�����ӱ���ͼƬ
 */
@SuppressWarnings("serial")
public class ChatPanel extends JPanel {
	/**
	 * ��������ķ���
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ͼƬ·��
		ImageIcon icon = new ImageIcon(ChatPanel.class.getResource("chat.jpg"));
		Image img= icon.getImage();//�õ�ͼƬ
		//����ͼƬ
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
}