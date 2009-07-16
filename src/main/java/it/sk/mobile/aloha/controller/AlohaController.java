/**
 * 
 */
package it.sk.mobile.aloha.controller;

import it.sk.mobile.aloha.AlohaMIDlet;
import it.sk.mobile.aloha.ui.AlohaCanvas;
import it.sk.mobile.aloha.ui.MenuCanvas;
import it.sk.mobile.aloha.ui.SearchCanvas;
import it.sk.mobile.aloha.ui.bean.MenuBean;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class AlohaController implements CommandListener
{
	private static AlohaController instance;
	
	// our beloved MIDlet
	private AlohaMIDlet alohaMIDlet;
	
	private Display display;
	
	// lazy initialization will occur on demand
	private MenuCanvas menuCanvas;
	private SearchCanvas searchCanvas;
	
	private AlohaController ()
	{
	}
	
	/* (non-Javadoc)
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command, javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command c, Displayable d)
	{
		// TODO Auto-generated method stub

	}
	
	public void start ()
	{
		Displayable canvas = resolveCanvas(MenuBean.SEARCH);
		display.setCurrent(canvas);
	}
	
	public void setAlohaMIDlet (AlohaMIDlet midlet)
	{
		this.alohaMIDlet = midlet;
	}
	
	public AlohaMIDlet getAlohaMIDlet ()
	{
		return alohaMIDlet;
	}
	
	public void setDisplay (Display display)
	{
		this.display = display;
	}

	public static AlohaController getInstance ()
	{
		if (instance == null)
		{
			instance = new AlohaController ();
		}
		
		return instance;
	}

	public void switchSection(String label)
	{
		Displayable nextDisplayable = resolveCanvas (label);
		
		nextDisplayable.setCommandListener(((AlohaCanvas)nextDisplayable).getController ());
		display.setCurrent(nextDisplayable);
	}
	
	protected Displayable resolveCanvas (String label)
	{
		Displayable displayable = display.getCurrent ();
		
		if (label.compareTo(MenuBean.SEARCH) == 0)
		{
			if (searchCanvas == null)
			{
				searchCanvas = new SearchCanvas ();
				searchCanvas.focus();
			}
			displayable = searchCanvas;
		}
		
		if (label.compareTo(MenuBean.GOTO) == 0)
		{
			if (menuCanvas == null)
			{
				menuCanvas = new MenuCanvas (getAlohaMIDlet());
				menuCanvas.focus();
			}
			displayable = menuCanvas;
		}

		// default: stay where we are
		return displayable;
	}
}
