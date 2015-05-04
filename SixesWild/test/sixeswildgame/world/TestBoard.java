package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.sixeswildgame.world.*;

public class TestBoard extends TestCase{

	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean enabled;
	Space ts = new Space(tt, enabled);	
	
	@Test
	public void testgetDimention() {
		assertEquals(9,tb.getDimension());	
	}
	
	public void testsetDimention(){
		tb.setDimension(8);
		assertEquals(8,tb.getDimension());
	}
}
