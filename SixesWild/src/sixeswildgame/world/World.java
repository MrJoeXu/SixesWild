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
	
	protected ArrayList<PuzzleLevel> puzzleLevels;
	protected ArrayList<LightningLevel> lightningLevels;
	protected ArrayList<ReleaseLevel> releaseLevels;
	protected ArrayList<EliminationLevel> eliminationLevels;
	
	/**
	 * 
	 */
	public World() {
		puzzleLevels = new ArrayList<PuzzleLevel>();
		lightningLevels = new ArrayList<LightningLevel>();
		releaseLevels = new ArrayList<ReleaseLevel>();
		eliminationLevels = new ArrayList<EliminationLevel>();
	}

	/**
	 * @return the puzzleLevels
	 */
	public ArrayList<PuzzleLevel> getPuzzleLevels() {
		return puzzleLevels;
	}

	/**
	 * @param puzzleLevels the puzzleLevels to set
	 */
	public void setPuzzleLevels(ArrayList<PuzzleLevel> puzzleLevels) {
		this.puzzleLevels = puzzleLevels;
	}

	/**
	 * @return the lightningLevels
	 */
	public ArrayList<LightningLevel> getLightningLevels() {
		return lightningLevels;
	}

	/**
	 * @param lightningLevels the lightningLevels to set
	 */
	public void setLightningLevels(ArrayList<LightningLevel> lightningLevels) {
		this.lightningLevels = lightningLevels;
	}

	/**
	 * @return the releaseLevels
	 */
	public ArrayList<ReleaseLevel> getReleaseLevels() {
		return releaseLevels;
	}

	/**
	 * @param releaseLevels the releaseLevels to set
	 */
	public void setReleaseLevels(ArrayList<ReleaseLevel> releaseLevels) {
		this.releaseLevels = releaseLevels;
	}

	/**
	 * @return the eliminationLevels
	 */
	public ArrayList<EliminationLevel> getEliminationLevels() {
		return eliminationLevels;
	}

	/**
	 * @param eliminationLevels the eliminationLevels to set
	 */
	public void setEliminationLevels(ArrayList<EliminationLevel> eliminationLevels) {
		this.eliminationLevels = eliminationLevels;
	}

	
	
}