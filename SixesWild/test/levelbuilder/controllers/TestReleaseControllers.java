package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JCheckBox;

import junit.framework.TestCase;
import src.levelbuilder.controllers.ReleaseController;
import src.levelbuilder.controllers.TileController;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;

/**
 * 
 * @author Tiffany
 *
 */
public class TestReleaseControllers extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getReleaseBtn().doClick();

		assertEquals(3, application.getGameType());

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		SpaceView sv = application.getLbLevelView().getBoardView().getGrid()
				.get(0);
		TileView tv = sv.getTileView();
		JCheckBox bucket = application.getLbLevelView().getBucketCheckBox();
		//ReleaseController cForBucket = new ReleaseController(application,
				//application.getGameType(), bucket);

		assertFalse(bucket.isSelected());
		bucket.doClick();
		assertTrue(bucket.isSelected());

		TileController tc = new TileController(tv, application.getLbLevelView()
				.getLevel(), application);
		
		tc.mousePressed(null);
		
		assertEquals(7, tv.getTile().getValue());
		
		JCheckBox six = application.getLbLevelView().getRangeSixCheckBox();
		assertFalse(six.isSelected());
		six.doClick();
		assertFalse(bucket.isSelected());
		assertTrue(six.isSelected());
		
		tc.mousePressed(null);
		tc.mousePressed(null);
		
		assertEquals(6, tv.getTile().getValue());

	}

}
