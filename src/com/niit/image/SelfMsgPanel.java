package com.niit.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ���������Ͻ�����ӱ���ͼƬ
 */
@SuppressWarnings("serial")
public class SelfMsgPanel extends JPanel {
	 //��������ķ���
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ͼƬ·��
		ImageIcon icon = new ImageIcon(SelfMsgPanel.class.getResource("selfMessage.jpg"));
		Image img= icon.getImage();//�õ�ͼƬ
		//����ͼƬ
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
}
