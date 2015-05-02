/**
 * 
 */
package src.sixeswildgame.world;

import java.util.ArrayList;

/**
 * @author Halsey
 *
 */
public class SwapTwoTilesMove extends Move {

	public SwapTwoTilesMove(Tile tl) {
		super(tl);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isValid(){
		return true;
	}
	
	@Override
	public void addTile(Tile tl) {
		this.tiles.add(tl);
	}
	
	@Override
	public Tile removeLast() {
		return tiles.remove(tiles.size()-1);
	}
	
	@Override
	public boolean doMove (Level lv) {
		return true;
	}

}