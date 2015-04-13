/**
 * 
 */
package src.levelbuilder.world;

import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

/**
 * @author Halsey
 *
 */
public class LevelBuilderSpace extends Space {
	
	protected Tile tile;
	protected boolean enabled;
	
	public LevelBuilderSpace(Tile tile) {
		super(tile);

	}

}
