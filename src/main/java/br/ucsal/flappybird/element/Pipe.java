package br.ucsal.flappybird.element;

import java.awt.geom.AffineTransform;
import java.util.Random;

public class Pipe extends Element{

	public Pipe(int x, int y, int w, int h) {
		super(x, y, w, h, "/pipe2.png");
	}
	
	public AffineTransform rotate(int spaceBetween) {
		this.setY(0);
		AffineTransform at = AffineTransform.getTranslateInstance((x+145), h);
		at.scale(0.3, 0.3);
		at.rotate(Math.toRadians(180));
		
		return at;
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
