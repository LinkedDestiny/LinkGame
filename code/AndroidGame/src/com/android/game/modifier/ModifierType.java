package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author 星陨
 *
 * @功能 定义Modifier的类型
 * 
 * @param 
 * 	ModifierCalculator calculator<br>
 * 计算 Modifier 的计算器
 * 
 * @param String name
 * 		Modifier的类型
 */
public interface ModifierType {
	
	/**
	 * @功能 获取 Modifier 类型名
	 * @return
	 * 		String name
	 */
	String getName();
	
	/**
	 * @功能 获取 ModifierCalculator
	 * @return
	 */
	ModifierCalculator getCalculator();
	
	/**
	 * @功能 计算 Modifier 的值
	 * @param moidifiers
	 * 		Modifier 的集合
	 * @return
	 * 		int value
	 */
	int calculateModifiers( Collection<ModifierObject> modifiers );
}
