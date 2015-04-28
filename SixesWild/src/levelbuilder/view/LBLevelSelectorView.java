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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import src.levelbuilder.controllers.LBCloseGameController;
import src.levelbuilder.controllers.LBGameTypeBackController;
import src.levelbuilder.controllers.LBMinimizeGameController;
import src.levelbuilder.controllers.LBSelectLevelController;
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
	
	protected JButton newLevelBtn;
	protected ArrayList<JButton> levelButtons;
	protected JLabel titleLable;
	protected int numLevels;
	
	protected LevelBuilderWindow application;
	protected World world;

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
		
		newLevelBtn.addActionListener(new LBSelectLevelController(application, world, null));
		
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
			b.addActionListener(new LBSelectLevelController(application, world, level));
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
		
		eliminationBtn = new BetterButton(Color.decode("#65ABD5"),200, 52, 10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(400, 315, 200, 52);
		eliminationBtn.setForeground(Color.white);
		
		releaseBtn = new BetterButton(Color.decode("#45D7B3"),200, 52, 10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(400, 315, 200, 52);
		releaseBtn.setForeground(Color.white);
		
		if (application.getGameType() == 1) { this.add(puzzleBtn); }
		if (application.getGameType() == 2) { this.add(lightningBtn); }
		if (application.getGameType() == 3) { this.add(releaseBtn); }
		if (application.getGameType() == 4) { this.add(eliminationBtn); }
		
		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 230, 69,
				10);
		lbLabel.setBounds(385, 135, 230, 69);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		this.add(lbLabel);
		
		JScrollPane levelScrollPane = new JScrollPane();
		levelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelScrollPane.setBounds(100, 432, 800, 200);
		this.add(levelScrollPane);
		
		JPanel levelPane = new JPanel();
		levelScrollPane.getViewport().add(levelPane);
		
		newLevelBtn = new BetterButton(Color.decode("#A38F85"),150,150,0);
		newLevelBtn.setBorderPainted(false);
		newLevelBtn.setFocusPainted(false);
		Icon levelIcn = new ImageIcon("resources/LevelSelectorIcon.png");
		Icon plus = new ImageIcon("resources/Plus.png");
		newLevelBtn.setIcon(plus);
		newLevelBtn.setBounds(50, 50, 150, 150);
		newLevelBtn.setPreferredSize(new Dimension(150, 150));
		newLevelBtn.setForeground(Color.white);
		levelPane.add(newLevelBtn);
		
		JLabel newLevelName = new JLabel("New Level");
		newLevelName.setFont(f22);
		newLevelName.setForeground(Color.decode("#A38F85"));
		newLevelName.setBounds(50, 210, 150, 30);
		levelPane.add(newLevelName);
		
		for (int i = 0; i < numLevels; i++) {
			
			JButton levelBtn = new BetterButton (Color.decode("#9B9B9B"),150,150,0);
			levelBtn.setBorderPainted(false);
			levelBtn.setFocusPainted(false);
			levelBtn.setIcon(levelIcn);
			levelBtn.setBounds(50+200*i, 10, 150, 150);
			levelBtn.setPreferredSize(new Dimension(150, 150));
			levelButtons.add(levelBtn);
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
			levelName.setBounds(70 + 150*i, 270, 150, 30);
			levelPane.add(levelName);
		}

		
	}
}
