import java.awt.*;
import java.awt.image.*;

/*
Name: Moveable Sprite
Description: Acts as a base class for a moveable object
*/

public class MoveableSprite extends Sprite {
	//	**Feilds**
	private Image image;

	//	**Constructors**
	public MoveableSprite(Image img, int x, int y) {
		super(img, x, y);
		image = img;
		super.setX(x);
		super.setY(y);
	}

	
	//	**Methods**
	
	// Public methods
	
	// Draws this object
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, getX(), getY(), io);
	}
}
