import java.awt.*;
import java.awt.image.*;

// Description: Is a super class for all movable objects (sprites)

public class MoveableThing extends Sprite {

	private Image image;

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
