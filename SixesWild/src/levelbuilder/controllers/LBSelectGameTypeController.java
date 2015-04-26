/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import src.levelbuilder.view.LBLevelSelectorView;
import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

/**
 * @author Halsey Vandenberg
 * 
 */
public class LBSelectGameTypeController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected int gameType;

	/**
	 * 
	 */
	public LBSelectGameTypeController(LevelBuilderWindow application, World world, int gameType) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.setGameType(gameType);
		/*Level newCustomLevel = new Level(new Board(9), 0);
		newCustomLevel.initialize();
		try {
			application.setLbLevelView(new LBLevelView(application, world, newCustomLevel));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		try {
			application.setLbLevelSelectorView(new LBLevelSelectorView(application, world));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		application.getFrame().setContentPane(application.getLbLevelSelectorView());
		application.setGameType(gameType);
		application.getLbLevelSelectorView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
		application.getFrame().repaint();
	}

}