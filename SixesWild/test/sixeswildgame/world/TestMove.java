package test.sixeswildgame.world;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Move;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

public class TestMove extends TestCase{
	
	World tw = new World();
	Board tb = new Board(9);
	Tile tt1 = new Tile(5,2,9,9,3,1,false);
	Tile tt2 = new Tile(1,0,9,8,2,3,false);
	private boolean enabled;
	Space ts1 = new Space(tt1, enabled);
	Space ts2 = new Space(tt2,enabled);
	Level tpl = new Level(tb,1,"1");
	Move tm = new Move(tt1, tpl,1);

	@Test
	public void testisValid() {
		tm.addTile(tt2);
		assertEquals(true, tm.isValid());
	}
	
	public void testRemoveTile(){
		tm.addTile(tt2);
		assertEquals(tt2,tm.removeLast());
	}
	
	public void testDoMove(){
		tm.removeLast();
		tpl.setMovesLeft(2);
		assertEquals(false, tm.doMove(tpl));
	}
	
	

}
