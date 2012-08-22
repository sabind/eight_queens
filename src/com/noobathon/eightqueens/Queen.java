package com.noobathon.eightqueens;

import java.awt.Point;

public class Queen extends Point implements Comparable<Queen>
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

	public int compareTo(Queen queen)
	{
		if (this.x == queen.x && this.y == queen.y)
			return 0;
		else
			return -1;
	}
	
	public int hashCode()
	{
		return super.hashCode();
	}
	
	public boolean equals(Queen queen) 
	{
		return super.equals(queen);
	}
	
	public String toString()
	{
		return "Q @ " + super.toString();
	}
}
