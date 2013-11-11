/**
 * 
 */
package com.android.game.constant;

import java.util.HashMap;
import java.util.Map;

import com.android.game.controller.GameController;

/**
 * @author user
 *
 */
public class GameInfo {
	
	private static GameController controller;
	public static int money;
	public static int blood;
	public static int e_blood;

	public static int level;
	
	public static Map<String , Integer> price = new HashMap<String , Integer>();
	
	public GameInfo( GameController controller , int level ){
		GameInfo.level = level;
		GameInfo.controller = controller;
	}
	
	public static void initlizeGame(){
		money = 20 + 20 * level;
		blood = 500;
		e_blood = 500;
		setPrice();
	}
	
	public static void setPrice(){
		price.put("Footman", 10 );
		price.put("Archer", 10 );
		price.put("Shield", 10 );
		price.put("HeavyRider", 10 );
	}
	
	public static float getPercent( int type ){
		if( type == 1 ){
			return ( ( (float)controller.castle.getAbilityScore("HP").getModifierValue() ) / ( (float)blood ) );
		}else{
			return ( ( (float)controller.e_castle.getAbilityScore("HP").getModifierValue() ) / ( (float)e_blood ) );
		}
	}
	
	public static int getPrice( String name ){
		return price.get( name );
	}
	
}
