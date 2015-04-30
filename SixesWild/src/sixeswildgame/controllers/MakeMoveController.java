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

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.view.BoardView;
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
	
	public MakeMoveController(TileView tileView, Level level) {
		this.tileView = tileView;
		this.level = level;
	}
	
	public void mousePressed(MouseEvent me) {
		Move newMove = new Move(tileView.getTile());
		level.setMove(newMove);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (!level.isMakingMove()) tileView.setBackground(Color.GREEN);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (!level.isMakingMove()) tileView.setBackground(Color.BLACK);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (level.getMove().isValid()) level.getMove().doMove(level);
		
	}

}
