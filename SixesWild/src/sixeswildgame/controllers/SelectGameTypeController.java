/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.sixeswildgame.view.GameTypeView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Halsey
 *
 */
public class SelectGameTypeController implements ActionListener {
	
	protected World world;
	protected SixesWildWindow application;

	/**
	 * 
	 */
	public SelectGameTypeController(SixesWildWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GameTypeView gameTypeView = new GameTypeView();
		application.setGameTypeView(gameTypeView);
		
	}
	
	

}
