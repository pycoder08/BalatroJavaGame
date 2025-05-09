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
	private static final int COLS = 160;
	private static final int HAND_COL = 35;
	private static final int HAND_ROW = 25;
	private static final int CARD_COL = HAND_COL + 2;
	private static final int CARD_ROW = HAND_ROW + 1;
	private static final int HAND_CELL_WIDTH = 14;

	/***** STATIC VARIABLES *****/
	// Arrays for the board, colors, and deck
	static String[][] board = new String[ROWS][COLS];
	static String[][] colors = new String[ROWS][COLS]; // Stores the color of each cell to be applied when printing
	static Card[] deck = new Card[52];
	// Fill the deck with cards
	{
		for (int i = 0; i < 13; i++)
		{
			deck[i] = new Card(i + 1, "Spades", false);
		}
		for (int i = 13; i < 26; i++)
		{
			deck[i] = new Card(i - 12, "Hearts", false);
		}
		for (int i = 26; i < 39; i++)
		{
			deck[i] = new Card(i - 25, "Diamonds", false);
		}
		for (int i = 39; i < 52; i++)
		{
			deck[i] = new Card(i - 38, "Clubs", false);
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
		printBox(0,0, ROWS, COLS); // Draw the outer border of the board
		printHorizBoxes(HAND_ROW, HAND_COL, 9, HAND_CELL_WIDTH, 7); // Draw the hand box
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
	 * @param row The starting row for the box
	 * @param col The starting column for the box
	 * @param height The height of the box
	 * @param width The width of the box
	 */
	public void printBox(int row, int col, int height, int width)
	{
		// Add the corner symbols
		board[row][col] = "┌";
		board[row][col + width - 1] = "┐";
		board[row + height - 1][col] = "└";
		board[row + height - 1][col + width - 1] = "┘";

		// Add the borders using loops
		for (int c = col + 1; c < col + width - 1; c++)
		{
			board[row][c] = "─";
		}
		for (int c = col + 1; c < col + width - 1; c++)
		{
			board[row + height - 1][c] = "─";
		}
		for (int r = row + 1; r < row + height - 1; r++)
		{
			board[r][col] = "│";
		}
		for (int r = row + 1; r < row + height - 1; r++)
		{
			board[r][col + width - 1] = "│";
		}
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

		int totalWidth = cellWidth * cells;

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
			board[bot][col + totalWidth] = "┘";
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
					deck[j] = null; // Remove the card from the deck
					dealtCards++;
				}
			}
		}

		/**
		 * Prints the player's hand of cards on the game board.
		 */
		public void printHand()
		{
			for (int i = 0; i < hand.length; i++)
			{
				if (hand[i] != null)
				{
					stampBoard(hand[i].cardToLinesArray(), CARD_ROW, CARD_COL + (i * HAND_CELL_WIDTH), hand[i].suitToColor());
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
				Card temp = deck[i];
				deck[i] = deck[randomIndex];
				deck[randomIndex] = temp;
			}
		}

}