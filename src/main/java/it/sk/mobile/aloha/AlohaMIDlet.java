package it.sk.mobile.aloha;

import it.sk.mobile.aloha.cache.SimpleCache;
import it.sk.mobile.aloha.controller.AlohaController;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * 
 * Alhoa! MIDlet provides a J2ME dictionary for MIDP/CLDC enabled devices.
 * This project has started as a refactoring of OmniDictionary.
 * 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 * @since 1.0
 * 
 */
public class AlohaMIDlet extends MIDlet
{
	private Display display;

	public void startApp() throws MIDletStateChangeException
	{
		AlohaController controller = AlohaController.getInstance();
		
		display = Display.getDisplay(this);
		controller.setAlohaMIDlet(this);
		controller.setDisplay(display);
		
		controller.start();
	}

	public void pauseApp()
	{
		// free temporary resources
		SimpleCache.getInstance().clear ();
	}

	public void destroyApp(boolean unconditional) throws MIDletStateChangeException
	{
		notifyDestroyed();
	}

	public void showException(Exception e)
	{
		Alert alert = new Alert("Error");
		alert.setString(e.getMessage());
		alert.setType(AlertType.ERROR);
		alert.setTimeout(Alert.FOREVER);
		display.setCurrent(alert);
	}
}
