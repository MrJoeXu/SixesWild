package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import src.levelbuilder.view.LevelBuilderWindow;
import junit.framework.TestCase;

/**
 * 
 * @author Tiffany
 *
 */
public class TestTileRangeController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();
		
		assertTrue(application.getLbLevelView().getLevel().getTileRange()[1]);

		application.getLbLevelView().getTileRangeCheckBoxes().get(1).doClick();

		assertFalse(application.getLbLevelView().getLevel().getTileRange()[1]);
		
	}
}
