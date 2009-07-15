/**
 * 
 */
package it.sk.mobile.aloha.ui.utils;

import it.sk.mobile.aloha.controller.Constants;

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class UIUtils
{
	public static void drawHeader (Displayable displayable, Graphics graphics)
	{
		int width = displayable.getWidth();
		int height = displayable.getHeight();
		
		graphics.setColor(255, 255, 255);
		graphics.fillRect(0, 0, width, height);
		
		// draw the application name
		graphics.setColor(128, 0, 0);
		graphics.setFont(Constants.FONT_PROPORTIONAL_BOLD_LARGE);
		graphics.drawString(Constants.APPLICATION_NAME, width / 2, 20, Graphics.BASELINE | Graphics.HCENTER);

		// draw the application URL
		graphics.setFont(Constants.FONT_PROPORTIONAL_PLAIN_SMALL);
		graphics.drawString(Constants.APPLICATION_URL, 
							width / 2, height - Constants.FONT_PROPORTIONAL_PLAIN_SMALL.getHeight() - 5, 
							Graphics.BASELINE | Graphics.HCENTER);
	}
}
