package com.android.game.modifier;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author 星陨
 *
 * @功能 计算所有 Modifier 中的最大值
 * 
 * @implements ModifierCalculator
 */
public class HighestModifierCalculator implements ModifierCalculator{

	public int calculateModifier(Collection<ModifierObject> modifiers) {
		int maxValue = 0;
		Iterator<ModifierObject> iterator = modifiers.iterator();
		while( iterator.hasNext() ){
			Modifier modifier = ( Modifier )iterator.next().getModifier();
			int modifierValue = modifier.getModifier();
			if( Math.abs(modifierValue) > maxValue ){
				maxValue = modifierValue;
			}
		}
		return maxValue;
	}

}
