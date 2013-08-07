package pieces;

import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		List<Position> position = controller.findPosition(Direction.allDirection());
		return position;
	}
}

