import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/*
Name: Game Frame
Description: Is a JFrame for all games (and the menu)
*/

public class GameFrame extends JFrame {
	//	**Feilds**
	private static boolean MAX=Constants.MAX;
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JFrame w;
	private Container c;
	private Coordinates coords;
	
	
	//	**Constructors**
	public GameFrame( int xOff, int yOff, int x, int y) {
		width = x;
		height = y;
		coords = new Coordinates(xOff, yOff);
		w= new JFrame();
	}
	
	//	**Methods**
	
	// Public methods
	
	// Runs a menu instance
	public void runMenu() {
		w.setName("Menu");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Menu menu = new Menu();
		menu.setBackground(Color.WHITE);

		c = w.getContentPane();
		c.add(menu);

		w.setResizable(true);
		w.setVisible(true);
	}

	// Runs a game instance
	public void run(GraphicsGame g) {
		w.setName(g.getName());
		if (!MAX) {
			w.setBounds(coords.getX(), coords.getY(), width, height);
		}
		else {
			w.setBounds(0,0,0,0);
			w.setSize(getMaximumSize());
		}
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsGame game = g;
		w.setBackground(g.getBackground());
		w.addKeyListener(game);
		Container c = w.getContentPane();
		c.add(game);
		w.setResizable(true);
		w.setVisible(true);
	}

	// Returns this window's dimensions
	public Coordinates getDimensions() {
		Coordinates dimensions= new Coordinates(width,height);
		return dimensions;
	}
}
