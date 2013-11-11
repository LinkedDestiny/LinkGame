package com.android.game.bitmap;

/*
DefaultBitmapFactory默认的位图生成模式
仅根据原图大小及屏幕分辨率对原图进行缩放
*/


import com.android.game.constant.UIDefaultData;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class DefaultBitmapFactory implements MyBitmapFactory{

	public Bitmap createBitmap(int id) {
		//载入原图
		Bitmap bmp_origination = BitmapFactory.decodeResource( UIDefaultData.res, id);
		int width = bmp_origination.getWidth();
		int height = bmp_origination.getHeight();
		
		//获得放缩参数
		Matrix matrix = new Matrix();
		matrix.postScale( UIDefaultData.f_scales,  UIDefaultData.f_scales);
		
		//放缩图片
		Bitmap bmp = Bitmap.createBitmap(bmp_origination, 0, 0, width, height, matrix, true);
		
		return bmp;
	}

}
