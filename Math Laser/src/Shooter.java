import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Shooter extends GameObject{
	private int speed;
	private boolean movingUp;
	private boolean movingDown;
	private boolean shooting;
	private BufferedImage image;
	
	public Shooter() {
		width = 100;
		height = 75;
		speed = 5;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/cannon.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (movingUp) {
			y -= speed;
		}
		if (movingDown) {
			y += speed;
		}
		if (y > 500) {
			y = 500;
		}
		if (y < 70) {
			y = 70;
		}
	}
	
	public void draw(Graphics2D g) {
		/*g.setColor(Color.BLACK);
		g.fillRect(x-width/2, y-height/2, width, height);*/
		g.drawImage(image, (int)x-width/2, (int)y-height/2, width, height, null);
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			g.fillOval(x + width / 2 + 20 + i * 50, y-5, 10, 10);
		}
	}
	
	public void setMovingUp(boolean b) {
		movingUp = b;
	}
	
	public void setMovingDown(boolean b) {
		movingDown = b;
	}
	
	public void setShooting(boolean b) {
		shooting = b;
	}
	
	public boolean getShooting() {
		return shooting;
	}
}
