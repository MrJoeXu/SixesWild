package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.LightningLevel;
import src.sixeswildgame.world.PuzzleLevel;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestPuzzleLevel extends TestCase {

	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	PuzzleLevel tpl = new PuzzleLevel(tb,1,"2");
	
	@Test
	public void testPuzzleLevelConstructor() {
		assertEquals(tb,tpl.getBoard());
		assertEquals(1,tpl.getId());
	}
	
	public void testHasWonPuzzle() {
		tpl.setOneStarScore(1);
		tpl.setCurrentScore(2);
		assertEquals(true, tpl.hasWon());
	}

}
