# Game-Frame
Game Frame: a frame for games
-

This program was written by Elwin He, Krishan Patel, and John Whitney starting May 1.
This program is a simple interface for playing and experimenting with siplistic games easily without neccesity of an emulator or other secondary system. Anyone interested in the beginning of video games made enjoy this program to play games such as pong. When using this program it is important to remember that controls will be shown at the start with the exeption of the main menu which operates on a click to select interface. 

In depth description:
-
Our project Game-Frame includes our first prototype game PONG, with other games still in development. We use many different classes to split up and properly organize specific functionalities and methods into each class, associating them with different relationships of each other as shown in the UML Diagram. By separating different mechanics such as textures and sprites in one class and hitboxes and game mechanics in separate classes, it makes our project more organized since specific mechanics are easier to locate. The main interface you'll be interacting with is the GameFrame.java class.

Once you run the Starter.java program, you are presented with the main menu, which is an intuitive interface with the default game selected as Pong. Simply press "PLAY" to begin playing, or you can select other games by pressing the orange gear button. This would bring you to the game selection interface. From the interface, you can always go back to the main menu or you can select any of the three available games GameFrame has to offer.

PONG: For this game, you are going against a computer. You control the left paddle with the "W" and "S" keys, which moves the paddle up and down respectively. Try your best to beat the computer by blocking the ball from scoring on your side.

Text-Based (Museum): You are prompted to answer the questions presented by the Museum operator, feel free to ask anything you desire!

COLOR wheel: This fun little game has simple rules. You are prompted a screen that displays a color in text, with four color options, You'll have to click the color rectangle according what is displayed in text, but act fast! You only have a couple seconds to make you selection.

Ball: Is a ball object for sprite

Blank Template: Is a blank template for creation of ojbects

Costants: Is a class holding all project wide variables such as if you're testing currently

Coordinates: Is a class holding coordinates

Game: Is the superclass of all game objects

Game Frame: Is the frame for all graphics games

Graphics Game: Is a superclass of all graphics based game objects

Menu: Is a menu for all games

Moveable Sprite: Is the superclass of all moveable sprite objects

Paddle: Is a paddle object for the pong class

Pong: Is a pong object

Sprite: Is the superclass for all sprite objects

Starter: The object containing the main for the project

TextBased: Is a textbased game object

Credits
-
Elwin He - Graphics Guru
-
Krishan Patel - Fix-it-legend
-
John Whitney - GAME (Game Artist Master Extraordinaire)
-
Mr. Taylor - Example code
-
Stack overflow - Concept explaination
-
The Java API - Syntax and capabilities
-
