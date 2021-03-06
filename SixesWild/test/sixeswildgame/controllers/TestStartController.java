/**
 * 
 */
package test.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;

import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;
import junit.framework.TestCase;

/**
 * @author Tiffany
 *
 */
public class TestStartController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException, IOException {
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();
		
		StartController sc = new StartController(application, world);
		
		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());
		
	}
}
