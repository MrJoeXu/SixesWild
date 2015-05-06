/**
 * 
 */
package test.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import src.sixeswildgame.controllers.MakeMoveController;
import src.sixeswildgame.controllers.ResetBoardController;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.SelectLevelController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;
import junit.framework.TestCase;

/**
 * @author Hvandenberg
 *
 */
public class TestMakeMoveController extends TestCase {
	
	public void test() throws FileNotFoundException, FontFormatException,
	IOException {
		
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();

		StartController sc = new StartController(application, world);

		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());

		SelectGameTypeController controller = new SelectGameTypeController(
				application, world, 1);
		controller.actionPerformed(null);
		assertEquals(1, application.getGameType());

		assertTrue(application.getLevelSelectorView().isVisible());

		Level level = world.getPuzzleLevels().get(0);

		SelectLevelController slc = new SelectLevelController(application,
				world, level);

		slc.actionPerformed(null);

		assertTrue(application.getLevelView().isVisible());
		assertEquals(application.getLevelView(), application.getFrmSixesWild()
				.getContentPane());
		
		int numMoves = level.getMovesLeft();
		int numSwapMoves = level.getSwapTwoTilesMoves();
		int numRemoveMoves = level.getRemoveTileMoves();
		
		MakeMoveController rbc = new MakeMoveController(application.getLevelView().getBoardView().getGrid().get(0).getTileView()
				, level, application);
		MakeMoveController rbc2 = new MakeMoveController(application.getLevelView().getBoardView().getGrid().get(1).getTileView()
				, level, application);

		rbc.mouseEntered(null);
		rbc.mouseExited(null);
		rbc.mousePressed(null);
		rbc2.mouseEntered(null);
		rbc2.mouseExited(null);
	
		assertEquals(level.getMovesLeft(), numMoves);
		
		application.getLevelView().setSwapTwoTiles(true);
		
		rbc.mousePressed(null);
		
		assertEquals(level.getSwapTwoTilesMoves(), numSwapMoves);
		
		rbc2.mousePressed(null);
		
		assertEquals(level.getSwapTwoTilesMoves() + 1, numSwapMoves);
		
		application.getLevelView().setRemoveTile(true);
		
		rbc.mousePressed(null);
		
		assertEquals(level.getRemoveTileMoves() + 1, numRemoveMoves);
		
		rbc.mouseReleased(null);
		
	}

}
