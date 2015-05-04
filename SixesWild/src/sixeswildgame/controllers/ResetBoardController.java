/**
 * 
 */
package src.sixeswildgame.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.Tile;

/**
 * @author Hvandenberg
 *
 */
public class ResetBoardController implements ActionListener {
	
	protected SixesWildWindow application;
	protected Level level;

	/**
	 * @param application
	 * @param level
	 */
	public ResetBoardController(SixesWildWindow application, Level level) {
		super();
		this.application = application;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (level.getResetBoardMoves() > 0) {
		
			ArrayList<Space> spaceGrid = new ArrayList<Space>();
			ArrayList<Integer> indices = new ArrayList<Integer>();
			
			for (Space sp: level.getBoard().getGrid()) {
				if (sp.isEnabled() && sp.getTile().getValue() != 6 && sp.getTile().getValue() != 7) {
					spaceGrid.add(sp);
					indices.add(sp.getTile().getRow() * level.getBoard().getDimension() + sp.getTile().getColumn());
				}
			}
			
			Collections.shuffle(spaceGrid, new Random(42));
			
			int i = 0;
			int j = 0;
			int k = 0;
			
			for (int l = 0; l < level.getBoard().getDimension() * level.getBoard().getDimension(); l++) {
				if (level.getBoard().getGrid().get(l).getTile().getValue() != 6
						&& level.getBoard().getGrid().get(l).getTile().getValue() != 7
						&& level.getBoard().getGrid().get(l).isEnabled()) {
					level.getBoard().getGrid().get(l).setTile(new Tile(spaceGrid.get(k).getTile().getValue(),
							spaceGrid.get(k).getTile().getBonus(), i, j, spaceGrid.get(k).getTile().getLastValue(),
							spaceGrid.get(k).getTile().getLastBonus(), spaceGrid.get(k).getTile().isSelected()));
					k++;
				}
				j++;
				if (j == level.getBoard().getDimension()) {
					j = 0;
					i++;
				}
				System.out.println("Row: " + level.getBoard().getGrid().get(k).getTile().getRow() + ", Column: " + 
						level.getBoard().getGrid().get(k).getTile().getColumn());
			}
			
			level.setResetBoardMoves(level.getResetBoardMoves() - 1);
			
			BoardView newBoardView = new BoardView(level.getBoard(), 50, 50);
			int length = newBoardView.getDimension()*newBoardView.getTileLength() + 5 * newBoardView.getDimension();
			int panelX = (1000 - length)/2;
			int panelY = (708 - length)/2;
			newBoardView.setBounds(panelX, panelY, length, length);

			application.getLevelView().setBoardView(newBoardView);
			application.getLevelView().getBoardPanel().removeAll();
			application.getLevelView().getBoardPanel().add(newBoardView);
			
			application.getLevelView().getResetBoardCountLbl().setText(String.valueOf(level.getResetBoardMoves()));
			
			for (SpaceView sv : application.getLevelView().getBoardView()
					.getGrid()) {
				TileView tv = sv.getTileView();
				tv.addMouseListener(new MakeMoveController(tv, level, application));
			}
			
			application.getLevelView().getBoardView().setVisible(true);
			application.getLevelView().updateLevelInfo();
			
			application.getLevelView().repaint();
			application.getFrmSixesWild().pack();
		
		}
		
	}
	
}
