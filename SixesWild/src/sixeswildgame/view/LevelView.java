/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		
		BoardView boardView = new BoardView(level.getBoard());
		boardView.setBounds(370, 149, 700, 700);
		this.add(boardView);
		
	}

}
