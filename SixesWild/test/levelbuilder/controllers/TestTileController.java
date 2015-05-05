package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.controllers.TileController;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;

/**
 * 
 * @author Tiffany
 *
 */
public class TestTileController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getReleaseBtn().doClick();

		assertEquals(3, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();
		
		SpaceView sv = application.getLbLevelView().getBoardView().getGrid()
				.get(0);
		TileView tv = sv.getTileView();
		TileController tc = new TileController(tv, application.getLbLevelView()
				.getLevel(), application);
		tc.mousePressed(null);
		assertEquals(0, tv.getTile().getValue());
		assertFalse(sv.getSpace().isEnabled());
		
		tc.mouseEntered(null);
		assertNotNull(tv.getBorder());
		
		tc.mouseExited(null);
		assertNull(tv.getBorder());
	}

}
