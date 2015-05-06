/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import src.levelbuilder.view.LBLevelSelectorView;
import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class BackHomeController implements ActionListener {

	protected Level level;
	protected SixesWildWindow application;

	/**
	 * Creates new LevelBackController with specified world, application, and
	 * level
	 * 
	 * @param world
	 * @param application
	 * @param level
	 */
	public BackHomeController(SixesWildWindow application,
			Level level) {
		this.application = application;
		this.level = level;
	}

	/**
	 * Returns back to selecting levels
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		application.getFrmSixesWild().setContentPane(
				application.getGameTypeView());
		application.getGameTypeView().setVisible(true);
		application.getFrmSixesWild().setTitle("Select Type");
		application.getFrmSixesWild().pack();
	}

}
