package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BetterLabel extends JLabel {
	Color col;
	int width;
	int height;
	int radius;

	/**
	 * Creates new BetterLabel with specified column, width, height, and radius
	 * 
	 * @param col
	 * @param width
	 * @param height
	 * @param radius
	 */
	public BetterLabel(Color col, int width, int height, int radius) {
		this.col = col;
		this.width = width;
		this.height = height;
		this.radius = radius;
	}

	/**
	 * Creates a better looking label
	 */
	protected void paintComponent(Graphics g) {
		g.setColor(this.col);
		g.fillRoundRect(0, 0, width, height, radius, radius);
		super.paintComponent(g);
	}
}
