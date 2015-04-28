/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.EliminationLevel;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.LightningLevel;
import src.sixeswildgame.world.PuzzleLevel;
import src.sixeswildgame.world.ReleaseLevel;
import src.sixeswildgame.world.World;

/**
 * @author Halsey
 *
 */
public class SaveController implements ActionListener {
	
	protected Level level;
	protected LevelBuilderWindow application;
	protected World world;

	/**
	 * @param level
	 * @param application
	 */
	public SaveController(Level level, LevelBuilderWindow application, World world) {
		this.level = level;
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		LBLevelView view = application.getLbLevelView();
		
		if (!view.getLvlNameTextField().getText().equals("")) level.setName(view.getLvlNameTextField().getText());
		
		if (!view.getResetBoardTextField().getText().equals("")) level.setResetBoardMoves(Integer.parseInt(view.getResetBoardTextField().getText()));
		if (!view.getSwapTilesTextField().getText().equals("")) level.setSwapTwoTilesMoves(Integer.parseInt(view.getSwapTilesTextField().getText()));
		if (!view.getRemoveTileTextField().getText().equals("")) level.setRemoveTileMoves(Integer.parseInt(view.getRemoveTileTextField().getText()));
		
		if (!view.getOneStarTextField().getText().equals("")) level.setOneStarScore(Integer.parseInt(view.getOneStarTextField().getText()));
		if (!view.getTwoStarTextField().getText().equals("")) level.setTwoStarScore(Integer.parseInt(view.getTwoStarTextField().getText()));
		if (!view.getThreeStarTextField().getText().equals("")) level.setThreeStarScore(Integer.parseInt(view.getThreeStarTextField().getText()));
		
		if (!view.getMovesLeftTextField().getText().equals("")) level.setMovesLeft(Integer.parseInt(view.getMovesLeftTextField().getText()));
		
		level.save(application.getGameTypeName());
		
		if (application.getGameType() == 1 && !world.getPuzzleLevels().contains(level)) world.getPuzzleLevels().add(level);
		if (application.getGameType() == 2 && !world.getLightningLevels().contains(level)) world.getLightningLevels().add(level);
		if (application.getGameType() == 3 && !world.getReleaseLevels().contains(level)) world.getReleaseLevels().add(level);
		if (application.getGameType() == 4 && !world.getEliminationLevels().contains(level)) world.getEliminationLevels().add(level);
		
		application.getLbLevelView().getSaveLbl().setText("Level Saved");
	}

}
