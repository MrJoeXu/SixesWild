package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.World;

public class TestUpdateTimeControllers extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getLightningBtn().doClick();

		assertEquals(2, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getTimerMinuteTextField().setText("4");
		application.getLbLevelView().getTimerSecondTextField().setText("40");

		assertEquals(4, application.getLbLevelView().getLevel().getMinutes());
		assertEquals(40, application.getLbLevelView().getLevel().getSeconds());
	}
}
