package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.World;
import junit.framework.TestCase;

public class TestBackControllers extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();
		World world;

		application.getPuzzleBtn().doClick();

		assertEquals(1, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getBackBtn().doClick();

		assertEquals(true, application.getLbLevelSelectorView().isVisible());

		application.getLbLevelSelectorView().getBackBtn().doClick();
	}

}
