package pieces;

import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		Direction [] direction = {Direction.NORTH};
		if (super.isWhite()) {
			direction[0] = Direction.NORTH;
		} else if (super.isBlack()) {
			direction[0] = Direction.SOUTH;
		}
		List<Position> position = controller.findPosition(direction);
		return position;
	}
}
