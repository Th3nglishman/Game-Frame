import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class ColorWheel extends GraphicsGame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private Rectangle uL, uR, lL, lR, center, scoreboard, pointboard, restart;
	private boolean firstTime;
	private int width, height;
	private int time, rand1, rand2, rand3, rand4, pointTrack;
	private Timer timer;
	private Timer timer2;
	private String points, UL, UR, LL, LR;
	private boolean passed4;
	private boolean passed1;
	private boolean passed2;
	private boolean passed3;
	private boolean triumph;
	private boolean different;
	private int rand5;
	private int timehit;
	private boolean gameOver;
	private Rectangle whiteArea;
	private boolean roundOver;

	private int MAX_TIME;

	private boolean userClicked;

	private boolean lRClicked;

	private boolean lLClicked;

	private boolean uRClicked;

	private boolean uLClicked;

	private boolean printTime;

	private int timeLeft;

	private int roundBegin;

	public ColorWheel(Coordinates size) {
		firstTime = true;
		width = size.getX();
		height = size.getY();
		this.setBackground(Color.BLACK);
		time = 0;
		timer = new Timer(1000, this);
		timer2 = new Timer(3000, this);

		timer.setRepeats(true);
		timer2.setRepeats(true);

		scoreboard = new Rectangle((width * 4 / 5), 0, width / 5, height);
		pointboard = new Rectangle(scoreboard.x + scoreboard.width / 5, scoreboard.height / 5, scoreboard.width * 3 / 5,
				scoreboard.height / 10);

		uL = new Rectangle(0, 0, scoreboard.x / 2, (height * 2 / 5));
		uR = new Rectangle(uL.width, 0, uL.width, uL.height);
		lL = new Rectangle(0, height * 3 / 5, uL.width, uL.height);
		lR = new Rectangle(uL.width, lL.y, uL.width, uL.height);
		center = new Rectangle(0, uL.height, scoreboard.x, uL.height / 2);
		whiteArea = new Rectangle(pointboard.x, pointboard.y, pointboard.width, height / 10);

		restart = new Rectangle(center.x + center.width / 3, (center.y + center.height * 3 / 2), center.width / 3,
				center.width / 20);

		addMouseListener((MouseListener) this);
		roundOver = true;
		pointTrack = 0;
		points = "Pts: " + pointTrack + "";
		MAX_TIME = ((2 * 60) + 30);
		printTime = true;

	}

	public void testVariables() {
		System.out.println("passed1 = " + passed1);
		System.out.println("passed2 = " + passed1);
		System.out.println("passed3 = " + passed1);
		System.out.println("passed4 = " + passed1);
		System.out.println("----------------");
		System.out.println("booleans");
		System.out.println("triumph = " + triumph);
		System.out.println("is timer running" + timer.isRunning());

	}

	public static void pause(int pause) {
		try {
			Thread.sleep(pause);
		} catch (Exception e) {
		}
	}

	public void countDown(Graphics g) {

		if (passed1) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			g.drawString("3", center.x + center.width / 2, center.y + center.height / 2);
			passed1 = false;
			pause(1000);

		}
		if (passed2) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, scoreboard.x, height);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			g.drawString("2", center.x + center.width / 2, center.y + center.height / 2);
			passed2 = false;
			pause(1000);

		}
		if (passed3) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, scoreboard.x, height);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			g.drawString("1", center.x + center.width / 2, center.y + center.height / 2);
			passed3 = false;
			pause(1000);

		}
		if (passed4) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, scoreboard.x, height);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			g.drawString("GO", center.x + center.width / 2, center.y + center.height / 2);
			passed4 = false;
			pause(1000);
			firstTime = false;

		}
	}

	public void randomize() {
		rand1 = (int) (Math.random() * 7 + 1);
		rand2 = (int) (Math.random() * 7 + 1);
		rand3 = (int) (Math.random() * 7 + 1);
		rand4 = (int) (Math.random() * 7 + 1);

		// changer
		while (rand1 == rand2 || rand1 == rand3 || rand1 == rand4) {
			rand1 = (int) (Math.random() * 8 + 1);
		}
		while (rand2 == rand1 || rand2 == rand3 || rand2 == rand4) {
			rand2 = (int) (Math.random() * 8 + 1);
		}
		while (rand3 == rand1 || rand3 == rand2 || rand3 == rand4) {
			rand3 = (int) (Math.random() * 8 + 1);
		}
	}

	public void pickWinner() {
		rand5 = (int) (Math.random() * 4 + 1);
		/// System.out.println(rand1 + " "+ rand2 + " "+ rand3 + " "+ rand4);
		// System.out.println("Winner is " + rand5);

		if (rand5 == 1) {
			decipher(rand1);
		}
		if (rand5 == 2) {
			decipher(rand2);
		}
		if (rand5 == 3) {
			decipher(rand3);
		}
		if (rand5 == 4) {
			decipher(rand4);
		}
		System.out.println("Winner is = " + rand5);
	}

	public void printWinnerStr(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));

		if (rand5 == 1)
			g.drawString(decipher(rand1), center.x + center.width / 2, center.y + center.height / 2);
		if (rand5 == 2)
			g.drawString(decipher(rand2), center.x + center.width / 2, center.y + center.height / 2);
		if (rand5 == 3)
			g.drawString(decipher(rand3), center.x + center.width / 2, center.y + center.height / 2);
		if (rand5 == 4)
			g.drawString(decipher(rand4), center.x + center.width / 2, center.y + center.height / 2);

	}

	public void printScreen(Graphics g) {
g.clearRect(0, uL.y, scoreboard.x, uL.height);
g.clearRect(0, lL.y, scoreboard.x, uL.height);
		setColor(g, decipher(rand1));
		g.fillRect(uL.x, uL.y, uL.width, uL.height);

		setColor(g, decipher(rand2));
		g.fillRect(uR.x, uR.y, uR.width, uR.height);

		setColor(g, decipher(rand3));
		g.fillRect(lL.x, lL.y, lL.width, lL.height);

		setColor(g, decipher(rand4));
		g.fillRect(lR.x, lR.y, lR.width, lR.height);

	}

	public String updatePoints() {
		points = "Pts: " + pointTrack + "";
		return points;

	}

	public void printVictory(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, scoreboard.x, height);
		//
		g.setColor(Color.WHITE);
		g.fillRoundRect(whiteArea.x, whiteArea.y, whiteArea.width, whiteArea.height, 20, 20);
		g.setColor(Color.BLACK);

		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.drawString("+1000 pts", (center.x + (center.width / 2)), (center.y + (center.height / 4)));
		pointTrack += 1000;
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString(updatePoints(), whiteArea.x, whiteArea.y + whiteArea.height / 2);
		g.drawLine(scoreboard.x, 0, scoreboard.x, height);
		printTime(g);

	}

	public void printDefeat(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, scoreboard.x, height);
		g.setColor(Color.WHITE);
		g.fillRoundRect(whiteArea.x, whiteArea.y, whiteArea.width, whiteArea.height, 20, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString(updatePoints(), whiteArea.x, whiteArea.y + whiteArea.height / 2);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.setColor(Color.WHITE);
		g.drawString("DEFEAT", (center.x + (center.width / 2)), (center.y + (center.height / 4)));
		g.drawLine(scoreboard.x, 0, scoreboard.x, height);
		printTime(g);

	}

	public void displayGameOver(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, scoreboard.width, scoreboard.height);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("GAME OVER", (center.x + center.width / 2), (center.y + center.height / 2));

