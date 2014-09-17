import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {
	
	private BowlingGame game;

	@Before
	public void setUp() throws Exception {
		game = new BowlingGame();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGutterGame() {
		
		int numPins = 0;
		int numRolls = 20;
		
		rollFramesWithNumPins(numPins, numRolls);
		
		assertEquals(0, game.score());
		
	}

	private void rollFramesWithNumPins(int numPins, int numRolls) {
		for (int i = 0; i<numRolls; i++) {
			game.roll(numPins);
		}
	}
	
	@Test
	public void testAllOnes() {
		
		int numPins = 1;
		int numRolls = 20;
		
		rollFramesWithNumPins(numPins, numRolls);
		
		assertEquals(20, game.score());
		
	}
	
	@Test
	public void testOneSpare() {
		
		rollSpare();
		game.roll(3);
		rollFramesWithNumPins(0, 17);
		
		assertEquals(16, game.score());
		
	}

	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	@Test
	public void testOneStrike() {
		
		rollStrike();
		game.roll(3);
		game.roll(3);
		rollFramesWithNumPins(0, 17);
		
		assertEquals(22, game.score());
		
	}
	
	private void rollStrike() {
		game.roll(10);
	}
	
	@Test
	public void testPerfectGame() {
		rollFramesWithNumPins(10, 12);
		
		assertEquals(300, game.score());
	}

}
