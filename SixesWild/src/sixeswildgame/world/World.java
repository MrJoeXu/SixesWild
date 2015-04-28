/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class World {
	
	protected ArrayList<Level> puzzleLevels;
	protected ArrayList<Level> lightningLevels;
	protected ArrayList<Level> releaseLevels;
	protected ArrayList<Level> eliminationLevels;
	
	/**
	 * 
	 */
	public World() {
		puzzleLevels = new ArrayList<Level>();
		lightningLevels = new ArrayList<Level>();
		releaseLevels = new ArrayList<Level>();
		eliminationLevels = new ArrayList<Level>();
	}

	/**
	 * @return the puzzleLevels
	 */
	public ArrayList<Level> getPuzzleLevels() {
		return puzzleLevels;
	}

	/**
	 * @param puzzleLevels the puzzleLevels to set
	 */
	public void setPuzzleLevels(ArrayList<Level> puzzleLevels) {
		this.puzzleLevels = puzzleLevels;
	}

	/**
	 * @return the lightningLevels
	 */
	public ArrayList<Level> getLightningLevels() {
		return lightningLevels;
	}

	/**
	 * @param lightningLevels the lightningLevels to set
	 */
	public void setLightningLevels(ArrayList<Level> lightningLevels) {
		this.lightningLevels = lightningLevels;
	}

	/**
	 * @return the releaseLevels
	 */
	public ArrayList<Level> getReleaseLevels() {
		return releaseLevels;
	}

	/**
	 * @param releaseLevels the releaseLevels to set
	 */
	public void setReleaseLevels(ArrayList<Level> releaseLevels) {
		this.releaseLevels = releaseLevels;
	}

	/**
	 * @return the eliminationLevels
	 */
	public ArrayList<Level> getEliminationLevels() {
		return eliminationLevels;
	}

	/**
	 * @param eliminationLevels the eliminationLevels to set
	 */
	public void setEliminationLevels(ArrayList<Level> eliminationLevels) {
		this.eliminationLevels = eliminationLevels;
	}

	
	
}