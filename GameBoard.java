/**
 * Represents <what is this class?>
 * 
 * @author <name>
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Hand
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
	private static final int COLS = 80;

	/***** STATIC VARIABLES *****/
	// Arrays for the board and colors
	String[][] board = new String[ROWS][COLS];
	String[][] colors = new String[ROWS][COLS];
	
	/***** INSTANCE VARIABLES *****/

	/***** CONSTRUCTORS *****/

	/***** ACCESSORS *****/
	
	/***** MUTATORS *****/
	
	/***** OTHER REQUIRED METHODS *****/

	/***** HELPER METHODS *****/
	public void intializeBoard()
	{
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				board[r][c] = ".";
			}
		}
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

}