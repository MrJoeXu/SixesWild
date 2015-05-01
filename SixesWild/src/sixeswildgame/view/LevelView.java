/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.LevelBackController;
import src.sixeswildgame.controllers.MakeMoveController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
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
	protected JButton closeBtn;
	protected JButton miniBtn;
	
	protected World world;
	protected SixesWildWindow application;
	protected Level level;
	
	
	public LevelView(SixesWildWindow application, World world, Level level) throws FileNotFoundException, FontFormatException, IOException {
		this.application = application;
		this.world = world;
		this.level = level;
		initialize();
	}
	
	public void initialize() throws FileNotFoundException, FontFormatException, IOException {
		initializeModel();
		initializeView();
		initializeControllers();
	}

	private void initializeControllers() {
		backBtn.addActionListener(new LevelBackController(world, application));
		closeBtn.addActionListener(new CloseGameController(world, application));
		miniBtn.addActionListener(new MinimizeGameController(world,application));
		for (SpaceView sv : boardView.getGrid()) {
			sv.getTileView().addMouseListener(new MakeMoveController(sv.getTileView(), level, application));
		}
	}

	private void initializeModel() {
		this.level = new Level(new Board(9), 0, "puzzle");
		level.initialize(1);
	}

	private void initializeView() throws FileNotFoundException, FontFormatException, IOException {
		this.setPreferredSize(new Dimension (1000,708));
		this.setLayout(null);
		
		scoreLbl = new JLabel("Score: 0000");
		Font f30 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 30);
		scoreLbl.setFont(f30);
		scoreLbl.setBounds(418, 37, 164, 41);
		scoreLbl.setForeground(Color.decode("#D76262"));
		this.add(scoreLbl);
		
		backBtn = new BetterButton(Color.decode("#EC7665"),65,40,10);
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		Icon backIcon = new ImageIcon("resources/backIcon.png");
		backBtn.setIcon(backIcon);
		backBtn.setBounds(30, 20, 65, 40);
		this.add(backBtn); 
		
		Font f15 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 15);
		resetBoardBtn = new BetterButton(Color.decode("#3D7CA2"),150,40,10);
		resetBoardBtn.setBorderPainted(false);
		resetBoardBtn.setText("Reset Board: 0");
		resetBoardBtn.setFont(f15);
		resetBoardBtn.setForeground(Color.white);
		resetBoardBtn.setFocusPainted(false);
		resetBoardBtn.setBounds(814, 265, 150,40);
		this.add(resetBoardBtn); 
		
		removeTileBtn = new BetterButton(Color.decode("#45D7B3"),150,40,10);
		removeTileBtn.setBorderPainted(false);
		removeTileBtn.setText("Remove Tile: 0");
		removeTileBtn.setFont(f15);
		removeTileBtn.setForeground(Color.white);
		removeTileBtn.setFocusPainted(false);
		removeTileBtn.setBounds(814, 333, 150,40);
		this.add(removeTileBtn); 
		
		swapTilesBtn = new BetterButton(Color.decode("#FF9D8F"),150,40,10);
		swapTilesBtn.setBorderPainted(false);
		swapTilesBtn.setText("Swap 2 Tiles: 0");
		swapTilesBtn.setFont(f15);
		swapTilesBtn.setForeground(Color.white);
		swapTilesBtn.setFocusPainted(false);
		swapTilesBtn.setBounds(814, 403, 150,40);
		this.add(swapTilesBtn); 
		
		Font f18 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 18);
		movesLeft = new BetterLabel(Color.decode("#D76262"),166,47,10);
		movesLeft.setText("Moves Left: " + level.getMovesLeft());
		movesLeft.setFont(f18);
		movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		movesLeft.setForeground(Color.white);
		movesLeft.setBounds(250, 635, 166, 47);
		this.add(movesLeft); 
		
			timesLeft = new BetterLabel(Color.decode("#D76262"),166,47,10);
			timesLeft.setText("Timess Left: " + level.getTime());
			timesLeft.setFont(f18);
			timesLeft.setHorizontalAlignment(SwingConstants.CENTER);
			timesLeft.setForeground(Color.white);
			timesLeft.setBounds(584, 635, 166, 47);
			this.add(timesLeft); 
		
		BetterLabel starPanel = new BetterLabel(Color.decode("#D8D8D8"),120, 273,40);
		starPanel.setLayout(null);
		starPanel.setBounds(63, 218, 120, 273);
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
		oneStarLbl.setBounds(41, 198, 36, 36);
		starPanel.add(oneStarLbl);
		
		twoStarLbl = new JLabel();
		if (level.getCurrentScore() < level.getTwoStarScore()) {
			twoStarLbl.setIcon(secondGreyStar);
		}
		else { twoStarLbl.setIcon(secondYellowStar); }
		twoStarLbl.setBounds(34, 123, 50, 50);
		starPanel.add(twoStarLbl);
		
		threeStarLbl = new JLabel();
		if (level.getCurrentScore() < level.getThreeStarScore()) {
			threeStarLbl.setIcon(thirdtGreyStar);
		}
		else { threeStarLbl.setIcon(thirdYellowStar); }
		threeStarLbl.setBounds(29, 38, 60, 60);
		starPanel.add(threeStarLbl);
		
		boardView = new BoardView(level.getBoard(),50,50); 
		int length = boardView.getDimension()*boardView.getTileLength() + 5 * boardView.getDimension();
		int panelX = (1000 - length)/2;
		int panelY = (708 - length)/2;
		boardView.setBounds(panelX, panelY, length, length);
		this.add(boardView);
		
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
	}

}
