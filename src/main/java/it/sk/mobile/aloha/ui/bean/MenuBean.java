/**
 * 
 */
package it.sk.mobile.aloha.ui.bean;

import it.sk.mobile.aloha.controller.Utils;

/**
 * Simple bean that holds 
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class MenuBean
{
	private static final String[] menuItems;
	
	public static final String SEARCH = "Search";
	public static final String DICTIONARY = "Dictionary";
	public static final String KEYBOARD = "Keyboard";
	public static final String LANGUAGE = "Language";
	public static final String HELP = "Help";
	public static final String ABOUT = "About";
	public static final String EXIT = "Exit";

	public static final String GOTO = "Menu";
	
	static
	{
		menuItems = new String[7];

		menuItems[0] = MenuBean.SEARCH;
		menuItems[1] = MenuBean.DICTIONARY;
		menuItems[2] = MenuBean.KEYBOARD;
		menuItems[3] = MenuBean.LANGUAGE;
		menuItems[4] = MenuBean.HELP;
		menuItems[5] = MenuBean.ABOUT;
		menuItems[6] = MenuBean.EXIT;
	}
	
	public static String[] getMenuItems ()
	{
		return menuItems;
	}
	
	public static String getMenuEntry (String entry)
	{
		return Utils.getI18NString(entry);
	}
}
