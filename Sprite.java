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
		width=img.getWidth(null);
		height=img.getHeight(null);
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
		width=img.getWidth(null);
		height=img.getHeight(null);
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
	
	// Checks collisions
	public boolean checkCollision(Sprite other){
		boolean result=false;
		for (int x = getX(); x < (getX() + getWidth()); x++) {
			for (int y = getY(); y < (getY() + getHeight()); y++) {
				for (int x2 = other.getX(); x2 < (other.getX() + other.getWidth()); x2++) {
					for (int y2 = other.getY(); y2 < (other.getY() + other.getHeight()); y2++) {
						if (x==x2&&y==y2) {
							result = true;
							return result;
						}
					}
				}
			}
		}
		return result;
	}
	
	// Draws this
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(picture, getX(), getY(),width,height, io);
	}

	// Rotates the sprite by some degrees
	public void rotateDegrees(double degrees) {
		double radians = (degrees * PI / 180);
		this.getAffineTransform().rotate(radians, getWidth() / 2, getHeight() / 2);
	}

	// Rotates the sprite by some radians
	public void rotateRadians(double radians) {
		this.getAffineTransform().rotate(radians, getWidth() / 2, getHeight() / 2);
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
	// Returns image
	public Image getImage() {
		return picture;
	}
}
