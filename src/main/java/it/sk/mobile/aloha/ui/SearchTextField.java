package it.sk.mobile.aloha.ui;

import javax.microedition.lcdui.Graphics;

public class SearchTextField extends Widget
{
	private String searchString;
	private AreaBean areaBean;
	
	public SearchTextField ()
	{
		searchString = new String ();

		areaBean = new AreaBean ();
		
		areaBean.y = 30;
		areaBean.x = 2;
		areaBean.height = 17;
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
	}
	
	private class AreaBean
	{
		int x = -1, y = -1, width = -1, height = -1;
	}

}
