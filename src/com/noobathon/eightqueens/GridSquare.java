package com.noobathon.eightqueens;

import java.awt.Point;

public class GridSquare extends Point implements Comparable<GridSquare>
{
	private static final long serialVersionUID = 4072082330538730890L;
	
	public GridSquare(Point position) 
	{
		super(position);
	}
	
	public GridSquare(int x, int y) 
	{
		super(x, y);
	}
	
	public int compareTo(GridSquare square)
	{
		if (getX() == square.getX() && getY() == square.getY())
			return 0;
		else
			return 1;
	}
	
	public int hashCode()
	{
		return super.hashCode();
	}
	
	public boolean equals(GridSquare square) 
	{
		return super.equals(square);
	}
}
