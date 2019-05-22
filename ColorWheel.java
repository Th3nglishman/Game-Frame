import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorWheel extends GraphicsGame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Notes:
	// there are 13 colors java can print
	// some trouble on incorporating time into game
	
	private Rectangle uL;
	private Rectangle uR;
	private Rectangle lR;
	private Rectangle lL;
	private Rectangle center;
	private Rectangle scoreboard;
	private Rectangle pointTally;
	private Rectangle levels;
	private Rectangle restart;

	private boolean uLclicked;
	private boolean uRclicked;
	private boolean lLclicked;
	private boolean lRclicked;

	
	private String upRText;
	private String upLText;
	private String lRText;
	private String lLText;
	private final int MAX_TIME = 15;
	private boolean passed;
	
	
	private String BoxColor;
	
	private int xCenter;
	private int yCenter;

	private Color correct;
	private Color uLC;
	private Color uRC;
	private Color lLC;
	private Color lRC;
	private Color clr1;
	private boolean triumph;

	private int correctBox;

	double rand;
	int random;

	private Timer timer;

	public ColorWheel(Coordinates size) {

		xCenter = getWidth() / 2;
		yCenter = getHeight() / 2;
		timer = new Timer(30, this);
		timer.setRepeats(true);
		timer.addActionListener(this);
		this.setBackground(Color.WHITE);
		triumph = false;
		repaint();
	}
	public String getName() {
		return "ColorWheel";
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		scoreboard = new Rectangle(getHeight()*4/5, 0, getHeight()/5, getHeight());
		pointTally = new Rectangle(scoreboard.x + scoreboard.x/40,scoreboard.y + scoreboard.y/10,	scoreboard.x*38/40,scoreboard.y/10);
		levels = new Rectangle(pointTally.x, (pointTally.y + pointTally.width*2),pointTally.width,pointTally.height);
		restart = new Rectangle(levels.x, (levels.x + levels.width*2), levels.width, levels.height);

		uL = new Rectangle(0, 0, getWidth()*2/5, getHeight()*2/5);
		uR = new Rectangle(getWidth()*2/5, 0, getWidth()*2/5, getHeight()*2/5);
		center = new Rectangle(0, getHeight()*2/5, getWidth()*4/5, getHeight()/5);
		lL = new Rectangle(0, getHeight()*3/5, getWidth()*2/5, getHeight()*2/5);
		lR = new Rectangle(getWidth()*2/5,getHeight()*3/5, getWidth()*2/5, getHeight()*2/5);
		
		//changeColor(uLC);
		
		g.setColor(Color.BLUE);
		g.fillRect(uL.x, uL.y, uL.width, uL.height);
		
		//changeColor(uRC);
		
		g.setColor(Color.RED);
		g.fillRect(uR.x, uR.y, uR.width, uR.height);
		
		//changeColor(lLC);
		
		g.setColor(Color.GREEN);
		g.fillRect(lL.x, lL.y, lL.width, lL.height);
		
		//changeColor(lRC);
		
		g.setColor(Color.YELLOW);
		g.fillRect(lR.x,lR.y, lR.width, lR.height);
		
		g.setColor(Color.BLACK);
		g.fillRect(center.x, center.y, center.width, center.height);
		g.setColor(Color.WHITE);
		g.drawString("to be filled", (int)center.getCenterX()/2, (int)center.getCenterY());
		
		int start = (int) (System.currentTimeMillis()/1000);
		
		random = (int)(Math.random() * 4);
		
		switch(random) {
		case 0:
			correct = uLC;
		case 1:
			correct = uRC;		
		case 2:
			correct = lLC;	
		default:
			correct = lRC;	
		}
		//incorporate timer
		
		 int stop =(int) (System.currentTimeMillis()/1000);
		
		if((stop - start)<=15) 
			passed = true;
		
		else
			passed = false;
		 
		if(uLclicked && (correct == uLC)&&passed)
			triumph = true;
		else if(uRclicked && (correct == uRC)&&passed)
			triumph = true;
		else if(lLclicked && (correct == lLC)&&passed)
			triumph = true;
		else if(lRclicked && (correct == lRC)&&passed)
			triumph = true;
		
		g.setFont(Font.getFont("Arial"));
	//	g.setColor(Color.BLACK);
		
		if(triumph)
			g.drawString("VICTORY!", (int)center.getCenterX(), (int)center.getCenterY());
		else
			g.drawString("FAIL", (int)center.getCenterX(), (int)center.getCenterY());
			
		
		
		
		
			

	}

	public Color changeColor(Color clr) {
		clr1 = clr;
		/*
		 * RED = 1 BLUE = 2 GREEEN = 3 YELLOW = 4 GREY = 5 WHITE = 6 BLACK = 7 MAGENTA =
		 * 8 PINK = 9 CYAN = 10 ORANGE = 11
		 * 
		 */
		int x;

		correctBox = (int) (Math.random() * 5);// which box is correct

		x = (int) (Math.random() * 12);
		//System.out.println("X is = " + x);
		//System.out.println("Correct box is " + correctBox);

		switch (x) {
		case 0:
			BoxColor = "RED";
			clr1 = Color.RED;
			break;
		case 1:
			BoxColor = "BLUE";
			clr1 = Color.BLUE;
			break;
		case 2:
			BoxColor = "GREEN";
			clr1 = Color.GREEN;
			break;
		case 3:
			BoxColor = "YELLOW";
			clr1 = Color.YELLOW;
			break;
		case 4:
			BoxColor = "GRAY";
			clr1 = Color.GRAY;
			break;
		case 5:
			BoxColor = "WHITE";
			clr1 = Color.WHITE;
			break;
		case 6:
			BoxColor = "BLACK";
			clr1 = Color.BLACK;
			break;
		case 7:
			BoxColor = "MAGENTA";
			clr = Color.MAGENTA;
			break;
		case 8:
			BoxColor = "PINK";
			clr1 = Color.PINK;
			break;
		case 9:
			BoxColor = "CYAN";
			clr1 = Color.CYAN;
			break;
		default:
			BoxColor = "ORANGE";
			clr1 = Color.ORANGE;
			break;
		}
		return clr1;

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
		if (Constants.TEST) {
			System.out.println("X = " + x + "Y = " + y);
		}
		if (uL.contains(x, y)) {
			uLclicked = true;
		} else if (uR.contains(x, y)) {
			uRclicked = true;
		} else if (lL.contains(x, y)) {
			lLclicked = true;
		} else if (lR.contains(x, y)) {
			lRclicked = true;
		}
		else if(levels.contains(x, y)) {
			//change level
		}
		else if(restart.contains(x, y)) {
			//restart level
		}
	//	timer.stop();
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	public Color getBackground() {
		// TODO Auto-generated method stub
		return Color.WHITE;
	}
}
