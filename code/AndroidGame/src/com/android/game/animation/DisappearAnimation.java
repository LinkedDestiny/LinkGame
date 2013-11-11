package com.android.game.animation;

import android.graphics.Canvas;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;

/*
DisappearAnimation消失动画:
一张图片从不透明到完全透明的动画，仅循环一次
*/

public class DisappearAnimation implements MyAnimation{

	private MyBitmap bmps;
	private String str_name;
	private int i_frame;        //帧数
	private int i_current;      //当前帧
	private int i_interval;     //每帧间隔时间（大于35ms）
	private int i_control;      //用于控制播放
	private int i_alpha;     //透明度
	
	public DisappearAnimation( String name, int frame, int interval ){
		str_name = name;
		i_frame = frame;
		i_interval = interval;
		i_current = i_control = 0;
		i_alpha = 255;
		bmps = UIDefaultData.container_bmp.getBitmap(name);
	}
	
	public DisappearAnimation( MyAnimation ani ){
		str_name = ani.getName();
		i_frame = ani.getFrame();
		i_interval = ani.getInterval();
		bmps = UIDefaultData.container_bmp.getBitmap( str_name );
		i_current = i_control = 0;
		i_alpha = 255;
	}

	public String getName() {
		return str_name;
	}
	
	public String getType(){
		return "DisappearAnimation";
	}
	
	public int getFrame() {
		return i_frame;
	}
	
	public int getHeight(){
		return bmps.getHeight();
	}
	
	public int getWidth(){
		return bmps.getWidth();
	}

	public void setInterval( int interval ){
		this.i_interval = interval;
	}
	
	public int getInterval() {
		return i_interval;
	}

	public boolean isEnd() {
		if( i_current == -1 )
			return true;
		return false;
	}

	public boolean isEndAnCirculation() {
		return isEnd();
	}
	
	public void nextFrame() {
		//控制播放进度
		i_control += UIDefaultData.DRAW_INTERVAL;
		if( i_control >= i_interval ){
			i_current ++;
			i_alpha -= ( 255 / i_frame );
			i_control -= i_interval;
		}
		//判断是否播放完
		if( i_current >= i_frame || i_alpha < 0 ){
			i_current = -1;
		}
	}
	
	public void start(){
		i_control = i_current = 0;
	}
	
	public void end(){
		i_current = -1;
	}
	
	public void draw(Canvas canvas, int cx, int cy) {
		if( i_current < i_frame ){
			bmps.draw( canvas, cx, cy, i_alpha );
			nextFrame();
		}
	}
	
}
