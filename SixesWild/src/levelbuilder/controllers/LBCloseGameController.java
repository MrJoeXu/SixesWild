/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class LBCloseGameController implements ActionListener {

	World world;
	LevelBuilderWindow application;

	/**
	 * Creates a new LBCloseGameController with specified world, application
	 * 
	 * @param world
	 * @param application
	 */
	public LBCloseGameController(World world, LevelBuilderWindow application) {
		this.world = world;
		this.application = application;
	}

	/**
	 * Closes the Level Builder Game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}