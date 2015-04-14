/**
 * 
 */
package src.sixeswildgame.view;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

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
	protected Level level;
	
	
	public LevelView(SixesWildWindow application, World world, Level level) {
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
		this.setLayout(null);
		
		JLabel scoreLbl = new JLabel("Score: 0000");
		scoreLbl.setFont(new Font("Avenir Next", Font.PLAIN, 40));
		scoreLbl.setBounds(611, 60, 219, 55);
		scoreLbl.setForeground(Color.decode("#D76262"));
		this.add(scoreLbl);
		
		//if (application.getGameType() == 1) {world.getPuzzleLevels()}
		
	}

	private void initializeModel() {
		// TODO Auto-generated method stub
		
	}

	private void initializeView() {
		// TODO Auto-generated method stub
		
	}

}
