package com.android.game.drawable;

import java.util.ArrayList;
import java.util.List;

import com.android.game.constant.UIDefaultData;

public class BitmapDrawableContainer{
	
	private ArrayList<Drawable> bmps;
	private int i_bmp_num = 7;
	
	public BitmapDrawableContainer(){
		bmps = new ArrayList<Drawable>();
	}

	public void initBatleDrawableContainer( List<String> hero ) {
		if( !bmps.isEmpty() )
			bmps.clear();
		bmps.add( new BitmapDrawable( "BACKGROUND", 0, 0, 255 ) );
		bmps.add( new BitmapDrawable( "OUR_HEALTH", 358, 14, 255 ) );
		bmps.add( new BitmapDrawable( "ENEMY_HEALTH", 358, 34, 255 ) );
		bmps.add( new BitmapDrawable( "POINT_NUM", 358, 14, 255 ) );
		bmps.add( new BitmapDrawable( "MONEY", 102, 551, 255 ) );
		bmps.add( new BitmapDrawable( "Lancer_BUTTON", 661, 549, 2000 ) );
		bmps.add( new BitmapDrawable( "LightRider_BUTTON", 752, 549, 2000 ) );
		System.out.println( "hero : " + hero.get(0) + ", " + hero.get(1) );
		bmps.add( new BitmapDrawable( hero.get(0), 22, 142, 255 ) );
		bmps.add( new BitmapDrawable( hero.get(1), 22, 240, 255 ) );
		bmps.add( new BitmapDrawable( "MINIMAP", 12, 6, UIDefaultData.MASK_ALPHA ) );
		bmps.add( new UnfixedBitmapDrawable( "CURRENT_WINDOW", 17, 11, 255 ) );
		bmps.add( new UnfixedBitmapDrawable( "OUR_LOCATION", 17, 30, 255 ) );
		bmps.add( new UnfixedBitmapDrawable( "ENEMY_LOCATION", 17, 30, 255 ) );
	}
	
	public void initHeroSelectDrawable(){
		if( !bmps.isEmpty() )
			bmps.clear();
		bmps.add( new StandardBitmapDrawable( "hero_select_background", 0, 0, 255 ) );
		bmps.add( new StandardBitmapDrawable( "hero_select_describe", 540, 543, 255 ) );
		bmps.add( new StandardBitmapDrawable( "hero_1_describe", 376, 136, 255 ) );
		bmps.add( new StandardBitmapDrawable( "hero_2_describe", 376, 136, 255 ) );
		bmps.add( new StandardBitmapDrawable( "hero_3_describe", 376, 136, 255 ) );
	}
	
	public int size(){
		return bmps.size();
	}
	
	public int staticBitmapNum(){
		return i_bmp_num;
	}

	public Drawable getDrawable( String name ) {
		return null;
	}
	
	public Drawable getDrawable( int index ){
		return bmps.get(index);
	}

	public void deleteDrawable(String name) {
		bmps.remove(name);
	}

	public void clear() {
		bmps.clear();		
	}

}
