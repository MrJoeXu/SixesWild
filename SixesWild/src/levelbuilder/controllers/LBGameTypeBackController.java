/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.World;

/**
 * @author Halsey
 *
 */
public class LBGameTypeBackController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;

	/**
	 * 
	 */
	public LBGameTypeBackController(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
	}

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
			}
			catch (Exception e1) {
			    
			}
		}
		
		application.getToggleSoundCheckBox().setSelected(application.isSoundEnabled());
		
		application.getFrame().setContentPane(application.getMainMenuView());
		application.getFrame().setTitle("Level Builder Main Menu");
		application.getFrame().pack();
	}

}
