package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ucsal.flappybird.element.DoublePipe;
import br.ucsal.flappybird.element.Flappy;

public class JogoFinal extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int screenH = 700;
	private int spaceBetweenPipes = 150;
	private ArrayList<DoublePipe> pipes = new ArrayList<DoublePipe>();
	private Flappy flappy = new Flappy(60, 280, 90, 90);
	private DoublePipe pairPipe1 = new DoublePipe(600, 745, screenH, spaceBetweenPipes);
	private DoublePipe pairPipe2 = new DoublePipe(1200, 1345, screenH, spaceBetweenPipes);
	private DoublePipe pairPipe3 = new DoublePipe(1800, 1945, screenH, spaceBetweenPipes);
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
		pipes.add(pairPipe1);
		pipes.add(pairPipe2);
		pipes.add(pairPipe3);
		for (DoublePipe pairPipes : pipes) {
			pairPipes.desenho(g2d);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void actionPerformed(ActionEvent e) {
		flappy.gravidade();
		checkCollisions();
		if (e.getSource() instanceof JButton) {
			flappy.voar();
		}
		for (DoublePipe doublePipe : pipes) {
			if(doublePipe.getBottom().getX() < -290) {
				doublePipe.refresh(1555, 1700);
			}
		}
		pairPipe1.run();
		pairPipe2.run();
		pairPipe3.run();
		this.updateUI();
	}
	
	public void checkCollisions() {
		Rectangle flappyBounds = flappy.getBounds();
		for (DoublePipe doublePipe : pipes) {
			Rectangle bottom = doublePipe.getBottom().getBounds();
//			Rectangle top = doublePipe.getTop().getBounds();
			if(flappyBounds.intersects(doublePipe.getBottom().getBounds())) {
				System.out.println("flappy" + flappyBounds.x + " " + flappyBounds.y + " " + flappyBounds.width + " " + flappyBounds.height);
				System.out.println("bottom" + bottom.x + " " + bottom.y + " " + bottom.width + " " + bottom.height);
//				System.out.println("top" + top.x + " " + top.y + " " + top.width + " " + top.height);
				timer.stop();
			}
		}
	}
}
