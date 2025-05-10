/**
 * Represents A card in the game with a number, suit, and selection status.
 * 
 * @author Muhammad Conn
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Card
-----------------------------------------
- RESET: String
- BLACK: String
- RED: String
- GREEN: String
- YELLOW: String
- BLUE: String
- PURPLE: String
- CYAN: String
- WHITE: String
- ORANGE: String
- number: int
- suit: String
- isSelected: boolean
- rowCoord: int
- colCoord: int
-----------------------------------------
+ GetNumber(): int
+ getSuit(): String
+ getSelected(): boolean
+ getRowCoord(): int
+ getColCoord(): int
+ setNumber(number: int): void
+ setSuit(suit: String): void
+ setSelected(selected: boolean): void
+ setRowCoord(row: int): void
+ setColCoord(col: int): void
+ setAll(number: int, suit: String, selected: boolean, row: int, col: int): void
+ toString(): String
+ equals(other: Card): boolean
+ cardToLines(line: int): String
+ cardToLinesArray(): String[]
+ suitToColor(): String
-----------------------------------------
*/

public class Card // don't forget to rename here and rename the file too!
{
	/***** STATIC VARIABLES *****/

	// Color Codes
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

	/***** INSTANCE VARIABLES *****/
	int number;
	String suit;
	boolean isSelected;
	// Coordiantes of the card on the game baord
	int rowCoord;
	int colCoord;
	/***** CONSTRUCTORS *****/
	/** Description: Default constructor that creates an ace of spades and is not selected */
	public Card()
	{
		number = 1; // Ace
		suit = "Spades";
		isSelected = false;
		rowCoord = 0;
		colCoord = 0;
	}

	/** Description: Constructor that creates a card with the given number, suit, and selection status */
	public Card(int number, String suit, boolean selectedChoice, int row, int col)
	{
		this.number = number;
		this.suit = suit;
		this.isSelected = selectedChoice;
		this.rowCoord = row;
		this.colCoord = col;
	}

	/** 
	 * Copy constructor that copies the value of a source card 
	 *@param other Source card to be copied
	 */
	public Card(Card other)
	{
		this.number = other.number;
		this.suit = other.suit;
		this.isSelected = other.isSelected;
		this.rowCoord = other.rowCoord;
		this.colCoord = other.colCoord;
	}


	/***** ACCESSORS *****/
	/** 
	 * Returns the number of the card 
	 * @return the card's number
	 * */
	public int getNumber()
	{
		return this.number;
	}

	/** 
	 * Returns the suit of the card 
	 * @return the card's suit
	 * */
	public String getSuit()
	{
		return this.suit;
	}

	/** 
	 * Returns the selection status of the card 
	 * @return the selection status of the card
	 * */
	public boolean getSelected()
	{
		return this.isSelected;
	}

	/** 
	 * Returns the row coordinate of the card 
	 * @return the row coordinate of the card
	 * */
	public int getRowCoord()
	{
		return this.rowCoord;
	}

	/** 
	 * Returns the column coordinate of the card 
	 * @return the column coordinate of the card
	 * */
	public int getColCoord()
	{
		return this.colCoord;
	}
	/***** MUTATORS *****/
	/** 
	 * Sets the number of the card 
	 * @param number the card's number
	 * */
	public void setNumber(int number)
	{
		this.number = number;
	}

	/** 
	 * Sets the suit of the card 
	 * @param suit the card's suit
	 * */
	public void setSuit(String suit)
	{
		this.suit = suit;
	}

	/**
	 * Sets the selection status of the card
	 * @param selected the selection status of the card
	 */
	public void setSelected(boolean selected)
	{
		this.isSelected = selected;
	}

	/**
	 * Sets the row coordinate of the card
	 * @param row the row coordinate of the card
	 */
	public void setRowCoord(int row)
	{
		this.rowCoord = row;
	}

	/**
	 * Sets the column coordinate of the card
	 * @param col the column coordinate of the card
	 */
	public void setColCoord(int col)
	{
		this.colCoord = col;
	}

