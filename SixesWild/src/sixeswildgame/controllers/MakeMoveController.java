/**
 * 
 */
package src.sixeswildgame.controllers;

import java.util.ArrayList;

import src.sixeswildgame.world.Tile;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
import src.sixeswildgame.view.LevelView;
import src.sixeswildgame.view.SixesWildWindow;
import src.sixeswildgame.view.SpaceView;
import src.sixeswildgame.view.TileView;
import src.sixeswildgame.world.Board;
import src.sixeswildgame.world.Level;
import src.sixeswildgame.world.Move;
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
	
	public MakeMoveController(TileView tileView, Level level, SixesWildWindow application) {
		this.tileView = tileView;
		this.level = level;
		this.application = application;
	}
	
	public void mousePressed(MouseEvent me) {
		
		if (application.getLevelView().isSwapTwoTiles()) {
			if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {	
				Tile tile = tileView.getTile();
				Move newMove = new SwapTwoTilesMove(tileView.getTile(), level);
				level.setMove(newMove);
				tileView.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
				tileView.repaint();
			}
		}
		
		else if (application.getLevelView().isRemoveTile()) {
			if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {	
				Tile tile = tileView.getTile();
				Move newMove = new Move(tileView.getTile(), level);
				level.setMove(newMove);
				tileView.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
				tileView.repaint();
			}
		}
		
		else if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {	
			Tile tile = tileView.getTile();
			Move newMove = new Move(tileView.getTile(), level);
			level.setMove(newMove);
			tileView.setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D7B"), 5, true));
			tileView.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (level.isMakingMove()) {				
			if (level.getMove().isAdjacent(tileView.getTile())) {
				if ((tileView.getTile().getValue() < 6) && (tileView.getTile().getValue() > 0)) {
					level.getMove().addTile(tileView.getTile());
					tileView.setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D7B"), 5, true));
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
				tileView.setBorder(BorderFactory.createLineBorder(Color.decode("#FF9D7B"), 3, true));
				tileView.repaint();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (!level.isMakingMove())  tileView.setBorder(null);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		level.getMove().doMove(level);
		level.setMakingMove(false);
	}
}
