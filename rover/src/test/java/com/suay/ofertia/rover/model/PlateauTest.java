package com.suay.ofertia.rover.model;

import org.junit.Assert;
import org.junit.Test;

import com.suay.ofertia.rover.BaseTest;

public class PlateauTest extends BaseTest {

	@Test
	public void onBoundsTest() {
		Rover r = new Rover(3, 3, Direction.W, plateau);
		Assert.assertTrue(plateau.isRoverOnPlateau(r));
	}

	@Test
	public void outOfBoundsTest() {
		Rover r = new Rover(3, 7, Direction.W, plateau);
		Assert.assertFalse(plateau.isRoverOnPlateau(r));
	}

}
