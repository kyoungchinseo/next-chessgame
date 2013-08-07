package pieces;

import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		List<Position> positions = controller.findsDiagonalPositionAll();
		return positions;
	}
}