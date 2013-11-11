package com.android.game.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

/*
BitmapDrawable简单图片
仅包含一张图片的元件，主要是大地图
*/

public class BitmapDrawable implements Drawable{
	
	private MyBitmap bmp;
	private String name;
	private int i_cx, i_cy;
	private int i_alpha;
	
	public BitmapDrawable( String name, int cx, int cy, int alpha ){
		this.name = name;
		i_cx = (int)( cx * UIDefaultData.f_x_scales );
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
	
	public Rect getRect(){
		Rect rect = new Rect( i_cx, i_cy, i_cx + bmp.getWidth(), i_cy + bmp.getHeight() );
		return rect;
	}

}
