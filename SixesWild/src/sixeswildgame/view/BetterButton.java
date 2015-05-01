package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class BetterButton extends JButton{
	Color col;
	int width;
	int height;
	int radius;
	
	public BetterButton(Color col, int width, int height, int radius) {
		setContentAreaFilled(false);
		this.col = col;
		this.width = width;
		this.height = height;
		this.radius = radius;
	}
	
	protected void paintComponent(Graphics g) {
		   g.setColor(this.col);
		   g.fillRoundRect(0, 0, width, height, radius, radius);
		   super.paintComponent(g);
	}

	/**
	 * @return the col
	 */
	public Color getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(Color col) {
		this.col = col;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
