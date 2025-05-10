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
	private static final int ROWS = 40;
	private static final int COLS = 140;
	private static final int HAND_COL = 30;
	private static final int HAND_ROW = 27;
	private static final int CARD_COL = HAND_COL + 2;
	private static final int CARD_ROW = HAND_ROW + 1;
	private static final int HAND_CELL_WIDTH = 14;

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
	private static final String[] EMPTY_CARD = new String[5];
	{
		EMPTY_CARD[0] = EMPTY_CARD[1] = EMPTY_CARD[2] = EMPTY_CARD[3] = EMPTY_CARD[4] = "           ";
	}

	/***** STATIC VARIABLES *****/
	// Arrays for the board, colors, and deck
	static String[][] board = new String[ROWS][COLS];
	static String[][] colors = new String[ROWS][COLS]; // Stores the color of each cell to be applied when printing
	static Card[] deck = new Card[52];
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
		printHorizBoxes(HAND_ROW, HAND_COL, 9, HAND_CELL_WIDTH, 7); // Draw the hand box

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
			System.out.println(sb.toString());
			sb.setLength(0); // Clear the StringBuilder for the next row
		}
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

		/*int totalWidth = cellWidth * cells;

			// 1) Top border
			board[row][col] = "┌";
			for (int x = 1; x < totalWidth; x++) 
			{
				if (x % cellWidth == 0) 
				{
					board[row][col + x] = "┬";       //Three-way connector for the top of the cell
				} else {
					board[row][col + x] = "─";
				}
			}
			board[row][col + totalWidth] = "┐";
		
			// 2) Middle rows
			for (int y = 1; y < height - 1; y++) 
			{
				int r = row + y;
				board[r][col] = "│";                 // left wall
				board[r][col + totalWidth] = "│";    // right wall
				// draw interior verticals
				for (int x = cellWidth; x < totalWidth; x += cellWidth) 
				{
					board[r][col + x] = "│";
				}
			}
		
			// 3) Bottom border
			int bot = row + height - 1;
			board[bot][col] = "└";
			for (int x = 1; x < totalWidth; x++) 
			{
				if (x % cellWidth == 0) 
				{
					board[bot][col + x] = "┴"; //Three-way connector for the bottom of the cell
				} else {
					board[bot][col + x] = "─";
				}
			}
			board[bot][col + totalWidth] = "┘";*/
		}

		/**
		 * Deals a hand of cards from the deck to the empty slots in the player's hand but does not print it. 
		 */
		public void dealHand()
		{
			int dealtCards = 0;
			for (int j = 0; j < deck.length; j++)
			{	
				if (deck[j] != null && dealtCards < 7 && hand[j] == null)
				{
					hand[dealtCards] = deck[j]; // Add the card to the hand
					hand[dealtCards].setRowCoord(CARD_ROW); // Set the row coordinate of the card
					hand[dealtCards].setColCoord(CARD_COL + (dealtCards * HAND_CELL_WIDTH)); // Set the column coordinate of the card
					deck[j] = null; // Remove the card from the deck
					dealtCards++;
				}
			}
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
			}
		}

		public void printHand()
		{
			printCards(hand);
		}

		public void eraseCard(Card[] cardArray, int cardIndex)
		{
			if (cardArray[cardIndex] != null)
			{
				stampBoard(EMPTY_CARD, hand[cardIndex].getRowCoord(), hand[cardIndex].getColCoord(), "\u001B[0m"); // Reset color for erased cards
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
		public void selectCard(int cardIndex)
		{
			if (hand[cardIndex] != null)
			{
				hand[cardIndex].setSelected(!hand[cardIndex].getSelected()); // Toggle the selection status of the card to be the opposite of what it is now
				hand[cardIndex].setRowCoord(CARD_ROW - 2); // Set the row coordinate of the card to be above the hand
			}
		}

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
					if (hand[index].getSelected())
					{
						eraseCard(hand, index); // Erase the card if it is selected
					}
					if (hand[minIndex].getSelected())
					{
						eraseCard(hand, minIndex); // Erase the card if it is selected
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
							System.out.println(hand[currentSuitIndex].getSuit());
							System.out.println(suits[suitIndex]);

							swapIndeces(hand, currentSuitIndex, nextSuitIndex);
							currentSuitIndex++; // Update the current suit index to be the next card
							if (hand[currentSuitIndex].getSelected())
							{
								eraseCard(hand, currentSuitIndex); // Erase the card if it is selected
							}
							if (hand[nextSuitIndex].getSelected())
							{
								eraseCard(hand, nextSuitIndex); // Erase the card if it is selected
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

		public static int indexOfSuit(Card[] array, int startIndex, String suit)
		{
			Card currentMin = new Card(array[startIndex]); //Copy constructor to avoid modifying the original card
			int minIndex = startIndex;
			for (int index = startIndex; index < array.length; index++)
			{
				if (array[index].getSuit().equalsIgnoreCase(suit))
				{
					currentMin = array[index];
					return index; // Return the index of the first card of the suit
				}
			}
			return -1; // Return -1 if no card of the suit is found
		}

}