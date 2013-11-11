package com.android.game.modifier;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义Modifier
 */
public class DefaultModifier implements Modifier{

	private int value;
	private ModifierType type;
	
	public DefaultModifier( ModifierType type , int value ){
		this.type = type;
		this.value = value;
	}
	public DefaultModifier( Modifier modifier ){
		this.value = modifier.getModifier();
		this.type = modifier.getModifierType();
	}
	
	public int getModifier() {
		return value;
	}

	public ModifierType getModifierType() {
		return type;
	}

	public boolean isBonus() {
		if( value >= 0 )
			return true;
		else
			return false;
	}

}
