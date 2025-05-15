import java.util.Scanner;

/**
 * Represents The game board
 * 
 * @author Muhammad Conn
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
GameBoard
-----------------------------------------
- ROWS: int
- COLS: int
- HAND_COL: int
- HAND_ROW: int
- CARD_COL: int
- CARD_ROW: int
- HAND_CELL_WIDTH: int
- board: String[][]
- colors: String[][]
- deck: Card[]
- hand: Card[]
-----------------------------------------
+ getHand(): Card[]
+ setHand(hand: Card[]): void
+ GameBoard(): void
+ GameBoard(hand: Card[]): void
+ GameBoard(other: GameBoard): void
+ toString(): String
+ equals(other: GameBoard): boolean
+ initializeBoard(): void
+ stampBoard(stamp: String[], row: int, col: int, color: String): void
+ printBoard(): void
+ printBox(row: int, col: int, height: int, width: int): void
+ printHorizBoxes(row: int, col: int, height: int, totalWidth: int, cells: int): void
+ dealHand(): void
+ printHand(): void
+ shuffleDeck(): void
-----------------------------------------
*/

public class GameBoard
{
	
	/***** CONSTANTS  *****/

	// Constants used in placing elements on the board
	private static final int ROWS = 40;
	private static final int COLS = 140;
	private static final int HAND_COL = 30;
	private static final int HAND_ROW = 27;
	private static final int CARD_COL = HAND_COL + 2;
	private static final int CARD_ROW = HAND_ROW + 1;
	private static final int HAND_CELL_WIDTH = 14;

	// Color codes
	public static final String RESET  = "\u001B[0m";
	public static final String BLACK  = "\u001B[30m";
	public static final String RED    = "\u001B[31m";
	public static final String GREEN  = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE   = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN   = "\u001B[36m";
	public static final String WHITE  = "\u001B[37m";
	public static final String ORANGE = "\u001B[38;2;255;165;0m";

	// Empty card stamp to erase cards from the board
	private static final String[] EMPTY_CARD = new String[7];
	{
		EMPTY_CARD[0] = EMPTY_CARD[1] = EMPTY_CARD[2] = EMPTY_CARD[3] = EMPTY_CARD[4] = EMPTY_CARD[5] = EMPTY_CARD[6] = "           ";
	}

	/***** STATIC VARIABLES *****/
	// Arrays for the board, colors, deck, and selected cards
	static String[][] board = new String[ROWS][COLS];
	static String[][] colors = new String[ROWS][COLS]; // Stores the color of each cell to be applied when printing
	static Card[] deck = new Card[52];
	static Card[] selectedCards = new Card[5];

	// Logic variables
	static int dealtCardsCount = 0; // Int to keep track of dealt cards
	static int selectedCardsCount = 0; // Int to keep track of selected cards
	static int sortType = -1; /// Int to keep track of the sort kind. We set as -1 so it doesn't trigger anything until set
	
	// Fill the deck with cards
	{
		for (int i = 0; i < 13; i++)
		{
			deck[i] = new Card(i + 1, "Spades", false, 0, 0); 
		}
		for (int i = 13; i < 26; i++)
		{
			deck[i] = new Card(i - 12, "Hearts", false, 0, 0);
		}
		for (int i = 26; i < 39; i++)
		{
			deck[i] = new Card(i - 25, "Diamonds", false, 0, 0);
		}
		for (int i = 39; i < 52; i++)
		{
			deck[i] = new Card(i - 38, "Clubs", false, 0, 0);
		}
	}

	/***** INSTANCE VARIABLES *****/
	Card[] hand = new Card[7]; // Array to hold the player's hand
	/***** CONSTRUCTORS *****/
	/**
	 * Default constructor for the GameBoard class.
	 * Initializes the game board and deck of cards.
	 */
	public GameBoard()
	{
		// Initialize the game board with borders and empty spaces
		initializeBoard();
		for (int i = 0; i < hand.length; i++)
		{
			hand[i] = null; // Initialize the hannd with null values
		}
	}

