package game.world;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class UnitType extends Panel{
	String jieshao;
	//BufferedImage img;
	BufferedImage bulder;
	int x,y,bx,by;
	boolean select;
	
	public UnitType(BufferedImage img,String s) {//BufferedImage bulder,
		super(img,0,0,40,40);
		this.bulder=bulder;
		this.jieshao = s;

		System.out.println("UnitType");
		
		this.setFocusable(true);
		this.requestFocus();
	}

	@Override
	protected void leftClick() {
		System.out.println("UnitType:"+jieshao);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, getX(), getY(), getWidth(),getHeight(),null);
		//System.out.println("unittype:x="+x);
		if(select==true){
			
			g.drawImage(bulder, bx, by, null);
		}
	}
	
}
