import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/*
Name: Sprite
Description: Provides a base Sprite class
*/

public class Sprite extends Coordinates {
	//	**Feilds**
	public static final double PI = Math.PI;
	private int height;
	private int width;
	private String name;
	private Image picture;
	
	
	//	**Constructors**
	public Sprite(Image img, int x, int y) {
		super(x, y);
		picture = img;
		super.setX(x);
		super.setY(y);
	}

	public Sprite(Image img, int x, int y, int width, int height) {
		super(x, y);
		picture = img.getScaledInstance(width, height, 0);
		super.setX(x);
		super.setY(y);
	}
	
	public Sprite(Image img, int x, int y, String nameInput) {
		super(x, y);
		picture = img;
		super.setX(x);
		super.setY(y);
		name=nameInput;
	}

	public Sprite(Image img, int x, int y, int width, int height, String nameInput) {
		super(x, y);
		picture = img.getScaledInstance(width, height, 0);
		super.setX(x);
		super.setY(y);
		name=nameInput;
	}
	
	
	//	**Methods**
	
	// Public methods
	
	// Draws this
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(picture, getX(), getY(),width,height, io);
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
	
	// Sets width
	public void setWidth(int widthInput) {
		width=widthInput;
	}
	
	// Sets height
	public void setHeight(int heightInput) {
		height=heightInput;
	}
	
	// Returns this picture
	public Image getPicture() {
		return picture;
	}

	// Sets this picture
	public void setPicture(Image pictureInput) {
		picture = pictureInput;
	}

	// Returns this name
	public String getName() {
		return name;
	}

	// Returns width
	public int getWidth() {
		return width;
	}

	// Returns height
	public int getHeight() {
		return height;
	}
}
