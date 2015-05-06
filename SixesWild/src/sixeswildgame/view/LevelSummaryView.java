/**
 * 
 */
package src.sixeswildgame.view;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.sixeswildgame.controllers.BackHomeController;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class LevelSummaryView extends JPanel {
	SixesWildWindow application;
	Level level;
	JButton homeBtn;

	
	/** 
	 * @param application
	 * @param level
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public LevelSummaryView(SixesWildWindow application, Level level) throws FileNotFoundException, FontFormatException, IOException {
		super();
		this.application = application;
		this.level = level; 
		initialize();
	}
	
	public void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeView();
		initializeModel();
		initializeController();
	}
	
	private void initializeController() {
		homeBtn.addActionListener(new BackHomeController(application, level));
		
	}

	private void initializeModel() {
		
		
	}

	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		this.setLayout(null);
		this.setBackground(Color.decode("#CAC2BE"));
		Font f60 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 60);
		Font f50 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 50);
		Font f35 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 35);
		
		JLabel congLbl = new JLabel("Congratulations!");
		congLbl.setFont(f60);
		congLbl.setBounds(263, 75, 475, 82);
		congLbl.setForeground(Color.decode("#D76262"));
		this.add(congLbl);
		
		JLabel levelLbl = new JLabel("You passed Level " + application.gameLevel+1 +" of ");
		levelLbl.setFont(f35);
		levelLbl.setBounds(157, 171, 800, 67);
		switch (application.gameType) {
		case 1:
			levelLbl.setText(levelLbl.getText()+"Puzzel");
			break;
		case 2:
			levelLbl.setText(levelLbl.getText()+"Lightning");
			break;
		case 3:
			levelLbl.setText(levelLbl.getText()+"Release");
			break;
		case 4:
			levelLbl.setText(levelLbl.getText()+"Elimination");
			break;
		default:
			levelLbl.setText(levelLbl.getText()+"Unknown");
			break;
		}
		
		levelLbl.setText(levelLbl.getText()+" Mode with");
		levelLbl.setForeground(Color.decode("#D76262"));
		this.add(levelLbl);
		
		JLabel pointsLbl = new JLabel(""+level.getCurrentScore());
		pointsLbl.setText(pointsLbl.getText() + " points");
		pointsLbl.setBounds(357, 245, 300, 68);
		pointsLbl.setFont(f50);
		pointsLbl.setForeground(Color.decode("#D76262"));
		this.add(pointsLbl);
		
		ImageIcon GreyStar = new ImageIcon("resources/greyyStar.png");
		ImageIcon RedStar = new ImageIcon("resources/redStar.png");
		
		JLabel oneStarLbl = new JLabel();
		if (level.getCurrentScore() > level.getOneStarScore()) {
			oneStarLbl.setIcon(RedStar);
		}
		else {oneStarLbl.setIcon(GreyStar);}
		oneStarLbl.setBounds(377, 327, 80, 80);
		this.add(oneStarLbl);

		JLabel twoStarLbl = new JLabel();
		if (level.getCurrentScore() > level.getTwoStarScore()) {
			twoStarLbl.setIcon(RedStar);
		}
		else {twoStarLbl.setIcon(GreyStar);}
		twoStarLbl.setBounds(463, 327, 80, 80);
		this.add(twoStarLbl);
		
		JLabel threeStarLbl = new JLabel();
		if (level.getCurrentScore() > level.getThreeStarScore()) {
			threeStarLbl.setIcon(RedStar);
		}
		else {threeStarLbl.setIcon(GreyStar);}
		threeStarLbl.setBounds(549, 327, 80, 80);
		this.add(threeStarLbl);

		JLabel highScoreLbl = new JLabel ("Your highest score of this level: " + level.getHighScore());
		highScoreLbl.setFont(f35);
		highScoreLbl.setForeground(Color.decode("#D76262"));
		highScoreLbl.setBounds(194, 426, 650, 48);
		this.add(highScoreLbl);
		
		JLabel niceLbl = new JLabel ("Keep going!");
		niceLbl.setFont(f35);
		niceLbl.setForeground(Color.decode("#D76262"));
		niceLbl.setBounds(400, 482, 222, 48);
		this.add(niceLbl);
		
		homeBtn = new BetterButton(Color.decode("#D76262"),130,64,10);
		homeBtn.setBorderPainted(false);
		homeBtn.setFocusPainted(false);
		Icon homeIcon = new ImageIcon("resources/home.png");
		homeBtn.setIcon(homeIcon);
		homeBtn.setBounds(435, 593, 130, 64);
		this.add(homeBtn); 
		
	} 

	
	
	
	

}
