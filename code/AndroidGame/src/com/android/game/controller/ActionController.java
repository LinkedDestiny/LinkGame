/**
 * 
 */
package com.android.game.controller;

import java.util.Iterator;

import com.android.game.action.DefaultAction;
import com.android.game.constant.Constant;
import com.android.game.constant.GameInfo;
import com.android.game.constant.Message;
import com.android.game.item.Location;
import com.android.game.item.Soilder;
import com.android.game.modifier.DefaultModifier;
import com.android.game.modifier.DefaultModifierObject;
import com.android.game.modifier.ModifierObject;
import com.android.game.time.Timer;

/**
 * @author 星陨
 *
 * @功能 行为总控制类，控制士兵的自发行为控制
 * 
 * @注意：ActionController有自己的
 * 		独立线程用于控制士兵的Modifier
 */
public class ActionController {
	
	private GameController controller;				//GameController的引用（获取士兵容器）
	
	private Soilder soilder_target;					//己方士兵的攻击目标
	private Soilder enemy_target;					//敌方士兵的攻击目标
	
	private DefaultAction action = new DefaultAction();
	
	
	public ActionController( GameController controller ){
		this.controller = controller;
		soilder_target = controller.e_castle;					//己方士兵的攻击目标
		enemy_target = controller.castle;					//敌方士兵的攻击目标
	}
	
	//行为主控制循环
	public void ActionMainLoop(){
		
		if( controller.getSoilders().isEmpty() ){
			enemy_target = controller.castle;
		}
		if( controller.getEnemies().isEmpty() ){
			soilder_target = controller.e_castle;
		}
		
		Iterator<Soilder> arrow = controller.getArrow().iterator();
		
		while( arrow.hasNext() ){
			Soilder temp = arrow.next();
			if( ( Constant.LOCATION.get( soilder_target.getID() ).getX() -
					Constant.ARROW_LOCATION.get( temp.getID() ).getX()  ) <= 
					( soilder_target.getAbilityScore("Range").getModifierValue() +
							temp.getAbilityScore("Range").getModifierValue() ) ){
				
				ModifierObject modifier = new DefaultModifierObject( 
						new DefaultModifier( Constant.getType("HP") , -temp.getAbilityScore("Attack").getModifierValue() ) , 3600000 , 1 );
				
				soilder_target.getAbilityScore("HP").addModifierObject(modifier);
				
				Constant.ARROW_LOCATION.get( temp.getID() ).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.ARROW_LOCATION.remove(temp.getID());
				
				arrow.remove();
			}else{
				Location location = Constant.ARROW_LOCATION.get( temp.getID() );
				location.setX( location.getX() + temp.getAbilityScore("Speed").getModifierValue() );
			}
		}
		
		//敌方士兵
		Iterator<Soilder> enemy = controller.getEnemies().iterator();
		while( enemy.hasNext() ){
			Soilder temp = enemy.next();
			temp.onModify( Timer.getNowTime() );
			
			//死亡判断
			if( temp.getAbilityScore("HP").getModifierValue() <= 0 ){
				Constant.LOCATION.get(temp.getID()).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.LOCATION.remove(temp.getID());
				Message.killEnemy = true;
				soilder_target = controller.e_castle;
				System.out.println(" enemy die , new soilder target  " + soilder_target.getName() );
				GameInfo.money += ( temp.getName() == "Monster_1" ) ? 10 : 5;
				enemy.remove();
				continue;
			}
			
			//设置目标
			int temp_x = Constant.LOCATION.get(temp.getID()).getX();
			if( temp_x < Constant.LOCATION.get(soilder_target.getID()).getX() ){
				soilder_target = temp;
				System.out.println(" new soilder target  " + soilder_target.getName() );
			}
			
			//行动
			action.actionEntry(temp, enemy_target);
		}
		
		//己方士兵
		Iterator<Soilder> soilder = controller.getSoilders().iterator();
		
		while( soilder.hasNext() ){
			Soilder temp = soilder.next();
			temp.onModify( Timer.getNowTime() );
			
			//死亡判断
			if( temp.getAbilityScore("HP").getModifierValue() <= 0 ){
				Constant.LOCATION.get(temp.getID()).setState( Constant.SOILDER_ACTION_DEATH );
				Constant.LOCATION.remove(temp.getID());
				enemy_target = controller.castle;
				System.out.println(" soilder die , new enemy target  " + enemy_target.getName() );
				soilder.remove();
				continue;
			}
			
			//设置目标
			int temp_x = Constant.LOCATION.get(temp.getID()).getX();
			if( temp_x > Constant.LOCATION.get(enemy_target.getID()).getX() ){
				enemy_target = temp;
				System.out.println(" new enemy target  " + enemy_target.getName() );
			}
			
			//行动 
			action.actionEntry(temp, soilder_target);
		}
		
	}
}
