package com.android.game.bitmap;

import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class TransparentAbsoluteBitmap implements MyBitmap{
	
	private Bitmap bmp;
	private MyBitmapFactory factory;
	private Paint paint;
	
	public TransparentAbsoluteBitmap( int id ){
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
		//Ô½½çÅÐ¶¨
		cx = (int)( cx * UIDefaultData.f_y_scales );
		cy = (int)( cy * UIDefaultData.f_y_scales );
		if( cx + bmp.getWidth() >= 0 && cx < UIDefaultData.i_x_screen && cy >= 0 && cy < UIDefaultData.i_y_screen ){
			paint.setAlpha(alpha);
			canvas.drawBitmap(bmp, cx, cy, paint);
		}
	}
	
}
