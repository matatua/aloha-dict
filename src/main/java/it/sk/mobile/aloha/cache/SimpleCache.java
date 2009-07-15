/**
 * 
 */
package it.sk.mobile.aloha.cache;

import java.util.Hashtable;

/**
 * @author <a href="mailto:carlo.sciolla@gmail.com">Carlo Sciolla</a>
 *
 */
public class SimpleCache
{
	private static SimpleCache instance = null;
	private static Hashtable cacheTable = null;
	
	/**
	 * Singleton 
	 */
	private SimpleCache ()
	{
		cacheTable = new Hashtable ();
	}
	
	public static SimpleCache getInstance ()
	{
		if (instance == null)
		{
			instance = new SimpleCache ();
		}
		
		return instance;
	}
	
	public boolean hasEntry (Object key)
	{
		return cacheTable.containsKey(key);
	}
	
	public Object getCachedObject (Object key)
	{
		return cacheTable.get(key);
	}
	
	public void setObject (Object key, Object value)
	{
		cacheTable.put(key, value);
	}
	
	public void clear ()
	{
		cacheTable.clear ();
	}
	
	//TODO: implement a delegating system
//	public Object getCachedObjectOrDelegate (String key, Delegator delegate)
//	{
//		
//	}
}
