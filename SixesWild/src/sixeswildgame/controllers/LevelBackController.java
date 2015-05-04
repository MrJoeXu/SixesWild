/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import src.levelbuilder.view.LBLevelSelectorView;
import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class LevelBackController implements ActionListener{

	protected World world;
	protected Level level;
	protected SixesWildWindow application;
	
	public LevelBackController(World world, SixesWildWindow application, Level level) {
		this.world = world;
		this.application = application;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int index = world.getLevels(application.getGameType()).indexOf(level);
		world.getLevels(application.getGameType()).set(index, new Level(level.getFile()));
	
		try {
			application.setLevelSelectorView(new LevelSelectorView(
					application, world));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		application.getFrmSixesWild().setContentPane(
				application.getLevelSelectorView());
		application.getLevelSelectorView().setVisible(true);
		application.getFrmSixesWild().setTitle("Select Level");
		application.getFrmSixesWild().pack();
	}

}

