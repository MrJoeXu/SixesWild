package test.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import junit.framework.TestCase;
import src.sixeswildgame.controllers.LevelSelectorBackController;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.SelectLevelController;
import src.sixeswildgame.controllers.SelectSpecialMoveController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * 
 * @author Tiffany
 *
 */
public class TestSelectSpecialMoveController extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		SixesWildWindow application = new SixesWildWindow();
		World world = application.getWorld();

		StartController sc = new StartController(application, world);

		sc.actionPerformed(null);
		assertTrue(application.getGameTypeView().isVisible());

		SelectGameTypeController controller = new SelectGameTypeController(
				application, world, 4);
		controller.actionPerformed(null);
		assertEquals(4, application.getGameType());

		Level level = world.getEliminationLevels().get(0);

		SelectLevelController slc = new SelectLevelController(application,
				world, level);

		slc.actionPerformed(null);

		assertTrue(application.getLevelView().isVisible());
		assertEquals(application.getLevelView(), application.getFrmSixesWild()
				.getContentPane());

		JCheckBox swapBox = application.getLevelView().getSwapTilesCheckBox();

		JCheckBox removeTileBox = application.getLevelView().getRemoveTileCheckBox();
		
		//assertFalse(application.getLevelView().getres)
		removeTileBox.doClick();
		//System.out.print(sttBox.isSelected());
		swapBox.doClick();
		//System.out.print(sttBox.isSelected());
		assertFalse(removeTileBox.isSelected());
		

	}
}
