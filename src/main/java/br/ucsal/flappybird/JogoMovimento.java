package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ucsal.flappybird.element.Flappy;

public class JogoMovimento extends JPanel implements ActionListener{
	
	private Flappy flappy = new Flappy(60, 280, 90, 90);
//	private int flappyX = 60;
//	private int flappyY = 280;
	private int pipeUpX = 930;
	private int pipeUpY = 280;
	private int pipeDownX = -700;
	private int pipeDownY = 500;
	Timer timer;

	private static final long serialVersionUID = 1L;

	public JogoMovimento() {
		this.add(new Label());
		setBackground(Color.decode("#018695"));
		JButton botao = new JButton("VOA");
		this.add(botao);
		botao.addActionListener(this);
		timer = new Timer(100, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
	}

	private void desenhar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
//		ImageIcon i = new ImageIcon(getClass().getResource("/bird.png"));
		ImageIcon ii = new ImageIcon(getClass().getResource("/pipe2.png"));
//		Image bird = i.getImage();
		Image pipe = ii.getImage();
		Dimension size = getSize();
		int w = (int) size.getWidth();
		int h = (int) size.getHeight();
		double rotationTo180 = Math.toRadians (180);
		double rotationTo45 = Math.toRadians (45);
		
		AffineTransform rotate180 = AffineTransform.getRotateInstance(rotationTo180, 200, 400);
		AffineTransform rotate45 = AffineTransform.getRotateInstance(rotationTo45, 200, 400);
		AffineTransform rotate0 = g2d.getTransform();
		
		g2d.setTransform(rotate180);
		g2d.drawImage(pipe, pipeDownX, pipeDownY, w/7, h, null);
		
		g2d.setTransform(rotate0);
		g2d.drawImage(pipe, pipeUpX, pipeUpY, w/7, h, null);
		System.out.println(h);
		g2d.setTransform(rotate0);
		g2d.drawImage(flappy.getImagem(), flappy.getX(), flappy.getY(), flappy.getW(), flappy.getH(), null);
//		g2d.drawImage(pipe, 400, (h - 500), 130, 500, null);
		Toolkit.getDefaultToolkit().sync();
		
	}

	public void actionPerformed(ActionEvent e) {
//		flappyY = flappyY + 5;
		flappy.gravidade();
		pipeDownX = pipeDownX + 5;
		pipeUpX = pipeUpX -5;
		if (pipeDownX > 0) pipeDownX = -700;
		if (pipeUpX < 0) pipeUpX = 930;
		if (e.getSource() instanceof JButton) {
			flappy.voar();
			//flappyY = flappyY - 30;
			this.updateUI();
		}
		this.updateUI();
	}
}
