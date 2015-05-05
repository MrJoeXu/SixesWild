package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.LightningLevel;
import src.sixeswildgame.world.RemoveTileMove;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestRemoveTileMove extends TestCase {

	Board tb = new Board(9);
	Tile tt1 = new Tile(5,2,9,9,3,1,false);
	Tile tt2 = new Tile(4,0,9,8,2,3,false);
	private boolean enabled;
	Space ts1 = new Space(tt1, enabled);
	Space ts2 = new Space(tt2,enabled);
	LightningLevel tll = new LightningLevel(tb,1,"2");
	RemoveTileMove trtm = new RemoveTileMove(tt1,tll,1);
	
	@Test
	public void testrtmConstructor() {
		assertEquals(tt1, trtm.getTiles());
	}

	public void testrtmDoMove(){
		assertEquals(false, trtm.doMove(tll));
	}
}
