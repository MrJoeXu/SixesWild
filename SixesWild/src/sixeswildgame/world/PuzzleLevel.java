/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * @author Halsey
 *
 */
public class PuzzleLevel extends Level {

	/**
	 * @param board
	 * @param specialMoves
	 * @param id
	 * @param currentScore
	 * @param highScore
	 * @param oneStarScore
	 * @param twoStarScore
	 * @param threeStarScore
	 * @param movesLeft
	 * @param bonusFrequency
	 * @param time
	 * @param isLocked
	 * @param tileRange
	 */
	public PuzzleLevel(Board board, ArrayList<SpecialMove> specialMoves,
			int id, int currentScore, int highScore, int oneStarScore,
			int twoStarScore, int threeStarScore, int movesLeft,
			int bonusFrequency, Timer time, boolean isLocked,
			boolean[] tileRange) {
		super(board, specialMoves, id, currentScore, highScore, oneStarScore,
				twoStarScore, threeStarScore, movesLeft, bonusFrequency, time,
				isLocked, tileRange);
		// TODO Auto-generated constructor stub
	}

	public void hasWon() {
		
	}

}
