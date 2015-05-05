package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;

import src.levelbuilder.controllers.SelectLevelController;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;
import junit.framework.TestCase;

/**
 * 
 * @author Tiffany
 *
 */
public class TestSelectLevelController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();
		World world = application.getWorld();

		application.getEliminationBtn().doClick();

		assertEquals(4, application.getGameType());
		
		JButton level1Btn = application.getLbLevelSelectorView().getLevelButtons().get(0);
		
		Level level = world.getEliminationLevels().get(0);
		//System.out.println(world.getEliminationLevels().toString());

		SelectLevelController slc = new SelectLevelController(level1Btn, application, level);
		
		//level1Btn.doClick();
		
		slc.mouseClicked(null);
		assertNotNull(level1Btn.getBorder());
		assertTrue(level1Btn.isEnabled()); 
		
		slc.mouseClicked(null);
		assertNull(level1Btn.getBorder());
		
		slc.mouseEntered(null);
		assertNotNull(level1Btn.getBorder());
		
		slc.mouseExited(null);
		assertNull(level1Btn.getBorder());
		
		slc.mouseClicked(null);
		
		//application.getLbLevelSelectorView().getBuildLevelBtn().doClick();
		
	}
}
