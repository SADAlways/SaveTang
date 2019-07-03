package game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import game.guaiwu.Monster;
import game.ta.Tower;

/**
 * 小地图
 * 功能：等比缩小的世界地图，大地图上所有的单位都映射在小地图上
 * 敌人以红点表示，友方以绿点显示，点的大小以综合战力分配
 * 用白色边框框选出当前视野的地图范围
 *
 */
public class MiniMap extends Panel{
	List<Tower> ts = Tower.towers;
	List<Monster> ms = Monster.monsters;
	public MiniMap() {
		super(Images.map);
		//System.out.println("Map");
		setSize(160,160);
		this.width=160;
		this.height=160;
		xk=1.0*width/World.WIDTH;
		yk=1.0*height/World.HEIGHT;
	}
	
	public int tunMapX(int mapx){
		return width*mapx/World.map.width;
	}
	public int tunMapY(int mapy){
		return height*mapy/World.map.height;
	}
	public void paint(Graphics g){
		g.drawImage(img, x, y, getWidth(),getHeight(),null);
		for(UnitObject u:ms){
			if(!u.isLife())continue;
			int tx=tunMapX(u.getX());
			
			int ty=tunMapY(u.getY());
			//System.out.println(tx+","+ty);
			g.setColor(Color.red);
			g.fillOval(tx, ty+5, 7, 7);
		}
		for(UnitObject u:ts){
			if(!u.isLife())continue;
			int tx=tunMapX(u.getX());
			
			int ty=tunMapY(u.getY());
			//System.out.println(tx+","+ty);
			g.setColor(Color.blue);
			g.fillOval(tx, ty+5, 7, 7);
		}
		
		int tx=-width*World.map.x/World.map.width;
		int ty=-height*World.map.y/World.map.height;
		int tw = width*World.self.getWidth()/World.map.width;
		int th = height*World.self.getHeight()/World.map.height;
		
		g.setColor(Color.WHITE);
		//g.setFont(new Font("黑体", 30, 100));
		g.drawRoundRect(tx, ty, tw, th, 20, 20);
		g.drawRoundRect(tx+1, ty+1, tw-2, th-2, 20, 20);
	}
	@Override
	public void leftClick(int ex,int ey) {
		//System.out.println(ex+","+ey);
		int mx=World.map.x;
		int my=World.map.y;
		int mw=World.map.width;
		int mh=World.map.height;

		int ww=World.self.getWidth();
		int wh=World.self.getHeight();
		
		World.map.x=ww/2-mw/width*ex;
		World.map.y=wh/2-mh/height*ey;
		
		if(World.map.x<ww-mw)World.map.x=ww-mw;		
		if(World.map.y<wh-mh)World.map.y=wh-mh;
		if(World.map.x>0)World.map.x=0;
		if(World.map.y>0)World.map.y=0;
	}
	
	public void mouseDragg(int ex,int ey){
		leftClick( ex, ey);
	}
	
}