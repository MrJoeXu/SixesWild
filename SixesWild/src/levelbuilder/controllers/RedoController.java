/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;

/**
 * @author Halsey
 *
 */
public class RedoController implements ActionListener {

	protected ArrayList<Space> toggleSpaceMoves;
	protected LevelBuilderWindow application;
	protected Level level;

	/**
	 * Creates new RedoController with specified toggleSpaceMoves, application,
	 * and level
	 * 
	 * @param toggleSpaceMoves
	 * @param application
	 * @param level
	 */
	public RedoController(ArrayList<Space> toggleSpaceMoves,
			LevelBuilderWindow application, Level level) {
		super();
		this.toggleSpaceMoves = toggleSpaceMoves;
		this.application = application;
		this.level = level;
	}
	
	/**
	 * Redoes the most recently made toggle on the preview board
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (application.isSoundEnabled()) {
			try {
				File f = new File("resources/3.wav");
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

		Space s;
		if (application.getLbLevelView().getActiveIndex() + 1 > application
				.getLbLevelView().getToggleMoves().size())
			return;
		else
			s = application.getLbLevelView().getToggleMoves()
					.get(application.getLbLevelView().getActiveIndex());
		TileView tileView = application
				.getLbLevelView()
				.getBoardView()
				.getGrid()
				.get(s.getTile().getRow() * level.getBoard().getDimension()
						+ s.getTile().getColumn()).getTileView();
		s.toggleEnabled();
		application.getLbLevelView().incrementActiveIndex();

		if (!s.isEnabled()) {
			s.getTile().setValue(
					s.getReleaseStates().get(s.getActiveIndex() + 1));
			;
		}

		s.printReleaseStates();
		s.incrementActiveIndex();

		System.out.println("Active Index: "
				+ application.getLbLevelView().getActiveIndex());
		System.out.println("Moves List Size: "
				+ application.getLbLevelView().getToggleMoves().size());
		tileView.repaint();
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	}

}
