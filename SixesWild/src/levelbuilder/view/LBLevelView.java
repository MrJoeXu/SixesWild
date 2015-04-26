package src.levelbuilder.view;

/**
 * @author Joe Xu
 * @author Halsey Vandenberg
 * @author Tiffany Leung
 *
 */
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.levelbuilder.controllers.LBCloseGameController;
import src.levelbuilder.controllers.LBGameTypeBackController;
import src.levelbuilder.controllers.LBMinimizeGameController;
import src.levelbuilder.controllers.UpdateDimensionController;
import src.levelbuilder.controllers.UpdateLevelNameController;
import src.levelbuilder.controllers.UpdateMinuteController;
import src.levelbuilder.controllers.UpdateMovesLeftController;
import src.levelbuilder.controllers.UpdateOneStarController;
import src.levelbuilder.controllers.UpdateRemoveTileController;
import src.levelbuilder.controllers.UpdateResetBoardController;
import src.levelbuilder.controllers.UpdateSecondsController;
import src.levelbuilder.controllers.UpdateSwapTilesController;
import src.levelbuilder.controllers.UpdateThreeStarController;
import src.levelbuilder.controllers.UpdateTileRangeController;
import src.levelbuilder.controllers.UpdateTwoStarController;
import src.levelbuilder.world.ToggleSpaceMove;
import src.sixeswildgame.view.BetterButton;
import src.sixeswildgame.view.BetterLabel;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
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

