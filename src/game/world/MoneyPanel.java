package game.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MoneyPanel extends Panel{
	
	public MoneyPanel() {
		super(Images.moneypanle);
//		setSize(60,160);
//		this.width=60;
//		this.height=160;
		xk=1.0*width/World.WIDTH;
		yk=1.0*height/World.HEIGHT;
	}
//	public void drawMoney(Graphics g) {
//		g.setFont(new Font("楷体", 1, 30));
//
//		g.setColor(new Color(0,0,0));
//		g.drawString(String.valueOf(World.money), 100,50 );
//	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		int xx =getWidth()/8;
		g.setFont(new Font("楷体", 1, xx));

		g.setColor(new Color(0,0,0));
		g.drawString(String.valueOf(World.money), getWidth()/3,getHeight()/2+10 );
		
	}
}
