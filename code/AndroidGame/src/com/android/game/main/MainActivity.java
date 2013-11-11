package com.android.game.main;

import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.UIDefaultData;
import com.android.game.controller.GestureController;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.app.Activity;
import com.android.game.view.*;


public class MainActivity extends Activity {

	public enum WHICHVIEW{ WELCOME_VIEW , START_VIEW , HERO_SELECT_VIEW , SOILDER_LEVEL_VIEW , HELP_VIEW , SCORE_VIEW , GAME_VIEW };
	private MainView surfaceview = null;
	private GestureController gesture;
	private DefaultDataPool pool;
	
	private WelcomeView welcomeview;
	private StartView startview;
	private HeroSelectView heroselectview;
	private SoilderLevelView soilderlevelview;
	private HelpView helpview;
	private ScoreView scoreview;
	
	public WHICHVIEW current;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       
      //设置全屏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        super.onCreate(savedInstanceState);
       
        pool = new DefaultDataPool( this );
        pool.getClass();
        initStaticData();
        
        this.welcomeview = new WelcomeView( this );
        this.scoreview = new ScoreView( this );
        
        current = WHICHVIEW.WELCOME_VIEW;
        setContentView(welcomeview);
    }
    public void initlizeShelf(){
    	this.scoreview.initlizeShelf();
    }
    public void initStaticData(){
    	
    	UIDefaultData.res = getResources();
    	//获得屏幕的长宽
    	DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int temp1 = dm.widthPixels;
		int temp2 = dm.heightPixels;
		UIDefaultData.i_x_screen = temp1 > temp2 ? temp1 : temp2;
		UIDefaultData.i_y_screen = temp1 < temp2 ? temp1 : temp2;
		UIDefaultData.initScales();

    }

    //设置按键监听，按下back和home后退出线程
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch( keyCode ){
		case KeyEvent.KEYCODE_BACK:
			System.out.println( "back" );
			if( current != WHICHVIEW.START_VIEW ){
				if( current == WHICHVIEW.GAME_VIEW ){
					surfaceview.destroyDrawThread();
				}
				else if( current == WHICHVIEW.HERO_SELECT_VIEW )
					heroselectview.destroyHeroViewThread();
				else if( current == WHICHVIEW.SOILDER_LEVEL_VIEW )
					soilderlevelview.destroySoilderThread();
				else if( current == WHICHVIEW.HELP_VIEW )
					helpview.destroyHelpViewThread();
				current = WHICHVIEW.START_VIEW;
				this.sendMessage(1);	
				System.out.println( "go to start view" );
			}
			
			break;
		case KeyEvent.KEYCODE_HOME:
			System.out.println("HOME");
			exitGame();
			break;
		}
		return true;
	}
	
	public void exitGame(){
		if( surfaceview != null ){
			surfaceview.destroyDrawThread();
		}
		if( startview != null )
			startview.destroyStartViewThread();
		if( heroselectview != null )
			heroselectview.destroyHeroViewThread();
		if( helpview != null )
			helpview.destroyHelpViewThread();
		if( soilderlevelview != null )
			soilderlevelview.destroySoilderThread();
		System.exit(0);
	}

	//设置手势监听，用于处理屏幕上的点击、拖动及滚屏
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if( current == WHICHVIEW.GAME_VIEW ){
			System.out.println( "game view gesture" );
			return gesture.onTouchEvent(event);
		}
		return false;
	}
	
	public void setCurrent( WHICHVIEW which ){
		current = which;
	}
	
	Handler myHandler = new Handler(){
		@Override
		public void handleMessage( Message msg ){
			switch( msg.what ){
				case 0:{
					MainActivity.this.setContentView(welcomeview);
					break;
				}
				case 1:{
					if( startview == null ){
						startview = new StartView( MainActivity.this );
					}
					startview.initView();
					MainActivity.this.setContentView(startview);
					break;
				}
				case 2:{
					if( heroselectview == null ){
						heroselectview = new HeroSelectView( MainActivity.this );
					}
					heroselectview.initView();
					MainActivity.this.setContentView(heroselectview);
					break;
				}
				case 3:{
					if( soilderlevelview == null ){
						soilderlevelview = new SoilderLevelView( MainActivity.this );
					}
					System.out.println( "soilder view" );
					soilderlevelview.initView();
					MainActivity.this.setContentView( soilderlevelview );
					break;
				}
				case 4:{
					if( helpview == null ){
						helpview = new HelpView( MainActivity.this );
					}
					helpview.initView();
					MainActivity.this.setContentView(helpview);
					break;
				}
				case 5:{
					//MainActivity.this.setContentView( R.layout.main );
					if( ! scoreview.setShelf() ){
						Toast.makeText( MainActivity.this.getApplicationContext(), "积分墙打开失败！请检查联网状态", Toast.LENGTH_SHORT).show();
						MainActivity.this.sendMessage( 1 );
					}
					break;
				}
				case 6:{
					if( surfaceview == null ){
						surfaceview = new MainView( MainActivity.this );
				        gesture = new GestureController( MainActivity.this );
					}
					surfaceview.initView();
					MainActivity.this.setContentView(surfaceview);
					break;
				}
			}
		}
	};
	
	public void sendMessage( int what ){
    	Message msg1 = myHandler.obtainMessage( what );
    	myHandler.sendMessage( msg1 );							//发送消息
    }
}