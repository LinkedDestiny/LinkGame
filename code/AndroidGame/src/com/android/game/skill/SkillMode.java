package com.android.game.skill;

import com.android.game.modifier.ModifierObject;

/**
 * 
 * @author 星陨
 *
 * @功能 英雄技能效果模块
 */
public interface SkillMode {
	
	/**
	 * @功能 获取修正值
	 * @return
	 * ModifierObject
	 */
	ModifierObject getModifier();
	
	/**
	 * @功能 获取
	 * @return
	 */
	float getValue();
	
	/**
	 * @功能 获取技能效果的归属
	 * @return
	 */
	String getBelong();
	
	/**
	 * @function get the type of SkillMode
	 * @return
	 */
	String getType();
	
	/**
	 * @function get the target type of the skillmode
	 * @return
	 * target type 
	 */
	int getTarget();
}
