package com.android.game.drawable;

import android.graphics.Canvas;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

public class StandardBitmapDrawable implements Drawable{
	
	private MyBitmap bmp;
	private String name;
	private int i_cx, i_cy;
	private int i_alpha;
	
	public StandardBitmapDrawable( String name, int cx, int cy, int alpha ){
		this.name = name;
		i_cx = (int)( cx * UIDefaultData.f_y_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		i_alpha = alpha;
	}

	public String getBasicType() {
		return "Bitmap";
	}

	public String getConcreteType() {
		return "Bitmap";
	}

	public void draw(Canvas canvas, Location location) {
		bmp = UIDefaultData.container_bmp.getBitmap(name);
		bmp.draw(canvas, i_cx, i_cy, i_alpha );
	}

	public String getName() {
		return name;
	}

}
