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
//	From GameBoard.java authored by Mr.Taylor
// 	Description: Acts as the main menu for all games
public class Menu extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Image play = new ImageIcon("PLAY.png").getImage();
	private Image title = new ImageIcon("TitleFrame.png").getImage();
	private Image greenButton = new ImageIcon("GreenButton.png").getImage();
	private Image pressedButton = new ImageIcon("PressedButton.png").getImage();
	private Image redButton = new ImageIcon("redButton.png").getImage();
	private Image pressedRed = new ImageIcon("RedButtonPressed.png").getImage();
	private Image gear = new ImageIcon("GEAR.png").getImage();
	private Image SettingsFrame = new ImageIcon("SettingsFrame.png").getImage();

	
	private Rectangle playPong;
	private Rectangle settings;
	private Rectangle playTextBased;
	private Rectangle playSettingsBased;
	private Rectangle returnMenu;
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
	
	public Menu () {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void run() {
		w = new JFrame("Menu");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Menu menu = new Menu();
		menu.setBackground(Color.WHITE);

		c = w.getContentPane();
		c.add(menu);

		w.setResizable(true);
		w.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		int xUnit=this.getWidth()/16;
		int yUnit=this.getHeight()/16;
		
	if (inSettings) {
		//Settings menu
		g.drawImage(SettingsFrame,(int)(8*xUnit-323),(int)(7*yUnit-210), this);
		g.setColor(Color.GRAY);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
		returnMenu=new Rectangle((int)(8*xUnit-274),(int)(7*yUnit - 120), 146, 121);
		exitMenu=new Rectangle((int)(8*xUnit-274),(int)(7*yUnit + 187), 60, 60);
	  	g2d.fillRect(returnMenu.x, returnMenu.y, returnMenu.width, returnMenu.height);
	  	g2d.fillRect(exitMenu.x, exitMenu.y, exitMenu.width, exitMenu.height);
		}
	else if (!inSettings) {
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
//			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.GRAY);
		}
		
		if (releasedPong) {
			clickedPong=false;
			GameFrame gF = new GameFrame(100,100,640,480);
			Coordinates windowSize=gF.getDimensions();
			Pong game = new Pong(windowSize);
			gF.run(game);
//			g.setColor(Color.RED);
			releasedPong=false;
			this.setVisible(false);
		}
		else {
			g.setColor(Color.GREEN);
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
		
		releasedSettings=false;
		releasedSettingsBased=false;
		
		if(exitSettings) {
		inSettings = false;
		exitSettings = false;
		
		g.drawImage(greenButton,(int)(8*xUnit-100),(int)(7*yUnit + 20), this);
		g.drawImage(redButton,(int)(8*xUnit-100),(int)(7*yUnit + 120), this);
		System.out.println("ddd");
		playPong=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		playTextBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		playSettingsBased=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 20),200, 70);
		settings=new Rectangle((int)(8*xUnit-100),(int)(7*yUnit + 120),200, 70);
		
		exitSettings = false;
		repaint();
		}
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
	if (!inSettings) {
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
	else if (inSettings) {
		if (exitMenu.contains(x, y)) {
				exitButtonDown = true;
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
	if (!inSettings) {
		if (Constants.TEST) {
			System.out.println("X = "+ x + "Y = "+ y);
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
	else if (exitButtonDown) {
		if (exitMenu.contains(x, y)) {
				exitSettings = true;
				repaint();
		}
  }
}
}
