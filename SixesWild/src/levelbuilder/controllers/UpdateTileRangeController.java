/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
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
		//level.printTileRange();
		//System.out.println(application.getLbLevelView().getTileRangeCheckBoxes().indexOf(checkBox));
		level.getTileRange()[application.getLbLevelView().getTileRangeCheckBoxes().indexOf(checkBox)] = checkBox.isSelected();
		//System.out.println(checkBox.isSelected());
		level.setBoard(new Board(level.getBoard().getDimension()));
		level.initialize();
		BoardView newBoardView = new BoardView(level.getBoard(), 50, 50);
		//ArrayList<SpaceView> newGrid = new ArrayList<SpaceView>();
		int j = 1;
		for(boolean i : level.getTileRange()) {
			System.out.println("after initialize(): ");
			System.out.println(j + ": " + i);
			j++;
		}
		/*
		application.setLbLevelView(new LBLevelView(application, world, level));
		application.getFrame().setContentPane(application.getLbLevelView());
		application.getLbLevelView().setVisible(true);
		application.getFrame().pack();
		
		*/
		application.getLbLevelView().setBoardView(newBoardView);
		application.getLbLevelView().getBoardPanel().removeAll();
		application.getLbLevelView().getBoardPanel().add(newBoardView);
		application.getLbLevelView().repaint();
		application.getFrame().pack();
		
		
		//level.printTileRange();
	}

}
