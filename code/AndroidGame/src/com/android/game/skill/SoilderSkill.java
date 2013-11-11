package com.android.game.skill;


/**
 * 
 * @author 星陨
 *
 * @功能 士兵技能
 */
public interface SoilderSkill extends Skill{
	
	/**
	 * @功能 士兵使用技能
	 * 
	 * @param type
	 * 应当使用的技能类型，若类型不匹配返回0
	 * @return
	 * 技能修正值
	 */
	float useSkill( int type );
	
	/**
	 * @功能 解锁技能
	 * @param usable
	 */
	void setUsable( boolean usable );
	/**
	 * @功能 判断当前技能是否解锁
	 * @return
	 */
	boolean usable();
	
	/**
	 * @功能 获取技能持续时间
	 * @return
	 */
	int getTime();
	
}
