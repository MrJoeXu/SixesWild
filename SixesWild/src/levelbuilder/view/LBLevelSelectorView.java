package src.levelbuilder.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import src.levelbuilder.controllers.DeleteLevelController;
import src.levelbuilder.controllers.LBCloseGameController;
import src.levelbuilder.controllers.LBGameTypeBackController;
import src.levelbuilder.controllers.LBMinimizeGameController;
import src.levelbuilder.controllers.LBBuildLevelController;
import src.levelbuilder.controllers.SelectLevelController;
import src.levelbuilder.controllers.ToggleSoundController;
import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.view.BetterButton;
import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.PuzzleLevel;
import src.sixeswildgame.world.World;

public class LBLevelSelectorView extends JPanel {
	
	protected JButton closeBtn;
	protected JButton miniBtn;
	protected JButton backBtn;
	
	protected JButton puzzleBtn;
	protected JButton lightningBtn;
	protected JButton eliminationBtn;
	protected JButton releaseBtn;
	protected BetterButton deleteLevelBtn;
	protected BetterButton buildLevelBtn;
	
	protected JButton newLevelBtn;
	protected ArrayList<JButton> levelButtons;
	protected JLabel titleLable;
	protected int numLevels;
	protected Level selectedLevel;
	protected JLabel pleaseLabel;
	
	protected LevelBuilderWindow application;
	protected World world;
	protected JCheckBox toggleSoundCheckBox;

	public LBLevelSelectorView(LevelBuilderWindow application, World world) throws FileNotFoundException, FontFormatException, IOException {
		this.application = application;
		this.world = world;
		this.levelButtons = new ArrayList<JButton>();
		initialize();
	}

