import javax.swing.JPanel;

/*
Name: Game
Description: is a super class for all games
*/

public abstract class Game extends JPanel{
	//	**Feilds**
	private static final long serialVersionUID = 1L;

	
	//	**Methods**
	
	// Public methods
	
	// Returns this Game's name
	public abstract String getName();
}
