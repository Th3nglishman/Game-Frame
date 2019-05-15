import java.awt.*;
import java.awt.image.*;

// Description: acts as a super class for all moving objects

public class MoveableThing extends Sprite {

	private Image image;

	// Constructors
	public MoveableThing(Image img, int x, int y) {
		super(img, x, y);
		image = img;
		super.setX(x);
		super.setY(y);
	}

	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, getX(), getY(), io);
	}
}
