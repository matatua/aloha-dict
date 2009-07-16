package it.sk.mobile.aloha.ui;

import it.sk.mobile.aloha.controller.AlohaController;
import it.sk.mobile.aloha.controller.Controller;
import it.sk.mobile.aloha.ui.bean.MenuBean;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;

public class SearchController implements Controller
{
	private SearchCanvas canvas;
	private Command commandExit, commandGoTo;
	
	public SearchController (SearchCanvas canvas)
	{
		this.canvas = canvas;
		
		// TODO: externalize labels
		commandExit = new Command(MenuBean.EXIT, Command.EXIT, 2);
		commandGoTo = new Command(MenuBean.GOTO, Command.HELP, 1);
		
		this.canvas.addCommand(commandExit);
		this.canvas.addCommand(commandGoTo);
	}
	
	public void commandAction(Command command, Displayable displayable)
	{
		if (command == commandGoTo)
		{
			AlohaController.getInstance().switchSection(MenuBean.GOTO);
			return;
		}
		else if (command == commandExit)
		{
			AlohaController.getInstance().getAlohaMIDlet().notifyDestroyed();
		}
	}
}
