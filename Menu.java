import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
		 *usage of GameBoard.java authored by Mr.Taylor
		 Description: Acts as a menu used to pick a game to play
		 */
public class Menu extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Rectangle playPong;
	private Rectangle playTextBased;
	private Container c;
	private JFrame w;
	private boolean releasedPong=false;
	private boolean clickedPong=false;
	private boolean releasedTextBased=false;
	private boolean clickedTextBased=false;
	
	// Constructor
	public Menu () {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// Runs this menu
	public void run() {
		w = new JFrame("Menu");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Menu menu = new Menu();
		menu.setBackground(Color.WHITE);

		c = w.getContentPane();
		c.add(menu);

		w.setResizable(true);
		w.setVisible(true);
	}

	// Draws the menu
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xUnit=this.getWidth()/16;
		int yUnit=this.getHeight()/16;
		
		playPong=new Rectangle((int)(7.5*xUnit),(int)(7.5*yUnit),1*xUnit,1*yUnit);
		playTextBased=new Rectangle((int)(1.5*xUnit),(int)(4*yUnit),1*xUnit,1*yUnit);
		
		if (releasedPong) {
			clickedPong=false;
			GameFrame gF = new GameFrame(100,100,640,480);
			Coordinates windowSize=gF.getDimensions();
			Pong game = new Pong(windowSize);
			gF.run(game);
//			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.GREEN);
		}
		if (clickedPong) {
			g.setColor(Color.BLACK);
		}
			
		
		
		g.fillRect(playPong.x, playPong.y, playPong.width, playPong.height);
		
		if (clickedTextBased) {
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.YELLOW);
		}
		
		if (releasedTextBased) {
			clickedTextBased=false;
//			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.RED);
		}
		
		
		g.fillRect(playTextBased.x, playTextBased.y, 0, 0);
		
		releasedPong=false;
		releasedTextBased=false;
		
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x, y;

		x = e.getX();
		y = e.getY();
		if (Constants.TEST) {
			System.out.println("X = "+ x + "Y = "+ y);
		}

		if (playPong.contains(x, y)) {
			clickedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}

		repaint();
		  

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
		if (Constants.TEST) {
			System.out.println("X = "+ x + "Y = "+ y);
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
