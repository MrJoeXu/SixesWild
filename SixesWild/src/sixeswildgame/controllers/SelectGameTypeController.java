/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * Creates new SelectGameTypeController with specified application, world,
	 * and gameType
	 * 
	 * @param application
	 * @param world
	 * @param gameType
	 */
	public SelectGameTypeController(SixesWildWindow application, World world,
			int gameType) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
	}

	/**
	 * Opens level selecting for specific game type
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.setGameType(gameType);
		try {
			application.setLevelSelectorView(new LevelSelectorView(application,
					world));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		application.getLevelSelectorView().setPreferredSize(
				new Dimension(1000, 708));
		application.getFrmSixesWild().setContentPane(
				application.getLevelSelectorView());
		application.getLevelSelectorView().setVisible(true);
		application.getFrmSixesWild().setTitle("Level Select");
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}

}
