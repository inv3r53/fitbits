package com.github.inv3r53.fitbits;

/**
 * Represent a trainee holding its location.
 */
public class Trainee {
	private int x;
	private int y;
	private Direction currentDirection;
	private final int xMax;
	private final int yMax;

	Trainee(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public void move() {

		int dx = currentDirection.getX();
		int dy = currentDirection.getY();

		if (!isValidLocation(x + dx, y + dy)) {
			// Instruction to move to invalid location will be ignored.
			return;
		}
		x = x + dx;
		y = y + dy;
	}

	public void turnLeft() {
		currentDirection = currentDirection.left();
	}

	public void turnRight() {
		currentDirection = currentDirection.right();
	}

	public Location getCurrentLocation() {
		return new Location(x, y, currentDirection);
	}

	public boolean place(Location location) {
		if (!isValidLocation(location.getX(), location.getY()) || location.getDirection() == null) {
			// bad initial placement of the trainee.
			return false;
		}
		this.x = location.getX();
		this.y = location.getY();
		this.currentDirection = location.getDirection();
		return true;
	}

	private boolean isValidLocation(int x, int y) {
		return x >= 0 && x <= xMax && y >= 0 && y <= yMax;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

}
