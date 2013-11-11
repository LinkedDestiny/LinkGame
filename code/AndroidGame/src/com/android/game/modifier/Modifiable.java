package com.android.game.modifier;

/**
 * 
 * @author 星陨
 *
 * @功能 定义可添加 Modifier 的对象
 * 
 * @extends ModifierObjectContainer
 */
public interface Modifiable extends ModifierObjectContainer{
	
	/**
	 * @功能 获取未修正的值
	 * @return
	 * 	int baseValue
	 */
	int getBaseValue();
	
	/**
	 * @功能 设置基础值
	 */
	void setBaseValue( int value );
	
	/**
	 * @功能 获取修正后的值
	 * @return
	 * 	int modifierValue
	 */
	int getModifierValue();
	
	/**
	 * @功能 计算修正值
	 */
	void calculate();
}
