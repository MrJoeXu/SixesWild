/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LBLevelSelectorView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Hvandenberg
 *
 */
public class DeleteLevelController implements ActionListener {
	
	protected World world;
	protected LevelBuilderWindow application;
	protected Level level;

	/**
	 * @param world
	 * @param application
	 * @param level
	 */
	public DeleteLevelController(World world, LevelBuilderWindow application,
			Level level) {
		super();
		this.world = world;
		this.application = application;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (application.isSoundEnabled()) {
			try {
			    File f = new File("resources/close.wav");
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
		
		ArrayList<Level> levels;
		
		switch (application.getGameType()) {
		case 1:
			levels = world.getPuzzleLevels();
			break;
		case 2:
			levels = world.getLightningLevels();
			break;
		case 3:
			levels = world.getReleaseLevels();
			break;
		case 4:
			levels = world.getEliminationLevels();
			break;
			default:
				levels = new ArrayList<Level>();
		}
		
		levels.remove(application.getLbLevelSelectorView().getSelectedLevel());
		
		System.out.println("Num Levels: " + levels.size());
		
		//File f = new File("saveddata/custom/" + application.getLbLevelSelectorView().getSelectedLevel().getGameType() +
				//"/" + application.getLbLevelSelectorView().getSelectedLevel().getId() + ".txt");
		//f.delete();
		
		try{
			 
    		File file = application.getLbLevelSelectorView().getSelectedLevel().getFile();
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e1){
 
    		e1.printStackTrace();
 
    	}
		
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
