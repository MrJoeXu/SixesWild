/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * @author tleung
 * @author Halsey Vandenberg
 *
 */
public class UpdateTileRangeController implements ActionListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JCheckBox checkBox;
	
	/**
	 * 
	 */
	public UpdateTileRangeController(LevelBuilderWindow application, Level level, JCheckBox checkBox) {
		this.application = application;
		this.level = level;
		this.checkBox = checkBox;

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		level.getTileRange()[application.getLbLevelView().getTileRangeCheckBoxes().indexOf(checkBox)] = checkBox.isSelected();
		level.setBoard(new Board(level.getBoard().getDimension()));
		level.initialize();
		BoardView newBoardView = new BoardView(level.getBoard(), 33, 33);
		
		application.getLbLevelView().setBoardView(newBoardView);
		application.getLbLevelView().getBoardPanel().removeAll();
		application.getLbLevelView().getBoardPanel().add(newBoardView);
		
		for (SpaceView sv : application.getLbLevelView().getBoardView().getGrid() ) {
			TileView tv = sv.getTileView();
			tv.addMouseListener(new TileController(tv, level, application));
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	
	}

}
