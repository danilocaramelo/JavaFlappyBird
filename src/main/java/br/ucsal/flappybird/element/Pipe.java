package br.ucsal.flappybird.element;

import java.awt.geom.AffineTransform;
import java.util.Random;

public class Pipe extends Element{

	public Pipe(int x, int y, int w, int h) {
		super(x, y, w, h, "/pipe2.png");
	}
	
	public AffineTransform rotate() {
		double rotationTo180 = Math.toRadians (180);
		AffineTransform rotate180 = AffineTransform.getRotateInstance(rotationTo180, x, y);
		return rotate180;
	}
	
	public static int randomY(int limit) {
		int y;
		Random gerador = new Random();
		//TODO gerar número automático
		y = gerador.nextInt(600);
		return y;
	}
	
	public void run() {
		this.x = x -10;
	}
}
