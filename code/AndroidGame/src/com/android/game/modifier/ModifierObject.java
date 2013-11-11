package com.android.game.modifier;

/**
 * 
 * @author 星陨
 * 
 * @功能 封装Modifier和对应的ModifierListener<br>
 * 		并实现对应接口
 */
public interface ModifierObject {
	
	/**
	 * 获取 Object 的 Modifier
	 * @return
	 * 	Modifier
	 */
	Modifier getModifier();
	
	/**
	 * @功能 获取Modifier的类型
	 * @return
	 * 	ModifierType
	 */
	ModifierType getModifierType();
	
	/**
	 * 获取 Object 的 Listener
	 * @return
	 * 	ModifierListener
	 */
	ModifierListener getListener();
	
	/**
	 * ModifierListener 的监听接口
	 * @param nowTime
	 * 	当前时间
	 * @return
	 * 		boolean 
	 */
	boolean onModify( long nowTime );
}