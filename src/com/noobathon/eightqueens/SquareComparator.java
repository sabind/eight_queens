package com.noobathon.eightqueens;

import java.util.Comparator;

public class SquareComparator implements Comparator<GridSquare>
{
	@Override
	public int compare(GridSquare square1, GridSquare square2)
	{
		if (square1.getX() == square2.getX() && square1.getY() == square2.getY())
			return 0;
		else
			return 1;
	}
}
