package com.noobathon.eightqueens;

import java.util.ArrayList;

public class SolutionFinder 
{
	private PuzzleGrid grid;
	private final int maxCoordinate = 8;
	private ArrayList<String> solutions;
	private int[] placements;
	private int numSolutions;
	private int solutionsExplored = 0;
	
	public SolutionFinder()
	{
		placements = new int[maxCoordinate];
		for (int i = 0; i < maxCoordinate; ++i)
			placements[i] = 0;

		grid = new PuzzleGrid(maxCoordinate);
		solutions = new ArrayList<String>();
		numSolutions = 0;
	}
	
	public static void main(String args[])
	{
		SolutionFinder finder = new SolutionFinder();
		ArrayList<String> solutions = finder.run();
		for(String solution : solutions)
			System.out.println(solution);
		System.out.println(finder.getSolutionsFound() + " of 96.");
		System.out.println(finder.getSolutionsExplored());
	}
	
	private int getSolutionsFound() 
	{
		return numSolutions;
	}

	public String getSolutionsExplored()
	{
		return "Solutions Explored = " + solutionsExplored;
	}
	
	public ArrayList<String> run()
	{
		while (!noMoreIterations())
		{	
			placeAndBump(0);
			if (grid.isSolutionFound())
			{
				numSolutions++;
				solutions.add(grid.toString());
				grid = new PuzzleGrid(maxCoordinate);
			}
			grid = new PuzzleGrid(maxCoordinate);
		}
		return solutions;
	}
	
	private boolean noMoreIterations() 
	{
		for (int i = 0; i < maxCoordinate; ++i)
			if (placements[i] != (maxCoordinate - 1))
				return false;
		System.out.println("ran out of itrs");
		for (int i = 0; i < maxCoordinate; ++i)
			System.out.print(placements[i] + " ");
		System.out.println("");
		return true;
	}

	private void placeAndBump(int i)
	{
		place();
		bumpColumn(i);
	}
	
	private void resetColumn(int i)
	{
		placements[i] = 0;
	}
	
	private void bumpColumn(int i)
	{
		if (placements[i] == (maxCoordinate-1))
		{
			resetColumn(i);
			bumpColumn(i+1);
		}
		else if (i != maxCoordinate)
			placements[i] = placements[i] + 1;
	}
	
	private void place()
	{
		solutionsExplored++;
		for (int i = 0; i < maxCoordinate; ++i)
		{
			grid.addQueen(new Queen(i, placements[i]));
		}
	}
}
