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
}
