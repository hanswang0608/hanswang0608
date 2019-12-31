import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class LevelState extends GameState{
	private int difficulty;
	private Color bgColour;
	private Shooter shooter;
	private Queue<Bubble> waitingBubbles;
	private ArrayList<Bubble> bubbles;
	private ArrayList<Bullet> bullets;
	private long timer;
	private long pauseTimer;
	private int pauseTime;
	private int time;
	private int firstValue;
	private int secondValue;
	private int questions;
	private Random r;
	private int qType;
	private int[] answers;
	private boolean loopedOnce;
	private int answer;
	private int score;
	private int bubbleCounter;
	private int tries;
	private boolean pause;
	private boolean correct;
	private int bulletCount;
	
	public LevelState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public void init() {
		waitingBubbles = new LinkedList<Bubble>();
		bubbles = new ArrayList<Bubble>();
		bullets = new ArrayList<Bullet>();
		timer = System.currentTimeMillis();
		r = new Random();
		score = 0;
		answers = new int[3 + 1 * difficulty];
		questions = 5 + 5 * difficulty;
		if (difficulty == 0) time = 3000;
		if (difficulty == 1) time = 2000;
		if (difficulty == 2) time = 1000;
		pauseTime = 1000;
		createBubbles();
		bgColour = Color.ORANGE;
		shooter = new Shooter();
		shooter.setPosition(80, 200);
		tries = 5;
		generateQuestion();
		pause = false;
		bulletCount = 10;
	}
	
	public void createBubbles() {
		int amount = 3 + difficulty;
		for (int i = 0; i < amount; i++) {
			waitingBubbles.add(new Bubble((1 + difficulty * 0.25)));
		}
		waitingBubbles.peek().setPosition(800, 600);
	}

	public void update() {
		if ((System.currentTimeMillis() - pauseTimer) > pauseTime && tries != 0 && bulletCount != 0) {
			pause = false;
		}
		if (pause) return;
		if ((System.currentTimeMillis() - timer) > time) {
			timer = System.currentTimeMillis();
			bubbleCounter++;
			if (!waitingBubbles.isEmpty()) {
				bubbles.add(waitingBubbles.remove());
				if (!loopedOnce) {
					bubbles.get(bubbles.size()-1).setValue(answers[bubbleCounter-1]);
				}
				if (!waitingBubbles.isEmpty()) {
					waitingBubbles.peek().setPosition(800, 600);
				}
				if (bubbleCounter == answers.length) {
					loopedOnce = true;
				}
			}
		}
		for (int i = 0; i < bubbles.size(); i++) {
			bubbles.get(i).update();
			if (bubbles.get(i).gety() < -50) {
				waitingBubbles.add(bubbles.remove(i));
				waitingBubbles.peek().setPosition(800, 600);
			}
		}
		shooter.update();
		
		if (shooter.getShooting() && bullets.isEmpty()) {
			bullets.add(new Bullet());
			bullets.get(0).setPosition(shooter.getx()-bullets.get(0).getWidth()/2, shooter.gety()-bullets.get(0).getHeight()/2);
			bulletCount --;
			if (bulletCount == 0) {
				pause = true;
			}
		}
		if (!bullets.isEmpty()) {
			if (bullets.get(0).getx() > 1000) {
				bullets.remove(0);
			}
			else {
				bullets.get(0).update();
			}
		}
		for (int i = 0; i < bubbles.size(); i++) {
			if (!bullets.isEmpty() && bullets.get(0).intersects(bubbles.get(i))) {
				pause = true;
				pauseTimer = System.currentTimeMillis();
				if (bubbles.get(i).getValue() == answer) {
					score += answer;
					correct = true;
					bulletCount++;
				}
				else {
					tries--;
					correct = false;
					if (tries == 0) {
						pause = true;
						return;
					}
				}
				generateQuestion();
				bubbles.clear();
				waitingBubbles.clear();
				createBubbles();
				loopedOnce = false;
				bubbleCounter = 0;
			}
		}
		
	}

	public void draw(Graphics2D g) {
		g.setColor(bgColour);
		g.fillRect(0, 0, 960, 540);
		for (int i = 0; i < bubbles.size(); i++) {
			bubbles.get(i).draw(g);
		}
		
		shooter.draw(g);
		
		if (!bullets.isEmpty()) {
			bullets.get(0).draw(g);
		}
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.setColor(Color.BLACK);
		if (qType == 0) {
			g.drawString("" + firstValue + " + " + secondValue + " = ", 400, 30);
		}
		else {
			g.drawString("" + firstValue + " - " + secondValue + " = ", 400, 30);
		}
		g.drawString("Score: " + score, 10, 30);
		g.drawString("Tries: " + tries, 200, 30);
		if (pause && tries != 0 && bulletCount != 0) {
			if (correct) {
				g.setColor(Color.GREEN);
				g.setFont(new Font("Century Gothic", Font.BOLD, 48));
				g.drawString("Correct!", 350, 300);
			}
			else {
				g.setColor(Color.RED);
				g.setFont(new Font("Century Gothic", Font.BOLD, 48));
				g.drawString("Wrong", 350, 300);
			}
		}
		if (tries == 0 || bulletCount == 0) {
			g.setColor(Color.RED);
			g.setFont(new Font("Century Gothic", Font.BOLD, 64));
			g.drawString("Game Over", 300, 300);
		}
		g.setColor(Color.BLUE);
		for (int i = 0; i < bulletCount; i++) {
			g.fillOval(20 + i * 25, 500, 20, 20);
		}
	}

	public void setDifficulty(int n) {
		difficulty = n;
	}
	
	public void generateQuestion() {
		qType = r.nextInt(2);
		if (qType == 0) {
			if (difficulty == 0) {
				firstValue = r.nextInt(30) + 1;
				secondValue = r.nextInt(30) + 1;
			}
			else if (difficulty == 1) {
				firstValue = r.nextInt(50) + 1;
				secondValue = r.nextInt(50) + 1;
			}
			else if (difficulty == 2) {
				firstValue = r.nextInt(100) + 1;
				secondValue = r.nextInt(100) + 1;
			}
		}
		else {
			if (difficulty == 0) {
				firstValue = r.nextInt(30) + 2;
				secondValue = r.nextInt(firstValue-1) + 1;
			}
			else if (difficulty == 1) {
				firstValue = r.nextInt(50) + 2;
				secondValue = r.nextInt(firstValue-1) + 1;
			}
			else if (difficulty == 2) {
				firstValue = r.nextInt(100) + 2;
				secondValue = r.nextInt(firstValue-1) + 1;
			}
		}
		
		if (qType == 0) {
			answer = firstValue + secondValue;
		}
		else {
			answer = firstValue - secondValue;
		}
		int answerIndex = r.nextInt(answers.length);
		for (int i = 0; i < answers.length; i++) {
			if (i == answerIndex) {
				answers[i] = answer;
			}
			else {
				answers[i] = r.nextInt(answer + 10) + 1;
				while(answers[i] == answer) {
					answers[i] = r.nextInt(answer + 10) + 1;
				}
			}
		}
	}
	
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_UP) {shooter.setMovingUp(true);}
		if (k == KeyEvent.VK_DOWN) {shooter.setMovingDown(true);}
		if (k == KeyEvent.VK_SPACE) {shooter.setShooting(true);}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_UP) {shooter.setMovingUp(false);}
		if (k == KeyEvent.VK_DOWN) {shooter.setMovingDown(false);}
		if (k == KeyEvent.VK_SPACE) {shooter.setShooting(false);}
	}

	public void mouseClicked(MouseEvent m) {
		
	}

	public void mouseEntered(MouseEvent m) {
		
	}

	public void mouseExited(MouseEvent m) {
		
	}

	public void mousePressed(MouseEvent m) {
		
	}

	public void mouseReleased(MouseEvent m) {
		
	}

	public void mouseMoved(MouseEvent m) {
		
	}
}
