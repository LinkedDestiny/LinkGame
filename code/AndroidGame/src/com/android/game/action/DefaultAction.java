package com.android.game.action;

import com.android.game.constant.Constant;
import com.android.game.controller.SoilderFactory;
import com.android.game.item.Location;
import com.android.game.item.Soilder;

/**
 * 
 * @author 星陨
 *
 * @功能 Action实体类
 */
public class DefaultAction implements Action{
	
	private Soilder user;
	private Soilder target;
	private int type;
	
	public void actionEntry(Soilder user, Soilder target) {
		this.user = user;
		this.target = target;
		int x_user = Constant.LOCATION.get(user.getID()).getX();
		type = Constant.LOCATION.get(user.getID()).getState();
		
		if( type == Constant.SOILDER_ACTION_ATTACKOVER && user.getName() == "Archer" ){
			Location location = Constant.LOCATION.get( user.getID() );
			SoilderFactory.createSoilder("Arrow", Constant.ARROW_ID  , location.getX() + 37, location.getY() - 86 , 3 );
			Constant.ARROW_ID += 1;
			if( Constant.ARROW_ID == 65535 )
				Constant.ARROW_ID = 0;
			type = Constant.SOILDER_ACTION_MOVE;
		}
		if( type != Constant.SOILDER_ACTION_MOVE || target == null ){
			return;
		}
		
		int x_target;
		
		if( target != null ){
			
			x_target = Constant.LOCATION.get(target.getID()).getX();
			
			int range ;
			if( user.getType() == 2 ){
				range = ( target.getName() == "Archer" ) ? 75 : target.getAbilityScore("Range").getModifierValue() ;
			}else{
				range = 0;
			}
			//行为逻辑控制
			if( (int)Math.abs( x_target - x_user ) <= user.getAbilityScore("Range").getModifierValue() + range ){
				//特殊移动状态
				if( user.getAbilityScore("Speed").getModifierValue() < 0 ){
					//士兵后退
					type = Constant.SOILDER_ACTION_MOVE;
				}else{
					type = Constant.SOILDER_ACTION_ATTACK;		//攻击
					//设置state
				}
				
			}else{
				type = Constant.SOILDER_ACTION_MOVE;		//移动
				//设置state
			}
		}
		takeAction();
	}

	public void takeAction() {
		switch( type ){
		case Constant.SOILDER_ACTION_ATTACK:
			Constant.ATTACK_ACTION.takeAction(user, target);
			break;
		case Constant.SOILDER_ACTION_MOVE:
			Constant.MOVE_ACTION.takeAction(user, target);
			break;
		}
		
	}

}
