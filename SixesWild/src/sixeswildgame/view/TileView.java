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
 * @author Joe Xu & Halsey
 *
 */

public class TileView extends JPanel {

	protected Tile tile;
	protected int bonus;
	
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
		
		Random rand = new Random();
	    bonus = rand.nextInt(3) + 1;
		
		JLabel valueLbl = new JLabel(Integer.toString(tile.getValue()));
		valueLbl.setFont(new Font("Avenir Next", Font.PLAIN, 19));
		valueLbl.setForeground(Color.white);
		valueLbl.setBounds(19, 12, 12, 26);
		
		JLabel bonusLbl = new JLabel();
		switch (bonus) {
		case 1: bonusLbl.setText(""); break;
		case 2: bonusLbl.setText("x2"); break;
		case 3: bonusLbl.setText("x3"); break;
		}
		bonusLbl.setFont(new Font("Avenir Next", Font.PLAIN, 10));
		bonusLbl.setForeground(Color.white);
		bonusLbl.setBounds(34, 31, 12, 14);
		
		add(valueLbl);
		add(bonusLbl);
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

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	} 

}