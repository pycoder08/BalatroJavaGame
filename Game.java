import java.util.Scanner;

/**
 * Represents The game board. Has no instance variables and just encapsulates all game logic
 * 
 * @author Muhammad Conn
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Game
-----------------------------------------
- ROWS: int
- COLS: int
- HAND_COL: int
- HAND_ROW: int
- CARD_COL: int
- CARD_ROW: int
- CARD_WIDTH: int
- HAND_CELL_WIDTH: int
- HAND_CELL_HEIGHT: int
- LEGEND_ROW: int
- LEGEND_COL: int
- LEGEND_WIDTH: int
- LEGEND_HEIGHT: int
- SCORE_BOARD_ROW: int
- SCORE_BOARD_COL: int
- SCORE_BOARD_WIDTH: int
- SCORE_BOARD_HEIGHT: int
- DECK_ROW: int
- DECK_COL: int
- POINTS_ROW: int
- POINTS_COL: int
- X_ROW: int
- X_COL: int
- MULT_ROW: int
- MULT_COL: int
- SCORE_BOX_HEIGHT: int
- SCORE_BOX_ROW: int
- SCORE_BOX_COL: int
- SCORE_BOX_WIDTH: int
- SCORE_ROW: int
- SCORE_COL: int
- WIN_BOX_HEIGHT: int
- WIN_BOX_WIDTH: int
- WIN_BOX_ROW: int
- WIN_BOX_COL: int
- GOAL_ROW: int
- GOAL_COL: int
- GOAL_WIDTH: int
- GOAL_HEIGHT: int
- STRAIGHT_POINTS: int
- STRAIGHT_MULT: int
- FLUSH_POINTS: int
- FLUSH_MULT: int
- STRAIGHT_FLUSH_POINTS: int
- STRAIGHT_FLUSH_MULT: int
- HIGH_POINTS: int
- HIGH_MULT: int
- TWO_POINTS: int
- TWO_MULT: int
- THREE_POINTS: int
- THREE_MULT: int
- FOUR_POINTS: int
- FOUR_MULT: int
- PAIR_POINTS: int
- PAIR_MULT: int
- HOUSE_POINTS: int
- HOUSE_MULT: int
- STARTER_HANDS: int
- STARTER_DISCARDS: int
- LEVEL_ONE_GOAL: int
- LEVEL_TWO_GOAL: int
- LEVEL_THREE_GOAL: int
- LEVEL_FOUR_GOAL: int
- LEVEL_FIVE_GOAL: int
- RED: String
- GREEN: String
- YELLOW: String
- BLUE: String
- PURPLE: String
- CYAN: String
- WHITE: String
- ORANGE: String
- MAGENTA: String
- DARK_RED: String
- LIME: String
- EMPTY_CARD: String[]
- SUITS_ARRAY: String[]
- CARD_BACK: String[]
- DASHED_CARD: String[]
- legendArray: String[]
- BLANK_SCORE: String[]
- HELP_ARRAY: String[]
- STRAIGHT_ARRAY: String[]
- FLUSH_ARRAY: String[]
- STRAIGHT_FLUSH_ARRAY: String[]
- HIGH_CARD_ARRAY: String[]
- TWO_KIND_ARRAY: String[]
- THREE_KIND_ARRAY: String[]
- FOUR_KIND_ARRAY: String[]
- HOUSE_ARRAY: String[]
- TWO_PAIR_ARRAY: String[]
- ZERO_ARRAY: String[]
- ONE_ARRAY: String[]
- TWO_ARRAY: String[]
- THREE_ARRAY: String[]
- FOUR_ARRAY: String[]
- FIVE_ARRAY: String[]
- SIX_ARRAY: String[]
- SEVEN_ARRAY: String[]
- EIGHT_ARRAY: String[]
- NINE_ARRAY: String[]
- NUMBERS_ARRAY: String[][]
- X_ARRAY: String[]
- WIN_ARRAY: String[]
- FAIL_ARRAY: String[]
- board: String[][]
- colors: String[][]
- saveBoard: String[][]
- saveColors: String[][]
- deck: Card[]
- deckLength: int
- hand: Card[]
- selectedCards: Card[]
- dealtCardsCount: int
- selectedCardsCount: int
- hands: int
- discards: int
- sortType: int
- currentHandType: String
- currentPoints: int
- currentMult: int
- currentScore: int
- targetNum: int[]
- targetNumLength: int
- viewingHelp: boolean
- currentGoal: int
- currentLevel: int
-----------------------------------------
+ Game()
+ Game(String[][], String[][], String[][], String[][], Card[], int, Card[], Card[], int, int, int, int, int, String, int, int, int, int[], int, boolean, int, int)
+ Game(Game)
+ getBoard(): String[][]
+ getColors(): String[][]
+ getSaveBoard(): String[][]
+ getSaveColors(): String[][]
+ getDeck(): Card[]
+ getDeckLength(): int
+ getHand(): Card[]
+ getSelectedCards(): Card[]
+ getDealtCardsCount(): int
+ getSelectedCardsCount(): int
+ getHands(): int
+ getDiscards(): int
+ getSortType(): int
+ getCurrentHandType(): String
+ getCurrentPoints(): int
+ getCurrentMult(): int
+ getCurrentScore(): int
+ getTargetNum(): int[]
+ getTargetNumLength(): int
+ isViewingHelp(): boolean
+ getCurrentGoal(): int
+ getCurrentLevel(): int
+ setBoard(String[][]): void
+ setColors(String[][]): void
+ setSaveBoard(String[][]): void
+ setSaveColors(String[][]): void
+ setDeck(Card[]): void
+ setDeckLength(int): void
+ setHand(Card[]): void
+ setSelectedCards(Card[]): void
+ setDealtCardsCount(int): void
+ setSelectedCardsCount(int): void
+ setHands(int): void
+ setDiscards(int): void
+ setSortType(int): void
+ setCurrentHandType(String): void
+ setCurrentPoints(int): void
+ setCurrentMult(int): void
+ setCurrentScore(int): void
+ setTargetNum(int[]): void
+ setTargetNumLength(int): void
+ setViewingHelp(boolean): void
+ setCurrentGoal(int): void
+ setCurrentLevel(int): void
+ toString(): String
+ equals(Game): boolean
+ playGame(): void
- initializeBoard(): void
- stampBoard(String[], int, int, String): void
- printBoard(boolean): void
- printHandDisc(): void
- printDeckRemaining(): void
- printBox(int, int, int, int, String): void
- printHorizBoxes(int, int, int, int, int): void
- printHandGrid(): void
- printLegend(): void
- printScoreBoard(): void
- printCardBack(int, int): void
- printHandText(): void
- printHelp(): void
- printHandTip(Card[], String): void
- printCards(Card[]): void
- printHand(): void
- erase(int, int, int, int): void
- eraseCard(Card[], int): void
- eraseHand(): void
- eraseScoreBoard(): void
- erasePlayBoard(): void
- dealHand(): void
- shuffleDeck(): void
- selectCard(int): boolean
- removeSelectedCards(): void
- discard(): void
- refillHand(): void
- sortHand(int): void
- intToAscii(String): String[]
- centerAscii(String[], int): String[]
- fillDeck(): void
- swapIndeces(Card[], int, int): void
- handToSelectedIndex(int): int
- indexOfMin(Card[], int): int
- indexOfSuit(Card[], int, String): int
- siftArray(Card[]): void
- appendCard(Card[], Card): void
- appendInt(int[], int): void
- eraseInt(int[]): void
- deepCopyBoard(String[][]): String[][]
- returnHighestCard(Card[]): int
- returnIfAce(Card[]): int
- checkForFlush(): boolean
- checkForStraight(): boolean
- checkForKind(): int
- checkForStraightFlush(): boolean
- checkForHighCard(): boolean
- checkForTwoOfAKind(): boolean
- checkForThreeOfAKind(): boolean
- checkForFourOfAKind(): boolean
- checkForFullHouse(): boolean
- checkForTwoPair(): boolean
- checkHandType(): String
- playHand(): void
- scoreCards(Card[]): void
- scoreCard(Card): void
- checkWin(): boolean
- checkLoss(): boolean
- updateGoal(): void
- clearHand(): void
- testPrintSelected(): void
- testPrintHand(): void
- testPrintDeck(): void
- testPrintStringArray(String[]): void
-----------------------------------------
*/

public class Game
{
	
	/***** CONSTANTS  *****/

	// Constants used in placing elements on the board
	private static final int ROWS = 41;
	private static final int COLS = 165;
	private static final int HAND_COL = 60;
	private static final int HAND_ROW = ROWS - 11; // 12 rows from the bottom
	private static final int CARD_COL = HAND_COL + 2;
	private static final int CARD_ROW = HAND_ROW + 1;
	private static final int CARD_WIDTH = 11; // While this doesn't control the width of the card, it is convenient to have as a constant
	private static final int HAND_CELL_WIDTH = 14;
	private static final int HAND_CELL_HEIGHT = 9;
	private static final int LEGEND_ROW = HAND_ROW;
	private static final int LEGEND_COL = 5;
	private static final int LEGEND_WIDTH = 26;
	private static final int LEGEND_HEIGHT = 9;
	private static final int SCORE_BOARD_ROW = 2;
	private static final int SCORE_BOARD_COL = 5;
	private static final int SCORE_BOARD_WIDTH = 51;
	private static final int SCORE_BOARD_HEIGHT = 27;

	// Constants for the deck symbol
	private static final int DECK_ROW = CARD_ROW;
	private static final int DECK_COL = SCORE_BOARD_COL + SCORE_BOARD_WIDTH - CARD_WIDTH;

	private static final int POINTS_ROW = SCORE_BOARD_ROW + SCORE_BOARD_HEIGHT - 8; // The score should be a little from the bottom of the scoreboard. Makes for easier changes
	private static final int POINTS_COL =  SCORE_BOARD_COL + 2; // The score is a little to the right of the left edge of the score board

	// Constants for the X on the scoreboard
	private static final int X_ROW = POINTS_ROW + 1;
	private static final int X_COL = POINTS_COL + 20;

	// Constants for the mult number
	private static final int MULT_ROW = POINTS_ROW;
	private static final int MULT_COL = X_COL + 8; 
	

	// Dimenstions and location for the score box, linked to where the points are printed
	private static final int SCORE_BOX_HEIGHT = 9;
	private static final int SCORE_BOX_ROW = POINTS_ROW - SCORE_BOX_HEIGHT;
	private static final int SCORE_BOX_COL = POINTS_COL;
	private static final int SCORE_BOX_WIDTH = SCORE_BOARD_WIDTH - 2 * (POINTS_COL - SCORE_BOARD_COL);

	// Constants for the score
	private static final int SCORE_ROW = SCORE_BOX_ROW + 1;
	private static final int SCORE_COL = SCORE_BOARD_COL + 3;

	// Constants for the win/lose box
	private static final int WIN_BOX_HEIGHT = 9;
	private static final int WIN_BOX_WIDTH = 50;
	private static final int WIN_BOX_ROW = (ROWS/2) - (WIN_BOX_HEIGHT/2);
	private static final int WIN_BOX_COL = COLS/2 - WIN_BOX_WIDTH/2;

