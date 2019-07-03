package game.world;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public abstract class Panel extends JPanel implements Const{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BufferedImage img;
	protected int x,y,width,height;
	protected double xk,yk;

	public Panel(BufferedImage img) {
		this(img,0,0,img.getWidth(),img.getHeight());		
	}
	public Panel(BufferedImage img,int x,int y,int w,int h) {
		this.img = img;
		this.x=x;
		this.y=y;
		width = w;
		height = h;
		width = img.getWidth();
		height = img.getHeight();
		setSize(width,height);
		xk=1.0*width/World.WIDTH;
		yk=1.0*height/World.HEIGHT;
		addMouseListeners();		
	}
//	@Override
//	public void setLocation(int x,int y) {
//		
//		this.x=x;
//		this.y=y;
//		super.setLocation(x, y);
//	}
	
	public void addMouseListeners() {
		this.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseMove();
				mouseMove(e.getX(),e.getY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseDragg();
				mouseDragg(e.getX(),e.getY());
			}
		});
		this.addMouseListener(new MouseAdapter()  {
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExit();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnter();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

					if(e.getButton() == MouseEvent.BUTTON1) {
					// 左键点击
						leftClick();
						leftClick(e.getX(),e.getY());
					} else if(e.getButton() == MouseEvent.BUTTON2) {
					// 中键点击
						midClick();
					} else if(e.getButton() == MouseEvent.BUTTON3) {
					// 右键点击
						rightClick();
					}

			}
		});
		
		this.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int count = e.getWheelRotation();
				//int direction = (Math.abs(count) > 0) ? UP : DOWN;
				if(count>0)mouseRotationUp(e.getX(),e.getY());
				else mouseRotationDown(e.getX(),e.getY());
				
			}}
		);
	}
	protected void mouseMove(int x2, int y2) {
	// TODO Auto-generated method stub
	
}
	protected void mouseRotationUp(int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

	protected void mouseRotationDown(int x2, int y2) {	}
	protected void leftClick(int x2, int y2) {	}
	protected void mouseMove() {	}
	protected void mouseDragg() {	}
	protected void mouseDragg(int ex,int ey) {	}
	protected void mouseExit() {	}
	protected void mouseEnter() {	}
	protected void leftClick() {	}
	protected void midClick() {	}
	protected void rightClick() {	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
//	public int getX() {
//		return x;
//	}
//	public int getY() {
//		return y;
//	}
	
	void worldChangeAction(int worldwith,int worldheight) {
		width=(int) (xk*worldwith);
		height=(int) (yk*worldheight);
		setSize(width,height);
	}
	
	public void paint(Graphics g){
		g.drawImage(img, x, y, getWidth(),getHeight(),null);
		//System.out.println(this.getClass().toString() + getWidth());
	}
}
