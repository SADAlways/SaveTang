package game.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameWin extends Panel {
	World world = World.self;
	Color c = new Color(255,255,0,200);
	public GameWin() {
		super(Images.gamewin);
		world.remove(world.sup);
		
		world.remove(world.moneypanel);
		world.remove(world.minimap);
		world.remove(world.minibound);
		world.remove(world.map);
		y=-world.getHeight();
		
		// TODO Auto-generated constructor stub
	}
	
	private int t;	//s=1/2*gg*tt*tt;
	private int v;

	public void paint(Graphics g){
		width=world.getWidth();
		height=world.getHeight();
		
		if(y!=0 || v!=0){
			t++;
			v+=t/2;
			System.out.println(v);
			y+=v;
			if(y>=0 && v>0){
				y=0;
				if(v<10){
					v=0;
				}else{
					t=0;
					v=-v/3;
				}
				
			}
			g.drawImage(img, x, y, width,height,null);
		}else{
			g.drawImage(img, x, y, width,height,null);
			g.setColor(c);
			g.setFont(new Font("楷体",1,getWidth()/4));
			g.drawString("胜利！", getWidth()/5, getHeight()/2);
		}
		
		
		
	}

}
