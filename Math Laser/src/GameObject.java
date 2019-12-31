import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	protected int cwidth;
	protected int cheight;
	
	public boolean intersects(GameObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	
	private Rectangle getRectangle() {
		return new Rectangle((int)x - cwidth, (int)y - cheight, cwidth, cheight);
	}
	
	public int getx() {return (int)x;}
	public int gety() {return (int)y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getCWidth() {return cwidth;}
	public int getCHeight() {return cheight;}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics2D g);
}
