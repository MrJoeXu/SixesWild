
/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.LevelSelectorBackController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.controllers.SelectLevelController;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class LevelSelectorView extends JPanel{
	// JLabel
	protected JLabel titleLable;
	
	protected JFrame testFrame;
	
	protected SixesWildWindow application;
	
	protected World world;
	
	protected JButton backBtn;
	protected JButton puzzleBtn;
	protected JButton lightningBtn;
	protected JButton eliminationBtn;
	protected JButton releaseBtn;
	protected JButton closeBtn;
	protected JButton miniBtn;
	
	protected JButton levelBtn1;
	protected JButton levelBtn2;
	protected JButton levelBtn3;
	protected JButton levelBtn4;
	
	protected JLabel star1, star2, star3;
	

	public LevelSelectorView(SixesWildWindow application, World world) throws FileNotFoundException, FontFormatException, IOException {
		this.application = application;
		this.world = world;
		initialize();
	}

	public void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeView();
		initializeModel();
		initializeController();
	}

	private void initializeController() {
		backBtn.addActionListener(new LevelSelectorBackController(world, application));
		closeBtn.addActionListener(new CloseGameController(world, application));
		miniBtn.addActionListener(new MinimizeGameController(world,application));
		
		ArrayList<Level> levels;
		
		switch (application.getGameType()) {
		case 1:
			levels = world.getPuzzleLevels();
			break;
		case 2:
			levels = world.getLightningLevels();
			break;
		case 3:
			levels = world.getReleaseLevels();
			break;
		case 4:
			levels = world.getEliminationLevels();
			break;
			default:
				levels = new ArrayList<Level>(null);
		}
		
		levelBtn1.addActionListener(new SelectLevelController(application, world, levels.get(0)));
		levelBtn2.addActionListener(new SelectLevelController(application, world, null));
		levelBtn3.addActionListener(new SelectLevelController(application, world, null));
		levelBtn4.addActionListener(new SelectLevelController(application, world, null));
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		setPreferredSize(new Dimension(1000, 708));
		this.setLayout(null);
		
		JLabel titleLable = new JLabel("Please Select a Level");
		Font f45 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 45);
		titleLable.setFont(f45);
		titleLable.setBounds(286, 162, 435, 61);
		titleLable.setForeground(Color.decode("#D76262"));
		this.add(titleLable);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),65,40,10);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(30, 20, 65, 40);
		this.add(backBtn); 
		
		Font f22 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 22);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),200, 52, 10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(401, 89, 200, 52);
		puzzleBtn.setForeground(Color.white);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),200, 52, 10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(401, 89, 200, 52);
		lightningBtn.setForeground(Color.white);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),200, 52, 10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(401, 89, 200, 52);
		eliminationBtn.setForeground(Color.white);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),200, 52, 10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(401, 89, 200, 52);
		releaseBtn.setForeground(Color.white);
	
		if (application.getGameType() == 1) { this.add(puzzleBtn); }
		if (application.getGameType() == 2) { this.add(lightningBtn); }
		if (application.getGameType() == 3) { this.add(releaseBtn); }
		if (application.getGameType() == 4) { this.add(eliminationBtn); }
		
		Font f40 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 40);
		
		levelBtn1 = new BetterButton(Color.decode("#D76262"),100,100,10);
		levelBtn1.setBorderPainted(false);
		levelBtn1.setFocusPainted(false);
		levelBtn1.setFont(f40);
		levelBtn1.setText("1");
		levelBtn1.setBounds(355, 245, 100, 100);
		levelBtn1.setForeground(Color.white);
		this.add(levelBtn1);
		
		levelBtn2 = new BetterButton(Color.decode("#9B9B9B"),100,100,10);
		levelBtn2.setBorderPainted(false);
		levelBtn2.setFocusPainted(false);
		levelBtn2.setFont(f40);
		levelBtn2.setText("2");
		levelBtn2.setBounds(545, 247, 100, 100);
		levelBtn2.setForeground(Color.white);
		this.add(levelBtn2);
		
		levelBtn3 = new BetterButton(Color.decode("#9B9B9B"),100,100,10);
		levelBtn3.setBorderPainted(false);
		levelBtn3.setFocusPainted(false);
		levelBtn3.setFont(f40);
		levelBtn3.setText("3");
		levelBtn3.setBounds(355, 445, 100, 100);
		levelBtn3.setForeground(Color.white);
		this.add(levelBtn3);
		
		levelBtn4 = new BetterButton(Color.decode("#9B9B9B"),100,100,10);
		levelBtn4.setBorderPainted(false);
		levelBtn4.setFocusPainted(false);
		levelBtn4.setFont(f40);
		levelBtn4.setText("4");
		levelBtn4.setBounds(545, 447, 100, 100);
		levelBtn4.setForeground(Color.white);
		this.add(levelBtn4);
		
		Icon yellowStarIcon = new ImageIcon("resources/YellowStar.png");
		Icon greyStarIcon = new ImageIcon("resources/GreyStar.png");
		
		star1 = new JLabel();
		star1.setIcon(yellowStarIcon);
		star1.setBounds(355, 360, 32, 32);
		this.add(star1);
		
		star2 = new JLabel();
		star2.setIcon(yellowStarIcon);
		star2.setBounds(389, 360, 32, 32);
		this.add(star2);
		
		star3 = new JLabel();
		star3.setIcon(greyStarIcon);
		star3.setBounds(423, 360, 32, 32);
		this.add(star3);
		
		closeBtn = new BetterButton(Color.decode("#D76262"),40,40,10);
		closeBtn.setBorderPainted(false);
		closeBtn.setFocusPainted(false);
		Icon closeIcon = new ImageIcon("resources/close.png");
		closeBtn.setIcon(closeIcon);
		closeBtn.setBounds(930, 20, 40, 40);
		this.add(closeBtn); 
		
		miniBtn = new BetterButton(Color.decode("#50E3C2"),40,40,10);
		miniBtn.setBorderPainted(false);
		miniBtn.setFocusPainted(false);
		Icon minIcon = new ImageIcon("resources/min.png");
		miniBtn.setIcon(minIcon);
		miniBtn.setBounds(880, 20, 40, 40);
		this.add(miniBtn); 
		
		
		
	}
}