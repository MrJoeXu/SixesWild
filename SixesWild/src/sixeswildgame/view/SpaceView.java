/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import src.sixeswildgame.world.Space;

/**
 * @author Halsey & JoeXu
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
		setPreferredSize(new Dimension(70, 70));
		this.tileView = new TileView(space.getTile(), 40);
		

		if (!isEnabled()) {
			setBackground(Color.WHITE);
		}

		else add(tileView);
	}

	public TileView getTileView() {
		return tileView;
	}

	public void setTileView(TileView tileView) {
		this.tileView = tileView;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}