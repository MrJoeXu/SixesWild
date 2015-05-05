/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * Creates new SpaceView with specified space and spaceLength
	 * 
	 * @param space
	 * @param spaceLength
	 */
	public SpaceView(Space space, int spaceLength) {
		this.space = space;
		this.isEnabled = true;
		this.spaceLength = spaceLength;
		setPreferredSize(new Dimension(spaceLength, spaceLength));
		this.tileView = new TileView(space.getTile(), spaceLength);

		if (!isEnabled()) {
			setBackground(Color.LIGHT_GRAY);
		}

		else
			add(tileView);
	}

	/**
	 * @return the tileView
	 */
	public TileView getTileView() {
		return tileView;
	}

	/**
	 * @param tileView the tileView to set
	 */
	public void setTileView(TileView tileView) {
		this.tileView = tileView;
	}

	/**
	 * @return the space
	 */
	public Space getSpace() {
		return space;
	}

	/**
	 * @param space the space to set
	 */
	public void setSpace(Space space) {
		this.space = space;
	}

	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the spaceLength
	 */
	public int getSpaceLength() {
		return spaceLength;
	}

	/**
	 * @param spaceLength the spaceLength to set
	 */
	public void setSpaceLength(int spaceLength) {
		this.spaceLength = spaceLength;
	}

}