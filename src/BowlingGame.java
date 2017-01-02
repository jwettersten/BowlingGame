
public class BowlingGame {
	private int currentRoll = 0;
	private int rolls[] = new int[21]; // 21 potential rolls - no more than 3 in 10th frame

	public void roll(int numPinsKnockedDown) {
		rolls[currentRoll] = numPinsKnockedDown;

		currentRoll++;
	}

	public int score() {
		int currentScore = 0;

		int frameIndex = 0;

		for (int frame = 0; frame < 10; frame++) {

			if (isSpare(frameIndex)) {
				currentScore += 10 + spareBonus(frameIndex);
				frameIndex += 2;

			} else if (isStrike(frameIndex)) {
				currentScore += 10 + strikeBonus(frameIndex);

				frameIndex += 1;

			} else {
				currentScore += sumOfPins(frameIndex);

				frameIndex += 2;
			}
    }
		return currentScore;
	}

	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1] == 10;
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1] + rolls[frameIndex+2];
	}

	private int sumOfPins(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1];
	}
}
