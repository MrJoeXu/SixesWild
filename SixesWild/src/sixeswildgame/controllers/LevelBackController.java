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

public class LevelBackController implements ActionListener{

	World world;
	SixesWildWindow application;
	
	public LevelBackController(World world, SixesWildWindow application) {
		this.world = world;
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		application.getFrmSixesWild().setContentPane(application.getLevelSelectorView());
		application.getFrmSixesWild().setTitle("Select Level");
	}

}

