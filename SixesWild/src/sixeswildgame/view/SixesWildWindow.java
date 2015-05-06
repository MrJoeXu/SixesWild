package src.sixeswildgame.view;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
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
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;

import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.controllers.StartController;
import src.sixeswildgame.world.Level;
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
	protected LevelSummaryView levelSummary;
	protected LoseGameView loseView;
	
	//JButtons
	protected JButton startButton;
	protected JButton closeBtn;
	protected JButton miniBtn;
	
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
		world = new World();

		File dir = new File("saveddata/custom/puzzle");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {
		  	Level level = new Level(child);
		  	world.getPuzzleLevels().add(level);
		  }
		} else {
		}
		
		dir = new File("saveddata/custom/lightning");
		directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {
		  	Level level = new Level(child);
		  	world.getLightningLevels().add(level);
		  }
		} else {
		}
		
		dir = new File("saveddata/custom/release");
		directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {
		  	Level level = new Level(child);
		  	world.getReleaseLevels().add(level);
		  }
		} else {
		}
		
		dir = new File("saveddata/custom/elimination");
		directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {
		  	Level level = new Level(child);
		  	world.getEliminationLevels().add(level);
		  }
		} else {
		}

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
		frmSixesWild.setSize(1000, 708);
		frmSixesWild.setLocationRelativeTo(null);
		frmSixesWild.setResizable(false);
		frmSixesWild.setUndecorated(true);
		frmSixesWild.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSixesWild.setBackground(Color.decode("#E5E5E5"));
		frmSixesWild.setLayout(null);
		frmSixesWild.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#A38F85")));

		this.mainMenuView = (JPanel) frmSixesWild.getContentPane();
		
		JLabel lblSixeswild = new JLabel("SixesWild");
		Font f50 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 50);
		lblSixeswild.setFont(f50);
		lblSixeswild.setBounds(390, 162, 225, 68);
		lblSixeswild.setForeground(Color.decode("#D76262"));
		//lblSixeswild.setHorizontalAlignment(JLabel.CENTER);
		frmSixesWild.getContentPane().add(lblSixeswild);
		
		
		startButton = new BetterButton(Color.decode("#D76262"),200,52,10);
		startButton.setBorderPainted(false);
		startButton.setFocusPainted(false);
		Font f22 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 22);
		startButton.setFont(f22);
		startButton.setText("Start");
		startButton.setBounds(401, 302, 200, 52);
		startButton.setForeground(Color.white);
		frmSixesWild.getContentPane().add(startButton);

		
		JLabel label1 = new JLabel("Presented by");
		label1.setBounds(438, 412, 135, 30);
		label1.setFont(f22);
		label1.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Matthew Beaulieu");
		Font f15 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 15);
		label2.setBounds(439, 461, 123, 20);
		label2.setFont(f15);
		label2.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Tiffany Leung");
		label3.setBounds(456, 486, 90, 20);
		label3.setFont(f15);
		label3.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Jiaqi Ren");
		label4.setBounds(469, 511, 65, 20);
		label4.setFont(f15);
		label4.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Halsey Vandenberg");
		label5.setBounds(436, 536, 133, 20);
		label5.setFont(f15);
		label5.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("Ziyao Xu \"Joe\"");
		label6.setBounds(459, 561, 100, 20);
		label6.setFont(f15);
		label6.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label6);
		
		closeBtn = new BetterButton(Color.decode("#D76262"),40,40,10);
		closeBtn.setBorderPainted(false);
		closeBtn.setFocusPainted(false);
		Icon closeIcon = new ImageIcon("resources/close.png");
		closeBtn.setIcon(closeIcon);
		closeBtn.setBounds(930, 20, 40, 40);
		frmSixesWild.getContentPane().add(closeBtn); 
		
		miniBtn = new BetterButton(Color.decode("#50E3C2"),40,40,10);
		miniBtn.setBorderPainted(false);
		miniBtn.setFocusPainted(false);
		Icon minIcon = new ImageIcon("resources/min.png");
		miniBtn.setIcon(minIcon);
		miniBtn.setBounds(880, 20, 40, 40);
		frmSixesWild.getContentPane().add(miniBtn); 

		
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		startButton.addActionListener(new StartController(this, world));
		closeBtn.addActionListener(new CloseGameController(world, this));
		miniBtn.addActionListener(new MinimizeGameController(world,this));
		
	}
	
	public String getGameTypeName() {
		
		switch (gameType) {
		case 1:
			return "puzzle";
		case 2:
			return "lightning";
		case 3:
			return "release";
		case 4:
			return "elimination";
		default:
			return "Unknown";
		}
	}
	
	public Color getGameTypeColor() {
		
		switch (gameType) {
		case 1:
			return Color.decode("#D76262");
		case 2:
			return Color.decode("#3D7CA2");
		case 3:
			return Color.decode("#45D7B3");
		case 4:
			return Color.decode("#65ABD5");
		default:
			return Color.white;
		}
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
	        Thread.sleep(3000);
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

	public LevelSummaryView getLevelSummary() {
		return levelSummary;
	}

	public void setLevelSummary(LevelSummaryView levelSummary) {
		this.levelSummary = levelSummary;
	}

	public LoseGameView getLoseView() {
		return loseView;
	}

	public void setLoseView(LoseGameView loseView) {
		this.loseView = loseView;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	//Getters and Setters
	

}