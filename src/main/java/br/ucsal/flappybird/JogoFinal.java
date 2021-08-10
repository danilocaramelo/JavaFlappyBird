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
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.ucsal.flappybird.element.Tmp;
import br.ucsal.flappybird.element.DoublePipes;
import br.ucsal.flappybird.element.Flappy;

public class JogoFinal extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int screenH = 700;
	private int spaceBetweenPipes = 150;
	private int size = 70;
	private ArrayList<DoublePipes> pipes;
	private Flappy flappy;
	private DoublePipes pairPipe1;
	private DoublePipes pairPipe2;
	private DoublePipes pairPipe3;

	private JButton botao;

	Menu Fmenu = new Menu();
	Tmp tmp = new Tmp();
	Thread th_tmp;

	private boolean gameover = false;
	private int points = 0;

	Timer timer;

	public JogoFinal() {
		this.add(new Label());
		setBackground(Color.decode("#018695"));
		this.setLayout(null);//Tecla Space
		botao = new JButton("VOA"); //Tecla Space
		this.add(botao);
		Fmenu.setPanel(this);
		
		this.start();
		
		th_tmp = new Thread(tmp);

		botao.addActionListener(this);
		timer = new Timer(100, this);
		timer.start();
	}

	public void start() {
		pipes = new ArrayList<DoublePipes>();
		flappy = new Flappy(60, 280, size, size);
		points = 0;

		pairPipe1 = new DoublePipes(600, 745, screenH, spaceBetweenPipes);
		pairPipe2 = new DoublePipes(1200, 1345, screenH, spaceBetweenPipes);
		pairPipe3 = new DoublePipes(1800, 1945, screenH, spaceBetweenPipes);

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
		setDoubleBuffered(true);

		Font F = new Font ("Courier New", 1, 17);
		g2d.setColor(Color.WHITE);
		g2d.setFont(F);
		
		g2d.drawImage(flappy.getImagem(), flappy.getX(), flappy.getY(), 
				flappy.getW(), flappy.getH(), null);

		for (DoublePipes pairPipes : pipes) {
			pairPipes.desenho(g2d);
		}

		//debugger(g2d);
		this.Fmenu.desenhar(g2d, gameover);
		drawPoint(g2d);
		clock(g2d);
		

		Toolkit.getDefaultToolkit().sync();
	}
	
	private void clock(Graphics g2d) {
		if (!tmp.isInit()) {
			tmp.setInit(true);
			th_tmp.start(); //Inicia a Thread
		} else {
			if(tmp.isTick()) {
				Font q = new Font ("Courier New", 1, 30);
				g2d.setColor(Color.WHITE);
				g2d.setFont(q);
				g2d.drawString(LocalDateTime.now().getHour()+":"+
				LocalDateTime.now().getMinute()+":"+
				LocalDateTime.now().getSecond(), 0, 20);
			}
		}
	}
	
	private void drawPoint(Graphics g2d) {
		Font F = new Font ("Courier New", 1, 100);
		g2d.setColor(Color.WHITE);
		g2d.setFont(F);
		g2d.drawString(points+"", 560, 260);
	}

	private void debugger(Graphics g2d) {
		g2d.drawRect(flappy.getX(), flappy.getY(), flappy.getW(), flappy.getH()); //Debug
		g2d.drawString("Flappy: "+flappy.getX()+" | "+flappy.getY(), 0, 160); //Debug

		int i = 1, s = 20;
		for (DoublePipes pairPipes : pipes) {
			g2d.drawString("Coluna Bottom"+i+": "+pairPipes.getBottom().getX()+" | "+pairPipes.getBottom().getY(), 0, s);
			s += 20;
			g2d.drawString("Coluna Top"+i+": "+pairPipes.getTop().getX()+" | "+pairPipes.getTop().getY(), 0, s);
			s += 20;
			i++;
		}
	}

	public void actionPerformed(ActionEvent e) {

		flappy.gravidade();
		checkCollisions();
		if (e.getSource() instanceof JButton) {
			JButton obj = (JButton) e.getSource();
			if (obj.getText() == "JOGAR") {
				gameover = false;
				this.start();
				timer.start();
			} else {
				flappy.voar();
			}
		}
		for (DoublePipes doublePipe : pipes) {
			if(doublePipe.getBottom().getX() < -290) {
				doublePipe.refresh(1555, 1700);
			}
			
			if (doublePipe.getBottom().getX() < 0 && doublePipe.getBottom().getX() >= -12) {
				points++;
			}
		}
		pairPipe1.run();
		pairPipe2.run();
		pairPipe3.run();
		this.updateUI();

	}

	public void checkCollisions() {
		Rectangle flappyBounds = flappy.getBounds();
		
		for (DoublePipes doublePipe : pipes) {
			Rectangle bottom = doublePipe.getBottom().getBounds();
			Rectangle top = doublePipe.getTop().getBounds();
			if(flappyBounds.intersects(top) || flappyBounds.intersects(bottom)) {
				gameover = true;
				timer.stop();
				break;
			}
		}
	}
}
