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

	/**
	 * 
	 */
	public LBSelectLevelController(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Level newCustomLevel = new Level(new Board(9), 0);
		newCustomLevel.initialize();
		
		try {
			application.setLbLevelView(new LBLevelView(application, world, newCustomLevel));
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
