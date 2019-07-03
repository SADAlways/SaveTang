package game.ta;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.world.Images;
import game.world.Panel;
import game.world.UnitObject;
import game.world.World;

public class Ranges extends JPanel{
	private int x;
	private int y;
	private int height;
	private int width;
	private int range;
	Tower belong;
	
	public Ranges(Tower t) {
		belong=t;
		this.x=t.x;
		this.y=t.y;
		this.width=t.width;
		this.height=t.height;
		this.range = t.range;
		World.map.add(this);
	}
	static BufferedImage ranges;
	static BufferedImage levelbotton;
	static {
		ranges = Images.readImage("Ta/range.png");
		levelbotton = Images.readImage("Ta/升级按钮.png");
	}
	public void paint(Graphics g) {
		x=belong.getX()+World.map.x;
		y=belong.getY()+World.map.y;
		g.drawImage(ranges, x-range, y-range, 2*range, 2*range, null);
		g.drawImage(levelbotton, x+width/2, y+30, 20, 20, null);
	}
	public BufferedImage getImage() {
		
		return ranges;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
