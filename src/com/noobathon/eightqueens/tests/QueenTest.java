package com.noobathon.eightqueens.tests;


import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import com.noobathon.eightqueens.Queen;

public class QueenTest
{
	Queen queen;
	
	@Before
	public void setup()
	{
		queen = new Queen(new Point(0, 1));
	}
	
	@Test
	public void queenPositionIsAccurate()
	{
		assertEquals(new Point(0, 1), queen);
	}
	
	@Test
	public void queenPositionXAndYCoordinatesAreAccurate()
	{
		assertEquals(0, (int) queen.getX());
		assertEquals(1, (int) queen.getY());
	}
}
