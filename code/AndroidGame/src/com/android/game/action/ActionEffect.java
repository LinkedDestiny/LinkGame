package com.android.game.action;

import com.android.game.item.Soilder;


/**
 * 
 * @author user
 *
 * @功能 不同行为的动作实现接口
 */
public interface ActionEffect {
	
	/**
	 * @功能 行动函数，控制当前行为效果
	 * @param user
	 * 行为发起者
	 * @param target
	 * 行为接受者
	 */
	void takeAction( Soilder user , Soilder target );
	
}
