package br.ucsal.flappybird.element;

public class Tmp implements Runnable{

	private boolean init;
	private boolean tick;
	
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tick = false;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public boolean isTick() {
		return tick;
	}

	public void setTick(boolean tick) {
		this.tick = tick;
	}

}
