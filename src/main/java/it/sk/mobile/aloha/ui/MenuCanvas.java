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
 * You can find the completa text of the license in LICENSE.TXT distributed with Omnidic's source files.
 */

package it.sk.mobile.aloha.ui;

import it.sk.mobile.aloha.controller.Constants;
import it.sk.mobile.aloha.controller.Controller;
import it.sk.mobile.aloha.controller.MenuController;
import it.sk.mobile.aloha.controller.Utils;
import it.sk.mobile.aloha.ui.bean.MenuBean;
import it.sk.mobile.aloha.ui.utils.UIUtils;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

/**
 * Canvas to switch the page/function
 * 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 * @author aram
 */
public class MenuCanvas extends Canvas implements CommandListener, AlohaCanvas
{
	private MenuController menuController;
	
	/**
	 * Used to draw a simple arrow turned up or down
	 */
	private SimpleArrow arrow;
	
	public MenuCanvas(MIDlet midlet)
	{
		this.menuController = new MenuController (this);
		this.arrow = new SimpleArrow (getWidth()/2 -8, 49, 7);
		this.menuController.setLanguage();
		
		setCommandListener(menuController);
	}

	protected void paint(Graphics graphics)
	{
		UIUtils.drawHeader(this, graphics);
		
		String[] menuItems = MenuBean.getMenuItems();
		
		graphics.setColor(87, 87, 87);
		graphics.setFont(Constants.FONT_PROPORTIONAL_PLAIN_LARGE);
		
		graphics.drawString(Utils.getI18NString(menuItems[menuController.getSelectedItem()]), 
												getWidth() / 2, getHeight() / 2, 
												Graphics.BASELINE | Graphics.HCENTER);

		graphics.setColor(0, 0, 128);
		
		if (menuController.getSelectedItem() != 0)
		{
			arrow.setDirection(true);
			arrow.setY(getHeight() / 2 - Constants.FONT_PROPORTIONAL_PLAIN_LARGE.getHeight() / 2 - 4);
			arrow.render(graphics);
		}

		if (menuController.getSelectedItem() != menuItems.length - 1)
		{
			arrow.setY(getHeight() / 2 + 4);
			arrow.setDirection(false);
			arrow.render(graphics);
		}

	}

	protected void keyPressed(int keyCode)
	{
		menuController.keyPressed (keyCode);

		repaint();
	}

	public void commandAction(Command command, Displayable displayable)
	{
		menuController.commandAction(command, displayable);

		repaint();
	}

	public Controller getController()
	{
		return menuController;
	}
}
