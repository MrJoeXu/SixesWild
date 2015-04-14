/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.view.LevelView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class SelectLevelController implements ActionListener{
	protected World world;
	protected SixesWildWindow application;
	protected int gameType;
	protected int gameLevel;
	

	/**
	 * 
	 */
	public SelectLevelController (SixesWildWindow application, World world, int gameType, int gameLevel) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
		this.gameLevel = gameLevel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.setGameType(gameType);
		application.setGameLevel(gameLevel);
		//application.setLevelView(new LevelView(application, world));
		application.getLevelView().setPreferredSize(new Dimension(1440,1020));
		application.getFrmSixesWild().setContentPane(application.getLevelView());
		application.getLevelView().setVisible(true);
		application.getFrmSixesWild().setTitle("Level Select");
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}
	
	

}
