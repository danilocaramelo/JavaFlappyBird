package br.ucsal.flappybird.element;

public class Flappy extends Element {
	
	public Flappy(int x, int y, int w, int h) {
		super(x, y, w, h, "/bird.png");
	}

	public void voar() {
		this.y = y - 40;
		this.setImagem("/birdUp.png");
	}
	
	public void gravidade() {
		this.y = y + 7;
		this.setImagem("/bird.png");
	}
}
