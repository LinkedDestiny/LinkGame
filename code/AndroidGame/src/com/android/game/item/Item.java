package com.android.game.item;

/**
 *
 * @author 星陨
 *
 * @功能 物体类
 */
public interface Item {
	
	/**
	 * @功能 获取名称
	 * @return
	 *  name
	 */
	String getName();
	
	/**
	 * @功能 获取ID
	 * @return
	 *  ID
	 */
	int getID();
	
	/**
	 * @功能 获取Character的类型
	 * @return
	 * 	int type
	 */
	int getType();
	
	/**
	 * @功能 设置 Character 的类型
	 * 
	 * @param type
	 * 	设置的类型
	 */
	void setType( int type );
}
