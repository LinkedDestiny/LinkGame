package com.android.game.item;

import com.android.game.constant.Constant;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义物体类
 * 
 * @implements Item
 */
public class DefaultItem implements Item{

	private String str_name;
	private int i_ID;
	private int i_type;
	
	/**
	 * 
	 * @param name 名称
	 * @param ID ID
	 * @param x 大地图横坐标
	 * @param y 大地图纵坐标
	 * @param alpha	透明度（士兵当前状态（行走、攻击、技能动画））
	 * @param type Item的类型
	 */
	public DefaultItem( String name , int ID , int x , int y , int alpha , int type ){
		this.str_name = name;
		this.i_ID = ID;
		Location location = new Location( name , x , y , Constant.SOILDER_ACTION_MOVE );
		if( type == 3 ){
			Constant.ARROW_LOCATION.put(ID, location);
			Constant.arrow_list.add( location );
		}else if( type == 4 ){
			
		}else{
			Constant.LOCATION.put( ID , location );
			Constant.soilder_list.add( location );
		}
		this.i_type = type;
	}

	public String getName() {
		return str_name;
	}

	public int getID() {
		return i_ID;
	}
	
	public int getType() {
		return i_type;
	}

	public void setType(int type) {
		this.i_type = type;
	}

}
