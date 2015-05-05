package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;

public class TestUpdateStarControllers extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getLightningBtn().doClick();

		assertEquals(2, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getOneStarTextField().setText("100");

		assertEquals(100, application.getLbLevelView().getLevel().getOneStarScore());

		application.getLbLevelView().getOneStarTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel().getOneStarScore());
		
		application.getLbLevelView().getTwoStarTextField().setText("200");

		assertEquals(200, application.getLbLevelView().getLevel().getTwoStarScore());

		application.getLbLevelView().getTwoStarTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel().getTwoStarScore());
		
		application.getLbLevelView().getThreeStarTextField().setText("300");

		assertEquals(300, application.getLbLevelView().getLevel().getThreeStarScore());

		application.getLbLevelView().getThreeStarTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel().getThreeStarScore());

	}

}
