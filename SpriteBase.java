

import java.awt.Graphics;
import java.awt.Image;

//Provides a base for the Sprite class to work off
public class SpriteBase extends Coordinates {
	public static final double PI = Math.PI;

	private Image picture;
	private int picHeight;
	private int picWidth;
	private String name;

	// Constructors
	public SpriteBase(Image pic, int x, int y) {
		super(x, y);
		picWidth = pic.getWidth(null);
		picHeight = pic.getHeight(null);
		picture = pic;
	}

	public SpriteBase(Image pic, int x, int y, String nameInput) {
		super(x, y);
		picWidth = pic.getWidth(null);
		picHeight = pic.getHeight(null);
		picture = pic;
		name = nameInput;
	}

	// Rotates the sprite by some degrees
	public void rotateDegrees(double degrees) {
		double radians = (degrees * PI / 180);
		this.getCoordinates().rotate(radians, getWidth() / 2, getHeight() / 2);
	}

	// Rotates the sprite by some radians
	public void rotateRadians(double radians) {
		this.getCoordinates().rotate(radians, getWidth() / 2, getHeight() / 2);
	}

	// Returns this picture
	public Image getPicture() {
		return picture;
	}

	// Sets this picture
	public void setPicture(Image picture) {
		this.picture = picture;
	}

	// Returns this name
	public String getName() {
		return name;
	}

	// Draws this sprite
	public void draw(Graphics g) {
//		g.drawImage(getPicture(), getX(), getY(), null);
		g.drawImage(getPicture(), getX(), getY(), getWidth(), getHeight(), null, null);
	}

	// Returns width
	public int getWidth() {
		return picWidth;
	}

	// Returns height
	public int getHeight() {
		return picHeight;
	}
}
