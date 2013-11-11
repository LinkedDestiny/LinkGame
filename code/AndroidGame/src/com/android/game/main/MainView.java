package com.android.game.main;

import java.util.List;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.Message;
import com.android.game.constant.UIDefaultData;
import com.android.game.controller.GameController;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainView  extends SurfaceView implements SurfaceHolder.Callback{

	private MainActivity activity;
	private SurfaceHolder holder;
	private DrawThread thread_draw;
	private GameController game_controller; 
	private List<String> hero;
	
	public MainView(MainActivity activity ){
		//绑定SurfaceHolder,使用holder控制SurfaceView
		super(activity);
		this.activity = activity;
		System.out.println("MainView creating");
		holder = this.getHolder();
		holder.addCallback(this);		 	
		hero = DefaultDataPool.HERO_LIST;
    	System.out.println("MainView created");
	}
	
	public void initView(){
		DefaultDataPool.helper.openDatabase();
		DefaultDataPool.loadSkill( hero.get(0), hero.get(1) );
		DefaultDataPool.helper.closeDatabase();
		UIDefaultData.drawable_bmps.initBatleDrawableContainer(hero);
    	UIDefaultData.drawable_buttons.initBatleDrawableContainer(hero);   
	}
	
	public void gameOver(){
		if( Message.GAMEOVER == 1 ){
			Constant.Level_money += 20;
			Constant.level += 1;
			activity.sendMessage( 2 );
		}else if( Message.GAMEOVER == -1 ){
			activity.sendMessage( 1 );
		}
	}

	//surface改变时调用
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		System.out.println("Changed");
	}

	//surface创建时被调用
	public void surfaceCreated(SurfaceHolder holder) {
		System.out.println("Created");
		Constant.soilder_list.clear();
		UIDefaultData.i_x_scroll = 0;
		UIDefaultData.f_speed = 0;
		thread_draw = new DrawThread( holder );
    	game_controller = new GameController( this , Constant.level , hero ); 
		thread_draw.setIsRun( true );
		thread_draw.setWorkFlag(true);
		System.out.println( "b_run: " + thread_draw.getIsRun() );
		game_controller.startGameLoop();
		thread_draw.start();
	}

	//surface被销毁时调用
	public void surfaceDestroyed(SurfaceHolder holder) {
		System.out.println("Destroyed");
		destroyDrawThread();
	}
	
	//销毁thread_draw线程
	public void destroyDrawThread(){
		thread_draw.setIsRun( false );
		game_controller.stopGameLoop();
	}

}
