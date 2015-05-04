package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.sixeswildgame.world.*;

public class TestSpace extends TestCase{

	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean set;
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	
	@Test
	public void testsetisMarked() {
		ts.setIsMarked(set);
		assertEquals(set, ts.isMarked());	
	}
	
	public void testtoString(){
		assertEquals("5,2,9,9,3,1,false,false,",ts.toString());
	}
	
	public void testtoggleEnable(){
		ts.toggleEnabled();
		assertEquals(3, ts.getTile().getValue());
		assertEquals(1, ts.getTile().getBonus());	
	}

}
