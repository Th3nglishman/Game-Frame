

//Provides a System of Coordinates to create one Coordinate System link
public class CoordinateSystem {
	public static final double PI = Math.PI;

	private Coordinates topLeft;
	private Coordinates topRight;
	private Coordinates bottomLeft;
	private Coordinates bottomRight;
	private Coordinates center;

	private int width;
	private int height;

	// Constructor
	public CoordinateSystem(int x, int y, int xDimension, int yDimension) {

		topLeft = new Coordinates(x, y);
		topRight = new Coordinates(xDimension, y);
		bottomLeft = new Coordinates(x, yDimension);
		bottomRight = new Coordinates(xDimension, yDimension);

		width = xDimension - x;
		height = yDimension - y;

		center = new Coordinates(x + width / 2, y + height / 2);
	}

	// Rotates the system in radians
	public void rotateRadians(double radians) {
		topLeft.getCoordinates().rotate(radians, center.getX(), center.getY());
		topRight.getCoordinates().rotate(radians, center.getX(), center.getY());
		bottomLeft.getCoordinates().rotate(radians, center.getX(), center.getY());
		bottomRight.getCoordinates().rotate(radians, center.getX(), center.getY());
	}

	// Rotates the system in degrees
	public void rotateDegrees(double degrees) {
		rotateRadians(degrees * PI / 180);
	}

	// Returns center
	public Coordinates getCenter() {
		return center;
	}

	// Returns top left
	public Coordinates getTopLeft() {
		return topLeft;
	}

	// Returns top right
	public Coordinates getTopRight() {
		return topRight;
	}

	// Returns bottom left
	public Coordinates getBottomLeft() {
		return bottomLeft;
	}

	// Returns bottom right
	public Coordinates getBottomRight() {
		return bottomRight;
	}
}
