package test.sixeswildgame.world;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

public class TestWorld extends TestCase{

	World tw = new World();
	Board tb = new Board(9);
	Tile tt1 = new Tile(5,2,9,9,3,1,false);
	Tile tt2 = new Tile(4,0,9,8,2,3,false);
	private boolean enabled;
	Space ts1 = new Space(tt1,enabled);
	Space ts2 = new Space(tt2,enabled);
	Level tpl = new Level(tb,1,"1");
	Level tll = new Level(tb,1,"2");
	Level trl = new Level(tb,1,"3");
	Level tel = new Level(tb,1,"4");

	@Test
	public void testSetnGetPuzzleLevels() {
		ArrayList<Level> puzzleLevels = new ArrayList<Level>();
		puzzleLevels.add(tpl);
		tw.setPuzzleLevels(puzzleLevels);
		assertEquals(puzzleLevels,tw.getPuzzleLevels());
	}
	
	public void testSetnGetLighningLevels() {
		ArrayList<Level> lightningLevels = new ArrayList<Level>();
		lightningLevels.add(tll);
		tw.setLightningLevels(lightningLevels);
		assertEquals(lightningLevels,tw.getLightningLevels());
	}
	
	public void testSetnGetReleaseLevels() {
		ArrayList<Level> releaseLevels = new ArrayList<Level>();
		releaseLevels.add(trl);
		tw.setReleaseLevels(releaseLevels);
		assertEquals(releaseLevels,tw.getReleaseLevels());
	}
	
	public void testSetnGetEliminationLevels() {
		ArrayList<Level> eliminationLevels = new ArrayList<Level>();
		eliminationLevels.add(tel);
		tw.setEliminationLevels(eliminationLevels);
		assertEquals(eliminationLevels,tw.getEliminationLevels());
	}
}
