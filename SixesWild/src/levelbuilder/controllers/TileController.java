/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		if (!space.isEnabled()) tileView.setBackground(Color.LIGHT_GRAY);
		application.getLbLevelView().getToggleMoves().add(application.getLbLevelView().getActiveIndex(), space);
		while (application.getLbLevelView().getActiveIndex() + 1 < application.getLbLevelView().getToggleMoves().size()) {
			application.getLbLevelView().getToggleMoves().remove(application.getLbLevelView().getActiveIndex() + 1);
		}
		application.getLbLevelView().incrementActiveIndex();
		System.out.println("Active Index: " + application.getLbLevelView().getActiveIndex());
		System.out.println("Moves List Size: " + application.getLbLevelView().getToggleMoves().size());
		tileView.repaint();
		
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
