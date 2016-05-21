package com.niit.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ��������Ϣ������ӱ���ͼƬ
 */
@SuppressWarnings("serial")
public class SenderPanel extends JPanel {
	/**
	 * ��������ķ���
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ͼƬ·��
		ImageIcon icon = new ImageIcon(SenderPanel.class.getResource("send.jpg"));
		Image img= icon.getImage();//�õ�ͼƬ
		//����ͼƬ
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
}