package com.niit.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 给添加好友界面添加背景图片
 */
@SuppressWarnings("serial")
public class AddFriendPanel extends JPanel {
	/**
	 * 绘制组件的方法
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//图片路径
		ImageIcon icon = new ImageIcon(AddFriendPanel.class.getResource("addfriend.jpg"));
		Image img= icon.getImage();//得到图片
		//绘制图片
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
}