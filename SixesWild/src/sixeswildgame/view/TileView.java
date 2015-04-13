package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

public class TileView extends JPanel {

	/**
	 * Create the panel.
	 */
	public TileView() {
		setPreferredSize(new Dimension(50, 50));
		
		JLabel valueLbl = new JLabel("0");
		valueLbl.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		valueLbl.setBackground(Color.CYAN);
		add(valueLbl);
	}

}
