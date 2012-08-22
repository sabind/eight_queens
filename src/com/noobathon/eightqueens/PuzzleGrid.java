package com.noobathon.eightqueens;

import java.util.TreeSet;

public class PuzzleGrid {

	private int maxXCoordinate;
	private int maxYCoordinate;
	
	private TreeSet<Queen> queens;
	
	public PuzzleGrid(int x, int y) 
	{
		this.maxXCoordinate = x;
		this.maxYCoordinate = y;
		
		queens = new TreeSet<Queen>();
	}
	
	public boolean addQueen(Queen queen)
	{
		if (queen.getY() <= maxYCoordinate && queen.getY() > 0 && queen.getX() <= maxXCoordinate && queen.getX() > 0)
			return queens.add(queen);
		else
			return false;
	}
}
