import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class EasyWindow extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	private Paddle left;
	private Paddle right;

	public EasyWindow() {
		Image paddle = ((new ImageIcon("paddle.gif")).getImage());
		left = new Paddle(paddle, 0, 0);
		right = new Paddle(paddle, 50,0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		left.draw(g, this);
		right.draw(g, this);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			left.setY(left.getY() - 5);
		} else if (code == KeyEvent.VK_DOWN) {
			left.setY(left.getY() + 5);
		} if (code == KeyEvent.VK_LEFT) {
			right.setY(right.getY() - 5);
		} else if (code == KeyEvent.VK_RIGHT) {
			right.setY(right.getY() + 5);
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
