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
	protected boolean enabled;
	protected boolean isBucket;
	protected boolean isSix;

	/**
	 * 
	 */
	public Space(Tile tile) {
		this.tile = tile;
		this.enabled = true;
	}

	/**
	 * @param tile
	 * @param enabled
	 */
	public Space(Tile tile, boolean enabled) {
		super();
		this.tile = tile;
		this.enabled = enabled;
	}



	public void toggleEnabled() {
		enabled = !enabled;
		if (!enabled) {
			tile.setValue(0);
			tile.setBonus(0);
		}
		else {
			tile.setValue(tile.getLastValue());
			tile.setBonus(tile.getLastBonus());
		}
	}
	
	public String toString() {
		String spaceString = "";
		
		spaceString += tile.toString() + enabled + ",";
		
		return spaceString;
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

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	
}
