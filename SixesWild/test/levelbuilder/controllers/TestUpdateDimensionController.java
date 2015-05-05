package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;

public class TestUpdateDimensionController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getDimensionSlider().setValue(5);

		assertEquals(5, application.getLbLevelView().getLevel().getBoard()
				.getDimension());

	}

}
