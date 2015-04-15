/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

/**
 * @author Halsey Vandenberg
 *
 */
public class SelectLBGameTypeController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected int gameType;

	/**
	 * 
	 */
	public SelectLBGameTypeController(LevelBuilderWindow application, World world, int gameType) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.setGameType(gameType);
		Level newCustomLevel = new Level(new Board(9), 0);
		newCustomLevel.initialize();
		application.setLbLevelView(new LBLevelView(application, world, newCustomLevel));
		application.getFrame().setContentPane(application.getLbLevelView());
		application.getLbLevelView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
	}

}
