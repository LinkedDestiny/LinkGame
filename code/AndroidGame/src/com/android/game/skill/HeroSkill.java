package com.android.game.skill;

import java.util.Collection;

import com.android.game.item.Soilder;

/**
 * 
 * @author 星陨
 *
 * @功能 英雄技能接口
 */
public interface HeroSkill extends Skill{
	
	/**
	 * @功能 获取CD时间
	 * @return
	 * CDtime
	 */
	int getCDtime();
	
	/**
	 * @功能 获取技能范围
	 * @return
	 */
	int getRange();
	
	/**
	 * @功能 监听技能CD
	 * @param nowTime
	 */
	boolean onCDListener( long nowTime );
	
	int getTargetType();
	/**
	 * use the skill
	 * @param target
	 */
	void takeAction( Collection<Soilder> target );
	
}
