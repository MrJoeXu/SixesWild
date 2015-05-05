/**
 * 
 */
package src.sixeswildgame.world;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
	protected String name;
	protected int gameType;

	protected int minutes;
	protected int seconds;

	protected boolean isLocked;
	protected boolean[] tileRange;
	protected boolean[] allowedSpecialMoves;

	protected Move move;
	protected SwapTwoTilesMove sttMove;
	protected RemoveTileMove rtMove;
	protected boolean isMakingMove;

	protected File file;

	/**
	 * Creates new Level with specified board, id, and gameType
	 * 
	 * @param board
	 * @param id
	 * @param gameType
	 */
	public Level(Board board, int id, String gameType) {
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
		this.bonusFrequency = 3;
		this.minutes = 0;
		this.seconds = 0;
		this.isLocked = false;
		this.tileRange = new boolean[5];
		for (int i = 0; i < 5; i++) {
			tileRange[i] = true;
		}
		this.allowedSpecialMoves = new boolean[3];
		for (int i = 0; i < 3; i++) {
			allowedSpecialMoves[i] = true;
		}
		this.name = "Level " + id;
		this.file = new File("saveddata/custom/" + gameType + "/" + id + ".txt");
	}

	/**
	 * Creates new Level with specified file
	 * 
	 * @param file
	 */
	public Level(File file) {
		this.file = file;
		this.tileRange = new boolean[5];
		for (int i = 0; i < 5; i++) {
			tileRange[i] = true;
		}
		this.allowedSpecialMoves = new boolean[3];
		for (int i = 0; i < 3; i++) {
			allowedSpecialMoves[i] = true;
		}

		// stores input stream
		InputStream is;

		try {

			// sets input stream as given file
			is = new FileInputStream(file);

			Scanner scan = new Scanner(is);
			String[] array;

			String line = scan.nextLine();

			if (line.contains(",")) {

				array = line.split(",");

			} else
				array = line.split("\t");

			Object[] data = new Object[array.length];

			for (int i = 0; i < array.length; i++)
				data[i] = array[i];

			this.resetBoardMoves = Integer.parseInt((String) data[0]);
			this.swapTwoTilesMoves = Integer.parseInt((String) data[1]);
			this.removeTileMoves = Integer.parseInt((String) data[2]);
			this.id = Integer.parseInt((String) data[3]);
			this.currentScore = Integer.parseInt((String) data[4]);
			this.highScore = Integer.parseInt((String) data[5]);
			this.oneStarScore = Integer.parseInt((String) data[6]);
			this.twoStarScore = Integer.parseInt((String) data[7]);
			this.threeStarScore = Integer.parseInt((String) data[8]);
			this.movesLeft = Integer.parseInt((String) data[9]);
			this.bonusFrequency = Integer.parseInt((String) data[10]);
			this.name = (String) data[11];
			this.minutes = Integer.parseInt((String) data[12]);
			this.seconds = Integer.parseInt((String) data[13]);
			this.isLocked = Boolean.parseBoolean((String) data[14]);

			// tileRange
			for (int i = 0; i < 5; i++) {
				this.tileRange[i] = Boolean.parseBoolean((String) data[15 + i]);
			}

			// allowedSpecialMoves
			for (int i = 0; i < 3; i++) {
				this.allowedSpecialMoves[i] = Boolean
						.parseBoolean((String) data[20 + i]);
			}

			int dimension = Integer.parseInt((String) data[23]);
			System.out.println("Dimension: " + dimension);
			System.out.println((String) data[29]);
			this.board = new Board(dimension);

			for (int i = 0; i < dimension * dimension; i++) {
				Space space = new Space(new Tile(
						Integer.parseInt((String) data[24 + i * 8]),
						Integer.parseInt((String) data[25 + i * 8]),
						Integer.parseInt((String) data[26 + i * 8]),
						Integer.parseInt((String) data[27 + i * 8]),
						Integer.parseInt((String) data[28 + i * 8]),
						Integer.parseInt((String) data[29 + i * 8]),
						Boolean.parseBoolean((String) data[30 + i * 8])),
						Boolean.parseBoolean((String) data[31 + i * 8]));
				board.getGrid().set(i, space);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		for (int i = 0; i < this.board.getGrid().size(); i++) {
			if (this.board.getGrid().get(i).getTile().getValue() == 6)
				this.board.getGrid().get(i).setEnabled(true);
			if (!this.board.getGrid().get(i).isEnabled()){
				this.board.getGrid().get(i).setIsMarked(true);
			}
		}
	}

	/**
	 * Initializes level given the game type
	 * 
	 * @param gameType
	 */
	public void initialize(int gameType) {
		this.board = new Board(board.dimension);

		for (int i = 0; i < board.getDimension() * board.getDimension(); i++) {
			Tile tile = board.getGrid().get(i).getTile();

			ArrayList<Integer> values = new ArrayList<Integer>();
			for (int j = 0; j < 5; j++)
				if (getTileRange()[j]) {
					values.add(j + 1);
				}
			if (gameType != 3)
				values.add(6);

			Random rand = new Random();
			int value = rand.nextInt(values.size());

			Random rand2 = new Random();

			int frequency = rand2.nextInt(bonusFrequency) + 1;

			if (values.get(value) == 6)
				frequency = 0;

			board.getGrid()
					.get(i)
					.setTile(
							new Tile(values.get(value), frequency, tile
									.getRow(), tile.getColumn(),
									tile.isSelected));

		}
	}

	/**
	 * Returns true depending on Game Type winning specifications
	 * 
	 */
	public boolean hasWon(int gameType) {
		switch (gameType) {
		case 1:
			if (this.getCurrentScore() > this.getOneStarScore()) {
				isLocked = false;
				return true;
			} else
				return false;
		case 2:
			if (minutes == 0 && seconds == 0) {
				if (currentScore > oneStarScore) {
					isLocked = false;
					return true;
				}
			} else
				return false;
			break;
		case 3:
			for (int i = 0; i < board.getGrid().size(); i++)
				if (board.getGrid().get(i).getTile().getValue()==6) return false;
			return true;
		case 4:
			boolean win = true;
			for (int i = 0; i < board.getGrid().size(); i++) {
				Space sp = board.getGrid().get(i);
				win = sp.isMarked();
			}
			return win;
		default:
			return false;
		}
		return false;
	}

	/**
	 * Saves level with specified game type
	 * 
	 * @param gameType
	 */
	public void save(String gameType) {
		String levelString = toString();

		try {
			file = new File("saveddata/custom/" + gameType + "/" + id + ".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(levelString);
			bw.close();

			System.out.println(levelString);
			System.out.println("Saved.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Decrements the time
	 */
	public void decrementTime() {
		if (seconds == 0) {
			minutes--;
			seconds = 59;
		} else
			seconds--;
	}

	/**
	 * Increments the time
	 */
	public void incrementTime() {
		if (seconds == 59) {
			minutes++;
			seconds = 0;
		} else
			seconds++;
	}

	/**
	 * Converts level variables to string
	 */
	public String toString() {
		String levelString = "";

		// Special Moves
		levelString += resetBoardMoves + "," + swapTwoTilesMoves + ","
				+ removeTileMoves + ",";

		// More
		levelString += id + "," + currentScore + "," + highScore + ","
				+ oneStarScore + "," + twoStarScore + "," + threeStarScore
				+ "," + movesLeft + "," + bonusFrequency + "," + name + ",";

		// Time
		levelString += minutes + "," + seconds + ",";

		// locked
		levelString += isLocked + ",";

		// tileRange
		for (int i = 0; i < 5; i++) {
			levelString += tileRange[i] + ",";
		}

		// allowedSpecialMoves
		for (int i = 0; i < 3; i++) {
			levelString += allowedSpecialMoves[i] + ",";
		}

		levelString += board.getDimension() + ",";

		for (Space sp : board.getGrid())
			levelString += sp.toString();

		return levelString;
	}

	// Getters and Setters
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
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
	 * Sets this
	 * 
	 * @param id
	 *            the id to set
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
	 * @param currentScore
	 *            the currentScore to set
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
	 * @param highScore
	 *            the highScore to set
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
	 * @param oneStarScore
	 *            the oneStarScore to set
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
	 * @param twoStarScore
	 *            the twoStarScore to set
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
	 * @param threeStarScore
	 *            the threeStarScore to set
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
	 * @param movesLeft
	 *            the movesLeft to set
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
	 * @param bonusFrequency
	 *            the bonusFrequency to set
	 */
	public void setBonusFrequency(int bonusFrequency) {
		this.bonusFrequency = bonusFrequency;
	}

	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}

	/**
	 * @param isLocked
	 *            the isLocked to set
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
	 * @param tileRange
	 *            the tileRange to set
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
	 * @param resetBoardMoves
	 *            the resetBoardMoves to set
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
	 * @param swapTwoTilesMoves
	 *            the swapTwoTilesMoves to set
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
	 * @param removeTileMoves
	 *            the removeTileMoves to set
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
	 * @param allowedSpecialMoves
	 *            the allowedSpecialMoves to set
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
	 * @param minutes
	 *            the minutes to set
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
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the move
	 */
	public Move getMove() {
		return move;
	}

	/**
	 * @param move
	 *            the move to set
	 */
	public void setMove(Move move) {
		this.move = move;
		this.isMakingMove = true;
	}

	/**
	 * @return the isMakingMove
	 */
	public boolean isMakingMove() {
		return isMakingMove;
	}

	/**
	 * @param isMakingMove
	 *            the isMakingMove to set
	 */
	public void setMakingMove(boolean isMakingMove) {
		this.isMakingMove = isMakingMove;
	}

	/**
	 * @return the gameType
	 */
	public int getGameType() {
		return gameType;
	}

	/**
	 * @param gameType
	 *            the gameType to set
	 */
	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	public void decrementMoves() {

		this.movesLeft--;
	}

	/**
	 * @return the sttMove
	 */
	public SwapTwoTilesMove getSttMove() {
		return sttMove;
	}

	/**
	 * @param sttMove
	 *            the sttMove to set
	 */
	public void setSttMove(SwapTwoTilesMove sttMove) {
		this.sttMove = sttMove;
	}

	/**
	 * @return the rtMove
	 */
	public RemoveTileMove getRtMove() {
		return rtMove;
	}

	/**
	 * @param rtMove
	 *            the rtMove to set
	 */
	public void setRtMove(RemoveTileMove rtMove) {
		this.rtMove = rtMove;
	}

}
