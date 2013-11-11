package com.android.game.animation;

import java.util.ArrayList;

import android.graphics.Canvas;

import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.UIDefaultData;

/*
DisposableAnimation一次性动画
只播放（循环）依次一次就消失
*/

public class DisposableAnimation implements MyAnimation{
	
	private ArrayList<MyBitmap> bmps;
	private String str_name;
	private int i_frame;        //帧数
	private int i_current;      //当前帧
	private int i_interval;     //每帧间隔时间（大于35ms）
	private int i_control;      //用于控制播放
	
	public DisposableAnimation( String name, int frame, int interval ){
		str_name = name;
		i_frame = frame;
		i_interval = interval;
		i_current = -1;
		i_control = 0;
		bmps = new ArrayList<MyBitmap>();
		//载入图片
		for( int i = 1; i <= frame; i ++ ){
			String temp = name + '_' + i;
			bmps.add( UIDefaultData.container_bmp.getBitmap(temp) );
		}
	}
	
	//拷贝构造
	public DisposableAnimation( MyAnimation ani ){
		str_name = ani.getName();
		i_frame = ani.getFrame();
		i_interval = ani.getInterval();
		bmps = new ArrayList<MyBitmap>();
		//载入图片
		for( int i = 1; i <= i_frame; i ++ ){
			String temp = ani.getName() + '_' + i;
			bmps.add( UIDefaultData.container_bmp.getBitmap(temp) );
		}
		i_current = -1;
		i_control = 0;
	}

	public String getName() {
		return str_name;
	}
	
	public String getType(){
		return "DisposableAnimation";
	}
	
	public int getFrame() {
		return i_frame;
	}
	
	public int getHeight(){
		return bmps.get(0).getHeight();
	}
	
	public int getWidth(){
		return bmps.get(0).getWidth();
	}

	public void setInterval( int interval ){
		this.i_interval = interval;
	}
	
	public int getInterval() {
		return i_interval;
	}

	public boolean isEnd() {
		if( i_current == -1 ){
			return true;
		}
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
			i_control -= i_interval;
		}
		//判断是否播放完
		if( i_current >= i_frame )
			i_current = -1;
	}
	
	public void start(){
		i_control = i_current = 0;
	}
	
	public void end(){
		i_current = -1;
	}

	public void draw(Canvas canvas, int cx, int cy ) {
		if( i_current < i_frame && i_current >= 0 ){
			bmps.get(i_current).draw(canvas, cx, cy, 255 );
			nextFrame();
		}
	}

}
