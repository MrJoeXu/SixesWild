/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LBLevelSelectorView;
import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.LevelSelectorView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Tile;
import src.sixeswildgame.world.World;

/**
 * @author Halsey Vandenberg
 * 
 */
public class LBSelectGameTypeController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected int gameType;

	/**
	 * 
	 */
	public LBSelectGameTypeController(LevelBuilderWindow application, World world, int gameType) {
		this.application = application;
		this.world = world;
		this.gameType = gameType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (application.isSoundEnabled()) {
			try {
			    File f = new File("resources/open.wav");
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
		
		application.setGameType(gameType);
		
		System.out.println("GT: " + gameType);
		
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
		application.getFrame().repaint();
	}

}
