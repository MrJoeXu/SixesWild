package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.util.AbstractList;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.SwapTwoTilesMove;
import src.sixeswildgame.world.Tile;

public class TestSwapTwoTiles extends TestCase{
	
	Board tb = new Board(9);
	Tile tt1 = new Tile(5,2,8,7,3,1,true);
	Tile tt2 = new Tile(4,0,7,8,2,3,true);
	private boolean enabled;
	Space ts1 = new Space(tt1, enabled);
	Space ts2 = new Space(tt2,enabled);
	Level tll = new Level(tb,1,"2");
	SwapTwoTilesMove tsttm = new SwapTwoTilesMove(tt1,tll,1);

	@Test
	public void testSTTMoveConstructor() {
		assertEquals(tt1, tsttm.getTile1());
	}
	
	public void testDoMove(){
		
		tsttm.setTile1(tt1);
		assertEquals(tt1,tsttm.getTile1());	
		
		tsttm.setTile2(tt2);
		assertEquals(tt2,tsttm.getTile2());
		
		tll.setSwapTwoTilesMoves(2);
		
		assertEquals(true,tsttm.doMove(tll));	
	}

}
