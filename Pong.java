import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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
	private int P1score=0;
	private int P2score=0;
	private boolean first=true;
	private boolean moved=false;
	private boolean gameStarted;
	private boolean paddleCollision;
	private boolean restart;
	private boolean topWallCollision;
	private boolean bottomWallCollision;
	
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
		if (restart) {
			first=true;
			moved=false;
			gameStarted=false;
			restart=false;
		}
		if (first) {
			left.setY((this.getHeight()-left.getHeight())/2);
			right.setY((this.getHeight()-right.getHeight())/2);
			pongBall.setY((this.getHeight()-pongBall.getHeight())/2);
			pongBall.setX((getWidth()-pongBall.getWidth())/2);
			first = false;
		}
		if (moved) {
			if ((gameStarted==false)) {
				if (Constants.TEST) {
					String play=pongBall.playTest();
					System.out.println(play);
				}
				else {
					pongBall.play();
					gameStarted=true;
				}
			}
			else {
				pongBall.moveBall();
				this.checkCollision();
			}
		}
		right.setX(getWidth()-20);
		
		left.draw(g,this);
		right.draw(g,this);
		if (paddleCollision) {
			pongBall.reverseSpeed();
		}
		pongBall.draw(g,this);
		paddleCollision=false;
	}

	// Checks the ball's collision
	private void checkCollision() {
		boolean looper=true;		
		
		BufferedImage pic = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = pic.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pic.getWidth(), pic.getHeight());
		left.draw(g, this);
		right.draw(g, this);
		
		if (!((pongBall.getX()+pongBall.getWidth())<getWidth())) {
			P2score++;
			looper=false;
			restart=true;
		}
		else if (!((pongBall.getY()+pongBall.getHeight())<getHeight())) {
			bottomWallCollision=true;
			looper=false;
		}
		else if (pongBall.getX()<0) {
			P1score++;
			looper=false;
			restart=true;
		}
		else if (pongBall.getY()<0) {
			topWallCollision=true;
			looper=false;
		}
		if (looper) {
			for (int i = pongBall.getX(); i < (pongBall.getX() + pongBall.getWidth()); i++) {
				for (int j = pongBall.getY(); j < (pongBall.getY() + pongBall.getHeight()); j++) {
					if (pic.getRGB(i, j) != Color.BLACK.getRGB()) {
						paddleCollision = true;
					}
				}
			}
		}
//		if (looper=false) {
//			System.out.println("JUB");
//		}
//		if (pongBall.checkCollision(left)) {
//			collision=true;
//		}
//		if (pongBall.checkCollision(right)) {
//			collision=true;
//		}
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
