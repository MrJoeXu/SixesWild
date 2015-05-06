package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
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
	 * Creates new TileView with specified tile and length
	 * 
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public TileView(Tile tile, int length) {
		this.setLayout(null);
		this.tile = tile;
		this.length = length;
		setPreferredSize(new Dimension(length,length));
	    this.bonus = tile.getBonus();
		
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
	
	/**
	 * Creates a better looking TileView
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (tile.getValue()) {
		case 1:
			g.setColor(Color.decode("#45D7B3"));
			valueLbl.setText("1");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 2:
			g.setColor(Color.decode("#3D7CA2"));
			valueLbl.setText("2");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 3:
			g.setColor(Color.decode("#FECA44"));
			valueLbl.setText("3");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 4:
			g.setColor(Color.decode("#CAA3DC"));
			valueLbl.setText("4");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;
		case 5:
			g.setColor(Color.decode("#D76262"));
			valueLbl.setText("5");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(true);
			break;			
		case 6:
			g.setColor(Color.decode("#716561"));
			valueLbl.setText("6");
			valueLbl.setVisible(true);
			bonusLbl.setVisible(false);
			break;
		//disabled
		case 0:
			g.setColor(Color.decode("#9B9B9B"));
			valueLbl.setVisible(false);
			bonusLbl.setVisible(false);
			break;
		//bucket
		case 7:
			g.setColor(Color.decode("#33CCFF"));
			ImageIcon smallBucket = new ImageIcon("resources/Bucket.png");
			ImageIcon bucket = new ImageIcon("resources/BucketBig.png");
			
			if (this.length < 40) {				
				valueLbl.setIcon(smallBucket);
				valueLbl.setBounds(6, 6, 24, 24);
				g.setColor(Color.white);
			}
			else if (this.length >= 40) {
				valueLbl.setIcon(bucket);
				valueLbl.setBounds(8, 8, 35, 35);
				g.setColor(Color.decode("#A38F85"));
			}
			bonusLbl.setVisible(false);
			break;
		default:
			g.setColor(Color.decode("#9B9B9B"));
		}
		
		g.fillRoundRect(0, 0, length, length, 10, 10);
		
		
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the valueLbl
	 */
	public JLabel getValueLbl() {
		return valueLbl;
	}

	/**
	 * @param valueLbl the valueLbl to set
	 */
	public void setValueLbl(JLabel valueLbl) {
		this.valueLbl = valueLbl;
	}

	/**
	 * @return the bonusLbl
	 */
	public JLabel getBonusLbl() {
		return bonusLbl;
	}

	/**
	 * @param bonusLbl the bonusLbl to set
	 */
	public void setBonusLbl(JLabel bonusLbl) {
		this.bonusLbl = bonusLbl;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
}