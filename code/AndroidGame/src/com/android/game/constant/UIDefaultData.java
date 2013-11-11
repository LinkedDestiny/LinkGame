package com.android.game.constant;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.game.R;
import com.android.game.animation.MyAnimationContainer;
import com.android.game.bitmap.MyBitmapContainer;
import com.android.game.drawable.BitmapDrawableContainer;
import com.android.game.drawable.button.ButtonDrawableContainer;
import com.android.game.item.Location;

public class UIDefaultData {
	
	public static int i_scroll_bound;                            //滚屏边界
	public static int i_x_scroll;                                    //滚屏程度,即当前区域起始横坐标
	public static int i_x_screen;                                  //屏幕宽度
	public static int i_y_screen;                                  //屏幕高度
	public static float f_scales;                                   //图片放缩比例
	public static float f_x_scales;                               //横坐标修改值
	public static float f_y_scales;                               //纵坐标修改值
	public static float f_speed;                                       //滚屏速度
	public static Resources res;
	
	public static MyBitmapContainer container_bmp;                                 //存储所有位图资源
	public static MyAnimationContainer container_animation;                   //存储所有动画资源 
	public static BitmapDrawableContainer drawable_bmps;                     //存储所有直接绘制的图片
	public static ButtonDrawableContainer drawable_buttons;                  //存储所有按键绘图元件
	public static List<Location> skill_ani_loc;
	
	public static final int DRAW_INTERVAL = 35;       //绘图时间间隔
	public static final int MOVE_ANIMATION_INTERVAL = 150;          //移动动画时间间隔
	public static final int MOVE_ANIMATION_FRAME = 4;
	public static final int ATTACK_ANIMATION_INTERVAL = 150;        //攻击动画时间间隔
	public static final int ATTACK_ANIMATION_FRAME = 2;
	public static final int DEATH_ANIMATION_INTERVAL = 200;         //死亡动画时间间隔
	public static final int DEATH_ANIMATION_FRAME = 5;                 //死亡动画帧数
	public static final int MASK_ALPHA = 200;         //遮罩图片透明度
	
	public static void initUIDefaultData(){
    	//初始化图片资源
    	container_bmp = new MyBitmapContainer();
    	container_bmp.initBitmapContainer();
    	//初始化动画资源
    	container_animation = new MyAnimationContainer();
    	container_animation.initAnimationContainer();
    	//初始化绘图元件
    	drawable_bmps = new BitmapDrawableContainer();
    	drawable_buttons = new ButtonDrawableContainer();
    	//初始化滚屏相关数据
    	i_scroll_bound = container_bmp.getBitmap("BACKGROUND").getWidth() - i_x_screen;
    	i_x_scroll = 0;
    	f_speed = 0;
	}
	
	public static void initScales(){
		Bitmap test = BitmapFactory.decodeResource( res, R.drawable.ic_launcher );
    	float temp = 0;
    	switch( test.getHeight() ){
    	case 48:    case 32:
    		temp = (float)i_y_screen / 320;
    		break;
    	case 72:
    		temp = (float)i_y_screen / 480;
    		break;
    	case 96:
    		temp = (float)i_y_screen / 640;
    		break;
    	}
    	f_scales = temp;
    	f_x_scales = (float)i_x_screen / 960;
    	f_y_scales = (float)i_y_screen / 640;
    	System.out.println( f_x_scales + " " + f_x_scales );
	}
	
}
