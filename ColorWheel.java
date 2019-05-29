import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

public class ColorWheel extends GraphicsGame implements ActionListener, MouseListener {
	private Rectangle uL, uR, lL, lR, center, scoreboard, pointboard;
	private boolean firstTime;
	private int width, height;
	private int time, rand1, rand2, rand3, rand4;
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
		addMouseListener((MouseListener) this);

		points = "Pts: ?";

	}

	public static void pause(int pause) {
		try {
			Thread.sleep(pause);
		} catch (Exception e) {
		}
	}

	public void paintComponent(Graphics g) {

		if (!triumph) {
			// the setup
			// testLayout(g);
			timer.start();
			if (firstTime) {
				// set up Rectangles	
				
				if (passed1) {
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.BOLD, 50));
					g.drawString("3", center.x + center.width / 2, center.y + center.height / 2);
					passed1 = false;
					pause(1000);
				}
				if (passed2) {
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, width, height);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.BOLD, 50));
					g.drawString("2", center.x + center.width / 2, center.y + center.height / 2);
					passed2 = false;
					pause(1000);
				}
				if (passed3) {
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, width, height);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.BOLD, 50));
					g.drawString("1", center.x + center.width / 2, center.y + center.height / 2);
					passed3 = false;
					pause(1000);
				}
				if (passed4) {
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, width, height);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.BOLD, 50));
					g.drawString("GO", center.x + center.width / 2, center.y + center.height / 2);
					passed4 = false;
					pause(1000);
					firstTime = false;
					timer.setDelay(15000);
					

				}
			} else {
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
				// picking a winner

				rand5 = (int) (Math.random() * 4 + 1);
			///	System.out.println(rand1 + " "+ rand2 + " "+ rand3 + " "+ rand4);
			//	System.out.println("Winner is " + rand5);
				
				if(rand5 == 1) {
					decipher(rand1);
				}
				if(rand5 == 2) {
					decipher(rand2);
				}
				if(rand5 == 3) {
					decipher(rand3);
				}
				if(rand5 == 4) {
					decipher(rand4);
				}
				
				
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("TimesRoman", Font.BOLD, 50));
				
				if (time > 5) {

					if (rand5 == 1)
						g.drawString(decipher(rand1), center.x + center.width / 2, center.y + center.height / 2);
					if (rand5 == 2)
						g.drawString(decipher(rand2), center.x + center.width / 2, center.y + center.height / 2);
					if (rand5 == 3)
						g.drawString(decipher(rand3), center.x + center.width / 2, center.y + center.height / 2);
					if (rand5 == 4)
						g.drawString(decipher(rand4), center.x + center.width / 2, center.y + center.height / 2);

					pause(1000);
					
					repaint();
				}
			//if(time)
				g.setColor(Color.BLACK);
				g.drawRect(scoreboard.x, scoreboard.y, scoreboard.width, scoreboard.height);
				g.setColor(Color.WHITE);
				g.fillRoundRect(pointboard.x, pointboard.y, pointboard.width, height/10, 20, 20);
				setColor(g,decipher(rand1));
				g.fillRect(uL.x, uL.y, uL.width, uL.height);
				
				setColor(g,decipher(rand2));
				g.fillRect(uR.x, uR.y, uR.width, uR.height);
				
				
				setColor(g,decipher(rand3));
				g.fillRect(lL.x, lL.y, lL.width, lL.height);
				
				
				setColor(g,decipher(rand4));
				g.fillRect(lR.x, lR.y, lR.width, lR.height);
				
				// now ready to print
				
			}

		}
		else {
			
			
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
			// picking a winner

			rand5 = (int) (Math.random() * 4 + 1);
		///	System.out.println(rand1 + " "+ rand2 + " "+ rand3 + " "+ rand4);
		//	System.out.println("Winner is " + rand5);
			
			if(rand5 == 1) {
				decipher(rand1);
			}
			if(rand5 == 2) {
				decipher(rand2);
			}
			if(rand5 == 3) {
				decipher(rand3);
			}
			if(rand5 == 4) {
				decipher(rand4);
			}
			
			
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			
			if (time > 5) {

				if (rand5 == 1)
					g.drawString(decipher(rand1), center.x + center.width / 2, center.y + center.height / 2);
				if (rand5 == 2)
					g.drawString(decipher(rand2), center.x + center.width / 2, center.y + center.height / 2);
				if (rand5 == 3)
					g.drawString(decipher(rand3), center.x + center.width / 2, center.y + center.height / 2);
				if (rand5 == 4)
					g.drawString(decipher(rand4), center.x + center.width / 2, center.y + center.height / 2);

				pause(1000);
				
				repaint();
			}
		//if(time)
			g.setColor(Color.BLACK);
			g.drawRect(scoreboard.x, scoreboard.y, scoreboard.width, scoreboard.height);
			g.setColor(Color.WHITE);
			g.fillRoundRect(pointboard.x, pointboard.y, pointboard.width, height/10, 20, 20);
			setColor(g,decipher(rand1));
			g.fillRect(uL.x, uL.y, uL.width, uL.height);
			
			setColor(g,decipher(rand2));
			g.fillRect(uR.x, uR.y, uR.width, uR.height);
			
			
			setColor(g,decipher(rand3));
			g.fillRect(lL.x, lL.y, lL.width, lL.height);
			
			
			setColor(g,decipher(rand4));
			g.fillRect(lR.x, lR.y, lR.width, lR.height);
		}

	}

	private String decipher(int x) {
		// TODO Auto-generated method stub
		String correct;
		if(x == 1)
			correct = "RED";
		else if(x == 2)
			correct = "BLUE";
		else if(x == 3)
			correct = "GREEN";
		else if(x == 4)
			correct = "YELLOW";
		else if(x == 5)
			correct = "ORANGE";
		else if(x == 6)
			correct = "MAGENTA";
		else if(x == 7)
			correct = "PINK";
		else 
			correct = "CYAN";
		return correct;
	}
	private void setColor(Graphics g, String s) {
		if(s== "RED")//1
			g.setColor(Color.RED);
		else if (s=="BLUE")//2
			g.setColor(Color.BLUE);
		else if (s=="GREEN")//3
			g.setColor(Color.GREEN);
		else if (s=="YELLOW")//4
			g.setColor(Color.YELLOW);
		else if (s=="ORANGE")//5
			g.setColor(Color.ORANGE);
		else if (s=="MAGENTA")//6
			g.setColor(Color.MAGENTA);
		else if (s=="PINK")//7
			g.setColor(Color.PINK);
		else  //8
			g.setColor(Color.CYAN);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		time++;
		System.out.println(time + " " + firstTime);

		if (time == 1) {
			passed1 = true;
			repaint();
		}
		if (time == 2) {
			passed2 = true;
			repaint();
		}
		if (time == 3) {
			passed3 = true;
			repaint();
		}

		if (time == 4) {
			passed4 = true;
			repaint();
		}

		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
		// System.out.println("clicked");

		if (uL.contains(x, y)&& time <15) {
			triumph = true;
		} else if (uR.contains(x, y) && time < 15) {
			triumph = true;
		} else if (lL.contains(x, y) && time < 15) {
			triumph = true;
		} else if (lR.contains(x, y) && time < 15) {
			triumph = true;
		} else {
			triumph = false;
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
