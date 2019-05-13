import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Rectangle playPong;
	private Rectangle playTextBased;
	private Container c;
	private JFrame w;
	private boolean clickedPong=false;
	private boolean clickedTextBased=false;

	public void run() {
		addMouseListener(this);
		addMouseMotionListener(this);
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xUnit=this.getWidth()/16;
		int yUnit=this.getHeight()/16;
		
		playPong=new Rectangle(8*xUnit,8*yUnit,1*xUnit,1*yUnit);
		playTextBased=new Rectangle(2*xUnit,4*yUnit,1*xUnit,1*yUnit);
		if (clickedPong) {
			w.dispose();
		}
		if (clickedTextBased) {
			w.dispose();
		}
		g.setColor(Color.GREEN);
		g.fillRect(playPong.x, playPong.y, playPong.width, playPong.height);
		g.setColor(Color.RED);
		g.fillRect(playTextBased.x, playTextBased.y, playTextBased.width, playTextBased.height);
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
		int x, y;

		x = e.getX();
		y = e.getY();

		if (playPong.contains(x, y)) {
			clickedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}

		repaint();
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
		int x, y;

		x = e.getX();
		y = e.getY();

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
		int x, y;

		x = e.getX();
		y = e.getY();

		if (playPong.contains(x, y)) {
			clickedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}

		repaint();
	}
}
