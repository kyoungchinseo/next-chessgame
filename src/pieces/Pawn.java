package pieces;

import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		Direction [] direction = null;
		if (super.isWhite()) {
			if (super.getPosition().getY() == 1) {
				direction = new Direction[] {Direction.NORTH, Direction.NORTHNORTH};
			} else {
				direction = new Direction[] {Direction.NORTH};
			}
		} else if (super.isBlack()) {
			if (super.getPosition().getY() == 6) {
				direction = new Direction[] {Direction.SOUTH, Direction.SOUTHSOUTH};
			} else {
				direction = new Direction[] {Direction.SOUTH};
			}
		}
		List<Position> position = controller.findPosition(direction);
		return position;
	}
}
