/**
 * 
 */
package com.android.game.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.item.Soilder;
import com.android.game.skill.HeroSkill;

/**
 * @author star
 *
 * @function controll the hero skill
 */
public class HeroSkillController {
	
	private GameController controller;
	
	public HeroSkillController( GameController controller ){
		this.controller = controller;
	}
	
	public void useSkill( String name ){
		HeroSkill skill = DefaultDataPool.HERO_SKILL.get( name );
		if( skill.getType() == 1 ){
			return;
		}else{
			System.out.println("use skill " + name );
			skill.takeAction( getTarget( Constant.current_button.getX() , skill.getRange() , skill.getTargetType() ));
		}
	}
	
	public Collection<Soilder> getTarget( int x , int range , int type ){
		System.out.println("get Target");
		List<Soilder> target;
		List<Soilder> enemies = ( type == 1 ) ? controller.getSoilders() : controller.getEnemies();
		
		if( range == 0 ){
			target = new ArrayList<Soilder>( enemies );
		}else{
			target = new ArrayList<Soilder>(  );
		}
		Iterator<Soilder> iterator = enemies.iterator();
		System.out.println("get Target  " + x );
		while( iterator.hasNext() ){
			Soilder enemy = iterator.next();
			System.out.println( "" + Constant.LOCATION.get( enemy.getID() ).getX() );
			if( Math.abs( Constant.LOCATION.get( enemy.getID() ).getX() - x )  <= range ){
				System.out.println("add target");
				target.add(enemy);
			}
		}
		
		return target;
	}
	
}
