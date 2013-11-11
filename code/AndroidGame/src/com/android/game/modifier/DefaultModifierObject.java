package com.android.game.modifier;

import com.android.game.time.Timer;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义ModifierObject
 */
public class DefaultModifierObject implements ModifierObject{
	
	private Modifier modifier;
	private ModifierListener listener;
	/**
	 * @功能 构造一个ModifierObject
	 * @param modifier
	 * 		修正Modifier
	 * @param limitTime
	 * 		ModifierListener的时限
	 * @param type
	 * 监听器类型
	 */
	public DefaultModifierObject( Modifier modifier , long limitTime , int type ){
		this.modifier = new DefaultModifier( modifier );
		this.listener = new DefaultModifierListener( limitTime , type );
		listener.start(Timer.getNowTime());
	}
	
	public Modifier getModifier() {
		return modifier;
	}

	public ModifierType getModifierType() {
		return modifier.getModifierType();
	}

	public ModifierListener getListener() {
		// TODO Auto-generated method stub
		return listener;
	}

	public boolean onModify(long nowTime) {
		return listener.onModify(nowTime);
	}
	
}	
