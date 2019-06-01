import java.awt.AlphaComposite; //accounts for transparency
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
// 	Description: Acts as the main menu for all games
public class Menu extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	//Fields
	private Image play = new ImageIcon("resources/PLAY.png").getImage();
	private Image title = new ImageIcon("resources/TitleFrame.png").getImage();
	private Image greenButton = new ImageIcon("resources/GreenButton.png").getImage();
	private Image pressedButton = new ImageIcon("resources/PressedButton.png").getImage();
	private Image redButton = new ImageIcon("resources/redButton.png").getImage();
	private Image pressedRed = new ImageIcon("resources/RedButtonPressed.png").getImage();
	private Image gear = new ImageIcon("resources/GEAR.png").getImage();
	private Image SettingsFrame = new ImageIcon("resources/SettingsFrame.png").getImage();

	
	private Rectangle playPong;
	private Rectangle settings;
	private Rectangle playTextBased;
	private Rectangle playSettingsBased;
	private Rectangle Set1;
	private Rectangle Set2;
	private Rectangle Set3;
	private Rectangle exitMenu;

	private Container c;
	private JFrame w;
	private boolean releasedPong=false;
	private boolean clickedPong=false;
	private boolean clickedSettings=false;
	private boolean releasedSettings=false;
	private boolean releasedTextBased=false;
	private boolean clickedTextBased=false;
	private boolean releasedSettingsBased=false;
	private boolean clickedSettingsBased=false;
	private boolean inSettings=false;
	private boolean exitButtonDown=false;
	private boolean exitSettings=false;
	private boolean set1BD=false;
	private boolean set2BD=false;
	private boolean set3BD=false;

	public Menu () {
		addMouseListener(this);
		addMouseMotionListener(this);
	}	
	public void run() {	//Initiates windows
		w = new JFrame("Menu");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Menu menu = new Menu();
		menu.setBackground(Color.WHITE);

		c = w.getContentPane();
		c.add(menu);

		w.setResizable(false);
		w.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		int xUnit=this.getWidth()/16;
		int yUnit=this.getHeight()/16;
		
	if (inSettings) { 	//When in Settings, displays setting interface
								//Est. Settings menu interface
		g.drawImage(SettingsFrame,(int)(8*xUnit-323),(int)(7*yUnit-210), this);
		g.setColor(Color.GRAY);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f)); //Makes the drawn rectangles below transparent..
		Set1=new Rectangle((int)(8*xUnit-274),(int)(7*yUnit - 90), 146, 121);
		Set2=new Rectangle((int)(8*xUnit-74),(int)(7*yUnit - 90), 146, 121);
		Set3=new Rectangle((int)(8*xUnit+126),(int)(7*yUnit - 90), 146, 121);
		exitMenu=new Rectangle((int)(8*xUnit-274),(int)(7*yUnit + 187), 60, 60);
	  	g2d.fillRect(Set1.x, Set1.y, Set1.width, Set1.height);
	  	g2d.fillRect(Set2.x, Set2.y, Set2.width, Set2.height);
	  	g2d.fillRect(Set3.x, Set3.y, Set3.width, Set3.height);
	  	g2d.fillRect(exitMenu.x, exitMenu.y, exitMenu.width, exitMenu.height);
	  //establish the four buttons in Settings menu as invisible hitboxes
	  	
		}
	else if (!inSettings) { //When not in Settings, displays main interface
		g.drawImage(greenButton,(int)(8*xUnit-100),(int)(7*yUnit + 20), this);
		g.drawImage(redButton,(int)(8*xUnit-100),(int)(7*yUnit + 120), this);
		
		playPong=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		playTextBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		playSettingsBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		settings=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 120),200, 70);
		
		g.drawImage(play,(int)(8*xUnit-100),(int)(7*yUnit+20), this);
		g.drawImage(gear,(int)(8*xUnit-100),(int)(7*yUnit+120), this);
		g.drawImage(title,(int)(8*xUnit-323),(int)(7*yUnit-210), this);
		} 
	// Displays the button press-down animations for each button
		if(exitButtonDown) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g.fillRect((int)(8*xUnit-274),(int)(7*yUnit + 187), 60, 60);
		}
	
		if (clickedSettings) {
			g.drawImage(pressedRed,(int)(8*xUnit-100),(int)(7*yUnit+120), this);
			g.drawImage(gear,(int)(8*xUnit-100),(int)(7*yUnit+120), this);
		}
		if (clickedSettingsBased) {
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.YELLOW);
		}
		
		if (releasedSettingsBased) {
			clickedSettingsBased=false;
		}
		else {
			g.setColor(Color.GRAY);
		}
		
		if (releasedPong) {	//runs PONG when play button is pressed and released
			clickedPong=false;
			GameFrame gF = new GameFrame(100,100,640,480);
			Coordinates windowSize=gF.getDimensions();
			Pong game = new Pong(windowSize);
			gF.run(game);
			releasedPong=false;
			this.setVisible(false);
		}
		if (clickedPong) {
			g.setColor(Color.BLACK);
			g.drawImage(pressedButton,(int)(8*xUnit-100),(int)(7*yUnit+20), this);
			g.drawImage(play,(int)(8*xUnit-100),(int)(7*yUnit+20), this);
		}
			
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f)); //makes the rectangle transparent
	  	g2d.fillRect(playPong.x, playPong.y, playPong.width, playPong.height);
		
		if (releasedTextBased) {
			clickedTextBased=false;
		}
		
		if (releasedSettings) {
			clickedSettings=false;
			inSettings = true;
			
			removeAll();
			repaint();
		}

		else {
			g.setColor(Color.GREEN);
		}
	  	if(exitButtonDown) {
			g.setColor(Color.GRAY);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f));
			g.fillRect((int)(8*xUnit-274),(int)(7*yUnit + 187), 60, 60);
			inSettings = false;
			exitButtonDown = false;
	  	}
		if(exitSettings) {
			inSettings = false;
			exitSettings = false;
			//draws textures for the framework of the settings tab
			g.drawImage(greenButton,(int)(8*xUnit-100),(int)(7*yUnit + 20), this);
			g.drawImage(redButton,(int)(8*xUnit-100),(int)(7*yUnit + 120), this);
			playPong=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
			playTextBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
			playSettingsBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
			settings=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 120),200, 70);
		
		exitSettings = false;
		repaint();
		}
	  	if(set1BD) { 
	  		g.setColor(Color.GRAY);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
			g.fillRect((int)(8*xUnit-274),(int)(7*yUnit - 90), 146, 121);
			//gray button overlay feedback when user presses a button (Pong)
	  	}
	  	if(set2BD) {
	  		g.setColor(Color.GRAY);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
			g.fillRect((int)(8*xUnit-74),(int)(7*yUnit - 90), 146, 121);
			//gray button overlay feedback when user presses a button (The Museum)
	  	}
	  	if(set3BD) {
	  		g.setColor(Color.GRAY);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
			g.fillRect((int)(8*xUnit+126),(int)(7*yUnit - 90), 146, 121);
			//gray button overlay feedback when user presses a button (color wheel)
	  	}
		
		releasedSettings=false;
		releasedSettingsBased=false;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
	if (!inSettings) {	//Tests for the button press down animation for the main menu
		if (Constants.TEST) {
			System.out.println("X = "+ x + "Y = "+ y);
		}

		if (playPong.contains(x, y)) {
			clickedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}
		if (settings.contains(x, y)) {
			clickedSettings = true;
		}
		if (playSettingsBased.contains(x, y)) {
			clickedSettingsBased = true;
		}
		repaint();
	} 
	else if (inSettings) {		//Tests for the button press down animation for the Settings menu
		if (exitMenu.contains(x, y)) {
				exitButtonDown = true;
		}
		if (Set1.contains(x, y)) {
				set1BD = true;
		}
		if (Set2.contains(x, y)) {
			set2BD = true;
	}
		if (Set3.contains(x, y)) {
			set3BD = true;
	}
		repaint();
	}

}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x, y;

		x = e.getX();
		y = e.getY();
	if (!inSettings) {	//Functions for buttons in the main menu
		if (Constants.TEST) {
			System.out.println("X = "+ x + "Y = "+ y); //tester
		}

		if (playPong.contains(x, y)) {
			releasedPong = true;
		}
		if (playTextBased.contains(x, y)) {
			clickedTextBased = true;
		}
		else  {
				clickedPong = false;
		}
		if (settings.contains(x, y)) {
			releasedSettings = true;
		}
		if (playSettingsBased.contains(x, y)) {
			clickedSettingsBased = true;
		}
		else  {
				clickedSettings = false;
		}
		repaint();
	} 
	else if (inSettings) { //Functions for buttons in the Settings Menu
		if (exitMenu.contains(x, y)) {
				exitSettings = true;
		}
		if (Set1.contains(x, y)) {	//Runs Pong
			if(set1BD) {
				set1BD = false;
				GameFrame gF = new GameFrame(100,100,640,480);
				Coordinates windowSize=gF.getDimensions();
				Pong game = new Pong(windowSize);
				gF.setResizable(false);
				gF.run(game);
				this.setVisible(false);
			}
		}
	
		if (Set2.contains(x, y)) {	//Runs Text-Based Game
			if(set2BD) {
				set2BD = false;		
				this.setVisible(false);
				TextBased tester=new TextBased();
				tester.run();
				}
			}
		if (Set3.contains(x, y)) {	//Runs Color Wheel Game
			if(set3BD) {
				set3BD = false;
				GameFrame gF = new GameFrame(100,100,640,480);
				gF.setResizable(false);
				Coordinates windowSize=gF.getDimensions();
				ColorWheel game = new ColorWheel(windowSize); //run Color Wheel
				gF.run(game);
				this.setVisible(false);
				}
			}
		}
	}
}
	

