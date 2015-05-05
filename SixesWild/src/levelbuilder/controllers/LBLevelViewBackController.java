package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LBLevelSelectorView;
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
	 * Creates a LBLevelViewBackController with specified application and world
	 * 
	 * @param application
	 * @param world
	 */
	public LBLevelViewBackController(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
	}

	/**
	 * Returns back to Level Builder's LevelSelectorView to be able to reselect
	 * a level to edit
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (application.isSoundEnabled()) {
			try {
				File f = new File("resources/1.wav");
				AudioInputStream stream;
				AudioFormat format;
				DataLine.Info info;
				Clip clip;

				stream = AudioSystem.getAudioInputStream(f);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			} catch (Exception e1) {

			}
		}

		try {
			application.setLbLevelSelectorView(new LBLevelSelectorView(
					application, world));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		application.getFrame().setContentPane(
				application.getLbLevelSelectorView());
		application.getLbLevelSelectorView().setVisible(true);
		application.getFrame().setTitle("Level Builder");
		application.getFrame().pack();
	}

}