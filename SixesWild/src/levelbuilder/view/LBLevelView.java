package src.levelbuilder.view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.levelbuilder.controllers.LBGameTypeBackController;
import src.levelbuilder.controllers.UpdateTileRangeController;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.World;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
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
	private JTextField lvlNameTextField;
	private JTextField oneStarTextField;
	private JTextField twoStarTextField;
	private JTextField threeStarTextField;
	protected JPanel boardPanel;

	/**
	 * Create the panel.
	 */
	public LBLevelView(LevelBuilderWindow application, World world, Level level) {
		setPreferredSize(new Dimension(1250, 900));
		this.application = application;
		this.world = world;
		this.level = level;
		this.tileRangeCheckBoxes = new ArrayList<JCheckBox>();
		this.setBounds(550, 100, 1250, 750);
		
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
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 40, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		backBtn = new JButton("<- Back");
		GridBagConstraints gbc_backBtn = new GridBagConstraints();
		gbc_backBtn.gridx = 0;
		gbc_backBtn.gridy = 0;
		panel.add(backBtn, gbc_backBtn);
		
		JLabel lblTypeBuilder = new JLabel("Level Builder");
		lblTypeBuilder.setBorder(new EmptyBorder(50, 0, 50, 0));
		lblTypeBuilder.setFont(new Font("Palatino Linotype", Font.PLAIN, 60));
		GridBagConstraints gbc_lblTypeBuilder = new GridBagConstraints();
		gbc_lblTypeBuilder.gridwidth = 2;
		gbc_lblTypeBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeBuilder.gridx = 1;
		gbc_lblTypeBuilder.gridy = 0;
		add(lblTypeBuilder, gbc_lblTypeBuilder);
		
		JPanel levelParametersPanel = new JPanel();
		levelParametersPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		levelParametersPanel.setPreferredSize(new Dimension(500, 500));
		GridBagConstraints gbc_levelParametersPanel = new GridBagConstraints();
		gbc_levelParametersPanel.gridwidth = 2;
		gbc_levelParametersPanel.insets = new Insets(0, 0, 5, 5);
		gbc_levelParametersPanel.fill = GridBagConstraints.BOTH;
		gbc_levelParametersPanel.gridx = 0;
		gbc_levelParametersPanel.gridy = 1;
		add(levelParametersPanel, gbc_levelParametersPanel);
		GridBagLayout gbl_levelParametersPanel = new GridBagLayout();
		gbl_levelParametersPanel.columnWidths = new int[]{0, 0, 0};
		gbl_levelParametersPanel.rowHeights = new int[]{0, 131, 0, 0, 0, 0, 0, 0};
		gbl_levelParametersPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_levelParametersPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		levelParametersPanel.setLayout(gbl_levelParametersPanel);
		
		JLabel lblLevelName = new JLabel("Level Name:");
		lblLevelName.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		lblLevelName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblLevelName = new GridBagConstraints();
		gbc_lblLevelName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevelName.anchor = GridBagConstraints.EAST;
		gbc_lblLevelName.gridx = 0;
		gbc_lblLevelName.gridy = 0;
		levelParametersPanel.add(lblLevelName, gbc_lblLevelName);
		
		lvlNameTextField = new JTextField();
		GridBagConstraints gbc_lvlNameTextField = new GridBagConstraints();
		gbc_lvlNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lvlNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lvlNameTextField.gridx = 1;
		gbc_lvlNameTextField.gridy = 0;
		levelParametersPanel.add(lvlNameTextField, gbc_lvlNameTextField);
		lvlNameTextField.setColumns(10);
		TextPrompt namePrompt = new TextPrompt("Enter to name the level.", lvlNameTextField);
		namePrompt.changeStyle(Font.ITALIC);
		
		JLabel lblTileRange = new JLabel("Tile Range:");
		lblTileRange.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		lblTileRange.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTileRange.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTileRange = new GridBagConstraints();
		gbc_lblTileRange.anchor = GridBagConstraints.EAST;
		gbc_lblTileRange.insets = new Insets(0, 0, 5, 5);
		gbc_lblTileRange.gridx = 0;
		gbc_lblTileRange.gridy = 1;
		levelParametersPanel.add(lblTileRange, gbc_lblTileRange);
		
		JPanel tileRangePanel = new JPanel();
		GridBagConstraints gbc_tileRangePanel = new GridBagConstraints();
		gbc_tileRangePanel.insets = new Insets(0, 0, 5, 0);
		gbc_tileRangePanel.fill = GridBagConstraints.BOTH;
		gbc_tileRangePanel.gridx = 1;
		gbc_tileRangePanel.gridy = 1;
		levelParametersPanel.add(tileRangePanel, gbc_tileRangePanel);
		tileRangePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JCheckBox rangeOneCheckBox = new JCheckBox("1");
		rangeOneCheckBox.setSelected(true);
		rangeOneCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		rangeOneCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		rangeOneCheckBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		tileRangeCheckBoxes.add(rangeOneCheckBox);
		tileRangePanel.add(rangeOneCheckBox);
		
		JCheckBox rangeTwoCheckBox = new JCheckBox("2");
		rangeTwoCheckBox.setSelected(true);
		rangeTwoCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		rangeTwoCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		rangeTwoCheckBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		tileRangeCheckBoxes.add(rangeTwoCheckBox);
		tileRangePanel.add(rangeTwoCheckBox);
		
		JCheckBox rangeThreeCheckBox = new JCheckBox("3");
		rangeThreeCheckBox.setSelected(true);
		rangeThreeCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		rangeThreeCheckBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		rangeThreeCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		tileRangeCheckBoxes.add(rangeThreeCheckBox);
		tileRangePanel.add(rangeThreeCheckBox);
		
		JCheckBox rangeFourCheckBox = new JCheckBox("4");
		rangeFourCheckBox.setSelected(true);
		rangeFourCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		rangeFourCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		rangeFourCheckBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		tileRangeCheckBoxes.add(rangeFourCheckBox);
		tileRangePanel.add(rangeFourCheckBox);
		
		JCheckBox rangeFiveCheckBox = new JCheckBox("5");
		rangeFiveCheckBox.setSelected(true);
		rangeFiveCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		rangeFiveCheckBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		rangeFiveCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		tileRangeCheckBoxes.add(rangeFiveCheckBox);
		tileRangePanel.add(rangeFiveCheckBox);
		
		JLabel lblNewLabel = new JLabel("Board Dimensions:");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		levelParametersPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel dimensionsPanel = new JPanel();
		GridBagConstraints gbc_dimensionsPanel = new GridBagConstraints();
		gbc_dimensionsPanel.fill = GridBagConstraints.BOTH;
		gbc_dimensionsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_dimensionsPanel.gridx = 1;
		gbc_dimensionsPanel.gridy = 2;
		levelParametersPanel.add(dimensionsPanel, gbc_dimensionsPanel);
		GridBagLayout gbl_dimensionsPanel = new GridBagLayout();
		gbl_dimensionsPanel.columnWidths = new int[]{0, 0};
		gbl_dimensionsPanel.rowHeights = new int[]{0, 0, 0};
		gbl_dimensionsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_dimensionsPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		dimensionsPanel.setLayout(gbl_dimensionsPanel);
		
		JSlider dimensionsSlider = new JSlider();
		GridBagConstraints gbc_dimensionsSlider = new GridBagConstraints();
		gbc_dimensionsSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimensionsSlider.insets = new Insets(0, 0, 5, 0);
		gbc_dimensionsSlider.gridx = 0;
		gbc_dimensionsSlider.gridy = 0;
		dimensionsPanel.add(dimensionsSlider, gbc_dimensionsSlider);
		dimensionsSlider.setMinimum(3);
		dimensionsSlider.setMaximum(9);
		dimensionsSlider.setMajorTickSpacing(2);
 
        Hashtable<Integer, JLabel> labels =
                new Hashtable<Integer, JLabel>();
        for (int i = 3; i <= 9; i++) {
        	labels.put(i, new JLabel(i + "x" + i));
        }
        dimensionsSlider.setLabelTable(labels);
		
		JLabel dimensionsLbl = new JLabel();
		dimensionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_dimensionsLbl = new GridBagConstraints();
		gbc_dimensionsLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_dimensionsLbl.gridx = 0;
		gbc_dimensionsLbl.gridy = 1;
		dimensionsPanel.add(dimensionsLbl, gbc_dimensionsLbl);
		
		JLabel lblBo = new JLabel("Special Moves:");
		lblBo.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBo = new GridBagConstraints();
		gbc_lblBo.anchor = GridBagConstraints.EAST;
		gbc_lblBo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBo.gridx = 0;
		gbc_lblBo.gridy = 3;
		levelParametersPanel.add(lblBo, gbc_lblBo);
		
		JCheckBox specialMovesCheckBox = new JCheckBox("");
		specialMovesCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_specialMovesCheckBox = new GridBagConstraints();
		gbc_specialMovesCheckBox.anchor = GridBagConstraints.WEST;
		gbc_specialMovesCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_specialMovesCheckBox.gridx = 1;
		gbc_specialMovesCheckBox.gridy = 3;
		levelParametersPanel.add(specialMovesCheckBox, gbc_specialMovesCheckBox);
		
		JLabel lblBonusFrequency = new JLabel("Bonus Frequency:");
		lblBonusFrequency.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBonusFrequency = new GridBagConstraints();
		gbc_lblBonusFrequency.anchor = GridBagConstraints.EAST;
		gbc_lblBonusFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_lblBonusFrequency.gridx = 0;
		gbc_lblBonusFrequency.gridy = 4;
		levelParametersPanel.add(lblBonusFrequency, gbc_lblBonusFrequency);
		
		JPanel frequencyPanel = new JPanel();
		GridBagConstraints gbc_frequencyPanel = new GridBagConstraints();
		gbc_frequencyPanel.insets = new Insets(0, 0, 5, 0);
		gbc_frequencyPanel.fill = GridBagConstraints.BOTH;
		gbc_frequencyPanel.gridx = 1;
		gbc_frequencyPanel.gridy = 4;
		levelParametersPanel.add(frequencyPanel, gbc_frequencyPanel);
		GridBagLayout gbl_frequencyPanel = new GridBagLayout();
		gbl_frequencyPanel.columnWidths = new int[]{0, 0};
		gbl_frequencyPanel.rowHeights = new int[]{0, 0, 0};
		gbl_frequencyPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_frequencyPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frequencyPanel.setLayout(gbl_frequencyPanel);
		
		JSlider frequencySlider = new JSlider();
		GridBagConstraints gbc_frequencySlider = new GridBagConstraints();
		gbc_frequencySlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_frequencySlider.insets = new Insets(0, 0, 5, 0);
		gbc_frequencySlider.gridx = 0;
		gbc_frequencySlider.gridy = 0;
		frequencyPanel.add(frequencySlider, gbc_frequencySlider);
		
		JLabel frequencyLabel = new JLabel("Medium");
		GridBagConstraints gbc_frequencyLabel = new GridBagConstraints();
		gbc_frequencyLabel.gridx = 0;
		gbc_frequencyLabel.gridy = 1;
		frequencyPanel.add(frequencyLabel, gbc_frequencyLabel);
		
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
		
		JLabel levelNameLbl = new JLabel("\"Level Name\"");
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
		boardBtnPanel.add(undoBtn);
		
		initializeControllers();
	}
	
	public void initializeControllers() {
		backBtn.addActionListener(new LBGameTypeBackController(application, world));
		for (JCheckBox checkBox : tileRangeCheckBoxes) {
			checkBox.addActionListener(new UpdateTileRangeController(application, level, checkBox));
		}
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


	

}
