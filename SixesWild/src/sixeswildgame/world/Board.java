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
	
	public Space getSpace (int row, int col) {
		return this.grid.get(row*dimension + col);
	}
}
