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
import it.sk.mobile.aloha.controller.MenuController;
import it.sk.mobile.aloha.ui.bean.MenuBean;
import it.sk.mobile.aloha.ui.utils.UIUtils;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextField;


/**
 * Canvas that allows the user to search for a word
 * 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class SearchCanvas extends Canvas implements CommandListener, AlohaCanvas
{
	private MenuController menuController;
	private SearchTextField searchString;
	
	public SearchCanvas ()
	{
		searchString = new SearchTextField ();
	}
	
	
	protected void paint(Graphics graphics)
	{
		UIUtils.drawHeader(this, graphics);

		searchString.render(graphics);
	}

	public void commandAction(Command c, Displayable d)
	{
		// TODO Auto-generated method stub
		
	}

	public Controller getController()
	{
		
		return menuController;
	}
}
