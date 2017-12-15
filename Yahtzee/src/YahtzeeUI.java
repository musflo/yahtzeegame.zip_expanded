import java.util.Scanner;

public class YahtzeeUI {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean keepPlaying = true;
		while (keepPlaying) {
			Yahtzee theGame = new Yahtzee();
			while (theGame.isNotOver()) {
				takeaTurn(theGame);
				System.out.println();
			}
			displayScoreCard(theGame);
			System.out.println("Final Score: " + theGame.scoreCard().finalScore());
			keepPlaying = playAgain();
		}
		System.out.println("Thank you, have a good day.");
		scan.close();
	}

	public static int askForInt(Scanner scan, String prompt) {
		while (true) {
			try {
				String choice = askForString(scan, prompt);
				int answer = Integer.parseInt(choice);
				return answer;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid number");
			}
		}
	}

	public static String askForString(Scanner scan, String prompt) {
		System.out.println(prompt);
		String answer = scan.nextLine();
		return answer;
	}

	private static void displayDice(Yahtzee theGame) {
		for (int i = 0; i < theGame.dice().size(); i++)			
			System.out.print("#" + (i+1) + "\t");
		System.out.println();
		for (Die aDie : theGame.dice()) 
			System.out.print(aDie.sideUp + "\t");
		System.out.println();
	}

	private static void displayScoreCard(Yahtzee theGame) {
		YahtzeeScoreCardRow[] rows = theGame.scoreCard().rows(theGame.dice());
		for (int i = 0; i < rows.length; i++ ) 
			if (rows[i].isScored()) 
				System.out.println("    " + rows[i].label + "  " + rows[i].score());
			else
				System.out.println((i + 1) + ".  " + rows[i].label + "  (" + rows[i].score() + ")");
	}

	private static void eliminateDice(Yahtzee theGame) {
		String dieNumbers = askForString(scan, "Choose die positions to remove (eg. 1 3 5)");
		theGame.eliminateDie(dieNumbers);
		theGame.roll();
	}

	private static void eliminateDiceOrAskToScore(Yahtzee theGame) {
		String choice = askForString(scan, "(R)oll or (S)core? " + theGame.rollsLeft() + " rolls left");
		if (choice.toUpperCase().equals("S")) { 
			pickScore(theGame);
		} else {
			eliminateDice(theGame);
		}
	}

	private static void pickScore(Yahtzee theGame) {
		int row = 0;
		do {
			row = askForInt(scan, " Please pick a row to score:");
			row -= 1 ;
		} while (theGame.scoreCard().rows(theGame.dice())[row].isScored());
		theGame.pickAScore(row);
	}

	private static boolean playAgain() {
		return (askForString(scan, "Play Again?")).toUpperCase().equals("Y");
	}

	private static void takeaTurn(Yahtzee theGame) {
		System.out.println("You are starting a turn. " + theGame.turnsLeft() + " turns left.");
		theGame.startTurn();
		while (theGame.inATurn()) {
			displayScoreCard(theGame);
			displayDice(theGame);
			if (theGame.rollsLeft() > 0)
				eliminateDiceOrAskToScore(theGame);
			else
				pickScore(theGame);
		}
	}

}

