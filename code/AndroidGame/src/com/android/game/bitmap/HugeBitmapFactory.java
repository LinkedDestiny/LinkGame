package com.android.game.bitmap;

/*
HugeBitmapFactory超大位图生成模式:
针对超大图片decode时out of momery问题进行处理，
将高分辨率大图分成若干张小图，再创建一张低分辨率（ARGB_4444）的大型位图，
将小图依次贴在大图上
*/

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;

public class HugeBitmapFactory implements MyBitmapFactory{

	private Bitmap bmp;
	
	public Bitmap createBitmap(int id) {
		ArrayList<Bitmap> list_bmp = new ArrayList<Bitmap>();
		MyBitmapFactory factory = new DefaultBitmapFactory();
		//载入小图
		int width = 0;
		for( int i = 0; i < 3; i ++ ){
			list_bmp.add( factory.createBitmap( id + i ) );
			width += list_bmp.get(i).getWidth();
		}
		int height = list_bmp.get(0).getHeight();
		
		//创建一张大图,将小图依次贴到大图上
		bmp = Bitmap.createBitmap( width, height, Config.ARGB_8888 );
		Canvas canvas = new Canvas( bmp );
		int temp = 0;
		for( int i = 0; i < 3; i ++ ){
			canvas.drawBitmap( list_bmp.get(i), temp, 0, null );
			temp += list_bmp.get(i).getWidth();
		}
		return bmp;
	}

}
