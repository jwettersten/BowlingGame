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
		rollGame(0, 20);
	
		assertEquals(game.score(), 0);
		
	}
	
	@Test
	public void testOnePinPerRollGame() {
		rollGame(1, 20);
		
		assertEquals(20, game.score());	
	}
	
	@Test
	public void testOneSpare() {
		rollSpare();
		game.roll(3);
		game.roll(4); // add in extra roll to test we are not evaluating this as a strike
		rollGame(0, 16);
		assertEquals(20, game.score());
	}
	
	@Test
	public void testStrike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		rollGame(0, 17);
		assertEquals(24, game.score());
	}
	
	@Test
	public void testPerfectGame() {
		rollGame(10, 12);
		assertEquals(300, game.score());
	}

	private void rollSpare() {
		game.roll(3);
		game.roll(7);
	}
	
	
	public void rollGame(int pinsPerRoll, int times) {
		
		for (int i = 0; i < times; i++)
		{
			game.roll(pinsPerRoll);
		}
		
	}

}
