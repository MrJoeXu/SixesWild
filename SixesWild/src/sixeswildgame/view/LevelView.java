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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.sixeswildgame.controllers.CloseGameController;
import src.sixeswildgame.controllers.LevelBackController;
import src.sixeswildgame.controllers.MakeMoveController;
import src.sixeswildgame.controllers.MinimizeGameController;
import src.sixeswildgame.controllers.SelectSpecialMoveController;
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
	protected JPanel boardPanel;
	
	protected JLabel scoreLbl;
	protected JLabel timerLbl;
	protected JLabel oneStarLbl;
	protected JLabel twoStarLbl;
	protected JLabel threeStarLbl;
	protected JLabel movesLeft;
	protected JLabel timesLeft;
	
	protected BetterButton resetBoardBtn;
	protected JCheckBox removeTileCheckBox;
	protected JCheckBox swapTilesCheckBox;
	
	protected JButton backBtn;
	protected JButton closeBtn;
	protected JButton miniBtn;
	
	protected World world;
	protected SixesWildWindow application;
	protected Level level;
	
	protected ArrayList<JCheckBox> specialMovesCheckBoxes;
	protected boolean isSwapTwoTiles;
	protected boolean isRemoveTile;
	
	public LevelView(SixesWildWindow application, World world, Level level) throws FileNotFoundException, FontFormatException, IOException {
		this.application = application;
		this.world = world;
		this.level = level;
		this.isSwapTwoTiles = false;
		this.isRemoveTile = false;
		this.specialMovesCheckBoxes = new ArrayList<JCheckBox>();
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
		
		int i = 0;
		for (JCheckBox cb : specialMovesCheckBoxes) {
			cb.addActionListener(new SelectSpecialMoveController(application, level, cb, i));
			i++;
		}
		
		for (SpaceView sv : boardView.getGrid()) {
			sv.getTileView().addMouseListener(new MakeMoveController(sv.getTileView(), level, application));
		}
	}
	
	public BoardView getBoardView() {
		return this.boardView;
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
	
		resetBoardBtn = new BetterButton(Color.decode("#3D7CA2"),65,65,15);
		resetBoardBtn.setBorderPainted(false);
		resetBoardBtn.setFocusPainted(false);
		Icon Reset = new ImageIcon("resources/Reset.png");
		resetBoardBtn.setIcon(Reset);
		resetBoardBtn.setBounds(814, 217, 65,65);
		this.add(resetBoardBtn); 
		
		Font f40 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("resources/avenir-next-regular.ttf"))).deriveFont(Font.PLAIN, 40);
		
		JLabel resetBoardCount = new JLabel("10");
		resetBoardCount.setFont(f40);
		resetBoardCount.setBounds(900, 226, 50, 55);
		resetBoardCount.setForeground(Color.decode("#3D7CA2"));
		this.add(resetBoardCount);
		
		
		Icon remove = new ImageIcon("resources/Remove.png");
		Icon removeSelect = new ImageIcon("resources/RemoveSelect.png");
		removeTileCheckBox = new JCheckBox();
		removeTileCheckBox.setIcon(remove);
		removeTileCheckBox.setSelectedIcon(removeSelect);
		removeTileCheckBox.setSelected(this.isRemoveTile);
		removeTileCheckBox.setBounds(810, 321, 70, 65);
		this.add(removeTileCheckBox);
		
		JLabel removeCount = new JLabel("10");
		removeCount.setFont(f40);
		removeCount.setBounds(900, 328, 50, 55);
		removeCount.setForeground(Color.decode("#45D7B3"));
		this.add(removeCount);
		
		
		Icon swap = new ImageIcon("resources/Swap.png");
		Icon swapSelect = new ImageIcon("resources/SwapSelect.png");
		swapTilesCheckBox = new JCheckBox();
		swapTilesCheckBox.setIcon(swap);
		swapTilesCheckBox.setSelectedIcon(swapSelect);
		swapTilesCheckBox.setSelected(this.isSwapTwoTiles);
		swapTilesCheckBox.setBounds(810, 427, 70, 65);
		this.add(swapTilesCheckBox);
		
		JLabel swapCount = new JLabel("10");
		swapCount.setFont(f40);
		swapCount.setBounds(900, 431, 50, 55);
		swapCount.setForeground(Color.decode("#FF9D8F"));
		this.add(swapCount);
		
		specialMovesCheckBoxes.add(swapTilesCheckBox);
		specialMovesCheckBoxes.add(removeTileCheckBox);
		
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
		
		boardPanel = new JPanel();
		
		boardView = new BoardView(level.getBoard(),50,50); 
		int length = boardView.getDimension()*boardView.getTileLength() + 5 * boardView.getDimension();
		int panelX = (1000 - length)/2;
		int panelY = (708 - length)/2;
		boardView.setBounds(panelX, panelY, length, length);
		boardPanel.setBounds(panelX, panelY, length, length);
		// boardPanel.setBackground(Color.decode("#D4D4D4"));
		this.add(boardPanel);
		boardPanel.add(boardView);
		
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

	/**
	 * @return the scoreLbl
	 */
	public JLabel getScoreLbl() {
		return scoreLbl;
	}

	/**
	 * @param scoreLbl the scoreLbl to set
	 */
	public void setScoreLbl(JLabel scoreLbl) {
		this.scoreLbl = scoreLbl;
	}

	/**
	 * @return the timerLbl
	 */
	public JLabel getTimerLbl() {
		return timerLbl;
	}

	/**
	 * @param timerLbl the timerLbl to set
	 */
	public void setTimerLbl(JLabel timerLbl) {
		this.timerLbl = timerLbl;
	}

	/**
	 * @return the oneStarLbl
	 */
	public JLabel getOneStarLbl() {
		return oneStarLbl;
	}

	/**
	 * @param oneStarLbl the oneStarLbl to set
	 */
	public void setOneStarLbl(JLabel oneStarLbl) {
		this.oneStarLbl = oneStarLbl;
	}

	/**
	 * @return the twoStarLbl
	 */
	public JLabel getTwoStarLbl() {
		return twoStarLbl;
	}

	/**
	 * @param twoStarLbl the twoStarLbl to set
	 */
	public void setTwoStarLbl(JLabel twoStarLbl) {
		this.twoStarLbl = twoStarLbl;
	}

	/**
	 * @return the threeStarLbl
	 */
	public JLabel getThreeStarLbl() {
		return threeStarLbl;
	}

	/**
	 * @param threeStarLbl the threeStarLbl to set
	 */
	public void setThreeStarLbl(JLabel threeStarLbl) {
		this.threeStarLbl = threeStarLbl;
	}

	/**
	 * @return the movesLeft
	 */
	public JLabel getMovesLeft() {
		return movesLeft;
	}

	/**
	 * @param movesLeft the movesLeft to set
	 */
	public void setMovesLeft(JLabel movesLeft) {
		this.movesLeft = movesLeft;
	}

	/**
	 * @return the timesLeft
	 */
	public JLabel getTimesLeft() {
		return timesLeft;
	}

	/**
	 * @param timesLeft the timesLeft to set
	 */
	public void setTimesLeft(JLabel timesLeft) {
		this.timesLeft = timesLeft;
	}

	/**
	 * @return the resetBoardCheckBox
	 */
	public BetterButton getResetBoardCheckBox() {
		return resetBoardBtn;
	}

	/**
	 * @param resetBoardCheckBox the resetBoardCheckBox to set
	 */
	public void setResetBoardCheckBox(BetterButton resetBoardBtn) {
		this.resetBoardBtn = resetBoardBtn;
	}

	/**
	 * @return the removeTileCheckBox
	 */
	public JCheckBox getRemoveTileCheckBox() {
		return removeTileCheckBox;
	}

	/**
	 * @param removeTileCheckBox the removeTileCheckBox to set
	 */
	public void setRemoveTileCheckBox(JCheckBox removeTileCheckBox) {
		this.removeTileCheckBox = removeTileCheckBox;
	}

	/**
	 * @return the swapTilesCheckBox
	 */
	public JCheckBox getSwapTilesCheckBox() {
		return swapTilesCheckBox;
	}

	/**
	 * @param swapTilesCheckBox the swapTilesCheckBox to set
	 */
	public void setSwapTilesCheckBox(JCheckBox swapTilesCheckBox) {
		this.swapTilesCheckBox = swapTilesCheckBox;
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
	 * @return the application
	 */
	public SixesWildWindow getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(SixesWildWindow application) {
		this.application = application;
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
	 * @return the isSwapTwoTiles
	 */
	public boolean isSwapTwoTiles() {
		return isSwapTwoTiles;
	}

	/**
	 * @param isSwapTwoTiles the isSwapTwoTiles to set
	 */
	public void setSwapTwoTiles(boolean isSwapTwoTiles) {
		this.isSwapTwoTiles = isSwapTwoTiles;
	}

	/**
	 * @return the isRemoveTile
	 */
	public boolean isRemoveTile() {
		return isRemoveTile;
	}

	/**
	 * @param isRemoveTile the isRemoveTile to set
	 */
	public void setRemoveTile(boolean isRemoveTile) {
		this.isRemoveTile = isRemoveTile;
	}

	/**
	 * @param boardView the boardView to set
	 */
	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
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
	 * @return the resetBoardBtn
	 */
	public BetterButton getResetBoardBtn() {
		return resetBoardBtn;
	}

	/**
	 * @param resetBoardBtn the resetBoardBtn to set
	 */
	public void setResetBoardBtn(BetterButton resetBoardBtn) {
		this.resetBoardBtn = resetBoardBtn;
	}
	
	
	
}
