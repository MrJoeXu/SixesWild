/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import src.sixeswildgame.world.Board;

/**
 * @author Halsey
 *
 */
public class BoardView extends JPanel {
	
	protected ArrayList<SpaceView> grid;
	protected Board board;
	protected int dimension;

	/**
	 * 
	 */
	public BoardView(Board board) {
		this.board = board;
		this.dimension = board.getDimension();
		this.setPreferredSize(new Dimension(500, 500));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setLayout(new GridLayout(dimension, dimension));
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				SpaceView spaceView = new SpaceView(board.getGrid().get(i * dimension + j));
				this.add(spaceView);
			}
		}
	}

}
