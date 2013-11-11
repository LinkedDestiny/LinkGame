package com.android.game.bitmap;

import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class TransparentRelativeBitmap implements MyBitmap{

	private Bitmap bmp;
	private MyBitmapFactory factory;
	private Paint paint;
	
	public TransparentRelativeBitmap( int id ){
		factory = new DefaultBitmapFactory();
		bmp = factory.createBitmap(id);
		paint = new Paint();
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
		int x = cx- UIDefaultData.i_x_scroll;         //实际屏幕显示坐标
		//越界判定
		if( x + bmp.getWidth() >= 0 && x < UIDefaultData.i_x_screen && cy >= 0 && cy < UIDefaultData.i_y_screen ){
			paint.setAlpha(alpha);
			canvas.drawBitmap( bmp, x, cy - bmp.getHeight(), paint );
		}
	}

}
