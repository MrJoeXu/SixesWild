package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.levelbuilder.controllers.LBSelectGameTypeController;
import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.GameTypeBackController;
import src.sixeswildgame.controllers.MinimizeGameController;
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
	protected JButton closeBtn;
	protected JButton miniBtn;
	
	// JLabel
	protected JLabel lblGameType;
	
	// World
	protected World world;
	
	// SixesWildWindow
	protected SixesWildWindow application;
	
	protected int gameType;
	

	/**
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 * 
	 */
	public GameTypeView(SixesWildWindow application, World world) throws FileNotFoundException, FontFormatException, IOException {
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
		backBtn.addActionListener(new GameTypeBackController(world, application));
		closeBtn.addActionListener(new CloseGameController(world, application));
		miniBtn.addActionListener(new MinimizeGameController(world,application));
		
		puzzleBtn.addActionListener(new SelectGameTypeController(application, world, 1));
		lightningBtn.addActionListener(new SelectGameTypeController(application, world, 2));
		releaseBtn.addActionListener(new SelectGameTypeController(application, world, 3));
		eliminationBtn.addActionListener(new SelectGameTypeController(application, world, 4));
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	public void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		setLayout(null);
		
		JLabel lblGameType = new JLabel("Please Select A Game Type");
		Font f45 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 45);
		lblGameType.setFont(f45);
		lblGameType.setBounds(223, 162, 565, 61);
		lblGameType.setForeground(Color.decode("#D76262"));
		this.add(lblGameType);
		
		Font f22 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 22);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),203,52,10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(257, 283, 203, 52);
		puzzleBtn.setForeground(Color.white);
		this.add(puzzleBtn);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),203,53,10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(543, 283, 203, 53);
		lightningBtn.setForeground(Color.white);
		this.add(lightningBtn);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),203,53,10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(257, 373, 203, 53);
		eliminationBtn.setForeground(Color.white);
		this.add(eliminationBtn);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),203,53,10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(543, 373, 203, 53);
		releaseBtn.setForeground(Color.white);
		this.add(releaseBtn);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),65,40,10);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(30, 20, 65, 40);
		this.add(backBtn); 
		
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
