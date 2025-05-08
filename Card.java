/**
 * Represents <what is this class?>
 * 
 * @author <name>
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
<class name>
-----------------------------------------
<data, i.e. variables>
-----------------------------------------
<actions, i.e. methods>
-----------------------------------------
*/

public class Card // don't forget to rename here and rename the file too!
{
	/***** STATIC VARIABLES *****/

	/***** INSTANCE VARIABLES *****/
	int number;
	String suit;
	boolean isSelected;
	/***** CONSTRUCTORS *****/
	/** Description: Default constructor that creates an ace of spades and is not selected */
	public Card()
	{
		number = 1; // Ace
		suit = "Spades";
		isSelected = false;
	}

	/** Description: Constructor that creates a card with the given number, suit, and selection status */
	public Card(int number, String suit, boolean selectedChoice)
	{
		this.number = number;
		this.suit = suit;
		isSelected = selectedChoice;
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
	}


	/***** ACCESSORS *****/
	/** 
	 * Returns the number of the card 
	 * @return the card's number
	 * */
	public int GetNumber()
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

	/***** OTHER REQUIRED METHODS *****/

	/** 
	 * Returns a string representation of the card
	 * @return a string representation of the card
	 */
	public String toString()
	{
		String numberSymbol;
		switch (this.number) 
		{
			case 1:
				numberSymbol = "A";
				break;
			case 11:
				numberSymbol = "J";
				break;
			case 12:
				numberSymbol = "Q";
				break;
			case 13:
				numberSymbol = "K";
				break;
			default:
				numberSymbol = String.valueOf(this.number);
				break;
        }

		String suitSymbol;
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

		String cardString;
		cardString = String.format("┌─────────┐%n");
		cardString += String.format("│%s%8s│%n", numberSymbol, "");
		cardString += String.format("│%9s│%n", "");
		cardString += String.format("│%5s%4s│%n", suitSymbol,  "");
		cardString += String.format("│%9s│%n", "");
		cardString += String.format("│%9s%s│%n", numberSymbol, "");
		cardString += String.format("└─────────┘%n");


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

}