	// Constants for the goal score box
	private static final int GOAL_ROW = SCORE_BOARD_ROW;
	private static final int GOAL_COL = 120;
	private static final int GOAL_WIDTH = 40;
	private static final int GOAL_HEIGHT = 9;

	// Constants for how much a hand scores
	private static final int STRAIGHT_POINTS = 30;
	private static final int STRAIGHT_MULT = 4;

	// Constants for each hand score
	private static final int FLUSH_POINTS = 35;
	private static final int FLUSH_MULT = 4;

	private static final int STRAIGHT_FLUSH_POINTS = 100;
	private static final int STRAIGHT_FLUSH_MULT = 8;

	private static final int HIGH_POINTS = 5;
	private static final int HIGH_MULT = 1;

	private static final int TWO_POINTS = 10;
	private static final int TWO_MULT = 2;

	private static final int THREE_POINTS = 30;
	private static final int THREE_MULT = 3;

	private static final int FOUR_POINTS = 60;
	private static final int FOUR_MULT = 7;

	private static final int PAIR_POINTS = 20;
	private static final int PAIR_MULT = 2;

	private static final int HOUSE_POINTS = 40;
	private static final int HOUSE_MULT = 4;

	// Starter hands and discards
	private static final int STARTER_HANDS = 4;
	private static final int STARTER_DISCARDS = 4;

	// Score goals
	private static final int LEVEL_ONE_GOAL = 250;
	private static final int LEVEL_TWO_GOAL = 400;
	private static final int LEVEL_THREE_GOAL = 750;
	private static final int LEVEL_FOUR_GOAL = 1500;
	private static final int LEVEL_FIVE_GOAL = 2000;

	// Color codes
	private static final String RED    = "\u001B[31m";
	private static final String GREEN  = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE   = "\u001B[34m";
	private static final String PURPLE = "\u001B[35m";
	private static final String CYAN   = "\u001B[36m";
	private static final String WHITE  = "\u001B[37m";
	private static final String ORANGE = "\u001B[38;2;255;165;0m";
	private static final String MAGENTA = "\u001B[38;2;255;0;255m";
	private static final String DARK_RED = "\u001B[38;2;139;0;0m";
	private static final String LIME = "\u001B[38;2;0;255;0m";

	// Empty card stamp to erase cards from the board
	private static final String[] EMPTY_CARD = new String[7];
	{
		EMPTY_CARD[0] = EMPTY_CARD[1] = EMPTY_CARD[2] = EMPTY_CARD[3] = EMPTY_CARD[4] = EMPTY_CARD[5] = EMPTY_CARD[6] = "           ";
	}

	private static final String[] SUITS_ARRAY = {"Spades", "Hearts", "Diamonds", "Clubs"}; // Array of suits

	private static final String[] CARD_BACK = new String[7];
	static {
		CARD_BACK[0] = "┌─────────┐";
		CARD_BACK[1] = "│# # # # #│";
		CARD_BACK[2] = "│# # # # #│";
		CARD_BACK[3] = "│# # # # #│";
		CARD_BACK[4] = "│# # # # #│";
		CARD_BACK[5] = "│# # # # #│";
		CARD_BACK[6] = "└─────────┘";
	}

	private static final String[] DASHED_CARD = new String[7];
	static {
		DASHED_CARD[0] = "┌ - - - - ┐";
		DASHED_CARD[1] = "│         │";
		DASHED_CARD[2] = "│         │";
		DASHED_CARD[3] = "│         │";
		DASHED_CARD[4] = "│         │";
		DASHED_CARD[5] = "│         │";
		DASHED_CARD[6] = "└ - - - - ┘";
	}

	// Array to keep legend text
	private static final String[] legendArray = new String[6];
	static {
		legendArray[0] = "Select: 1 - 7";
		legendArray[1] = "Discard: d";
		legendArray[2] = "Sort: s/n (suit/number)";
		legendArray[3] = "Play hand: p";
		legendArray[4] = "Help: h";
		legendArray[5] = "Quit: q";
	}

	// Array to keep blank spaces for erasing the score board
	private static final String[] BLANK_SCORE = new String [19];
	{
		for (int row = 0; row < BLANK_SCORE.length; row++)
		{
			BLANK_SCORE[row] = "";
			for (int col = 0; col < 48; col++)
			{
				BLANK_SCORE[row] += " ";
			}
		}
	}

	// Arrays to hold ascii art for different text

	private static final String[] HELP_ARRAY = new String[6];
	static {
		HELP_ARRAY[0] = " _   _ _____ _    ______ ";
		HELP_ARRAY[1] = "| | | |  ___| |   | ___ \\";
		HELP_ARRAY[2] = "| |_| | |__ | |   | |_/ /";
		HELP_ARRAY[3] = "|  _  |  __|| |   |  __/ ";
		HELP_ARRAY[4] = "| | | | |___| |___| |    ";
		HELP_ARRAY[5] = "\\_| |_|____/\\_____|_|    ";
	}


	private static final String[] STRAIGHT_ARRAY = new String[8];
	static {
		STRAIGHT_ARRAY[0] = " _____ _             _       _     _   ";
		STRAIGHT_ARRAY[1] = "/  ___| |           (_)     | |   | |  ";
		STRAIGHT_ARRAY[2] = "\\ `--.| |_ _ __ __ _ _  __ _| |__ | |_ ";
		STRAIGHT_ARRAY[3] = " `--. \\ __| '__/ _` | |/ _` | '_ \\| __|";
		STRAIGHT_ARRAY[4] = "/\\__/ / |_| | | (_| | | (_| | | | | |_ ";
		STRAIGHT_ARRAY[5] = "\\____/ \\__|_|  \\__,_|_|\\__, |_| |_|\\__|";
		STRAIGHT_ARRAY[6] = "                        __/ |          ";
		STRAIGHT_ARRAY[7] = "                       |___/           ";

	}

	private static final String[] FLUSH_ARRAY = new String[6];
	static {
		FLUSH_ARRAY[0] = " _____ _           _     ";
		FLUSH_ARRAY[1] = "|  ___| |         | |    ";
		FLUSH_ARRAY[2] = "| |_  | |_   _ ___| |__  ";
		FLUSH_ARRAY[3] = "|  _| | | | | / __| '_ \\ ";
		FLUSH_ARRAY[4] = "| |   | | |_| \\__ \\ | | |";
		FLUSH_ARRAY[5] = "\\_|   |_|\\__,_|___/_| |_|";
	}


	private static final String[] STRAIGHT_FLUSH_ARRAY = new String[11];
	static {
		STRAIGHT_FLUSH_ARRAY[0] = " _____ _             _       _     _   ";
		STRAIGHT_FLUSH_ARRAY[1] = "/  ___| |           (_)     | |   | |  ";
		STRAIGHT_FLUSH_ARRAY[2] = "\\ `--.| |_ _ __ __ _ _  __ _| |__ | |_ ";
		STRAIGHT_FLUSH_ARRAY[3] = " `--. \\ __| '__/ _` | |/ _` | '_ \\| __|";
		STRAIGHT_FLUSH_ARRAY[4] = "/\\__/ / |_| | | (_| | | (_| | | | | |_ ";
		STRAIGHT_FLUSH_ARRAY[5] = "______ ___|_|  \\__,_|_|\\__, |_| |_|\\__|";
		STRAIGHT_FLUSH_ARRAY[6] = "|  ___| |         | |   __/ |          ";
		STRAIGHT_FLUSH_ARRAY[7] = "| |_  | |_   _ ___| |__|___/           ";
		STRAIGHT_FLUSH_ARRAY[8] = "|  _| | | | | / __| '_ \\               ";
		STRAIGHT_FLUSH_ARRAY[9] = "| |   | | |_| \\__ \\ | | |             ";
		STRAIGHT_FLUSH_ARRAY[10] = "\\_|   |_|\\__,_|___/_| |_|              ";
	}

	private static final String[] HIGH_CARD_ARRAY = new String[8];
	static{
		HIGH_CARD_ARRAY[0] = " _   _ _       _       _____               _ ";
		HIGH_CARD_ARRAY[1] = "| | | (_)     | |     /  __ \\             | |";
		HIGH_CARD_ARRAY[2] = "| |_| |_  __ _| |__   | /  \\/ __ _ _ __ __| |";
		HIGH_CARD_ARRAY[3] = "|  _  | |/ _` | '_ \\  | |    / _` | '__/ _` |";
		HIGH_CARD_ARRAY[4] = "| | | | | (_| | | | | | \\__/\\ (_| | | | (_| |";
		HIGH_CARD_ARRAY[5] = "\\_| |_/_|\\__, |_| |_|  \\____/\\__,_|_|  \\__,_|";
		HIGH_CARD_ARRAY[6] = "          __/ |                            ";
		HIGH_CARD_ARRAY[7] = "         |___/                             ";
	}

	private static final String[] TWO_KIND_ARRAY = new String[9];
	static {
		TWO_KIND_ARRAY[0] = " _____                                  ";
		TWO_KIND_ARRAY[1] = "/ __  \\                                 ";
		TWO_KIND_ARRAY[2] = "`' / /'                                 ";
		TWO_KIND_ARRAY[3] = "  / /   __    ___    _    _           _ ";
		TWO_KIND_ARRAY[4] = "./ /___/ _|  / _ \\  | |  (_)         | |";
		TWO_KIND_ARRAY[5] = "\\_____| |_  / /_\\ \\ | | ___ _ __   __| |";
		TWO_KIND_ARRAY[6] = " / _ \\|  _| |  _  | | |/ / | '_ \\ / _` |";
		TWO_KIND_ARRAY[7] = "| (_) | |   | | | | |   <| | | | | (_| |";
		TWO_KIND_ARRAY[8] = " \\___/|_|   \\_| |_/ |_|\\_\\_|_| |_|\\__,_|";
	}

	private static final String[] THREE_KIND_ARRAY = new String[9];
	static {
		THREE_KIND_ARRAY[0] = " _____                                  ";
		THREE_KIND_ARRAY[1] = "|____ |                                 ";
		THREE_KIND_ARRAY[2] = "    / /                                 ";
		THREE_KIND_ARRAY[3] = "    \\ \\ __    ___    _    _           _ ";
		THREE_KIND_ARRAY[4] = ".___/ // _|  / _ \\  | |  (_)         | |";
		THREE_KIND_ARRAY[5] = "\\____/| |_  / /_\\ \\ | | ___ _ __   __| |";
		THREE_KIND_ARRAY[6] = " / _ \\|  _| |  _  | | |/ / | '_ \\ / _` |";
		THREE_KIND_ARRAY[7] = "| (_) | |   | | | | |   <| | | | | (_| |";
		THREE_KIND_ARRAY[8] = " \\___/|_|   \\_| |_/ |_|\\_\\_|_| |_|\\__,_|";
	}

	private static final String[] FOUR_KIND_ARRAY = new String[9];
	static{
		FOUR_KIND_ARRAY[0] = "   ___                                  ";
		FOUR_KIND_ARRAY[1] = "  /   |                                 ";
		FOUR_KIND_ARRAY[2] = " / /| |                                 ";
		FOUR_KIND_ARRAY[3] = "/ /_| | __    ___    _    _           _ ";
		FOUR_KIND_ARRAY[4] = "\\___  |/ _|  / _ \\  | |  (_)         | |";
		FOUR_KIND_ARRAY[5] = "  ____| |_  / /_\\ \\ | | ___ _ __   __| |";
		FOUR_KIND_ARRAY[6] = " / _ \\|  _| |  _  | | |/ / | '_ \\ / _` |";
		FOUR_KIND_ARRAY[7] = "| (_) | |   | | | | |   <| | | | | (_| |";
		FOUR_KIND_ARRAY[8] = " \\___/|_|   \\_| |_/ |_|\\_\\_|_| |_|\\__,_|";
	}

