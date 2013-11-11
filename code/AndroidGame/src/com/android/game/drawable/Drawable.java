package com.android.game.drawable;

import com.android.game.item.Location;

import android.graphics.Canvas;

/*
基本绘图元件接口
*/

public interface Drawable {
	
	public String getBasicType();
	
	public String getConcreteType();
	
	public String getName();
	
	public void draw( Canvas canvas, Location location );
	
}
