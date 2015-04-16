package src.levelbuilder.view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.SplashScreen;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import src.levelbuilder.controllers.SelectLBGameTypeController;
import src.sixeswildgame.view.BetterButton;
import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.world.World;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public LevelBuilderWindow() throws FileNotFoundException, FontFormatException, IOException {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException, FontFormatException, IOException {
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
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {	    
		frame = new JFrame();
		
		frame.setTitle("Sixes Wild");
		frame.setSize(1440, 1020);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		//System.out.println(frmSixesWild.getToolkit().getScreenSize());
		//System.out.println(frmSixesWild.getToolkit().getScreenResolution());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.decode("#E5E5E5"));
		frame.getContentPane().setLayout(null);

		this.mainMenuView = (JPanel) frame.getContentPane();
		mainMenuView.setPreferredSize(new Dimension(1440, 1020));
		
		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 301, 89, 10);
		lbLabel.setBounds(575, 116, 301, 89);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		frame.getContentPane().add(lbLabel);
		
		
		JLabel lblSixeswild = new JLabel("Please Select A Game Type");
		Font f60 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 60);
		lblSixeswild.setFont(f60);
		lblSixeswild.setBounds(354, 298, 750, 82);
		lblSixeswild.setForeground(Color.decode("#A38F85"));
		//lblSixeswild.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblSixeswild);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),271,70,15);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		Font f30 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 30);
		puzzleBtn.setFont(f30);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(352, 462, 271, 70);
		puzzleBtn.setForeground(Color.white);
		frame.getContentPane().add(puzzleBtn);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),271,70,15);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f30);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(820, 462, 271, 70);
		lightningBtn.setForeground(Color.white);
		frame.getContentPane().add(lightningBtn);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),271,70,15);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f30);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(352, 632, 271, 70);
		eliminationBtn.setForeground(Color.white);
		frame.getContentPane().add(eliminationBtn);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),271,70,15);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f30);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(820, 632, 271, 70);
		releaseBtn.setForeground(Color.white);
		frame.getContentPane().add(releaseBtn);
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
		
		JWindow splash = new JWindow();
	    BufferedImage splashScreenImg;
		try {
			splashScreenImg = ImageIO.read(new File("resources/lbSplashScreen.png"));
			splash.getContentPane().add(new JLabel(new ImageIcon(splashScreenImg)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	    int width = 500;
	    int height = 300;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width - width) / 2;
	    int y = (screen.height - height) / 2;
	    splash.setBounds(x, y, width, height);
	    splash.setVisible(true);
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    splash.setVisible(false);
	    splash.dispose();
        
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
