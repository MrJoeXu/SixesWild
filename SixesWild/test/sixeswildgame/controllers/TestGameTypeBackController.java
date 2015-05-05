package test.sixeswildgame.controllers;

import java.awt.FontFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.sixeswildgame.controllers.GameTypeBackController;
import src.sixeswildgame.controllers.LevelSelectorBackController;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * 
 * @author Tiffany
 *
 */
public class TestGameTypeBackController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();

		StartController sc = new StartController(application, world);

		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());

		GameTypeBackController gtbc = new GameTypeBackController(world, application);
		
		gtbc.actionPerformed(null);
		
		assertEquals(application.getMainMenuView(), application.getFrmSixesWild().getContentPane());
	}
}