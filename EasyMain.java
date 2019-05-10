import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class EasyMain {
	public static void main(String[] args) {
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EasyWindow panel = new EasyWindow();
		w.addKeyListener(panel);
		panel.setBackground(Color.WHITE);
		Container c = w.getContentPane();
		c.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}
}
