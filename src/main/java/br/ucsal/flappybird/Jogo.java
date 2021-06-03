package br.ucsal.flappybird;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.Random;
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
		double rotationTo180 = Math.toRadians (180);
		double rotationTo45 = Math.toRadians (45);
		
		int topPipeHeight = 0;
		int bottomPipeHeight = 0;
		int sum = 0;
				
		do {
			topPipeHeight = (int) (Math.random() * (h - 0)) + 0;
			bottomPipeHeight = (int) (Math.random() * (h - 0)) + 0;
			sum = (h - topPipeHeight) + (h - bottomPipeHeight);
			
		} while ((h - sum) > 284 || (h -sum) < 190);
		
		
		AffineTransform rotate180 = AffineTransform.getRotateInstance(rotationTo180, 200, 400);
		AffineTransform rotate45 = AffineTransform.getRotateInstance(rotationTo45, 200, 400);
		AffineTransform rotate0 = g2d.getTransform();
		
		g2d.setTransform(rotate180);
		g2d.drawImage(pipe, -700, (topPipeHeight), w/8, h, null);
		
		g2d.setTransform(rotate0);
		g2d.drawImage(pipe, 950, (bottomPipeHeight), w/8, h, null);
		g2d.drawImage(bird, 60,280,90,90,null);
		
	}
}
