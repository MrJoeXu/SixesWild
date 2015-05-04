package test.sixeswildgame.world;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Tile;

public class TestTile extends TestCase{
	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,8,false);

	@Test
	public void testsetngetRow() {
		tt.setRow(7);
		assertEquals(7, tt.getRow());
	}
	
	public void testsetngetColumn(){
		tt.setColumn(6);
		assertEquals(6, tt.getColumn());
	}
	
	public void testsetnisSelected(){
		tt.setSelected(true);
		assertEquals(true, tt.isSelected());
	}

}
