package it.sk.mobile.aloha.ui;

import javax.microedition.lcdui.Graphics;

/**
 * Draws a triangular arrow
 * 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 * 
 */
public class SimpleArrow
{
	/**
	 * Geometric dimensions/position
	 */
	private int x, y, size;

	/**
	 * False: the arrow points down, True: the arrow points up
	 */
	private boolean direction;

	public void setX(int x)
	{
		this.x = x;
	}

	public void setDirection(boolean direction)
	{
		this.direction = direction;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public SimpleArrow(int x, int y, int size)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		direction = true;
	}

	public void render(Graphics g)
	{

		for (int i = 0; i < size; i++)
		{
			if (direction)
			{
				g.drawLine(x + i, y, x + i, y - i);
				g.drawLine(x + i + size, y, x + i + size, y - size + i);
			} 
			else
			{
				g.drawLine(x + i, y, x + i, y + i);
				g.drawLine(x + i + size, y, x + i + size, y + size - i);
			}
		}
	}
}
