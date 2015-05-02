/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import src.levelbuilder.view.LevelBuilderWindow;
import src.levelbuilder.view.PreferencesView;
import src.sixeswildgame.view.BetterButton;

/**
 * @author Halsey
 *
 */
public class PreferencesController implements ActionListener {
	
	protected LevelBuilderWindow application;
	protected PreferencesView preferencesView;
	protected BetterButton preferencesBtn;
	protected Icon closeIcon;
	protected Icon openIcon;

	/**
	 * @param application
	 * @param preferencesView
	 * @param preferencesBtn
	 * @param closedIcon
	 * @param openIcon2
	 */
	public PreferencesController(LevelBuilderWindow application,
			PreferencesView preferencesView, BetterButton preferencesBtn,
			Icon closeIcon2, Icon openIcon2) {
		super();
		this.application = application;
		this.preferencesView = preferencesView;
		this.preferencesBtn = preferencesBtn;
		this.closeIcon = closeIcon2;
		this.openIcon = openIcon2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.togglePreferences();
		
		if (application.isPreferencesEnabled()) {
			preferencesBtn.setIcon(closeIcon);
			preferencesBtn.setCol(Color.decode("#50E3C2"));
		}
		else {
			preferencesBtn.setIcon(openIcon);
			preferencesBtn.setCol(Color.decode("#D76262"));
		}

		preferencesView.setVisible(application.isPreferencesEnabled());
		application.getFrame().pack();
	}

}
