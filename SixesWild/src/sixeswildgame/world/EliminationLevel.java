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
public class EliminationLevel extends Level {

	/**
	 * Creates a new EliminationLevel with specified board, id, and gameType
	 * 
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public EliminationLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
	}

	/**
	 * Creates a new EliminationLevel with specified file
	 * @param file
	 */
	public EliminationLevel(File file) {
		super(file);
	}
	
	/**
	 * Returns true if all the tiles in the Board are marked
	 */
	public boolean hasWon() {
		for (int i = 0; i < this.getBoard().getGrid().size(); i++) {
			if ((this.getBoard().getGrid().get(i).getTile().getValue() != 6) && 
					(this.getBoard().getGrid().get(i).getTile().getValue() != 0)) {
				if (!(this.getBoard().getGrid().get(i).isMarked()))
					return false;
			}
		}
		return true;
	}
}
