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
	protected int spaceLength;

	/**
	 * 
	 */
	public SpaceView(Space space, int spaceLength) {
		this.space = space;
		this.isEnabled = true;
		this.spaceLength = spaceLength;
		setPreferredSize(new Dimension(spaceLength, spaceLength));
		this.tileView = new TileView(space.getTile(), spaceLength);
		System.out.print(spaceLength);

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

	public int getSpaceLength() {
		return spaceLength;
	}

	public void setSpaceLength(int spaceLength) {
		this.spaceLength = spaceLength;
	}
	
	

}