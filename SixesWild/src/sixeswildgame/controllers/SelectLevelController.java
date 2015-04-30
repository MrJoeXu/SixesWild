package src.sixeswildgame.controllers;

import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import src.sixeswildgame.view.LevelView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class SelectLevelController implements ActionListener{
	protected World world;
	protected SixesWildWindow application;
	protected Level level;
	

	/**
	 * 
	 */
	public SelectLevelController (SixesWildWindow application, World world, Level level) {
		this.application = application;
		this.world = world;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			application.setLevelView(new LevelView(application, world, level));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		application.getLevelView().setPreferredSize(new Dimension(1000,708));
		application.getFrmSixesWild().setContentPane(application.getLevelView());
		application.getLevelView().setVisible(true);
		application.getFrmSixesWild().setTitle(level.getName());
		application.getFrmSixesWild().pack();
		application.getFrmSixesWild().repaint();
	}
	
	

}