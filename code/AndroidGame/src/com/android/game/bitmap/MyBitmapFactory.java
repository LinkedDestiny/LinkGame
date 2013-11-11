package com.android.game.bitmap;

/*
MyBitmapFactory基本图片生成接口
使用不同的策略创建位图
 */

import android.graphics.Bitmap;

public interface MyBitmapFactory {
	
	public Bitmap createBitmap( int id );
	
}