	private static final String[] HOUSE_ARRAY = new String[9];
	static {
		HOUSE_ARRAY[0] = "       ______     _ _       ";
		HOUSE_ARRAY[1] = "       |  ___|   | | |      ";
		HOUSE_ARRAY[2] = "       | |_ _   _| | |      ";
		HOUSE_ARRAY[3] = " _   _ |  _| | | | | |      ";
		HOUSE_ARRAY[4] = "| | | || | | |_| | | |      ";
		HOUSE_ARRAY[5] = "| |_| |\\_|_ \\__,_|_|_|  ___ ";
		HOUSE_ARRAY[6] = "|  _  |/ _ \\| | | / __|/ _ \\";
		HOUSE_ARRAY[7] = "| | | | (_) | |_| \\__ \\  __/";
		HOUSE_ARRAY[8] = "\\_| |_/\\___/ \\__,_|___/\\___|";
	}



	private static final String[] TWO_PAIR_ARRAY = new String[7];
	static{
		TWO_PAIR_ARRAY[0] = ""; // Blank line for alignment
		TWO_PAIR_ARRAY[1] = " _____              ______     _      ";
		TWO_PAIR_ARRAY[2] = "|_   _|             | ___ \\   (_)     ";
		TWO_PAIR_ARRAY[3] = "  | |_      _____   | |_/ /_ _ _ _ __ ";
		TWO_PAIR_ARRAY[4] = "  | \\ \\ /\\ / / _ \\  |  __/ _` | | '__|";
		TWO_PAIR_ARRAY[5] = "  | |\\ V  V / (_) | | | | (_| | | |   ";
		TWO_PAIR_ARRAY[6] = "  \\_/ \\_/\\_/ \\___/  \\_|  \\__,_|_|_|   ";
	}

	// Arrays to hold ascii art for numbers

	private static final String[] ZERO_ARRAY = new String[6];
	static {
		ZERO_ARRAY[0] = " _____ ";
		ZERO_ARRAY[1] = "|  _  |";
		ZERO_ARRAY[2] = "| |/' |";
		ZERO_ARRAY[3] = "| |/| |";
		ZERO_ARRAY[4] = "\\ |_/ /";
		ZERO_ARRAY[5] = " \\___/ ";
	}

	private static final String[] ONE_ARRAY = new String[6];
	static {
		ONE_ARRAY[0] = " __  ";
		ONE_ARRAY[1] = "/  | ";
		ONE_ARRAY[2] = "`| | ";
		ONE_ARRAY[3] = " | | ";
		ONE_ARRAY[4] = "_| |_";
		ONE_ARRAY[5] = "\\___/";
	}
	
	private static final String[] TWO_ARRAY = new String[6];
	static {
		TWO_ARRAY[0] = " _____ ";
		TWO_ARRAY[1] = "/ __  \\";
		TWO_ARRAY[2] = "`' / /'";
		TWO_ARRAY[3] = "  / /  ";
		TWO_ARRAY[4] = "./ /___";
		TWO_ARRAY[5] = "\\_____/";
	}

	private static final String[] THREE_ARRAY = new String[6];
	static {
		THREE_ARRAY[0] = " _____ ";
		THREE_ARRAY[1] = "|____ |";
		THREE_ARRAY[2] = "    / /";
		THREE_ARRAY[3] = "    \\ \\";
		THREE_ARRAY[4] = ".___/ /";
		THREE_ARRAY[5] = "\\____/ ";
	}

	private static final String[] FOUR_ARRAY = new String[6];
	static{
		FOUR_ARRAY[0] = "   ___ ";
		FOUR_ARRAY[1] = "  /   |";
		FOUR_ARRAY[2] = " / /| |";
		FOUR_ARRAY[3] = "/ /_| |";
		FOUR_ARRAY[4] = "\\___  |";
		FOUR_ARRAY[5] = "    |_/";
	}

	private static final String[] FIVE_ARRAY = new String[6];
	static {
		FIVE_ARRAY[0] = " _____ ";
		FIVE_ARRAY[1] = "|  ___|";
		FIVE_ARRAY[2] = "|___ \\ ";
		FIVE_ARRAY[3] = "    \\ \\";
		FIVE_ARRAY[4] = "/\\__/ /";
		FIVE_ARRAY[5] = "\\____/ ";
	}

	private static final String[] SIX_ARRAY = new String[6];
	static {
		SIX_ARRAY[0] = "  ____ ";
		SIX_ARRAY[1] = " / ___|";
		SIX_ARRAY[2] = "/ /___ ";
		SIX_ARRAY[3] = "| ___ \\";
		SIX_ARRAY[4] = "| \\_/ |";
		SIX_ARRAY[5] = "\\_____/"; 
	}

	private static final String[] SEVEN_ARRAY = new String[6];
	static {
		SEVEN_ARRAY[0] = " ______";
		SEVEN_ARRAY[1] = "|___  /";
		SEVEN_ARRAY[2] = "   / / ";
		SEVEN_ARRAY[3] = "  / /  ";
		SEVEN_ARRAY[4] = "./ /   ";
		SEVEN_ARRAY[5] = "\\_/    ";
	}

	private static final String[] EIGHT_ARRAY = new String[6];
	static {
		EIGHT_ARRAY[0] = " _____ ";
		EIGHT_ARRAY[1] = "|  _  |";
		EIGHT_ARRAY[2] = " \\ V / ";
		EIGHT_ARRAY[3] = " / _ \\ ";
		EIGHT_ARRAY[4] = "| |_| |";
		EIGHT_ARRAY[5] = "\\_____/"; 
	}

	private static final String[] NINE_ARRAY = new String[6];
	static {
		NINE_ARRAY[0] = " _____ ";
		NINE_ARRAY[1] = "|  _  |";
		NINE_ARRAY[2] = "| |_| |";
		NINE_ARRAY[3] = "\\____ |";
		NINE_ARRAY[4] = ".___/ /";
		NINE_ARRAY[5] = "\\____/ ";
	}

	// Array for all the number arrays
	private static final String[][] NUMBERS_ARRAY = new String[10][];
	static {
		NUMBERS_ARRAY[0] = ZERO_ARRAY;
		NUMBERS_ARRAY[1] = ONE_ARRAY;
		NUMBERS_ARRAY[2] = TWO_ARRAY;
		NUMBERS_ARRAY[3] = THREE_ARRAY;
		NUMBERS_ARRAY[4] = FOUR_ARRAY;
		NUMBERS_ARRAY[5] = FIVE_ARRAY;
		NUMBERS_ARRAY[6] = SIX_ARRAY;
		NUMBERS_ARRAY[7] = SEVEN_ARRAY;
		NUMBERS_ARRAY[8] = EIGHT_ARRAY;
		NUMBERS_ARRAY[9] = NINE_ARRAY;
	}

	private static final String[] X_ARRAY = new String[4];
	static {
		X_ARRAY[0] = "__   __";
		X_ARRAY[1] = "\\ \\_/ /";
		X_ARRAY[2] = " > _ < ";
		X_ARRAY[3] = "/_/ \\_\\";
	}

	private static final String[] WIN_ARRAY = new String[6];
	static {
		WIN_ARRAY[0] = " _    _ _____ _   _ _ ";
		WIN_ARRAY[1] = "| |  | |_   _| \\ | | |";
		WIN_ARRAY[2] = "| |  | | | | |  \\| | |";
		WIN_ARRAY[3] = "| |/\\| | | | | . ` | |";
		WIN_ARRAY[4] = "\\  /\\  /_| |_| |\\  |_|";
		WIN_ARRAY[5] = " \\/  \\/ \\___/\\_| \\_(_)";
	}

	private static final String[] FAIL_ARRAY = new String[6];
	static {
		FAIL_ARRAY[0] = "______ ___  _____ _     ";
		FAIL_ARRAY[1] = "|  ___/ _ \\|_   _| |    ";
		FAIL_ARRAY[2] = "| |_ / /_\\ \\ | | | |    ";
		FAIL_ARRAY[3] = "|  _||  _  | | | | |    ";
		FAIL_ARRAY[4] = "| |  | | | |_| |_| |____";
		FAIL_ARRAY[5] = "\\_|  \\_| |_/\\___/\\_____/"; 
	}


	/***** STATIC VARIABLES *****/
	
	/***** INSTANCE VARIABLES *****/
	// Board display variables 
	String[][] board;
	String[][] colors;
	String[][] saveBoard; // Backup array to save the game board before we erase it
	String[][] saveColors; // Backup array for the colors on the board

	// Deck variables
	Card[] deck;
	int deckLength = 52; // Int for how big the deck is

	// Hand and selection variables
	Card[] hand; // Array to hold the player's hand
	Card[] selectedCards;
	int dealtCardsCount; // Int to keep track of dealt cards
	int selectedCardsCount; // Int to keep track of selected cards

	// Game logic variables
	int hands; // number of hands you have left
	int discards; // Number of discards you have left

	int sortType; /// Int to keep track of the sort kind. Set to 0 by default
	String currentHandType; // Int to keep track of the current hand type.
	int currentPoints; // Int to keep track of the current points
	int currentMult; // Int to keep track of the current multiplier
	int currentScore; // Int to keep track of the overall score

	int[] targetNum; // Int used for scoring hands where only certain cards should count. The second value is only used for two pair
	int targetNumLength; // Since targetNum can be partially filled we need a var to keep track of its length

	boolean viewingHelp; // Int for wheter the user is viewing the help page or not

	int currentGoal; // Int for the current goal to reach
	int currentLevel; // Int to keep track of the current level

	

	/***** CONSTRUCTORS *****/
	
	/**
	 * Initializes a game object with default values for the very start of the game
	 */
	public Game()
	{
		this.board = new String[ROWS][COLS]; // initialize the board with default dimensions
		this.colors = new String[ROWS][COLS]; // Stores the color of each cell to be applied when printing

		this.deck = new Card[52]; // Initialize the deck of length 52 by default
		this.fillDeck(); // Fill the deck with default cards
		this.hand = new Card[7]; // Init hand array
		this.selectedCards = new Card[5]; // Initialize the selected cards array
		this.dealtCardsCount = 0;
		this.selectedCardsCount = 0;


		// Game logic
		this.hands = STARTER_HANDS;
		this.discards = STARTER_DISCARDS;

		// Initialize the save state arrays as blank
		this.saveBoard = new String[ROWS][COLS];
		this.saveColors = new String[ROWS][COLS];
		this.sortType = 0; // Init sort type as numbers
		this.currentHandType = ""; // No hand type yet
		this.currentPoints = 0;
		this.currentMult = 1;
		this.currentScore = 0;

		this.targetNum = new int[2]; // Keep this blank by default
		this.targetNumLength  = 0; // Nothing here yet

		this.viewingHelp = false;

		this.currentGoal = LEVEL_ONE_GOAL;
		this.currentLevel = 1;
	}

