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
 * @author Joe Xu, havandenberg
 * 
 */
public class LBBuildLevelController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected Level level;
	protected int type;

	/**
	 * 
	 */
	public LBBuildLevelController(LevelBuilderWindow application, World world, Level level, int type) {
		this.application = application;
		this.world = world;
		this.level = level;
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int nextId = new File("saveddata/custom/" + application.getGameTypeName()).listFiles().length;
		File file = new File("saveddata/custom/" + application.getGameTypeName() + "/" + nextId + ".txt");
		
		if (type == 0) {
			Level newLevel = new Level(new Board(9), nextId, application.getGameTypeName());
			newLevel.initialize(application.getGameType());
			application.getLbLevelSelectorView().setSelectedLevel(newLevel);
		}
		if (type == 1) {
			level = application.getLbLevelSelectorView().getSelectedLevel();
		}
		
		if (level == null) {
			application.getLbLevelSelectorView().getPleaseLabel().setVisible(true);
			application.getFrame().pack();
		}
		
		try {
			application.setLbLevelView(new LBLevelView(application, world, application.getLbLevelSelectorView().getSelectedLevel()));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}	
		try {
			application.setLbLevelSelectorView(new LBLevelSelectorView(application, world));
		} catch (FontFormatException | IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Grid Size: " + application.getLbLevelView().getBoardView().getGrid().size());
		
		application.getFrame().setContentPane(application.getLbLevelView());
		application.getLbLevelView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
		application.getFrame().repaint();
	}

}
