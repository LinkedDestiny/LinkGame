package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author 星陨
 * 
 * @功能 预定义 ModifierType
 */
public class DefaultModifierType implements ModifierType{
	
	private String name;
	private ModifierCalculator calculator;
	
	public DefaultModifierType( String name , ModifierCalculator calculator ){
		this.name = name;
		this.calculator = calculator;
	}
	
	public DefaultModifierType( ModifierType type ){
		this.name = type.getName();
		this.calculator = type.getCalculator();
	}
	
	public String getName() {
		return name;
	}

	public int calculateModifiers(Collection<ModifierObject> modifiers) {
		return calculator.calculateModifier(modifiers);
	}

	public ModifierCalculator getCalculator() {
		return calculator;
	}
	
}
