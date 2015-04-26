package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SixesWildWindow;
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
		application.getFrame().setContentPane(application.getLbLevelSelectorView());
		application.getFrame().setTitle("Level Builder Main Menu");
		application.getFrame().pack();
	}

}