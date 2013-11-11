package com.android.game.action;

import com.android.game.item.Soilder;


/**
 * 
 * @author 星陨
 *
 * @功能  士兵行动的基类接口
 */
public interface Action {
	
	/**
	 * @功能 行为入口，用于实现行为前的各种操作
	 * @param user
	 * 行为发起者
	 * @param target
	 * 行为目标
	 */
	void actionEntry( Soilder user , Soilder target );
	
	/**
	 * @功能 行为实施函数
	 */
	void takeAction();
	
}
