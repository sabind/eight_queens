package com.noobathon.eightqueens;

import java.awt.Point;

public class Queen extends GridSquare implements Comparable<GridSquare>
{
	private static final long serialVersionUID = 9168110980389974856L;
	
	public Queen(Point position) 
	{
		super(position);
	}
	
	public Queen(int x, int y) 
	{
		super(x, y);
	}
	
	public String toString()
	{
		return "Q @ " + super.toString();
	}
}
