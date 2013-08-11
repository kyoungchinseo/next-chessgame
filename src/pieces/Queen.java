package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		List<Position> position = controller.findPositionAll(Direction.allDirection());
		return position;
	}
}
