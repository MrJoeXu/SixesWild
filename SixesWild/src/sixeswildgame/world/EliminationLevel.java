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
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public EliminationLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param file
	 */
	public EliminationLevel(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public boolean hasWon() {
		return false;
	}

}
