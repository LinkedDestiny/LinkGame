/**
 * 
 */
package com.android.game.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.android.game.R;
import com.android.game.bitmap.AbsoluteBitmap;
import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.UIDefaultData;
import com.android.game.main.MainActivity;
import com.android.game.main.MainActivity.WHICHVIEW;

/**
 * @author user
 *
 * 
 */
public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback{
	
	private MainActivity activity;
	private SurfaceHolder holder;
	
	private AbsoluteBitmap background;
	private AbsoluteBitmap logo;
	private boolean flag = true;
	
	private MyDraw thread;
	private LoadBitmap load;
	/**
	 * @param context
	 * @param attrs
	 */
	public WelcomeView(MainActivity activity) {
		super(activity);
		this.activity = activity;
		
		holder = this.getHolder();
		holder.addCallback( this );
		
		thread = new MyDraw();
		load = new LoadBitmap();
		
		initlizeBitmap();
	}
	
	public void initlizeBitmap(){
		background = new AbsoluteBitmap( R.drawable.welcome );
		logo = new AbsoluteBitmap( R.drawable.logo );
	}
	
	public void onDraw( Canvas canvas ){
		//进行平面贴图
		if( logo == null )return;
		
		background.draw(canvas, 0, 0, 255 );
		logo.draw(canvas, ( UIDefaultData.i_x_screen - logo.getWidth() ) / 2, 
				( UIDefaultData.i_y_screen - logo.getHeight() ) / 2, 255 );
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
	}

	
	public void surfaceCreated(SurfaceHolder holder) {
		load.start();
		thread.start();
	}

	
	public void surfaceDestroyed(SurfaceHolder holder) {
	
	}

	public class MyDraw extends Thread{
		public void run(){
			SurfaceHolder myHolder = WelcomeView.this.getHolder();
			Canvas canvas = myHolder.lockCanvas();						//获取画布
			try{
				synchronized( myHolder ){
					onDraw( canvas );						//绘制
				}
			}catch( Exception e ){
				e.printStackTrace();
			}finally{
				if( canvas != null )
					myHolder.unlockCanvasAndPost(canvas);
			}
			while( flag ){
				
			}
			activity.current = WHICHVIEW.START_VIEW;
			activity.sendMessage( 1 );
		}
	}
	
	public class LoadBitmap extends Thread{
		public void run(){
			UIDefaultData.initUIDefaultData();
			activity.initlizeShelf();
			DefaultDataPool.loadSoilderLevel();
			System.out.println("load over");
			try{
				Thread.sleep( 1000 );
			}catch( Exception e ){
				e.printStackTrace();
			}
			flag = false;
		}
	}
	

	
}