	/**
	 * Full constructor for Game. Initializes all instance variables.
	 */
	public Game(String[][] board, String[][] colors, String[][] saveBoard, String[][] saveColors, Card[] deck, int deckLength, Card[] hand, Card[] selectedCards, int dealtCardsCount, int selectedCardsCount, 
	int hands, int discards, int sortType, String currentHandType, int currentPoints, int currentMult, int currentScore, int[] targetNum, int targetNumLength, boolean viewingHelp, int currentGoal, int currentLevel) 
	{
		this.board = board;
		this.colors = colors;
		this.saveBoard = saveBoard;
		this.saveColors = saveColors;
		this.deck = deck;
		this.deckLength = deckLength;
		this.hand = hand;
		this.selectedCards = selectedCards;
		this.dealtCardsCount = dealtCardsCount;
		this.selectedCardsCount = selectedCardsCount;
		this.hands = hands;
		this.discards = discards;
		this.sortType = sortType;
		this.currentHandType = currentHandType;
		this.currentPoints = currentPoints;
		this.currentMult = currentMult;
		this.currentScore = currentScore;
		this.targetNum = targetNum;
		this.targetNumLength = targetNumLength;
		this.viewingHelp = viewingHelp;
		this.currentGoal = currentGoal;
		this.currentLevel = currentLevel;
	}

	/**
	 * Copy constructor for Game. Performs a deep copy of arrays where appropriate.
	 */
	public Game(Game other) {
		// Deep copy 2D arrays
		this.board = deepCopyBoard(other.board);
		this.colors = deepCopyBoard(other.colors);
		this.saveBoard = deepCopyBoard(other.saveBoard);
		this.saveColors = deepCopyBoard(other.saveColors);

		// Deep copy Card arrays
		this.deck = new Card[other.deck.length];
		for (int i = 0; i < other.deck.length; i++) {
			this.deck[i] = (other.deck[i] != null) ? new Card(other.deck[i]) : null;
		}
		this.hand = new Card[other.hand.length];
		for (int i = 0; i < other.hand.length; i++) {
			this.hand[i] = (other.hand[i] != null) ? new Card(other.hand[i]) : null;
		}
		this.selectedCards = new Card[other.selectedCards.length];
		for (int i = 0; i < other.selectedCards.length; i++) {
			this.selectedCards[i] = (other.selectedCards[i] != null) ? new Card(other.selectedCards[i]) : null;
		}

		// Copy primitives and immutable objects
		this.deckLength = other.deckLength;
		this.dealtCardsCount = other.dealtCardsCount;
		this.selectedCardsCount = other.selectedCardsCount;
		this.hands = other.hands;
		this.discards = other.discards;
		this.sortType = other.sortType;
		this.currentHandType = other.currentHandType;
		this.currentPoints = other.currentPoints;
		this.currentMult = other.currentMult;
		this.currentScore = other.currentScore;
		this.targetNum = other.targetNum.clone();
		this.targetNumLength = other.targetNumLength;
		this.viewingHelp = other.viewingHelp;
		this.currentGoal = other.currentGoal;
		this.currentLevel = other.currentLevel;
	}

	/***** ACCESSORS *****/
	// Formatting shrunk to one line since we have so many instance variables
	public String[][] getBoard() { return board; }
	public String[][] getColors() { return colors; }
	public String[][] getSaveBoard() { return saveBoard; }
	public String[][] getSaveColors() { return saveColors; }

	public Card[] getDeck() { return deck; }
	public int getDeckLength() { return deckLength; }

	public Card[] getHand() { return hand; }
	public Card[] getSelectedCards() { return selectedCards; }
	public int getDealtCardsCount() { return dealtCardsCount; }
	public int getSelectedCardsCount() { return selectedCardsCount; }

	public int getHands() { return hands; }
	public int getDiscards() { return discards; }

	public int getSortType() { return sortType; }
	public String getCurrentHandType() { return currentHandType; }
	public int getCurrentPoints() { return currentPoints; }
	public int getCurrentMult() { return currentMult; }
	public int getCurrentScore() { return currentScore; }

	public int[] getTargetNum() { return targetNum; }
	public int getTargetNumLength() { return targetNumLength; }

	public boolean isViewingHelp() { return viewingHelp; }

	public int getCurrentGoal() { return currentGoal; }
	public int getCurrentLevel() { return currentLevel; }

	/***** MUTATORS *****/
	// Formatting shrunk to one line since we have so many instance variables
	public void setBoard(String[][] board) { this.board = board; }
	public void setColors(String[][] colors) { this.colors = colors; }
	public void setSaveBoard(String[][] saveBoard) { this.saveBoard = saveBoard; }
	public void setSaveColors(String[][] saveColors) { this.saveColors = saveColors; }

	public void setDeck(Card[] deck) { this.deck = deck; }
	public void setDeckLength(int deckLength) { this.deckLength = deckLength; }

	public void setHand(Card[] hand) { this.hand = hand; }
	public void setSelectedCards(Card[] selectedCards) { this.selectedCards = selectedCards; }
	public void setDealtCardsCount(int dealtCardsCount) { this.dealtCardsCount = dealtCardsCount; }
	public void setSelectedCardsCount(int selectedCardsCount) { this.selectedCardsCount = selectedCardsCount; }

	public void setHands(int hands) { this.hands = hands; }
	public void setDiscards(int discards) { this.discards = discards; }

	public void setSortType(int sortType) { this.sortType = sortType; }
	public void setCurrentHandType(String currentHandType) { this.currentHandType = currentHandType; }
	public void setCurrentPoints(int currentPoints) { this.currentPoints = currentPoints; }
	public void setCurrentMult(int currentMult) { this.currentMult = currentMult; }
	public void setCurrentScore(int currentScore) { this.currentScore = currentScore; }

	public void setTargetNum(int[] targetNum) { this.targetNum = targetNum; }
	public void setTargetNumLength(int targetNumLength) { this.targetNumLength = targetNumLength; }

	public void setViewingHelp(boolean viewingHelp) { this.viewingHelp = viewingHelp; }

	public void setCurrentGoal(int currentGoal) { this.currentGoal = currentGoal; }
	public void setCurrentLevel(int currentLevel) { this.currentLevel = currentLevel; }

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
	 * Returns true if the target object is equal to the input object
	 */
	public boolean equals(Game other) 
	{
		return java.util.Arrays.deepEquals(this.board, other.board)
			&& java.util.Arrays.deepEquals(this.colors, other.colors)
			&& java.util.Arrays.deepEquals(this.saveBoard, other.saveBoard)
			&& java.util.Arrays.deepEquals(this.saveColors, other.saveColors)
			&& java.util.Arrays.equals(this.deck, other.deck)
			&& this.deckLength == other.deckLength
			&& java.util.Arrays.equals(this.hand, other.hand)
			&& java.util.Arrays.equals(this.selectedCards, other.selectedCards)
			&& this.dealtCardsCount == other.dealtCardsCount
			&& this.selectedCardsCount == other.selectedCardsCount
			&& this.hands == other.hands
			&& this.discards == other.discards
			&& this.sortType == other.sortType
			&& java.util.Objects.equals(this.currentHandType, other.currentHandType)
			&& this.currentPoints == other.currentPoints
			&& this.currentMult == other.currentMult
			&& this.currentScore == other.currentScore
			&& java.util.Arrays.equals(this.targetNum, other.targetNum)
			&& this.targetNumLength == other.targetNumLength
			&& this.viewingHelp == other.viewingHelp
			&& this.currentGoal == other.currentGoal
			&& this.currentLevel == other.currentLevel;
	}

	/***** HELPER METHODS *****/

	/***** SETUP METHODS *****/
	// These methods are used to initialize/output the game and its parts 

