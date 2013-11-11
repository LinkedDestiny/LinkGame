package com.android.game.drawable.button;

import android.graphics.Rect;

import com.android.game.drawable.Drawable;

/*
ButtonDrawable按键绘图部分
有若干种状态，每种状态对应不同的绘图机制
按键位置固定，除DraggableButtonDrawable外，draw(……)中的Location无效
*/

public interface ButtonDrawable extends Drawable{
	
	public static final int NORMAL = 0;                  //正常状态
	public static final int CLICKED = 1;                   //点击状态
	public static final int DRAGGED = 2;                //拖曳状态
	public static final int COLDING = 3;                  //冷却状态
	public static final int LOCKED = 4;                    //封锁状态

	public int getState();
	
	public void setState( int state );
	
	public Rect getRect();
	
}
