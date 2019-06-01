import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

/*
Name: Graphics game
Description: is a super class for all graphics games
*/

public abstract class GraphicsGame extends Game implements KeyListener {
	//	**Feilds**
	private static final long serialVersionUID = 1L;

	
	//	**Constructors**
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	
	//	**Methods**
	
	// Public methods
	
	// Returns the game background color
	public abstract Color getBackground();
}
