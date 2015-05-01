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
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import src.levelbuilder.controllers.LBCloseGameController;
import src.levelbuilder.controllers.LBMinimizeGameController;
import src.levelbuilder.controllers.LBSelectGameTypeController;
import src.levelbuilder.controllers.ToggleSoundController;
import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.view.BetterButton;
import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.PuzzleLevel;
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
	protected LBLevelSelectorView lbLevelSelectorView;
	
	//JButtons
	protected JButton puzzleBtn;
	protected JButton lightningBtn;
	protected JButton releaseBtn;
	protected JButton eliminationBtn;
	
	protected JButton closeBtn;
	protected JButton miniBtn;
	protected JCheckBox toggleSoundCheckBox;
	
	protected World world;
	protected int gameType;
	protected boolean soundEnabled;
	protected Clip musicClip;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public LevelBuilderWindow() throws FileNotFoundException, FontFormatException, IOException {
		this.soundEnabled = true;
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
		
		if (soundEnabled) {
			try {
			    File f = new File("resources/SixesWildMenu.wav");
			    AudioFormat format;
			    DataLine.Info info;

			    AudioInputStream musicStream = AudioSystem.getAudioInputStream(f);
			    format = musicStream.getFormat();
			    info = new DataLine.Info(Clip.class, format);
			    musicClip = (Clip) AudioSystem.getLine(info);
			    musicClip.open(musicStream);
			    musicClip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e1) {
			    
			}
		}
		
	}
	
	/**
	 * Initialize the world.
	 */
	private void initializeWorld() {		
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
		frame = new JFrame();
		
		frame.setTitle("Sixes Wild");
		frame.setSize(1000, 708);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		//System.out.println(frmSixesWild.getToolkit().getScreenSize());
		//System.out.println(frmSixesWild.getToolkit().getScreenResolution());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.decode("#E5E5E5"));
		frame.getContentPane().setLayout(null);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#A38F85")));

		this.mainMenuView = (JPanel) frame.getContentPane();
		mainMenuView.setPreferredSize(new Dimension(1000, 708));
		
		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 230, 69, 10);
		lbLabel.setBounds(385, 135, 230, 69);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		frame.getContentPane().add(lbLabel);
		
		
		JLabel lblSixeswild = new JLabel("Please Select A Game Type");
		Font f45 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 45);
		lblSixeswild.setFont(f45);
		lblSixeswild.setBounds(223, 229, 590, 61);
		lblSixeswild.setForeground(Color.decode("#A38F85"));
		//lblSixeswild.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblSixeswild);
		
		Font f22 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 22);
		Icon sound = new ImageIcon("resources/sound.png");
		Icon mute = new ImageIcon("resources/mute.png");
		
		toggleSoundCheckBox = new JCheckBox();
		toggleSoundCheckBox.setIcon(mute);
		toggleSoundCheckBox.setSelectedIcon(sound);
		toggleSoundCheckBox.setSelected(soundEnabled);
		toggleSoundCheckBox.setBounds(650, 140, 52, 52);
		frame.getContentPane().add(toggleSoundCheckBox);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),200,52,10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(257, 350, 200, 52);
		puzzleBtn.setForeground(Color.white);
		frame.getContentPane().add(puzzleBtn);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),200,52,10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(543, 350, 200, 52);
		lightningBtn.setForeground(Color.white);
		frame.getContentPane().add(lightningBtn);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),200,52,10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(257, 440,200,52);
		eliminationBtn.setForeground(Color.white);
		frame.getContentPane().add(eliminationBtn);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),200,52,10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(543,440,200,52);
		releaseBtn.setForeground(Color.white);
		frame.getContentPane().add(releaseBtn);
		
		closeBtn = new BetterButton(Color.decode("#D76262"),40,40,10);
		closeBtn.setBorderPainted(false);
		closeBtn.setFocusPainted(false);
		Icon closeIcon = new ImageIcon("resources/close.png");
		closeBtn.setIcon(closeIcon);
		closeBtn.setBounds(930, 20, 40, 40);
		frame.getContentPane().add(closeBtn); 
		
		miniBtn = new BetterButton(Color.decode("#50E3C2"),40,40,10);
		miniBtn.setBorderPainted(false);
		miniBtn.setFocusPainted(false);
		Icon minIcon = new ImageIcon("resources/min.png");
		miniBtn.setIcon(minIcon);
		miniBtn.setBounds(880, 20, 40, 40);
		frame.getContentPane().add(miniBtn); 
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		puzzleBtn.addActionListener(new LBSelectGameTypeController(this, world, 1));
		lightningBtn.addActionListener(new LBSelectGameTypeController(this, world, 2));
		releaseBtn.addActionListener(new LBSelectGameTypeController(this, world, 3));
		eliminationBtn.addActionListener(new LBSelectGameTypeController(this, world, 4));
		closeBtn.addActionListener(new LBCloseGameController(world, this));
		miniBtn.addActionListener(new LBMinimizeGameController(world,this));
		toggleSoundCheckBox.addActionListener(new ToggleSoundController(this));
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

	public LBLevelSelectorView getLbLevelSelectorView() {
		return lbLevelSelectorView;
	}

	public void setLbLevelSelectorView(LBLevelSelectorView lbLevelSelectorView) {
		this.lbLevelSelectorView = lbLevelSelectorView;
	}

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

	public JButton getReleaseBtn() {
		return releaseBtn;
	}

	public void setReleaseBtn(JButton releaseBtn) {
		this.releaseBtn = releaseBtn;
	}

	public JButton getEliminationBtn() {
		return eliminationBtn;
	}

	public void setEliminationBtn(JButton eliminationBtn) {
		this.eliminationBtn = eliminationBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public void setCloseBtn(JButton closeBtn) {
		this.closeBtn = closeBtn;
	}

	public JButton getMiniBtn() {
		return miniBtn;
	}

	public void setMiniBtn(JButton miniBtn) {
		this.miniBtn = miniBtn;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public void toggleSound() {
		soundEnabled = !soundEnabled;
	}

	/**
	 * @return the toggleSoundCheckBox
	 */
	public JCheckBox getToggleSoundCheckBox() {
		return toggleSoundCheckBox;
	}

	/**
	 * @param toggleSoundCheckBox the toggleSoundCheckBox to set
	 */
	public void setToggleSoundCheckBox(JCheckBox toggleSoundCheckBox) {
		this.toggleSoundCheckBox = toggleSoundCheckBox;
	}

	/**
	 * @return the soundEnabled
	 */
	public boolean isSoundEnabled() {
		return soundEnabled;
	}

	/**
	 * @param soundEnabled the soundEnabled to set
	 */
	public void setSoundEnabled(boolean soundEnabled) {
		this.soundEnabled = soundEnabled;
	}

	/**
	 * @return the musicStream
	 */
	public Clip getMusicClip() {
		return musicClip;
	}

	/**
	 * @param musicStream the musicStream to set
	 */
	public void setMusicStream(Clip musicClip) {
		this.musicClip = musicClip;
	}

}
