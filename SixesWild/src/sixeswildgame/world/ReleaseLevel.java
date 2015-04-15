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
public class ReleaseLevel extends Level{

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
	public ReleaseLevel(Board board, int resetBoardMoves, int swapTwoTilesMoves,
			int removeTileMoves, int id, int currentScore, int highScore,
			int oneStarScore, int twoStarScore, int threeStarScore,
			int movesLeft, int bonusFrequency, Timer time, boolean isLocked,
			boolean[] tileRange, boolean[] allowedSpecialMoves) {
		super(board, resetBoardMoves, swapTwoTilesMoves,
				removeTileMoves, id, currentScore, highScore,
				oneStarScore, twoStarScore, threeStarScore,
				movesLeft, bonusFrequency, time, isLocked,
				tileRange, allowedSpecialMoves);
	}

	public void hasWon() {
		
	}

}
