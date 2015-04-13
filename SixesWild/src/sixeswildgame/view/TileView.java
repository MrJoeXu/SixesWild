package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import src.sixeswildgame.world.Tile;

import java.awt.Font;

public class TileView extends JPanel {

	protected Tile tile;
	
	/**
	 * Create the panel.
	 */
	public TileView(Tile tile) {
		this.tile = tile;
		setPreferredSize(new Dimension(59, 49));
		JLabel valueLbl = new JLabel(Integer.toString(tile.getValue()));
		valueLbl.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		valueLbl.setVerticalAlignment(SwingConstants.CENTER);
		
		switch (tile.getValue()) {
		case 1:
			setBackground(Color.RED);
			break;
		case 2:
			setBackground(Color.BLUE);
			break;
		case 3:
			setBackground(Color.YELLOW);
			break;
		case 4:
			setBackground(Color.CYAN);
			break;
		case 5:
			setBackground(Color.GREEN);
			break;			
		case 6:
			setBackground(Color.MAGENTA);
			break;
		default:
			setBackground(Color.BLACK);
		}
		
		add(valueLbl);
	}

}
