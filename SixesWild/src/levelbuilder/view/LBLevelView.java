package src.levelbuilder.view;
/**
 * @author Joe Xu
 * @author Halsey Vandenberg
 *
 */
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.levelbuilder.controllers.LBGameTypeBackController;
import src.levelbuilder.controllers.UpdateLevelNameController;
import src.levelbuilder.controllers.UpdateTileRangeController;
import src.sixeswildgame.view.BetterButton;
import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;

import java.awt.Component;

public class LBLevelView extends JPanel {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected JButton backBtn;
	protected String typeName = "Unknown";
	protected BoardView boardView;
	protected Level level;
	protected ArrayList<JCheckBox> tileRangeCheckBoxes;
	protected ArrayList<JCheckBox> specialMovesCheckBoxes;
	protected JLabel levelNameLbl;
	private JTextField lvlNameTextField;
	private JTextField oneStarTextField;
	private JTextField twoStarTextField;
	private JTextField threeStarTextField;
	
	protected JPanel boardPanel;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public LBLevelView(LevelBuilderWindow application, World world, Level level) throws FileNotFoundException, FontFormatException, IOException {
		
		this.application = application;
		this.world = world;
		this.level = level;
		this.tileRangeCheckBoxes = new ArrayList<JCheckBox>();
		this.specialMovesCheckBoxes = new ArrayList<JCheckBox>();
		
		switch (application.gameType) {
		case 1:
			this.typeName = "Puzzle";
			break;
		case 2:
			this.typeName = "Lightning";
			break;
		case 3:
			this.typeName = "Release";
			break;
		case 4:
			this.typeName = "Elimination";
			break;
		default:
			this.typeName = "Unknown";
		}
		
		initialize();	
	}
	
