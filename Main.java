/********************************************
*	AUTHORS:	<your name>
* COLLABORATORS: <name of peer, tutor, instructor>
*	LAST MODIFIED:	<date of last change>
********************************************/

/********************************************
*	<TITLE OF PROGRAM>
* Card Game
*********************************************
*	PROGRAM DESCRIPTION:
*	Inspired by the game balatro, this is a card game where the player can select and play cards 
* in certain configurations to beat the level and continue on to the next one.
*********************************************
*	ALGORITHM:
*	Keep the board in an array of arrays where each character has its own spot in the array
* Mutate this array every time we add something to the board
* Print the board to display changes
* Keep a class for cards where each card has a number, suit, selection status and row/col coordinate
* Establish arrays for deck, hand, and selected cards
* Take user input to select cars, play them, discard them, etc, and use custom methods to carry out the actions
* Check for win/loss conditions and play till the user wins all levels or loses by running out of hands/cards in the deck 
*********************************************
*	STATIC METHODS:
* No methods in Main, all game logic contained in Game.java
*********************************************
*	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *	Scanner used for console input in Game.java
*********************************************/

public class Main 
{

  /***** CONSTANT SECTION *****/

  public static void main(String[] args) throws InterruptedException
  {
    /***** DECLARATION SECTION *****/

    /***** INITIALIZATION SECTION *****/
    
    /***** INTRO SECTION *****/

    /***** INPUT SECTION *****/

    /***** PROCESSING SECTION *****/

    /***** OUTPUT SECTION *****/
    
    // All game logic is contained in Game.java
    Game board = new Game(); 
    board.playGame();

  }
  /***** STATIC METHODS *****/
}
