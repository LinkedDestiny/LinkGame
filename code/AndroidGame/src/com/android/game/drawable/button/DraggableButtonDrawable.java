package com.android.game.drawable.button;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.game.animation.ClickedAnimation;
import com.android.game.animation.MaskAnimation;
import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

/*
DraggableButtonDrawable可拖动按键绘图
包含三张图片，两张同SimpleButton，位置固定；一张是拖动时产生的图像，位置由触屏控制。
绘图时若处于拖动状态，则需绘制两张图片。
*/

public class DraggableButtonDrawable implements ButtonDrawable{
	
	private String str_name;
	private MyBitmap bmp_normal, bmp_dragged;
	private MaskAnimation ani_mask;
	private ClickedAnimation ani_clicked;
	private int i_state;
	private int i_cx, i_cy;
	private int i_time;
	private Rect rect;
	
	public DraggableButtonDrawable( String name, int cx, int cy, int time ){
		str_name = name;
		i_cx = (int)( cx * UIDefaultData.f_x_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		i_state = NORMAL;
		i_time = time;
		bmp_normal = UIDefaultData.container_bmp.getBitmap( name );
		if( name.startsWith( "hero" ) )
			bmp_dragged = UIDefaultData.container_bmp.getBitmap( name.substring(0, 8) + "_drag" );
		else
			bmp_dragged = UIDefaultData.container_bmp.getBitmap(name);
		ani_mask = new MaskAnimation( "BUTTON_MASK", 20 );
		ani_mask.setColdingTime( i_time );
		ani_clicked = new ClickedAnimation( name );
		rect = new Rect( i_cx, i_cy, i_cx + bmp_normal.getWidth(), i_cy + bmp_normal.getHeight() );
	}

	public String getBasicType() {
		return "Button";
	}

	public String getConcreteType() {
		return "DraggableButton";
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
		if( i_state == state )
			return;
		if( i_state == NORMAL && state == DRAGGED ){
			i_state = CLICKED;
			return;
		}
		if( i_state == COLDING )
			return;
		if( i_state == COLDING && state == NORMAL )
			ani_mask.end();
		i_state = state;
	}
	
	public void draw(Canvas canvas, Location location) {
		setState( location.getState() );
		switch( i_state ){
		case NORMAL:
			if( ! ani_clicked.isEnd() ){
				if( ani_clicked.isEndAnCirculation() )
					ani_clicked.restore();
				ani_clicked.draw( canvas, i_cx, i_cy );
			}
			else
				bmp_normal.draw( canvas, i_cx, i_cy, 255 );
			break;
		case CLICKED:
			if( ani_clicked.isEnd() )
				ani_clicked.start();
			ani_clicked.draw(canvas, i_cx, i_cy);
			break;
		case DRAGGED:
			//当按键处于拖动状态时，location记录当前拖动坐标
			//根据location数据绘制拖动图片
			ani_clicked.draw(canvas, i_cx, i_cy );
			bmp_dragged.draw( canvas, location.getX() - bmp_dragged.getWidth() / 2, 
					location.getY() - bmp_dragged.getHeight() / 2, 200 );
			break;
		case COLDING:
			if( ! ani_clicked.isEnd() ){
				if( ani_clicked.isEndAnCirculation() )
					ani_clicked.restore();
				ani_clicked.draw( canvas, i_cx, i_cy );
				if( ani_clicked.isEnd() && str_name.startsWith( "hero" ) ){
					UIDefaultData.skill_ani_loc.add( new Location( str_name.substring(0, 8), location.getX(), 506, 255 ) );
					System.out.println( "add skill animation" );
				}
			}
			else{
				bmp_normal.draw( canvas, i_cx, i_cy, 255 );
				if( ani_mask.isEnd() )
					ani_mask.start();
				ani_mask.draw( canvas, i_cx, i_cy );
				if( ani_mask.isEnd() ){
					i_state = NORMAL;
					location.setState(NORMAL);
				}
			}
			break;
		}
	}

}
