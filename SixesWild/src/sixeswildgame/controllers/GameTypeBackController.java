/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LBLevelView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class GameTypeBackController implements ActionListener {

	World world;
	SixesWildWindow application;
	
	public GameTypeBackController(World world, SixesWildWindow application) {
		this.world = world;
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		application.getFrmSixesWild().setContentPane(application.getMainMenuView());
		application.getFrmSixesWild().setTitle("Main Screen");
	}
}
