import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameStateManager {
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MenuState = 0;
	public static final int LevelState = 1;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		currentState = MenuState;
		gameStates.add(new MenuState(this));
	} 	
	
	public void beginState(int state) {
		gameStates.get(state).init();
		currentState = state;
	}
	
	public void startLevel(int n) {
		LevelState level = new LevelState(this);
		level.setDifficulty(n);
		gameStates.add(level);
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}

	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}

	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
	
	public void mouseClicked(MouseEvent m) {
		gameStates.get(currentState).mouseClicked(m);
	}
	
	public void mouseEntered(MouseEvent m) {
		gameStates.get(currentState).mouseEntered(m);
	}
	
	public void mouseExited(MouseEvent m) {
		gameStates.get(currentState).mouseExited(m);
	}
	
	public void mousePressed(MouseEvent m) {
		gameStates.get(currentState).mousePressed(m);
	}
	
	public void mouseReleased(MouseEvent m) {
		gameStates.get(currentState).mouseReleased(m);
	}
	
	public void mouseMoved(MouseEvent m) {
		gameStates.get(currentState).mouseMoved(m);
	}
}
