import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class ColorWheel extends GraphicsGame implements ActionListener, MouseListener {

	public boolean firstTime;

	private Rectangle uL, uR, lL, lR, center, scoreboard;

	int width, height, winner, boxClicked, random;

	private boolean uLWin, uRWin, lLWin, lRWin;

	Color uLc, uRc, lLc, lRc;
	int count;
	private String correctBoxClr;

	private boolean triumph;

	Color randomClr;

	private Timer timer;
	private int MAX_TIME = 15;
	private int time;

	private boolean clicked;

	public ColorWheel(Coordinates size) {
		firstTime = true;
		width = size.getX();
		height = size.getY();

		uLWin = false;
		uRWin = false;
		lLWin = false;
		lRWin = false;

		time = 0;
		timer = new Timer(1000, this);
		correctBoxClr = "";

		scoreboard = new Rectangle((width * 4 / 5), 0, width / 5, height);
		uL = new Rectangle(0, 0, scoreboard.x / 2, (height * 2 / 5));
		uR = new Rectangle(uL.width, 0, uL.width, uL.height);
		lL = new Rectangle(0, height * 3 / 5, uL.width, uL.height);
		lR = new Rectangle(uL.width, lL.y, uL.width, uL.height);
		center = new Rectangle(0, uL.height, scoreboard.x, uL.height / 2);
		addMouseListener(this);

	}

	public static void pause(int pause) {
		try {
			Thread.sleep(pause);
		} catch (Exception e) {
		}
	}

	public void createRect(Graphics g, Color c, Rectangle r) {
		g.setColor(c);
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	public void getRandomColor(Color c) {
		random = (int) (Math.random() * 7);

		switch (random) {
		case 0:
			randomClr = Color.BLUE;
			break;
		case 1:
			randomClr = Color.GREEN;
			break;
		case 2:
			randomClr = Color.CYAN;
			break;
		case 3:
			randomClr = Color.YELLOW;
			break;
		case 4:
			randomClr = Color.RED;
			break;
		case 5:
			randomClr = Color.ORANGE;
			break;
		case 6:
			randomClr = Color.MAGENTA;
			break;
		default:
			randomClr = Color.PINK;
			break;
		}
		count++;
		if (count == 1)
			uLc = randomClr;
		else if (count == 2)
			uRc = randomClr;
		else if (count == 3)
			lLc = randomClr;
		else if (count == 4)
			lRc = randomClr;

		checkSame(uLc, uRc, lLc, lRc);
	}

	public void checkSame(Color a, Color b, Color c, Color d) {
		if (a == b || a == c || a == d) {
			count = 0;
			getRandomColor(a);
		}
		if (b == c || b == d) {
			count = 1;
			getRandomColor(b);
		}
		if (c == d) {
			count = 2;
			getRandomColor(c);

		}
	}

	public void newBoard(Graphics g) {
		createRect(g, Color.WHITE, scoreboard);

		createRect(g, Color.BLUE, uL);

		createRect(g, Color.RED, uR);

		createRect(g, Color.GREEN, lL);

		createRect(g, Color.YELLOW, lR);
		createRect(g, Color.BLACK, center);
	}

	public void chooseCorrectBox() {
		winner = (int) (Math.random() * 4);
		switch (winner) {
		case 0:
			uLWin = true;
			break;
		case 1:
			uRWin = true;
			break;
		case 2:
			lLWin = true;
			break;
		default:
			lRWin = true;
			break;
		}
		System.out.println("Winner is " + winner);
	}

	public void checkIfWinner() {
		if (winner == boxClicked && time < MAX_TIME)
			triumph = true;
		else
			triumph = false;
	}

	public void paintComponent(Graphics g) {

		createRect(g, Color.WHITE, scoreboard);

		getRandomColor(uLc);
		getRandomColor(uRc);
		getRandomColor(lLc);
		getRandomColor(lRc);

		System.out.println(uLc + " " + uRc + " " + lLc + " " + lRc);
		createRect(g, uLc, uL);
		createRect(g, uRc, uR);
		createRect(g, lLc, lL);
		createRect(g, lRc, lR);

		createRect(g, Color.BLACK, center);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("RED", (center.width / 2), (center.y + (center.height / 2)));
		chooseCorrectBox();
		timer.start();
		//goes to Action perfomed


	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		// System.out.println(time);
		if (triumph) {
			timer.stop();
			count = 0;
			
			repaint();
		}

	}

	public Color getBackground() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ColorWheel";
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;
		x = e.getX();
		y = e.getY();
		
		clicked = true;
		System.out.println(clicked);
		if (uL.contains(x, y))
			boxClicked = 0;
		else if (uR.contains(x, y))
			boxClicked = 1;
		else if (lL.contains(x, y))
			boxClicked = 2;
		else if (lR.contains(x, y))
			boxClicked = 3;
		checkIfWinner();

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