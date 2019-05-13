
public class Starter {
	private static final boolean TEST = true;
	public static void main(String[] args) {
		if (!TEST) {
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
