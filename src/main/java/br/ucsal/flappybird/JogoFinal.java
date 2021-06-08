package br.ucsal.flappybird;

import java.awt.Color;
import java.awt.Font;
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
	private ArrayList<DoublePipe> pipes;
	private Flappy flappy;
	private DoublePipe pairPipe1;
	private DoublePipe pairPipe2;
	private DoublePipe pairPipe3;
	
	private JButton botao;
	
	Menu Fmenu = new Menu();
	
	private boolean gameover = false;
	
	Timer timer;

	public JogoFinal() {
		this.add(new Label());
		setBackground(Color.decode("#018695"));
		botao = new JButton("VOA");
		this.add(botao);
		Fmenu.setPanel(this);
		
		start();
		
		botao.addActionListener(this);
		timer = new Timer(100, this);
		timer.start();
	}
	
	public void start() {
		pipes = new ArrayList<DoublePipe>();
		flappy = new Flappy(60, 280, 90, 90);
		
		pairPipe1 = new DoublePipe(600, 745, screenH, spaceBetweenPipes);
		pairPipe2 = new DoublePipe(1200, 1345, screenH, spaceBetweenPipes);
		pairPipe3 = new DoublePipe(1800, 1945, screenH, spaceBetweenPipes);
		
		pipes.add(pairPipe1);
		pipes.add(pairPipe2);
		pipes.add(pairPipe3);
		
		botao.requestFocus();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenhar(g);
		
	}
	
	private void desenhar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font F = new Font ("Courier New", 1, 17);
		g2d.setColor(Color.WHITE);
		g2d.setFont(F);
		
		g2d.drawImage(flappy.getImagem(), flappy.getX(), flappy.getY(), 
				flappy.getW(), flappy.getH(), null);
		
		for (DoublePipe pairPipes : pipes) {
			pairPipes.desenho(g2d);		
		}
		
		debugger(g2d);
		this.Fmenu.desenhar(g2d, gameover);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void debugger(Graphics g2d) {
		g2d.drawRect(flappy.getX(), flappy.getY(), flappy.getW(), flappy.getH()); //Debug
		g2d.drawString("Coluna Bottom1: "+pairPipe1.getBottom().getX()+" | "+pairPipe1.getBottom().getY(), 0, 20);
		g2d.drawString("Coluna Top1: "+pairPipe1.getTop().getX()+" | "+pairPipe1.getTop().getY(), 0, 40);
		g2d.drawString("Coluna Bottom2: "+pairPipe2.getBottom().getX()+" | "+pairPipe2.getBottom().getY(), 0, 60);
		g2d.drawString("Coluna Top2: "+pairPipe2.getTop().getX()+" | "+pairPipe2.getTop().getY(), 0, 80);
		g2d.drawString("Coluna Bottom3: "+pairPipe3.getBottom().getX()+" | "+pairPipe3.getBottom().getY(), 0, 100);
		g2d.drawString("Coluna Top3: "+pairPipe3.getTop().getX()+" | "+pairPipe3.getTop().getY(), 0, 120);
		g2d.drawString("Flappy: "+flappy.getX()+" | "+flappy.getY(), 0, 160);
	}

	public void actionPerformed(ActionEvent e) {
		
		flappy.gravidade();
		checkCollisions();
		if (e.getSource() instanceof JButton) {
			JButton obj = (JButton) e.getSource();
			if (obj.getText() == "JOGAR") {
				gameover = false;
				start();
			} else {
				flappy.voar();
			}
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
			Rectangle top = doublePipe.getTop().getBounds();
			if(flappyBounds.intersects(top) || flappyBounds.intersects(bottom)) {
				gameover = true;
				break;
			}
		}
		if (gameover) {
			//timer.stop();
		}
	}
}
