package com.github.inv3r53.fitbits;

/**
 *Provides delta-x and delta-y for every move in any direction.
 */
public enum Direction {
	EAST(1, 0, 'E') {
		@Override
		public Direction right() {
			return SOUTH;
		}

		@Override
		public Direction left() {
			return NORTH;
		}
	},
	WEST(-1, 0, 'W') {
		@Override
		public Direction right() {
			return NORTH;
		}

		@Override
		public Direction left() {
			return SOUTH;
		}
	},
	NORTH(0, 1, 'N') {
		@Override
		public Direction right() {
			return EAST;
		}

		@Override
		public Direction left() {
			return WEST;
		}
	},
	SOUTH(0, -1, 'S') {
		@Override
		public Direction right() {
			return WEST;
		}

		@Override
		public Direction left() {
			return EAST;
		}
	};
	private final int x;
	private final int y;
	private final char directionCode;

	public abstract Direction right();

	public abstract Direction left();

	private Direction(int x, int y, char directionCode) {
		this.x = x;
		this.y = y;
		this.directionCode = directionCode;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getDirectionCode() {
		return directionCode;
	}

	public static Direction getDirection(char directionCode) {

		for (Direction d : Direction.values()) {
			if (d.getDirectionCode() == directionCode) {
				return d;
			}
		}
		return null;

	}

}
