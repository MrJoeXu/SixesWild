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

/**
 * @author Halsey
 *
 */
public class ToggleSoundController implements ActionListener {
	
	protected LevelBuilderWindow application;

	/**
	 * @param application
	 */
	public ToggleSoundController(LevelBuilderWindow application) {
		super();
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.toggleSound();
		
		if (application.isSoundEnabled()) {
			try {
			    File f = new File("resources/4.wav");
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
	}

}
