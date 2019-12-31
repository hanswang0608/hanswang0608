import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;


public class MenuState extends GameState{
	private Font font;
	private Font titleFont;
	private Font selectedFont;
	private String[] options = {"Easy", "Intermediate", "Advanced"};
	private Color titleColor;
	private Color bgColour;
	private int currentChoice;
	private int mouseX;
	private int mouseY;
	
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		try {
			bgColour = Color.WHITE;
			titleColor = Color.BLUE;
			titleFont = new Font("Century Gothic", Font.BOLD, 64);
			selectedFont = new Font("Arial", Font.BOLD, 36);
			font = new Font("Arial", Font.PLAIN, 32);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {}
	
	public void update() {
		if (mouseX > 400 && mouseX < 580) {
			if (mouseY > 230 && mouseY < 260) {
				currentChoice = 0;
			}
			else if (mouseY > 280 && mouseY < 310) {
				currentChoice = 1;
			}
			else if (mouseY > 340 && mouseY < 370) {
				currentChoice = 2;
			}
			else {
				currentChoice = -1;
			}
		}
		else {
			currentChoice = -1;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(bgColour);
		g.fillRect(0, 0, 960, 540);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Math Laser", 320, 150);
		for(int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setFont(selectedFont);
				g.setColor(Color.BLACK);
			}
			else {
				g.setFont(font);
				g.setColor(Color.GRAY);
			}
			g.drawString(options[i], 400, 250 + i * 60);
		}
	}

	
	public void keyPressed(int k) {}
	
	public void keyReleased(int k) {}
	
	public void mouseClicked(MouseEvent m) {}
	public void mouseEntered(MouseEvent m) {}
	public void mouseExited(MouseEvent m) {}
	public void mousePressed(MouseEvent m) {
		if (currentChoice != -1) {
			gsm.startLevel(currentChoice);
			gsm.beginState(GameStateManager.LevelState);
		}
	}
	public void mouseReleased(MouseEvent m) {}
	
	public void mouseMoved(MouseEvent m) {
		mouseX = m.getX();
		mouseY = m.getY();
	}
}
