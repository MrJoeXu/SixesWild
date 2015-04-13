package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import src.sixeswildgame.world.Tile;

import java.awt.Font;

/**
 * @author Joe Xu & Halsey
 *
 */

public class TileView extends JPanel {

	protected Tile tile;
	
	protected int length;
	
	/**
	 * Create the panel.
	 */
	public TileView(Tile tile, int length) {
		this.tile = tile;
		this.length = length;
		setPreferredSize(new Dimension(length,length));
		
		JLabel valueLbl = new JLabel(Integer.toString(tile.getValue()));
		valueLbl.setFont(new Font("Avenir Next", Font.PLAIN, length/2));
		valueLbl.setForeground(Color.white);
		//valueLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		add(valueLbl, Component.LEFT_ALIGNMENT);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		switch (tile.getValue()) {
		case 1:
			g.setColor(Color.decode("#45D7B3"));
			break;
		case 2:
			g.setColor(Color.decode("#3D7CA2"));
			break;
		case 3:
			g.setColor(Color.decode("#FECA44"));
			break;
		case 4:
			g.setColor(Color.decode("#CAA3DC"));
			break;
		case 5:
			g.setColor(Color.decode("#D76262"));
			break;			
		case 6:
			g.setColor(Color.decode("#716561"));
			break;
		default:
			g.setColor(Color.white);
		}
		g.fillRoundRect(0, 0, length, length, 10, 10);
		
		
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	} 

}