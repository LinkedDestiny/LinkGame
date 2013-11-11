/**
 * 
 */
package com.android.game.controller;

import com.android.game.constant.Constant;
import com.android.game.constant.GameInfo;
import com.android.game.constant.Message;

/**
 * @author 星陨
 *
 * @功能 按键控制室类
 */
public class KeyDownController {
	
	private GameController controller;
	
	public KeyDownController( GameController controller ){
		this.controller = controller;
	}
	
	public void keyDown(){
		if( skill_keyDown() ){
			controller.heroskillController.useSkill( Constant.current_button.getName() );
			System.out.println( "Skill  " + Constant.current_button.getName() );
			Constant.current_button = null;
		}
		if( soilder_keyDown() && isMoneyEnough( Constant.current_soilder.getName() ) ){
			Message.new_soilder = SoilderFactory.createSoilder( Constant.current_soilder.getName() , 
					Constant.SOILDER_ID, 150 , Constant.SOILDER_Y , 1 );
			controller.getSoilders().add( Message.new_soilder );
			Constant.SOILDER_ID += 1;
			System.out.println( Constant.SOILDER_ID + " " );
			System.out.println("create a soilder" + Constant.current_soilder.getName() );
			Constant.current_soilder = null;
		}
	}
	public static boolean skill_keyDown(){
		if( Constant.current_button == null )
			return false;
		else
			return true;
	}
	public static boolean soilder_keyDown(){
		if( Constant.current_soilder == null )
			return false;
		else
			return true;
	}
	
	public static boolean isMoneyEnough( String name ){
		if( GameInfo.money >= GameInfo.getPrice(name) ){
			GameInfo.money -= GameInfo.getPrice(name);
			return true;
		}
		return false;
	}
}