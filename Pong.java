import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Pong extends GraphicsGame implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	private final int Width=1000;
	private final int Height=480;
	
	private static PongPhysics phys;
	private Ball ball;
	private Paddle left;
	private Paddle right;
	private int speed;

	@Override
	public String getName() {
		return "Pong";
	}

	@Override
	public void paintComponet(Graphics g) {
		super.paintComponent(g);
		phys.ballPhys(ball, speed, this.getWidth(), this.getHeight(), left, right);
		ball.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void run() {
		int w=this.getWidth();
		int h=this.getHeight();
		Image ballPic=(new ImageIcon("ball.gif").getImage()).getScaledInstance(w/50,h/20,0);
		Image paddlePic=(new ImageIcon("paddle.gif").getImage());
		ball=new Ball(ballPic,w/2,h/2);
		left=new Paddle(paddlePic,0,h/2);
		right=new Paddle(paddlePic,0,0);
	}

	@Override
	public int getWindowWidth() {
		return Width;
	}

	@Override
	public int getWindowHeight() {
		return Height;
	}
}
