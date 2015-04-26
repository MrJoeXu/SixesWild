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
	 * @param resetBoardMoves
	 * @param swapTwoTilesMoves
	 * @param removeTileMoves
	 * @param id
	 * @param currentScore
	 * @param highScore
	 * @param oneStarScore
	 * @param twoStarScore
	 * @param threeStarScore
	 * @param movesLeft
	 * @param bonusFrequency
	 * @param time
	 * @param minutes
	 * @param seconds
	 * @param isLocked
	 * @param tileRange
	 * @param allowedSpecialMoves
	 */
	public PuzzleLevel(Board board, int resetBoardMoves, int swapTwoTilesMoves,
			int removeTileMoves, int id, int currentScore, int highScore,
			int oneStarScore, int twoStarScore, int threeStarScore,
			int movesLeft, int bonusFrequency, Timer time, int minutes,
			int seconds, boolean isLocked, boolean[] tileRange,
			boolean[] allowedSpecialMoves) {
		super(board, resetBoardMoves, swapTwoTilesMoves, removeTileMoves, id,
				currentScore, highScore, oneStarScore, twoStarScore, threeStarScore,
				movesLeft, bonusFrequency, time, minutes, seconds, isLocked, tileRange,
				allowedSpecialMoves);
		// TODO Auto-generated constructor stub
	}

	public void hasWon() {
		
	}

}
