package com.android.game.drawable.button;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.game.animation.ClickedAnimation;
import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

public class StandardButtonDrawable implements ButtonDrawable{
	private String str_name;
	private MyBitmap bmp_normal;
	private ClickedAnimation ani_clicked;
	private int i_state;
	private int i_cx, i_cy;
	private Rect rect;
	
	public StandardButtonDrawable( String name, int cx, int cy ){
		i_state = NORMAL;
		str_name = name;
		i_cx = (int)( cx * UIDefaultData.f_y_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		bmp_normal = UIDefaultData.container_bmp.getBitmap( name  );
		ani_clicked = new ClickedAnimation( name );
		rect = new Rect( i_cx, i_cy, i_cx + bmp_normal.getWidth(), i_cy + bmp_normal.getHeight() );
	}

	public String getBasicType() {
		return "Button";
	}

	public String getConcreteType() {
		return "SimpleButton";
	}

	public String getName() {
		return str_name;
	}
	
	public int getState() {
		return i_state;
	}
	
	public Rect getRect(){
		return rect;
	}

	public void setState(int state) {
		i_state = state;
	}

	public void draw(Canvas canvas, Location location) {
		if( location != null )
			setState( location.getState() );
		switch( i_state ){
		case NORMAL:
			if( ! ani_clicked.isEnd() ){
				if( ani_clicked.isEndAnCirculation() )
					ani_clicked.restore();
				ani_clicked.draw(canvas, i_cx, i_cy);
			}
			else
				bmp_normal.draw(canvas, i_cx, i_cy, 255 );
			break;
		case CLICKED:
			if( ani_clicked.isEnd() )
				ani_clicked.start();
			ani_clicked.draw( canvas, i_cx, i_cy );
			break;
		}
	}

}
