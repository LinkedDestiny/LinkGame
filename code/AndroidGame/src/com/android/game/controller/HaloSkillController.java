/**
 * 
 */
package com.android.game.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.Message;
import com.android.game.item.Soilder;
import com.android.game.skill.HeroSkill;
import com.android.game.skill.SkillMode;

/**
 * @author user
 *
 */
public class HaloSkillController {
	
	private GameController controller;
	
	public HaloSkillController( GameController controller ){
		this.controller = controller;
	}
	
	public void HaloSkillEntry(){
		Iterator<HeroSkill> iterator = DefaultDataPool.HERO_SKILL.values().iterator();
		while( iterator.hasNext() ){
			HeroSkill skill = iterator.next();
			if( skill.getType() == 1 ){
				useSkill( skill.getName() );
			}
		}
	}
	public void useSkill( String name ){
		HeroSkill skill = DefaultDataPool.HERO_SKILL.get(name);
		SkillMode mode = (SkillMode) DefaultDataPool.SKILL_MODE.get(name).get(0);
		if( checkMessage( mode ) ){
			skill.takeAction( getTarget( skill.getType() , mode.getType() , mode.getTarget() ) );
		}
	}
	
	public List<Soilder> getTarget( int skillType , String modeType , int targetType ){
		System.out.println("getTarget  skilltype = " + skillType + " modeType = " + modeType );
		if( modeType.charAt(0) == 'H' ){
			if( skillType == 1 )
				return controller.getSoilders();
			else
				return controller.getEnemies();
		}else{
			List<Soilder> target = new ArrayList<Soilder>();
			target.add( ( targetType == 1 ) ? Message.new_soilder : Message.new_enemy );
			Message.new_soilder = null;
			Message.new_enemy = null;
			return target;
		}
	}
	public boolean checkMessage( SkillMode mode ){
		
		if( mode.getType().charAt(0) == 'H' ){
			if( Message.killEnemy ){
				Message.killEnemy = false;
				return true;
			}else{
				return false;
			}
		}else{
			if( Message.new_soilder != null && mode.getTarget() == 1 ){
				return true;
			}else if(  Message.new_enemy != null && mode.getTarget() == 2 ){
				return true;
			}else{
				return false;
			}
		}
	}
}
