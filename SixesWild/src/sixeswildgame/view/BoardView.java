/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	protected int tileLength;
	protected int spaceLength;
	
	/**
	 * Creates new BoardView with specified board, t
	 * @param board
	 * @param tileLength
	 * @param spaceLength
	 */
	public BoardView(Board board, int tileLength, int spaceLength) {
		this.board = board;
		this.dimension = board.getDimension();
		this.tileLength = tileLength;
		this.spaceLength = spaceLength;
		this.grid = new ArrayList<SpaceView>();
		
		this.setLayout(new GridLayout(dimension, dimension));
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				SpaceView spaceView = new SpaceView(board.getGrid().get(i * dimension + j), spaceLength);
				spaceView.getTileView().setLength(tileLength);
				this.add(spaceView);
				grid.add(spaceView);
			}
		}
		
		this.setPreferredSize(new Dimension(40+dimension*tileLength, 40+dimension*tileLength));
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


	public int getSpaceLength() {
		return spaceLength;
	}

	public void setSpaceLength(int spaceLength) {
		this.spaceLength = spaceLength;
	}

	public int getTileLength() {
		return tileLength;
	}

	public void setTileLength(int tileLength) {
		this.tileLength = tileLength;
	}

}