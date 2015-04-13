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

import src.levelbuilder.controllers.SelectLBGameTypeController;
import src.sixeswildgame.controllers.GameTypeBackController;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class GameTypeView extends JPanel{
	
	// JButton
	protected JButton puzzleBtn;
	protected JButton lightningBtn;
	protected JButton eliminationBtn;
	protected JButton releaseBtn;
	protected JButton backBtn;
	
	// JLabel
	protected JLabel lblGameType;
	
	// World
	protected World world;
	
	// SixesWildWindow
	protected SixesWildWindow application;
	
	protected int gameType;
	

	/**
	 * 
	 */
	public GameTypeView(SixesWildWindow application, World world) {
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
		backBtn.addActionListener(new GameTypeBackController(world, application));
		puzzleBtn.addActionListener(new SelectGameTypeController(application, world, 1));
		lightningBtn.addActionListener(new SelectGameTypeController(application, world, 2));
		releaseBtn.addActionListener(new SelectGameTypeController(application, world, 3));
		eliminationBtn.addActionListener(new SelectGameTypeController(application, world, 4));
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	public void initializeView() {
		setLayout(null);
		
		JLabel lblGameType = new JLabel("Please Select A Game Type");
		lblGameType.setFont(new Font("Avenir Next", Font.PLAIN, 60));
		lblGameType.setBounds(352, 174, 750, 82);
		lblGameType.setForeground(Color.decode("#D76262"));
		this.add(lblGameType);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),271,70,15);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(352, 375, 271, 70);
		puzzleBtn.setForeground(Color.white);
		this.add(puzzleBtn);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),271,70,15);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(820, 375, 271, 70);
		lightningBtn.setForeground(Color.white);
		this.add(lightningBtn);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),271,70,15);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(352, 545, 271, 70);
		eliminationBtn.setForeground(Color.white);
		this.add(eliminationBtn);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),271,70,15);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		releaseBtn.setText("Release");
		releaseBtn.setBounds(820, 545, 271, 70);
		releaseBtn.setForeground(Color.white);
		this.add(releaseBtn);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),94,58,15);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(50, 30, 94, 58);
		this.add(backBtn); 
	}

	//Getter and Setters
	public JButton getPuzzleBtn() {
		return puzzleBtn;
	}

	public void setPuzzleBtn(JButton puzzleBtn) {
		this.puzzleBtn = puzzleBtn;
	}

	public JButton getLightningBtn() {
		return lightningBtn;
	}

	public void setLightningBtn(JButton lightningBtn) {
		this.lightningBtn = lightningBtn;
	}

	public JButton getEliminationBtn() {
		return eliminationBtn;
	}

	public void setEliminationBtn(JButton eliminationBtn) {
		this.eliminationBtn = eliminationBtn;
	}

	public JButton getReleaseBtn() {
		return releaseBtn;
	}

	public void setReleaseBtn(JButton releaseBtn) {
		this.releaseBtn = releaseBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JLabel getTitle() {
		return lblGameType;
	}

	public void setTitle(JLabel title) {
		this.lblGameType = title;
	}
	

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

}
