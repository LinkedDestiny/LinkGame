package com.android.game.bitmap;

/*
RelativeBitmap相对坐标型不透明位图:
坐标cx,cy是相对于大地图的，实际绘图时需进行换算
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class RelativeBitmap implements MyBitmap{

	private Bitmap bmp;
	private MyBitmapFactory factory;
	
	public RelativeBitmap( int id ){
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
		int x = cx - UIDefaultData.i_x_scroll;         //实际屏幕显示坐标
		//越界判定
		if( x + bmp.getWidth() >= 0 && x <= UIDefaultData.i_x_screen + 50 && cy >= 0 && cy <= UIDefaultData.i_y_screen ){
			canvas.drawBitmap(bmp, x, cy - bmp.getHeight(), null);
		}
	}

}
