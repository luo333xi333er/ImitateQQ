package com.niit.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ��������Ϣ������ӱ���ͼƬ
 */
@SuppressWarnings("serial")
public class ReceiverPanel extends JPanel {
	/**
	 * ��������ķ���
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ͼƬ·��
		ImageIcon icon = new ImageIcon(ReceiverPanel.class.getResource("receive.jpg"));
		//�õ�ͼƬ
		Image img= icon.getImage();
		//����ͼƬ
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
}