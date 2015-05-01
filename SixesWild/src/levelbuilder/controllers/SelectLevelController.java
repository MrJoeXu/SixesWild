/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Hvandenberg
 *
 */
public class SelectLevelController implements MouseListener {
	
	protected JButton button;
	protected LevelBuilderWindow application;
	protected Level level;
	protected boolean selected;

	/**
	 * @param world
	 * @param application
	 * @param level
	 */
	public SelectLevelController(JButton button, LevelBuilderWindow application,
			Level level) {
		super();
		this.button = button;
		this.application = application;
		this.level = level;
		this.selected = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		selected = !selected;
		
		if (selected) {
			application.getLbLevelSelectorView().setSelectedLevel(level);
			for (JButton btn : application.getLbLevelSelectorView().getLevelButtons()) {
				if (!btn.equals(button)) btn.setBorder(null);
			}
			button.setBorder(BorderFactory.createLineBorder(Color.decode("#50E3C2"), 2, true));
			application.getLbLevelSelectorView().getPleaseLabel().setVisible(false);
			System.out.println(application.getLbLevelSelectorView().getSelectedLevel().getName());
		}
		
		else {
			application.getLbLevelSelectorView().setSelectedLevel(null);
			for (JButton btn : application.getLbLevelSelectorView().getLevelButtons()) {
				if (!btn.equals(button)) btn.setBorder(null);
			}
			button.setBorder(null);
		}
		
		button.repaint();
		application.getFrame().pack();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		button.setBorder(BorderFactory.createLineBorder(Color.decode("#D76262"), 2, true));;
		button.setBorderPainted(true);
		button.repaint();
		application.getFrame().pack();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!selected) {
			button.setBorder(null);;
			button.repaint();
			application.getFrame().pack();
		}
	}

}
