/**
 * 
 */
package src.sixeswildgame.world;

import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * @author Halsey
 *
 */
public class LightningLevel extends Level {

	/**
	 * Creates new LightningLevel with specified board, id, and gameType
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public LightningLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
	}

	/**
	 * Creates new LightningLevel with specified file
	 * @param file
	 */
	public LightningLevel(File file) {
		super(file);
	}

	public boolean hasWon() {
		if (minutes == 0 && seconds == 0) {
			if (super.getCurrentScore() > super.getOneStarScore()) {
				return true;
			}
		}
		return false;
	}

}
