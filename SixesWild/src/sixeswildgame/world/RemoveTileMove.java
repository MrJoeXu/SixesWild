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
		lv.getMove().getTiles().remove(tile);
		lv.decrementMoves();
		return true;
	}
		
}
