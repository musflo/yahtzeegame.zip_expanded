import java.util.ArrayList;

public class YahtzeeScoreCard {

	private YahtzeeScoreCardRow[] rows;

	public YahtzeeScoreCard() {
		this.rows = new YahtzeeScoreCardRow[13];
		rows[0] = new YahtzeeScoreCardRow("Aces");
	}
	public YahtzeeScoreCardRow[] rows() {
		return this.rows;
	}
	
	public YahtzeeScoreCardRow [] rows(ArrayList<Die> dice) {
		calculatePotentialScores(dice);
		return this.rows;
	}

	private void calculatePotentialScores(ArrayList<Die> dice) {
		// TODO Auto-generated method stub
		
	}
	public int sumOf(ArrayList<Die> dice, int toMatch) {
		int total = 0;
		for (Die die : dice)
			if (die.sideUp == toMatch || toMatch == -1)
				total += die.sideUp;
		return total;
		
	}

	public int sumOf(ArrayList<Die> dice) {
		return sumOf(dice, -1);
	}

	public boolean sameDice(ArrayList<Die> dice, int ofAKind) {
		for (int i = 1; i <= 6; i++) {
			if (sumOf(dice, i) >= (i *  ofAKind))
			return true;
		}
		return false;
	}

	public boolean inOrder(ArrayList<Die> dice, int toMatch) {
		for (int i = 1; i + toMatch -1 <= 6; i++) {
			System.out.println("i=" + i);
			boolean found = true;
			for (int j = i; j < i + toMatch; j++) {
				System.out.println(j);
				if (sumOf(dice, j) < j)
					found = false;
			}
			if (found)
				return true;
		}
		return false;
	}
	public String finalScore() {
		// TODO Auto-generated method stub
		return null;
	}
	private int sumRows(int from, int to) {
	}

}



