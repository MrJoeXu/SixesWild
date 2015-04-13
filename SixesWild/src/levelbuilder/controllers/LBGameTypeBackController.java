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
 * @author Halsey
 *
 */
public class LBGameTypeBackController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;

	/**
	 * 
	 */
	public LBGameTypeBackController(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.getFrame().setContentPane(application.getMainMenuView());
		application.getFrame().setTitle("Level Builder Main Menu");
		application.getFrame().pack();
	}

}
