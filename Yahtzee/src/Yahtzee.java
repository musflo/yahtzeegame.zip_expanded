import java.util.ArrayList;

public class Yahtzee {
	
	private boolean isNotOver;
	private int turnsLeft;
	private int rollsLeft;
	private boolean inATurn;
	private ArrayList<Die> dice;
	
	public Yahtzee() {
		this.isNotOver = true;
		this.turnsLeft = 13;
		this.rollsLeft = 0;
		this.inATurn = false;
		this.dice = new ArrayList<Die>();
	
	}
	public ArrayList<Die> dice() {
		return this.dice;
	}
	
	public boolean isNotOver() {
		return (this.turnsLeft !=0);
	}
	public boolean inATurn() {
		return this.inATurn;
	}
	public void pickAScore(int row) {
		this.inATurn = false;
	}
	public void roll() {
		while (this.dice.size() <5)
			this.dice.add(new Die());
		this.rollsLeft--;
	}
	public int rollsLeft() {
		return this.rollsLeft;
	}
	public void startTurn() {
		this.inATurn = true;
		this.turnsLeft--;
		this.rollsLeft = 3;
		this.dice.clear();
		this.roll();
		}
	public void eliminateDie(String dieNumbers) {
		// TODO Auto-generated method stub
		
	}
	public int turnsLeft() {
		return this.turnsLeft;
	}
	public YahtzeeScoreCard scoreCard() {
		return this.scoreCard();
	}
	}


