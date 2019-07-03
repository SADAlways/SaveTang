package game.world;

import game.guaiwu.Monster;

public class GC implements Const{
	public static void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(3000);
					for (Monster m:monsters) {
						if(m.getLifeState()==REMOVE)m.remove();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}.start();
	}
}
