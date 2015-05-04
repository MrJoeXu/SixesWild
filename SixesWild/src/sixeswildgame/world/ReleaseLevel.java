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
public class ReleaseLevel extends Level {

	/**
	 * Creates new ReleaseLevel with specified board, id, and gameType
	 * 
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public ReleaseLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
	}

	/**
	 * Creates new ReleaseLevel with specified file
	 * 
	 * @param file
	 */
	public ReleaseLevel(File file) {
		super(file);
	}
	
	/**
	 * Returns true if all 6's are in their respective buckets
	 * @return
	 */
	public boolean hasWon() {
		for (int i = 0; i < this.getBoard().getGrid().size(); i++) {
			if (this.getBoard().getGrid().get(i).getTile().getValue() == 6)
				return false;
		}
		return true;
	}
}
