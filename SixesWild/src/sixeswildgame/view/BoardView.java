/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author Halsey
 *
 */
public class BoardView extends JPanel {
	
	protected ArrayList<SpaceView> grid;
	protected int dimension;

	/**
	 * 
	 */
	public BoardView(int dimension) {
		this.setPreferredSize(new Dimension(500, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.dimension = dimension;
		this.setLayout(new GridBagLayout());
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				SpaceView spaceView = new SpaceView();
				GridBagConstraints gbc_spaceView = new GridBagConstraints();
				gbc_spaceView.insets = new Insets(0, 0, 1, 1);
				gbc_spaceView.gridx = j;
				gbc_spaceView.gridy = i;
				this.add(spaceView, gbc_spaceView);
			}
		}
	}

}
