package com.android.game.modifier;

import java.util.Collection;

/**
 * 
 * @author 星陨
 *
 * @功能 定义 ModifierObject 的容器
 * 
 * @param
 * 	
 */
public interface ModifierObjectContainer {
	
	/**
	 * 添加一个ModifierObject
	 * @param modifierObject
	 */
	void addModifierObject( ModifierObject modifierObject );
	
	/**
	 * 移除一个ModifierObject
	 * @param modifierObject
	 */
	void removeModifierObject( ModifierObject modifierObject );
	
	/**
	 * 获取ModifierObject的集合
	 * @return
	 * 		Collection
	 */
	Collection<?> getModifierObjects();
	
	/**
	 * ModifierListener监听接口
	 * @param nowTime
	 * 	当前时间
	 */
	void onModify( long nowTime );
	
}