	/**
	 * Full constructor for the GameBoard class.
	 * @param hand The player's hand of cards to be displayed on the game board.
	 */
	public GameBoard(Card[] hand)
	{
		this.hand = hand; // Initialize the hand with the provided array of cards
		initializeBoard(); // Initialize the game board with borders and empty spaces
	}

	/**
	 * Copy constructor for the GameBoard class.
	 * @param other The GameBoard object to be copied.
	 */
	public GameBoard(GameBoard other)
	{
		this.hand = other.hand; // Copy the hand from the other GameBoard object
		initializeBoard(); // Initialize the game board with borders and empty spaces
	}

	/***** ACCESSORS *****/
	
	/**
	 * Returns the player's hand of cards.
	 * @return The player's hand of cards.
	 */
	public Card[] getHand()
	{
		return hand;
	}
	/***** MUTATORS *****/
	
	/**
	 * Sets the player's hand of cards.
	 * @param hand The new hand of cards to be set.
	 */
	public void setHand(Card[] hand)
	{
		this.hand = hand; // Set the hand to the provided array of cards
	}
	/***** OTHER REQUIRED METHODS *****/

	/**
	 * Returns a string representation of the GameBoard object.
	 * @return A string representation of the GameBoard object.
	 */
        @Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("GameBoard: \n");
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				sb.append(board[r][c]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Returns whether two GameBoard objects are equal.
	 * @param other The other GameBoard object to compare with.
	 * @return true if the GameBoard objects are equal, false otherwise.
	 */
	public boolean equals(GameBoard other)
	{
		return (this.hand == other.hand);
	}

	/***** HELPER METHODS *****/

	/***** SETUP METHODS *****/
	// These methods are used to initialize/output the game and its parts 

	/**
	 * Initializes the game board with borders and empty spaces.
	 */
	public void initializeBoard()
	{
		// Add the corner symbols
		board[0][0] = "┌";
		board[0][COLS - 1] = "┐";
		board[ROWS - 1][0] = "└";
		board[ROWS - 1][COLS - 1] = "┘";

		// Add the borders using loops
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				board[r][c] = " ";
			}
		}
		printBox(0,0, ROWS, COLS, WHITE); // Draw the outer border of the board
		printHandGrid(); // Draw the hand box

