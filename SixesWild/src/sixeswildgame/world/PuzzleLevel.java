/**
 * 
 */
package src.sixeswildgame.world;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Timer;

/**
 * @author Halsey
 *
 */
public class PuzzleLevel extends Level {
	
		/**
	 * @param board
	 * @param id
	 */
	public PuzzleLevel(Board board, int id, String gameType) {
		super(board, id, gameType);
	}

	/**
	 * @param file
	 */
	public PuzzleLevel(File file) {
		super(file);
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
            is = new FileInputStream( file );

            Scanner scan = new Scanner(is);
            String[] array;

            String line = scan.nextLine();

            if (line.contains(",")) {

                array = line.split(",");

            } else array = line.split("\t");

            Object[] data = new Object[array.length];

            for (int i = 0; i < array.length; i++) data[i] = array[i];

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

    		//tileRange
    		for (int i = 0; i < 5; i++) {
    			this.tileRange[i] = Boolean.parseBoolean((String) data[15+i]);
    		}
    		
    		//allowedSpecialMoves
    		for (int i = 0; i < 3; i++) {
    			this.allowedSpecialMoves[i] = Boolean.parseBoolean((String) data[20+i]);
    		}
    		
    		int dimension = Integer.parseInt((String) data[23]);
    		System.out.println("Dimension: " + dimension);
    		System.out.println((String) data[29]);
    		this.board = new Board(dimension);

    		for (int i = 0; i < dimension * dimension; i++) {
				Space space = new Space(new Tile(Integer.parseInt((String) data[24+i*8]), Integer.parseInt((String) data[25+i*8]),
						Integer.parseInt((String) data[26+i*8]), 
						Integer.parseInt((String) data[27+i*8]),
						Integer.parseInt((String) data[28+i*8]), 
						Integer.parseInt((String) data[29+i*8]),
						Boolean.parseBoolean((String) data[30+i*8])), Boolean.parseBoolean((String) data[31+i*8]));
				board.getGrid().add(space);
    		}
          
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
		
	}

	public boolean hasWon() {
		if (this.getCurrentScore() > this.getOneStarScore())
			return true;
		else return false;
	}
}
