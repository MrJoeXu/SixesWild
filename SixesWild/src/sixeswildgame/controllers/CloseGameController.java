/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class CloseGameController implements ActionListener {

	World world;
	SixesWildWindow application;

	/**
	 * Creates new CloseGameController with specified world and application
	 * 
	 * @param world
	 * @param application
	 */
	public CloseGameController(World world, SixesWildWindow application) {
		this.world = world;
		this.application = application;
	}
	
	/**
	 * Exits SixesWildWindow
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}