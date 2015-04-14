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
 * @author Halsey & JoeXu & Tiffany
 *
 */
public class BoardView extends JPanel {
	
	protected ArrayList<SpaceView> grid;
	protected Board board;
	protected int dimension;
	protected int titleLength;
	/**
	 * 
	 */
	public BoardView(Board board) {
		this.board = board;
		this.dimension = board.getDimension();
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setLayout(new GridLayout(dimension, dimension));
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				SpaceView spaceView = new SpaceView(board.getGrid().get(i * dimension + j));
				titleLength = spaceView.getTileView().getLength();
				this.add(spaceView);
			}
		}
		
		this.setPreferredSize(new Dimension(40+9*titleLength, 400));
	}
  
  /**
	 * @return the grid
	 */
	public ArrayList<SpaceView> getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(ArrayList<SpaceView> grid) {
		this.grid = grid;
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @return the dimension
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getTitleLength() {
		return titleLength;
	}

	public void setTitleLength(int titleLength) {
		this.titleLength = titleLength;
	}

}