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
import javax.swing.JCheckBox;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * @author tleung
 * @author Halsey Vandenberg
 *
 */
public class UpdateTileRangeController implements ActionListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JCheckBox checkBox;
	
	/**
	 * 
	 */
	public UpdateTileRangeController(LevelBuilderWindow application, Level level, JCheckBox checkBox) {
		this.application = application;
		this.level = level;
		this.checkBox = checkBox;

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (application.isSoundEnabled()) {
			try {
			    File f = new File("resources/2.wav");
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
		
		level.getTileRange()[application.getLbLevelView().getTileRangeCheckBoxes().indexOf(checkBox)] = checkBox.isSelected();
		level.setBoard(new Board(level.getBoard().getDimension()));
		level.initialize(application.getGameType());
		BoardView newBoardView = new BoardView(level.getBoard(), 33, 33);
		
		application.getLbLevelView().setBoardView(newBoardView);
		application.getLbLevelView().getBoardPanel().removeAll();
		application.getLbLevelView().getBoardPanel().add(newBoardView);
		
		for (SpaceView sv : application.getLbLevelView().getBoardView().getGrid() ) {
			TileView tv = sv.getTileView();
			tv.addMouseListener(new TileController(tv, level, application));
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	
	}

}
