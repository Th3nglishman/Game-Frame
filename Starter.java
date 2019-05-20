

/*
Name: Starter
Description: Holds the main method
*/

public class Starter {
	// Main
	public static void main(String[] args) {
		if (!(Constants.TEST)) {
			Menu window = new Menu();
			window.run();
		}
		else {
			TextBased tester=new TextBased();
			tester.run();
		}
	}
}