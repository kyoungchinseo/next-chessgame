package pieces;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),
	NORTHNORTHWEST(-1, 2),
	NORTHNORTHEAST( 1, 2),
	SOUTHSOUTHWEST(-1,-2),
	SOUTHSOUTHEAST( 1,-2),
	WESTWESTNORTH(-2, 1),
	WESTWESTSOUTH(-2,-1),
	EASTEASTNORTH( 2, 1),
	EASTEASTSOUTH( 2,-1),
	NORTHNORTH( 0, 2),
	SOUTHSOUTH( 0,-2);

	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}
	
	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	}

	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}
	
	public static Direction[] allDirection() {
		return new Direction[] {NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST};
	}
	
	public static Direction[] knightDirection() {
		return new Direction[] {NORTHNORTHWEST,NORTHNORTHEAST,SOUTHSOUTHWEST,SOUTHSOUTHEAST,
								WESTWESTNORTH,WESTWESTSOUTH,EASTEASTNORTH,EASTEASTSOUTH};
	}
	
}
