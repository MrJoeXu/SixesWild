package src.sixeswildgame.view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SixesWildWindow {

	private JFrame frmSixesWild;

	/**
	 * Create the application.
	 */
	public SixesWildWindow() {
		initialize();
	}
	
	private void initialize() {
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
	 */
	private void initializeView() {
		frmSixesWild = new JFrame();
		frmSixesWild.setTitle("Sixes Wild");
		frmSixesWild.setBounds(550, 100, 750, 750);
		frmSixesWild.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frmSixesWild.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSixeswild = new JLabel("Sixes Wild");
		lblSixeswild.setFont(new Font("Palatino Linotype", Font.BOLD, 65));
		lblSixeswild.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSixeswild = new GridBagConstraints();
		gbc_lblSixeswild.fill = GridBagConstraints.BOTH;
		gbc_lblSixeswild.insets = new Insets(0, 0, 5, 0);
		gbc_lblSixeswild.gridx = 0;
		gbc_lblSixeswild.gridy = 0;
		frmSixesWild.getContentPane().add(lblSixeswild, gbc_lblSixeswild);
		
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		frmSixesWild.getContentPane().add(button, gbc_button);
		
		JLabel label_5 = new JLabel("Presented By:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		frmSixesWild.getContentPane().add(label_5, gbc_label_5);
		
		JLabel label = new JLabel("Halsey Vandenberg");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		frmSixesWild.getContentPane().add(label, gbc_label);
		
		JLabel label_1 = new JLabel("Tiffany Leung");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		frmSixesWild.getContentPane().add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("Ziyao Xu \"Joe\"");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		frmSixesWild.getContentPane().add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("Matthew Beaulieu");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		frmSixesWild.getContentPane().add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("Jiaqi Ren");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 7;
		frmSixesWild.getContentPane().add(label_4, gbc_label_4);
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SixesWildWindow window = new SixesWildWindow();
					window.frmSixesWild.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
