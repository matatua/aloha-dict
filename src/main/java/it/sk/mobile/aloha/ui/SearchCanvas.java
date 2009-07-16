/*
 * Copyright (C) 2007 Aram Julhakyan
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as published by
 * the Free Software Foundation.
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You can find the complete text of the license in LICENSE.TXT
 */
package it.sk.mobile.aloha.ui;

import it.sk.mobile.aloha.controller.Controller;
import it.sk.mobile.aloha.ui.utils.UIUtils;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;


/**
 * Canvas that allows the user to search for a word
 * 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class SearchCanvas extends Canvas implements CommandListener, AlohaCanvas
{
	private SearchController searchController;
	private SearchTextField searchString;
	
	public SearchCanvas ()
	{
		searchController = new SearchController (this);
		searchString = new SearchTextField ();
		
		setCommandListener(searchController);
	}
	
	
	protected void paint(Graphics graphics)
	{
		UIUtils.drawHeader(this, graphics);

		searchString.render(graphics);
	}

	public void commandAction(Command c, Displayable d)
	{
		searchController.commandAction(c, d);
	}

	public Controller getController()
	{
		return searchController;
	}


	public void focus()
	{
		searchString.setFocused(true);
		
	}
}
