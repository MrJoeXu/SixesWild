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
public class LevelSelectorBackController implements ActionListener {

	World world;
	SixesWildWindow application;

	/**
	 * Creates LevelSelectorBackController with specified world and application
	 * 
	 * @param world
	 * @param application
	 */
	public LevelSelectorBackController(World world, SixesWildWindow application) {
		this.world = world;
		this.application = application;
	}

	/**
	 * Returns back to setting game types
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		application.getFrmSixesWild().setContentPane(
				application.getGameTypeView());
		application.getFrmSixesWild().setTitle("Game Type");
	}

}