//		g.drawString("PLAY AGAIN?", center.x, (center.y + (center.width * 3 / 2)));
//		g.fillRect(restart.x, restart.y, restart.width, restart.height);
		// need a restart image drawn here

	}

	private String decipher(int x) {
		// TODO Auto-generated method stub
		String correct;
		if (x == 1)
			correct = "RED";
		else if (x == 2)
			correct = "BLUE";
		else if (x == 3)
			correct = "GREEN";
		else if (x == 4)
			correct = "YELLOW";
		else if (x == 5)
			correct = "ORANGE";
		else if (x == 6)
			correct = "MAGENTA";
		else if (x == 7)
			correct = "PINK";
		else
			correct = "CYAN";
		return correct;
	}

	private void setColor(Graphics g, String s) {
		if (s == "RED")// 1
			g.setColor(Color.RED);
		else if (s == "BLUE")// 2
			g.setColor(Color.BLUE);
		else if (s == "GREEN")// 3
			g.setColor(Color.GREEN);
		else if (s == "YELLOW")// 4
			g.setColor(Color.YELLOW);
		else if (s == "ORANGE")// 5
			g.setColor(Color.ORANGE);
		else if (s == "MAGENTA")// 6
			g.setColor(Color.MAGENTA);
		else if (s == "PINK")// 7
			g.setColor(Color.PINK);
		else // 8
			g.setColor(Color.CYAN);
	}

	private void withinTimeLimit() {
		// empty
	}

	public void checkifWin() {

		if (rand5 == 1 && uLClicked && (timeLeft) <= 15)
			triumph = true;

		else if (rand5 == 2 && uRClicked && (timeLeft) <= 15)
			triumph = true;

		else if (rand5 == 3 && lLClicked && (timeLeft) <= 15)
			triumph = true;

		else if (rand5 == 4 && lRClicked && (timeLeft) <= 15)
			triumph = true;
		else {
			triumph = false;
		}

	}

	public void printTime(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(scoreboard.x + scoreboard.width / 2, (scoreboard.y - scoreboard.height / 4), 50, 50);
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("Time: "+time + "", scoreboard.x + scoreboard.width / 2, (scoreboard.y - scoreboard.height / 4));

	}

	public void setupScoreboard(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, scoreboard.height);

		g.setColor(Color.WHITE);
		g.fillRoundRect(whiteArea.x, whiteArea.y, whiteArea.width, whiteArea.height, 20, 20);
		g.drawLine(scoreboard.x, 0, scoreboard.x, height);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g.drawString("Time: "+time + "", scoreboard.x, (scoreboard.y + scoreboard.height / 10));
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString(points, pointboard.x, (pointboard.y + pointboard.height / 2));

	}

	// the graphics section
	public void paintComponent(Graphics g) {
		// always runs

		setupScoreboard(g);
		if (gameOver) {
			displayGameOver(g);
			timer.stop();
		} else if (!gameOver) {

			// game is not over

			if (firstTime) {// for the first time the game runs
				timer.start();
				countDown(g);
			} else {// for all other times
				
				if (userClicked) {
					checkifWin();
					if (triumph)
						printVictory(g);
					else {
						gameOver = true;
						repaint();					
						}
					pause(1000);
					roundOver = true;
					userClicked = false;
				}
				if (roundOver) {
					randomize();
					pickWinner();
					printWinnerStr(g);
					pause(1000);
					printScreen(g);
					timeLeft = 15;
					roundOver = false;
					roundBegin = time;
				} else {
					
					printWinnerStr(g);
					printScreen(g);
					if (timeLeft == 0) {
						roundOver = true;
						repaint();
					}
				}

				// = time;
				// withinTimeLimit();
				//
				// System.out.println(!roundOver + "&" + userClicked);
				//
				// if (userClicked) {
				// if (!roundOver) {
				// // check if they won
				// checkifWin();
				// if (triumph)
				// printVictory(g);
				// else
				// printDefeat(g);
				// roundOver = true;
				// pause(1000);
				// repaint();
				// } else {
				// printDefeat(g);
				// }
				// } else {
				// if (roundOver)
				// printDefeat(g);
				// else
				// repaint();
				// }

				// if(userClicked) {
				// determine if they clicked the right box
				// if so set triumph to true
				// else check if time for the round is up
				// if (max round time exceeded)
				// then repaint
				// }

			}
		}
	}

	// mouse & timer related methods
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		time++;
		if (timeLeft > 0)
			timeLeft--;
		System.out.println("time is" + time + " Round begin at: " + roundBegin + " time left in round = " + timeLeft);
		if (time >= MAX_TIME) {
			gameOver = true;
		}
		if (timeLeft == 0) {
			roundOver = true;
			repaint();
		}
		if (time == 1) {
			passed1 = true;
			repaint();
		} else if (time == 2) {
			passed2 = true;
			repaint();
		} else if (time == 3) {
			passed3 = true;
			repaint();
		} else if (time == 4) {
			passed4 = true;
			repaint();
		} else if (time == 5) {
			repaint();
		}
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
		userClicked = true;
		// System.out.println("clicked");
		timehit = time;
		if (uL.contains(x, y)) {
			uLClicked = true;		
		} else if (uR.contains(x, y)) {
			uRClicked = true;		
		} else if (lL.contains(x, y)) {
			lLClicked = true;		
		} else if (lR.contains(x, y)) {
			lRClicked = true;			
		} 
		System.out.println("Time hit= " + timehit);

		if (userClicked) {			
			repaint();
		}
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
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
