package br.ucsal.flappybird.element;

import java.awt.Graphics2D;

public class DoublePipe {
	
	private Pipe bottom;
	private Pipe top;
	private int screenH;
	private int spaceBetween;
	
	public DoublePipe(int xBottom, int xTop, int screenH, int spaceBetween) {
		this.screenH = screenH;
		this.spaceBetween = spaceBetween;
		this.bottom = new Pipe(xBottom, Pipe.randomY(screenH - spaceBetween), 145, screenH);
		this.top = new Pipe(xTop-spaceBetween, (this.bottom.getY() - spaceBetween), 145, screenH);
		
	}
	
	public void refresh(int xBottom, int xTop) {
		this.bottom.setX(xBottom);
		this.top.setX(xTop-spaceBetween);
		this.bottom.setY(Pipe.randomY(screenH - spaceBetween));
		this.top.setY(this.bottom.getY() - spaceBetween);
	}
	
	public void desenho(Graphics2D g2d) {
		
		g2d.drawImage(bottom.getImagem(), bottom.getX(), bottom.getY(),
				bottom.getW(), bottom.getH(), null);
		
		g2d.drawRect(bottom.getX()+spaceBetween, top.getH(), 50, spaceBetween);

		this.top.setH(this.bottom.getY()-spaceBetween);
		g2d.drawImage(top.getImagem(), top.rotate(spaceBetween), null);
		
		debugger(g2d);
	}
	
	private void debugger(Graphics2D g2d) {
		g2d.drawRect(bottom.getX(), bottom.getY(), bottom.getW(), bottom.getH()); //Debug
		g2d.drawRect(top.getX(), top.getY(), top.getW(), top.getH()); //Debug
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
