/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class MinimizeGameController implements ActionListener {

	World world;
	SixesWildWindow application;

	/**
	 * Creates MinimizeGameController with specified world and application
	 * 
	 * @param world
	 * @param application
	 */
	public MinimizeGameController(World world, SixesWildWindow application) {
		this.world = world;
		this.application = application;
	}

	/**
	 * Minimizes SixesWildWindow
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getFrmSixesWild().setState(JFrame.ICONIFIED);
	}

}