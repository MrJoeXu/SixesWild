package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.io.File;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.LightningLevel;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestLightningLevel extends TestCase{
	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	LightningLevel tll = new LightningLevel(tb,1,"2");
	
	@Test
	public void testLightningLevelConstructor() {
		assertEquals(tb,tll.getBoard());
		assertEquals(1,tll.getId());
	}
	
	public void testHasWonLighning() {
		tll.setMinutes(0);
		tll.setSeconds(1);
		tll.decrementTime();
		tll.setOneStarScore(1);
		tll.setCurrentScore(2);
		assertEquals(true, tll.hasWon());
		assertEquals(0, tll.getMinutes());
		assertEquals(0, tll.getSeconds());
	}

}
