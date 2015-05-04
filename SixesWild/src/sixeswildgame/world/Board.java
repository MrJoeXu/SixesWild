/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

import src.sixeswildgame.view.SpaceView;

/**
 * @author Halsey
 *
 */
public class Board {

	protected ArrayList<Space> grid;
	protected int dimension;

	/**
	 * Creates new Board with specified dimension
	 * 
	 * @param grid
	 * @param dimension
	 */
	public Board(int dimension) {
		this.dimension = dimension;
		this.grid = new ArrayList<Space>();

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				Space space = new Space(new Tile(i, j));
				grid.add(space);
			}
		}
	}

	/**
	 * Returns this grid
	 * 
	 * @return the grid
	 */
	public ArrayList<Space> getGrid() {
		return grid;
	}

	/**
	 * Sets this grid to given grid
	 * 
	 * @param grid
	 *            the grid to set
	 */
	public void setGrid(ArrayList<Space> grid) {
		this.grid = grid;
	}

	/**
	 * Returns this dimension
	 * 
	 * @return the dimension
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * Sets this dimension to given dimension
	 * 
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	/**
	 * Returns the Space in given row and column of this Board
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Space getSpace(int row, int col) {
		return this.grid.get(row * dimension + col);
	}
	
	/**
	 * Sets Tile of row and column in this Board to given Tile
	 * @param row
	 * @param col
	 * @param tl
	 */
	public void setTile(int row, int col, Tile tl) {
		Tile temp = new Tile(tl.getValue(), tl.getBonus(), row, col, false);
		this.getSpace(row, col).setTile(temp);
	}
}