		// Print number labels
		for (int r = 0; r < 7; r++)
		{
			board[HAND_ROW + 9][HAND_COL + 7 + r * HAND_CELL_WIDTH] = "" + (r+1);
		}

	}

	/**
	 * Stamps a string array on the game board at the specified row and column with the given color.
	 * @param stamp The stamp to be placed on the board
	 * @param row The starting row for the stamp
	 * @param col The starting column for the stamp
	 * @param color The color to be applied to the stamp
	 */
	public void stampBoard(String[] stamp, int row, int col, String color)
	{
		for (int r = 0; r < stamp.length; r++)
		{
			for (int c = 0; c < stamp[r].length(); c++)
			{
				String symbol = stamp[r].substring(c, c + 1);
            	board[row + r][col + c] = symbol;
				colors[row + r][col + c] = color;
			}
		}
	}

	/**
	 * Prints the game board to the console. Each cell is colored based on the color stored in the colors array.
	 */
	public void printBoard()
	{
		StringBuilder sb = new StringBuilder();
		printHand(); // Update the hand before we output
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				if (colors[r][c] != null)
				{
					sb.append(colors[r][c]);
				}
				else
				{
					sb.append("\u001B[0m"); // Reset color if no color is set
				}
				sb.append(board[r][c]);
				sb.append("\u001B[0m"); // Reset color after each character
			}
			sb.append("\n"); // Add a new line after every line
		}
		
		System.out.println(sb.toString()); // Print entire board in one go to avoid flickering
	}

	/**
	 * Prints a box on the game board with the specified dimensions and starting coordinate.
	 * @param row The integer starting row for the box
	 * @param col The integer starting column for the box
	 * @param height The integer height of the box
	 * @param width The integer width of the box
	 * @param color The string for the color to be applied to the box
	 */
	public void printBox(int row, int col, int height, int width, String color)
	{
		String[] boxArray = new String[height];

		// Add the corner symbol to the first row
		boxArray[0] = "┌";

		// Add the top border to the first row
		for (int c = 0; c < width - 2; c++)
		{
			boxArray[0] += "─";
		}
		boxArray[0] += "┐"; // Cap off the first row with a corner

		for (int r = 1; r < height - 1; r++) // Corrected loop condition to include the last row before the bottom border
		{
			boxArray[r] = "│";
			for (int blank = 1; blank < width - 1; blank++) // fill the row with spaces
			{
				boxArray[r] += " ";
			}
			boxArray[r] += "│";
		}

		// Add the bottom border to the last row
		boxArray[height - 1] = "└";
		for (int c = 0; c < width - 2; c++)
		{
			boxArray[height - 1] += "─";
		}
		boxArray[height - 1] += "┘"; // Cap off the last row with a corner

		stampBoard(boxArray, row, col, color); // Stamp the box on the board
	}

	/**
	 * Prints horizontal boxes with shared walls.
	 * @param row The starting row for the box
	 * @param col The starting column for the box
	 * @param height The height of the box
	 * @param totalWidth The total width of the box (must be divisible by cells)
	 * @param cells The number of cells in the box
	 */
	public void printHorizBoxes(int row, int col, int height, int cellWidth, int cells)
	{

		printBox(row, col, height, cellWidth+1, WHITE); // Print the first box outside the loop
		//Print the rest of the boxes and fix the corners between boxes
		for (int c = 1; c < cells; c++)
		{
			printBox(row, col + c * cellWidth, height, cellWidth+1, WHITE);
			board[row][col + c * cellWidth] = "┬"; // Replace corner
			board[row + height - 1][col + c * cellWidth] = "┴"; // Replace corner
		}
	}

	/**
		 * Prints the hand grid on the game board.
		 */
		public void printHandGrid()
		{
			printHorizBoxes(HAND_ROW, HAND_COL, 9, HAND_CELL_WIDTH, 7); // Draw the hand box
		}

		/**
		 * Prints an array of cards to the board
		 */
		public void printCards(Card[] cardArray)
		{
			for (int i = 0; i < hand.length; i++)
			{
				if (hand[i] != null && !hand[i].getSelected())
				{
					stampBoard(hand[i].cardToLinesArray(), hand[i].getRowCoord(), hand[i].getColCoord(), hand[i].suitToColor());
				}
				else if (hand[i] != null && hand[i].getSelected())
				{
					stampBoard(hand[i].cardToLinesArray(), hand[i].getRowCoord(), hand[i].getColCoord(), hand[i].suitToColor()); // Reset color for selected cards
				}
				else if (hand[i] == null)
				{
					stampBoard(EMPTY_CARD, CARD_ROW, CARD_COL + (i * HAND_CELL_WIDTH), "\u001B[0m"); // print empty cards
				}
			}
		}

		/**
		 * Prints the player's hand of cards to the board.
		 */
		public void printHand()
		{
			printCards(hand);
		}

		/**
		 * Erases a card from the hand by stamping an empty card at its position.
		 * @param cardArray The array of cards to erase from.
		 * @param cardIndex The index of the card to be erased.
		 */
		public void eraseCard(Card[] cardArray, int cardIndex)
		{
			if (cardArray[cardIndex] != null)
			{
				stampBoard(EMPTY_CARD, hand[cardIndex].getRowCoord(), hand[cardIndex].getColCoord(), "\u001B[0m"); // Reset color for erased cards
			}
		}


		/***** LOGIC METHODS *****/
		// These are methods that deal with the behind the scenes logic required to display the game properly


		/**
		 * Deals a hand of cards from the deck to the empty slots in the player's hand but does not print it. 
		 */
		public void dealHand()
		{
			
			for (int j = 0; j < deck.length; j++)
			{	
				for (int handCard = 0; handCard < hand.length; handCard++)
				{
					if (deck[j] != null && dealtCardsCount < 7 && hand[handCard] == null)
						{
							hand[handCard] = deck[j]; // Add the card to the hand
							hand[handCard].setRowCoord(CARD_ROW); // Set the row coordinate of the card
							hand[handCard].setColCoord(CARD_COL + (handCard * HAND_CELL_WIDTH)); // Set the column coordinate of the card
							deck[j] = null; // Remove the card from the deck
							dealtCardsCount++;
						}
				}
				
			}
		}

		

		/**
		 * Shuffles the deck of cards using the Fisher-Yates shuffle algorithm.
		 */
		public void shuffleDeck()
		{
			for (int i = 0; i < deck.length; i++)
			{
				int randomIndex = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, 52); // Generate a random index between 0 and 51
				
				// Swap the current card with a random one
				swapIndeces(deck, i, randomIndex);
			}
		}

		/**
		 * Selects a card from the hand by toggling its selection status.
		 * @param cardIndex The index of the card to be selected.
		 */
		public boolean selectCard(int cardIndex)
		{
			if (hand[cardIndex] != null && !hand[cardIndex].getSelected() && selectedCardsCount < 5) // If the card is not selected and less than 5 cards are selected
			{
				hand[cardIndex].setSelected(true); // Toggle the selection status to be true
				hand[cardIndex].setRowCoord(CARD_ROW - 2); // Set the row coordinate of the card to be above the hand
				appendCard(selectedCards, hand[cardIndex]); // Add the card to the selected cards array
				selectedCardsCount++; // Increase the number of selected cards
			}
			else if (hand[cardIndex] != null && !hand[cardIndex].getSelected() && selectedCardsCount >= 5) // If the card is not selected and 5 cards are already selected
			{
				return (false); // Return false if the card cannot be selected
			}
			else if (hand[cardIndex] != null && hand[cardIndex].getSelected()) // If the card is already selected
			{
				selectedCards[handToSelectedIndex(cardIndex)] = null; // Remove the card from the selected cards array
				selectedCardsCount--; // Decrease the number of selected cards
				siftArray(selectedCards); // Sift out the null values to make sure the first cards in the array are full
				hand[cardIndex].setSelected(false); // Toggle the selection status to be false
				hand[cardIndex].setRowCoord(CARD_ROW); // Set the row coordinate of the card back to the hand
				printHandGrid(); // Reprtint the hand grid to fix the edge
			}
			return (true); // Return true if the card was successfully selected
		}

		/**
		 * Discards the selected cards and updates/prints the hand accordingly
		 * @throws InterruptedException
		 */
		public void discard() throws InterruptedException
		{
			if (selectedCardsCount != 0)
			{
				for (int i = 0; i < hand.length; i++) // For every card in the hand
				{
					if (hand[i] != null && hand[i].getSelected()) // If the card in the hand is selected
					{
						eraseCard(hand, i); // Erase the card from the board
						hand[i] = null; // Discard the selected card
						dealtCardsCount--; // Decrease number of cards dealt
					}
				}
				for (int card = 0; card < selectedCardsCount; card++) // For every selected card
				{
					selectedCards[card] = null; // Remove the selected card from the selected cards array
				}
				selectedCardsCount = 0; // reset the number of selected cards
				siftArray(selectedCards); // Sift out the null values to make sure the first cards in the array are full

				printHandGrid(); // Reprint the hand grid to fix the edge
				printBoard(); // Print the board

				Thread.sleep(500);
				dealHand(); // Fill empty spots in the hand
				printBoard(); // Print the board

				if (sortType == 0 || sortType == 1) // As long as a sort type has been set
				{
					Thread.sleep(700); // Pause efore sorting
					sortHand(sortType); // Sort
					printBoard(); // Print the board
				}
			}
		}

		/**
		 * Sorts the hand of cards based on the specified sorting criteria.
		 * @param sortKind The sorting criteria (0 for number, 1 for suit).
		 */
		public void sortHand(int sortKind)
		{
			String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"}; // Array of suits to be used for sorting

			if (sortKind == 0) // Sort by number
			{
				// We loop through the hand array, swapping each card with the smallest subsequent card using the indexOfMin method
				for (int index = 0; index < hand.length; index++)
				{
					int minIndex = indexOfMin(hand, index); // Get the index of the minimum card from the current index to the end of the array
					swapIndeces(hand, index, minIndex);
					if (hand[index] != null && hand[index].getSelected())
					{
						eraseCard(hand, index); // Erase the card if it is selected
					}
					initializeBoard(); // Reinitialize the board to fix the hand box
				}
			}
			else if (sortKind == 1) // Sort by suit
			{
				int currentSuitIndex = 0;

				for (int suitIndex = 0; suitIndex < suits.length; suitIndex++) // For each suit in the suits array
				{
					int nextSuitIndex = 0;
					while (indexOfSuit(hand, currentSuitIndex, suits[suitIndex]) != -1 && currentSuitIndex < hand.length - 1) // While there are upcoming cards of the suit in the hand and we haven't reached the end of the hand
					{
						nextSuitIndex = indexOfSuit(hand, currentSuitIndex, suits[suitIndex]); // Get the index of the next card of the proper suit
						if (hand[currentSuitIndex] != null && !hand[currentSuitIndex].getSuit().equalsIgnoreCase(suits[suitIndex])) // If the suit of the card is not the right suit and isn't null
						{
							swapIndeces(hand, currentSuitIndex, nextSuitIndex);
							currentSuitIndex++; // Update the current suit index to be the next card
							if (hand[currentSuitIndex].getSelected())
							{
								eraseCard(hand, currentSuitIndex); // Erase the card if it is selected
							}
							initializeBoard(); // Reinitialize the board to fix the hand box
						}
						else
						{
							currentSuitIndex++;
						}
					}
				}
			}

		}

		/**** Array Methods ****/
		// These methods perform various tasks on arrays necessary for game logic

		/**
		 * Swaps two cards in the array at the specified indices.
		 * @param array The array of cards to swap elements in.
		 * @param a The index of the first card to swap.
		 * @param b The index of the second card to swap.
		 */
		public static void swapIndeces(Card[] array, int a, int b)
		{
			//We store one element in a temporary variable to avoid it being overwritten
			Card storedElement = new Card(array[a]); //array[a];
			int aColCoord = array[a].getColCoord(); //Store the column coordinate of the first card
			int bColCoord = array[b].getColCoord(); //Store the column coordinate of the second card

			array[a] = new Card(array[b]);
			array[a].setColCoord(aColCoord); //Set the column coordinate of the first card to be the same as it was before
			array[b] = new Card(storedElement);
			array[b].setColCoord(bColCoord); //Set the column coordinate of the second card to be the same as it was before
		}

		public int handToSelectedIndex(int index)
		{

			for (int selectedIndex = 0; selectedIndex < selectedCardsCount; selectedIndex++)
			{
				Card dummyCard = new Card(hand[index]);
				dummyCard.setSelected(!dummyCard.getSelected()); // Set the selected status to the opposite of the original for comparison

				if ((selectedCards[selectedIndex] != null) && (selectedCards[selectedIndex].equals(hand[index])) || ((selectedCards[selectedIndex] != null) && (dummyCard.equals(hand[index]))))
				{
					return selectedIndex; // Return the index of the card in the hand
				}
			}
			return -1; // Return -1 if the card is not found in the hand
		}

		/**
		 * Returns the index of the minimum card in the array starting from the given index.
		 * @param array The array of cards to search in.
		 * @param startIndex The index to start searching from.
		 * @return The index of the minimum card, or -1 if not found.
		 */
		public static int indexOfMin(Card[] array, int startIndex)
		{
			// We set the current minimum and index of that minimum to be the starting element and index
			Card currentMin = new Card(array[startIndex]); //Copy constructor to avoid modifying the original card
			int minIndex = startIndex; 

			// We loop through, updating the current minimum and index if we find a smaller element
			for (int index = startIndex; index < array.length; index++)
			{
				if (array[index].getNumber() < currentMin.getNumber())
				{
					currentMin = array[index];
					minIndex = index;
				}
			}
			return minIndex;
		}

		/**
		 * Returns the index of the first card of the specified suit in the array starting from the given index.
		 * @param array The array of cards to search in.
		 * @param startIndex The index to start searching from.
		 * @param suit The suit to search for.
		 * @return The index of the first card of the specified suit, or -1 if not found.
		 */
		public static int indexOfSuit(Card[] array, int startIndex, String suit)
		{
			
			for (int index = startIndex; index < array.length; index++)
			{
				if (array[index].getSuit().equalsIgnoreCase(suit))
				{
					return index; // Return the index of the first card of the suit
				}
			}
			return -1; // Return -1 if no card of the suit is found
		}

		public void siftArray(Card[] array)
		{
			for (int i = 0; i < array.length; i++) // For every card in the array
			{
				if (array[i] == null) // if a blank spot is found
				{
					for (int j = i; j < array.length - 1; j++) // For all subsequent cards
					{
						array[j] = array[j + 1]; // Shift the elements to the left
					}
					array[array.length - 1] = null; // Set the last element to null
				}
			}
		}


		/**
		 * Appends a card to the selectedCards array.
		 * @param cardArray The array to which the card will be appended.
		 * @param card The card to be appended.
		 */
		public void appendCard(Card[] cardArray, Card card)
		{
			for (int i = 0; i < cardArray.length; i++)
			{
				if (cardArray[i] == null)
				{
					cardArray[i] = card; // Add the card to the first empty slot in the array
					break;
				}
			}
		}


		/**** GAME LOGIC METHODS ****/
		// These methods handle the rules of the game and the play loop


		/**
		 * Checks if the selected cards form a flush (all cards of the same suit).
		 * @return true if the selected cards form a flush, false otherwise.
		 */
		public boolean checkForFlush()
		{
			if (selectedCardsCount == 5)
			{
				String suit = selectedCards[0].getSuit(); // Get the suit of the first card
				for (int i = 1; i < selectedCards.length; i++)
				{
					if (!selectedCards[i].getSuit().equalsIgnoreCase(suit)) // If any card has a different suit
					{
						return false; // Not a flush
					}
				}
				return true; // All cards have the same suit, it's a flush
			}
			return false;
		}

		/**
		 * Checks if the selected cards form a straight (consecutive numbers).
		 * @return true if the selected cards form a straight, false otherwise.
		 */
		public boolean checkForStraight()
		{
			boolean numFound = false;

			if (selectedCardsCount != 5) // If we don't have 5 cards, we can't have a straight
			{
				return false;
			}

			else
			{
				
				for (int startNum = 1; startNum < 9; startNum++) // For every possible number that could start a straight
				{

					for (int currentNum = startNum; currentNum < startNum + 5; currentNum++) // Loop through five numbers after startNum
					{
						numFound = false; // Reset numFound to false for each new starting number
						for (int card = 0; card < selectedCardsCount; card++) // Loop through every seleced card until we find a card of the right number, then break if we find it
						{
							if (selectedCards[card] != null && selectedCards[card].getNumber() == currentNum)
							{
								numFound = true;
								break;
							}
						}
						if (!numFound) // If we didn't find a card of the right number, break out of the loop
						{
							startNum = currentNum; // Set the starting number to be the next number so we don't waste time checking
							break; // We don't return here because we still need to check for the special straight
						}
						
					}
					if (numFound) // If we found all five cards, return true. If not, move on to the next starting number
					{
						return true;
					}
				}

				// If we didn't find all five cards, we check for a special straight (10, jack, queen, king, ace)
				boolean specialFound = false;
				int aceCount = 0;
				for (int specialNum = 10; specialNum < 14; specialNum++)
				{
					specialFound = false; // Reset specialFound to false for each new starting number
					for (int specialCard = 0; specialCard < selectedCardsCount; specialCard++) // Loop through every seleced card until we find a card of the right number, then break if we find it
					{
						// If we find a number within the 10, jack, queen, king range, set specialFound to true
						if (selectedCards[specialCard] != null && selectedCards[specialCard].getNumber() == specialNum) 
							{
								specialFound = true;
								break;
							}
						// If we find an ace AND no aces have been found yet, increase aceCount and set specialFound to true
						else if (selectedCards[specialCard] != null && selectedCards[specialCard].getNumber() == 1 && aceCount == 0) 
						{
							aceCount++;
							specialNum--; // Decrease specialNum since we used this turn to find the ace
							specialFound = true;
							break;
						}
					}
					if (!specialFound) // If we didn't find a special card, return false
						{
							return false;
						}
				}
				// If we found a 10-King run and an ace, we have a straight
				// We check if the last selected card is an ace since the for loop above only checks for 10 through King
				if ((specialFound && aceCount == 1) || (specialFound && selectedCards[selectedCardsCount - 1].getNumber() == 1)) 
				{
					return true;
				}
			}
			return false; // Return false if nothing else was found

		}

		/**
		 * Checks the selected cards for high card, two of a kind, three of a kind, four of a kind, or full house
		 * @returns 1 through 4 depending on how many times the most frequent card is found, returns 5 if a full house is found, or 6 if a two pair is found
		 */
		public int checkForKind()
		{
			int modeNum = 0; // Int for the loop logic
			boolean threeFound = false; // Boolean for finding full house
			int twosFound = 0; // Int for finding full house and two pair
			int[] selectedFrequency = new int[13]; // Array to hold the frequency that each number of card appears

			
				for (int card = 0; card < selectedCardsCount; card++) // For every selected card
				{
					selectedFrequency[selectedCards[card].getNumber() - 1]++; // Increase the frequency of the card
				}

				for (int currentNum = 0; currentNum < 13; currentNum++)
				{
					// If the frequency of this card is higher than the last highest, update the highest value
					if (selectedFrequency[currentNum] > selectedFrequency[modeNum])
					{
						modeNum = currentNum;
					}

					// If we find a card that appears 2 or 3 times, update our booleans accordingly
					if (selectedFrequency[currentNum] == 2)
					{
						twosFound++; // Increase the number of pairs found
					}
					if (selectedFrequency[currentNum] == 3)
					{
						threeFound = true;
					}
				
				}

				if (twosFound == 1 && threeFound)
				{
					return 5; // Full house
				}
				else if (twosFound == 2)
				{
					return 6; // Two Pair
				}
				else
				{
					return selectedFrequency[modeNum]; // Return how many times the most frequent card appears 
				}
				
		}

		/**
		 * Checks if the selected cards form a straight flush (both a straight and a flush)
		 * @return True if straight flush is found, false otherwise
		 */
		public boolean checkForStraightFlush()
		{
			return checkForStraight() && checkForFlush();
		}

		/**
		 * Checks if the selected cards form a high card (no pattern)
		 * @return True if high card is found, false otherwise
		 */
		public boolean checkForHighCard()
		{
			return !checkForFlush() && !checkForStraight() && checkForKind() == 1; // All other hands override high card. We only account for flish and straight since the others are handled in checkForKind 
		}

		/**
		 * Checks if the selected cards form a two of a kind
		 * @return true if two of a kind is found, false otherwise
		 */
		public boolean checkForTwoOfAKind()
		{
			return !checkForFlush() && checkForKind() == 2; // Flush overrides two of a kind
		}

		/**
		 * Checks if the selected cards form a three of a kind
		 * @return true if three of a kind is found, false otherwise
		 */
		public boolean checkForThreeOfAKind()
		{
			return !checkForFlush() && checkForKind() == 3; // Flush overrides three of a kind
		}

		/**
		 * Checks if the selected cards form a four of a kind
		 * @return true if four of a kind is found, false otherwise
		 */
		public boolean checkForFourOfAKind()
		{
			return !checkForFlush() && checkForKind() == 4; // Flush overrides four of a kind
		}

		/**
		 * Checks if the selected cards form a full house
		 * @return true if full house is found, false otherwise
		 */
		public boolean checkForFullHouse()
		{
			return !checkForFlush() && checkForKind() == 5; // Flush overrides full house
		}

		/**
		 * Checks if the selected cards form a two pair
		 * @return true if two pair is found, false otherwise
		 */
		public boolean checkForTwoPair()
		{
			return !checkForFlush() && checkForKind() == 6; // Flush overrides two pair
		}



		/**
		 * Main method to play the game.
		 * @throws InterruptedException
		 */
		public void playGame() throws InterruptedException
		{
			boolean contGame = true;
			
			
			Scanner scanner = new Scanner(System.in);
			this.initializeBoard();
			this.shuffleDeck(); // Shuffle the deck
			this.printBoard();
			Thread.sleep(1000); // Sleep for 1 second
			this.dealHand(); // Deal the hand
			this.printBoard();
			while (contGame)
			{
				// We read if the initial string is empty before going any further
				String stringInput = scanner.nextLine();
				System.out.print("\u001B[2K" + "\u001B[1A"); // Clear the line and move the cursor up to reduce flickering in the board output
				if (stringInput.isEmpty())
				{
					System.out.println("Please enter a valid input");
				}
				else
				{
					// As long as the string isn't empty, we convert it to a char and read the input
					char input = stringInput.charAt(0);
					switch (input) 
					{
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
							int cardIndex = input - '0' - 1; // Convert the character to an index
							this.eraseCard(hand, cardIndex); // Erase the card from the hand
							if (!this.selectCard(cardIndex)) // Select the card at the index if possible
							{
								System.out.println("You can only select 5 cards at a time");
								break;
							} 
							else
							{
								this.printBoard(); // Display the board
								System.out.println("Straight: " + checkForStraight());
								System.out.println("Flush: " + checkForFlush());
								System.out.println("Straight Flush: " + checkForStraightFlush());
								System.out.println("High Card: " + checkForHighCard());
								System.out.println("Two of a Kind: " + checkForTwoOfAKind());
								System.out.println("Three of a Kind: " + checkForThreeOfAKind());
								System.out.println("Four of a Kind: " + checkForFourOfAKind());
								System.out.println("Full House: " + checkForFullHouse());
								System.out.println("Two Pair: " + checkForTwoPair());
								break;
							}
							
						case 's':
						sortType = 1;
							this.sortHand(sortType); // Sort the hand by suit
							this.printBoard(); // Display the board
							break;
						case 'n':
							sortType = 0;
							this.sortHand(sortType); // Sort the hand by suit
							this.printBoard(); // Display the board
							
							break;
						case 'q':
							scanner.close(); // Close the input stream
							contGame = false; // Quit the game
							break;
						case 'd':
							this.discard(); // Discard the selected cards. The method handles printing
							break;
						default:
							System.out.println("Please enter a valid input");
							break;
					}
				}
				
			}
		}


		/*** DEBUG METHODS ***/
		// These are useful methods that assist with debugging and aren't used in the actual game logic


		/**
		 * Debug method that prints the selected cards to the console for debugging.
		 */
		private static void testPrintSelected()
		{
			for (int i = 0; i < selectedCards.length; i++)
			{
				if (selectedCards[i] != null)
				{
					System.out.println(selectedCards[i].toString());
				}
				if (selectedCards[i] == null)
				{
					System.out.println("null");
				}
			}
		}

}