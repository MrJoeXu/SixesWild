/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import src.levelbuilder.view.LBLevelView;
import src.sixeswildgame.view.GameTypeView;
import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class SelectGameTypeController implements ActionListener {
	
	protected World world;
	protected SixesWildWindow application;
	protected int gameType;

	/**
	 * 
	 */
	public SelectGameTypeController(SixesWildWindow application, World world, int gameType) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.setGameType(gameType);
		application.setLevelSelectorView(new LevelSelectorView(application, world));
		application.getLevelSelectorView().setPreferredSize(new Dimension(1440,1020));
		application.getFrmSixesWild().setContentPane(application.getLevelSelectorView());
		application.getLevelSelectorView().setVisible(true);
		application.getFrmSixesWild().setTitle("Level Select");
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}
	
	

}
