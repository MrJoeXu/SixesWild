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
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public LightningLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param file
	 */
	public LightningLevel(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public boolean hasWon() {
		if (time.getDelay() <= 0) {
			if (super.getCurrentScore() > super.getOneStarScore()) {
				return true;
			}
		}
		return false;
	}

}
