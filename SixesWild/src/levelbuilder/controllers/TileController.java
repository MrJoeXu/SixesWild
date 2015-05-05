/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BorderFactory;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

/**
 * @author Halsey
 *
 */
public class TileController implements MouseListener {

	protected TileView tileView;
	protected Level level;
	protected LevelBuilderWindow application;

	/**
	 * Creates a new TileController with specified tileView, level, and
	 * application
	 * 
	 * @param space
	 * @param level
	 * @param application
	 */
	public TileController(TileView tileView, Level level,
			LevelBuilderWindow application) {
		super();
		this.tileView = tileView;
		this.level = level;
		this.application = application;
	}
	
	/**
	 * Toggles the Space to be inert or not inert
	 */
	public void mousePressed(MouseEvent me) {

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
			} catch (Exception e1) {

			}
		}

		Tile tile = tileView.getTile();

		System.out.println(tile.getRow() + ", " + tile.getColumn());

		int row = tile.getRow();
		int column = tile.getColumn();

		Space space = level.getBoard().getGrid()
				.get(row * level.getBoard().getDimension() + column);

		space.toggleEnabled();

		if (!space.isEnabled()) {
			if (application.getLbLevelView().isPlacingSix()) {
				space.getTile().setValue(6);
				space.getTile().setLastValue(6);
				space.getTile().setBonus(1);
				space.getReleaseStates().add(6);
				space.incrementActiveIndex();
			} else if (application.getLbLevelView().isPlacingBucket()) {
				space.getTile().setValue(7);
				space.getReleaseStates().add(7);
				space.incrementActiveIndex();
			} else {
				space.getTile().setValue(0);
				space.getReleaseStates().add(0);
				space.incrementActiveIndex();
			}
		}

		else {
			space.getReleaseStates().add(tile.getValue());
			space.incrementActiveIndex();
		}

		space.printReleaseStates();

		application.getLbLevelView().getToggleMoves()
				.add(application.getLbLevelView().getActiveIndex(), space);
		while (application.getLbLevelView().getActiveIndex() + 1 < application
				.getLbLevelView().getToggleMoves().size()) {
			application.getLbLevelView().getToggleMoves()
					.remove(application.getLbLevelView().getActiveIndex() + 1);
		}
		application.getLbLevelView().incrementActiveIndex();

		tileView.repaint();
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Shows a border on the TileView
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		tileView.setBorder(BorderFactory.createLineBorder(application
				.getLbLevelSelectorView().getBuildLevelBtn().getCol(), 3, true));
		tileView.repaint();
		application.getFrame().pack();
	}
	
	/**
	 * Removes border from the TileView
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		tileView.setBorder(null);
		tileView.repaint();
		application.getFrame().pack();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
