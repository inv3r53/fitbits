package com.github.inv3r53.fitbits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

	@Test
	public void begin_east_direction_transition_next_states() {
		Direction currentDirection = Direction.EAST;
		assertEquals(Direction.NORTH, currentDirection.left());
		assertEquals(Direction.SOUTH, currentDirection.right());
		assertEquals(1, currentDirection.getX());
		assertEquals(0, currentDirection.getY());
	}

	@Test
	public void begin_west_direction_transition_next_states() {
		Direction currentDirection = Direction.WEST;
		assertEquals(Direction.SOUTH, currentDirection.left());
		assertEquals(Direction.NORTH, currentDirection.right());
		assertEquals(-1, currentDirection.getX());
		assertEquals(0, currentDirection.getY());
	}

	@Test
	public void begin_north_direction_transition_next_states() {
		Direction currentDirection = Direction.NORTH;
		assertEquals(Direction.WEST, currentDirection.left());
		assertEquals(Direction.EAST, currentDirection.right());
		assertEquals(0, currentDirection.getX());
		assertEquals(1, currentDirection.getY());
	}

	@Test
	public void begin_south_direction_transition_next_states() {
		Direction currentDirection = Direction.SOUTH;
		assertEquals(Direction.EAST, currentDirection.left());
		assertEquals(Direction.WEST, currentDirection.right());
		assertEquals(0, currentDirection.getX());
		assertEquals(-1, currentDirection.getY());
	}
}
