package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ucsal.flappybird.element.Flappy;
import br.ucsal.flappybird.element.Pipe;

public class JogoFinal extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int screenH = 700;
	private int spaceBetweenPipes = 150;
	private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	private Flappy flappy = new Flappy(60, 280, 90, 90);
	private Pipe bottomPipe1 = new Pipe(600, Pipe.randomY(screenH - spaceBetweenPipes), 145, screenH);
	private Pipe topPipe1 = new Pipe(745, (this.bottomPipe1.getY() - spaceBetweenPipes), 145, screenH);
	private Pipe bottomPipe2 = new Pipe(1200, Pipe.randomY(screenH - spaceBetweenPipes), 145, screenH);
	private Pipe topPipe2 = new Pipe(1345, (this.bottomPipe2.getY() - spaceBetweenPipes), 145, screenH);
	private Pipe bottomPipe3 = new Pipe(1800, Pipe.randomY(screenH - spaceBetweenPipes), 145, screenH);
	private Pipe topPipe3 = new Pipe(1945, (this.bottomPipe3.getY() - spaceBetweenPipes), 145, screenH);
	Timer timer;

	public JogoFinal() {
		this.add(new Label());
		setBackground(Color.decode("#018695"));
		JButton botao = new JButton("VOA");
		//		botao.setVisible(true);
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
		pipes.add(bottomPipe1);
		pipes.add(topPipe1);
		pipes.add(bottomPipe2);
		pipes.add(topPipe2);
		pipes.add(bottomPipe3);
		pipes.add(topPipe3);
		int count = 0;
		AffineTransform rotate0 = g2d.getTransform();
		for (Iterator<Pipe> iterator = pipes.iterator(); iterator.hasNext();) {
			Pipe pipe = (Pipe) iterator.next();
			if (count%2 == 1) {
				g2d.setTransform(pipe.rotate());
			} else {
				g2d.setTransform(rotate0);
			}
			g2d.drawImage(pipe.getImagem(), pipe.getX(), pipe.getY(),
					pipe.getW(), pipe.getH(), null);
			count++;
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void actionPerformed(ActionEvent e) {
		flappy.gravidade();
		if (e.getSource() instanceof JButton) {
			flappy.voar();
		}
		int count = 0;
		//TODO reandomizar o Y dos pipers novamente.
		for (Iterator<Pipe> iterator = pipes.iterator(); iterator.hasNext();) {
			Pipe pipe = (Pipe) iterator.next();
			if(count%2 == 0) {
				if (pipe.getX() < -290) {
					pipe.setX(1555);
				}
			} else {
				if (pipe.getX() < -145) {
					pipe.setX(1700);
			}
			}
			count++;
		}
		bottomPipe1.run();
		topPipe1.run();
		bottomPipe2.run();
		topPipe2.run();
		bottomPipe3.run();
		topPipe3.run();
		this.updateUI();
	}
}
