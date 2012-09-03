package com.noobathon.eightqueens;

import java.util.ArrayList;

public class SolutionFinder 
{
	public static void main(String[] args)
	{
		PuzzleGrid grid = new PuzzleGrid(8);
		ArrayList<String> solutions = new ArrayList<String>();
		
		grid.addQueen(new Queen(1, 1));
		grid.addQueen(new Queen(7, 0));
		int numSolutions = 0;
		
		/*
		while (numSolutions <= 12)
		{
			while(true)
			{
				if (grid.isSolutionFound())
				{
					solutions.add(grid.toString());
					break;
				}
			}
		}
		*/
		
		System.out.println(grid.toString());
	}
}
