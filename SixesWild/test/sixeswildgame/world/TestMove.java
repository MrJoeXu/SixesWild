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
	Board tb1 = new Board(3);
	Board tb = new Board(2);
	Tile tt1 = new Tile(5,2,0,0,3,1,false);
	Tile tt2 = new Tile(1,0,0,1,4,0,false);
	Tile tt3 = new Tile(2,1,1,0,5,2,false);
	Tile tt4 = new Tile(5,2,1,1,3,1,false);
	Tile tt5 = new Tile(3,1,0,0,3,1,false);
	
	private boolean enabled;
	Space ts1 = new Space(tt1, enabled);	
	Space ts2 = new Space(tt2, enabled);
	Space ts3 = new Space(tt3, enabled);	
	Space ts4 = new Space(tt4, enabled);
	Space ts5 = new Space(tt5, enabled);
	
	ArrayList<Space> grid= new ArrayList<Space>();
	Level tpl = new Level(tb,1,"1");
	Level tll = new Level(tb,1,"2");
	Level trl = new Level(tb,1,"3");
	Level tel = new Level(tb,1,"4");
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
	
	public void testDoMoveNotValid(){
		tm.removeLast();
		tpl.setMovesLeft(2);
		assertEquals(false, tm.doMove(tpl));
	}
	
	public void testDoMoveisValid(){
		tm.addTile(tt2);
		tpl.setCurrentScore(0);
		
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		tb.setGrid(grid);		
		tpl.getBoard().setGrid(grid);

		assertEquals(true,tm.doMove(tpl));
		
	}
	
	
	

}
