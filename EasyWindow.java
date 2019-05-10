import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class EasyWindow extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	private MoveableThing movingHouse;

	public EasyWindow() {
		Image house = ((new ImageIcon("house.gif")).getImage());
		movingHouse = new MoveableThing(house, 0, 0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		movingHouse.draw(g, this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			movingHouse.setY(movingHouse.getY() - 5);
		} else if (code == KeyEvent.VK_DOWN) {
			movingHouse.setY(movingHouse.getY() + 5);
		} else if (code == KeyEvent.VK_LEFT) {
			movingHouse.setX(movingHouse.getX() - 5);
		} else if (code == KeyEvent.VK_RIGHT) {
			movingHouse.setX(movingHouse.getX() + 5);
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
