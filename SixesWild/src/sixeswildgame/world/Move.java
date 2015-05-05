/**
 * Move class accounts for making moves
 */
package src.sixeswildgame.world;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author Matthew
 *
 */
public class Move {
	protected ArrayList<Tile> tiles;
	protected Level level;
	int gameType;

	public Move(Tile tl, Level lv, int game) {
		this.tiles = new ArrayList<Tile>();
		tiles.add(tl);
		this.level = lv;
		this.gameType = game;
	}

	/**
	 * Returns true if move adds to 6
	 * 
	 * @return
	 */
	public boolean isValid() {
		int sum = 0;
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).getValue() == 6)
				return false;
			sum = sum + tiles.get(i).getValue();
		}
		return (sum == 6);
	}

	/**
	 * Adds give Tile
	 * 
	 * @param tl
	 */
	public void addTile(Tile tl) {
		this.tiles.add(tl);
	}

	/**
	 * Removes and returns the last Tile
	 * 
	 * @return
	 */
	public Tile removeLast() {
		return tiles.remove(tiles.size() - 1);
	}

	/**
	 * Does the move and returns true if the move was valid
	 * 
	 * @param lv
	 * @return
	 */
	public boolean doMove(Level lv) {
		lv.decrementMoves();
		if (!this.isValid()) {
			return false;
		}

		else {
			ArrayList<Tile> newTiles;
			newTiles = new ArrayList<Tile>();
			int mult = 10 * tiles.size();
			for (int i = 0; i < tiles.size(); i++) {
				newTiles.add(makeTile(lv, tiles.get(i).getColumn()));
				mult = mult * tiles.get(i).getBonus();
				lv.getBoard().getSpace(this.tiles.get(i).getRow(), this.tiles.get(i).getColumn()).setIsMarked(true);
			}

			fallDown(lv, newTiles);
			lv.setCurrentScore(lv.getCurrentScore() + mult);
			return true;
		}
	}

	/**
	 * Allows the tiles to fall down per gravity and adds new Tiles to replace
	 * Tiles that have fallen down
	 * 
	 * @param lv
	 * @param nwTiles
	 */
	public void fallDown(Level lv, ArrayList<Tile> nwTiles) {
		boolean flag = true;
		for (int v = 0; v < tiles.size(); v++)
		while (flag) {
			flag = false;
			for (int j = 0; j < this.tiles.size() - 1; j++) {
				if (tiles.get(j).getRow() > this.tiles.get(j+1).getRow()) {
					Tile temp = tiles.get(j);
					tiles.set(j, tiles.get(j+1));
					tiles.set(j+1, temp);
					flag = true;
				}
			}
		}		

		for (int i = 0; i < this.tiles.size(); i++) {
			for (int j = this.tiles.get(i).getRow(); j >= 0; j--) {
				if(!(level.getBoard().getSpace((j), this.tiles.get(i).getColumn()).isEnabled())) {	
					continue;
				}
				
				if (j == 0) {
					lv.getBoard().setTile(j, this.tiles.get(i).getColumn(), nwTiles.get(i));
					continue;
				}
					
				int m = 1;
				while (!(level.getBoard().getSpace((j-m),
						this.tiles.get(i).getColumn()).isEnabled())) {
						if ((j-m) == 0)
							break;
						m++;
				}
				
				if (gameType == 5)
					System.out.println("My m is " + m + " and j is" + j);
				
				if (j-m == 0) {
					if ((level.getBoard().getSpace(0,
						this.tiles.get(i).getColumn()).isEnabled())) {
						lv.getBoard().setTile(j, this.tiles.get(i).getColumn(),
								level.getBoard()
								.getSpace((j - m),
										this.tiles.get(i).getColumn())
								.getTile());
						
						lv.getBoard().setTile(0, this.tiles.get(i).getColumn(),
								nwTiles.get(i));
					}
					
					else {
						lv.getBoard().setTile(
								j,
								this.tiles.get(i).getColumn(),
								nwTiles.get(i));
					}
				}
				
				else {
					if (gameType == 5)
						System.out.println("in here");
					
					lv.getBoard().setTile(
						j,
						this.tiles.get(i).getColumn(),
						level.getBoard()
								.getSpace((j - m),
										this.tiles.get(i).getColumn())
								.getTile());
				}	
			}
			
			if (this.gameType == 3){
				for (int x = 0; x < (lv.getBoard().getGrid().size() - lv.getBoard().getDimension()); x++){
					if (sixAboveSeven(lv, lv.getBoard().getGrid().get(x).getTile())) {
						releaseSix(lv, lv.getBoard().getGrid().get(x).getTile());
					}
				}
			}
		}
		if (gameType == 5)
			System.out.println("Finished Row: " + tiles.get(0).getRow() + " Column: " + tiles.get(0).getColumn());
	}
	
	/**
	 * Purpose: releases a six from its position
	 * @param lv
	 * @param tl
	 */
	protected void releaseSix (Level lv, Tile tl) {
		System.out.println("SixRelease called with Tile: " + tl.getRow() + ", " + tl.getColumn());
		Move newMove = new Move(tl, lv, 5);
		ArrayList<Tile> tileArray = new ArrayList<Tile>();
		Tile newTl = newMove.makeTile(lv, tl.getColumn());
		tileArray.add(newTl);
		newMove.fallDown(lv, tileArray);
	}
	
	/**
	 * Purpose: return true if the tile is a 6 and the tile below it is a 7
	 * @param lv
	 * @param tl
	 * @return
	 */
	protected boolean sixAboveSeven(Level lv, Tile tl) {
		if (tl.getValue() == 6){
			if (lv.getBoard().getSpace
					((tl.getRow() + 1),
					tl.getColumn()).getTile().getValue()== 7) {
					return true;
				}
		}
		return false;
	}

	/**
	 * Makes a new Tile given level and column
	 * 
	 * @param lv
	 * @param col
	 * @return
	 */
	public Tile makeTile(Level lv, int col) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int j = 0; j < 5; j++) {
			if (lv.getTileRange()[j]) {
				values.add(j + 1);
			}
		}
		if (gameType != 3)
			values.add(6);

		Random rand = new Random();
		int value = rand.nextInt(values.size());

		Random rand2 = new Random();

		int frequency = rand2.nextInt(lv.bonusFrequency) + 1;
		if (values.get(value) == 6)
			frequency = 0;

		Tile tile = new Tile(values.get(value), frequency, 0, col, false);
		return tile;
	}

	/**
	 * Returns true is the Tile is adjacent to most recently added Tile
	 * 
	 * @param add
	 * @return
	 */
	public boolean isAdjacent(Tile add) {
		if (tiles.contains(add))
			return false;

		Tile test = tiles.get(tiles.size() - 1);

		if (test.getColumn() == add.getColumn()) {
			if ((test.getRow() + 1 == add.getRow())
					|| (test.getRow() - 1 == add.getRow()))
				return true;
		}

		else if (test.getRow() == add.getRow()) {
			if ((test.getColumn() + 1 == add.getColumn())
					|| (test.getColumn() - 1 == add.getColumn()))
				return true;
		}
		return false;
	}

	/**
	 * Returns this Tiles
	 * 
	 * @return
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
}
