/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

/**
 * @author Halsey
 *
 */
public class TileController implements MouseListener {
	
	protected TileView tileView;
	protected Level level;
	protected LevelBuilderWindow application;

	/**
	 * @param space
	 * @param level
	 * @param application
	 */
	public TileController(TileView tileView, Level level,
			LevelBuilderWindow application) {
		super();
		this.tileView = tileView;
		this.level = level;
		this.application = application;
	}

	public void mousePressed(MouseEvent me) {
				
		Tile tile = tileView.getTile();

		System.out.println(tile.getRow() + ", " + tile.getColumn());
		
		int row = tile.getRow();
		int column = tile.getColumn();
		
		Space space = level.getBoard().getGrid().get(row * level.getBoard().getDimension() + column);
		
		space.toggleEnabled();
		
		if (!space.isEnabled()) {
			if (application.getLbLevelView().isPlacingSix()) {
				space.getTile().setValue(6);
				space.getTile().setBonus(1);
				space.getReleaseStates().add(6);
				space.incrementActiveIndex();
			}
			else if (application.getLbLevelView().isPlacingBucket()) {
				space.getTile().setValue(7);
				space.getReleaseStates().add(7);
				space.incrementActiveIndex();
			}
			else {
				space.getTile().setValue(0);
				space.getReleaseStates().add(0);
				space.incrementActiveIndex();
			}
		}
		
		else {
			space.getReleaseStates().add(tile.getValue());
			space.incrementActiveIndex();
		}
		
		space.printReleaseStates();
		
		application.getLbLevelView().getToggleMoves().add(application.getLbLevelView().getActiveIndex(), space);
		while (application.getLbLevelView().getActiveIndex() + 1 < application.getLbLevelView().getToggleMoves().size()) {
			application.getLbLevelView().getToggleMoves().remove(application.getLbLevelView().getActiveIndex() + 1);
		}
		application.getLbLevelView().incrementActiveIndex();
		
		tileView.repaint();
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		tileView.setBorder(BorderFactory.createLineBorder(application.getLbLevelSelectorView().getBuildLevelBtn().getCol(), 3, true));
		tileView.repaint();
		application.getFrame().pack();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		tileView.setBorder(null);
		tileView.repaint();
		application.getFrame().pack();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