	public void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeView();
		initializeControllers();
	}
	
	public void initializeView () throws FileNotFoundException, FontFormatException, IOException {
		setPreferredSize(new Dimension(1440, 1020));
		this.setLayout(null);
		
		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 301, 89, 10);
		lbLabel.setBounds(570, 32, 301, 89);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		this.add(lbLabel);
		
		BetterButton puzzleBtn = new BetterButton(Color.decode("#D76262"),271,70,15);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		Font f30 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 30);
		puzzleBtn.setFont(f30);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(585, 148, 271, 70);
		puzzleBtn.setForeground(Color.white);
		
		BetterButton lightningBtn = new BetterButton(Color.decode("#3D7CA2"),271,70,15);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f30);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(585, 148, 271, 70);
		lightningBtn.setForeground(Color.white);
		
		BetterButton eliminationBtn = new BetterButton(Color.decode("#65ABD5"),271,70,15);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f30);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(585, 148, 271, 70);
		eliminationBtn.setForeground(Color.white);
		
		BetterButton releaseBtn = new BetterButton(Color.decode("#45D7B3"),271,70,15);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f30);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(585, 148, 271, 70);
		releaseBtn.setForeground(Color.white);
	
		if (application.getGameType() == 1) { this.add(puzzleBtn); }
		if (application.getGameType() == 2) { this.add(lightningBtn); }
		if (application.getGameType() == 3) { this.add(releaseBtn); }
		if (application.getGameType() == 4) { this.add(eliminationBtn); }
		
		backBtn = new BetterButton(Color.decode("#EC7665"),94,58,15);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(50, 30, 94, 58);
		this.add(backBtn); 
		
		BetterButton redoBtn = new BetterButton(Color.decode("#A38F85"), 100, 46, 10);
		redoBtn.setBorderPainted(false);
		redoBtn.setFocusPainted(false);
		redoBtn.setText("Redo");
		Font f20 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 20);
		redoBtn.setFont(f20);
		redoBtn.setForeground(Color.white);
		redoBtn.setBounds(930, 925, 100, 46);
		add(redoBtn);
		
		BetterButton undoBtn = new BetterButton(Color.decode("#A38F85"), 100, 46, 10);
		undoBtn.setBorderPainted(false);
		undoBtn.setFocusPainted(false);
		undoBtn.setText("Undo");
		undoBtn.setFont(f20);
		undoBtn.setForeground(Color.white);
		undoBtn.setBounds(1121, 925, 100, 46);
		add(undoBtn);
		
		JLabel lblLevelName = new JLabel("Level Name:");
		Font f40 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 40);
		lblLevelName.setFont(f40);
		lblLevelName.setForeground(Color.decode("#A38F85"));
		lblLevelName.setBounds(160, 309, 240, 55);
		add(lblLevelName);
		
		lvlNameTextField = new JTextField();
		lvlNameTextField.setBounds(435, 320, 250, 40);
		lvlNameTextField.setBorder(null);
		lvlNameTextField.setFont(f20);
		lvlNameTextField.setForeground(Color.decode("#A38F85"));
		lvlNameTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt namePrompt = new TextPrompt("Enter to name the level.", lvlNameTextField);
		namePrompt.setHorizontalAlignment(TextPrompt.CENTER);
		namePrompt.changeStyle(Font.ITALIC);
		this.add(lvlNameTextField);
		
		JLabel lblTileRange = new JLabel("Tile Range:");
		lblTileRange.setFont(f40);
		lblTileRange.setForeground(Color.decode("#A38F85"));
		lblTileRange.setBounds(159, 404, 204, 55);
		add(lblTileRange);
		
		Icon check1Y = new ImageIcon("resources/Check1Y.png");
		Icon check2Y = new ImageIcon("resources/Check2Y.png");
		Icon check3Y = new ImageIcon("resources/Check3Y.png");
		Icon check4Y = new ImageIcon("resources/Check4Y.png");
		Icon check5Y = new ImageIcon("resources/Check5Y.png");
		Icon check1N = new ImageIcon("resources/Check1N.png");
		Icon check2N = new ImageIcon("resources/Check2N.png");
		Icon check3N = new ImageIcon("resources/Check3N.png");
		Icon check4N = new ImageIcon("resources/Check4N.png");
		Icon check5N = new ImageIcon("resources/Check5N.png");
		
		JCheckBox rangeOneCheckBox = new JCheckBox();
		rangeOneCheckBox.setIcon(check1N);
		rangeOneCheckBox.setSelectedIcon(check1Y);
		rangeOneCheckBox.setSelected(true);
		rangeOneCheckBox.setBounds(432, 414, 45, 41);
		tileRangeCheckBoxes.add(rangeOneCheckBox);
		add(rangeOneCheckBox);
		
		JCheckBox rangeTwoCheckBox = new JCheckBox();
		rangeTwoCheckBox.setIcon(check2N);
		rangeTwoCheckBox.setSelectedIcon(check2Y);
		rangeTwoCheckBox.setSelected(true);
		rangeTwoCheckBox.setBounds(484, 414, 45, 41);
		tileRangeCheckBoxes.add(rangeTwoCheckBox);
		add(rangeTwoCheckBox);
		
		JCheckBox rangeThreeCheckBox = new JCheckBox();
		rangeThreeCheckBox.setIcon(check3N);
		rangeThreeCheckBox.setSelectedIcon(check3Y);
		rangeThreeCheckBox.setSelected(true);
		rangeThreeCheckBox.setBounds(540, 414, 45, 41);
		tileRangeCheckBoxes.add(rangeThreeCheckBox);
		add(rangeThreeCheckBox);
		
		JCheckBox rangeFourCheckBox = new JCheckBox();
		rangeFourCheckBox.setIcon(check4N);
		rangeFourCheckBox.setSelectedIcon(check4Y);
		rangeFourCheckBox.setSelected(true);
		rangeFourCheckBox.setBounds(593, 414, 45, 41);
		tileRangeCheckBoxes.add(rangeFourCheckBox);
		add(rangeFourCheckBox);
		
		JCheckBox rangeFiveCheckBox = new JCheckBox();
		rangeFiveCheckBox.setIcon(check5N);
		rangeFiveCheckBox.setSelectedIcon(check5Y);
		rangeFiveCheckBox.setSelected(true);
		rangeFiveCheckBox.setBounds(646, 414, 45, 41);
		tileRangeCheckBoxes.add(rangeFiveCheckBox);
		add(rangeFiveCheckBox);
		
		JLabel lblNewLabel = new JLabel("Dimensions:");
		lblNewLabel.setFont(f40);
		lblNewLabel.setForeground(Color.decode("#A38F85"));
		lblNewLabel.setBounds(159, 499, 250, 55);
		add(lblNewLabel);
		
		JSlider dimensionsSlider = new JSlider();
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		JLabel label1 = new JLabel("3x3");
		label1.setFont(f20);
		label1.setForeground(Color.decode("#A38F85"));
		JLabel label2 = new JLabel("5x5");
		label2.setFont(f20);
		label2.setForeground(Color.decode("#A38F85"));
		JLabel label3 = new JLabel("7x7");
		label3.setFont(f20);
		label3.setForeground(Color.decode("#A38F85"));
		JLabel label4 = new JLabel("9x9");
		label4.setFont(f20);
		label4.setForeground(Color.decode("#A38F85"));
		labelTable.put( new Integer( 3 ), label1 );
		labelTable.put( new Integer( 5 ), label2 );
		labelTable.put( new Integer( 7 ), label3 );
		labelTable.put( new Integer( 9 ), label4 );
		dimensionsSlider.setMinimum(3);
		dimensionsSlider.setMaximum(9);
		dimensionsSlider.setMajorTickSpacing(2);
		dimensionsSlider.setBorder(null);
		dimensionsSlider.setPaintTicks(true);
		dimensionsSlider.setPaintTrack(true);
		dimensionsSlider.setPaintLabels(true);
		dimensionsSlider.setFont(f20);
		dimensionsSlider.setLabelTable(labelTable);
		dimensionsSlider.setBounds(420, 515, 288, 39);
		add(dimensionsSlider);
		
		JLabel lblRb = new JLabel("Reset Board:");
		lblRb.setFont(f40);
		lblRb.setForeground(Color.decode("#A38F85"));
		lblRb.setBounds(159, 609, 250, 55);
		add(lblRb);
		
		
		JLabel lblSt = new JLabel("Swap Tiles:");
		lblSt.setFont(f40);
		lblSt.setForeground(Color.decode("#A38F85"));
		lblSt.setBounds(159, 704, 210, 55);
		add(lblSt);
		
		JLabel lblRt = new JLabel("Remove Tile:");
		lblRt.setFont(f40);
		lblRt.setForeground(Color.decode("#A38F85"));
		lblRt.setBounds(159, 799, 240, 55);
		add(lblRt);
		
		Icon moveLock = new ImageIcon("resources/MoveLock.png");
		Icon moveUnlock = new ImageIcon("resources/MoveUnlock.png");
		
		JCheckBox checkbxResetBoard = new JCheckBox();
		checkbxResetBoard.setIcon(moveLock);
		checkbxResetBoard.setSelectedIcon(moveUnlock);
		checkbxResetBoard.setSelected(true);
		checkbxResetBoard.setBounds(430, 617, 85, 38);
		add(checkbxResetBoard);
		
		JCheckBox checkbxSwapTiles = new JCheckBox();
		checkbxSwapTiles.setIcon(moveLock);
		checkbxSwapTiles.setSelectedIcon(moveUnlock);
		checkbxSwapTiles.setSelected(true);
		checkbxSwapTiles.setBounds(430, 715, 85, 38);
		add(checkbxSwapTiles);
		
		JCheckBox checkbxRemoveTile = new JCheckBox();
		checkbxRemoveTile.setIcon(moveLock);
		checkbxRemoveTile.setSelectedIcon(moveUnlock);
		checkbxRemoveTile.setSelected(true);
		checkbxRemoveTile.setBounds(430, 810, 85, 38);
		add(checkbxRemoveTile);
		
		JLabel lblBonusFrequency = new JLabel("Bonus Frequency:");
		lblBonusFrequency.setFont(f40);
		lblBonusFrequency.setForeground(Color.decode("#A38F85"));
		lblBonusFrequency.setBounds(159, 894, 345, 55);
		add(lblBonusFrequency);
		
		JSlider frequencySlider = new JSlider();
		Hashtable<Integer, JLabel> frequencySliderTable = new Hashtable<Integer, JLabel>();
		JLabel label5 = new JLabel("Low");
		label5.setFont(f20);
		label5.setForeground(Color.decode("#A38F85"));
		JLabel label6 = new JLabel("Medium");
		label6.setFont(f20);
		label6.setForeground(Color.decode("#A38F85"));
		JLabel label7 = new JLabel("High");
		label7.setFont(f20);
		label7.setForeground(Color.decode("#A38F85"));
		frequencySliderTable.put( new Integer( 2 ), label5 );
		frequencySliderTable.put( new Integer( 4 ), label6 );
		frequencySliderTable.put( new Integer( 6 ), label7 );
		frequencySlider.setMinimum(2);
		frequencySlider.setMaximum(6);
		frequencySlider.setMajorTickSpacing(2);
		frequencySlider.setBorder(null);
		frequencySlider.setPaintTicks(true);
		frequencySlider.setPaintTrack(true);
		frequencySlider.setPaintLabels(true);
		frequencySlider.setLabelTable(frequencySliderTable);
		frequencySlider.setBounds(538, 910, 259, 50);
		add(frequencySlider);
		
		levelNameLbl = new JLabel("Level Name");
		levelNameLbl.setBounds(941, 179, 300, 55);
		levelNameLbl.setHorizontalAlignment(JLabel.CENTER);
		levelNameLbl.setFont(f40);
		levelNameLbl.setForeground(Color.decode("#A38F85"));
		add(levelNameLbl);
		
		boardPanel = new JPanel();
		boardPanel.setBounds(822, 267, 500, 500);
		boardPanel.setBackground(Color.decode("#D4D4D4"));
		this.add(boardPanel);
		
		boardView = new BoardView(level.getBoard(), 50, 50);
		boardView.setPreferredSize(new Dimension(490, 490));
		boardPanel.add(boardView);
		
		Icon starIcon = new ImageIcon("resources/lbStar1.png");
		
		JLabel starLb1 = new JLabel();
		starLb1.setIcon(starIcon);
		starLb1.setBounds(861, 780, 70, 70);
		add(starLb1);
		
		JLabel starLb2 = new JLabel();
		starLb2.setIcon(starIcon);
		starLb2.setBounds(1039, 780, 70, 70);
		add(starLb2);
		
		JLabel starLb3 = new JLabel();
		starLb3.setIcon(starIcon);
		starLb3.setBounds(1214, 780, 70, 70);
		add(starLb3);
		
		oneStarTextField = new JTextField();
		oneStarTextField.setBounds(833, 860, 126, 42);
		oneStarTextField.setBorder(null);
		oneStarTextField.setText("1111");
		oneStarTextField.setFont(f20);
		oneStarTextField.setForeground(Color.decode("#A38F85"));
		oneStarTextField.setHorizontalAlignment(JTextField.CENTER);
		this.add(oneStarTextField);
		
		twoStarTextField = new JTextField();
		twoStarTextField.setBounds(1009, 860, 126, 42);
		twoStarTextField.setBorder(null);
		twoStarTextField.setText("2222");
		twoStarTextField.setFont(f20);
		twoStarTextField.setForeground(Color.decode("#A38F85"));
		twoStarTextField.setHorizontalAlignment(JTextField.CENTER);
		this.add(twoStarTextField);
		
		threeStarTextField = new JTextField();
		threeStarTextField.setBounds(1185, 860, 126, 42);
		threeStarTextField.setBorder(null);
		threeStarTextField.setText("3333");
		threeStarTextField.setFont(f20);
		threeStarTextField.setForeground(Color.decode("#A38F85"));
		threeStarTextField.setHorizontalAlignment(JTextField.CENTER);
		this.add(threeStarTextField);
		
		/*
	
		
		JLabel lblAchievementsThreshold = new JLabel("Achievements Threshold:");
		lblAchievementsThreshold.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		lblAchievementsThreshold.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblAchievementsThreshold = new GridBagConstraints();
		gbc_lblAchievementsThreshold.anchor = GridBagConstraints.EAST;
		gbc_lblAchievementsThreshold.insets = new Insets(0, 0, 5, 5);
		gbc_lblAchievementsThreshold.gridx = 0;
		gbc_lblAchievementsThreshold.gridy = 5;
		levelParametersPanel.add(lblAchievementsThreshold, gbc_lblAchievementsThreshold);
		
		JPanel achievementsPanel = new JPanel();
		achievementsPanel.setPreferredSize(new Dimension(240, 300));
		GridBagConstraints gbc_achievementsPanel = new GridBagConstraints();
		gbc_achievementsPanel.gridwidth = 2;
		gbc_achievementsPanel.fill = GridBagConstraints.BOTH;
		gbc_achievementsPanel.gridx = 0;
		gbc_achievementsPanel.gridy = 6;
		levelParametersPanel.add(achievementsPanel, gbc_achievementsPanel);
		GridBagLayout gbl_achievementsPanel = new GridBagLayout();
		gbl_achievementsPanel.columnWidths = new int[]{159, 155, 150, 0};
		gbl_achievementsPanel.rowHeights = new int[]{10, 0};
		gbl_achievementsPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_achievementsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		achievementsPanel.setLayout(gbl_achievementsPanel);
		
		JPanel oneStarPanel = new JPanel();
		oneStarPanel.setPreferredSize(new Dimension(80, 100));
		GridBagConstraints gbc_oneStarPanel = new GridBagConstraints();
		gbc_oneStarPanel.insets = new Insets(0, 0, 0, 5);
		gbc_oneStarPanel.fill = GridBagConstraints.BOTH;
		gbc_oneStarPanel.gridx = 0;
		gbc_oneStarPanel.gridy = 0;
		achievementsPanel.add(oneStarPanel, gbc_oneStarPanel);
		GridBagLayout gbl_oneStarPanel = new GridBagLayout();
		gbl_oneStarPanel.columnWidths = new int[]{0, 0};
		gbl_oneStarPanel.rowHeights = new int[]{0, 0, 0};
		gbl_oneStarPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_oneStarPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		oneStarPanel.setLayout(gbl_oneStarPanel);
		
		JPanel oneStarImgPanel = new JPanel();
		oneStarImgPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
		GridBagConstraints gbc_oneStarImgPanel = new GridBagConstraints();
		gbc_oneStarImgPanel.insets = new Insets(0, 0, 5, 0);
		gbc_oneStarImgPanel.fill = GridBagConstraints.BOTH;
		gbc_oneStarImgPanel.gridx = 0;
		gbc_oneStarImgPanel.gridy = 0;
		oneStarPanel.add(oneStarImgPanel, gbc_oneStarImgPanel);
		BufferedImage oneStarImg;
		try {
			oneStarImg = ImageIO.read(new File("resources/oneStar.png"));
			JLabel img = new JLabel(new ImageIcon(oneStarImg));
			oneStarImgPanel.add(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		oneStarTextField = new JTextField();
		oneStarTextField.setHorizontalAlignment(SwingConstants.CENTER);
		oneStarTextField.setText("0000");
		GridBagConstraints gbc_oneStarTextField = new GridBagConstraints();
		gbc_oneStarTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_oneStarTextField.gridx = 0;
		gbc_oneStarTextField.gridy = 1;
		oneStarPanel.add(oneStarTextField, gbc_oneStarTextField);
		oneStarTextField.setColumns(10);
		
		JPanel twoStarPanel = new JPanel();
		twoStarPanel.setPreferredSize(new Dimension(80, 100));
		GridBagConstraints gbc_twoStarPanel = new GridBagConstraints();
		gbc_twoStarPanel.insets = new Insets(0, 0, 0, 5);
		gbc_twoStarPanel.fill = GridBagConstraints.BOTH;
		gbc_twoStarPanel.gridx = 1;
		gbc_twoStarPanel.gridy = 0;
		achievementsPanel.add(twoStarPanel, gbc_twoStarPanel);
		GridBagLayout gbl_twoStarPanel = new GridBagLayout();
		gbl_twoStarPanel.columnWidths = new int[]{0, 0};
		gbl_twoStarPanel.rowHeights = new int[]{0, 0, 0};
		gbl_twoStarPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_twoStarPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		twoStarPanel.setLayout(gbl_twoStarPanel);
		
		JPanel twoStarImgPanel = new JPanel();
		twoStarImgPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
		GridBagConstraints gbc_twoStarImgPanel = new GridBagConstraints();
		gbc_twoStarImgPanel.insets = new Insets(0, 0, 5, 0);
		gbc_twoStarImgPanel.fill = GridBagConstraints.BOTH;
		gbc_twoStarImgPanel.gridx = 0;
		gbc_twoStarImgPanel.gridy = 0;
		twoStarPanel.add(twoStarImgPanel, gbc_twoStarImgPanel);
		BufferedImage twoStarImg;
		try {
			twoStarImg = ImageIO.read(new File("resources/twoStar.png"));
			JLabel img2 = new JLabel(new ImageIcon(twoStarImg));
			twoStarImgPanel.add(img2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		twoStarTextField = new JTextField();
		twoStarTextField.setHorizontalAlignment(SwingConstants.CENTER);
		twoStarTextField.setText("1111");
		GridBagConstraints gbc_twoStarTextField = new GridBagConstraints();
		gbc_twoStarTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_twoStarTextField.gridx = 0;
		gbc_twoStarTextField.gridy = 1;
		twoStarPanel.add(twoStarTextField, gbc_twoStarTextField);
		twoStarTextField.setColumns(10);
		
		JPanel threeStarPanel = new JPanel();
		threeStarPanel.setPreferredSize(new Dimension(80, 100));
		GridBagConstraints gbc_threeStarPanel = new GridBagConstraints();
		gbc_threeStarPanel.fill = GridBagConstraints.BOTH;
		gbc_threeStarPanel.gridx = 2;
		gbc_threeStarPanel.gridy = 0;
		achievementsPanel.add(threeStarPanel, gbc_threeStarPanel);
		GridBagLayout gbl_threeStarPanel = new GridBagLayout();
		gbl_threeStarPanel.columnWidths = new int[]{0, 0};
		gbl_threeStarPanel.rowHeights = new int[]{0, 0, 0};
		gbl_threeStarPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_threeStarPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		threeStarPanel.setLayout(gbl_threeStarPanel);
		
		JPanel threeStarImgPanel = new JPanel();
		threeStarImgPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
		GridBagConstraints gbc_threeStarImgPanel = new GridBagConstraints();
		gbc_threeStarImgPanel.insets = new Insets(0, 0, 5, 0);
		gbc_threeStarImgPanel.fill = GridBagConstraints.BOTH;
		gbc_threeStarImgPanel.gridx = 0;
		gbc_threeStarImgPanel.gridy = 0;
		threeStarPanel.add(threeStarImgPanel, gbc_threeStarImgPanel);
		BufferedImage threeStarImg;
		try {
			threeStarImg = ImageIO.read(new File("resources/threeStar.png"));
			JLabel img3 = new JLabel(new ImageIcon(threeStarImg));
			threeStarImgPanel.add(img3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		threeStarTextField = new JTextField();
		threeStarTextField.setHorizontalAlignment(SwingConstants.CENTER);
		threeStarTextField.setText("2222");
		GridBagConstraints gbc_threeStarTextField = new GridBagConstraints();
		gbc_threeStarTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_threeStarTextField.gridx = 0;
		gbc_threeStarTextField.gridy = 1;
		threeStarPanel.add(threeStarTextField, gbc_threeStarTextField);
		threeStarTextField.setColumns(10);
		
		JPanel previewPanel = new JPanel();
		previewPanel.setPreferredSize(new Dimension(490, 500));
		GridBagConstraints gbc_previewPanel = new GridBagConstraints();
		gbc_previewPanel.insets = new Insets(0, 0, 5, 0);
		gbc_previewPanel.fill = GridBagConstraints.BOTH;
		gbc_previewPanel.gridx = 2;
		gbc_previewPanel.gridy = 1;
		add(previewPanel, gbc_previewPanel);
		GridBagLayout gbl_previewPanel = new GridBagLayout();
		gbl_previewPanel.columnWidths = new int[]{0, 0};
		gbl_previewPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_previewPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_previewPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		previewPanel.setLayout(gbl_previewPanel);
		
		levelNameLbl = new JLabel("\"Level Name\"");
		levelNameLbl.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		GridBagConstraints gbc_levelNameLbl = new GridBagConstraints();
		gbc_levelNameLbl.insets = new Insets(0, 0, 5, 0);
		gbc_levelNameLbl.gridx = 0;
		gbc_levelNameLbl.gridy = 0;
		previewPanel.add(levelNameLbl, gbc_levelNameLbl);
		
		boardPanel = new JPanel();
		boardPanel.setPreferredSize(new Dimension(490, 490));
		GridBagConstraints gbc_boardPanel = new GridBagConstraints();
		gbc_boardPanel.insets = new Insets(0, 0, 5, 0);
		gbc_boardPanel.fill = GridBagConstraints.BOTH;
		gbc_boardPanel.gridx = 0;
		gbc_boardPanel.gridy = 1;
		previewPanel.add(boardPanel, gbc_boardPanel);
		boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		boardView = new BoardView(level.getBoard(), 50, 50);
		boardView.setPreferredSize(new Dimension(490, 490));
		boardPanel.add(boardView);
		
		JPanel boardBtnPanel = new JPanel();
		GridBagConstraints gbc_boardBtnPanel = new GridBagConstraints();
		gbc_boardBtnPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_boardBtnPanel.gridx = 0;
		gbc_boardBtnPanel.gridy = 2;
		previewPanel.add(boardBtnPanel, gbc_boardBtnPanel);
		
		JButton redoBtn = new JButton("Redo");
		GridBagConstraints gbc_redoBtn = new GridBagConstraints();
		gbc_redoBtn.anchor = GridBagConstraints.WEST;
		gbc_redoBtn.gridx = 0;
		gbc_redoBtn.gridy = 0;
		boardBtnPanel.add(redoBtn, gbc_redoBtn);
		
		JButton saveBtn = new JButton("Save");
		boardBtnPanel.add(saveBtn);
		
		JButton undoBtn = new JButton("Undo");
		boardBtnPanel.add(undoBtn);*/
	}
	
	public void initializeControllers() {
		backBtn.addActionListener(new LBGameTypeBackController(application, world));
		for (JCheckBox checkBox : tileRangeCheckBoxes) {
			checkBox.addActionListener(new UpdateTileRangeController(application, level, checkBox));
		}
		lvlNameTextField.getDocument().addDocumentListener(new UpdateLevelNameController(application, level, lvlNameTextField));
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
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the boardView
	 */
	public BoardView getBoardView() {
		return boardView;
	}

	/**
	 * @param boardView the boardView to set
	 */
	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the tileRangeCheckBoxes
	 */
	public ArrayList<JCheckBox> getTileRangeCheckBoxes() {
		return tileRangeCheckBoxes;
	}

	/**
	 * @param tileRangeCheckBoxes the tileRangeCheckBoxes to set
	 */
	public void setTileRangeCheckBoxes(ArrayList<JCheckBox> tileRangeCheckBoxes) {
		this.tileRangeCheckBoxes = tileRangeCheckBoxes;
	}

	/**
	 * @return the lvlNameTextField
	 */
	public JTextField getLvlNameTextField() {
		return lvlNameTextField;
	}

	/**
	 * @param lvlNameTextField the lvlNameTextField to set
	 */
	public void setLvlNameTextField(JTextField lvlNameTextField) {
		this.lvlNameTextField = lvlNameTextField;
	}

	/**
	 * @return the oneStarTextField
	 */
	public JTextField getOneStarTextField() {
		return oneStarTextField;
	}

	/**
	 * @param oneStarTextField the oneStarTextField to set
	 */
	public void setOneStarTextField(JTextField oneStarTextField) {
		this.oneStarTextField = oneStarTextField;
	}

	/**
	 * @return the twoStarTextField
	 */
	public JTextField getTwoStarTextField() {
		return twoStarTextField;
	}

	/**
	 * @param twoStarTextField the twoStarTextField to set
	 */
	public void setTwoStarTextField(JTextField twoStarTextField) {
		this.twoStarTextField = twoStarTextField;
	}

	/**
	 * @return the threeStarTextField
	 */
	public JTextField getThreeStarTextField() {
		return threeStarTextField;
	}

	/**
	 * @param threeStarTextField the threeStarTextField to set
	 */
	public void setThreeStarTextField(JTextField threeStarTextField) {
		this.threeStarTextField = threeStarTextField;
	}

	/**
	 * @return the boardPanel
	 */
	public JPanel getBoardPanel() {
		return boardPanel;
	}

	/**
	 * @param boardPanel the boardPanel to set
	 */
	public void setBoardPanel(JPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	/**
	 * @return the specialMovesCheckBoxes
	 */
	public ArrayList<JCheckBox> getSpecialMovesCheckBoxes() {
		return specialMovesCheckBoxes;
	}

	/**
	 * @param specialMovesCheckBoxes the specialMovesCheckBoxes to set
	 */
	public void setSpecialMovesCheckBoxes(
			ArrayList<JCheckBox> specialMovesCheckBoxes) {
		this.specialMovesCheckBoxes = specialMovesCheckBoxes;
	}

	/**
	 * @return the levelNameLbl
	 */
	public JLabel getLevelNameLbl() {
		return levelNameLbl;
	}

	/**
	 * @param levelNameLbl the levelNameLbl to set
	 */
	public void setLevelNameLbl(JLabel levelNameLbl) {
		this.levelNameLbl = levelNameLbl;
	}


	

}
