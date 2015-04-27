/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

/**
 * @author Halsey
 * @author Tiffany
 *
 */
public class Level {
	
	protected Board board;
	
	protected int resetBoardMoves;
	protected int swapTwoTilesMoves;
	protected int removeTileMoves;
	
	protected int id;
	protected int currentScore;
	protected int highScore;
	protected int oneStarScore;
	protected int twoStarScore;
	protected int threeStarScore;
	protected int movesLeft;
	protected int bonusFrequency;
	
	protected Timer time;
	protected int minutes;
	protected int seconds;
	
	protected boolean isLocked;
	protected boolean[] tileRange;
	protected boolean[] allowedSpecialMoves;
	
	public Level(Board board, int id) {
		this.board = board;
		this.id = id;
		this.resetBoardMoves = 0;
		this.swapTwoTilesMoves = 0;
		this.removeTileMoves = 0;
		this.currentScore = 0;
		this.highScore = 0;
		this.oneStarScore = 0;
		this.twoStarScore = 0;
		this.threeStarScore = 0;
		this.movesLeft = 10;
		this.bonusFrequency = 1;
		this.isLocked = false;
		this.tileRange = new boolean[5];
		for (int i = 0; i < 5; i++) {
			tileRange[i] = true;
		}
		this.allowedSpecialMoves = new boolean[3];
		for (int i = 0; i < 3; i++) {
			allowedSpecialMoves[i] = true;
		}
	}

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
	public Level(Board board, int resetBoardMoves, int swapTwoTilesMoves,
			int removeTileMoves, int id, int currentScore, int highScore,
			int oneStarScore, int twoStarScore, int threeStarScore,
			int movesLeft, int bonusFrequency, Timer time, int minutes,
			int seconds, boolean isLocked, boolean[] tileRange,
			boolean[] allowedSpecialMoves) {
		super();
		this.board = board;
		this.resetBoardMoves = resetBoardMoves;
		this.swapTwoTilesMoves = swapTwoTilesMoves;
		this.removeTileMoves = removeTileMoves;
		this.id = id;
		this.currentScore = currentScore;
		this.highScore = highScore;
		this.oneStarScore = oneStarScore;
		this.twoStarScore = twoStarScore;
		this.threeStarScore = threeStarScore;
		this.movesLeft = movesLeft;
		this.bonusFrequency = bonusFrequency;
		this.time = time;
		this.minutes = minutes;
		this.seconds = seconds;
		this.isLocked = isLocked;
		this.tileRange = tileRange;
		this.allowedSpecialMoves = allowedSpecialMoves;
	}

	public void initialize() {
		this.board = new Board(board.dimension);
		
		for (int i = 0; i < board.getDimension()*board.getDimension(); i++) {
			Tile tile = board.getGrid().get(i).getTile();
			
			ArrayList<Integer> values = new ArrayList<Integer>();
			for (int j = 0; j < 5; j++) 
				if (getTileRange()[j]) {
					values.add(j + 1);
				}
			values.add(6);
			
			Random rand = new Random();
		    int value = rand.nextInt(values.size());
		    
		    Random rand2 = new Random();
					
			board.getGrid().get(i).setTile(new Tile(values.get(value), rand2.nextInt(3),
					tile.getRow(), tile.getColumn(), tile.isSelected));
			
		}
		
	}
	
	public void hasWon() {
		
	}
	
	//Getters and Setters
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}
	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	/**
	 * @return the highScore
	 */
	public int getHighScore() {
		return highScore;
	}
	/**
	 * @param highScore the highScore to set
	 */
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	/**
	 * @return the oneStarScore
	 */
	public int getOneStarScore() {
		return oneStarScore;
	}
	/**
	 * @param oneStarScore the oneStarScore to set
	 */
	public void setOneStarScore(int oneStarScore) {
		this.oneStarScore = oneStarScore;
	}
	/**
	 * @return the twoStarScore
	 */
	public int getTwoStarScore() {
		return twoStarScore;
	}
	/**
	 * @param twoStarScore the twoStarScore to set
	 */
	public void setTwoStarScore(int twoStarScore) {
		this.twoStarScore = twoStarScore;
	}
	/**
	 * @return the threeStarScore
	 */
	public int getThreeStarScore() {
		return threeStarScore;
	}
	/**
	 * @param threeStarScore the threeStarScore to set
	 */
	public void setThreeStarScore(int threeStarScore) {
		this.threeStarScore = threeStarScore;
	}
	/**
	 * @return the movesLeft
	 */
	public int getMovesLeft() {
		return movesLeft;
	}
	/**
	 * @param movesLeft the movesLeft to set
	 */
	public void setMovesLeft(int movesLeft) {
		this.movesLeft = movesLeft;
	}
	/**
	 * @return the bonusFrequency
	 */
	public int getBonusFrequency() {
		return bonusFrequency;
	}
	/**
	 * @param bonusFrequency the bonusFrequency to set
	 */
	public void setBonusFrequency(int bonusFrequency) {
		this.bonusFrequency = bonusFrequency;
	}
	/**
	 * @return the time
	 */
	public Timer getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Timer time) {
		this.time = time;
	}
	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	/**
	 * @param isLocked the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	/**
	 * @return the tileRange
	 */
	public boolean[] getTileRange() {
		return tileRange;
	}
	
	/**
	 * @param tileRange the tileRange to set
	 */
	public void setTileRange(boolean[] tileRange) {
		this.tileRange = tileRange;
	}

	/**
	 * @return the resetBoardMoves
	 */
	public int getResetBoardMoves() {
		return resetBoardMoves;
	}



	/**
	 * @param resetBoardMoves the resetBoardMoves to set
	 */
	public void setResetBoardMoves(int resetBoardMoves) {
		this.resetBoardMoves = resetBoardMoves;
	}



	/**
	 * @return the swapTwoTilesMoves
	 */
	public int getSwapTwoTilesMoves() {
		return swapTwoTilesMoves;
	}



	/**
	 * @param swapTwoTilesMoves the swapTwoTilesMoves to set
	 */
	public void setSwapTwoTilesMoves(int swapTwoTilesMoves) {
		this.swapTwoTilesMoves = swapTwoTilesMoves;
	}



	/**
	 * @return the removeTileMoves
	 */
	public int getRemoveTileMoves() {
		return removeTileMoves;
	}

	/**
	 * @param removeTileMoves the removeTileMoves to set
	 */
	public void setRemoveTileMoves(int removeTileMoves) {
		this.removeTileMoves = removeTileMoves;
	}
	
	/**
	 * @return the allowedSpecialMoves
	 */
	public boolean[] getAllowedSpecialMoves() {
		return allowedSpecialMoves;
	}

	/**
	 * @param allowedSpecialMoves the allowedSpecialMoves to set
	 */
	public void setAllowedSpecialMoves(boolean[] allowedSpecialMoves) {
		this.allowedSpecialMoves = allowedSpecialMoves;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
