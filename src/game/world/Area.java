package game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import game.world.World;

/**
 * 一系列矩形的集合，用以描述不可种塔的区域
 * 
 *
 */
public class Area extends JPanel{
	List<Rectangle> rects = new ArrayList<>();
	Maps map = World.map;
	private List<Rectangle> touchRects=new ArrayList<>();

	public static Area noBuildings=new Area();
	public Area() {
		int r=80;
		Point[] ps = new Point[16];
	
		ps[0]=new Point(1580,0);
		ps[1]=new Point(1580,80);
		ps[2]=new Point(100,80);
		ps[3]=new Point(100,755);
		ps[4]=new Point(270,755);
		ps[5]=new Point(270,250);
		ps[6]=new Point(435,250);
		ps[7]=new Point(435,840);
		ps[8]=new Point(685,840);
		
		ps[9]=new Point(685,245);
		ps[10]=new Point(1435,245);
		ps[11]=new Point(1435,415);
		ps[12]=new Point(850,415);
		ps[13]=new Point(850,580);
		ps[14]=new Point(1435,580);
		ps[15]=new Point(1435,2000);
		for (Point p : ps) {
			p.setLocation(p.x+5, p.y+5);
		}
		add(ps);
		map.add(this);
	}
	/*
	 * 怪物移动
	 * 怪物的几个拐点：
	 * 1.向左拐(1580,80)
	 * 2.向下拐(120,80)
	 * 3.向右拐(120,760)
	 * 4.向上拐(290,760)
	 * 5.向右拐(290,250)
	 * 6.向下拐(460,250)
	 * 7.向右拐(460,840)
	 * 8.向上拐(710,840)
	 * 9.向右拐(240,710)
	 * 10.向下拐(1450,220)
	 * 11.向右拐(1450,420)
	 * 12.向下拐(870,450)
	 * 13.向右拐(870,580)
	 * 14.向下拐(1450,580)
	 */
	
	public void add(Rectangle r){
		rects.add(r);
	}
	public void add(int x,int y,int width,int height){
		rects.add(new Rectangle(x, y, width, height));
	}
	public void add(Point... ps){
		int r=80;

		for (int i = 0; i < ps.length-1; i++) {
			int ax = ps[i].x;
			int ay = ps[i].y;
			int bx = ps[i+1].x;
			int by = ps[i+1].y;
			if(ax==bx){
				if(ay<by){
					add(new Rectangle(ax,ay,r,by-ay));
				}else{
					add(new Rectangle(bx,by+r,r,ay-by));
				}
			}
			
			if(ay==by){
				if(ax<bx){
					add(new Rectangle(ax,ay,bx-ax,r));
				}else{
					add(new Rectangle(bx+r,by,ax-bx,r));
				}
			}
			
			//add(new Rectangle(ax,bx,w,h));
			
		}

	}
	
	public void setLocation(int x,int y) {
		
	}
	
	public boolean contains(Rectangle other){
		touchRects.clear();
		for (Rectangle r : rects) {
			r=new Rectangle(r.x+map.x*2,r.y+map.y*2,r.width,r.height);
			//r.setLocation(r.x+map.x*2,r.y+map.y*2);
			if(r.intersects(other)){
				touchRects.add(r.intersection(other));
				
			}
		}
		if(touchRects.size()==0)		
		return false;
		return true;
		
	}
	public boolean contains(int x,int y,int width,int height){
		Rectangle other = new Rectangle(x+map.x,y+map.y,width,height);
		return contains(other);
		
	}
	
	public List<Rectangle> getTouch(){
		return touchRects;
	}
	
//	public Rectangle tochRect(Rectangle other){
//		for (Rectangle r : rects) {
//			if(r.intersection(other)!=null){
//				return r.intersection(other);
//			}
//		}
//		return null;
//	}
	
	public void paint(Graphics g){
//		for (Rectangle r : rects) {
//			g.setColor(new Color(255,0,0,50));
//			g.fillRect(r.x+map.x,r.y+map.y,r.width,r.height);
//		}
	}
	
}
