package pieces;

import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.getPosition());
		List<Position> positions = controller.findPositionAll(Direction.linearDirection());
		return positions;
	}
}
