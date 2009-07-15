/**
 * 
 */
package it.sk.mobile.aloha.controller;

import it.sk.mobile.aloha.cache.SimpleCache;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class Utils
{
	private static SimpleCache cache = SimpleCache.getInstance ();
	
	public static String getI18NString (String token)
	{
		String result = (String)Utils.cache.getCachedObject(token);
		if (result == null)
		{
			result = fetchLocalizedToken (token);
			Utils.cache.setObject(token, result);
		}
		
		return result;
	}

	private static String fetchLocalizedToken(String token)
	{
		// TODO Auto-generated method stub
		
		return token;
	}
}
