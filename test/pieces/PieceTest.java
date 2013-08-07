package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
	
	public void testEmptyPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece empty = new Empty(Color.NOCOLOR, source);
		assertEquals(0, empty.getPossibleMoves().size());
	}
	
	public void testRookPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece rook = new Rook(Color.WHITE,source);
		assertEquals(14, rook.getPossibleMoves().size());
		System.out.println(rook.getPossibleMoves());
	}
	
	public void testBishopPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece bishop = new Bishop(Color.WHITE,source);
		assertEquals(11, bishop.getPossibleMoves().size());
		System.out.println(bishop.getPossibleMoves());
	}
	
	public void testQueenPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece queen = new Queen(Color.WHITE,source);
		assertEquals(25, queen.getPossibleMoves().size());
		System.out.println(queen.getPossibleMoves());
	}
	
	public void testKingPossibleMove() throws Exception {
		Position source = new Position("c1");
		Piece king = new King(Color.WHITE,source);
		assertEquals(5, king.getPossibleMoves().size());
		System.out.println(king.getPossibleMoves());
	}
		
	public void testPawnPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece pawn1 = new Pawn(Color.BLACK, source);
		assertEquals(1, pawn1.getPossibleMoves().size());
		System.out.println(pawn1.getPossibleMoves());
		
		Piece pawn2 = new Pawn(Color.WHITE, source);
		assertEquals(1, pawn2.getPossibleMoves().size());
		System.out.println(pawn2.getPossibleMoves());
	}
	
	public void testPawnPossibleMoveStaringPosition() throws Exception {
		Piece pawn;		
		pawn = new Pawn(Color.BLACK, new Position("c4"));
		assertEquals(1,pawn.getPossibleMoves().size());
		System.out.println(pawn.getPossibleMoves());
		
		pawn = new Pawn(Color.BLACK, new Position("c7"));
		assertEquals(2,pawn.getPossibleMoves().size());
		System.out.println(pawn.getPossibleMoves());
		
		pawn = new Pawn(Color.WHITE, new Position("c4"));
		assertEquals(1,pawn.getPossibleMoves().size());
		System.out.println(pawn.getPossibleMoves());
	
		pawn = new Pawn(Color.WHITE, new Position("c2"));
		assertEquals(2,pawn.getPossibleMoves().size());
		System.out.println(pawn.getPossibleMoves());
	}
	
	public void testKnightPossibleMove() throws Exception {
		Position source = new Position("c4");
		Piece knight = new Knight(Color.WHITE,source);
		assertEquals(8, knight.getPossibleMoves().size());
		System.out.println(knight.getPossibleMoves());
	}
}	
