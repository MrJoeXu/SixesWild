package src.levelbuilder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import src.levelbuilder.controllers.SelectLBGameTypeController;
import src.sixeswildgame.world.World;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Insets;

public class LevelBuilderWindow {

	protected JFrame frame;
	protected JPanel mainMenuView;
	protected LBLevelView lbLevelView;
	
	//JButtons
	protected JButton puzzleBtn;
	protected JButton lightningBtn;
	protected JButton releaseBtn;
	protected JButton eliminationBtn;
	
	protected World world;
	protected int gameType;
	
	/**
	 * Create the application.
	 */
	public LevelBuilderWindow() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeWorld();
		initializeView();
		initializeControllers();
	}
	
	/**
	 * Initialize the world.
	 */
	private void initializeWorld() {
		int gameType = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeView() {
		frame = new JFrame();
		frame.setTitle("Sixes Wild Level Builder");
		frame.setBounds(550, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Border paddingBorder = BorderFactory.createEmptyBorder(100,100,100,100);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.getContentPane().setLayout(gridBagLayout);
		this.mainMenuView = (JPanel) frame.getContentPane();
		
		JLabel lblNewLabel = new JLabel("Sixes Wild Level Builder");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 65));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		frame.getContentPane().add(label, gbc_label);
		
		puzzleBtn = new JButton("    Puzzle Builder   ");
		GridBagConstraints gbc_btnPuzzleBuilder = new GridBagConstraints();
		gbc_btnPuzzleBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_btnPuzzleBuilder.gridx = 0;
		gbc_btnPuzzleBuilder.gridy = 2;
		frame.getContentPane().add(puzzleBtn, gbc_btnPuzzleBuilder);
		
		lightningBtn = new JButton(" Lightning Builder  ");
		GridBagConstraints gbc_btnLightningBuilder = new GridBagConstraints();
		gbc_btnLightningBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_btnLightningBuilder.gridx = 0;
		gbc_btnLightningBuilder.gridy = 3;
		frame.getContentPane().add(lightningBtn, gbc_btnLightningBuilder);
		
		releaseBtn = new JButton("   Release Builder  ");
		GridBagConstraints gbc_btnReleaseBuilder = new GridBagConstraints();
		gbc_btnReleaseBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_btnReleaseBuilder.gridx = 0;
		gbc_btnReleaseBuilder.gridy = 4;
		frame.getContentPane().add(releaseBtn, gbc_btnReleaseBuilder);
		
		eliminationBtn = new JButton("Elimination Builder");
		GridBagConstraints gbc_btnEliminationBuilder = new GridBagConstraints();
		gbc_btnEliminationBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminationBuilder.gridx = 0;
		gbc_btnEliminationBuilder.gridy = 5;
		frame.getContentPane().add(eliminationBtn, gbc_btnEliminationBuilder);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblPresentedBy = new JLabel("Presented By:");
		GridBagConstraints gbc_lblPresentedBy = new GridBagConstraints();
		gbc_lblPresentedBy.insets = new Insets(0, 0, 5, 0);
		gbc_lblPresentedBy.gridx = 0;
		gbc_lblPresentedBy.gridy = 7;
		frame.getContentPane().add(lblPresentedBy, gbc_lblPresentedBy);
		
		JLabel lblMatthewBeaulieu = new JLabel("Matthew Beaulieu");
		GridBagConstraints gbc_lblMatthewBeaulieu = new GridBagConstraints();
		gbc_lblMatthewBeaulieu.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatthewBeaulieu.gridx = 0;
		gbc_lblMatthewBeaulieu.gridy = 8;
		frame.getContentPane().add(lblMatthewBeaulieu, gbc_lblMatthewBeaulieu);
		
		JLabel lblTiffanyLeung = new JLabel("Tiffany Leung");
		GridBagConstraints gbc_lblTiffanyLeung = new GridBagConstraints();
		gbc_lblTiffanyLeung.insets = new Insets(0, 0, 5, 0);
		gbc_lblTiffanyLeung.gridx = 0;
		gbc_lblTiffanyLeung.gridy = 9;
		frame.getContentPane().add(lblTiffanyLeung, gbc_lblTiffanyLeung);
		
		JLabel lblJiaqiRen = new JLabel("Jiaqi Ren");
		GridBagConstraints gbc_lblJiaqiRen = new GridBagConstraints();
		gbc_lblJiaqiRen.insets = new Insets(0, 0, 5, 0);
		gbc_lblJiaqiRen.gridx = 0;
		gbc_lblJiaqiRen.gridy = 10;
		frame.getContentPane().add(lblJiaqiRen, gbc_lblJiaqiRen);
		
		JLabel lblHalseyVandenberg = new JLabel("Halsey Vandenberg");
		GridBagConstraints gbc_lblHalseyVandenberg = new GridBagConstraints();
		gbc_lblHalseyVandenberg.insets = new Insets(0, 0, 5, 0);
		gbc_lblHalseyVandenberg.gridx = 0;
		gbc_lblHalseyVandenberg.gridy = 11;
		frame.getContentPane().add(lblHalseyVandenberg, gbc_lblHalseyVandenberg);
		
		JLabel lblJiyaoXujoe = new JLabel("Ziyao Xu \"Joe\"");
		GridBagConstraints gbc_lblJiyaoXujoe = new GridBagConstraints();
		gbc_lblJiyaoXujoe.gridx = 0;
		gbc_lblJiyaoXujoe.gridy = 12;
		frame.getContentPane().add(lblJiyaoXujoe, gbc_lblJiyaoXujoe);
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		puzzleBtn.addActionListener(new SelectLBGameTypeController(this, world, 1));
		lightningBtn.addActionListener(new SelectLBGameTypeController(this, world, 2));
		releaseBtn.addActionListener(new SelectLBGameTypeController(this, world, 3));
		eliminationBtn.addActionListener(new SelectLBGameTypeController(this, world, 4));
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderWindow window = new LevelBuilderWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	/**
	 * @return the lbLevelView
	 */
	public LBLevelView getLbLevelView() {
		return lbLevelView;
	}

	/**
	 * @param lbLevelView the lbLevelView to set
	 */
	public void setLbLevelView(LBLevelView lbLevelView) {
		this.lbLevelView = lbLevelView;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the mainMenuView
	 */
	public JPanel getMainMenuView() {
		return mainMenuView;
	}

	/**
	 * @param mainMenuView the mainMenuView to set
	 */
	public void setMainMenuView(JPanel mainMenuView) {
		this.mainMenuView = mainMenuView;
	}
	
	

}
