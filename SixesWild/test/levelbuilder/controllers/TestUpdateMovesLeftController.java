package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.World;

public class TestUpdateMovesLeftController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getMovesLeftTextField().setText("25");

		assertEquals(25, application.getLbLevelView().getLevel().getMovesLeft());

		application.getLbLevelView().getMovesLeftTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel().getMovesLeft());

	}

}
