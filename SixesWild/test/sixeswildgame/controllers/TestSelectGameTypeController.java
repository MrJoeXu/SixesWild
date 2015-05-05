/**
 * 
 */
package test.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;

import junit.framework.TestCase;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Tiffany
 *
 */
public class TestSelectGameTypeController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException, IOException {
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();
		
		StartController sc = new StartController(application, world);
		
		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());
		
		//JButton puzzleBtn = application.getGameTypeView().getPuzzleBtn();
		
		SelectGameTypeController controller = new SelectGameTypeController(application, world, 1);
		controller.actionPerformed(null);
		assertEquals(1, application.getGameType());
		
		assertTrue(application.getLevelSelectorView().isVisible());
	}
}