	public void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeModel();
		initializeView();
		initializeController();
	}

	private void initializeController() {
		backBtn.addActionListener(new LBGameTypeBackController(application,
				world));
		closeBtn.addActionListener(new LBCloseGameController(world, application));
		miniBtn.addActionListener(new LBMinimizeGameController(world,application));
		
		newLevelBtn.addActionListener(new LBBuildLevelController(application, world, null, 0));
		deleteLevelBtn.addActionListener(new DeleteLevelController(world, application, selectedLevel));
		
		buildLevelBtn.addActionListener(new LBBuildLevelController(application, world, selectedLevel, 1));
		toggleSoundCheckBox.addActionListener(new ToggleSoundController(application));
		
		Level level;
		int nextId = new File("saveddata/custom/" + application.getGameTypeName()).listFiles().length;
		int i = 0;
		
		for (JButton b : levelButtons) {
			switch (application.getGameType()) {
			case 1:
				level = world.getPuzzleLevels().get(i);
				break;
			case 2:
				level = world.getLightningLevels().get(i);
				break;
			case 3:
				level = world.getReleaseLevels().get(i);
				break;
			case 4:
				level = world.getEliminationLevels().get(i);
				break;
			default:
				level = new Level(new Board(9), nextId, application.getGameTypeName());
			}
			b.addMouseListener(new SelectLevelController(b, application, level));
			i++;
		}
		
	}

	private void initializeModel() {
		
		numLevels = new File("saveddata/custom/" + application.getGameTypeName()).listFiles().length;
		System.out.println("NumLevels: " + numLevels);
		
	}

	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		setPreferredSize(new Dimension(1000, 708));
		this.setLayout(null);
		
		JLabel titleLable = new JLabel("Please Select a Level");
		Font f45 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 45);
		titleLable.setFont(f45);
		titleLable.setBounds(286, 229, 435, 61);
		titleLable.setForeground(Color.decode("#A38F85"));
		this.add(titleLable);
		
		backBtn = new BetterButton(Color.decode("#EC7665"), 65, 40, 10);
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
		
		Font f22 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 22);
		Font f25 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 25);
		Font f14 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 14);
		
		Icon sound = new ImageIcon("resources/sound.png");
		Icon mute = new ImageIcon("resources/mute.png");
		toggleSoundCheckBox = new JCheckBox();
		toggleSoundCheckBox.setIcon(mute);
		toggleSoundCheckBox.setSelectedIcon(sound);
		toggleSoundCheckBox.setSelected(application.isSoundEnabled());
		toggleSoundCheckBox.setBounds(650, 140, 52, 52);
		this.add(toggleSoundCheckBox);
		
		puzzleBtn = new BetterButton(Color.decode("#D76262"),200, 52, 10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(400, 315, 200, 52);
		puzzleBtn.setForeground(Color.white);
		
		lightningBtn = new BetterButton(Color.decode("#3D7CA2"),200, 52, 10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(400, 315, 200, 52);
		lightningBtn.setForeground(Color.white);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),200, 52, 10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(400, 315, 200, 52);
		releaseBtn.setForeground(Color.white);
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),200, 52, 10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(400, 315, 200, 52);
		eliminationBtn.setForeground(Color.white);

		Icon build = new ImageIcon("resources/Leave.png");
		buildLevelBtn = new BetterButton(Color.decode("#50E3C2"),50, 50, 10);
		buildLevelBtn.setBorderPainted(false);
		buildLevelBtn.setFocusPainted(false);
		buildLevelBtn.setIcon(build);
		buildLevelBtn.setBounds(525, 624, 50, 50);
		buildLevelBtn.setForeground(Color.white);
		this.add(buildLevelBtn);
		
		Icon delete = new ImageIcon("resources/Trash.png");
		deleteLevelBtn = new BetterButton(Color.decode("#D76262"),50, 50, 10);
		deleteLevelBtn.setBorderPainted(false);
		deleteLevelBtn.setFocusPainted(false);
		deleteLevelBtn.setIcon(delete);
		deleteLevelBtn.setBounds(425, 624, 50, 50);
		this.add(deleteLevelBtn);
		
		if (application.getGameType() == 1) { 
			this.add(puzzleBtn);
			buildLevelBtn.setCol(Color.decode("#D76262"));
			deleteLevelBtn.setCol(Color.decode("#D76262"));
			}
		if (application.getGameType() == 2) { 
			this.add(lightningBtn);
			buildLevelBtn.setCol(Color.decode("#3D7CA2"));
			deleteLevelBtn.setCol(Color.decode("#3D7CA2"));
			} 
		if (application.getGameType() == 3) { 
			this.add(releaseBtn);
			buildLevelBtn.setCol(Color.decode("#45D7B3"));
			deleteLevelBtn.setCol(Color.decode("#45D7B3"));
			}
		if (application.getGameType() == 4) { 
			this.add(eliminationBtn);
			buildLevelBtn.setCol(Color.decode("#65ABD5"));
			deleteLevelBtn.setCol(Color.decode("#65ABD5"));
			}
		
		
		pleaseLabel = new JLabel("Please select a level.");
		pleaseLabel.setFont(f14);
		pleaseLabel.setForeground(Color.decode("#9B9B9B"));
		pleaseLabel.setBounds(435, 675, 150, 30);
		this.add(pleaseLabel);
		pleaseLabel.setVisible(false);
		
		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 230, 69,
				10);
		lbLabel.setBounds(385, 135, 230, 69);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		this.add(lbLabel);
		
		JPanel levelPane = new JPanel();
		levelPane.setLayout(null);
		levelPane.setPreferredSize(new Dimension(700, 200));
		levelPane.setBackground(Color.decode("#D8D8D8"));
		
		JScrollPane levelScrollPane = new JScrollPane();
		levelScrollPane.setBorder(null);
		levelScrollPane.setBackground(Color.decode("#D8D8D8"));
		levelScrollPane.getHorizontalScrollBar().setUI(new BetterScrollBar());
		levelScrollPane.setViewportView(levelPane);
		levelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		levelScrollPane.setBounds(138, 407, 700, 200);
		this.add(levelScrollPane);
	
		newLevelBtn = new BetterButton(Color.decode("#9B9B9B"),100,100,10);
		newLevelBtn.setBorderPainted(false);
		newLevelBtn.setFocusPainted(false);
		
		Icon plus = new ImageIcon("resources/Plus.png");
		newLevelBtn.setIcon(plus);
		newLevelBtn.setBounds(62, 25, 100, 100);
		newLevelBtn.setForeground(Color.white);
		levelPane.add(newLevelBtn);
		
		JLabel newLevelName = new JLabel("New Level");
		newLevelName.setFont(f22);
		newLevelName.setForeground(Color.decode("#9B9B9B"));
		newLevelName.setBounds(60, 142, 150, 30);
		levelPane.add(newLevelName);
		
		for (int i = 0; i < numLevels; i++) {
			Icon levelIcn = new ImageIcon("resources/LevelSelectorIcon.png");
			JButton levelBtn = new BetterButton (Color.decode("#A38F85"),100,100,10);
			levelBtn.setBorderPainted(false);
			levelBtn.setFocusPainted(false);
			levelBtn.setIcon(levelIcn);
			levelBtn.setBounds(227+165*i, 27, 100, 100);
			levelBtn.setPreferredSize(new Dimension(150, 150));
			levelButtons.add(levelBtn);
			levelPane.setPreferredSize(new Dimension(350+i*165, 200));
			levelPane.add(levelBtn);
			
			String name;
			
			switch (application.getGameType()) {
			case 1:
				name = world.getPuzzleLevels().get(i).getName();
				break;
			case 2:
				name = world.getLightningLevels().get(i).getName();
				break;
			case 3:
				name = world.getReleaseLevels().get(i).getName();
				break;
			case 4:
				name = world.getEliminationLevels().get(i).getName();
				break;
			default:
				name = "Unknown";
			}
			
			JLabel levelName = new JLabel(name);
			levelName.setFont(f22);
			levelName.setForeground(Color.decode("#A38F85"));
			levelName.setBounds(243 + 165*i, 142, 150, 30);
			levelPane.add(levelName);
		}

		
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
	 * @return the deleteLevelBtn
	 */
	public JButton getDeleteLevelBtn() {
		return deleteLevelBtn;
	}

	/**
	 * @param deleteLevelBtn the deleteLevelBtn to set
	 */
	public void setDeleteLevelBtn(BetterButton deleteLevelBtn) {
		this.deleteLevelBtn = deleteLevelBtn;
	}

	/**
	 * @return the buildLevelBtn
	 */
	public BetterButton getBuildLevelBtn() {
		return buildLevelBtn;
	}

	/**
	 * @param buildLevelBtn the buildLevelBtn to set
	 */
	public void setBuildLevelBtn(BetterButton buildLevelBtn) {
		this.buildLevelBtn = buildLevelBtn;
	}

	/**
	 * @return the newLevelBtn
	 */
	public JButton getNewLevelBtn() {
		return newLevelBtn;
	}

	/**
	 * @param newLevelBtn the newLevelBtn to set
	 */
	public void setNewLevelBtn(JButton newLevelBtn) {
		this.newLevelBtn = newLevelBtn;
	}

	/**
	 * @return the levelButtons
	 */
	public ArrayList<JButton> getLevelButtons() {
		return levelButtons;
	}

	/**
	 * @param levelButtons the levelButtons to set
	 */
	public void setLevelButtons(ArrayList<JButton> levelButtons) {
		this.levelButtons = levelButtons;
	}

	/**
	 * @return the titleLable
	 */
	public JLabel getTitleLable() {
		return titleLable;
	}

	/**
	 * @param titleLable the titleLable to set
	 */
	public void setTitleLable(JLabel titleLable) {
		this.titleLable = titleLable;
	}

	/**
	 * @return the numLevels
	 */
	public int getNumLevels() {
		return numLevels;
	}

	/**
	 * @param numLevels the numLevels to set
	 */
	public void setNumLevels(int numLevels) {
		this.numLevels = numLevels;
	}

	/**
	 * @return the selectedLevel
	 */
	public Level getSelectedLevel() {
		return selectedLevel;
	}

	/**
	 * @param selectedLevel the selectedLevel to set
	 */
	public void setSelectedLevel(Level selectedLevel) {
		this.selectedLevel = selectedLevel;
	}

	/**
	 * @return the application
	 */
	public LevelBuilderWindow getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(LevelBuilderWindow application) {
		this.application = application;
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
	 * @return the pleaseLabel
	 */
	public JLabel getPleaseLabel() {
		return pleaseLabel;
	}

	/**
	 * @param pleaseLabel the pleaseLabel to set
	 */
	public void setPleaseLabel(JLabel pleaseLabel) {
		this.pleaseLabel = pleaseLabel;
	}
	
	
	
}
