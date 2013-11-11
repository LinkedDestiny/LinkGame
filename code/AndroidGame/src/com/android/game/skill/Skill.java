package com.android.game.skill;

/**
 * 
 * @author 星陨
 *
 * @功能 技能接口,定义技能的基类接口
 */
public interface Skill {
	
	/**
	 * @功能 获取技能名称
	 * @return
	 * 	name
	 */
	String getName();
	
	/**
	 * @功能 获取技能所属人物
	 * @return
	 *  belong
	 */
	String getBelong();
	
	/**
	 * @功能 获取技能类型
	 * @return
	 * 英雄技能：1 光环技能   2 放出技能<br>
	 * 士兵技能：1 攻击型 2 防御型 3移动型
	 */
	int getType();
	
	
}
