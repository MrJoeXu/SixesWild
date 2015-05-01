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
	
	public Move(Tile tl) {
		this.tiles = new ArrayList<Tile>();
		tiles.add(tl);
	}
	
	// Move must add to 6 to be valid
	public boolean isValid(){
		int sum = 0;
		for (int i = 0; i < tiles.size(); i++){
			if (tiles.get(i).getValue() == 6)
				return false;
			sum = sum + tiles.get(i).getValue();
		}
		return (sum == 6);		
	}
	
	public void addTile(Tile tl) {
		this.tiles.add(tl);
	}
	
	
	public boolean doMove (Level lv) {
		if (!this.isValid()) {
			lv.decrementMoves();
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
	
	private void fallDown (Level lv, ArrayList<Tile> tiles) {
		// TODO
	}
	
	private Tile makeTile (Level lv, int col) {
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
	    
	    int frequency = rand2.nextInt(lv.bonusFrequency)+1;
	    if (values.get(value) == 6) frequency = 0;
	    
	    Tile tile = new Tile(values.get(value),frequency,0, col, false);
	    return tile;
	}

	public boolean isAdjacent(Tile add) {
		if (tiles.contains(add)) return false;
		Tile test = tiles.get(tiles.size()-1);
		
		if (test.getColumn() == add.getColumn()) {
			if ((test.getRow()+1 == add.getRow()) || (test.getRow()-1 == add.getRow()))
				return true;
		}
		
		else if (test.getRow() == add.getRow()) {
			if ((test.getColumn()+1 == add.getColumn()) || (test.getColumn()-1 == add.getColumn()))
				return true;
		}
		
		return false;
	}
}
