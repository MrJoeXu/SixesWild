package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import src.sixeswildgame.world.Tile;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * @author Joe Xu 
 * @author Halsey
 * @author Tiffany
 *
 */

public class TileView extends JPanel {

	protected Tile tile;
	protected int bonus;
	protected JLabel valueLbl;
	protected JLabel bonusLbl;
	
	protected int length;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public TileView(Tile tile, int length) {
		this.setLayout(null);
		this.tile = tile;
		this.length = length;
		setPreferredSize(new Dimension(length,length));
	    bonus = tile.getBonus();
		
		valueLbl = new JLabel(Integer.toString(tile.getValue()));
		
		bonusLbl = new JLabel();
		switch (bonus) {
		case 1: bonusLbl.setText(""); break;
		case 2: bonusLbl.setText("x2"); break;
		case 3: bonusLbl.setText("x3"); break;
		}
		
		
		
		
		if (this.length == 33) {
			valueLbl.setFont(new Font("Avenir Next", Font.PLAIN, 12));
			valueLbl.setBounds(13,7,7,16);
			bonusLbl.setFont(new Font("Avenir Next", Font.PLAIN, 7));
			bonusLbl.setBounds(21, 21, 8, 10);
			
		} else {
			valueLbl.setFont(new Font("Avenir Next", Font.PLAIN, 19));
			valueLbl.setBounds(19, 12, 12, 26);	
			bonusLbl.setFont(new Font("Avenir Next", Font.PLAIN, 10));
			bonusLbl.setBounds(34, 31, 12, 14);
		}
		
		valueLbl.setForeground(Color.white);
		bonusLbl.setForeground(Color.white);
		
		add(valueLbl);
		add(bonusLbl);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (tile.getValue()) {
		case 1:
			g.setColor(Color.decode("#45D7B3"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 2:
			g.setColor(Color.decode("#3D7CA2"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 3:
			g.setColor(Color.decode("#FECA44"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 4:
			g.setColor(Color.decode("#CAA3DC"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 5:
			g.setColor(Color.decode("#D76262"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;			
		case 6:
			g.setColor(Color.decode("#716561"));
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 0:
			g.setColor(Color.LIGHT_GRAY);
			valueLbl.setVisible(false);
			bonusLbl.setVisible(false);
			break;
		default:
			g.setColor(Color.LIGHT_GRAY);
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

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	} 

}