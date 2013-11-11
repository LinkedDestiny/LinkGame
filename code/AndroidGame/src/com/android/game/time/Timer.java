package com.android.game.time;

/**
 * 
 * @author user
 *
 * @功能 时间类，用于计算并获取当前时间
 */
public class Timer {
	
	private static long startTime;
	
	public static long getNowTime(){
		long nowTime = System.currentTimeMillis() - startTime;
		return nowTime;
	}
}
