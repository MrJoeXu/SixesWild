/**
 * 
 */
package src.levelbuilder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.world.Tile;

/**
 * @author Halsey
 *
 */
public class PreferencesView extends JPanel  {
	
	protected LevelBuilderWindow application;
	protected JSlider musicSlider;
	protected JSlider soundSlider;
	
	/**
	 * @param application
	 * @param musicSlider
	 * @param soundSlider
	 */
	public PreferencesView(LevelBuilderWindow application) throws FileNotFoundException,
			FontFormatException, IOException {
		super();
		this.application = application;
		setPreferredSize(new Dimension(200, 200));
		
		initializeView();
		
	}

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public void initializeView() throws FileNotFoundException,
	FontFormatException, IOException {
		
		this.setLayout(null);
		
		Font f22 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 22);
		
		Font f16 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 16);
		
		musicSlider = new JSlider();
		musicSlider.setMinimum(0);
		musicSlider.setMaximum(10);
		musicSlider.setMajorTickSpacing(2);
		musicSlider.setBorder(null);
		musicSlider.setPaintTicks(true);
		musicSlider.setPaintTrack(true);
		musicSlider.setPaintLabels(true);
		musicSlider.setFont(f22);
		musicSlider.setBounds(10, 65, 150, 50);
		musicSlider.setBackground(Color.decode("#A38F85"));
		musicSlider.setValue(application.getMusicVolume());
		add(musicSlider);
		
		JLabel musicLabel = new JLabel("Music Volume:");
		musicLabel.setBounds(5, 5, 150, 50);
		musicLabel.setBackground(Color.decode("#A38F85"));
		musicLabel.setLayout(null);
		musicLabel.setFont(f16);
		musicLabel.setHorizontalAlignment(BetterLabel.CENTER);
		musicLabel.setVerticalAlignment(BetterLabel.CENTER);
		musicLabel.setForeground(Color.WHITE);
		add(musicLabel);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.decode("#9B9B9B"));
		g.fillRoundRect(0, 0, 200, 200, 10, 10);
	}

}
