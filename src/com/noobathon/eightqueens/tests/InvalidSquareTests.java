package com.noobathon.eightqueens.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import com.noobathon.eightqueens.InvalidSquare;
import com.noobathon.eightqueens.Queen;

public class InvalidSquareTests extends EasyMockSupport
{
	private InvalidSquare square;
	private Queen queen;
	
	@Before
	public void setup()
	{
		queen = createNiceMock(Queen.class);
		square = new InvalidSquare(new Point(0, 1), queen);
	}
	
	@Test
	public void squarePositionIsAccurate()
	{
		assertEquals(new Point(0, 1), square);
	}
	
	@Test
	public void queenPositionXAndYCoordinatesAreAccurate()
	{
		assertEquals(0, (int) square.getX());
		assertEquals(1, (int) square.getY());
	}
}
