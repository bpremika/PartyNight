package logic;

import java.util.Random;

public class Die {
	private final Random die1;
	private final Random die2;

	private int dieOneRoll;
	private int dieTwoRoll;

	public Die() {
		die1 = new Random();
		die2 = new Random();
	}

	public int roll() {
		dieOneRoll = die1.nextInt(6) + 1;
		dieTwoRoll = die2.nextInt(6) + 1;
		return dieOneRoll + dieTwoRoll;
	}

	public int getDieOneRoll() {
		return dieOneRoll;
	}

	public int getDieTwoRoll() {
		return dieTwoRoll;
	}

}
