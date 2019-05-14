
public class Starter {
	public static void main(String[] args) {
		if (!(Constants.TEST)) {
			Menu window = new Menu();
			window.run();
		}
		else {
			GameFrame w = new GameFrame(100,100,640,480);
			Coordinates windowSize=w.getDimensions();
			Pong game = new Pong(windowSize);
			w.run(game);
		}
	}
}