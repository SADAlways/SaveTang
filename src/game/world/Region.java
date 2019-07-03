package game.world;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Arrays;
/**
 * 	表示一系列无规律的点的集合
 * @author hsy
 *
 */
public class Region {
	/*public static Region bullet=new Region(Images.bullet),
			bulletII=new Region(Images.bulletII),
			bulletIII=new Region(Images.bulletIII),
			heros[]= {new Region(Images.heros[0]),new Region(Images.heros[1])},
			airplanes[]= {new Region(Images.airplanes[0]),new Region(Images.airplanes[1])},
			bigairplanes[]= {new Region(Images.bigairplanes[0]),new Region(Images.bigairplanes[1])},
			bees[]={new Region(Images.bees[0]),new Region(Images.bees[1])};
*/
	private final int[] px,py;
	private final int length;
	private int x,y;
	private final Rectangle rect;

	public Region(int[] x,int[] y,Rectangle rect) {
		px=x.clone();
		py=y.clone();
		length=px.length;
		this.rect=rect;
	}
	
	/**
	 * 	给图片描边，把所有不透明的边缘点的坐标保存回Region的底层数组px、py中。
	 * @param img
	 */
	public Region(BufferedImage img) {
		int w=img.getWidth();
		int h=img.getHeight();
		rect=new Rectangle(0,0,w,h);
		
		int[]x=new int[w*h];
		int[]y=new int[w*h];
		int index=0;
		
		int pha=0xff;//不透明度，0表示完全透明，255表示完全不透明
		int i,j;
		for(i=1;i<w-1;i++) {
			for(j=1;j<h-1;j++) {
				//img.getRGB(i,j)，获取某像素点的色彩，返回一个32位的整数（用16进制表示就是8位，最左边两位就是不透明度的值）
				//(img.getRGB(i,j)>>24&0xff)意思就是取得某像素点的不透明度的值。
				//整个if表达的意思是：如果点（i，j）是完全不透明的，而它旁边存在不完全透明的点，或者它是边界点，则返回true
				if((img.getRGB(i,j)>>24&0xff)>=pha&&(
						(img.getRGB(i+1,j)>>24&0xff)<pha ||
						(img.getRGB(i-1,j)>>24&0xff)<pha ||
						(img.getRGB(i,j+1)>>24&0xff)<pha ||
						(img.getRGB(i,j-1)>>24&0xff)<pha ||
						i==1||i==w-2||j==1||j==h-2//非最边缘的点，而是靠内一个点，有强迫症的可以继续细化=。=						
						)
					) {
					x[index]=i;
					y[index++]=j;
				}
			}
		}
		//System.out.println(index);
		if(index==0) {
			length=0;
			px=null;
			py=null;
			return;
		}
		px=Arrays.copyOf(x, index);
		py=Arrays.copyOf(y, index);
		length=index;
		
	}
	
	/**
	 * 	设置Region的坐标
	 * @param x
	 * @param y
	 * @return this
	 */
	public Region setLocation(int x,int y) {
		this.x=x;
		this.y=y;
		rect.setLocation(x, y);
		return this;
	}
	
	/**
	 * 	返回Region的子集，该子集里的点全在矩形区域rect内
	 * @param rect
	 * @return Region
	 */
	private Region intersection(Rectangle rect) {
		int[]x=new int[px.length];
		int[]y=new int[px.length];
		int index=0;
		for(int i=0;i<length;i++) {
			//times++;
			if(rect.contains(px[i]+this.x, py[i]+this.y)) {
				x[index]=px[i];
				y[index++]=py[i];
				
			}
		}
		if(index==0)return null;
		x=Arrays.copyOf(x, index);
		y=Arrays.copyOf(y, index);
		
		return new Region(x,y,this.rect).setLocation(this.x, this.y);
	}
	
	
	//int times=0;  打桩用，计算碰撞检测的次数
	/**
	 * 	判断两个Region是否发生碰撞
	 * @param other
	 * @return boolean
	 */
	public boolean intersects(Region other) {
		if(!this.rect.intersects(other.rect))return false;

		Rectangle rect = this.rect.intersection(other.rect);
		Region tr = this.intersection(rect);
		Region or = other.intersection(rect);
		if(tr==null || or==null) {
			//System.out.println("碰撞次数："+times);
			//times=0;
			return false;
		}
		int a=0,b=0;
		for( a=0;a<tr.length;a++) {
			for(b=0;b<or.length;b++) {
				//times++;
				if(tr.px[a]+tr.x==or.px[b]+or.x && tr.py[a]+tr.y==or.py[b]+or.y) {
					//System.out.println("碰撞次数："+times);
					//times=0;
					return true;
				}
				
			}
			
		}
		//System.out.println("碰撞次数："+times);
		//times=0;
		return false;
	}
	
}
