package com.android.game.action;

import com.android.game.constant.Constant;
import com.android.game.item.Location;
import com.android.game.item.Soilder;

/**
 * 
 * @author 星陨
 *
 * @功能 移动行为类，控制士兵的移动动作
 */
public class MoveEffect implements ActionEffect{

	public void takeAction(Soilder user, Soilder target) {
		Constant.LOCATION.get( user.getID() ).setState( Constant.SOILDER_ACTION_MOVE );
		int time, result;
		float value_user = 0;
		Location location = Constant.LOCATION.get(user.getID());
		if( user.getType() == 1 ){
			if( location.getX() < 150 && user.getAbilityScore("Speed").getModifierValue() < 0 ){
				return;
			}
			result = user.getAbilityScore("Speed").getModifierValue();
		}else{
			if( location.getX() >2420 && user.getAbilityScore("Speed").getModifierValue() < 0 ){
				return;
			}
			result = - user.getAbilityScore("Speed").getModifierValue();
		}
		location.setX( location.getX() + result );
	}

}
