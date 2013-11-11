package com.android.game.bitmap;

/*
AbsoluteBitmap绝对坐标型不透明位图：
坐标cx,cy是相对于手机屏幕的，不需要根据滚屏程度进行换算
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class AbsoluteBitmap implements MyBitmap{
	private Bitmap bmp;
	private MyBitmapFactory factory;
	
	public AbsoluteBitmap( int id ){
		factory = new DefaultBitmapFactory();
		bmp = factory.createBitmap(id);
	}

	public int getWidth() {
		return bmp.getWidth();
	}

	public int getHeight() {
		return bmp.getHeight();
	}
	
	public Bitmap getBitmap(){
		return bmp;
	}

	public void draw(Canvas canvas, int cx, int cy, int alpha) {
		//越界判定
		if( cx + bmp.getWidth() >= 0 && cx < UIDefaultData.i_x_screen && cy >= 0 && cy < UIDefaultData.i_y_screen ){
			canvas.drawBitmap(bmp, cx, cy, null);
		}
	}
}
