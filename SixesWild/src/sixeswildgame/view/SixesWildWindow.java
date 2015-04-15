package src.sixeswildgame.view;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;

import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */

public class SixesWildWindow {

	//JFrames
	protected JFrame frmSixesWild;
	
	//JPanels
	protected JPanel mainMenuView;
	protected GameTypeView gameTypeView;
	protected LevelSelectorView levelSelectorView;
	protected LevelView levelView;
	
	//JButtons
	protected JButton startButton;
	
	//World
	protected World world;
	
	protected int gameType;
	protected int gameLevel;

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public SixesWildWindow() throws FileNotFoundException, FontFormatException, IOException {
		initialize();
	}
	
	private void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeModel();
		initializeView();
		initializeControllers();
		
	}

	/**
	 * Initialize the model.
	 */
	private void initializeModel() {
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		frmSixesWild = new JFrame();
		frmSixesWild.setTitle("Sixes Wild");
		frmSixesWild.setSize(1440, 1020);
		frmSixesWild.setLocationRelativeTo(null);
		frmSixesWild.setResizable(false);
		System.out.println(frmSixesWild.getToolkit().getScreenSize());
		System.out.println(frmSixesWild.getToolkit().getScreenResolution());
		frmSixesWild.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSixesWild.setBackground(Color.decode("#E5E5E5"));
		frmSixesWild.setLayout(null);

		this.mainMenuView = (JPanel) frmSixesWild.getContentPane();
		
		JLabel lblSixeswild = new JLabel("SixesWild");
		Font f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 78);
		lblSixeswild.setFont(f);
		lblSixeswild.setBounds(543, 261, 354, 109);
		lblSixeswild.setForeground(Color.decode("#D76262"));
		//lblSixeswild.setHorizontalAlignment(JLabel.CENTER);
		frmSixesWild.getContentPane().add(lblSixeswild);
		
		
		startButton = new BetterButton(Color.decode("#D76262"),271,70,10);
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		
		startButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		startButton.setText("Start");
		startButton.setBounds(585, 477, 271, 70);
		startButton.setForeground(Color.white);
		frmSixesWild.getContentPane().add(startButton);

		
		JLabel label1 = new JLabel("Presented by:");
		label1.setBounds(625, 657, 200, 41);
		label1.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		label1.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Matthew Beaulieu");
		label2.setBounds(640, 732, 170, 27);
		label2.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label2.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Tiffany Leung");
		label3.setBounds(662, 759, 170, 27);
		label3.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label3.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Jiaqi Ren");
		label4.setBounds(680, 786, 170, 27);
		label4.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label4.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Halsey Vandenberg");
		label5.setBounds(635, 813, 180, 27);
		label5.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label5.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("Ziyao Xu \"Joe\"");
		label6.setBounds(664, 840, 170, 27);
		label6.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label6.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label6);
		
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		startButton.addActionListener(new StartController(this, world));
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JWindow splash = new JWindow();
	    BufferedImage splashScreenImg;
		try {
			splashScreenImg = ImageIO.read(new File("resources/swSplashScreen.png"));
			splash.getContentPane().add(new JLabel(new ImageIcon(splashScreenImg)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	    int width = 800;
	    int height = 800;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width - width) / 2;
	    int y = (screen.height - height) / 2;
	    splash.setBounds(x, y, width, height);
	    splash.setVisible(true);
	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    splash.setVisible(false);
	    splash.dispose();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SixesWildWindow window = new SixesWildWindow();
					window.frmSixesWild.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//InputStream is = MyClass.class.getClassLoader().getResourceAsStream(name)
		});
	}

	/**
	 * @return the gameTypeView
	 */
	
	
	public GameTypeView getGameTypeView() {
		return gameTypeView;
	}
	
	public JFrame getFrmSixesWild() {
		return frmSixesWild;
	}

	/**
	 * @param gameTypeView the gameTypeView to set
	 */
	public void setGameTypeView(GameTypeView gameTypeView) {
		this.gameTypeView = gameTypeView;
	}

	/**
	 * @return the startButton
	 */
	public JButton getStartButton() {
		return startButton;
	}

	/**
	 * @param startButton the startButton to set
	 */
	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JPanel getMainMenuView() {
		return mainMenuView;
	}

	public void setMainMenuView(JPanel mainMenuView) {
		this.mainMenuView = mainMenuView;
	}

	public void setFrmSixesWild(JFrame frmSixesWild) {
		this.frmSixesWild = frmSixesWild;
	}

	public LevelSelectorView getLevelSelectorView() {
		return levelSelectorView;
	}

	public void setLevelSelectorView(LevelSelectorView levelSelectorView) {
		this.levelSelectorView = levelSelectorView;
	}

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public int getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}

	public LevelView getLevelView() {
		return levelView;
	}

	public void setLevelView(LevelView levelView) {
		this.levelView = levelView;
	}

	//Getters and Setters
	

}