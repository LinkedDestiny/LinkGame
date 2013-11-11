package com.android.game.modifier;

/**
 * 
 * @author 星陨
 *
 * @功能 实现对Modifier的监听
 */
public interface ModifierListener {
	
	/**
	 * @功能 listen in Modifier or skill CDtime
	 * @param nowTime
	 * 		current time
	 * @return
	 * 		return true when time is over
	 * 		or return false
	 */
	boolean onModify( long nowTime );
	
	/**
	 * @功能 begin listening
	 * @param nowTime
	 * 
	 */
	void start( long nowTime );
	
	/**
	 * @function set the limitTime for the listener
	 * @param limitTime
	 */
	void setLimitTime( long limitTime );
	
}
