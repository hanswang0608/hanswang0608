import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bubble extends GameObject{
	private int value;
	private BufferedImage image;
	private double dy;
	
	public Bubble(double v) {
		
		width = 50;
		height = 50;
		cwidth = 50;
		cheight = 50;
		dy = v;
		value = 0;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/bubble.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		y -= dy;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, (int)x-width/2, (int)y-height/2, width, height, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		g.drawString(Integer.toString(value), (int)x-18, (int)y+10);
	}
	
	public void setValue(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setDy(double v) {
		dy = v;
	}
}
