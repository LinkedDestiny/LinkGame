package com.android.game.item;

import java.util.Collection;

/**
 * 
 * @author 星陨
 *
 * @功能 英雄定义
 */
public interface Hero extends Item{
	
	/**
	 * @功能 使用英雄技能
	 * @param ID
	 * 技能ID
	 * @param target
	 * 技能目标容器
	 */
	boolean useSkill( int ID , Collection<Soilder> target );
	
}
