import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/*
Name: Menu
Description: Class is the menu used to select games
*/

public class Menu extends JPanel implements MouseListener, MouseMotionListener {
	// **Feilds**
	private static final long serialVersionUID = 1L;
	private Rectangle playPong;
	private Rectangle playTextBased;
	private GameFrame gF;
	private boolean releasedPong = false;
	private boolean clickedPong = false;
	private boolean releasedTextBased = false;
	private boolean clickedTextBased = false;

	
	// **Constructors**
	public Menu() {
		addMouseListener(this);
		addMouseMotionListener(this);
		gF = new GameFrame(0, 0, 640, 480);
	}

	
	// **Methods**

	// Public methods

	// Starts up the menu
	public void run() {
		gF.runMenu();
	}

	// Paints this menu
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xUnit = this.getWidth() / 16;
		int yUnit = this.getHeight() / 16;
		playPong = new Rectangle((int) (7.5 * xUnit), (int) (7.5 * yUnit), 1 * xUnit, 1 * yUnit);
		playTextBased = new Rectangle((int) (1.5 * xUnit), (int) (4 * yUnit), 1 * xUnit, 1 * yUnit);

		if (releasedPong) {
			clickedPong = false;
			gF.setBounds(100, 100, 640, 480);
			Coordinates windowSize = gF.getDimensions();
			Pong game = new Pong(windowSize);
			gF.run(game);
		} else {
			g.setColor(Color.GREEN);
		}

		if (clickedPong) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(playPong.x, playPong.y, playPong.width, playPong.height);

		if (clickedTextBased) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.YELLOW);
		}

		if (releasedTextBased) {
			clickedTextBased = false;
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.RED);
		}
		g.fillRect(playTextBased.x, playTextBased.y, 0, 0);

		releasedPong = false;
		releasedTextBased = false;
		repaint();
	}

	// Checks if the mouse is dragged
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// Checks if the mouse is moved
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	// Checks if the mouse is clicked
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	// Checks if the mouse is entered
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	// Checks if the mouse is exited
	@Override
	public void mouseExited(MouseEvent e) {
	}

	// Checks if the mouse is pressed
	@Override
	public void mousePressed(MouseEvent e) {
		int x, y;

		x = e.getX();
		y = e.getY();
		if (Constants.TEST) {
			System.out.println("X = " + x + "Y = " + y);
		}
		if (playPong.contains(x, y)) {
			clickedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}
		repaint();
	}

	// Checks if the mouse is released
	@Override
	public void mouseReleased(MouseEvent e) {
		int x, y;

		x = e.getX();
		y = e.getY();
		if (Constants.TEST) {
			System.out.println("X = " + x + "Y = " + y);
		}
		if (playPong.contains(x, y)) {
			releasedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}
		repaint();
	}
}
