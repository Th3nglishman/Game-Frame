import java.awt.Image;

public class Ball extends MoveableThing {
	private int angle;
	private int speed;
	private Ball lastBall;

	public Ball(Image pic, int x, int y) {
		super(pic, x, y);
	}

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

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the lastBall
	 */
	public Ball getLastBall() {
		return lastBall;
	}

	/**
	 * @param lastBall the lastBall to set
	 */
	public void setLastBall(Ball lastBall) {
		this.lastBall = lastBall;
	}
}
