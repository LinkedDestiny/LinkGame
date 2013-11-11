package com.android.game.ability;

import com.android.game.modifier.ModifiableObject;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义能力值
 */
public class DefaultAbilityScore extends ModifiableObject implements AbilityScore{
	
	
	private Ability ability;
	
	public DefaultAbilityScore( Ability ability , int value , String character ){
		super( value );
		this.ability = new DefaultAbility( ability );
	}
	
	public DefaultAbilityScore( AbilityScore score ){
		super( score.getAbilityScore() );
		this.ability = new DefaultAbility( score.getAbility() );
	}
	
	public Ability getAbility() {
		return ability;
	}

	public int getAbilityScore() {
		int score = this.getModifierValue();
		if( ability.getName() == "Ability_HP" && score > this.getBaseValue() ){
			score = this.getBaseValue();
		}
		return score;
	}
}
