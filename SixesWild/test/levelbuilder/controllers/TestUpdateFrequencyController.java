package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;

/**
 * 
 * @author Tiffany
 *
 */
public class TestUpdateFrequencyController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getFrequencySlider().setValue(3);

		assertEquals(21, application.getLbLevelView().getLevel().getBonusFrequency());

	}
}
