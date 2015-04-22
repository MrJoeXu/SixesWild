/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
 *
 */
public class UpdateDimensionController implements ChangeListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JSlider slider;
	/**
	 * 
	 */
	public UpdateDimensionController(LevelBuilderWindow application, Level level, JSlider slider) {
		this.application = application;
		this.level = level;
		this.slider = slider;
	}
	@Override
	public void stateChanged(ChangeEvent ce) {
		if (!slider.getValueIsAdjusting()) {
			int dimension = (int)slider.getValue();
			level.getBoard().setDimension(dimension); 
			level.setBoard(new Board(level.getBoard().getDimension()));
			level.initialize();
			
			BoardView newBoardView = new BoardView(level.getBoard(), 50, 50);
			
			application.getLbLevelView().setBoardView(newBoardView);
			application.getLbLevelView().getBoardPanel().removeAll();
			application.getLbLevelView().getBoardPanel().add(newBoardView);
			application.getLbLevelView().repaint();
			application.getFrame().pack();
		}
		
	}
	
	

}
