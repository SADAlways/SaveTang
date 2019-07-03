package game.ta;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import game.attackelements.Bullet;
import game.attackelements.ShootObject;
import game.guaiwu.Monster;
import game.world.GameStart;
import game.world.Images;
import game.world.Modle;
import game.world.Music;
import game.world.UnitObject;
import game.world.World;
import game.world.Const.ActionType;
import game.world.Const.GameState;

public abstract class Tower extends UnitObject{
	public static  ArrayList<ShootObject> shoots = new ArrayList<>();
	protected ShootObject shootObject;
	protected ArrayList<Monster> rangeMonsters = new ArrayList<>();
	public int bulletX;
	public int bulletY;
	public int buymoney;
	public int level = 1;
	public int buildX;
	public int buildY;
	public int buildWidth=80;
	public int buildHeight=80;
	public Tower(int x,int y,int width,int height) {
		type = "Ta";
		Music.music.get("money").play();
		name = this.getClass().getSimpleName().toLowerCase();
		System.out.println(name);
		modle = new Modle(getType()+"/"+name,this);
		Monster target;
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		buildX=x+width/2-buildWidth/2;
		buildY=y+height/2;
		setSize(width,height);//大小
		World.map.add(this);
		towers.add(this);
		
		new Thread() {
			@Override
			public void run() {
				while(World.gameState==GameState.RUNNING) {
					getTarget();
					attack();
					waiting(100);

				}	
			}
		}.start();
//		new Ranges(this);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * 防御塔攻击
	 */
	int index=0;//控制子弹发射频率
	int monstersIndex = 0;//怪物下标
	public void attack() {
		if(target==null) {
			modle.play(ActionType.STAND);
		}else
		modle.play(ActionType.ATTACK1);
	}
	@Override
	public BufferedImage getImage() {
		return modle.getImage();
	}
	

	public abstract void shoot();
	public int getRange() {
		return range;
	}

}
