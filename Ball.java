import java.awt.Image;

/*
Name: Ball
Description: Is a ball object
*/

public class Ball extends MoveableSprite {
	//	**Feilds**
	private int angle;
	private int speed;
	private int speedPoint;
	private Ball lastBall;
	
	
	//	**Constructors**
	public Ball(Image pic, int x, int y) {
		super(pic, x, y);
		speed=5;
	}
	
	public Ball(Image pic, int x, int y, int width, int height) {
		super(pic, x, y,width,height);
		speed=5;
	}
	
	//	**Methods**

	// Public methods
	
	// Returns this ball's angle
	public int getAngle() {
		return angle;
	}

	// Sets this ball's angle
	public void setAngle(int angle) {
		this.angle = angle % 360;
	}

	// Generates this ball's starting angle
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

	// Tests the above code
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

	// Returns this ball's speed
	public int getSpeed() {
		return speed;
	}

	// Sets this balls speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// Returns the last ball
	public Ball getLastBall() {
		return lastBall;
	}

	// Sets this ball as the last one
	public void setLastBall(Ball lastBall) {
		this.lastBall = lastBall;
	}
	
	// Moves this ball
	public void moveBall() {
		this.setX(getX()+speed);
//		System.out.println(speed);
	}
	
	// Moves this ball 
	public void moveBall(int movement) {
		this.setX(getX()+movement);
//		System.out.println(speed);
	}

	// Reverses ball speed
	public void reverseSpeed() {
		speed=speed*-1;
	}
	
	// Adds a speed
	public void addSpeed() {
		if (speed<0&&speedPoint==4) {
			speed-=1;
			speedPoint=0;
		}
		else if (speedPoint==4) {
			speed+=1;
			speedPoint=0;
		}
		else if (4<speedPoint) {
			speedPoint=4;
		}
		else {
			speedPoint++;
		}
	}
}
