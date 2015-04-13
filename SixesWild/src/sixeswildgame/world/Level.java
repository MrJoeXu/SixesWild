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
public class Level {
	
	protected Board board;
	
	protected ArrayList<SpecialMove> specialMoves;
	
	//ints
	protected int id;
	protected int currentScore;
	protected int highScore;
	protected int oneStarScore;
	protected int twoStarScore;
	protected int threeStarScore;
	protected int movesLeft;
	protected int bonusFrequency;
	
	protected Timer time;
	
	protected boolean isLocked;
	protected boolean[] tileRange;
	
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
	public Level(Board board, ArrayList<SpecialMove> specialMoves, int id,
			int currentScore, int highScore, int oneStarScore,
			int twoStarScore, int threeStarScore, int movesLeft,
			int bonusFrequency, Timer time, boolean isLocked,
			boolean[] tileRange) {
		this.board = board;
		this.specialMoves = specialMoves;
		this.id = id;
		this.currentScore = currentScore;
		this.highScore = highScore;
		this.oneStarScore = oneStarScore;
		this.twoStarScore = twoStarScore;
		this.threeStarScore = threeStarScore;
		this.movesLeft = movesLeft;
		this.bonusFrequency = bonusFrequency;
		this.time = time;
		this.isLocked = isLocked;
		this.tileRange = tileRange;
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
	 * @return the specialMoves
	 */
	public ArrayList<SpecialMove> getSpecialMoves() {
		return specialMoves;
	}
	/**
	 * @param specialMoves the specialMoves to set
	 */
	public void setSpecialMoves(ArrayList<SpecialMove> specialMoves) {
		this.specialMoves = specialMoves;
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

}
