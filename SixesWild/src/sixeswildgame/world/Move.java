/**
 * 
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

	public Move(Tile tl, Level lv) {
		this.tiles = new ArrayList<Tile>();
		tiles.add(tl);
		this.level = lv;
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
			int mult = 10;
			for (int i = 0; i < tiles.size(); i++) {
				newTiles.add(makeTile(lv, tiles.get(i).getColumn()));
				mult = mult * tiles.get(i).getBonus();
			}

			fallDown(lv, newTiles);
			lv.setCurrentScore(lv.getCurrentScore() + (tiles.size() * mult));
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
	protected void fallDown(Level lv, ArrayList<Tile> nwTiles) {
		System.out.println("First Value: " + this.tiles.get(0).getValue());
		for (int i = 0; i < this.tiles.size(); i++) {
			for (int j = i + 1; j < this.tiles.size() - 1; j++) {
				if (tiles.get(i).getRow() > this.tiles.get(j).getRow()) {
					Tile temp = tiles.get(i);
					tiles.set(j, tiles.get(i));
					tiles.set(i, temp);
				}
			}
		}
		System.out.println("First Value: " + this.tiles.get(0).getValue());

		for (int i = 0; i < this.tiles.size(); i++) {
			lv.getBoard()
					.getSpace(this.tiles.get(i).getRow(),
							this.tiles.get(i).getColumn()).setIsMarked(true);
			for (int j = this.tiles.get(i).getRow(); j >= 0; j--) {
				if (j > 0) {
					while (!(level.getBoard().getSpace((j - 1),
							this.tiles.get(i).getColumn()).isEnabled())) {
						System.out.println("Testing j: " + j);
						j--;
					}
					lv.getBoard().setTile(
							j,
							this.tiles.get(i).getColumn(),
							level.getBoard()
									.getSpace((j - 1),
											this.tiles.get(i).getColumn())
									.getTile());
				}

				else {
					lv.getBoard().setTile(j, this.tiles.get(i).getColumn(),
							nwTiles.get(i));
				}
			}
		}
	}

	/**
	 * Makes a new Tile given level and column
	 * 
	 * @param lv
	 * @param col
	 * @return
	 */
	private Tile makeTile(Level lv, int col) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int j = 0; j < 5; j++) {
			if (lv.getTileRange()[j]) {
				values.add(j + 1);
			}
		}
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
