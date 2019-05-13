import java.awt.Dimension;
import java.awt.Image;

public class Ball extends MoveableThing {
	private int angle;
	private int speed;

	public Ball(Image pic, int x, int y) {
		super(pic, x, y);
	}

//	public void move() {
//		Dimension movement = this.convertToFractionValue();
//
//	}
//
//	private int convertToFractionType() {
//		boolean xConvert = false;
//		boolean yConvert = true;
//		if (angle < 90) {
//			xConvert = false;
//			yConvert = true;
//		}
//
//		else if (angle > 90 && angle < 180) {
//			xConvert = true;
//			yConvert = true;
//		}
//
//		else if (angle > 180 && angle < 270) {
//			xConvert = true;
//			yConvert = false;
//		}
//
//		else if (angle > 270 && angle < 360) {
//			xConvert = false;
//			yConvert = false;
//		}
//		int instaVar = 0;
//		if (xConvert)
//			instaVar += 1;
//		if (yConvert)
//			instaVar += 2;
//		return instaVar;
//	}
//
//	private Dimension convertToFractionValue() {
//		if (angle < 0 || angle > 360)
//			return null;
//		int x = 0;
//		int y = 0;
//		int instanceX;
//		int instanceY;
//
//		if (!(this.checkCardinal() == -1)) {
//			if (this.checkCardinal() == 0) {
//				x = 1;
//				y = 0;
//			} 
//			
//			else if (this.checkCardinal() == 90) {
//				x = 0;
//				y = 1;
//			} 
//			
//			else if (this.checkCardinal() == 180) {
//				x = -1;
//				y = 0;
//			} 
//			
//			else if (this.checkCardinal() == 270) {
//				x = 0;
//				y = -1;
//			}
//		}
//		
//		else {
//			if (angle==45) {
//				x=1;
//				y=1;
//			}
//			else if(angle) {
//				
//			}
//		}
//		
//		return new Dimension(x, y);
//	}
//
//	private int checkCardinal() {
//		int complete = -1;
//		if (angle == 0) {
//			complete = 0;
//		}
//
//		else if (angle == 90) {
//			complete = 2;
//		}
//
//		else if (angle == 180) {
//			complete = 3;
//		}
//
//		else if (angle == 270) {
//			complete = 4;
//		}
//		return complete;
//	}

	// @return the angle
	public int getAngle() {
		return angle;
	}

	// @param angle the angle to set
	public void setAngle(int angle) {
		this.angle = angle % 360;
	}

	public void play() {
		int randomAngle = (int) (Math.random() * 180);
		if (randomAngle < 45) {
			randomAngle = 360 - randomAngle;
		}

		else if (randomAngle >= 45) {
			randomAngle = randomAngle - 45;
		}

		else if (randomAngle < 45 && randomAngle <= 180) {
			randomAngle += 45;
		}
		this.setAngle(randomAngle);
	}

	public String playTest() {
		String result = "";
		for (int f = 0; f < 100; f++) {
			int randomAngle = (int) (Math.random() * 180);
			if (randomAngle < 45) {
				randomAngle = 360 - randomAngle;
			}

			else if (randomAngle >= 45 && randomAngle <= 90) {
				randomAngle = randomAngle - 45;
			}

			else {
				randomAngle += 45;
			}
			if ((randomAngle < 135 && randomAngle > 45) || (randomAngle < 315 && randomAngle > 225)) {
				System.out.println("STRING 1");
			}
			result = (result + randomAngle + " ");
		}
		return result;
	}

//	private Direction currentDirection;

//	private enum Direction {
//		RIGHT, LEFT, INFINITE
//	}	
//	// @return the currentDirection
//	public Direction getCurrentDirection() {
//		return currentDirection;
//	}
//
//	// @param currentDirection the currentDirection to set
//	public void setCurrentDirection(Direction currentDirection) {
//		this.currentDirection = currentDirection;
//	}
//	
//	// @param currentDirection toggled left to right (nothing if infinite)
//	public void toggleCurrentDirection() {
//		if(this.currentDirection.equals(Direction.LEFT)) {
//			this.currentDirection=Direction.RIGHT;
//		}
//		else if(this.currentDirection.equals(Direction.RIGHT)) {
//			this.currentDirection=Direction.LEFT;
//		}
//	}

}
