/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.sixeswildgame.controllers.LevelBackController;
import src.sixeswildgame.world.World;

/**
 * @author Joe Xu
 *
 */
public class LevelView extends JPanel{

	protected BoardView boardView;
	
	protected JLabel scoreLbl;
	protected JLabel timerLbl;
	protected JLabel oneStarLbl;
	protected JLabel twoStarLbl;
	protected JLabel threeStarLbl;
	protected JLabel movesLeft;
	protected JLabel timesLeft;
	
	protected JButton resetBoardBtn;
	protected JButton removeTileBtn;
	protected JButton swapTilesBtn;
	protected JButton backBtn;
	
	protected World world;
	protected SixesWildWindow application;
	protected src.sixeswildgame.world.Level level;
	
	
	public LevelView(SixesWildWindow application, World world, src.sixeswildgame.world.Level level) {
		this.application = application;
		this.world = world;
		this.level = level;
		initialize();
	}
	
	public void initialize() {
		initializeView();
		initializeModel();
		initializeController();
	}

	private void initializeController() {
		backBtn.addActionListener(new LevelBackController(world, application));
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	private void initializeView() {
		this.setLayout(null);
		
		scoreLbl = new JLabel("Score: 0000");
		scoreLbl.setFont(new Font("Avenir Next", Font.PLAIN, 40));
		scoreLbl.setBounds(611, 60, 219, 55);
		scoreLbl.setForeground(Color.decode("#D76262"));
		this.add(scoreLbl);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),94,58,15);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(50, 30, 94, 58);
		this.add(backBtn); 
		
		resetBoardBtn = new BetterButton(Color.decode("#3D7CA2"),180,60,15);
		resetBoardBtn.setBorderPainted(false);
		resetBoardBtn.setText("Reset Board: 0");
		resetBoardBtn.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		resetBoardBtn.setForeground(Color.white);
		resetBoardBtn.setFocusPainted(false);
		resetBoardBtn.setBounds(1197, 371, 180,60);
		this.add(resetBoardBtn); 
		
		removeTileBtn = new BetterButton(Color.decode("#45D7B3"),180,60,15);
		removeTileBtn.setBorderPainted(false);
		removeTileBtn.setText("Remove Tile: 0");
		removeTileBtn.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		removeTileBtn.setForeground(Color.white);
		removeTileBtn.setFocusPainted(false);
		removeTileBtn.setBounds(1197, 456, 180,60);
		this.add(removeTileBtn); 
		
		swapTilesBtn = new BetterButton(Color.decode("#FF9D8F"),180,60,15);
		swapTilesBtn.setBorderPainted(false);
		swapTilesBtn.setText("Swap 2 Tiles: 0");
		swapTilesBtn.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		swapTilesBtn.setForeground(Color.white);
		swapTilesBtn.setFocusPainted(false);
		swapTilesBtn.setBounds(1197, 541, 180,60);
		this.add(swapTilesBtn); 
		
		movesLeft = new BetterLabel(Color.decode("#D76262"),276,58,15);
		movesLeft.setText("Moves Left: " + level.getMovesLeft());
		movesLeft.setFont(new Font("Avenir Next", Font.PLAIN, 20));
		movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		movesLeft.setForeground(Color.white);
		movesLeft.setBounds(582, 904, 276,58);
		this.add(movesLeft); 
		
		if (application.getGameType() == 2) {
			movesLeft.setBounds(370, 904, 276,58);
			
			timesLeft = new BetterLabel(Color.decode("#D76262"),276,58,15);
			timesLeft.setText("Timess Left: " + level.getTime());
			timesLeft.setFont(new Font("Avenir Next", Font.PLAIN, 20));
			timesLeft.setHorizontalAlignment(SwingConstants.CENTER);
			timesLeft.setForeground(Color.white);
			timesLeft.setBounds(794, 904, 276,58);
			this.add(timesLeft); 
		}
		
		BetterLabel starPanel = new BetterLabel(Color.decode("#D8D8D8"),155,352,40);
		starPanel.setLayout(null);
		starPanel.setBounds(73, 313, 155, 352);
		this.add(starPanel); 
		
		ImageIcon firstYellowStar = new ImageIcon("resources/Star 1.png");
		ImageIcon firstGreyStar = new ImageIcon("resources/Star1g.png");
		ImageIcon secondYellowStar = new ImageIcon("resources/Star 2.png");
		ImageIcon secondGreyStar = new ImageIcon("resources/Star2g.png");
		ImageIcon thirdYellowStar = new ImageIcon("resources/Star 3.png");
		ImageIcon thirdtGreyStar = new ImageIcon("resources/Star3g.png");
		
		oneStarLbl = new JLabel();
		if (level.getCurrentScore() < level.getOneStarScore()) {
			oneStarLbl.setIcon(firstGreyStar);
		}
		else { oneStarLbl.setIcon(firstYellowStar); }
		oneStarLbl.setBounds(48, 252, 50, 50);
		starPanel.add(oneStarLbl);
		
		twoStarLbl = new JLabel();
		if (level.getCurrentScore() < level.getTwoStarScore()) {
			twoStarLbl.setIcon(secondGreyStar);
		}
		else { twoStarLbl.setIcon(secondYellowStar); }
		twoStarLbl.setBounds(38, 162, 70, 70);
		starPanel.add(twoStarLbl);
		
		threeStarLbl = new JLabel();
		if (level.getCurrentScore() < level.getThreeStarScore()) {
			threeStarLbl.setIcon(thirdtGreyStar);
		}
		else { threeStarLbl.setIcon(thirdYellowStar); }
		threeStarLbl.setBounds(36, 58, 75, 75);
		starPanel.add(threeStarLbl);
		
		BoardView boardView = new BoardView(level.getBoard(),70,70);
		int length = boardView.getDimension()*boardView.getTielLength() + 5 * boardView.getDimension();
		int panelX = (1440 - length)/2;
		System.out.print(panelX);
		int panelY = (1020 - length)/2;
		System.out.print(panelY);
		boardView.setBounds(panelX, panelY, length, length);
		this.add(boardView);
		
		
	}

}
