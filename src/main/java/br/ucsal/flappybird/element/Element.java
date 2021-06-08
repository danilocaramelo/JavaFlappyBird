package br.ucsal.flappybird.element;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Element {
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image imagem;
	
	public Element(int x, int y, int w, int h, String local) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.imagem = this.carregaImagem(local);
	}
	
	private Image carregaImagem(String local) {
		ImageIcon ii = new ImageIcon(getClass().getResource(local));
		return ii.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
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

	public void setImagem(String local) {
		this.imagem = this.carregaImagem(local);
	}
	
	

}
