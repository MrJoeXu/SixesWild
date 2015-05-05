package test.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;
import src.levelbuilder.view.LevelBuilderWindow;

/**
 * 
 * @author Tiffany
 *
 */
public class TestUpdateSpecialMovesControllers extends TestCase {
	public void test() throws FileNotFoundException, FontFormatException,
			IOException {
		LevelBuilderWindow application = new LevelBuilderWindow();

		application.getPuzzleBtn().doClick();

		application.getLbLevelSelectorView().getNewLevelBtn().doClick();

		application.getLbLevelView().getCheckbxResetBoard().doClick();

		assertTrue(application.getLbLevelView().getCheckbxRemoveTile()
				.isSelected());

		application.getLbLevelView().getResetBoardTextField().setText("10");

		assertEquals(10, application.getLbLevelView().getLevel()
				.getResetBoardMoves());

		application.getLbLevelView().getResetBoardTextField().setText("");

		application.getLbLevelView().getCheckbxResetBoard().doClick();

		assertTrue(application.getLbLevelView().getCheckbxResetBoard()
				.isEnabled());
		
		assertEquals(0, application.getLbLevelView().getLevel()
				.getResetBoardMoves());
		
		application.getLbLevelView().getCheckbxSwapTiles().doClick();

		assertTrue(application.getLbLevelView().getCheckbxSwapTiles()
				.isEnabled());

		application.getLbLevelView().getSwapTilesTextField().setText("20");

		assertEquals(20, application.getLbLevelView().getLevel()
				.getSwapTwoTilesMoves());

		application.getLbLevelView().getSwapTilesTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel()
				.getSwapTwoTilesMoves());
		
		application.getLbLevelView().getCheckbxRemoveTile().doClick();

		assertTrue(application.getLbLevelView().getCheckbxRemoveTile()
				.isEnabled());

		application.getLbLevelView().getRemoveTileTextField().setText("15");

		assertEquals(15, application.getLbLevelView().getLevel()
				.getRemoveTileMoves());

		application.getLbLevelView().getRemoveTileTextField().setText("");

		assertEquals(0, application.getLbLevelView().getLevel()
				.getRemoveTileMoves());
	}
}
