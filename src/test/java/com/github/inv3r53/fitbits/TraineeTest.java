package com.github.inv3r53.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class TraineeTest {

	@Test
	public void test_trainee_placement() {
		Trainee trainee = new Trainee(5, 5);
		assertFalse(trainee.place(new Location(6, 3, Direction.EAST)));
		assertFalse(trainee.place(new Location(3, 6, Direction.EAST)));
		assertFalse(trainee.place(new Location(6, 6, Direction.EAST)));
		assertFalse(trainee.place(new Location(3, 3, null)));
		assertFalse(trainee.place(new Location(-1, 3, Direction.NORTH)));
		assertTrue(trainee.place(new Location(1, 3, Direction.WEST)));
	}

	@Test
	public void test_trainee_boundary_movement() {
		Trainee trainee = new Trainee(5, 5);
		assertTrue(trainee.place(new Location(4, 4, Direction.NORTH)));
		trainee.move();
		trainee.move();
		assertEquals(trainee.getY(), 5);
		assertEquals(trainee.getX(), 4);
		assertEquals(trainee.getCurrentDirection(), Direction.NORTH);
		assertTrue(trainee.place(new Location(1, 5, Direction.WEST)));
		trainee.move();
		trainee.move();
		assertEquals(trainee.getX(), 0);
		assertEquals(trainee.getY(), 5);
		assertEquals(trainee.getCurrentDirection(), Direction.WEST);
		assertTrue(trainee.place(new Location(4, 3, Direction.EAST)));
		trainee.move();
		trainee.move();
		assertEquals(trainee.getX(), 5);
		assertEquals(trainee.getY(), 3);
		assertEquals(trainee.getCurrentDirection(), Direction.EAST);
		assertTrue(trainee.place(new Location(4, 1, Direction.SOUTH)));
		trainee.move();
		trainee.move();
		assertEquals(trainee.getX(), 4);
		assertEquals(trainee.getY(), 0);
		assertEquals(trainee.getCurrentDirection(), Direction.SOUTH);
	}

	@Test
	public void test_trainee_directions() {
		Trainee trainee = new Trainee(5, 5);
		assertTrue(trainee.place(new Location(2, 3, Direction.NORTH)));
		trainee.turnLeft();
		assertTrue(trainee.place(new Location(2, 3, Direction.WEST)));
		trainee.turnLeft();
		assertTrue(trainee.place(new Location(2, 3, Direction.SOUTH)));
		trainee.turnLeft();
		assertTrue(trainee.place(new Location(2, 3, Direction.EAST)));
		trainee.turnLeft();
		assertTrue(trainee.place(new Location(2, 3, Direction.NORTH)));
		trainee.turnRight();
		assertEquals(trainee.getX(), 2);
		assertEquals(trainee.getY(), 3);
		assertTrue(trainee.place(new Location(2, 3, Direction.EAST)));
		trainee.turnRight();
		assertTrue(trainee.place(new Location(2, 3, Direction.SOUTH)));
		trainee.turnRight();
		assertTrue(trainee.place(new Location(2, 3, Direction.WEST)));
		trainee.turnRight();
		assertTrue(trainee.place(new Location(2, 3, Direction.NORTH)));
		assertEquals(trainee.getX(), 2);
		assertEquals(trainee.getY(), 3);
	}

}
