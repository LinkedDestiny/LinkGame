/**
 * 
 */
package com.android.game.constant;

import com.android.game.item.Soilder;

/**
 * @author user
 *
 */
public class Message {
	
	public static boolean killEnemy = false;
	
	public static Soilder new_soilder = null;
	public static Soilder new_enemy = null;
	
	public static int GAMEOVER = 0;
	
	public static void initlize(){
		killEnemy = false;
		new_soilder = null;
		new_enemy = null;
		GAMEOVER = 0;
	}
}
