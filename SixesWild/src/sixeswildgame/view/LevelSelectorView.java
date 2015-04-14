
/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.sixeswildgame.controllers.LevelSelectorBackController;
import src.sixeswildgame.controllers.SelectLevelController;
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
	
	protected JButton LevelBtn1;
	protected JButton LevelBtn2;
	protected JButton LevelBtn3;
	protected JButton LevelBtn4;
	
	protected JLabel star1, star2, star3;
	

	public LevelSelectorView(SixesWildWindow application, World world) {
		this.application = application;
		this.world = world;
		initialize();
	}

	public void initialize() {
		initializeView();
		initializeModel();
		initializeController();
	}

	private void initializeController() {
		backBtn.addActionListener(new LevelSelectorBackController(world, application));
		LevelBtn1.addActionListener(new SelectLevelController(application, world, application.getGameType(), 1));
		LevelBtn2.addActionListener(new SelectLevelController(application, world, application.getGameType(), 2));
		LevelBtn3.addActionListener(new SelectLevelController(application, world, application.getGameType(), 3));
		LevelBtn4.addActionListener(new SelectLevelController(application, world, application.getGameType(), 4));
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	private void initializeView() {
		this.setLayout(null);
		
		JLabel titleLable = new JLabel("Please Select a Level");
		titleLable.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		titleLable.setBounds(435, 174, 580, 82);
		titleLable.setForeground(Color.decode("#D76262"));
		this.add(titleLable);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),94,58,15);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(50, 30, 94, 58);
		this.add(backBtn); 
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),271,70,15);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(585, 60, 271, 70);
		puzzleBtn.setForeground(Color.white);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),271,70,15);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(585, 60, 271, 70);
		lightningBtn.setForeground(Color.white);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),271,70,15);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(585, 60, 271, 70);
		eliminationBtn.setForeground(Color.white);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),271,70,15);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		releaseBtn.setText("Release");
		releaseBtn.setBounds(585, 60, 271, 70);
		releaseBtn.setForeground(Color.white);
	
		if (application.getGameType() == 1) { this.add(puzzleBtn); }
		if (application.getGameType() == 2) { this.add(lightningBtn); }
		if (application.getGameType() == 3) { this.add(releaseBtn); }
		if (application.getGameType() == 4) { this.add(eliminationBtn); }
		
		LevelBtn1 = new BetterButton(Color.decode("#D76262"),150,150,15);
		LevelBtn1.setBorderPainted(false);
		LevelBtn1.setFocusPainted(false);
		LevelBtn1.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		LevelBtn1.setText("1");
		LevelBtn1.setBounds(495, 361, 150, 150);
		LevelBtn1.setForeground(Color.white);
		this.add(LevelBtn1);
		
		LevelBtn2 = new BetterButton(Color.decode("#9B9B9B"),150,150,15);
		LevelBtn2.setBorderPainted(false);
		LevelBtn2.setFocusPainted(false);
		LevelBtn2.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		LevelBtn2.setText("2");
		LevelBtn2.setBounds(795, 361, 150, 150);
		LevelBtn2.setForeground(Color.white);
		this.add(LevelBtn2);
		
		LevelBtn3 = new BetterButton(Color.decode("#9B9B9B"),150,150,15);
		LevelBtn3.setBorderPainted(false);
		LevelBtn3.setFocusPainted(false);
		LevelBtn3.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		LevelBtn3.setText("3");
		LevelBtn3.setBounds(495, 661, 150, 150);
		LevelBtn3.setForeground(Color.white);
		this.add(LevelBtn3);
		
		LevelBtn4 = new BetterButton(Color.decode("#9B9B9B"),150,150,15);
		LevelBtn4.setBorderPainted(false);
		LevelBtn4.setFocusPainted(false);
		LevelBtn4.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		LevelBtn4.setText("4");
		LevelBtn4.setBounds(795, 661, 150, 150);
		LevelBtn4.setForeground(Color.white);
		this.add(LevelBtn4);
		
		Icon yellowStarIcon = new ImageIcon("resources/YellowStar.png");
		Icon greyStarIcon = new ImageIcon("resources/GreyStar.png");
		
		star1 = new JLabel();
		star1.setIcon(yellowStarIcon);
		star1.setBounds(500, 535, 45, 45);
		this.add(star1);
		
		star2 = new JLabel();
		star2.setIcon(yellowStarIcon);
		star2.setBounds(548, 535, 45, 45);
		this.add(star2);
		
		star3 = new JLabel();
		star3.setIcon(greyStarIcon);
		star3.setBounds(596, 535, 45, 45);
		this.add(star3);
		
		
		
	}
}