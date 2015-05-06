package test.sixeswildgame.world;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Move;
import src.sixeswildgame.world.RemoveTileMove;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.SwapTwoTilesMove;
import src.sixeswildgame.world.Tile;

public class TestLevel extends TestCase{

	Board tb1 = new Board(3);
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
	Level tll = new Level(tb,1,"1");
	
	@Test
	public void testSetnGetHighScore() {
		tll.setHighScore(100);
		assertEquals(100, tll.getHighScore());
	}
	
	public void testSetnGetCurrentScore(){
		tll.setCurrentScore(100);
		assertEquals(100, tll.getCurrentScore());
	}
	
	public void testSetnGetGameType(){
		tll.setGameType(1);
		assertEquals(1, tll.getGameType());
	}
	
	public void testgetBoard(){
		tll.setBoard(tb1);
		assertEquals(tb1, tll.getBoard());
	}
	
	public void testInitialize(){
		tll.initialize(tll.getGameType());
		assertEquals(2,tll.getBoard().getDimension());
	}
	
	public void testDecnIncTime(){
		tll.setMinutes(1);
		tll.setSeconds(0);
		tll.decrementTime();
		assertEquals(0, tll.getMinutes());
		assertEquals(59, tll.getSeconds());
		tll.incrementTime();
		assertEquals(1, tll.getMinutes());
		assertEquals(0, tll.getSeconds());
	}
	
	public void testSetSpecialMove(){
		boolean[] allowedSpecialMoves = null;
		tll.setAllowedSpecialMoves(allowedSpecialMoves);
		assertEquals(allowedSpecialMoves,tll.getAllowedSpecialMoves());
	}
	
	public void testGetnSetId(){
		tll.setId(2);
		assertEquals(2, tll.getId());
	}
	
	public void testGetnSetStartScore(){
		tll.setOneStarScore(90);
		assertEquals(90, tll.getOneStarScore());
		tll.setTwoStarScore(120);
		assertEquals(120,tll.getTwoStarScore());
		tll.setThreeStarScore(150);
		assertEquals(150,tll.getThreeStarScore());
	}
	
	public void testSetnGetName(){
		tll.setName("test");
		assertEquals("test", tll.getName());
	}
	
	public void testSetnGetMove(){
		grid.add(ts1);
		grid.add(ts2);
		grid.add(ts3);
		grid.add(ts4);
		tb.setGrid(grid);
		
		Move tm = new Move(tt1,tll,1);
		tll.setMove(tm);
		assertEquals(tm, tll.getMove());
	}
	
	public void testSetnGetMoveLeft(){
		tll.setMovesLeft(10);
		assertEquals(10, tll.getMovesLeft());
	}
	
	public void testSetnGetBonusFreq(){
		tll.setBonusFrequency(3);
		assertEquals(3, tll.getBonusFrequency());
	}
	
	public void testSetnCheckLock(){
		boolean isLocked = false;
		tll.setLocked(isLocked);
		assertEquals(isLocked, tll.isLocked());
	}
	
	public void testTileRange(){
		tll.setTileRange(null);
		assertEquals(null, tll.getTileRange());
	}
	
	public void testResetBoardMove(){
		tll.setResetBoardMoves(5);
		assertEquals(5, tll.getResetBoardMoves());
	}
	
	public void testSwapTiles(){
		tll.setSwapTwoTilesMoves(4);
		assertEquals(4, tll.getSwapTwoTilesMoves());
	} 
	
	public void testRemoveTile(){
		tll.setRemoveTileMoves(3);
		assertEquals(3, tll.getRemoveTileMoves());
	}
	
	public void testAllAllowSpeMoves(){
		tll.setAllowedSpecialMoves(null);;
		assertEquals(null, tll.getAllowedSpecialMoves());
	}
	
	public void testSetnGetMakingMove(){
		tll.setMakingMove(true);
		assertEquals(true, tll.isMakingMove());
	}
	
	public void testSetnGetFile(){
		tll.setFile(null);
		assertEquals(null, tll.getFile());
	}
	
	public void testdecMove(){
		tll.setMovesLeft(2);
		tll.decrementMoves();
		assertEquals(1, tll.getMovesLeft());
	}
	
	public void testSetnGetsttMove(){
		SwapTwoTilesMove tsttm = new SwapTwoTilesMove(tt1,tll,1);
		tll.setSttMove(tsttm);
		assertEquals(tsttm, tll.getSttMove());
	}
	
	public void testSetnGetrtMove(){
		RemoveTileMove trtm = new RemoveTileMove(tt1,tll,2);
		tll.setRtMove(trtm);
		assertEquals(trtm, tll.getRtMove());
	}
}
