import java.awt.Image;

public class Ball extends Sprite {
	private int angle;
	private Direction currentDirection;
	private Image picture;

	private enum Direction {
		RIGHT, LEFT, INFINITE
	}

	public Ball(Image pic, int x, int y) {
		super(pic, x, y);
		picture=pic;
	}

	// @return the angle
	public int getAngle() {
		return angle;
	}

	// @param angle the angle to set
	public void setAngle(int angle) {
		this.angle = angle;
	}

	// @return the currentDirection
	public Direction getCurrentDirection() {
		return currentDirection;
	}

	// @param currentDirection the currentDirection to set
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
	
	// @param currentDirection toggled left to right (nothing if infinite)
	public void toggleCurrentDirection() {
		if(this.currentDirection.equals(Direction.LEFT)) {
			this.currentDirection=Direction.RIGHT;
		}
		else if(this.currentDirection.equals(Direction.RIGHT)) {
			this.currentDirection=Direction.LEFT;
		}
	}
	
	public int getWidth() {
		picture.
	}

}
