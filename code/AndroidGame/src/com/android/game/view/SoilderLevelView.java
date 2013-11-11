/**
 * 
 */
package com.android.game.view;

import java.util.ArrayList;
import java.util.List;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.UIDefaultData;
import com.android.game.drawable.button.ButtonDrawable;
import com.android.game.item.Location;
import com.android.game.main.MainActivity;
import com.android.game.main.MainActivity.WHICHVIEW;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author user
 *
 */
public class SoilderLevelView extends SurfaceView implements SurfaceHolder.Callback{

	private MainActivity activity;
	private SurfaceHolder holder;
	private SoilderViewThread thread;
	private boolean b_hit = false;
	private ButtonDrawable button_hit = null;
	private Location loc_hit = null;
	private List<Integer> soilder_level;

	public SoilderLevelView( MainActivity activity ) {
		super(activity);
		this.activity = activity;
		holder = this.getHolder();
		holder.addCallback( this );
	}
	
	public void initView(){
		UIDefaultData.drawable_buttons.initSoilderViewButton();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		soilder_level = new ArrayList<Integer>();
		soilder_level.add( DefaultDataPool.SOILDER_LEVEL.get("Footman"));
		soilder_level.add( DefaultDataPool.SOILDER_LEVEL.get("Archer") );
		soilder_level.add( DefaultDataPool.SOILDER_LEVEL.get("Shield") );
		soilder_level.add( DefaultDataPool.SOILDER_LEVEL.get("HeavyRider"));
		thread = new SoilderViewThread();	
		thread.setWordFlag(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		thread.setWordFlag(false);
		thread.setFlag(false);
	}
	
	public void destroySoilderThread(){
		thread.setWordFlag(false);
		thread.setFlag(false);
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		ButtonDrawable button;
		switch( event.getAction() ){
		case MotionEvent.ACTION_DOWN:
			for( int i = 0; i < Constant.skill_button.size(); i ++ ){
				Location loc = Constant.skill_button.get(i);
				button = (ButtonDrawable)UIDefaultData.drawable_buttons.getDrawable( loc.getName() );
				if( button.getRect().contains( (int)event.getX(), (int)event.getY() ) ){
					button_hit = button;
					loc_hit = loc;
					loc_hit.setState( ButtonDrawable.CLICKED );
					b_hit = true;
				}
			}
			break;
			
		case MotionEvent.ACTION_UP:
			System.out.println( "ACTION_UP" );
			if( b_hit && button_hit.getRect().contains( (int)event.getX(), (int)event.getY() ) ){
				System.out.println( "set NORMAL" );
				button_hit.setState( ButtonDrawable.NORMAL );
				String name = button_hit.getName();
				button_hit = null;
				loc_hit.setState( ButtonDrawable.NORMAL );
				loc_hit = null;
				onClicked( name );
			}
			else if( b_hit ){
				button_hit.setState( ButtonDrawable.NORMAL );
				button_hit = null;
				loc_hit.setState( ButtonDrawable.NORMAL );
				loc_hit = null;
			}
			b_hit = false;
			break;			
		}
		return true;
	}
	
	public void onClicked( String name ){
		if( name == "Ensure_BUTTON" ){
			System.out.println( "click ensure button" );
			activity.current = WHICHVIEW.GAME_VIEW;
			activity.sendMessage( 6 );
			thread.setFlag(false);
		}else if( Constant.Level_money >= 10 ){
			if( name == "Footman_levelup_BUTTON" ){
				System.out.println( "click footman up button" );
				DefaultDataPool.updateSoilderAbility("Footman", soilder_level.get(0) + 1 );
				soilder_level.set(0 , DefaultDataPool.SOILDER_LEVEL.get("Footman"));
			}
			else if( name == "Archer_levelup_BUTTON" ){
				System.out.println( "click archer up button" );
				DefaultDataPool.updateSoilderAbility("Archer", soilder_level.get(1) + 1 );
				soilder_level.set(1 , DefaultDataPool.SOILDER_LEVEL.get("Archer"));
			}
			else if( name == "Shield_levelup_BUTTON" ){
				System.out.println( "click shield up button" );
				DefaultDataPool.updateSoilderAbility("Shield", soilder_level.get(2) + 1 );
				soilder_level.set(2 , DefaultDataPool.SOILDER_LEVEL.get("Shield"));
			}
			else if( name == "Rider_levelup_BUTTON" ){
				System.out.println( "click rider up button" );
				DefaultDataPool.updateSoilderAbility("HeavyRider", soilder_level.get(3) + 1 );
				soilder_level.set(3 , DefaultDataPool.SOILDER_LEVEL.get("HeavyRider"));
			}
			Constant.Level_money -= 10;
		}
		
	}
	
	public class SoilderViewThread extends Thread{
		private boolean b_flag = true;
		private boolean b_work = false;
		private Canvas canvas;
		
		public SoilderViewThread(){
			super();
		}
		
		public void setFlag( boolean flag ){
			b_flag = flag;
		}
		
		public void setWordFlag( boolean work ){
			b_work = work;
		}
		
		public void drawIcon(){
			for( int i = 0; i < 5; i ++ ){
				if( i < soilder_level.get(0) )
					UIDefaultData.container_bmp.getBitmap( "Footman_icon" ).draw(canvas, 220 + i * 95, 110, 255 );
				else
					UIDefaultData.container_bmp.getBitmap( "Footman_icon" ).draw(canvas, 220 + i * 95, 110, 60 );
				
				if( i < soilder_level.get(1) )
					UIDefaultData.container_bmp.getBitmap( "Archer_icon" ).draw(canvas, 230 + i * 95, 230, 255 );
				else
					UIDefaultData.container_bmp.getBitmap( "Archer_icon" ).draw(canvas, 230 + i * 95, 230, 60 );
				
				if( i < soilder_level.get(2) )
					UIDefaultData.container_bmp.getBitmap( "Shield_icon" ).draw(canvas, 180 + i * 95, 340, 255 );
				else
					UIDefaultData.container_bmp.getBitmap( "Shield_icon" ).draw(canvas, 180 + i * 95, 340, 60 );
				
				if( i < soilder_level.get(3) )
					UIDefaultData.container_bmp.getBitmap( "Rider_icon" ).draw(canvas, 170 + i * 95, 490, 255 );
				else
					UIDefaultData.container_bmp.getBitmap( "Rider_icon" ).draw(canvas, 170 + i * 95, 490, 60 );
			}
		}
		
		public void draw(){
			canvas = holder.lockCanvas(null);
			try{
				//»æÍ¼²Ù×÷
				if( canvas != null ){
					UIDefaultData.container_bmp.getBitmap("SoilderBackground" ).draw(canvas, 0, 0, 255 );
					drawIcon();
					for( int i = 0; i < Constant.skill_button.size(); i ++ ){
						Location loc = Constant.skill_button.get(i);
						UIDefaultData.drawable_buttons.getDrawable( loc.getName() ).draw(canvas, loc);
					}
					Paint paint = new Paint();
					paint.setTextSize( (int)( UIDefaultData.f_y_scales * 35 ) );
					canvas.drawText( Constant.Level_money + "", (int)( 775 * UIDefaultData.f_y_scales ), 
							(int)( 80 * UIDefaultData.f_y_scales ), paint );
				}
			}
			finally{
				//½âËø»­²¼£¬»æÍ¼½áÊø
				if( canvas != null )
					holder.unlockCanvasAndPost(canvas);
			}
		}
		
		public void run(){
			while( b_flag ){
				if( b_work ){
					long begin_time = System.currentTimeMillis();
					draw();
					long end_time = System.currentTimeMillis();	
					//¿ØÖÆÖ¡Êý
					if( end_time - begin_time < UIDefaultData.DRAW_INTERVAL )
						try{
							Thread.sleep( UIDefaultData.DRAW_INTERVAL - ( end_time - begin_time ) );
						}
						catch( InterruptedException e ){
							e.printStackTrace();
						}
				}
			}
		}
		
	}

}
