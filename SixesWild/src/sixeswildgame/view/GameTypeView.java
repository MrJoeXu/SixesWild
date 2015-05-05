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
public class GameTypeView extends JPanel {

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
	 * Creates new GameTypeView with specified application and world
	 * 
	 * @param application
	 * @param world
	 * @throws FileNotFoundException
	 * @throws FontFormatException
	 * @throws IOException
	 */
	public GameTypeView(SixesWildWindow application, World world)
			throws FileNotFoundException, FontFormatException, IOException {
		this.application = application;
		this.world = world;
		initialize();
	}

	/**
	 * Initializes GameTypeView
	 * 
	 * @throws FileNotFoundException
	 * @throws FontFormatException
	 * @throws IOException
	 */
	public void initialize() throws FileNotFoundException, FontFormatException,
			IOException {
		initializeView();
		initializeModel();
		initializeController();
	}

	/**
	 * Initializes controllers
	 */
	private void initializeController() {
		backBtn.addActionListener(new GameTypeBackController(world, application));
		closeBtn.addActionListener(new CloseGameController(world, application));
		miniBtn.addActionListener(new MinimizeGameController(world, application));

		puzzleBtn.addActionListener(new SelectGameTypeController(application,
				world, 1));
		lightningBtn.addActionListener(new SelectGameTypeController(
				application, world, 2));
		releaseBtn.addActionListener(new SelectGameTypeController(application,
				world, 3));
		eliminationBtn.addActionListener(new SelectGameTypeController(
				application, world, 4));

	}

	/**
	 * Initializes model
	 */
	private void initializeModel() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initializes view
	 * 
	 * @throws FileNotFoundException
	 * @throws FontFormatException
	 * @throws IOException
	 */
	public void initializeView() throws FileNotFoundException,
			FontFormatException, IOException {
		setLayout(null);

		JLabel lblGameType = new JLabel("Please Select A Game Type");
		Font f45 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 45);
		lblGameType.setFont(f45);
		lblGameType.setBounds(223, 162, 565, 61);
		lblGameType.setForeground(Color.decode("#D76262"));
		this.add(lblGameType);

		Font f22 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 22);

		puzzleBtn = new BetterButton(Color.decode("#D76262"), 203, 52, 10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(257, 283, 203, 52);
		puzzleBtn.setForeground(Color.white);
		this.add(puzzleBtn);

		lightningBtn = new BetterButton(Color.decode("#3D7CA2"), 203, 53, 10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(543, 283, 203, 53);
		lightningBtn.setForeground(Color.white);
		this.add(lightningBtn);

		eliminationBtn = new BetterButton(Color.decode("#65ABD5"), 203, 53, 10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(257, 373, 203, 53);
		eliminationBtn.setForeground(Color.white);
		this.add(eliminationBtn);

		releaseBtn = new BetterButton(Color.decode("#45D7B3"), 203, 53, 10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(543, 373, 203, 53);
		releaseBtn.setForeground(Color.white);
		this.add(releaseBtn);

		backBtn = new BetterButton(Color.decode("#EC7665"), 65, 40, 10);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(30, 20, 65, 40);
		this.add(backBtn);

		closeBtn = new BetterButton(Color.decode("#D76262"), 40, 40, 10);
		closeBtn.setBorderPainted(false);
		closeBtn.setFocusPainted(false);
		Icon closeIcon = new ImageIcon("resources/close.png");
		closeBtn.setIcon(closeIcon);
		closeBtn.setBounds(930, 20, 40, 40);
		this.add(closeBtn);

		miniBtn = new BetterButton(Color.decode("#50E3C2"), 40, 40, 10);
		miniBtn.setBorderPainted(false);
		miniBtn.setFocusPainted(false);
		Icon minIcon = new ImageIcon("resources/min.png");
		miniBtn.setIcon(minIcon);
		miniBtn.setBounds(880, 20, 40, 40);
		this.add(miniBtn);
	}

	/**
	 * @return the puzzleBtn
	 */
	public JButton getPuzzleBtn() {
		return puzzleBtn;
	}

	/**
	 * @param puzzleBtn the puzzleBtn to set
	 */
	public void setPuzzleBtn(JButton puzzleBtn) {
		this.puzzleBtn = puzzleBtn;
	}

	/**
	 * @return the lightningBtn
	 */
	public JButton getLightningBtn() {
		return lightningBtn;
	}

	/**
	 * @param lightningBtn the lightningBtn to set
	 */
	public void setLightningBtn(JButton lightningBtn) {
		this.lightningBtn = lightningBtn;
	}

	/**
	 * @return the eliminationBtn
	 */
	public JButton getEliminationBtn() {
		return eliminationBtn;
	}

	/**
	 * @param eliminationBtn the eliminationBtn to set
	 */
	public void setEliminationBtn(JButton eliminationBtn) {
		this.eliminationBtn = eliminationBtn;
	}

	/**
	 * @return the releaseBtn
	 */
	public JButton getReleaseBtn() {
		return releaseBtn;
	}

	/**
	 * @param releaseBtn the releaseBtn to set
	 */
	public void setReleaseBtn(JButton releaseBtn) {
		this.releaseBtn = releaseBtn;
	}

	/**
	 * @return the backBtn
	 */
	public JButton getBackBtn() {
		return backBtn;
	}

	/**
	 * @param backBtn the backBtn to set
	 */
	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	/**
	 * @return the closeBtn
	 */
	public JButton getCloseBtn() {
		return closeBtn;
	}

	/**
	 * @param closeBtn the closeBtn to set
	 */
	public void setCloseBtn(JButton closeBtn) {
		this.closeBtn = closeBtn;
	}

	/**
	 * @return the miniBtn
	 */
	public JButton getMiniBtn() {
		return miniBtn;
	}

	/**
	 * @param miniBtn the miniBtn to set
	 */
	public void setMiniBtn(JButton miniBtn) {
		this.miniBtn = miniBtn;
	}

	/**
	 * @return the lblGameType
	 */
	public JLabel getLblGameType() {
		return lblGameType;
	}

	/**
	 * @param lblGameType the lblGameType to set
	 */
	public void setLblGameType(JLabel lblGameType) {
		this.lblGameType = lblGameType;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the application
	 */
	public SixesWildWindow getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(SixesWildWindow application) {
		this.application = application;
	}

	/**
	 * @return the gameType
	 */
	public int getGameType() {
		return gameType;
	}

	/**
	 * @param gameType the gameType to set
	 */
	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

}
