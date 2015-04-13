/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.GameTypeView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class StartController implements ActionListener{ 

	protected SixesWildWindow application;
	protected World world;
	protected int gameType;

	/**
	 * 
	 */
	public StartController(SixesWildWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.setGameTypeView(new GameTypeView(application, world));
		application.getGameTypeView().setPreferredSize(new Dimension(1440,1020));
		application.getFrmSixesWild().setContentPane(application.getGameTypeView());
		application.getGameTypeView().setVisible(true);
		application.getFrmSixesWild().setTitle("Game Type");
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}

}
