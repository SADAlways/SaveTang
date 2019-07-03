package game.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import game.attackelements.Bullet;
import game.ta.Tower;

import java.util.Vector;

public class Modle implements Const{
	String name;
	public boolean canAttack;
	public Tower belong;
	public ActionType state;
	Map<String,BufferedImage> hash;
	BufferedImage img;
	static Map<String,Map> list = new HashMap<>();
	BufferedImage[] playings = {};

//	static enum ActionType{
//		STAND,MOVE,ATTACK,DEAD,MOVE_LEFT,MOVE_RIGHT,MOVE_UP,MOVE_DOWN;
//	}
	public Modle(String directoryName,final Tower belong) {
		this.belong = belong;
		name = directoryName;
		if(!list.containsKey(name))
			list.put(name, Images.readImageAll(name));
		hash = list.get(name);
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						sleep(1);
						if(playings.length==0)continue;
						if(state.name().indexOf("ATTACK")>=0)
						sleep(belong.attackSpeed/playings.length);
						else sleep(1000/playings.length);
						if(state.name().indexOf("ATTACK")>=0 && playIndex%playings.length==playings.length-5) {
							belong.shoot();
						}
						img = playings[playIndex++%playings.length];
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		
	}
	private int playIndex;
	public void play(ActionType at) {
		if(state==at)return;
		playIndex=0;
		state=at;
		String s = at.name().toLowerCase();
		playings = new BufferedImage[hash.entrySet().size()];
		int imageIndex=0;
		for (Entry e : hash.entrySet()) {
//			System.out.println("Modle: play");
			String se = (String) e.getKey();
//			System.out.println(se);
			if(se.indexOf("_"+s+"_")>=0) {
//				System.out.println("_._");
				String[] ss = se.split("_");
				
				int num = Integer.parseInt(ss[ss.length-1]);
				playings[num]=(BufferedImage) e.getValue();
				imageIndex++;
			}
		}
		playings=Arrays.copyOf(playings, imageIndex);
	}
	
	public BufferedImage getImage() {
		return img;
	}

	public void remove() {
		list.remove(name);
	}
	
}
