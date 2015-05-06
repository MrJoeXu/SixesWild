package test.sixeswildgame.world;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.RemoveTileMove;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestRemoveTileMove extends TestCase {

	Board tb = new Board(2);
	Tile tt1 = new Tile(5,2,0,0,3,1,false);
	Tile tt2 = new Tile(4,0,0,1,4,0,false);
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
	
	Level tll = new Level(tb,1,"2");
	RemoveTileMove trtm = new RemoveTileMove(tt1,tll,2);
	
	@Test
	
	public void testrtmDoMove(){
		tll.setCurrentScore(0);
		tll.setRemoveTileMoves(2);
		
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		
		tll.getBoard().setGrid(grid);
		
		assertEquals(true, trtm.doMove(tll));
		assertEquals(20, tll.getCurrentScore());
		assertEquals(1, tll.getRemoveTileMoves());
	}
	
	public void testrtmConstructor(){
		assertEquals(tt1,trtm.getTiles().get(0));
	}
}
