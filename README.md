# Game-Frame
Game Frame: a frame for games
-

This program was written by Elwin He, Krishan Patel, and John Whitney starting May 1.
This program is a simple interface for playing and experimenting with classic games in a simplistic interface without neccesity of an emulator or other secondary system. Anyone interested in the beginning of video games made enjoy this program to play games such as pong. When using this program it is important to remember that controls will be shown at the start with the exeption of the main menu which operates on a click to select interface. 

More description:
-
Our project Game-Frame includes our first prototype game PONG, with many other games still in development.
We use many different classes to split up and properly organize specific functionalities and methods into each class, associating them with different relationships of each other as shown in the UML Diagram. By separating different mechanics such as textures and sprites in one class and hitboxes and game mechanics in separate classes, it makes our project more organized since specific mechanics are easier to locate. The main interface you'll be interacting with is the GameFrame.java class.

CLASS LIST:
Ball: Is a ball object used by pong

BlankTemplate: Is a blank template for all classes created

Constants: Stores project wide constants such as if it is being tested

Coordinates: Stores a set of coordinates and useful operations on them

Game: Is the super class of all games

GameFrame: Is a JFrame for all games

GraphicsGame: Is the subclass of game and the superclass of all graphics based games

Menu: Is the menu screen used to select games

MoveableSprite: Is the superclass of all moveable sprites and is a subclass of Sprite

Paddle: Is a paddle object used by pong

Pong: Is the graphics game PONG

Sprite: Is the superclass of all sprites

Starter: Contains the main method to run the program

TextBased: Is a textbased game like creation



TOO LONG DIDN'T READ(TLDR)
-
-You can run the project to start it or run the starter method

-You can change the constants class if you want to change settings 

-This has multiple simple games in an easy interface for your enjoyment and study


Credits
________
Elwin He - Graphics Guru
-
Krishan Patel - Fix-it-legend
-
John Whitney - GAME (Game Artist Master Extraordinaire)
-

