/**
 * 
 */
package src.sixeswildgame.world;

/**
 * @author Halsey
 *
 */
public class Space {
	
	protected Tile tile;

	/**
	 * 
	 */
	public Space(Tile tile) {
		this.tile = tile;
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	
	
}
