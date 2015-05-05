package test.sixeswildgame.world;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.sixeswildgame.world.*;

public class TestBoard extends TestCase{

	
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
	
	@Test
	public void testSetnGetDimention(){
		tb.setDimension(8);
		assertEquals(8,tb.getDimension());
	}
	
	public void testsetGrid(){
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		
		tb.setGrid(grid);
		assertEquals(grid, tb.getGrid());
	}
	
	public void testGetSpace(){
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		
		tb.setGrid(grid);
		assertEquals(ts1, tb.getSpace(0, 0));
	}
	
	public void testSetTile(){
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		
		tb.setGrid(grid);
		
		tb.setTile(0, 0, tt5);
		assertEquals(true, tt5 != tb.getSpace(0,0).getTile());
	}
}
