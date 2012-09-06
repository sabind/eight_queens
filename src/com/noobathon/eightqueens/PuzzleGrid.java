package com.noobathon.eightqueens;

import java.util.TreeSet;

public class PuzzleGrid {

	private int maxCoordinate;
	private int numQueens;
	
	private TreeSet<GridSquare> queens;
	
	
	public PuzzleGrid(int s) 
	{
		this.maxCoordinate = s;
		numQueens = 0;
		queens = new TreeSet<GridSquare>(new SquareComparator());
	}
	
	public boolean addQueen(Queen queen)
	{
		if (queen.getY() < maxCoordinate && queen.getY() >= 0 && queen.getX() < maxCoordinate && queen.getX() >= 0 && queens.add(queen))
		{
			invalidateSquares(queen);
			numQueens++;
			return true;
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
		numQueens--;
		return queens.remove(queen);
	}
	
	private void invalidateSquares(Queen queen)
	{
		for (int i = 0; i < maxCoordinate; i++)
		{
			if (queen.x != i)
				queens.add(new InvalidSquare(i, queen.y, queen));
			
			if (queen.y != i)
				queens.add(new InvalidSquare(queen.x, i, queen));
			
			if (coordinateIsInGrid(queen.x - i, queen.y - i))
			{
				queens.add(new InvalidSquare(queen.x - i, queen.y - i, queen));
			}
			
			if (coordinateIsInGrid(queen.x + i, queen.y + i))
			{
				queens.add(new InvalidSquare(queen.x + i, queen.y + i, queen));
			}
			
			if (coordinateIsInGrid(queen.x - i, queen.y + i))
			{
				queens.add(new InvalidSquare(queen.x - i, queen.y + i, queen));
			}
			
			if (coordinateIsInGrid(queen.x + i, queen.y - i))
			{
				queens.add(new InvalidSquare(queen.x + i, queen.y - i, queen));
			}
		}
	}
	
	private boolean coordinateIsInGrid(int x, int y)
	{
		return x >= 0 && x < maxCoordinate && y >= 0 && y < maxCoordinate;
	}
	
	public boolean isSolutionFound()
	{
		return numQueens == maxCoordinate;
	}
	
	public String toString()
	{
		String rtn ="  ";
		for (int i = 0; i < maxCoordinate; ++i)
			rtn += i + " ";
		rtn += "\n";
		
		String[][] solutionSpace = new String[maxCoordinate][maxCoordinate];
		
		for (GridSquare square : queens)
		{
			if (square.getClass() == Queen.class)
				solutionSpace[square.x][square.y] = "Q";
			else if(square.getClass() == InvalidSquare.class)
				solutionSpace[square.x][square.y] ="X";
		}
		
		for (int i = 0; i < maxCoordinate; ++i)
		{
			rtn += i + " ";
			for (int k = 0; k < maxCoordinate; ++k)
			{
				if (solutionSpace[k][i] == null)
					rtn += "-";
				else
					rtn += solutionSpace[k][i];
				rtn += " ";
			}
			rtn +="\n";
		}
		
		return rtn;
	}
}
