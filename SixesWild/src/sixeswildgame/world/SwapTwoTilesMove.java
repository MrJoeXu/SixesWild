/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class SwapTwoTilesMove extends Move {

	protected Tile tile1;
	protected Tile tile2;

	/**
	 * Creates new SwapTwoTilesMove with specified tile and level
	 * 
	 * @param tl
	 * @param lv
	 */
	public SwapTwoTilesMove(Tile tl, Level lv) {
		super(tl, lv);
		this.tile1 = tl;
	}
	
	/**
	 * Swaps two selected Tiles
	 */
	@Override
	public boolean doMove(Level lv) {

		int row1 = tile1.getRow();
		int col1 = tile1.getColumn();
		int row2 = tile2.getRow();
		int col2 = tile2.getColumn();

		tile1.setRow(row2);
		tile1.setColumn(col2);
		tile2.setRow(row1);
		tile2.setColumn(col1);

		lv.getBoard().getGrid().get(row1 * lv.getBoard().getDimension() + col1)
				.setTile(tile2);
		lv.getBoard().getGrid().get(row2 * lv.getBoard().getDimension() + col2)
				.setTile(tile1);

		lv.setSwapTwoTilesMoves(lv.getSwapTwoTilesMoves() - 1);
		return true;
	}

	/**
	 * @return the tile1
	 */
	public Tile getTile1() {
		return tile1;
	}

	/**
	 * @param tile1
	 *            the tile1 to set
	 */
	public void setTile1(Tile tile1) {
		this.tile1 = tile1;
	}

	/**
	 * @return the tile2
	 */
	public Tile getTile2() {
		return tile2;
	}

	/**
	 * @param tile2
	 *            the tile2 to set
	 */
	public void setTile2(Tile tile2) {
		this.tile2 = tile2;
	}

}
