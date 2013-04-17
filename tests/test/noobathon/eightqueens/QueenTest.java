package test.noobathon.eightqueens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import com.noobathon.eightqueens.InvalidSquare;
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
	
	@Test
	public void twoQueensSameInSquareCompareIsZero()
	{
		Queen queen2 = new Queen(new Point(0, 1));
		assertEquals(0, queen.compareTo(queen2));
	}
	
	@Test
	public void twoQueensInDifferentSquaresCompareIsNotZero()
	{
		Queen queen2 = new Queen(new Point(1, 1));
		boolean result = 0 != queen.compareTo(queen2);
		assertTrue(result);
	}
	
	@Test
	public void aQueenAndInvalidSquareCompareIsZeroIfSamePosition()
	{
		InvalidSquare square = new InvalidSquare(new Point(1, 1), queen);
		Queen queen2 = new Queen(new Point(1, 1));
		assertEquals(0, square.compareTo(queen2));
	}
	
	@Test
	public void aQueenAndInvalidSquareCompareIsNotZeroIfDifferentPosition()
	{
		InvalidSquare square = new InvalidSquare(new Point(1, 1), queen);
		Queen queen2 = new Queen(new Point(1, 0));
		boolean result = 0 != square.compareTo(queen2);
		assertTrue(result);
	}
}
