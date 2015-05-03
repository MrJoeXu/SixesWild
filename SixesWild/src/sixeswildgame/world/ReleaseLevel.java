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
public class ReleaseLevel extends Level{

	/**
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public ReleaseLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param file
	 */
	public ReleaseLevel(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public boolean hasWon() {
		for (int i = 0; i < this.getBoard().getGrid().size(); i++) {
			if (this.getBoard().getGrid().get(i).getTile().getValue() == 6)
					return false;
		}
		return true;
	}
}
