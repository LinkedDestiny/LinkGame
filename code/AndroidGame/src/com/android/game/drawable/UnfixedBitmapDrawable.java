package com.android.game.drawable;

import android.graphics.Canvas;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

public class UnfixedBitmapDrawable implements Drawable{
	
	private MyBitmap bmp;
	private int i_cx, i_cy;
	private String str_name;

	public UnfixedBitmapDrawable(String name, int cx, int cy, int alpha) {
		str_name = name;
		i_cx = (int)( cx * UIDefaultData.f_y_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		bmp = UIDefaultData.container_bmp.getBitmap(name);
	}

	public String getBasicType() {
		return "Bitmap";
	}

	public String getConcreteType() {
		return "UnfixedBitmap";
	}

	public String getName() {
		return str_name;
	}

	public void draw(Canvas canvas, Location location) {
		int cx;
		if( bmp.getWidth() > 20 ){
			cx = (int)( (float)location.getX() / UIDefaultData.container_bmp.getBitmap("BACKGROUND").getWidth() * 270 * UIDefaultData.f_y_scales );
		}
		else
			cx = (int)( location.getX() / 2880f * 270 * UIDefaultData.f_y_scales );
		bmp.draw(canvas, i_cx + cx, i_cy, 255 );
	}

}
