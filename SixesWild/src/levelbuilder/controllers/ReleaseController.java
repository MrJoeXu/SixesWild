/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * 
	 */
	public ReleaseController(LevelBuilderWindow application, int type, JCheckBox checkBox) {
		this.application = application;
		this.type = type;
		this.checkBox = checkBox;

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (type == 0) {
			application.getLbLevelView().setPlacingSix(!application.getLbLevelView().isPlacingSix());
			if (checkBox.isSelected()) {
				application.getLbLevelView().getBucketCheckBox().setSelected(false);
				application.getLbLevelView().setPlacingBucket(false);
			}
		}
		
		if (type == 1) {
			application.getLbLevelView().setPlacingBucket(!application.getLbLevelView().isPlacingBucket());
			if (checkBox.isSelected()) {
				application.getLbLevelView().getRangeSixCheckBox().setSelected(false);
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
