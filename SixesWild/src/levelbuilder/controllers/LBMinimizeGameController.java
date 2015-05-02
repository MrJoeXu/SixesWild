/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class LBMinimizeGameController implements ActionListener {

	World world;
	LevelBuilderWindow application;

	/**
	 * Creates a new LBMinimizeGameController with specified world and
	 * application
	 * 
	 * @param world
	 * @param application
	 */
	public LBMinimizeGameController(World world, LevelBuilderWindow application) {
		this.world = world;
		this.application = application;
	}

	/**
	 * Minimizes the Level Builder window
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getFrame().setState(JFrame.ICONIFIED);
	}

}