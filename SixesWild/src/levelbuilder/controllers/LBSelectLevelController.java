/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import src.levelbuilder.view.LBLevelSelectorView;
import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 * 
 */
public class LBSelectLevelController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected Level level;

	/**
	 * 
	 */
	public LBSelectLevelController(LevelBuilderWindow application, World world, Level level) {
		this.application = application;
		this.world = world;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int nextId = new File("saveddata/custom/" + application.getGameTypeName()).listFiles().length;
		File file = new File("saveddata/custom/" + application.getGameTypeName() + "/" + nextId + ".txt");
				
		if (level == null) {
			level = new Level(new Board(9), nextId, application.getGameTypeName());
			level.initialize(application.getGameType());
		}
		
		try {
			application.setLbLevelView(new LBLevelView(application, world, level));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}	
		try {
			application.setLbLevelSelectorView(new LBLevelSelectorView(application, world));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		application.getFrame().setContentPane(application.getLbLevelView());
		application.getLbLevelView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
		application.getFrame().repaint();
	}

}
