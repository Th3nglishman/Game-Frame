import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/*
Name: Pong
Description: is the game Pong
*/

public class Pong extends GraphicsGame {
	//	**Feilds**
	private static final long serialVersionUID = 1L;
	private Paddle left;
	private Paddle right;
	private Ball pongBall;
	private boolean first=true;
	private boolean moved=false;
	private boolean gameStarted;

	
	//	**Constructors**
	public Pong(Coordinates size) {
		
		Image paddle = ((new ImageIcon("paddle.gif")).getImage());
		Image ball = ((new ImageIcon("ball.gif")).getImage());
		left = new Paddle(paddle, 0, 0);
		right = new Paddle(paddle, 0, 0);
		pongBall = new Ball(ball, 0, 0);
		repaint();
	}

	
	//	**Methods**
	
	// Public methods
	
	// Returns name
	@Override
	public String getName() {
		return "Pong";
	}

	// Paints this game
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (first) {
			left.setY((this.getHeight()-left.getHeight())/2);
			right.setY((this.getHeight()-right.getHeight())/2);
			pongBall.setY((this.getHeight()-pongBall.getHeight())/2);
			pongBall.setX((getWidth()-pongBall.getWidth())/2);
			first = false;
		}
		if (moved&&(gameStarted==false)) {
			if (Constants.TEST) {
				String play=pongBall.playTest();
				System.out.println(play);
			}
			else {
				pongBall.play();
				gameStarted=true;
			}
		}
		right.setX(getWidth()-20);
		
		
		left.draw(g,this);
		right.draw(g,this);
		pongBall.draw(g,this);
	}

	// Checks if a key is pressed
	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			right.setY(right.getY() - 5);
			moved=true;
		} else if (code == KeyEvent.VK_DOWN) {
			right.setY(right.getY() + 5);
			moved=true;
		}
		if (code == KeyEvent.VK_W) {
			left.setY(left.getY() + -5);
			moved=true;
		} else if (code == KeyEvent.VK_S) {
			left.setY(left.getY() + 5);
			moved=true;
		}
		repaint();
	}

	// Checks if a key is released
	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	// Checks if a key is typed
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	// Returns Pong's background
	@Override
	public Color getBackground() {
		return Color.BLACK;
	}
}
