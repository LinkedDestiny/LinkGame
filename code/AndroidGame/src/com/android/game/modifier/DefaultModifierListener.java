package com.android.game.modifier;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义Modifier监听器
 * 
 * @implements ModifierListenr
 */
public class DefaultModifierListener implements ModifierListener{

	private long limitTime;
	private long startTime;
	private boolean onListener = false;
	private int type;
	
	/**
	 * 构造函数
	 * @param limitTime
	 * 	当前时间/当前剩余次数
	 * @param type
	 * 	1 代表按时间计时 ， 2 代表按次数计时
	 */
	public DefaultModifierListener( long limitTime , int type ){
		this.limitTime = limitTime;
		this.type = type;
	}

	public boolean onModify( long nowTime ) {
		if( this.onListener ){
			if( limitTime == -1 )
				return false;
			if( type == 1 ){
				if( ( nowTime - startTime ) >= limitTime ){
					return true;
				}else
					return false;
			}else{
				if( limitTime <= 0 ){
					return true;
				}else{
					limitTime --;
					return false;
				}
			}
		}
		return false;
	}

	public void start(long nowTime) {
		this.startTime = nowTime;
		this.onListener = true;
	}

	public void setLimitTime(long limitTime) {
		this.limitTime = limitTime;
	}

}
