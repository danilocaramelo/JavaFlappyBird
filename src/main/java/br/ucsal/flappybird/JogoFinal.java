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
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ucsal.flappybird.element.Flappy;
import br.ucsal.flappybird.element.Pipe;

public class JogoFinal extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int screenW = 1200;
	private int screenH = 700;
	private int spaceBetweenPipes = 100;
	private Flappy flappy = new Flappy(60, 280, 90, 90);
	private Pipe bottomPipe = new Pipe(600, Pipe.randomY(), 145, screenH);
	private Pipe topPipe = new Pipe(745, (this.bottomPipe.getY() - spaceBetweenPipes), 145, screenH);
	Timer timer;

	public JogoFinal() {
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

		g2d.drawImage(flappy.getImagem(), flappy.getX(), flappy.getY(), 
				flappy.getW(), flappy.getH(), null);
		g2d.drawImage(bottomPipe.getImagem(), bottomPipe.getX(), bottomPipe.getY(),
				bottomPipe.getW(), bottomPipe.getH(), null);
		AffineTransform rotate0 = g2d.getTransform();
		g2d.setTransform(topPipe.rotate());
		g2d.drawImage(topPipe.getImagem(), topPipe.getX(), topPipe.getY(),
				topPipe.getW(), topPipe.getH(), null);
		Toolkit.getDefaultToolkit().sync();
	}

	public void actionPerformed(ActionEvent e) {
		flappy.gravidade();
		if (e.getSource() instanceof JButton) {
			flappy.voar();
		}
		this.updateUI();
	}
}
