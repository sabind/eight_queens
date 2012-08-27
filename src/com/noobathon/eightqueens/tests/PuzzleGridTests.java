package com.noobathon.eightqueens.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import com.noobathon.eightqueens.GridSquare;
import com.noobathon.eightqueens.PuzzleGrid;
import com.noobathon.eightqueens.Queen;

public class PuzzleGridTests extends EasyMockSupport
{
	private final static int S_GRID_SIZE = 8;
	
	private Queen queen, queen2;
	private PuzzleGrid grid;
	
	@Before
	public void setup()
	{
		grid = new PuzzleGrid(S_GRID_SIZE);
		queen = createNiceMock(Queen.class);
		queen2 = createNiceMock(Queen.class);
	}
	
	@Test
	public void canAddQueenIfFitsInGrid()
	{
		givenThatQueenIsInBounds();
		givenThatQueenIsNotAlreadyInSet();
		replayAll();
		assertTrue(grid.addQueen(queen));
	}
	
	private void givenThatQueenIsInBounds() 
	{
		EasyMock.expect(queen.getX()).andStubReturn(1.0);
		EasyMock.expect(queen.getY()).andStubReturn(1.0);
	}
	
	private void givenThatQueenIsNotAlreadyInSet() {
		EasyMock.expect(queen.compareTo(EasyMock.<GridSquare>anyObject())).andStubReturn(new Integer(-1));
	}
	
	@Test
	public void canNotAddDuplicateQueenToSet()
	{
		givenThatQueensAreTheSame();
		replayAll();
		assertTrue(grid.addQueen(queen));
		assertFalse(grid.addQueen(queen2));
	}
	
	private void givenThatQueensAreTheSame() 
	{
		EasyMock.expect(queen.getX()).andStubReturn(1.0);
		EasyMock.expect(queen.getY()).andStubReturn(1.0);
		EasyMock.expect(queen.compareTo(EasyMock.<GridSquare>anyObject())).andStubReturn(new Integer(-1));
		
		EasyMock.expect(queen2.getX()).andStubReturn(1.0);
		EasyMock.expect(queen2.getY()).andStubReturn(1.0);
	}
	
	@Test
	public void canNotAddQueenIfDoesNotFitInGridNegatives()
	{
		givenThatQueenIsOutOfBoundsNegatives();
		replayAll();
		assertFalse(grid.addQueen(queen));
	}

	private void givenThatQueenIsOutOfBoundsNegatives() 
	{
		EasyMock.expect(queen.getX()).andStubReturn(-1.0);
		EasyMock.expect(queen.getY()).andStubReturn(-1.0);
	}
	
	@Test
	public void canNotAddQueenIfDoesNotFitInGridPositives()
	{
		givenThatQueenIsOutOfBoundsPositives();
		replayAll();
		assertFalse(grid.addQueen(queen));
	}
	
	private void givenThatQueenIsOutOfBoundsPositives() 
	{
		EasyMock.expect(queen.getX()).andStubReturn(9.0);
		EasyMock.expect(queen.getY()).andStubReturn(9.0);
	}
}
