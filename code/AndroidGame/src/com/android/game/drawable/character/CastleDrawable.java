package com.android.game.drawable.character;

import android.graphics.Canvas;

import com.android.game.animation.DisappearAnimation;
import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;
import com.android.game.item.Location;

public class CastleDrawable implements CharacterDrawable{
	
	private String str_name;
	private MyBitmap bmp;
	private DisappearAnimation ani;
	private int i_cx, i_cy;
	private int i_state = MOVE;
	private boolean b_death = false;
	
	public CastleDrawable( String name, int cx, int cy ){
		str_name = name;
		bmp = UIDefaultData.container_bmp.getBitmap(str_name);
		i_cx = (int)( cx * UIDefaultData.f_y_scales );
		i_cy = (int)( cy * UIDefaultData.f_y_scales );
		ani = new DisappearAnimation( UIDefaultData.container_animation.getAnimation( name + "_Death" ) );
	}

	public String getBasicType() {
		return "Character";
	}

	public String getConcreteType() {
		return "Castle";
	}

	public String getName() {
		return str_name;
	}

	public void draw(Canvas canvas, Location location) {
		setState( location.getState() );
		switch( i_state ){
		case MOVE:
			bmp.draw(canvas, i_cx, i_cy, 255 );
			break;
		case DEATH:
			ani.draw(canvas, i_cx, i_cy );
			if( ani.isEnd() )
				b_death = true; 
			break;
		}
	}

	public int getState() {
		return i_state;
	}

	public void setState(int state) {
		if( state == 5 && i_state == DEATH ){
			i_state = 5;
			return;
		}
		if( i_state == DEATH || i_state == state )
			return;
		i_state = state;
	}

	public boolean isDead() {
		return b_death;
	}

}
