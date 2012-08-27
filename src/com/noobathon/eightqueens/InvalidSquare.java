package com.noobathon.eightqueens;

import java.awt.Point;

public class InvalidSquare extends GridSquare implements Comparable<GridSquare>
{
	private static final long serialVersionUID = -6642784888748013967L;
	
	private Queen parentQueen;
	
	public InvalidSquare(int x, int y, Queen queen) {
		super(x, y);
		this.parentQueen = queen;
	}

	public InvalidSquare(Point point, Queen queen) {
		super(point);
		this.parentQueen = queen;
	}
	
	public Queen getParentQueen()
	{
		return parentQueen;
	}

}
