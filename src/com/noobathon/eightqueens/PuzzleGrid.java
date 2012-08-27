package com.noobathon.eightqueens;

import java.util.TreeSet;

public class PuzzleGrid {

	private int maxCoordinate;
	
	private TreeSet<GridSquare> queens;
	
	public PuzzleGrid(int s) 
	{
		this.maxCoordinate = s;
		
		queens = new TreeSet<GridSquare>();
	}
	
	public boolean addQueen(Queen queen)
	{
		if (queen.getY() <= maxCoordinate && queen.getY() > 0 && queen.getX() <= maxCoordinate && queen.getX() > 0)
		{
			invalidateSquares(queen);
			return queens.add(queen);
		}
		else
			return false;
	}
	
	public boolean removeQueen(Queen queen)
	{
		for (GridSquare s : queens)
		{
			if (s.getClass() == InvalidSquare.class && ((InvalidSquare) s).getParentQueen() == queen)
				queens.remove(s);
		}
		return queens.remove(queen);
	}
	
	private void invalidateSquares(Queen queen)
	{
		for (int i = 0; i < maxCoordinate; i++)
		{
			queens.add(new InvalidSquare(i, queen.y, queen));
			queens.add(new InvalidSquare(queen.x, i, queen));
		}
	}
}