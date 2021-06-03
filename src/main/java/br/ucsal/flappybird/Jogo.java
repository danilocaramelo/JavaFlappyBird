package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Jogo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Jogo() {
		this.add(new Label());
		setBackground(Color.decode("#018695"));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
	}

	private void desenhar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		ImageIcon i = new ImageIcon(getClass().getResource("/bird.png"));
		ImageIcon ii = new ImageIcon(getClass().getResource("/pipe2.png"));
		Image bird = i.getImage();
		Image pipe = ii.getImage();
		Dimension size = getSize();
		int w = (int) size.getWidth();
		int h = (int) size.getHeight();
		
		double rotationRequired = Math.toRadians (180);
		AffineTransform a = AffineTransform.getRotateInstance(rotationRequired, 200, 400);
		Graphics2D gBack = g2d;
		gBack.setTransform(a);
		gBack.drawImage(pipe, 200, 400, null);
		
		g2d.drawImage(bird, 60,280,90,90,null);
//		g2d.drawImage(pipe, 400, (h - 500), 130, 500, null);
		
	}
}
