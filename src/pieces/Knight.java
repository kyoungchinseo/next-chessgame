package pieces;

import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		List<Position> position = controller.findPosition(Direction.knightDirection());
		return position;
	}
}
