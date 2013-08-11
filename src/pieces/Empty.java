package pieces;

import java.util.ArrayList;
import java.util.List;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		return list;
	}
}
