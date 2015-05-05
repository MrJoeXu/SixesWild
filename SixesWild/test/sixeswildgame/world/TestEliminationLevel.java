package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.EliminationLevel;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestEliminationLevel extends TestCase {

	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	EliminationLevel tel = new EliminationLevel(tb,1,"1");
	
	@Test
	public void testElimLevelConstructor() {
		assertEquals(tb,tel.getBoard());
		assertEquals(1,tel.getId());
	}
	
	public void testHasWonElim() {
		assertEquals(true, tel.hasWon());
	}

}
