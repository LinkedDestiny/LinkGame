package com.android.game.ability;

import com.android.game.modifier.Modifiable;

/**
 * 
 * @author 星陨
 *
 * @功能 能力的数值
 */
public interface AbilityScore extends Modifiable{
	
	/**
	 * @功能 获取能力
	 * @return
	 * 	Ability
	 */
	Ability getAbility();
	
	/**
	 * @功能 获取能力值
	 * @return
	 * 	int AbilityScore;
	 */
	int getAbilityScore();
}
