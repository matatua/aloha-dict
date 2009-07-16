/**
 * 
 */
package it.sk.mobile.aloha.controller;

import it.sk.mobile.aloha.ui.MenuCanvas;
import it.sk.mobile.aloha.ui.bean.MenuBean;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class MenuController implements Controller
{
	private MenuCanvas canvas;
	private int selectedItem;
	private Command commandExit;
	
	public MenuController (MenuCanvas canvas)
	{
		this.canvas = canvas;
		this.selectedItem = 0;
		
		commandExit = new Command(MenuBean.EXIT, Command.EXIT, 2);
		
		this.canvas.addCommand(commandExit);
	}
	
	public void keyPressed(int keyCode)
	{
		if (canvas.getGameAction(keyCode) == Canvas.UP || keyCode == Canvas.KEY_NUM2 || keyCode == Canvas.KEY_NUM0)
		{
			// go back in the menu
			rotateBack();
		}
		if (canvas.getGameAction(keyCode) == Canvas.DOWN || keyCode == Canvas.KEY_NUM8 || keyCode == Canvas.KEY_POUND)
		{
			// go forth in the menu
			rotateForth();
		}
		if (canvas.getGameAction(keyCode) == Canvas.FIRE || keyCode == Canvas.KEY_NUM5)
		{
			String item = MenuBean.getMenuItems()[selectedItem];
			if (MenuBean.EXIT.compareTo(item) == 0)
			{
				commandAction (commandExit, canvas);
				return;
			}
			
			AlohaController.getInstance().switchSection (MenuBean.getMenuItems()[selectedItem]);
		}
	}
	
	public void commandAction(Command command, Displayable displayable)
	{
		if (command == commandExit)
		{
			AlohaController.getInstance().getAlohaMIDlet().notifyDestroyed();
		}
	}
	
	public int getSelectedItem ()
	{
		return this.selectedItem;
	}
	
	public void rotateBack ()
	{
		selectedItem--;
		if (selectedItem < 0)
		{
			selectedItem = 0;
		}
	}
	
	public void rotateForth ()
	{
		String[] menuItems = MenuBean.getMenuItems();
		
		selectedItem++;
		if (selectedItem >= menuItems.length)
		{
			selectedItem = menuItems.length - 1;
		}
	}
	
	public void setLanguage()
	{
		canvas.removeCommand(commandExit);

		// commandExit = new Command(midlet.cfg.getPalabra("salir"),
		// Command.EXIT, 2);
		// commandHelp = new Command(midlet.cfg.getPalabra("ayuda"),
		// Command.HELP, 1);
		// commandBack = new Command(midlet.cfg.getPalabra("volver"),
		// Command.BACK, 1);

		commandExit = new Command("Exit", Command.EXIT, 2);

		canvas.addCommand(commandExit);

	}
}
