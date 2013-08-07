package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findPositionAll(Direction[] directions) {
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : directions) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
}
