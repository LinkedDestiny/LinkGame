package com.android.game.bitmap;

/*
MyBitmap基本图片接口
对不同类型的图片使用不同的生成和绘图策略，并进行封装
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface MyBitmap {
	
	public int getWidth();
	
	public int getHeight();
	
	public Bitmap getBitmap();
	
	public void draw( Canvas canvas, int cx, int cy, int alpha );
	
}
