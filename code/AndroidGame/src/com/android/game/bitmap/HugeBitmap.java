package com.android.game.bitmap;

/*
HugeBitmap超大图片
图片尺寸大于屏幕，根据滚屏程度将大图的不同区域（Rect）绘制到屏幕上，
主要是背景图
 */


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class HugeBitmap implements MyBitmap{

	private Bitmap bmp;
	private MyBitmapFactory factory;
	
	public HugeBitmap( int id ){
		factory = new HugeBitmapFactory();
		bmp = factory.createBitmap(id);
	}
	
	public void draw( Canvas canvas, int cx, int cy, int alpha ) {
		//选择图片显示区域
		Rect rec_bmp = new Rect();
		rec_bmp.left = UIDefaultData.i_x_scroll;
		rec_bmp.top = 0;
		rec_bmp.right = rec_bmp.left + UIDefaultData.i_x_screen;
		rec_bmp.bottom = UIDefaultData.i_y_screen;
		if( bmp != null && canvas != null )
			canvas.drawBitmap(bmp, rec_bmp, canvas.getClipBounds(), null);
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

}
