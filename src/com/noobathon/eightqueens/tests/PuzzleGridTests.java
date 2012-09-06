package com.noobathon.eightqueens.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import com.noobathon.eightqueens.PuzzleGrid;
import com.noobathon.eightqueens.Queen;

public class PuzzleGridTests
{
	private final static int S_GRID_SIZE = 8;
	
	private Queen queen, queen2;
	private PuzzleGrid grid;
	
	@Before
	public void setup()
	{
		grid = new PuzzleGrid(S_GRID_SIZE);
	}
	
	@Test
	public void canAddQueenIfFitsInGrid()
	{
		givenThatQueenIsInBounds();
		assertTrue(grid.addQueen(queen));
	}
	
	private void givenThatQueenIsInBounds() 
	{
		queen = new Queen(1, 1);
	}
	
	@Test
	public void canNotAddDuplicateQueenToSet()
	{
		givenThatQueensAreTheSame();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}
	
	private void givenThatQueensAreTheSame() 
	{
		queen = new Queen(1, 1);
		queen2 = new Queen(1, 1);
	}
	
	@Test
	public void canNotAddQueenIfDoesNotFitInGridNegatives()
	{
		givenThatQueenIsOutOfBoundsNegatives();
		assertFalse(grid.addQueen(queen));
	}

	private void givenThatQueenIsOutOfBoundsNegatives() 
	{
		queen = new Queen(-1, -1);
	}
	
	@Test
	public void canNotAddQueenIfDoesNotFitInGridPositives()
	{
		givenThatQueenIsOutOfBoundsPositives();
		assertFalse(grid.addQueen(queen));
	}
	
	private void givenThatQueenIsOutOfBoundsPositives() 
	{
		queen = new Queen(9, 9);
	}
	
	@Test
	public void canNotAddQueenOnInvalidSquareVertical()
	{
		givenThatAQueenIsTopLeft();
		givenThatSecondQueenIsBottomLeft();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}

	private void givenThatAQueenIsTopLeft() 
	{
		queen = new Queen(0, 0);
	}
	
	private void givenThatSecondQueenIsBottomLeft()
	{
		queen2 = new Queen(0, 7);
	}
	
	@Test
	public void canNotAddQueenOnInvalidSquareHorizontal()
	{
		givenThatAQueenIsTopLeft();
		givenThatSecondQueenIsTopRight();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}

	private void givenThatSecondQueenIsTopRight() 
	{
		queen2 = new Queen(7, 0);
	}
	
	@Test
	public void canNotAddQueenOnInvalidSquareDiagonalIdentity()
	{
		givenThatAQueenIsTopLeft();
		givenThatSecondQueenIsBottomRight();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}

	private void givenThatSecondQueenIsBottomRight() 
	{
		queen2 = new Queen(7, 7);
	}
	
	@Test
	public void canNotAddQueenOnInvalidSquareDiagonalAboveRightNonIdentity()
	{
		givenThatQueenIsInBounds();
		givenThatQueenIsDiagonallyAboveToTheRight();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}

	private void givenThatQueenIsDiagonallyAboveToTheRight() 
	{
		queen2 = new Queen(2, 0);
	}
	
	@Test
	public void canNotAddQueenOnInvalidSquareDiagonalBelowLeftNonIdentity()
	{
		givenThatQueenIsInBounds();
		givenThatQueenIsDiagonallyBelowToTheLeft();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}

	private void givenThatQueenIsDiagonallyBelowToTheLeft() 
	{
		queen2 = new Queen(0, 2);
	}
}
