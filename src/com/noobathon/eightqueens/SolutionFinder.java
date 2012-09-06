package com.noobathon.eightqueens;

import java.util.ArrayList;

public class SolutionFinder 
{
	private PuzzleGrid grid;
	private final int maxCoordinate = 8;
	private ArrayList<String> solutions;
	private int[] placements;
	private int numSolutions;
	
	public SolutionFinder()
	{
		placements = new int[maxCoordinate];
		
		for (int i = 0; i < maxCoordinate; ++i)
			placements[0] = 0;

		grid = new PuzzleGrid(maxCoordinate);
		solutions = new ArrayList<String>();
		numSolutions = 0;
	}
	
	public static void main(String args[])
	{
		SolutionFinder finder = new SolutionFinder();
		finder.run();
	}
	
	public ArrayList<String> run()
	{
		place();
		if (grid.isSolutionFound())
		{
			numSolutions++;
			solutions.add(grid.toString());
		}
		System.out.println(grid.toString());
		grid = new PuzzleGrid(maxCoordinate);
		return solutions;
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
		if (placements[i] + 1 == maxCoordinate && i != maxCoordinate)
		{
			placements[i] = 0;
			bumpColumn(i+1);
		}
		else
			placements[i]++;
	}
	
	private void place()
	{
		for (int i = 0; i < maxCoordinate; ++i)
		{
			if (grid.addQueen(new Queen(i, placements[i])))
				System.out.println("added queen @ " + i + " " + placements[0]);
		}
	}
}
