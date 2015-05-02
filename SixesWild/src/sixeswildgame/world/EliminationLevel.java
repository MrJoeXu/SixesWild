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
		return false;
	}

}
