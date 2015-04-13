/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Halsey
 *
 */
public class SpaceView extends JPanel {
	
	protected TileView tileView;
	protected boolean isEnabled;

	/**
	 * 
	 */
	public SpaceView() {
		setPreferredSize(new Dimension(50, 50));
		this.setBackground(Color.green);
		this.tileView = new TileView();
		this.isEnabled = true;
		add(tileView);
	}

}
