/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;

/**
 * @author Halsey
 *
 */
public class UndoController implements ActionListener {
	
	protected ArrayList<Space> toggleSpaceMoves;
	protected LevelBuilderWindow application;
	protected Level level;

	/**
	 * @param toggleSpaceMoves
	 * @param application
	 * @param level
	 */
	public UndoController(ArrayList<Space> toggleSpaceMoves,
			LevelBuilderWindow application, Level level) {
		super();
		this.toggleSpaceMoves = toggleSpaceMoves;
		this.application = application;
		this.level = level;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		Space s;
		if (application.getLbLevelView().getActiveIndex() - 1 < 0) return;
		else s = application.getLbLevelView().getToggleMoves().get(application.getLbLevelView().getActiveIndex() - 1);
		TileView tileView = application.getLbLevelView().getBoardView().getGrid().get(s.getTile().getRow() * 
				level.getBoard().getDimension() + s.getTile().getColumn()).getTileView();
		s.toggleEnabled();
		application.getLbLevelView().decrementActiveIndex();

		if (!s.isEnabled()) tileView.setBackground(Color.LIGHT_GRAY);
		System.out.println("Active Index: " + application.getLbLevelView().getActiveIndex());
		System.out.println("Moves List Size: " + application.getLbLevelView().getToggleMoves().size());
		tileView.repaint();
		
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	}

}
