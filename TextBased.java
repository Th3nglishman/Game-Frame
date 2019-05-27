import java.util.Scanner;

/*
Name: Text Based
Description: Is a text based game
*/

public class TextBased extends Game {
	//	**Feilds**
	private static final long serialVersionUID = 1L;
	Scanner kboard=new Scanner(System.in);
	String userInput;
	boolean looper;
	
	//	**Methods**
	
	// Public methods
	
	// Returns name
	@Override
	public String getName() {
		return "Text Based";
	}

	// Runs this game
	public void run() {
//		System.out.println("\f");
		System.out.println("Welcome to my GameFrame, why don't you stay awhile?");
		userInput=kboard.next();
		if (userInput.equalsIgnoreCase("no")) {
			System.out.println("This message will self destruct");
		}
		else {
			System.out.println("As you can see, here you proceed when you press a button");
			userInput=kboard.next();
			System.out.println("Clever no?");
			userInput=kboard.next();
			if (userInput.equalsIgnoreCase("no")) {
				System.out.println("This message will self destruct");
			}
			else if (userInput.equalsIgnoreCase("Yes")||userInput.equalsIgnoreCase("yes!")) {
				System.out.println("Thank you!");
			}
			looper = true;
			while (looper) {
				System.out.println("     *** The Art Gallery ***     ");
				System.out.println("1. look at the pictures");
				System.out.println("2. examine the other people");
				System.out.println("3. move for the exit");
				userInput=kboard.next();
				switch (userInput) {
				
				case "1":
					looper = false;
					lookAtPictures();
					break;
					
				case "2":
					System.out.println("There is no one else, you are completely alone");
					break;
					
				case "3":
					looper = false;
					goToExit();
					break;
					
				default:
					System.out.println("please select a valid input");
					break;
				}
			}
		}
	}

	private void goToExit() {
		looper = true;
		while (looper) {
			System.out.println("There is a rock in front of you");
			System.out.println("1. Climb it");
			System.out.println("2. Go around it");
			System.out.println("3. BREAK IT WITH YOUR HEAD");
			userInput=kboard.next();
			switch (userInput) {
			
			case "1":
				if (((int)(Math.random()+0.5))<1) {
					System.out.println("You fall off");
				}
				else {
					looper = false;
					System.out.println("You have made it over and see the light of day (press any key to continue)");
					userInput=kboard.next();
					win();
				}
				break;
				
			case "2":
				looper = false;
				System.out.println("it was a very small rock (press any key to continue)");
				userInput=kboard.next();
				System.out.println("You have made it over and see the light of day");
				win();
				break;
				
			case "3":
				looper = false;
				System.out.println("You Win! (press any key to continue)");
				userInput=kboard.next();
				System.out.println("You have gained 128 xp!");
				userInput=kboard.next();
				System.out.println("You have gained 36 gold!");
				userInput=kboard.next();
				System.out.println("You got to level 3!");
				userInput=kboard.next();
				System.out.println("You got one head trauma");
				userInput=kboard.next();
				System.out.println("You have fainted");
				break;
				
			default:
				System.out.println("please select a valid input");
				break;
			}
		}
	}

	private void win() {
		for (int reps=0;reps<=1000;reps++) {
			System.out.println("VICTORY!");
		}
	}

	private void lookAtPictures() {
		boolean pictureSeen=false;
		
		looper=true;
		while (looper) {
			System.out.println("You see three pictures");
			System.out.println("1. An Owl");
			System.out.println("2. A Face");
			System.out.println("3. An X");
			if (pictureSeen) {
				System.out.println("4. leave");
			}
			userInput=kboard.next();
			switch (userInput) {
			
			case "1":
				printOwl();
				pictureSeen=true;
				break;
				
			case "2":
				printFace();
				pictureSeen=true;
				break;
				
			case "3":
				printX();
				pictureSeen=true;
				break;
				
			case "4":
				if (pictureSeen) {
					run();
				}
				else {
					System.out.println("please select a valid input");
				}
				break;
				
			default:
				System.out.println("please select a valid input");
				break;
			}
		}
	}

	private void printX() {
		System.out.println("You are looking at an X");
		userInput=kboard.next();
	}

	private void printFace() {
		System.out.println("You are looking at a Face");
		userInput=kboard.next();
	}

	private void printOwl() {
		System.out.println("You are looking at an Owl");
		userInput=kboard.next();
	}
}
