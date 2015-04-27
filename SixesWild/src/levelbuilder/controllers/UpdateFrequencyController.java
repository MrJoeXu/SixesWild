/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author Joe Xu
 *
 */
public class UpdateFrequencyController implements ChangeListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JSlider slider;

	/**
	 * 
	 */
	public UpdateFrequencyController(LevelBuilderWindow application,
			Level level, JSlider slider) {
		this.application = application;
		this.level = level;
		this.slider = slider;
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		if (!slider.getValueIsAdjusting()) {
			int bonusSlide = (int) slider.getValue();
			switch (bonusSlide) {
			case 3: level.setBonusFrequency(21); break;
			case 4: level.setBonusFrequency(12); break;
			case 5: level.setBonusFrequency(3); break;
			}
			level.initialize();
			
			BoardView newBoardView = new BoardView(level.getBoard(), 33, 33);
			int length = newBoardView.getDimension()*newBoardView.getTileLength() + 5 * newBoardView.getDimension();
			int panelX = (350 - length)/2;
			//System.out.print(panelX);
			int panelY = (350 - length)/2;
			//System.out.print(panelY);
			newBoardView.setBounds(panelX, panelY, length, length);
			
			application.getLbLevelView().setBoardView(newBoardView);
			application.getLbLevelView().getBoardPanel().removeAll();
			application.getLbLevelView().getBoardPanel().add(newBoardView);
			//application.getLbLevelView().getBoardPanel().setAlignmentY(JComponent.CENTER_ALIGNMENT);
			application.getLbLevelView().repaint();
			application.getFrame().pack();
		}
	}
}