package src.levelbuilder.view;

import javax.swing.JPanel;

import src.levelbuilder.controllers.LBGameTypeBackController;
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

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Dimension;

public class LBLevelView extends JPanel {
	
	protected LevelBuilderWindow application;
	protected World world;
	protected JButton backBtn;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LBLevelView(LevelBuilderWindow application, World world) {
		this.application = application;
		this.world = world;
		this.setBounds(550, 100, 1000, 750);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		backBtn = new JButton("<- Back");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		add(backBtn, gbc_button);
		
		JLabel lblPuzzleBuilder = new JLabel("Puzzle Builder");
		lblPuzzleBuilder.setFont(new Font("Palatino Linotype", Font.PLAIN, 60));
		GridBagConstraints gbc_lblPuzzleBuilder = new GridBagConstraints();
		gbc_lblPuzzleBuilder.gridwidth = 2;
		gbc_lblPuzzleBuilder.insets = new Insets(0, 0, 5, 0);
		gbc_lblPuzzleBuilder.gridx = 1;
		gbc_lblPuzzleBuilder.gridy = 0;
		add(lblPuzzleBuilder, gbc_lblPuzzleBuilder);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 750));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblLevelName = new JLabel("Level Name:");
		GridBagConstraints gbc_lblLevelName = new GridBagConstraints();
		gbc_lblLevelName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevelName.anchor = GridBagConstraints.EAST;
		gbc_lblLevelName.gridx = 0;
		gbc_lblLevelName.gridy = 0;
		panel.add(lblLevelName, gbc_lblLevelName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTileRange = new JLabel("Tile Range:");
		GridBagConstraints gbc_lblTileRange = new GridBagConstraints();
		gbc_lblTileRange.insets = new Insets(0, 0, 0, 5);
		gbc_lblTileRange.gridx = 0;
		gbc_lblTileRange.gridy = 1;
		panel.add(lblTileRange, gbc_lblTileRange);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JCheckBox checkBox = new JCheckBox("1");
		checkBox.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel_2.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("2");
		checkBox_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel_2.add(checkBox_1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		initializeControllers();
	}
	
	public void initializeControllers() {
		backBtn.addActionListener(new LBGameTypeBackController(application, world));
	}

}
