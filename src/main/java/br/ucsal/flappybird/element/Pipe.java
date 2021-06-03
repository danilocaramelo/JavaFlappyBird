package br.ucsal.flappybird.element;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Pipe extends Element{
	
	

	public Pipe(int x, int y, int w, int h) {
		super(x, y, w, h, "/pipe2.png");
	}

//	public static int randomY(int screenH) {
//		int y;
//		y = (int) (Math.random() * (screenH - 0)) + 0;
//		return  y;
//	}
	
	public AffineTransform rotate() {
		double rotationTo180 = Math.toRadians (180);
		AffineTransform rotate180 = AffineTransform.getRotateInstance(rotationTo180, x, y);
		return rotate180;
	}
	
//	public int sortY(int randomNumber1, int randomNumber2, int h) {
//		int sum = 0;
//		do {
//			sum = (h - randomNumber1) + (h - randomNumber2);
//		} while ((h - sum) > 284 || (h -sum) < 190);
//		this.setY(randomNumber2);
//		return randomNumber1;
//	}
	
	public static int[] validatePipeSize(int h) {
		int topRandomY;
		int bottomRandomY;
		int sum; 
		do {
			topRandomY = (int) (Math.random() * (h - 0)) + 0;
			bottomRandomY = (int) (Math.random() * (h - 0)) + 0;
			sum = (h - topRandomY) + (h - bottomRandomY);
		} while ((h - sum) > 284 || (h -sum) < 190);
		int[] randomY = {bottomRandomY, topRandomY};
		return randomY;
	}	
}
