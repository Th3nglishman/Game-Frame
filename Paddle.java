import java.awt.Image;

/*
Name: Paddle
Description: is a paddle object
*/

public class Paddle extends MoveableSprite {
	//	**Feilds**
	private int ballY;
	
	
	//	**Constructors**
	public Paddle(Image pic, int x, int y) {
		super(pic, x, y);
	}
	
	// Sets ball Y
	public void setBallY(Ball pongBall) {
		ballY=(pongBall.getY()-(pongBall.getHeight()/2));
	}
	
	// 
	public boolean moveUp() {
		if ((this.getY()+(this.getHeight()/2))<ballY) {
			return false;
		}
		else 
			return true;
	}
}
