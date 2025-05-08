/**
 * Represents <what is this class?>
 * 
 * @author <name>
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
GameBoard
-----------------------------------------
<data, i.e. variables>
-----------------------------------------
<actions, i.e. methods>
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
	// Arrays for the board and colors
	String[][] board = new String[ROWS][COLS];
	String[][] colors = new String[ROWS][COLS];
	Card[] deck = new Card[52];
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

	/***** CONSTRUCTORS *****/

	/***** ACCESSORS *****/
	
	/***** MUTATORS *****/
	
	/***** OTHER REQUIRED METHODS *****/

	/***** HELPER METHODS *****/
	/**
	 * Initializes the game board with borders and empty spaces.
	 */
	public void intializeBoard()
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
		printBox(0,0, ROWS, COLS);
		printHorizBoxes(HAND_ROW, HAND_COL, 9, HAND_CELL_WIDTH, 7);




	}

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
					board[row][col + x] = "┬";       // interior T-junction
				} else {
					board[row][col + x] = "─";       // horizontal line
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
					board[bot][col + x] = "┴";
				} else {
					board[bot][col + x] = "─";
				}
			}
			board[bot][col + totalWidth] = "┘";
		}

		public void dealHand()
		{
			for (int i = 0; i < 7; i++)
			{
				int randomIndex = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, 52);
				Card randomCard = deck[randomIndex];
				stampBoard(randomCard.cardToLinesArray(), CARD_ROW, CARD_COL + (i * HAND_CELL_WIDTH), randomCard.suitToColor());
			}
		}

}