	/**
	 * Sets all the properties of the card
	 * @param number int for number of the card
	 * @param suit String for suit of the card
	 * @param selected boolean for selection status of the card
	 * @param row int for row coordinate of the card
	 * @param col int for column coordinate of the card
	 */
	public void setAll(int number, String suit, boolean selected, int row, int col)
	{
		this.rowCoord = row;
		this.colCoord = col;
		this.number = number;
		this.suit = suit;
		this.isSelected = selected;
	}

	/***** OTHER REQUIRED METHODS *****/

	/** 
	 * Returns a string representation of the card
	 * @return a string representation of the card
	 */
	@Override
	public String toString()
	{
		System.out.println("Card: " + this.number + " of " + this.suit + " isSelected: " + this.isSelected + " at (" + this.rowCoord + ", " + this.colCoord + ")");
		String cardString = this.suitToColor();
		for (int line = 0; line < 7; line++)
		{
			cardString += cardToLines(line) + "\n";
		}
		cardString += RESET; // Reset color at the end of the card string
		return cardString;
	}

	/**
	 * Checks if two cards are equal
	 * @param other
	 * @return true if the cards are equal, false otherwise
	 */
	public boolean equals(Card other)
	{
		return (this.number == other.number && this.suit.equals(other.suit) && this.isSelected == other.isSelected);
	}
	/***** HELPER METHODS *****/

	public String cardToLines(int line)
	{
		// Varuables needed for card construction
		String numberSymbol;
		String suitSymbol;
		String color;
		String specialSymbol;

		switch (this.number) 
		{
			case 1:
				numberSymbol = "A";
				specialSymbol = ""; // No special symbol for Ace
				break;
			case 11:
				numberSymbol = "J";
				specialSymbol = "🎭";
				break;
			case 12:
				numberSymbol = "Q";
				specialSymbol = "👸";
				break;
			case 13:
				numberSymbol = "K";
				specialSymbol = "🤴";
				break;
			default:
				numberSymbol = String.valueOf(this.number);
				specialSymbol = ""; // No special symbol for numbers 2-10
				break;
		}

		
		if (this.suit.equalsIgnoreCase("Spades"))
		{
			suitSymbol = "♠";
		}
		else if (this.suit.equalsIgnoreCase("Hearts"))
		{
			suitSymbol = "♥";
		}
		else if (this.suit.equalsIgnoreCase("Diamonds"))
		{
			suitSymbol = "♦";
		}
		else if (this.suit.equalsIgnoreCase("Clubs"))
		{
			suitSymbol = "♣";
		}
		else
		{
			suitSymbol = "?"; // Unknown suit
		}

		color = this.suitToColor();


		String cardString = "";
		switch (line) {
			case 0:
				cardString = String.format("┌─────────┐");
				break;
			case 1:
				if (numberSymbol.equals("10"))
				{
					cardString = String.format("│%s%7s│", numberSymbol, "");
				}
				else
				{
					cardString = String.format("│%s%8s│", numberSymbol, "");
				}
				break;
			case 2:
				cardString = String.format("│%9s│", "");
				break;
			case 3:
				cardString = String.format("│%5s%4s│", suitSymbol,  "");
				break;
			case 4:
				cardString = String.format("│%9s│", "");
				break;
			case 5:
				cardString = String.format("│%s%9s│", "", numberSymbol);
				break;
			case 6:
				cardString = String.format("└─────────┘");
				break;
		}
		return cardString;
	}

	public String[] cardToLinesArray()
	{
		String[] cardLines = new String[7];
		for (int i = 0; i < 7; i++)
		{
			cardLines[i] = cardToLines(i);
		}
		return cardLines;
	}

	public String suitToColor()
	{
		if (this.suit.equalsIgnoreCase("Hearts"))
		{
			return RED;
		}
		else if (this.suit.equalsIgnoreCase("Diamonds"))
		{
			return ORANGE;
		}
		else if (this.suit.equalsIgnoreCase("Spades"))
		{
			return RESET; //Black doesn't show up on the console so we keep it defualt
		}
		else // Clubs
		{
			return BLUE;
		}
	}


}