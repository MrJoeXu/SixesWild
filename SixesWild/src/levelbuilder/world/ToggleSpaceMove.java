/**
 * 
 */
package src.levelbuilder.world;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;

/**
 * @author Tiffany Leung
 *
 */
public class ToggleSpaceMove implements MouseListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected SpaceView spaceView;

	/**
	 * @param level
	 * @param application
	 * @param space
	 */
	public ToggleSpaceMove(Level level, LevelBuilderWindow application,
			SpaceView spaceView) {
		super();
		this.level = level;
		this.application = application;
		this.spaceView = spaceView;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (space.getTile().isSelected()) {
			int i = space.getTile().getRow();
			int j = space.getTile().getColumn();
			int dimension = application.getLbLevelView().getBoardView()
					.getBoard().getDimension();
			Space locatedSpace = application.getLbLevelView().getBoardView()
					.getBoard().getGrid().get(i * dimension + j);
			locatedSpace.getTile().setSelected(false);
			
			application.getLbLevelView().repaint();
			application.getFrame().pack();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
