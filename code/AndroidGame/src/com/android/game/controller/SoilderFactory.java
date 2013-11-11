/**
 * 
 */
package com.android.game.controller;

import com.android.game.constant.Constant;
import com.android.game.constant.Message;
import com.android.game.item.DefaultSoilder;
import com.android.game.item.Soilder;

/**
 * @author star
 *
 * @function create soidler
 */
public class SoilderFactory {
	
	private static GameController controller;
	
	public SoilderFactory( GameController controll ){
		controller = controll;
	}
	
	public static Soilder createSoilder( String name , int id , int x , int y , int type ){
		if( type == 3 ){
			Soilder soilder = new DefaultSoilder( name , id , x , y , Constant.SOILDER_ACTION_MOVE , type );
			controller.getArrow().add(soilder);
			return soilder;
		}else{
			Message.new_soilder = new DefaultSoilder( name , id , x , y , Constant.SOILDER_ACTION_MOVE , type );
			return Message.new_soilder;
		}
		
	}
	
	public static Soilder createEnemy( String name , int id , int x , int y , int type ){
		Message.new_enemy = new DefaultSoilder( name , id , x , y , Constant.SOILDER_ACTION_MOVE , 2 );
		return Message.new_enemy;
	}

}
