/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import src.sixeswildgame.world.Space;

/**
 * @author Halsey
 *
 */
public class SpaceView extends JPanel {
	
	protected TileView tileView;
	protected Space space;
	protected boolean isEnabled;

	/**
	 * 
	 */
	public SpaceView(Space space) {
		this.space = space;
		this.isEnabled = true;
		this.tileView = new TileView(space.getTile());
		setPreferredSize(new Dimension(80, 80));

		if (!isEnabled()) {
			setBackground(Color.WHITE);
		}

		else add(tileView);
	}

}
