package it.sk.mobile.aloha.ui;

import it.sk.mobile.aloha.controller.Constants;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public class SearchTextField extends Widget
{
	private String searchString;
	private AreaBean areaBean;
	private boolean focused;
	private Font font;
	private int cursorPosition;
	
	public SearchTextField ()
	{
		searchString = new String ();
		font = Constants.FONT_SYSTEM_PLAIN_SMALL;

		areaBean = new AreaBean ();
		
		areaBean.y = 30;
		areaBean.x = 2;
		areaBean.height = 17;
		
		focused = false;
		cursorPosition = areaBean.x;
	}

	public void render(Graphics graphics)
	{
		// gray background
		graphics.setColor(223, 223, 223);

		if (areaBean.width < 0)
		{
			areaBean.width = graphics.getClipWidth() - 5;
		}
		
		graphics.fillRect(areaBean.x, areaBean.y, areaBean.width, areaBean.height);
		
		if (isFocused())
		{
			// draw cursor
			graphics.setColor(0);
			graphics.drawLine(cursorPosition, areaBean.y -2, cursorPosition, areaBean.height - 2);
		}
	}
	
	private boolean isFocused()
	{
		return focused;
	}
	
	public void setFocused (boolean focused)
	{
		this.focused = focused;
	}

	private class AreaBean
	{
		int x = -1, y = -1, width = -1, height = -1;
	}

}
