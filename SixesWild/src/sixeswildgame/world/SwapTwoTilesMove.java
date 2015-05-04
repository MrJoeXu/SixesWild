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
	
	public SwapTwoTilesMove(Tile tl, Level lv) {
		super(tl, lv);
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
		Tile tile1 = lv.getSttMove().getTiles().get(0);
		Tile tile2 = lv.getSttMove().getTiles().get(1);
		
		lv.getBoard().getGrid().get(tile1.getRow() * lv.getBoard().getDimension() + tile1.getColumn()).setTile(tile2);
		lv.getBoard().getGrid().get(tile2.getRow() * lv.getBoard().getDimension() + tile2.getColumn()).setTile(tile1);
		
		lv.decrementMoves();
		return true;
	}

}
