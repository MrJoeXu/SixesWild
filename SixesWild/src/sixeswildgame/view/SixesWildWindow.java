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

import src.sixeswildgame.controllers.SelectGameTypeController;
import src.sixeswildgame.world.World;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SixesWildWindow {

	//JFrames
	protected JFrame frmSixesWild;
	
	//JPanels
	protected GameTypeView gameTypeView;
	
	//JButtons
	protected JButton startButton;
	
	//World
	protected World world;

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
		frmSixesWild.setBounds(0, 0, 1440, 1024);
		frmSixesWild.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSixesWild.setBackground(Color.decode("#E5E5E5"));
		frmSixesWild.setLayout(null);
		
		JLabel lblSixeswild = new JLabel("SixesWild");
		lblSixeswild.setFont(new Font("Avenir Next", Font.PLAIN, 78));
		lblSixeswild.setBounds(543, 180, 354, 109);
		lblSixeswild.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(lblSixeswild);
		
		startButton = new BetterButton(Color.decode("#D76262"),271,70,10);
		startButton.setBorderPainted(false);
		startButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		startButton.setText("Start");
		startButton.setBounds(585, 370, 271, 70);
		startButton.setForeground(Color.white);
		frmSixesWild.getContentPane().add(startButton);
		
		JLabel label1 = new JLabel("Presented by:");
		label1.setBounds(625, 500, 200, 41);
		label1.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		label1.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Metthew Beaulieu");
		label2.setBounds(640, 600, 170, 27);
		label2.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label2.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Tiffany Leung");
		label3.setBounds(662, 630, 170, 27);
		label3.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label3.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Jiaqi Ren");
		label4.setBounds(680, 660, 170, 27);
		label4.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label4.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Halsey Vandenberg");
		label5.setBounds(635, 690, 180, 27);
		label5.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label5.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("Ziyao Xu 'Joe'");
		label6.setBounds(664, 720, 170, 27);
		label6.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		label6.setForeground(Color.decode("#D76262"));
		frmSixesWild.getContentPane().add(label6);
		
	}
	
	/**
	 * Initialize the controllers.
	 */
	private void initializeControllers() {
		startButton.addActionListener(new SelectGameTypeController(this, world));
		
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

	/**
	 * @return the gameTypeView
	 */
	public GameTypeView getGameTypeView() {
		return gameTypeView;
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
	
	//Getters and Setters
	

}
