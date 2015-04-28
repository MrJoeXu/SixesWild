package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import src.levelbuilder.view.LBLevelSelectorView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.PuzzleLevel;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class LBLevelViewBackController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;

	/**
	 * 
	 */
	public LBLevelViewBackController(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			application.setLbLevelSelectorView(new LBLevelSelectorView(application, world));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		application.getFrame().setContentPane(application.getLbLevelSelectorView());
		application.getLbLevelSelectorView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
	}

}