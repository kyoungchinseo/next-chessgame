package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Type;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	Piece findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		Piece targetPiece = findPiece(source);
		if (targetPiece.getType() == Type.EMPTY) {
			return;
		}
		if (source.isValid() == false || target.isValid() == false) {
			return;
		}
		Piece sourcePiece = findPiece(target);
		if (sourcePiece.matchColor(targetPiece.getColor()) == true) {
			return;
		}
		
		List<Position> positions = findPiece(source).getPossibleMoves();
		boolean includePosition = false;
		for(Position position : positions) {
			if (position.getY() == target.getY()) {
				if (position.getX() == target.getX()) {
					includePosition = true;
				}
			}
		}
		if (includePosition == false) {
			return;
		}
		
		
		sourcePiece =  targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);	
	}
	
	boolean isValidMovement(Position source, Position target) {
		Piece targetPiece = findPiece(source);
		if (targetPiece.getType() == Type.EMPTY) {
			return false;
		}
		if (source.isValid() == false || target.isValid() == false) {
			return false;
		}
		Piece sourcePiece = findPiece(target);
		if (sourcePiece.matchColor(targetPiece.getColor()) == true) {
			return false;
		}
		List<Position> positions = findPiece(target).getPossibleMoves();
		boolean includePosition = false;
		for(Position position : positions) {
			if (position.getY() == target.getY()) {
				if (position.getX() == target.getX()) {
					includePosition = true;
				}
			}
		}
		
		if (includePosition == false) {
			return false;
		}
		
		return true;
	}
	
	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + NEW_LINE);
		}
		return sb.toString();
	}
}
