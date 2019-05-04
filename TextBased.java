import java.util.Scanner;

public class TextBased extends Game {
	private static final long serialVersionUID = 1L;
	
	Scanner kboard=new Scanner(System.in);
	String userInput;

	@Override
	public String getName() {
		return "Text Based";
	}

	@Override
	public void run() {
		System.out.println("\f");
		System.out.println("Welcome to my GameFrame, why don't you stay awhile?");
		userInput=kboard.next();
		System.out.println("As you can see, here you proceed when you press a button");
		userInput=kboard.next();
		System.out.println("In the future you will be given the ability to change settings and other such");
		userInput=kboard.next();
		System.out.println("Currently this is a dead end in good style as it shows the possibility of more games while not creating more games");
		userInput=kboard.next();
		System.out.println("Clever no?");
		userInput=kboard.next();
		System.out.println("This message will self destruct");
		
	}
}
