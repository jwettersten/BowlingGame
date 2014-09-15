
public class BowlingGame {
	
	private int numberOfRolls = 0;
	private int[] rolls = new int[22];
	
	public void roll(int pins) {
		rolls[numberOfRolls] = pins;
		
		numberOfRolls++;
	}
	
	public int score() {
		int score = 0;
		
		int currentRoll = 0;
		for (int frame = 0; frame < 10; frame++) {
			
			if (isStrike(currentRoll)) {
				// apply next 2 rolls to currentRoll value
				score += 10 + rolls[currentRoll + 1] + rolls[currentRoll + 2];
				currentRoll++;
				
			} else if (isSpare(currentRoll)) {
				// for every 2 positions within rolls[] - need to check for value of 10
				// apply next role to value
				score += 10 + rolls[currentRoll + 2];
				currentRoll += 2;
				
			} else {
				score += rolls[currentRoll] + rolls[currentRoll + 1];
				currentRoll += 2;
			}
		}
		
		return score;
	}

	private boolean isSpare(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll + 1] == 10;
	}
	
	private boolean isStrike(int currentRoll) {
		return rolls[currentRoll] == 10;
	}
	
	
}
