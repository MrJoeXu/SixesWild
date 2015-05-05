package test.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.SelectLevelController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

public class TestSelectLevelController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();

		StartController sc = new StartController(application, world);

		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());

		SelectGameTypeController controller = new SelectGameTypeController(
				application, world, 1);
		controller.actionPerformed(null);
		assertEquals(1, application.getGameType());

		assertTrue(application.getLevelSelectorView().isVisible());
		
		Level level = world.getPuzzleLevels().get(0);
		
		SelectLevelController slc = new SelectLevelController(application, world, level);
		
		slc.actionPerformed(null);
		
		assertTrue(application.getLevelView().isVisible());
		assertEquals(application.getLevelView(), application.getFrmSixesWild().getContentPane());
		
		

	}
}
