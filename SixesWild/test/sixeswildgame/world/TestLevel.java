package test.sixeswildgame.world;

import static org.junit.Assert.*;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

public class TestLevel {
	Board tb = new Board(9);
	Tile tt = new Tile(5,2,9,9,3,1,false);
	private boolean set;
	private boolean enabled;
	Space ts = new Space(tt, enabled);
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
