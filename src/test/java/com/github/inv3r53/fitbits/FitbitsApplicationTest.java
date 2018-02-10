package com.github.inv3r53.fitbits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FitbitsApplicationTest {

	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_pitch_dimensions() {
		FitbitsApplication app = new FitbitsApplication();
		app.train(new int[] { -1, 0 }, new Location(1, 3, Direction.EAST), "LM");
	}

	@Test
	public void test_invalid_trainee_placement() {
		FitbitsApplication app = new FitbitsApplication();
		Location result = app.train(new int[] { 3, 3 }, new Location(4, 3, Direction.EAST), "LM");
		assertTrue(result == null);
		result = app.train(new int[] { 3, 3 }, new Location(0, -1, Direction.NORTH), "MLM");
		assertTrue(result == null);
	}

	@Test
	public void test_no_commands() {
		FitbitsApplication app = new FitbitsApplication();
		Location result = app.train(new int[] { 3, 3 }, new Location(1, 2, Direction.EAST), "");
		assertEquals(result.getDirection(), Direction.EAST);
		assertEquals(1, result.getX());
		assertEquals(2, result.getY());
	}

	@Test
	public void test_success_scenario() {
		FitbitsApplication app = new FitbitsApplication();
		Location result = app.train(new int[] { 3, 3 }, new Location(1, 1, Direction.EAST), "AMLMRX");
		assertEquals(result.getDirection(), Direction.EAST);
		assertEquals(2, result.getX());
		assertEquals(2, result.getY());
	}

}
