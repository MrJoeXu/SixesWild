/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class Board {
	
	protected ArrayList<Space> grid;
	protected int dimension;

	/**
	 * @param grid
	 * @param dimension
	 */
	public Board(ArrayList<Space> grid, int dimension) {
		this.grid = grid;
		this.dimension = dimension;
	}

	/**
	 * @return the grid
	 */
	public ArrayList<Space> getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(ArrayList<Space> grid) {
		this.grid = grid;
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
	
	

}
