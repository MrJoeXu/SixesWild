package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.World;

public class TestUpdateLevelNameController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getLvlNameTextField()
				.setText("My New Level");

		assertEquals("\"My New Level\"", application.getLbLevelView()
				.getLevelNameLbl().getText());

	}
}
