/**
 * 
 */
package it.sk.mobile.aloha.controller;

import javax.microedition.lcdui.Font;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public interface Constants
{
	public static final String APPLICATION_NAME = "Aloha!";
	public static final String APPLICATION_URL = "www.skuro.tk";
	public static final String LABEL_HELP = "help";
	
	public static final Font FONT_SYSTEM_PLAIN_SMALL = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	
	public static final Font FONT_PROPORTIONAL_BOLD_LARGE = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
	public static final Font FONT_PROPORTIONAL_BOLD_MEDIUM = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
	
	public static final Font FONT_PROPORTIONAL_PLAIN_SMALL = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	public static final Font FONT_PROPORTIONAL_PLAIN_LARGE = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
}
