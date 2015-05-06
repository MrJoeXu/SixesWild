/**
 * 
 */
package src.levelbuilder.controllers;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author Joe Xu
 *
 */
public class UpdateFrequencyController implements ChangeListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JSlider slider;

	/**
	 * Creates new UpdateFrequecnyController with specified application, level,
	 * and slider
	 * 
	 * @param application
	 * @param level
	 * @param slider
	 */
	public UpdateFrequencyController(LevelBuilderWindow application,
			Level level, JSlider slider) {
		this.application = application;
		this.level = level;
		this.slider = slider;
	}

	/**
	 * Updates the preview with the specified bonus frequency from slider
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		if (!slider.getValueIsAdjusting()) {

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

			int bonusSlide = (int) slider.getValue();
			switch (bonusSlide) {
			case 3:
				level.setBonusFrequency(1);
				break;
			case 4:
				level.setBonusFrequency(2);
				break;
			case 5:
				level.setBonusFrequency(3);
				break;
			}
			level.initialize(application.getGameType());

			BoardView newBoardView = new BoardView(level.getBoard(), 33, 33);
			int length = newBoardView.getDimension()
					* newBoardView.getTileLength() + 5
					* newBoardView.getDimension();
			int panelX = (350 - length) / 2;
			// System.out.print(panelX);
			int panelY = (350 - length) / 2;
			// System.out.print(panelY);
			newBoardView.setBounds(panelX, panelY, length, length);

			application.getLbLevelView().setBoardView(newBoardView);
			application.getLbLevelView().getBoardPanel().removeAll();
			application.getLbLevelView().getBoardPanel().add(newBoardView);
			for (SpaceView sv : application.getLbLevelView().getBoardView()
					.getGrid()) {
				TileView tv = sv.getTileView();
				tv.addMouseListener(new TileController(tv, level, application));
			}
			// application.getLbLevelView().getBoardPanel().setAlignmentY(JComponent.CENTER_ALIGNMENT);
			application.getLbLevelView().getSaveLbl()
					.setText("Unsaved Changes");
			application.getLbLevelView().repaint();
			application.getFrame().pack();
		}
	}
}