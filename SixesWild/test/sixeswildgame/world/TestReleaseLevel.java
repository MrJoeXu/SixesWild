package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.LightningLevel;
import src.sixeswildgame.world.ReleaseLevel;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestReleaseLevel extends TestCase{
	
	Board tb = new Board(1);
	Tile tt = new Tile(5,2,1,1,3,1,false);
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	ReleaseLevel trl = new ReleaseLevel(tb,1,"2");

	@Test
	public void testReleaseLevelConstructor() {
		assertEquals(tb,trl.getBoard());
		assertEquals(1,trl.getId());
	}
	
	public void testHasWonRelease() {
		assertEquals(true, trl.hasWon());
	}
}
