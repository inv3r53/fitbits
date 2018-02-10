package com.github.inv3r53.fitbits;

public class Location {

	private int x;
	private int y;
	private Direction direction;

	public Location(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return direction;
	}

}
