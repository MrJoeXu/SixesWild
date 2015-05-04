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
		int mult = 10 * tile.getBonus();
		ArrayList<Tile> tileArray = new ArrayList<Tile>();
		tileArray.add(tile);
		fallDown(lv, tileArray);
		lv.setCurrentScore(lv.getCurrentScore() + mult);
		lv.setRemoveTileMoves(lv.getRemoveTileMoves() - 1);
		return true;
	}
		
}
