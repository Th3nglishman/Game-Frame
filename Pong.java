import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/*
Name: Pong
Description: is the game Pong
*/

public class Pong extends GraphicsGame implements ActionListener {
	//	**Feilds**
	private static final long serialVersionUID = 1L;
	private Paddle left;
	private Paddle right;
	private Ball pongBall;
	private String p1;
	private String p2;
	private Timer timer;
	private int p1score=0;
	private int p2score=0;
	private boolean p1Win=false;
	private boolean p2Win=false;
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
		timer = new Timer(30, this);
		timer.setRepeats(true);
		timer.addActionListener(this);
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
		g.setColor(Color.WHITE);
		p1=("P1:"+p1score);
		p2=("P2:"+p2score);
		g.drawString(p1, 0, 10);
		g.drawString(p2, getWidth()-30, 10);
		if (restart) {
			first=true;
			moved=false;
			gameStarted=false;
			restart=false;
			if (p1Win) {
				p1score++;
			}
			if (p2Win) {
				p2score++;
			}
			pongBall.setSpeed(5);
		}
		if (!moved) {
			left.setY((this.getHeight()-left.getHeight())/2);
			right.setY((this.getHeight()-right.getHeight())/2);
			pongBall.setY((this.getHeight()-pongBall.getHeight())/2);
			pongBall.setX((getWidth()-pongBall.getWidth())/2);
			first = false;
			timer.start();
		}
		else if (moved) {
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
			pongBall.addSpeed();
		}
		pongBall.draw(g,this);
		paddleCollision=false;
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


	// is called when the timer activates
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	// Private methods
	
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
			p2Win=true;
			looper=false;
			restart=true;
		}
		else if (!((pongBall.getY()+pongBall.getHeight())<getHeight())) {
			bottomWallCollision=true;
			looper=false;
		}
		else if (pongBall.getX()<0) {
			p1Win=true;
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
	}
}
