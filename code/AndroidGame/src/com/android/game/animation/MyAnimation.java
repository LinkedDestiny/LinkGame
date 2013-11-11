package com.android.game.animation;

import android.graphics.Canvas;

public interface MyAnimation {
	
	public String getName();
	
	public String getType();
	
	public int getFrame();
	
	public void setInterval( int interval );
	
	public int getInterval();
	
	public int getHeight();
	
	public int getWidth();
	
	public boolean isEnd();
	
	public boolean isEndAnCirculation();
	
	public void nextFrame();
	
	public void start();
	
	public void end();
	
	public void draw( Canvas canvas, int cx, int cy );
	
}
