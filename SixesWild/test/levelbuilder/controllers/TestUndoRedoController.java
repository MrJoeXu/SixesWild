package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.controllers.RedoController;
import src.levelbuilder.controllers.TileController;
import src.levelbuilder.controllers.UndoController;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author Tiffany
 *
 */
public class TestUndoRedoController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getReleaseBtn().doClick();

		assertEquals(3, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		Level level = application.getLbLevelView().getLevel();

		SpaceView sv = application.getLbLevelView().getBoardView().getGrid()
				.get(0);
		TileView tv = sv.getTileView();
		TileController tc = new TileController(tv, application.getLbLevelView()
				.getLevel(), application);
		tc.mousePressed(null);
		assertEquals(0, tv.getTile().getValue());
		assertFalse(sv.getSpace().isEnabled());

		UndoController uc = new UndoController(application.getLbLevelView()
				.getToggleMoves(), application, level);

		uc.actionPerformed(null);

		assertTrue(sv.getSpace().isEnabled());

		RedoController rc = new RedoController(application.getLbLevelView()
				.getToggleMoves(), application, level);
		
		rc.actionPerformed(null);
		
		assertFalse(sv.getSpace().isEnabled());
	}

}
