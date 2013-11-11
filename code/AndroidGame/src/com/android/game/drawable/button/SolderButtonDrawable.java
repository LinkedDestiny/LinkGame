package com.android.game.drawable.button;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.game.animation.ClickedAnimation;
import com.android.game.animation.MaskAnimation;
import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

public class SolderButtonDrawable implements ButtonDrawable{

	private String str_name;
	private MyBitmap bmp_normal;
	private MaskAnimation ani_mask;
	private ClickedAnimation ani_clicked;
	private int i_state;
	private int i_cx, i_cy;
	private Rect rect;
	
	public SolderButtonDrawable( String name, int cx, int cy, int time ){
		str_name = name;
		i_cx = (int)( cx * UIDefaultData.f_x_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		bmp_normal = UIDefaultData.container_bmp.getBitmap( name );
		ani_mask = new MaskAnimation( "BUTTON_MASK", 20 );
		ani_mask.setColdingTime( time );
		ani_clicked = new ClickedAnimation( name );
		rect = new Rect( i_cx, i_cy, i_cx + bmp_normal.getWidth(), i_cy + bmp_normal.getHeight() );
		i_state = NORMAL;
	}
	
	public String getBasicType() {
		return "Button";
	}

	public String getConcreteType() {
		return "SkillButton";
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
		if( i_state == COLDING )
			return;
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
			ani_clicked.draw( canvas, i_cx, i_cy );
			break;
		case COLDING:
			if( ! ani_clicked.isEnd() ){
				if( ani_clicked.isEndAnCirculation() ){
					ani_clicked.restore();
				}
				ani_clicked.draw( canvas, i_cx, i_cy );
				if( ani_clicked.isEnd() && str_name.startsWith( "hero" ) ){
					String name = str_name.substring(0, 8);
					System.out.println( "create skill ani " + name );
					UIDefaultData.skill_ani_loc.add( new Location( name, 
							(int)( UIDefaultData.i_x_screen / UIDefaultData.f_y_scales / 2 ), 
							(int)( UIDefaultData.i_y_screen / UIDefaultData.f_y_scales / 2 ), 255 ) );
				}
			}
			else{
				bmp_normal.draw( canvas, i_cx, i_cy, 255 );
				if( ani_mask.isEnd() ){
					ani_mask.start();
				}
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
