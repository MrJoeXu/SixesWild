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
import src.sixeswildgame.world.Tile;

/**
 * @author Matthew
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
		Tile tile = tileView.getTile();
		Move newMove = new Move(tileView.getTile());
		level.setMove(newMove);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		tileView.setBorder(BorderFactory.createLineBorder(application.getGameTypeColor(), 3, true));
		tileView.repaint();
		if (level.isMakingMove()) level.getMove().addTile(tileView.getTile());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (!level.isMakingMove()) tileView.setBorder(null);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		level.getMove().doMove(level);
		level.setMakingMove(false);
	}
}
