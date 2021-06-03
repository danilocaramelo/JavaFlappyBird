package br.ucsal.flappybird;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Flappy {
	
	private int x = 60;
	private int y = 280;
	private int w = 90;
	private int h = 90;
	private Image imagem;
	
	public Flappy() {
		this.imagem = this.carregaImagem("/bird.png");
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Image getImagem() {
		return imagem;
	}

	private Image carregaImagem(String local) {
		ImageIcon i = new ImageIcon(getClass().getResource(local));
		return i.getImage();
	}
	
	public void voar() {
		this.y = y - 30;
	}
	
	public void gravidade() {
		this.y = y + 5;
	}

}
