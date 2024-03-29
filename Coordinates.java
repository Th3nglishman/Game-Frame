

import java.awt.geom.AffineTransform;

/*
Name: Coordinates
Description: Stores x,y and useful operations on said coordinates
*/

public class Coordinates {
	//	**Feilds**
	private int x, y;
	private AffineTransform coordTransform;

	
	//	**Constructors**
	public Coordinates(int xInput, int yInput) {
		x = xInput;
		y = yInput;
		coordTransform = new AffineTransform();
	}
	
	
	//	**Methods**
	
	// Public methods

	// Set X value
	public void setX(int xInput) {
		x = xInput;
	}

	// Set Y value
	public void setY(int yInput) {
		y = yInput;
	}

	// Returns X value
	public int getX() {
		return x;
	}

	// Returns Y value
	public int getY() {
		return y;
	}

	// Shifts coordinates
	public void coordinateShift(double dx, double dy) {
		coordTransform.translate(dx, dy);
	}

	// Shifts horizontally
	public void horizontalShift(double dx) {
		coordTransform.translate(dx, 0);
	}

	// Shifts vertically
	public void verticalShift(double dy) {
		coordTransform.translate(0, dy);
	}

	// Returns the coordinate transformer
	public Coordinates getCoordinates() {
		return new Coordinates(x, y);
	}
	
	// Returns this transform
	public AffineTransform getAffineTransform() {
		return coordTransform;
	}
}
