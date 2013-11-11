package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author 星陨
 *
 * @功能 定义 Modifier 的计算器
 */
public interface ModifierCalculator {
	
	/**
	 * @功能 计算 Modifier 
	 * @param modifiers
	 * 		Modifier的集合
	 * @return
	 */
	int calculateModifier( Collection<ModifierObject> modifiers );
}
