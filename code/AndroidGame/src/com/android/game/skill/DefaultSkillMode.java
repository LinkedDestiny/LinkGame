package com.android.game.skill;

import com.android.game.constant.Constant;
import com.android.game.modifier.DefaultModifier;
import com.android.game.modifier.DefaultModifierObject;
import com.android.game.modifier.ModifierObject;

/**
 * 
 * @author 星陨
 *
 * @功能 技能效果实体类
 */
public class DefaultSkillMode implements SkillMode{

	private String belong;
	private String type;
	private float value;
	private long time;
	private int target;
	
	public DefaultSkillMode( String belong , String type , float value , long time , int target ){
		this.belong = belong;
		this.type = type;
		this.value = value;
		this.time = time;
		this.target = target;
	}

	public ModifierObject getModifier() {
		ModifierObject modifier = new DefaultModifierObject( new DefaultModifier( Constant.getType(type) , (int)value ) , time , ( time >= 500 ) ? 1 : 2 );
		return modifier;
	}

	public float getValue() {
		return value;
	}

	public String getBelong() {
		return belong;
	}

	public String getType() {
		return type;
	}

	public int getTarget() {
		return target;
	}

}
