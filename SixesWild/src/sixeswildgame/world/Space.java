/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class Space {
	
	protected Tile tile;
	protected boolean enabled;
	protected ArrayList<Integer> releaseStates;
	protected int activeIndex;

	/**
	 * 
	 */
	public Space(Tile tile) {
		this.tile = tile;
		this.enabled = true;
		this.releaseStates = new ArrayList<Integer>();
		this.activeIndex = 0;
		releaseStates.add(tile.getValue());
	}

	/**
	 * @param tile
	 * @param enabled
	 */
	public Space(Tile tile, boolean enabled) {
		super();
		this.tile = tile;
		this.enabled = enabled;
		this.releaseStates = new ArrayList<Integer>();
		this.activeIndex = 0;
		releaseStates.add(tile.getValue());
	}

	public void toggleEnabled() {
		enabled = !enabled;
		if (enabled) {
			tile.setValue(tile.getLastValue());
			tile.setBonus(tile.getLastBonus());
		}
	}
	
	public String toString() {
		String spaceString = "";
		
		spaceString += tile.toString() + enabled + ",";
		
		return spaceString;
	}
	
	public void printReleaseStates() {
		String s = "";
		for (int i : releaseStates) {
			s += i + ", ";
		}
		System.out.println("Release States: " + s);
		System.out.println("Active Index: " + activeIndex);
	}
	
	public void incrementActiveIndex() {
		activeIndex++;
	}

	public void decrementActiveIndex() {
		activeIndex--;
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

	/**
	 * @return the releaseStates
	 */
	public ArrayList<Integer> getReleaseStates() {
		return releaseStates;
	}

	/**
	 * @param releaseStates the releaseStates to set
	 */
	public void setReleaseStates(ArrayList<Integer> releaseStates) {
		this.releaseStates = releaseStates;
	}

	/**
	 * @return the activeIndex
	 */
	public int getActiveIndex() {
		return activeIndex;
	}

	/**
	 * @param activeIndex the activeIndex to set
	 */
	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
	
}
