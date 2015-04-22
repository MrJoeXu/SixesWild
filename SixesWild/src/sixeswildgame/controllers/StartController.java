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
		try {
			application.setGameTypeView(new GameTypeView(application, world));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		application.getGameTypeView().setPreferredSize(new Dimension(1000,708));
		application.getFrmSixesWild().setContentPane(application.getGameTypeView());
		application.getGameTypeView().setVisible(true);
		application.getFrmSixesWild().setTitle("Game Type");
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}

}
