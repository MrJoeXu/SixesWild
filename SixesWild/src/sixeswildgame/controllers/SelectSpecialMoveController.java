/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Level;

/**
 * @author Halsey
 *
 */
public class SelectSpecialMoveController implements ActionListener {

	protected SixesWildWindow application;
	protected Level level;
	protected JCheckBox checkBox;
	protected int specialMove;

	/**
	 * Creates new SelectSpecialMoveController with specified application,
	 * level, checkBox, and specialMove
	 * 
	 * @param application
	 * @param level
	 * @param checkBox
	 * @param specialMove
	 */
	public SelectSpecialMoveController(SixesWildWindow application,
			Level level, JCheckBox checkBox, int specialMove) {
		super();
		this.application = application;
		this.level = level;
		this.checkBox = checkBox;
		this.specialMove = specialMove;
	}

	/**
	 * Selects either the swap two tiles or remove tile special move to be used
	 * in the Level
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (specialMove == 0 && level.getSttMove() == null) {
			application.getLevelView().setSwapTwoTiles(
					!application.getLevelView().isSwapTwoTiles());
			if (checkBox.isSelected()) {
				application.getLevelView().getRemoveTileCheckBox()
						.setSelected(false);
				application.getLevelView().setRemoveTile(false);
			}
		}

		else if (specialMove == 1 && level.getSttMove() == null) {
			application.getLevelView().setRemoveTile(
					!application.getLevelView().isRemoveTile());
			if (checkBox.isSelected()) {
				application.getLevelView().getSwapTilesCheckBox()
						.setSelected(false);
				application.getLevelView().setSwapTwoTiles(false);
			}
		}

		application.getLevelView().repaint();
		application.getFrmSixesWild().pack();
	}

}