import javax.swing.text.JTextComponent;

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
	protected JSlider dimensionSlider;
	protected JTextField timerMinuteTextField;
	protected JCheckBox checkbxResetBoard;
	protected JCheckBox checkbxSwapTiles;
	protected JCheckBox checkbxRemoveTile;
	protected JTextField movesLeftTextField;
	private JTextField lvlNameTextField;
	private JTextField oneStarTextField;
	private JTextField twoStarTextField;
	private JTextField threeStarTextField;

	protected JButton closeBtn;
	protected JButton miniBtn;

	protected JPanel boardPanel;
	private JTextField timerSecondTextField;
	private JTextField resetBoardTextField;
	private JTextField swapTilesTextField;
	private JTextField removeTileTextField;

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 * @throws FileNotFoundException
	 */
	public LBLevelView(LevelBuilderWindow application, World world, Level level)
			throws FileNotFoundException, FontFormatException, IOException {

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

	public void initialize() throws FileNotFoundException, FontFormatException,
			IOException {
		initializeView();
		initializeControllers();
	}

	public void initializeView() throws FileNotFoundException,
			FontFormatException, IOException {
		setPreferredSize(new Dimension(1000, 708));
		this.setLayout(null);

		BetterLabel lbLabel = new BetterLabel(Color.decode("#A38F85"), 230, 69,
				10);
		lbLabel.setBounds(385, 26, 230, 69);
		lbLabel.setLayout(null);
		Icon Builder = new ImageIcon("resources/Level BuilderButton.png");
		lbLabel.setIcon(Builder);
		lbLabel.setHorizontalAlignment(BetterLabel.CENTER);
		lbLabel.setVerticalAlignment(BetterLabel.CENTER);
		this.add(lbLabel);

		Font f22 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 22);

		BetterButton puzzleBtn = new BetterButton(Color.decode("#D76262"), 200,
				52, 10);
		puzzleBtn.setBorderPainted(false);
		puzzleBtn.setFocusPainted(false);
		puzzleBtn.setFont(f22);
		puzzleBtn.setText("Puzzle");
		puzzleBtn.setBounds(400, 112, 200, 52);
		puzzleBtn.setForeground(Color.white);

		BetterButton lightningBtn = new BetterButton(Color.decode("#3D7CA2"),
				200, 52, 10);
		lightningBtn.setBorderPainted(false);
		lightningBtn.setFocusPainted(false);
		lightningBtn.setFont(f22);
		lightningBtn.setText("Lightning");
		lightningBtn.setBounds(400, 112, 200, 52);
		lightningBtn.setForeground(Color.white);

		BetterButton eliminationBtn = new BetterButton(Color.decode("#65ABD5"),
				200, 52, 10);
		eliminationBtn.setBorderPainted(false);
		eliminationBtn.setFocusPainted(false);
		eliminationBtn.setFont(f22);
		eliminationBtn.setText("Elimination");
		eliminationBtn.setBounds(400, 112, 200, 52);
		eliminationBtn.setForeground(Color.white);

		BetterButton releaseBtn = new BetterButton(Color.decode("#45D7B3"),
				200, 52, 10);
		releaseBtn.setBorderPainted(false);
		releaseBtn.setFocusPainted(false);
		releaseBtn.setFont(f22);
		releaseBtn.setText("Release");
		releaseBtn.setBounds(400, 112, 200, 52);
		releaseBtn.setForeground(Color.white);

		if (application.getGameType() == 1) {
			this.add(puzzleBtn);
		}
		if (application.getGameType() == 2) {
			this.add(lightningBtn);
		}
		if (application.getGameType() == 3) {
			this.add(releaseBtn);
		}
		if (application.getGameType() == 4) {
			this.add(eliminationBtn);
		}

		backBtn = new BetterButton(Color.decode("#EC7665"), 65, 40, 10);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(30, 20, 65, 40);
		this.add(backBtn);

		BetterButton redoBtn = new BetterButton(Color.decode("#A38F85"), 80,
				34, 10);
		redoBtn.setBorderPainted(false);
		redoBtn.setFocusPainted(false);
		redoBtn.setText("Redo");
		Font f14 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 14);
		redoBtn.setFont(f14);
		redoBtn.setForeground(Color.white);
		redoBtn.setBounds(675, 643, 80, 34);
		add(redoBtn);

		BetterButton undoBtn = new BetterButton(Color.decode("#A38F85"), 80,
				34, 10);
		undoBtn.setBorderPainted(false);
		undoBtn.setFocusPainted(false);
		undoBtn.setText("Undo");
		undoBtn.setFont(f14);
		undoBtn.setForeground(Color.white);
		undoBtn.setBounds(815, 643, 80, 34);
		add(undoBtn);

		BetterButton saveBtn = new BetterButton(Color.decode("#A38F85"), 40,
				40, 10);
		Icon save = new ImageIcon("resources/save.png");
		saveBtn.setIcon(save);
		saveBtn.setBorderPainted(false);
		saveBtn.setFocusPainted(false);
		saveBtn.setFont(f14);
		saveBtn.setForeground(Color.white);
		saveBtn.setBounds(765, 637, 40, 40);
		add(saveBtn);

		JLabel lblLevelName = new JLabel("Level Name:");
		Font f30 = Font.createFont(
				Font.TRUETYPE_FONT,
				new FileInputStream(new File(
						"resources/avenir-next-regular.ttf"))).deriveFont(
				Font.PLAIN, 30);
		lblLevelName.setFont(f30);
		lblLevelName.setForeground(Color.decode("#A38F85"));
		lblLevelName.setBounds(63, 180, 178, 41);
		add(lblLevelName);

		lvlNameTextField = new JTextField();
		lvlNameTextField.setBounds(268, 185, 210, 34);
		lvlNameTextField.setBorder(null);
		lvlNameTextField.setFont(f14);
		lvlNameTextField.setForeground(Color.decode("#A38F85"));
		lvlNameTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt namePrompt = new TextPrompt("Enter to name the level.",
				lvlNameTextField);
		namePrompt.setHorizontalAlignment(TextPrompt.CENTER);
		namePrompt.changeStyle(Font.ITALIC);
		this.add(lvlNameTextField);

		JLabel lblTileRange = new JLabel("Tile Range:");
		lblTileRange.setFont(f30);
		lblTileRange.setForeground(Color.decode("#A38F85"));
		lblTileRange.setBounds(63, 241, 161, 41);
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
		rangeOneCheckBox.setBounds(268, 247, 40, 34);
		tileRangeCheckBoxes.add(rangeOneCheckBox);
		add(rangeOneCheckBox);

		JCheckBox rangeTwoCheckBox = new JCheckBox();
		rangeTwoCheckBox.setIcon(check2N);
		rangeTwoCheckBox.setSelectedIcon(check2Y);
		rangeTwoCheckBox.setSelected(true);
		rangeTwoCheckBox.setBounds(309, 247, 40, 34);
		tileRangeCheckBoxes.add(rangeTwoCheckBox);
		add(rangeTwoCheckBox);

		JCheckBox rangeThreeCheckBox = new JCheckBox();
		rangeThreeCheckBox.setIcon(check3N);
		rangeThreeCheckBox.setSelectedIcon(check3Y);
		rangeThreeCheckBox.setSelected(true);
		rangeThreeCheckBox.setBounds(350, 247, 40, 34);
		tileRangeCheckBoxes.add(rangeThreeCheckBox);
		add(rangeThreeCheckBox);

		JCheckBox rangeFourCheckBox = new JCheckBox();
		rangeFourCheckBox.setIcon(check4N);
		rangeFourCheckBox.setSelectedIcon(check4Y);
		rangeFourCheckBox.setSelected(true);
		rangeFourCheckBox.setBounds(391, 247, 40, 34);
		tileRangeCheckBoxes.add(rangeFourCheckBox);
		add(rangeFourCheckBox);

		JCheckBox rangeFiveCheckBox = new JCheckBox();
		rangeFiveCheckBox.setIcon(check5N);
		rangeFiveCheckBox.setSelectedIcon(check5Y);
		rangeFiveCheckBox.setSelected(true);
		rangeFiveCheckBox.setBounds(432, 247, 40, 34);
		tileRangeCheckBoxes.add(rangeFiveCheckBox);
		add(rangeFiveCheckBox);

		JLabel lblNewLabel = new JLabel("Dimensions:");
		lblNewLabel.setFont(f30);
		lblNewLabel.setForeground(Color.decode("#A38F85"));
		lblNewLabel.setBounds(63, 302, 180, 41);
		add(lblNewLabel);

		dimensionSlider = new JSlider();
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		JLabel label1 = new JLabel("3x3");
		label1.setFont(f14);
		label1.setForeground(Color.decode("#A38F85"));
		JLabel label2 = new JLabel("5x5");
		label2.setFont(f14);
		label2.setForeground(Color.decode("#A38F85"));
		JLabel label3 = new JLabel("7x7");
		label3.setFont(f14);
		label3.setForeground(Color.decode("#A38F85"));
		JLabel label4 = new JLabel("9x9");
		label4.setFont(f14);
		label4.setForeground(Color.decode("#A38F85"));
		labelTable.put(new Integer(3), label1);
		labelTable.put(new Integer(5), label2);
		labelTable.put(new Integer(7), label3);
		labelTable.put(new Integer(9), label4);
		dimensionSlider.setMinimum(3);
		dimensionSlider.setMaximum(9);
		dimensionSlider.setMajorTickSpacing(1);
		dimensionSlider.setBorder(null);
		dimensionSlider.setPaintTicks(true);
		dimensionSlider.setPaintTrack(true);
		dimensionSlider.setPaintLabels(true);
		dimensionSlider.setFont(f14);
		dimensionSlider.setLabelTable(labelTable);
		dimensionSlider.setBounds(268, 314, 200, 50);
		add(dimensionSlider);

		JLabel lblRb = new JLabel("Reset Board:");
		lblRb.setFont(f30);
		lblRb.setForeground(Color.decode("#A38F85"));
		lblRb.setBounds(63, 363, 185, 41);
		add(lblRb);

		JLabel lblSt = new JLabel("Swap Tiles:");
		lblSt.setFont(f30);
		lblSt.setForeground(Color.decode("#A38F85"));
		lblSt.setBounds(63, 424, 160, 41);
		add(lblSt);

		JLabel lblRt = new JLabel("Remove Tile:");
		lblRt.setFont(f30);
		lblRt.setForeground(Color.decode("#A38F85"));
		lblRt.setBounds(63, 485, 240, 55);
		add(lblRt);

		Icon moveLock = new ImageIcon("resources/MoveLock.png");
		Icon moveUnlock = new ImageIcon("resources/MoveUnlock.png");

		checkbxResetBoard = new JCheckBox();
		checkbxResetBoard.setIcon(moveLock);
		checkbxResetBoard.setSelectedIcon(moveUnlock);
		checkbxResetBoard.setSelected(false);
		checkbxResetBoard.setBounds(268, 371, 55, 30);
		add(checkbxResetBoard);

		resetBoardTextField = new JTextField();
		resetBoardTextField.setHorizontalAlignment(SwingConstants.CENTER);
		resetBoardTextField.setForeground(new Color(163, 143, 133));
		resetBoardTextField.setFont(null);
		resetBoardTextField.setBorder(null);
		resetBoardTextField.setBounds(344, 370, 46, 34);
		resetBoardTextField.setEnabled(checkbxResetBoard.isSelected());
		TextPrompt resetBoardPrompt = new TextPrompt("0", resetBoardTextField);
		resetBoardPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		// resetMovesPrompt.changeStyle(Font.ITALIC);
		add(resetBoardTextField);

		checkbxSwapTiles = new JCheckBox();
		checkbxSwapTiles.setIcon(moveLock);
		checkbxSwapTiles.setSelectedIcon(moveUnlock);
		checkbxSwapTiles.setSelected(false);
		checkbxSwapTiles.setBounds(268, 434, 55, 30);
		add(checkbxSwapTiles);

		swapTilesTextField = new JTextField();
		swapTilesTextField.setHorizontalAlignment(SwingConstants.CENTER);
		swapTilesTextField.setForeground(new Color(163, 143, 133));
		swapTilesTextField.setFont(null);
		swapTilesTextField.setBorder(null);
		swapTilesTextField.setBounds(344, 431, 46, 34);
		swapTilesTextField.setEnabled(checkbxSwapTiles.isSelected());
		TextPrompt swapTilesPrompt = new TextPrompt("0", swapTilesTextField);
		swapTilesPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		// swapTilesPrompt.changeStyle(Font.ITALIC);
		add(swapTilesTextField);

		checkbxRemoveTile = new JCheckBox();
		checkbxRemoveTile.setIcon(moveLock);
		checkbxRemoveTile.setSelectedIcon(moveUnlock);
		checkbxRemoveTile.setSelected(false);
		checkbxRemoveTile.setBounds(268, 495, 55, 30);
		add(checkbxRemoveTile);

		removeTileTextField = new JTextField();
		removeTileTextField.setHorizontalAlignment(SwingConstants.CENTER);
		removeTileTextField.setForeground(new Color(163, 143, 133));
		removeTileTextField.setFont(null);
		removeTileTextField.setBorder(null);
		removeTileTextField.setBounds(344, 495, 46, 34);
		removeTileTextField.setEnabled(checkbxRemoveTile.isSelected());
		TextPrompt removeTilePrompt = new TextPrompt("0", removeTileTextField);
		removeTilePrompt.setHorizontalAlignment(TextPrompt.CENTER);
		// removeTilePrompt.changeStyle(Font.ITALIC);
		add(removeTileTextField);

		JLabel lblBonusFrequency = new JLabel("Bonus Frequency:");
		lblBonusFrequency.setFont(f30);
		lblBonusFrequency.setForeground(Color.decode("#A38F85"));
		lblBonusFrequency.setBounds(63, 546, 250, 41);
		add(lblBonusFrequency);

		JSlider frequencySlider = new JSlider();
		Hashtable<Integer, JLabel> frequencySliderTable = new Hashtable<Integer, JLabel>();
		JLabel lowLbl = new JLabel("Low");
		lowLbl.setFont(f14);
		lowLbl.setForeground(Color.decode("#A38F85"));
		JLabel mediumLbl = new JLabel("Medium");
		mediumLbl.setFont(f14);
		mediumLbl.setForeground(Color.decode("#A38F85"));
		JLabel highLbl = new JLabel("High");
		highLbl.setFont(f14);
		highLbl.setForeground(Color.decode("#A38F85"));
		frequencySliderTable.put(new Integer(3), lowLbl);
		frequencySliderTable.put(new Integer(4), mediumLbl);
		frequencySliderTable.put(new Integer(5), highLbl);
		frequencySlider.setMinimum(3);
		frequencySlider.setMaximum(5);
		frequencySlider.setMajorTickSpacing(1);
		frequencySlider.setBorder(null);
		frequencySlider.setPaintTicks(true);
		frequencySlider.setPaintTrack(true);
		frequencySlider.setPaintLabels(true);
		frequencySlider.setLabelTable(frequencySliderTable);
		frequencySlider.setBounds(332, 558, 134, 50);
		add(frequencySlider);
		
		JLabel moveLeftLbl = new JLabel("Moves Left:");
		moveLeftLbl.setFont(f30);
		moveLeftLbl.setForeground(Color.decode("#A38F85"));
		moveLeftLbl.setBounds(63, 607, 185, 41);
		add(moveLeftLbl);
		
		movesLeftTextField = new JTextField();
		movesLeftTextField.setBounds(268, 612, 55, 34);
		movesLeftTextField.setBorder(null);
		movesLeftTextField.setFont(f14);
		movesLeftTextField.setForeground(Color.decode("#A38F85"));
		movesLeftTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt movesLeftPrompt = new TextPrompt("0", movesLeftTextField);
		movesLeftPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		// minutePrompt.changeStyle(Font.ITALIC);
		add(movesLeftTextField);

		levelNameLbl = new JLabel("Level Name");
		levelNameLbl.setBounds(615, 120, 350, 41);
		levelNameLbl.setHorizontalAlignment(JLabel.CENTER);
		levelNameLbl.setFont(f30);
		levelNameLbl.setForeground(Color.decode("#A38F85"));
		add(levelNameLbl);

		boardPanel = new JPanel();
		boardPanel.setBounds(615, 169, 350, 350);
		// boardPanel.setBackground(Color.decode("#D4D4D4"));
		this.add(boardPanel);

		boardView = new BoardView(level.getBoard(), 33, 33);
		boardView.setPreferredSize(new Dimension(340, 340));
		boardPanel.add(boardView);

		Icon starIcon = new ImageIcon("resources/lbStar1.png");

		JLabel starLb1 = new JLabel();
		starLb1.setIcon(starIcon);
		starLb1.setBounds(635, 530, 52, 52);
		add(starLb1);

		JLabel starLb2 = new JLabel();
		starLb2.setIcon(starIcon);
		starLb2.setBounds(765, 530, 52, 52);
		add(starLb2);

		JLabel starLb3 = new JLabel();
		starLb3.setIcon(starIcon);
		starLb3.setBounds(894, 530, 52, 52);
		add(starLb3);

		oneStarTextField = new JTextField();
		oneStarTextField.setBounds(615, 592, 92, 31);
		oneStarTextField.setBorder(null);
		oneStarTextField.setFont(f14);
		oneStarTextField.setForeground(Color.decode("#A38F85"));
		oneStarTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt oneStarPrompt = new TextPrompt("One Star", oneStarTextField);
		oneStarPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		oneStarPrompt.changeStyle(Font.ITALIC);
		this.add(oneStarTextField);

		twoStarTextField = new JTextField();
		twoStarTextField.setBounds(744, 592, 92, 31);
		twoStarTextField.setBorder(null);
		twoStarTextField.setFont(f14);
		twoStarTextField.setForeground(Color.decode("#A38F85"));
		twoStarTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt twoStarPrompt = new TextPrompt("Two Star", twoStarTextField);
		twoStarPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		twoStarPrompt.changeStyle(Font.ITALIC);
		this.add(twoStarTextField);

		threeStarTextField = new JTextField();
		threeStarTextField.setBounds(873, 592, 92, 31);
		threeStarTextField.setBorder(null);
		threeStarTextField.setFont(f14);
		threeStarTextField.setForeground(Color.decode("#A38F85"));
		threeStarTextField.setHorizontalAlignment(JTextField.CENTER);
		TextPrompt threeStarPrompt = new TextPrompt("Three Star", threeStarTextField);
		threeStarPrompt.setHorizontalAlignment(TextPrompt.CENTER);
		threeStarPrompt.changeStyle(Font.ITALIC);
		this.add(threeStarTextField);

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

		if (application.gameType == 2) {
			JLabel timerLbl = new JLabel("Timer:");
			timerLbl.setForeground(new Color(163, 143, 133));
			timerLbl.setBounds(63, 653, 161, 41);
			timerLbl.setFont(f30);
			timerLbl.setForeground(Color.decode("#A38F85"));
			add(timerLbl);

			timerMinuteTextField = new JTextField();
			timerMinuteTextField.setBounds(268, 660, 55, 34);
			timerMinuteTextField.setBorder(null);
			timerMinuteTextField.setFont(f14);
			timerMinuteTextField.setForeground(Color.decode("#A38F85"));
			timerMinuteTextField.setHorizontalAlignment(JTextField.CENTER);
			TextPrompt minutePrompt = new TextPrompt("0", timerMinuteTextField);
			minutePrompt.setHorizontalAlignment(TextPrompt.CENTER);
			// minutePrompt.changeStyle(Font.ITALIC);
			add(timerMinuteTextField);

			JLabel minLbl = new JLabel("min");
			minLbl.setForeground(new Color(163, 143, 133));
			minLbl.setFont(null);
			minLbl.setBounds(332, 657, 58, 41);
			add(minLbl);

			timerSecondTextField = new JTextField();
			timerSecondTextField.setHorizontalAlignment(SwingConstants.CENTER);
			timerSecondTextField.setForeground(new Color(163, 143, 133));
			timerSecondTextField.setFont(null);
			timerSecondTextField.setBorder(null);
			timerSecondTextField.setBounds(362, 660, 55, 34);
			TextPrompt secondPrompt = new TextPrompt("0", timerSecondTextField);
			secondPrompt.setHorizontalAlignment(TextPrompt.CENTER);
			// secondPrompt.changeStyle(Font.ITALIC);
			add(timerSecondTextField);

			JLabel secLbl = new JLabel("sec");
			secLbl.setForeground(new Color(163, 143, 133));
			secLbl.setFont(null);
			secLbl.setBounds(426, 657, 58, 41);
			add(secLbl);
		}
	}

	public void initializeControllers() {
		backBtn.addActionListener(new LBGameTypeBackController(application,
				world));
		for (JCheckBox checkBox : tileRangeCheckBoxes) {
			checkBox.addActionListener(new UpdateTileRangeController(
					application, level, checkBox));
		}
		lvlNameTextField.getDocument().addDocumentListener(
				new UpdateLevelNameController(application, level,
						lvlNameTextField));
		dimensionSlider.addChangeListener(new UpdateDimensionController(
				application, level, dimensionSlider));
		oneStarTextField.getDocument().addDocumentListener(
				new UpdateOneStarController(application, level,
						oneStarTextField));
		twoStarTextField.getDocument().addDocumentListener(
				new UpdateTwoStarController(application, level,
						twoStarTextField));
		threeStarTextField.getDocument().addDocumentListener(
				new UpdateThreeStarController(application, level,
						threeStarTextField));

		checkbxResetBoard.addActionListener(new UpdateResetBoardController(
				application, level, resetBoardTextField, checkbxResetBoard));
		resetBoardTextField.getDocument().addDocumentListener(
					new UpdateResetBoardController(application, level,
							resetBoardTextField, checkbxResetBoard));
		
		checkbxSwapTiles.addActionListener(new UpdateSwapTilesController(
				application, level, swapTilesTextField, checkbxSwapTiles));
		swapTilesTextField.getDocument().addDocumentListener(
					new UpdateResetBoardController(application, level,
							swapTilesTextField, checkbxSwapTiles));
		
		checkbxRemoveTile.addActionListener(new UpdateRemoveTileController(
				application, level, removeTileTextField, checkbxRemoveTile));
		removeTileTextField.getDocument().addDocumentListener(
					new UpdateResetBoardController(application, level,
							removeTileTextField, checkbxRemoveTile));
		
		movesLeftTextField.getDocument().addDocumentListener(
				new UpdateMovesLeftController(application, level,
						movesLeftTextField));
		/*
		for (int i = 1; i < boardView.getDimension() * boardView.getDimension()) {
			SpaceView space = boardView.getGrid().get(i);
			space.setMouseAdapter(new ToggleSpaceMove(level, application, space));
		} */
		
		if (application.getGameType() == 2) {
		timerMinuteTextField.getDocument().addDocumentListener(
				new UpdateMinuteController(application, level,
						timerMinuteTextField));
		timerSecondTextField.getDocument().addDocumentListener(
				new UpdateSecondsController(application, level,
						timerSecondTextField));
		}

		closeBtn.addActionListener(new LBCloseGameController(world, application));
		miniBtn.addActionListener(new LBMinimizeGameController(world,
				application));
	}

	/**
	 * @return the application
	 */
	public LevelBuilderWindow getApplication() {
		return application;
	}

	/**
	 * @param application
	 *            the application to set
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
	 * @param world
	 *            the world to set
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
	 * @param backBtn
	 *            the backBtn to set
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
	 * @param typeName
	 *            the typeName to set
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
	 * @param boardView
	 *            the boardView to set
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
	 * @param level
	 *            the level to set
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
	 * @param tileRangeCheckBoxes
	 *            the tileRangeCheckBoxes to set
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
	 * @param lvlNameTextField
	 *            the lvlNameTextField to set
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
	 * @param oneStarTextField
	 *            the oneStarTextField to set
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
	 * @param twoStarTextField
	 *            the twoStarTextField to set
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
	 * @param threeStarTextField
	 *            the threeStarTextField to set
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
	 * @param boardPanel
	 *            the boardPanel to set
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
	 * @param specialMovesCheckBoxes
	 *            the specialMovesCheckBoxes to set
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
	 * @param levelNameLbl
	 *            the levelNameLbl to set
	 */
	public void setLevelNameLbl(JLabel levelNameLbl) {
		this.levelNameLbl = levelNameLbl;
	}

	/**
	 * @return the dimensionSlider
	 */
	public JSlider getDimensionSlider() {
		return dimensionSlider;
	}

	/**
	 * @param dimensionSlider
	 *            the dimensionSlider to set
	 */
	public void setDimensionSlider(JSlider dimensionSlider) {
		this.dimensionSlider = dimensionSlider;
	}

	/**
	 * @return the timerMinuteTextField
	 */
	public JTextField getTimerMinuteTextField() {
		return timerMinuteTextField;
	}

	/**
	 * @param timerMinuteTextField
	 *            the timerMinuteTextField to set
	 */
	public void setTimerMinuteTextField(JTextField timerMinuteTextField) {
		this.timerMinuteTextField = timerMinuteTextField;
	}

	/**
	 * @return the checkbxResetBoard
	 */
	public JCheckBox getCheckbxResetBoard() {
		return checkbxResetBoard;
	}

	/**
	 * @param checkbxResetBoard
	 *            the checkbxResetBoard to set
	 */
	public void setCheckbxResetBoard(JCheckBox checkbxResetBoard) {
		this.checkbxResetBoard = checkbxResetBoard;
	}

	/**
	 * @return the closeBtn
	 */
	public JButton getCloseBtn() {
		return closeBtn;
	}

	/**
	 * @param closeBtn
	 *            the closeBtn to set
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
	 * @param miniBtn
	 *            the miniBtn to set
	 */
	public void setMiniBtn(JButton miniBtn) {
		this.miniBtn = miniBtn;
	}

	/**
	 * @return the timerSecondTextField
	 */
	public JTextField getTimerSecondTextField() {
		return timerSecondTextField;
	}

	/**
	 * @param timerSecondTextField
	 *            the timerSecondTextField to set
	 */
	public void setTimerSecondTextField(JTextField timerSecondTextField) {
		this.timerSecondTextField = timerSecondTextField;
	}

	/**
	 * @return the resetBoardTextField
	 */
	public JTextField getResetBoardTextField() {
		return resetBoardTextField;
	}

	/**
	 * @param resetBoardTextField
	 *            the resetBoardTextField to set
	 */
	public void setResetBoardTextField(JTextField resetBoardTextField) {
		this.resetBoardTextField = resetBoardTextField;
	}

	/**
	 * @return the swapTilesTextField
	 */
	public JTextField getSwapTilesTextField() {
		return swapTilesTextField;
	}

	/**
	 * @param swapTilesTextField
	 *            the swapTilesTextField to set
	 */
	public void setSwapTilesTextField(JTextField swapTilesTextField) {
		this.swapTilesTextField = swapTilesTextField;
	}

	/**
	 * @return the removeTileTextField
	 */
	public JTextField getRemoveTileTextField() {
		return removeTileTextField;
	}

	/**
	 * @param removeTileTextField
	 *            the removeTileTextField to set
	 */
	public void setRemoveTileTextField(JTextField removeTileTextField) {
		this.removeTileTextField = removeTileTextField;
	}

}
