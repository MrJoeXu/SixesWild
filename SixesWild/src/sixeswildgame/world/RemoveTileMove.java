/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class RemoveTileMove extends Move {
	
	protected Tile tile;
	protected Level level;

	public RemoveTileMove(Tile tl, Level lv) {
		super(tl, lv);
		this.tile = tl;
		this.level = level;
	}
	
	@Override
	public boolean doMove (Level lv) {
		
		Tile tile = lv.getMove().getTiles().get(0);
		
		//lv.getBoard().getGrid().get(tile.getRow() * lv.getBoard().getDimension() + tile.getColumn()).remove(tile);
		
		lv.setRemoveTileMoves(lv.getRemoveTileMoves() - 1);
		return true;
	}
		
}
