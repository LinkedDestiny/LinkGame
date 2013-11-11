package com.android.game.drawable;

public interface DrawableContainer {
	
	public void initDrawableContainer();
	
	public int size();
	
	public Drawable getDrawable( String name );
	
	public void deleteDrawable( String name );
	
	public void clear();
	
}
