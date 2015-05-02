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

import src.levelbuilder.view.LBLevelView;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * @author Hvandenberg
 *
 */
public class ReleaseController implements ActionListener {

	protected LevelBuilderWindow application;
	protected int type;
	protected JCheckBox checkBox;

	/**
	 * Creates new ReleaseController with specified application, game type, and
	 * check box
	 * 
	 * @param application
	 * @param type
	 * @param checkBox
	 */
	public ReleaseController(LevelBuilderWindow application, int type,
			JCheckBox checkBox) {
		this.application = application;
		this.type = type;
		this.checkBox = checkBox;

	}

	/**
	 * If the 6 check box is selected, then spaces on preview can be changed
	 * into 6's and if the bucket check box is selected, then spaces on preview
	 * can be changed into buckets
	 */
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
			} catch (Exception e1) {

			}
		}

		if (type == 0) {
			application.getLbLevelView().setPlacingSix(
					!application.getLbLevelView().isPlacingSix());
			if (checkBox.isSelected()) {
				application.getLbLevelView().getBucketCheckBox()
						.setSelected(false);
				application.getLbLevelView().setPlacingBucket(false);
			}
		}

		if (type == 1) {
			application.getLbLevelView().setPlacingBucket(
					!application.getLbLevelView().isPlacingBucket());
			if (checkBox.isSelected()) {
				application.getLbLevelView().getRangeSixCheckBox()
						.setSelected(false);
				application.getLbLevelView().setPlacingSix(false);
			}
		}

		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
		application.getLbLevelView().repaint();
		application.getFrame().pack();

		System.out.println(application.getLbLevelView().isPlacingSix());
		System.out.println(application.getLbLevelView().isPlacingBucket());
	}

}
