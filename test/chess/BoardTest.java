package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		System.out.println(board.generateBoard());
	}
	
	public void testEmptyMove() throws Exception {
		board.initialize();
		Position source = new Position("a3");
		Position target = new Position("a4");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Empty(Color.NOCOLOR, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testValidMove() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("a0");
		board.movePiece(source,target);
		System.out.println(board.generateBoard());
	}
	
	public void testCheckAllyMove() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b2");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
	}
	
	public void testPossibleMove() throws Exception {
		board.initialize();
		Position source= new Position("a2");
		Position target= new Position("a3");
		board.movePiece(source,target);
		assertEquals(new Pawn(Color.WHITE,target), board.findPiece(target));
		System.out.println(board.generateBoard());
	
		source = new Position("b2");
		target = new Position("c3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR,target), board.findPiece(target));
		System.out.println(board.generateBoard());
		
	}
	
}