	/**
	 * Initializes the game board with borders and empty spaces.
	 */
	private void initializeBoard() throws InterruptedException
	{
		// Reset discards and hands
		discards = STARTER_DISCARDS;
		hands = STARTER_HANDS;

		// Add the corner symbols
		board[0][0] = "┌";
		board[0][COLS - 1] = "┐";
		board[ROWS - 1][0] = "└";
		board[ROWS - 1][COLS - 1] = "┘";

		
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				board[r][c] = " ";
			}
		}
		printBox(0,0, ROWS, COLS, WHITE); // Draw the outer border of the board

		updateGoal(); // Update the target score
		printHandDisc(); // Print the hand and discard symbols

		// Print the current goal centered in a box in the top right
		printBox(GOAL_ROW, GOAL_COL, GOAL_HEIGHT, GOAL_WIDTH, ORANGE);
		String[] goalAscii = intToAscii("" + currentGoal);
		String[] centeredGoal = centerAscii(goalAscii, GOAL_WIDTH - 2);
		stampBoard(centeredGoal, GOAL_ROW + 1, GOAL_COL + 1, ORANGE);

		printScoreBoard(); // Draw the score board
		printLegend(); // Draw the legend box
		printCardBack(DECK_ROW, DECK_COL); // Draw deck symbol
		printDeckRemaining(); // print how many cards are left in the hand

		clearHand(); // Clear the hand
		dealtCardsCount = 0; // Rest the number of dealt cards
		printHandGrid(); // Draw the hand box

		
		currentScore = 0; // Reset the current score
		eraseScoreBoard(); // Erase the score board
		printScoreBoard(); //Reprint the score board

		// Print number labels
		for (int r = 0; r < 7; r++)
		{
			board[HAND_ROW + 9][HAND_COL + 7 + r * HAND_CELL_WIDTH] = "" + (r+1);
		}

		fillDeck(); // Fill the deck
		shuffleDeck(); // Shuffle the deck
		printBoard(true);
		Thread.sleep(1000); // Sleep for 1 second
		dealHand(); // Deal the hand
		printDeckRemaining(); // print how many cards are left in the hand after dealing
		sortHand(sortType); // Sort the hand
		printBoard(true); // Print the board and continue the game

	}

	/**
	 * Stamps a string array on the game board at the specified row and column with the given color.
	 * @param stamp The stamp to be placed on the board
	 * @param row The starting row for the stamp
	 * @param col The starting column for the stamp
	 * @param color The color to be applied to the stamp
	 */
	private void stampBoard(String[] stamp, int row, int col, String color)
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
	 * @param printHand A boolean indicating whether to print the hand or not
	 */
	private void printBoard(boolean printHand)
	{
		StringBuilder sb = new StringBuilder();

		// Only print the hand if we tell it to. This is important for printing the back of cards when discarding
		if (printHand)
		{
			printHand(); // Update the hand before we output
		}

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
		printHandDisc(); // Print the hand and discard symbols
		printDeckRemaining(); // print how many cards are left in the hand

		System.out.println(sb.toString()); // Print entire board in one go to avoid flickering
	}

	/**
	 * Prints the current hands and discards to the board under the deck symbol
	 */
	private void printHandDisc()
	{
		String[] handStrArray = new String[1];
		handStrArray[0] = "Hands:    " + hands;

		String[] discStrArray = new String[1];
		discStrArray[0] = "Discards: " + discards;

		stampBoard(handStrArray, DECK_ROW + 7, DECK_COL, BLUE);
		stampBoard(discStrArray, DECK_ROW + 8, DECK_COL, RED);
	}

	/**
	 * Prints the number of cards left in the deck to the board
	 * */
	private void printDeckRemaining()
	{
		erase(DECK_ROW -1, DECK_COL, CARD_WIDTH, 1); //Clear where the previous card count was so we don't get bad formatting when it goes to single digits
		String[] deckRemaining = new String[1];
		deckRemaining[0] = "(" + deckLength + "/52)";
		String[] centeredDeckRemaining = centerAscii(deckRemaining, CARD_WIDTH); // Piggyback off of our ascii center logic above the deck symbol
		stampBoard(centeredDeckRemaining, DECK_ROW - 1, DECK_COL, WHITE); // Stamp the label
	}

	/**
	 * Prints a box on the game board with the specified dimensions and starting coordinate.
	 * @param row The integer starting row for the box
	 * @param col The integer starting column for the box
	 * @param height The integer height of the box
	 * @param width The integer width of the box
	 * @param color The string for the color to be applied to the box
	 */
	private void printBox(int row, int col, int height, int width, String color)
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
	private void printHorizBoxes(int row, int col, int height, int cellWidth, int cells)
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
	private void printHandGrid()
	{
		printHorizBoxes(HAND_ROW, HAND_COL, HAND_CELL_HEIGHT, HAND_CELL_WIDTH, 7); // Draw the hand box
	}

	/**
	 * Prints the legend on the game board.
	 */
	private void printLegend()
	{
		printBox(LEGEND_ROW, LEGEND_COL, LEGEND_HEIGHT, LEGEND_WIDTH, WHITE); // Draw the legend box)
		stampBoard(legendArray, LEGEND_ROW + 1, LEGEND_COL + 1, WHITE); // Stamp the legend on the board
	}

	/**
	 * Prints the score board and its contents to the board
	 */
	private void printScoreBoard()
	{
		printBox(SCORE_BOARD_ROW, SCORE_BOARD_COL, SCORE_BOARD_HEIGHT, SCORE_BOARD_WIDTH, WHITE); // Draw the score box
		printHandText(); // Print the hand type to the board
		printBox(SCORE_BOX_ROW, SCORE_BOX_COL, SCORE_BOX_HEIGHT, SCORE_BOX_WIDTH, WHITE);
		stampBoard(X_ARRAY, X_ROW, X_COL, WHITE); // Stamp the X sign on the board

		// Stamp the points, calculating the distance between the point column and the x column
		String[] pointsAscii = intToAscii("" + currentPoints); // Turn the points into ascii art
		String[] centeredPointsAscii = centerAscii(pointsAscii, X_COL - POINTS_COL); // Center that ascii art within its given space
		stampBoard(centeredPointsAscii, POINTS_ROW, POINTS_COL, BLUE); // Stamp the points
		
		// Stamp the mult, calculating the distance between the mult column and the right edge of the score board
		String[] multAscii = intToAscii("" + currentMult); // Turn the mult into ascii art
		String[] centeredMultAscii = centerAscii(multAscii, SCORE_BOARD_COL + SCORE_BOARD_WIDTH - 1 - MULT_COL); // Center that ascii art within its given space
		stampBoard(centeredMultAscii, MULT_ROW, MULT_COL, DARK_RED); // Stamp the mult

		// Stamp the total score, considering the total width of the score box
		String[] scoreAscii = intToAscii("" + currentScore); // Turn the score into ascii art
		String[] centeredScoreAscii = centerAscii(scoreAscii,SCORE_BOX_WIDTH - 2); // Center that ascii art within the score box
		stampBoard(centeredScoreAscii, SCORE_ROW, SCORE_COL, YELLOW); // Stamp the score
		
	}

	/**
	 * Prints the symbol for the back of a card to the board
	 * @param row Row to print the card in
	 * @param col Col to print the card in
	 */
	private void printCardBack(int row, int col)
	{
		stampBoard(CARD_BACK, row, col, WHITE); // Stamp the card back on the board
	}

	/**
	 * Analyzes what hand the selected cards form and prints the corresponding ascii art to the scoreboard
	 */
	private void printHandText()
	{
		eraseScoreBoard(); // Clear the score box
		if (currentHandType.equalsIgnoreCase("Straight"))
		{
			stampBoard(STRAIGHT_ARRAY, 3, 10, BLUE); // Stamp the straight on the board
		}
		else if (currentHandType.equalsIgnoreCase("Flush"))
		{
			stampBoard(FLUSH_ARRAY, 3, 17, RED); // Stamp the flush on the board
		}
		else if (currentHandType.equalsIgnoreCase("Straight Flush"))
		{
			stampBoard(STRAIGHT_FLUSH_ARRAY, 3, 10, CYAN); // Stamp the straight flush on the board
		}
		else if (currentHandType.equalsIgnoreCase("High Card"))
		{
			stampBoard(HIGH_CARD_ARRAY, 3, 8, ORANGE); // Stamp the high card on the board
		}
		else if (currentHandType.equalsIgnoreCase("Two Of A Kind"))
		{
			stampBoard(TWO_KIND_ARRAY, 3, 10, PURPLE); // Stamp the two pair on the board
		}
		else if (currentHandType.equalsIgnoreCase("Three Of A Kind"))
		{
			stampBoard(THREE_KIND_ARRAY, 3, 10, GREEN); // Stamp the three of a kind on the board
		}
		else if (currentHandType.equalsIgnoreCase("Four Of A Kind"))
		{
			stampBoard(FOUR_KIND_ARRAY, 3, 10, YELLOW); // Stamp the four of a kind on the board
		}
		else if (currentHandType.equalsIgnoreCase("Full House"))
		{
			stampBoard(HOUSE_ARRAY, 3, 16, MAGENTA); // Stamp the full house on the board
		}
		else if (currentHandType.equalsIgnoreCase("Two Pair"))
		{
			stampBoard(TWO_PAIR_ARRAY, 3, 10, LIME); // Stamp the two pair on the board
		}
	}

	/**
	 * Prints or removes the help screen to give useful information. Whether it appears or disappears depends on the viewingHelp static variable
	 */
	private void printHelp()
	{
		
		if (!viewingHelp) // If the user is not currently looking at the help menu 
		{
			viewingHelp = true; // Update this value so the next time the user presses help it exits the menu
			saveBoard = deepCopyBoard(board); // Deep copy the board to save it before we erase it
			saveColors = deepCopyBoard(colors); // Deep copy the colors
			erase(1, 1, COLS - 2, ROWS - 2); // Erase the board

			// Print the help label in the top left

			// Store the height and width in variables for easy editing
			int helpHeight = 9;
			int helpWidth = SCORE_BOARD_WIDTH + 16;

			printBox(SCORE_BOARD_ROW, SCORE_BOARD_COL, helpHeight, helpWidth, PURPLE); // Recycle score board array constants for this box
			String[] centeredHelp = centerAscii(HELP_ARRAY, helpWidth - 2); // New string[] to center the help text piggybacking off the score board array constants
			stampBoard(centeredHelp, SCORE_BOARD_ROW + 1, SCORE_BOARD_COL + 1, PURPLE); // Stamp the help text

			String[] helpHints = new String[6]; // New string array to hold text we print to the screen
			helpHints[0] = "- Enter numbers 1 - 5 to select cards";
			helpHints[1] = "- Select cards in one of the displayed patterns to score";
			helpHints[2] = "- Enter 'p' when you're ready to play your hand and score points";
			helpHints[3] = "- Score enough points to beat the blind";
			helpHints[4] = "- You have a limited number of hands to play and discards to use";
			helpHints[5] = "- You can score a straight + a flush at once to play a straight flush";

			stampBoard(helpHints, SCORE_BOARD_ROW + helpHeight + 1, SCORE_BOARD_COL, WHITE); // Stamp instructions to the board

			// Array to hold tips for each hand
			String[] handTips = new String[6];
			handTips[0] = "High card (scores the highest held card only):";
			handTips[1] = "Straight (scores all the cards if they are in increasing order):";
			handTips[2] = "Flush (Scores all the cards if they are all the same suit):";
			handTips[3] = "(2, 3, 4) of a kind (scores the cards of matching rank):";
			handTips[4] = "Two pair (scores the two pairs of matching ranks):";
			handTips[5] = "Full house (scores a triple and a pair present together):";

			// Rows and cols to print the hands in
			int highRow = 21;
			int highCol = 5;

			int straightRow = highRow + 9;
			int straightCol = highCol;

			int flushRow = 3;
			int flushCol = 80;

			int kindRow = flushRow + 9;
			int kindCol = flushCol;

			int pairRow = kindRow + 9;
			int pairCol = kindCol;

			int houseRow = pairRow + 9;
			int houseCol = pairCol;

			// Arrays to represent the hands
			Card[][] handsArray = new Card [6][];
			handsArray[0] = new Card[1]; // High card
			handsArray[1] = new Card[5]; // Straight
			handsArray[2] = new Card[5]; // Flush
			handsArray[3] = new Card[4]; // __ Of a kind
			handsArray[4] = new Card[4]; // Two pair
			handsArray[5] = new Card[5]; // Full house

			//High card
			handsArray[0][0] = new Card(1, "spades", false, highRow, highCol);
			// Straight
			for (int straightCard = 0; straightCard < 5; straightCard++) // Initialize a line of cards of increasing rank and random suit
			{
				handsArray[1][straightCard] = new Card(straightCard + 1, SUITS_ARRAY[new java.util.Random().nextInt(SUITS_ARRAY.length)], false, straightRow, straightCol + straightCard * HAND_CELL_WIDTH);
			}
			// Flush
			for (int flushCard = 0; flushCard < 5; flushCard++) // Initialize a row of cards of random rank and suit hearts
			{
				handsArray[2][flushCard] = new Card(new java.util.Random().nextInt(12) + 1, "hearts", false, flushRow, flushCol + flushCard * HAND_CELL_WIDTH);
			}
			// __ of a kind
			for (int kindCard = 0; kindCard < handsArray[3].length; kindCard++) // Initialize a row of 4 cards with matching rank and random suit
			{
				handsArray[3][kindCard] = new Card(1, SUITS_ARRAY[new java.util.Random().nextInt(SUITS_ARRAY.length)], false, kindRow, kindCol + kindCard * HAND_CELL_WIDTH);
			}
			// Two pair
			for (int pairCard = 0; pairCard < handsArray[4].length; pairCard++) // Initialize a row of two pairs of cards that have matching rank, random suits
			{
				int value = pairCard / 2; // Using integer division, this will give 0 on the first two passes and 1 on the next two, perfect for making two pairs of cards
				handsArray[4][pairCard] = new Card(value + 1, SUITS_ARRAY[new java.util.Random().nextInt(SUITS_ARRAY.length)], false, pairRow, pairCol + pairCard * HAND_CELL_WIDTH);
			}
			// Full house
			for (int houseCard = 0; houseCard < handsArray[5].length; houseCard++) 
			{
				if (houseCard < 3) // For the first three cards, initialize a row of 3 cards with matching rank and random suit
				{
					handsArray[5][houseCard] = new Card(1, SUITS_ARRAY[new java.util.Random().nextInt(SUITS_ARRAY.length)], false, houseRow, houseCol + houseCard * HAND_CELL_WIDTH);
				}
				else // For the last two, initizalize a pair of random suit
				{
					handsArray[5][houseCard] = new Card(10, SUITS_ARRAY[new java.util.Random().nextInt(SUITS_ARRAY.length)], false, houseRow, houseCol + houseCard * HAND_CELL_WIDTH);
				}
				
			}

			// Loop through each hand and print it
			for (int handIdx = 0; handIdx < handsArray.length; handIdx++)
			{
				printHandTip(handsArray[handIdx], handTips[handIdx]);
			}

			String[] backString = new String[1];
			backString[0] = "Enter 'h' to go back to the game";
			stampBoard(backString, ROWS - 2, 2, YELLOW);

			printBoard(false);
		}
		else
		{
			viewingHelp = false; // Stop viewing the board
			board = deepCopyBoard(saveBoard); // Reverse-copy the saved board to the current one
			colors = deepCopyBoard(saveColors); // Restore the colors
			printBoard(true); // Print the board
		}
		
	}

	/**
	 * Takes an array of cards, coordinates to print them, and a tip message, and prints out a guide for the scoring hand with any empty cards represented as dashed lines
	 * @param cardArray the card array to print
	 * @param tip the stringtip to display
	 */
	private void printHandTip(Card[] cardArray, String tip)
	{
		Card[] tipCards = new Card[5]; // New array to be filled with contents of input array (possibility for partially filled arrays)

		String[] tipString = new String[1];
		tipString[0] = tip;

		System.arraycopy(cardArray, 0, tipCards, 0, cardArray.length); // Copy the input array into the new tipCards array
		printCards(tipCards); // Print the cards
		stampBoard(tipString, cardArray[0].getRowCoord() - 1, cardArray[0].getColCoord(), WHITE); // Stamp the tip message above the cards

		// Print dashed card outlines for the rest of the hand representation
		for (int dashed = 0; dashed < 5; dashed++)
		{
			if (tipCards[dashed] == null)
			{
				stampBoard(DASHED_CARD, tipCards[0].getRowCoord(), tipCards[0].getColCoord() + HAND_CELL_WIDTH * dashed, WHITE);
			}
		}
	}

	/**
	 * Prints an array of cards to the board
	 */
	private void printCards(Card[] cardArray)
	{
		for (int i = 0; i < cardArray.length; i++)
		{
			if (cardArray[i] != null)
			{
				stampBoard(cardArray[i].cardToLinesArray(), cardArray[i].getRowCoord(), cardArray[i].getColCoord(), cardArray[i].suitToColor());
			}
			else if (cardArray[i] == null)
			{
				stampBoard(EMPTY_CARD, CARD_ROW, CARD_COL + (i * HAND_CELL_WIDTH), "\u001B[0m"); // print empty cards
			}
		}
	}

	/**
	 * Prints the player's hand of cards to the board.
	 */
	private void printHand()
	{
		printCards(hand);
	}

	/**
	 * Fills the specified area on the board with blanks
	 * @param startRow Starting row to erase
	 * @param startCol Starting col to erase
	 * @param width Width to erase
	 * @param height Height to erase
	 */
	private void erase(int startRow, int startCol, int width, int height)
	{
		for (int r = startRow; r < startRow + height; r++)
		{
			for (int c = startCol; c < startCol + width; c++)
			{
				board[r][c] = " ";  // Reset the cell to empty
			}
		}
	}

	/**
	 * Visually erases a card from the hand
	 * @param cardArray The array of cards to erase from
	 * @param cardIndex The index of the card to be erased
	 */
	private void eraseCard(Card[] cardArray, int cardIndex)
	{
		if (cardArray[cardIndex] != null)
		{
			erase (hand[cardIndex].getRowCoord(), hand[cardIndex].getColCoord(), HAND_CELL_WIDTH - 2, HAND_CELL_HEIGHT - 2); // Erase the card
		}
	}

	/**
	 * Erases the entire hand of cards
	 */
	private void eraseHand()
	{
		erase(HAND_ROW -2, HAND_COL, HAND_CELL_WIDTH * 7, HAND_CELL_HEIGHT); // Clear the hand box
	}

	/**
	 * Clears the score board
	 */
	private void eraseScoreBoard()
	{
		erase(SCORE_BOARD_ROW + 1, SCORE_BOARD_COL + 1, SCORE_BOARD_WIDTH - 2, SCORE_BOARD_HEIGHT - 2); // Clear the score box
	}

	/**
	 * Clears the area of the board where cards are played
	 */
	private void erasePlayBoard()
	{
		erase(SCORE_BOX_ROW, HAND_COL, COLS - HAND_COL - 1, SCORE_BOARD_HEIGHT - SCORE_BOX_ROW); // Erase the entire space above the hand and to the right of the score board.
	}


	/***** LOGIC METHODS *****/
	// These are methods that deal with the behind the scenes logic required to display the game properly


	/**
	 * Deals a hand of cards from the deck to the empty slots in the player's hand but does not print it. 
	 */
	private void dealHand()
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
						deckLength--; // Decrease the size of the deck
						dealtCardsCount++;
					}
			}
			
		}
	}

	

	/**
	 * Shuffles the deck of cards using the Fisher-Yates shuffle algorithm.
	 */
	private void shuffleDeck()
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
	private boolean selectCard(int cardIndex)
	{
		if (hand[cardIndex] != null && !hand[cardIndex].getSelected() && selectedCardsCount < 5) // If the card is not selected and less than 5 cards are selected
		{
			hand[cardIndex].setSelected(true); // Toggle the selection status to be true
			hand[cardIndex].setRowCoord(CARD_ROW - 2); // Set the row coordinate of the card to be above the hand
			appendCard(selectedCards, hand[cardIndex]); // Add the card to the selected cards array
			selectedCardsCount++; // Increase the number of selected cards

			//Erase the scoreboard and reprint it to update the score relating to the hand
			eraseScoreBoard();
			printScoreBoard();
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

			//Erase the scoreboard and reprint it to update the score relating to the hand
			eraseScoreBoard();
			printScoreBoard();
		}
		return (true); // Return true if the card was successfully selected
	}

	/**
	 * Removes selected cards from the hand and updates the board without printing it
	 * @throws InterruptedException
	 */
	private void removeSelectedCards()
	{
		if (selectedCardsCount != 0)
		{
			for (int i = 0; i < hand.length; i++) // For every card in the hand
			{
				if (hand[i] != null && hand[i].getSelected()) // If the card in the hand is selected
				{
					eraseCard(hand, i); // Erase the card from the board
					hand[i] = null; // Remove the selected card
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

		}
	}

	/**
	 *  Discards the selected cards and updates/prints the board accordingly
	 * @throws InterruptedException
	 */
	private void discard() throws InterruptedException
	{
		if (selectedCardsCount != 0 && discards != 0) // As long as we have some cards selected
		{
			discards--; //Decrease the number of discards left
			eraseScoreBoard(); // Clear the score box
			currentHandType = ""; // Reset the hand type
			printScoreBoard(); // Re-print the score box
			
			removeSelectedCards(); // Remove the selected cards from the hand

			// Reset the scoreboard
			eraseScoreBoard(); // Clear the score box
			currentHandType = ""; // Reset the hand type
			// Reset the score and mult
			currentPoints = 0;
			currentMult = 1;
			printScoreBoard(); // Re-print the score box
			erasePlayBoard(); // Erase all the played cards


			printBoard(true); // Print the board and the hand
			Thread.sleep(500); // Pause for half a second

			refillHand(); // Refill the hand
			checkLoss(); // Check for a loss before continuint
		}
		else if (selectedCardsCount == 0)
		{
			System.out.println("Please select a card before discarding");
		}
		else if (discards == 0)
		{
			System.err.println("No discards remaining");
		}
		
		
	}

	/**
	 * Refills all the empty spots in the hand and prints the board to display the change
	 * @throws InterruptedException
	 */
	private void refillHand() throws InterruptedException
	{
		for (int blankCard = 0; blankCard < hand.length; blankCard++)
		{
			if (hand[blankCard] == null)
			{
				printCardBack(CARD_ROW, CARD_COL + (blankCard * HAND_CELL_WIDTH)); // Print the card back
			}
		}

		printBoard(false); // Print the board without the hand
		Thread.sleep(500);

		dealHand(); // Fill empty spots in the hand
		printBoard(true); // Print the board and the hand again
		
		Thread.sleep(700); // Pause efore sorting
		sortHand(sortType); // Sort
		printBoard(true); // Print the board and the hand
	}

	/**
	 * Sorts the hand of cards based on the specified sorting criteria.
	 * @param sortKind The sorting criteria (0 for number, 1 for suit).
	 */
	private void sortHand(int sortKind)
	{
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
				eraseHand(); // Erase the hand box to fix the edge
				printHandGrid(); // Reprint the hand grid to fix the edge
			}
		}
		else if (sortKind == 1) // Sort by suit
		{
			int currentSuitIndex = 0;

			for (int suitIndex = 0; suitIndex < SUITS_ARRAY.length; suitIndex++) // For each suit in the suits array
			{
				int nextSuitIndex;
				while (indexOfSuit(hand, currentSuitIndex, SUITS_ARRAY[suitIndex]) != -1 && currentSuitIndex < hand.length - 1) // While there are upcoming cards of the suit in the hand and we haven't reached the end of the hand
				{
					nextSuitIndex = indexOfSuit(hand, currentSuitIndex, SUITS_ARRAY[suitIndex]); // Get the index of the next card of the proper suit
					if (hand[currentSuitIndex] != null && !hand[currentSuitIndex].getSuit().equalsIgnoreCase(SUITS_ARRAY[suitIndex])) // If the suit of the card is not the right suit and isn't null
					{
						swapIndeces(hand, currentSuitIndex, nextSuitIndex);
						currentSuitIndex++; // Update the current suit index to be the next card
						if (hand[currentSuitIndex].getSelected())
						{
							eraseCard(hand, currentSuitIndex); // Erase the card if it is selected
						}
						eraseHand(); // Erase the hand box to fix the edge
						printHandGrid(); // Reprint the hand grid to fix the edge
					}
					else
					{
						currentSuitIndex++;
					}
				}
			}
		}

	}

	/**
	 * Takes an integer and the maximum amount of space that integer is allowed to occupy and returns ASCII art with preceding blank spaces to ensure the art is centered in its alotted area
	 * @param numberString a string representing the integer to turn into ASCII art
	 * @return String array containing the ASCII art
	 */
	private String[] intToAscii(String numberString)
	{
		char[] numberChars = numberString.toCharArray(); // Split the number into each of its digits as characters
		
		// Turn each of those characters into integers for easy use
		int[] numberInts = new int[numberChars.length]; 
		for (int numChar = 0; numChar < numberChars.length; numChar++)
		{
			numberInts[numChar] = Integer.parseInt("" + numberChars[numChar]);
		}

		String[] asciiArray = new String[6]; // Create an array to hold the ascii art for each digit

		// Assemble the final ascii art
		for (int digit = 0; digit < numberChars.length; digit++)
		{
			for (int i = 0; i < 6; i++) // For each line of ascii art
			{
				if (digit == 0)
				{
					asciiArray[i] = ""; // Initialize each line on the first pass to ensure no null values before adding to it
				}
				asciiArray[i] += NUMBERS_ARRAY[numberInts[digit]][i]; // Add each line to the array
			}	
		}
		
		return asciiArray; // Return the ascii array
		
	}

	/**
	 * Takes a string array of ascii art and adds padding to center it within the given width of characters  
	 * @param asciiArray ascii art to center (its longest line must be of an odd width in order to appear centered)
	 * @param maxWidth width of characters to center the art in (must be odd to get proper centering)
	 * @return
	 */
	private String[] centerAscii(String[] asciiArray, int maxWidth)
	{
		String[] outputArray = new String[asciiArray.length];
		String padding = " "; // Initialize the buffer string as a single blank space
		int inputWidth = 0; // This will hold the total width of the final ascii art
		int longestLine = 0; // Int to keep track of the longest line in each ascii digit (not necessary for our currently uniform ascii art but fixes potential issues for other ascii digits)

		for (int line = 0; line < asciiArray.length; line++) // For each line of ascii art, check if it's the longest and update the longest if it is
			{
				if (asciiArray[line].length() > longestLine)
				{
					longestLine = asciiArray[line].length();
				}
			}
			// Add to the total length of the final ascii art
			inputWidth += longestLine;	

		// Increase the padding given the maximum width we're printing the art in. This will add as much blank space as necessary to keep the digit centered no matter its length
		padding = padding.repeat((maxWidth - inputWidth)/2);

		// Assemble the final ascii art
		for (int line = 0; line < asciiArray.length; line++) // For each line of ascii art
		{
			outputArray[line] = padding; // Add the padding first
			outputArray[line] += asciiArray[line]; // Add each line of ascii art on top of the alignment spaces
		}	

		return outputArray; // Return centered ascii art

	}

	/**** Array Methods ****/
	// These methods perform various tasks on arrays necessary for game logic

	/**
	 * Fills the deck with cards
	 */
	private void fillDeck()
	{
		// Fill the deck with cards
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

	/**
	 * Swaps two cards in the array at the specified indices.
	 * @param array The array of cards to swap elements in.
	 * @param a The index of the first card to swap.
	 * @param b The index of the second card to swap.
	 */
	private static void swapIndeces(Card[] array, int a, int b)
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

	/**
	 * Takes an index for a card in the hand and returns the corresponding index of that card in the selectedCards array
	 * @param index Integer index of the card in the hand
	 * @return integer index of the corresponding card in the selected array
	 */
	private int handToSelectedIndex(int index)
	{

		for (int selectedIndex = 0; selectedIndex < selectedCardsCount; selectedIndex++)
		{
			Card dummyCard = new Card(hand[index]); // Save the card from the hand in a new card object
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
	private static int indexOfMin(Card[] array, int startIndex)
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
	private static int indexOfSuit(Card[] array, int startIndex, String suit)
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

	/**
	 * Sends all null values in an array to the end of the array
	 * @param array array to sift
	 */
	private void siftArray(Card[] array)
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
	private void appendCard(Card[] cardArray, Card card)
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

	/**
	 * Appends an int to the first empty slot (0) in the given int array.
	 * @param intArray The array to which the int will be appended.
	 * @param value The int value to be appended.
	 */
	private void appendInt(int[] intArray, int value)
	{
		for (int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] == 0)
			{
				intArray[i] = value; // Add the value to the first empty slot in the array
				break;
			}
		}
	}

	/**
	 * Sets each item in an integer array to 0
	 * @param intArray The array to erase
	 */
	private void eraseInt(int[] intArray)
	{
		for (int val = 0; val < intArray.length; val++)
		{
			intArray[val] = 0; // Set each item in intArray to 0
		}
	}

	/**
	 * Deep copies a source String[][] array into a target String array.
	 * @param source the original array to copy from
	 * @return a new deep-copied array
	 */
	private static String[][] deepCopyBoard(String[][] source) 
	{
		int rows = source.length;
		int cols = source[0].length;
		String[][] copy = new String[rows][cols];

		// Add each cell by looping through the columns and rows
		for (int row = 0; row < rows; row++) 
		{
			for (int col = 0; col < cols; col++) 
			{
				copy[row][col] = source[row][col];
			}
		}

		return copy;
	}

	/**
	 * Returns the rank of the highest card in the input array
	 * @param inputArray The input array to analyze
	 * @return
	 */
	private int returnHighestCard(Card[] inputArray)
	{
	int highest = 0; // Int to keep track of the highest rank of card
		for (int card = 0; card < inputArray.length; card++)// For every card we're scoring
		{
			if (inputArray[card] != null && inputArray[card].getNumber() > highest)
			{
				highest = inputArray[card].getNumber(); // Update highest number so far
			}
		}
		return highest;
	}

	/**
	 * Returns the index of the first ace found in the input array, or -1 if no ace is found
	 * @param inputArray The card array to search for an ace in
	 * @return the integer index of the ace, -1 if no ace found 
	 */
	private int returnIfAce(Card[] inputArray)
	{
		for (int card = 0; card < inputArray.length; card++)// For every card we're scoring
		{
			if (inputArray[card] != null && inputArray[card].getNumber() == 1) // If we find an ace
			{
				return card; // Return the index of the ace
			}
		}
		return -1; // Return -1 if no ace found
	}


	/**** GAME LOGIC METHODS ****/
	// These methods handle the rules of the game and the play loop


	/**
	 * Checks if the selected cards form a flush (all cards of the same suit).
	 * @return true if the selected cards form a flush, false otherwise.
	 */
	private boolean checkForFlush()
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
			currentHandType = "Flush"; // Set the current hand type to flush
			return true; // All cards have the same suit, it's a flush
		}
		return false;
	}

	/**
	 * Checks if the selected cards form a straight (consecutive numbers).
	 * @return true if the selected cards form a straight, false otherwise.
	 */
	private boolean checkForStraight()
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
					currentHandType = "Straight"; // Set the current hand type to straight
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
				currentHandType = "Straight"; // Set the current hand type to straight
				return true;
			}
		}
		return false; // Return false if nothing else was found

	}

	/**
	 * Checks the selected cards for high card, two of a kind, three of a kind, four of a kind, or full house
	 * @returns 1 through 4 depending on how many times the most frequent card is found, returns 5 if a full house is found, or 6 if a two pair is found
	 */
	private int checkForKind()
	{

		eraseInt(targetNum); // Reset the targetNum array to 0
		targetNumLength = 0; // Reset the length

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
					appendInt(targetNum, currentNum + 1); // Add the rank of the pair we just found to targetNum for scoring two of a kind and two pairs 
					targetNumLength++; // Increase the length of targetNum
					twosFound++; // Increase the number of pairs found
				}
				if (selectedFrequency[currentNum] == 3)
				{
					//appendInt(targetNum, currentNum + 1); // Add the rank of the triple we just found to targetNum for scoring 3 of a kind 
					threeFound = true; // Set threeFound to true fo finding full houses
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
				appendInt(targetNum, modeNum + 1); // Only cards of the same rank as the most common one should score, and we update this var accordingly. Note this doesn't work for high card, which we account for seperately
				targetNumLength++; // Increase the length of targetNum
				return selectedFrequency[modeNum]; // Return how many times the most frequent card appears 
			}
			
	}

	/**
	 * Checks if the selected cards form a straight flush (both a straight and a flush)
	 * @return True if straight flush is found, false otherwise
	 */
	private boolean checkForStraightFlush()
	{
		return checkForStraight() && checkForFlush();
	}

	/**
	 * Checks if the selected cards form a high card (no pattern)
	 * @return True if high card is found, false otherwise
	 */
	private boolean checkForHighCard()
	{
		return !checkForFlush() && !checkForStraight() && checkForKind() == 1; // All other hands override high card. We only account for flish and straight since the others are handled in checkForKind 
	}


	/**
	 * Checks if the selected cards form a two of a kind
	 * @return true if two of a kind is found, false otherwise
	 */
	private boolean checkForTwoOfAKind()
	{
		return !checkForFlush() && checkForKind() == 2; // Flush overrides two of a kind
	}

	/**
	 * Checks if the selected cards form a three of a kind
	 * @return true if three of a kind is found, false otherwise
	 */
	private boolean checkForThreeOfAKind()
	{
		return !checkForFlush() && checkForKind() == 3; // Flush overrides three of a kind
	}

	/**
	 * Checks if the selected cards form a four of a kind
	 * @return true if four of a kind is found, false otherwise
	 */
	private boolean checkForFourOfAKind()
	{
		return !checkForFlush() && checkForKind() == 4; // Flush overrides four of a kind
	}

	/**
	 * Checks if the selected cards form a full house
	 * @return true if full house is found, false otherwise
	 */
	private boolean checkForFullHouse()
	{
		return !checkForFlush() && checkForKind() == 5; // Flush overrides full house
	}

	/**
	 * Checks if the selected cards form a two pair
	 * @return true if two pair is found, false otherwise
	 */
	private boolean checkForTwoPair()
	{
		return !checkForFlush() && checkForKind() == 6; // Flush overrides two pair
	}

	/**
	 * Returns what hand the selected cards form
	 * @return The hand formed by the selected cards
	 */
	private String checkHandType()
	{
		// Check for each hand type
		if (checkForStraightFlush()) 
		{
			currentHandType = "Straight Flush";
			currentPoints = STRAIGHT_FLUSH_POINTS;
			currentMult = STRAIGHT_FLUSH_MULT;
		} 
		else if (checkForFourOfAKind()) 
		{
			currentHandType = "Four of a Kind";
			currentPoints = FOUR_POINTS;
			currentMult = FOUR_MULT;
		} 
		else if (checkForFullHouse()) 
		{
			currentHandType = "Full House";
			currentPoints = HOUSE_POINTS;
			currentMult = HOUSE_MULT;
		} 
		else if (checkForFlush()) 
		{
			currentHandType = "Flush";
			currentPoints = FLUSH_POINTS;
			currentMult = FLUSH_MULT;
		} 
		else if (checkForStraight()) 
		{
			currentHandType = "Straight";
			currentPoints = STRAIGHT_POINTS;
			currentMult = STRAIGHT_MULT;
		} 
		else if (checkForThreeOfAKind()) 
		{
			currentHandType = "Three of a Kind";
			currentPoints = THREE_POINTS;
			currentMult = THREE_MULT;
		} 
		else if (checkForTwoPair()) 
		{
			currentHandType = "Two Pair";
			currentPoints = TWO_POINTS;
			currentMult = TWO_MULT;
		} 
		else if (checkForTwoOfAKind()) 
		{
			currentHandType = "Two of a Kind";
			currentPoints = PAIR_POINTS;
			currentMult = PAIR_MULT;
		} 
		else if (checkForHighCard()) 
		{
			currentHandType = "High Card";
			currentPoints = HIGH_POINTS;
			currentMult = HIGH_MULT;
		} 
		else 
		{
			currentHandType = "";
			currentPoints = 0;
			currentMult = 1;
		}

		return currentHandType;
	}

	/**
	 * Plays and scores the selected cards
	 * @throws InterruptedException
	 */
	private void playHand() throws InterruptedException
	{
		if (selectedCardsCount != 0) // As long as we have cards selected
		{
			hands--; //Decrease the number of hands remaining
			Card[] playHand = new Card[5]; // Create a new array to hold the play hand
			int playSize = selectedCardsCount; // Get the number of selected cards before we wipe the selected array
			int startRow = HAND_ROW - 10; // Set the starting row for the play hand
			int totalWidth = playSize * HAND_CELL_WIDTH; // Calculate the total width of the play hand
			// Set the starting column for the play hand, shifting it backwards from column 109 (the middle of the hand)
			// Since each card has an odd width (to ensure it has a middle column) we subtract 1 from the total width before dividing by 2
			int startCol = 110 - ((totalWidth - 1)/2); 
			for (int i = 0; i < playHand.length; i++)
			{
				playHand[i] = null; // Initialize the play hand as null before filling it
			}
			for (int i = 0; i < selectedCardsCount; i++)
			{
				if (selectedCards[i] != null) // If the selected card is not null
				{
					playHand[i] = new Card (selectedCards[i]); // Add the selected card to the play hand
					playHand[i].setRowCoord(startRow); // Set the row coordinate of the card
					playHand[i].setColCoord(startCol + (i * HAND_CELL_WIDTH)); // Set the column coordinate of the card
					System.out.println(playHand[i].toString()); 
				}
			}
			removeSelectedCards(); // Remove the selected cards from the hand
			printCards(playHand);
			printBoard(true); // Print the board

			Thread.sleep(500);
			scoreCards(playHand);

			eraseScoreBoard(); // Clear the score box
			currentHandType = ""; // Reset the hand type
			printScoreBoard(); // Re-print the score box
			erasePlayBoard(); // Erase all the played cards

			printBoard(false); // Print the board with blank spaces still showing
			Thread.sleep(500); // Pause

			refillHand(); // Refill the hand (this handles the rest of the printing)

			checkWin();// Check if we've won before checking if we've lost to prevent issues when the payer wins on the last hand
			checkLoss(); // Check if we've lost before continuing
		}
		else
		{
			System.out.println("Please select cards before playing");
		}
		

	}

	/**
	 * Scores all the cards in the input array
	 * @param scoreArray array of cards to score
	 * @throws InterruptedException
	 */
	private void scoreCards(Card[] scoreArray) throws InterruptedException
	{
		// If the hand type is high card, 2-4 of a kind, or two pair we only score cards of a certain rank as determined by targetNum
		if (currentHandType.equalsIgnoreCase("Two of a kind") || currentHandType.equalsIgnoreCase("Three of a kind")  || currentHandType.equalsIgnoreCase("Four of a kind") || currentHandType.equalsIgnoreCase("Two pair"))
		{
			for (int card = 0; card < scoreArray.length; card++) // For each card we're scorring
			{
				for (int target = 0; target < targetNumLength; target++) // For every rank we should be scoring
				{
					System.out.println(targetNumLength);
					System.out.println(targetNum[target]);
					if (scoreArray[card] != null && scoreArray[card].getNumber() == targetNum[target]) // If the card is of the right rank 
					{
						scoreCard(scoreArray[card]); // Score the card

						printBoard(false); // Print the board without the hand just to be safe since the hand shouldn't change till after scoring
						Thread.sleep(800); // Pause between scores
						break; // Break to avoid scoring twice
					}
				}
				
			}
			eraseInt(targetNum); // Reset targetNum to be 0 for the next time we score cards
			targetNumLength = 0; // Reset the length of targetNum
		}
		else if (currentHandType.equalsIgnoreCase("High card")) // For high card specifically
		{
			int highest = returnHighestCard(scoreArray); // Int to keep track of the highest rank of card
			
			for (int card = 0; card < scoreArray.length; card++) // For every card we're scoring
			{
				if (returnIfAce(scoreArray) != -1) // If there's an ace in the hand
				{
					if (scoreArray[card] != null && scoreArray[card].getNumber() == 1) // If the current card is that ace
					{
						if (11 > highest) // If an ace would score higher than any other card in the hand
						{	
							scoreCard(scoreArray[card]); // Score the ace only
							printBoard(false); // Print the board without the hand just to be safe since the hand shouldn't change till after scoring
							Thread.sleep(800); // Pause between moving on
							break; // Break out of the loop
						}
					}
				} 
				else // If no ace in the hand
				{
					if (scoreArray[card] != null && scoreArray[card].getNumber() == highest) // If the current card is the highest
					{
						scoreCard(scoreArray[card]); // Score the current card
						printBoard(false); // Print the board without the hand just to be safe since the hand shouldn't change till after scoring
						Thread.sleep(800); // Pause between moving on
					}
				}
			}
		}
		else // For every other possible hand
		{
			for (int card = 0; card < scoreArray.length; card++) // For every card to score
			{
				if (scoreArray[card] != null) // As long as it's not empty
				{
					scoreCard(scoreArray[card]); // Score the card

					printBoard(false); // Print the board without the hand just to be safe since the hand shouldn't change till after scoring
					Thread.sleep(800); // Pause between scores
				}
			}
		}
		
		// update the final score for this hand
		currentScore += currentPoints * currentMult;

		// Clear and reprint the scoreboard to reflect points changes
		eraseScoreBoard();
		printScoreBoard();

		printBoard(false);
		Thread.sleep(500);


		currentPoints = 0;
		currentMult = 0;
		eraseScoreBoard(); // Clear the score box
		currentHandType = ""; // Reset the hand type
		printScoreBoard(); // Re-print the score box
	}

	/**
	 * Scores a single card and adds the points above it. Does not print the board to the terminal
	 * @param inputCard The card to score
	 */
	private void scoreCard(Card inputCard)
	{
		// String arrays to hold the card points and multipliers
		String[] cardPoints = new String[1];
		String[] cardMult = new String[1];

		int intPoints;
		int intMult; // Currently unused, left in for potential future features

		int pointsRow;
		int pointsCol;

		// Cards currently don't give mult in this version of the game
		int multRow;
		int multCol;

		if (inputCard.getNumber() != 1) // As long as the card is not an ace
		{
			intPoints = inputCard.getNumber(); // The card scores as high as its number
		}
		else
		{
			intPoints = 11; // The card scores 11 as an ace
		}

		// Define where to print the points
		pointsRow = inputCard.getRowCoord() - 1;
		pointsCol = inputCard.getColCoord() + 4;

		// Print the point addition sign
		cardPoints[0] = "+" + intPoints;
		stampBoard(cardPoints, pointsRow, pointsCol, YELLOW);

		// Update the points
		currentPoints += intPoints;

		// Clear and reprint the scoreboard to reflect points changes
		eraseScoreBoard();
		printScoreBoard();
	}

	/**
	 * Checks if the player has won the level
	 * @return True if the player has won, false otherwise
	 * @throws InterruptedException
	 */
	private boolean checkWin() throws InterruptedException
	{
		if (currentScore > currentGoal || currentScore == currentGoal) // If we've met the required score, we've won
		{
			erase(WIN_BOX_ROW, WIN_BOX_COL, WIN_BOX_WIDTH, WIN_BOX_HEIGHT);
			printBox(WIN_BOX_ROW, WIN_BOX_COL, WIN_BOX_HEIGHT, WIN_BOX_WIDTH, YELLOW);

			// Center the win text and print it
			String[] centeredWin = centerAscii(WIN_ARRAY, WIN_BOX_WIDTH - 2);
			stampBoard(centeredWin, WIN_BOX_ROW + 1, WIN_BOX_COL + 1, YELLOW);
			
			printBoard(false);
			Thread.sleep(2000);

			if (currentLevel == 5) // If we're at the last level
			{
				System.out.println("Thank you for playing!");
				System.exit(0); // Exit the program
			}

			currentLevel++;
			fillDeck(); // Refill the deck for the next level
			deckLength = 52; //Reset the deck length when we go to the next level
			initializeBoard(); // Re-initialize the board
			printBoard(true); // Re-print the board
			return true;
		}
		return false;
	}

	/**
	 * Check if the player has lost
	 * @return False if the player has not lost, exits the program if the player has (does not return anything)
	 * @throws InterruptedException
	 */
	private boolean checkLoss() throws InterruptedException
	{
		if (deckLength == 0 || hands == 0) // if we've run out of cards or hands
		{
			erase(WIN_BOX_ROW, WIN_BOX_COL, WIN_BOX_WIDTH, WIN_BOX_HEIGHT);
			printBox(WIN_BOX_ROW, WIN_BOX_COL, WIN_BOX_HEIGHT, WIN_BOX_WIDTH, RED);

			// Center the win text and print it
			String[] centeredFail = centerAscii(FAIL_ARRAY, WIN_BOX_WIDTH - 2);
			stampBoard(centeredFail, WIN_BOX_ROW + 1, WIN_BOX_COL + 1, RED);
			
			printBoard(false);
			Thread.sleep(2000);
			System.exit(0); // Exit the program, don't bother returning true
		}
		return false;
	}

	/**
	 * Updates the target score to reach depending on the level
	 */
	private void updateGoal()
	{
		switch (currentLevel)
		{
			case 1:
				currentGoal = LEVEL_ONE_GOAL;
				break;
			case 2:
				currentGoal = LEVEL_TWO_GOAL;
				break;
			case 3:
				currentGoal = LEVEL_THREE_GOAL;
				break;
			case 4:
				currentGoal = LEVEL_FOUR_GOAL;
				break;
			case 5:
				currentGoal = LEVEL_FIVE_GOAL;
				break;
			default:
				currentGoal = LEVEL_ONE_GOAL;
				break;
		}
	}

	/**
	 * Sets all the cards in the hand to null
	 */
	private void clearHand()
	{
		for (int card = 0; card < hand.length; card++)
		{
			hand[card] = null;
		}
	}



	/**
	 * Main method to play the game.
	 * @throws InterruptedException
	 */
	public void playGame() throws InterruptedException
	{
		boolean contGame = true; // Set LCV to true
		Scanner scanner = new Scanner(System.in);
		this.initializeBoard();
		while (contGame)
		{
			updateGoal(); // Update the goal score first

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
							checkHandType(); // Check the hand type
							printScoreBoard(); // Print the score board
							this.printBoard(true); // Display the board
							break;
						}
						
					case 's':
					sortType = 1;
						this.sortHand(sortType); // Sort the hand by suit
						this.printBoard(true); // Display the board
						break;
					case 'n':
						sortType = 0;
						this.sortHand(sortType); // Sort the hand by suit
						this.printBoard(true); // Display the board
						
						break;
					case 'q':
						scanner.close(); // Close the input stream
						contGame = false; // Quit the game
						break;
					case 'd':
						this.discard(); // Discard the selected cards. The method handles printing
						break;
					case 'p':
						this.playHand(); // Play the hand
						break;
					case 'h':
						printHelp();
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
	private void testPrintSelected()
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

	/**
	 * Debug method that prints the contents of the hand to the terminal
	 */
	private void testPrintHand()
	{
		for (int i = 0; i < hand.length; i++)
		{
			if (hand[i] != null)
			{
				System.out.println(hand[i].toString());
			}
			if (hand[i] == null)
			{
				System.out.println("null");
			}
		}
	}

	/**
	 * Debug method that prints the entire deck to the console for debugging.
	 */
	private void testPrintDeck()
	{
		for (int i = 0; i < deck.length; i++)
		{
			if (deck[i] != null)
			{
				System.out.println(deck[i].toString());
			}
			else
			{
				System.out.println("null");
			}
		}
	}

	/**
	 * Debug method that prints the contents of a string array to the terminal
	 * @param array Array of strings to print
	 */
	private void testPrintStringArray(String[] array)
	{
		for (int line = 0; line < array.length; line++)
		{
			System.out.println(array[line]);
		}
	}

}