/**
 * 
 */
package src.sixeswildgame.controllers;

import java.util.ArrayList;

import src.sixeswildgame.world.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import src.levelbuilder.controllers.TileController;
import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.LevelSummaryView;
import src.sixeswildgame.view.LevelView;
import src.sixeswildgame.view.LoseGameView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Move;
import src.sixeswildgame.world.RemoveTileMove;
import src.sixeswildgame.world.Space;
import src.sixeswildgame.world.SwapTwoTilesMove;
import src.sixeswildgame.world.Tile;

/**
 * @author Matthew, havandenberg
 *
 */
public class MakeMoveController implements MouseListener{

	protected TileView tileView;
	protected Level level;
	protected SixesWildWindow application;
	
	/**
	 * Initializes new Controller
	 * 
	 * @param tileView
	 * @param level
	 * @param application
	 */
	public MakeMoveController(TileView tileView, Level level, SixesWildWindow application) {
		this.tileView = tileView;
		this.level = level;
		this.application = application;
	}
	
	/**
	 * Mouse pressed extended from Mouse Listener
	 * 
	 */
	public void mousePressed(MouseEvent me) {
		
		if (application.getLevelView().isSwapTwoTiles() && level.getSwapTwoTilesMoves() > 0) {
			if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {
				if (level.getSttMove() == null) {
					SwapTwoTilesMove newMove = new SwapTwoTilesMove(tileView.getTile(), level, application.getGameType());
					level.setSttMove(newMove);
					tileView.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
					tileView.repaint();
				}
				
				else {
					level.getSttMove().setTile2(tileView.getTile());
					level.getSttMove().doMove(level);
					try {
						updateBoard();
					} catch (FontFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					level.setSttMove(null);
					application.getLevelView().getSwapTilesCheckBox()
					.setSelected(false);
					application.getLevelView().setSwapTwoTiles(false);
				}
			}
		}
		
		else if (application.getLevelView().isRemoveTile() && level.getRemoveTileMoves() > 0) {
			if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {	
				RemoveTileMove newMove = new RemoveTileMove(tileView.getTile(), level, application.getGameType());
				newMove.doMove(level);
				try {
					updateBoard();
				} catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				application.getLevelView().getRemoveTileCheckBox().setSelected(false);
				application.getLevelView().setRemoveTile(false);
			}
		}
		
		else if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {	
			Tile tile = tileView.getTile();
			Move newMove = new Move(tileView.getTile(), level, application.getGameType());
			level.setMove(newMove);
			tileView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			tileView.repaint();
		}
	}

	/**
	 * Mouse clicked is never used but the stub is needed
	 * 
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Mouse entered called when mouse enters a tile view
	 */
	public void mouseEntered(MouseEvent arg0) {
		if (level.isMakingMove()) {				
			if (level.getMove().isAdjacent(tileView.getTile())) {
				if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {
					level.getMove().addTile(tileView.getTile());
					tileView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
					tileView.repaint();
				}
			}
			
			else if (level.getMove().getTiles().get(level.getMove().getTiles().size()-2).equals(tileView.getTile())) {
				Tile temp = level.getMove().removeLast();
				int dimension = level.getBoard().getDimension();
				application.getLevelView().getBoardView().getGrid().get(temp.getRow()*dimension + temp.getColumn()).getTileView().setBorder(null);
				application.getLevelView().getBoardView().getGrid().get(temp.getRow()*dimension + temp.getColumn()).getTileView().repaint();
			}
		}
		else {
			if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)){
				tileView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
				tileView.repaint();
			}
		}
	}

	/**
	 * Mouse exited called when mouse exits a tileview
	 * 
	 */
	public void mouseExited(MouseEvent arg0) {
		
		boolean notSwap = true;
		if (level.getSttMove() != null) {
			if (tileView.getTile().equals(level.getSttMove().getTile1())) notSwap = false;
		}
		
		
		if (!level.isMakingMove() && notSwap) tileView.setBorder(null);
		if ((application.getGameType() == 4) && (level.getBoard().getSpace(tileView.getTile().getRow(), tileView.getTile().getColumn()).isMarked())) {
			tileView.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
			tileView.repaint();
		}
	}

	/**
	 * Mouse released indicates a move is made
	 */
	public void mouseReleased(MouseEvent arg0) {
		
		if (level.isMakingMove() && !application.getLevelView().isRemoveTile() && !application.getLevelView().isSwapTwoTiles()) 
			level.getMove().doMove(level);
			try {
				updateBoard();
			} catch (FontFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	/**
	 * Updates the board view according to move made
	 * @throws IOException 
	 * @throws FontFormatException 
	 * @throws FileNotFoundException 
	 */
	public void updateBoard() throws FileNotFoundException, FontFormatException, IOException {
		  if (application.getGameType() != 3 && level.getMovesLeft() == 0) {
		    if (level.hasWon(application.getGameType())) {
		      level.setLocked(false);
		      application.setLevelSummary(new LevelSummaryView(application, level));
		      application.getLevelSummary().setPreferredSize(new Dimension(1000, 708));
		      this.application.getFrmSixesWild().setContentPane(application.getLevelSummary());
		      application.getLevelSummary().setVisible(true);
		      application.getFrmSixesWild().pack();
		      application.getFrmSixesWild().repaint();
		    }
		    else {
		      application.setLoseView(new LoseGameView(application, level));
		      application.getLoseView().setPreferredSize(new Dimension(1000, 708));
		      this.application.getFrmSixesWild().setContentPane(application.getLoseView());
		      application.getLoseView().setVisible(true);
		      application.getFrmSixesWild().pack();
		      application.getFrmSixesWild().repaint();
		    }
		  }
		
		level.setMakingMove(false);
		
		BoardView newBoardView = new BoardView(level.getBoard(), 50, 50);
		int length = newBoardView.getDimension()*newBoardView.getTileLength() + 5 * newBoardView.getDimension();
		int panelX = (1000 - length)/2;
		int panelY = (708 - length)/2;
		newBoardView.setBounds(panelX, panelY, length, length);

		application.getLevelView().setBoardView(newBoardView);
		application.getLevelView().getBoardPanel().removeAll();
		application.getLevelView().getBoardPanel().add(newBoardView);
		
		application.getLevelView().getSwapTilesCountLbl().setText(String.valueOf(level.getSwapTwoTilesMoves()));
		application.getLevelView().getRemoveTileCountLbl().setText(String.valueOf(level.getRemoveTileMoves()));
		
		for (SpaceView sv : application.getLevelView().getBoardView()
				.getGrid()) {
			TileView tv = sv.getTileView();
			tv.addMouseListener(new MakeMoveController(tv, level, application));
			if (sv.getSpace().isMarked() && application.getGameType() == 4) {
				tv.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
				tv.repaint();
			}
		}
		
		application.getLevelView().getBoardView().setVisible(true);
		application.getLevelView().updateLevelInfo();
		application.getLevelView().repaint();
		application.getFrmSixesWild().pack();
	}
}
