package br.ucsal.flappybird.element;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class DoublePipe {
	
	private Pipe bottom;
	private Pipe top;
	private int screenH;
	private int spaceBetween;
	
	public DoublePipe(int xBottom, int xTop, int screenH, int spaceBetween) {
		this.screenH = screenH;
		this.spaceBetween = spaceBetween;
		this.bottom = new Pipe(xBottom, Pipe.randomY(screenH - spaceBetween), 145, screenH);
		this.top = new Pipe(xTop, (this.bottom.getY() - spaceBetween), 145, screenH);
	}
	
	public void refresh(int xBottom, int xTop) {
		this.bottom.setX(xBottom);
		this.top.setX(xTop);
		this.bottom.setY(Pipe.randomY(screenH - spaceBetween));
		this.top.setY(this.bottom.getY() - spaceBetween);
	}
	
	public void desenho(Graphics2D g2d) {
		AffineTransform rotate0 = g2d.getTransform();
		g2d.drawImage(bottom.getImagem(), bottom.getX(), bottom.getY(),
				bottom.getW(), bottom.getH(), null);
		g2d.setTransform(top.rotate());
		g2d.drawImage(top.getImagem(), top.getX(), top.getY(),
				top.getW(), top.getH(), null);
		g2d.setTransform(rotate0);
	}
	
	public void run() {
		bottom.run();
		top.run();
	}

	public Pipe getBottom() {
		return bottom;
	}

	public void setBottom(Pipe bottom) {
		this.bottom = bottom;
	}

	public Pipe getTop() {
		return top;
	}

	public void setTop(Pipe top) {
		this.top = top;
	}
}
