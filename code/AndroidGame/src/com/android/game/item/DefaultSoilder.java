package com.android.game.item;

import com.android.game.ability.AbilityScore;
import com.android.game.ability.AbilityScoreContainer;
import com.android.game.ability.DefaultAbilityScoreContainer;
import com.android.game.constant.DefaultDataPool;
import com.android.game.modifier.DefaultModifierListener;
import com.android.game.modifier.ModifierListener;
import com.android.game.skill.SoilderSkill;
import com.android.game.time.Timer;

public class DefaultSoilder extends DefaultItem implements Soilder{

	private AbilityScoreContainer container;
	private SoilderSkill skill;
	private ModifierListener listener;
	
	public DefaultSoilder(String name, int ID, int x, int y, int alpha, int type) {
		super(name, ID, x, y, alpha, type);
		this.container = new DefaultAbilityScoreContainer( DefaultDataPool.getAbilityContainer(name));
		skill = DefaultDataPool.getSoilderSkill(name);
		listener = new DefaultModifierListener( ( 25 - getAbilityScore("Dexterity").getModifierValue() ) * 50, 1 );
		listener.start(Timer.getNowTime());
		getAbilityScore("Range").setBaseValue(getAbilityScore("Range").getBaseValue() - (int)( 40 - Math.random() * 80 ) );
	}

	public AbilityScore getAbilityScore(String name) {
		String ability;
		if( name.startsWith("Ability_")){
			ability = name;
		}else
			ability = "Ability_" + name;
		AbilityScore score = container.getAbilityScore( ability );
		return score;
	}
	
	public SoilderSkill getSkill() {
		if( skill == null )
			return null;
		if( skill.usable() )
			return skill;
		else
			return null;
	}

	public void onModify(long nowTime) {
		container.onModify(nowTime);
	}

	public ModifierListener getATKListener() {
		return listener;
	}

}