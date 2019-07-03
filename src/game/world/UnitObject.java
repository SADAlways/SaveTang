package game.world;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import game.guaiwu.Monster;
/*
 * 单位画板
 */
public abstract class UnitObject extends JPanel implements Const{
	public String name;
	public String type;
	public Modle modle;
	protected BufferedImage img;
	public int x,y,width,height;//x y 宽高  范围  攻击力
	public Monster target;
	
	public boolean isRemove;
	public int range,moveSpeed,attackSpeed;
	protected int MoveState = DOWN;//初始怪物移动方向
	protected int LifeState = LIFE;//初始怪物状态
	public int blood;
	public int maxBlood=1;
	
//	public UnitObject(String t) {
//		type = t;
//		name = this.getClass().getSimpleName().toLowerCase();
//		System.out.println(name);
//		modle = new Modle(getType()+"/"+name);
//	}
	
	public int getLifeState() {
		return LifeState;
	}
	
	public boolean isLife() {
		return getLifeState()==LIFE;
	}
	public boolean isDead() {
		return getLifeState()==DEAD;
	}
	public boolean isRemove() {
		return getLifeState()==REMOVE;
	}
	public void goDead() {
		Music.music.get("dead").play();
		LifeState = DEAD;
	}
	
	public void remove() {
		World.map.remove(this);
		monsters.remove(this);
	}
	public String getType(){
		return type;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public int distanceTo(UnitObject u){
		return (int) Math.sqrt((u.x-x)*(u.x-x)+(u.y-y)*(u.y-y));
	}
	
	public int distanceTo(int ox,int oy){
		return (int) Math.sqrt((ox-x)*(ox-x)+(oy-y)*(oy-y));
	}
	public Monster getTarget(){
		if(target!=null && target.isLife() && distanceTo(target)<=getRange())
			return target;
		for (Monster u : monsters) {
			
			if(u.isLife()&&distanceTo(u)<=getRange()) {
				return target=u;
			}
		}
		return target=null;
	}
	public int getRange() {
		// TODO Auto-generated method stub
		//System.out.println(range);
		return range;
	}

	public boolean setTarget(Monster u) {
		if(u.isLife() && distanceTo(u)<=range) {
			target = u;
			return true;
		}
		return false;
	}
	
	public static void waiting(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public abstract BufferedImage getImage();
	public void attack(){};
	public void move(){};
	
}
