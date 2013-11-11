package com.android.game.item;

import com.android.game.ability.AbilityScore;
import com.android.game.modifier.ModifierListener;
import com.android.game.skill.SoilderSkill;


/**
 * 
 * @author star
 *
 * @function the interface of the Soilder
 */
public interface Soilder extends Item{
	
	/**
	 * @function get one of abilities by the name
	 * @param name
	 * 	name of the ability
	 * @return
	 * 	AbilityScore
	 */
	AbilityScore getAbilityScore( String name );
	
	/**
	 * @function get the skill of soilder
	 * @return
	 *  SoilderSkill
	 */
	SoilderSkill getSkill();
	
	/**
	 * @function listen in AbilityScoreContainer
	 * @param nowTime
	 */
	void onModify( long nowTime );
	
	/**
	 * @function get the Listener for the ATK
	 * @return
	 */
	ModifierListener getATKListener();
	
}
