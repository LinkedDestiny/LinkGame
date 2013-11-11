package com.android.game.modifier;

/**
 * 
 * @author 星陨
 *
 * @功能 修正值的封装
 * 
 * @include
 * 		int value  <br>
 * 		ModifierType type
 */
public interface Modifier {
	
	/**
	 * @功能 获取 Modifier 的值
	 * @return
	 * 		int value
	 */
	int getModifier();
	
	/**
	 * @功能 获取 Modifier 的类型
	 * @return
	 * 	ModifierType type
	 */
	ModifierType getModifierType();
	
	/**
	 * @功能 判断 Modifier 是否是增益
	 * @return
	 * 	boolean value >= 0 
	 */
	boolean isBonus();
}
