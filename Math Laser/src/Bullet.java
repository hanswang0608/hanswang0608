import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
	private int dx;
	
	public Bullet() {
		dx = 30;
		width = 20;
		height = 10;
		cwidth = 20;
		cheight = 20;
	}
	
	public void update() {
		x += dx;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}
}
