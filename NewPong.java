import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;

// Description: Is a pong window thing

public class Pong extends GraphicsGame {
	private static final long serialVersionUID = 1L;

	private Paddle left;
	private Paddle right;
	private Ball pongBall;
	private boolean first = true;
	private boolean moved = false;
	private boolean gameStarted;

	private final Set<Integer> keysPressed = new HashSet<Integer>();

	public Pong(Coordinates size) {

		Image paddle = ((new ImageIcon("paddle.gif")).getImage());
		Image ball = ((new ImageIcon("ball.gif")).getImage());
		left = new Paddle(paddle, 0, 0);
		right = new Paddle(paddle, 0, 0);
		pongBall = new Ball(ball, 0, 0);
		repaint();
	}

	@Override
	public String getName() {
		return "Pong";
	}

	public void paintComponent(Graphics g) {
		if (first) {
			left.setY((this.getHeight() - left.getHeight()) / 2);
			right.setY((this.getHeight() - right.getHeight()) / 2);
			pongBall.setY((this.getHeight() - pongBall.getHeight()) / 2);
			pongBall.setX((getWidth() - pongBall.getWidth()) / 2);
			first = false;
		}
		if (moved && (gameStarted == false)) {
			if (Constants.TEST) {
				String play = pongBall.playTest();
				System.out.println(play);
			} else {
				pongBall.play();
				gameStarted = true;
			}

		}
		right.setX(getWidth() - 20);

		if (this.checkCollision()) {
			// pongBall.getLastState();
		}

		super.paintComponent(g);

		left.draw(g, this);
		right.draw(g, this);
		pongBall.draw(g, this);

	}

	private boolean checkCollision() {
		return false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		keysPressed.add(arg0.getKeyCode());
		System.out.println(keysPressed.size());
		if (keysPressed.size() > 1) {

			// size is greater than one which means you
			// have pressed more than one key.
			movement(keysPressed);

		} else {
			int code = arg0.getKeyCode();
			if (code == KeyEvent.VK_UP) {
				right.setY(right.getY() - 5);
				moved = true;
			} else if (code == KeyEvent.VK_DOWN) {
				right.setY(right.getY() + 5);
				moved = true;
			}
			if (code == KeyEvent.VK_W) {
				left.setY(left.getY() + -5);
				moved = true;
			} else if (code == KeyEvent.VK_S) {
				left.setY(left.getY() + 5);
				moved = true;
			}
			repaint();
		}
		// clears the set
		keysPressed.clear();
	}

	public void movement(Set<Integer> Keyspressed) {

		for (Integer b1 : keysPressed) {

			// System.out.println("KeysPressed = " + keysPressed);
			if (b1 == KeyEvent.VK_S && b1 == KeyEvent.VK_DOWN) {
				// move both paddles down
				right.setY(right.getY() + 5);
				left.setY(left.getY() + 5);
				moved = true;
			} else if (b1 == KeyEvent.VK_W && b1 == KeyEvent.VK_UP) {
				// move both paddles up
				right.setY(right.getY() - 5);
				left.setY(left.getY() + -5);
				moved = true;
			}

		}

		// System.out.println("W: " + Wpressed + " UP: " + UPpressed + " S:" + Spressed
		// + " DOWNpressed: " + DOWNpressed);

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public Color getBackground() {
		return Color.BLACK;
	}
}
