/**
 * 
 */
package src.sixeswildgame.world;

/**
 * @author Halsey
 *
 */
public class EliminationSpace extends Space {
	
	protected boolean isMarked;

	/**
	 * @param tile
	 * @param isMarked
	 */
	public EliminationSpace(Tile tile, boolean isMarked) {
		super(tile);
		this.isMarked = isMarked;
	}

	

}
