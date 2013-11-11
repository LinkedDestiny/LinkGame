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
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * @author user
 *
 */
public class HeroSelectView extends SurfaceView implements SurfaceHolder.Callback{

	private MainActivity activity;
	private SurfaceHolder holder;
	private HeroViewThread thread;
	
	private boolean b_hit = false;
	private ButtonDrawable button_hit = null;
	private Location loc_hit = null;
	private int width;
	
	private List<Integer> hero_list = new ArrayList<Integer>();
	private int index_select = 0;
	private int num_select = 0;
	private boolean b_run = false;
	
	public HeroSelectView(MainActivity activity) {
		super(activity);
		this.activity = activity;
		holder = this.getHolder();
		holder.addCallback( this );
		width = UIDefaultData.container_bmp.getBitmap("hero_1_select" ).getWidth();
	}

	public void initView(){
		UIDefaultData.drawable_buttons.initHeroSelectViewButton();
		UIDefaultData.drawable_bmps.initHeroSelectDrawable();
		hero_list.clear();
		hero_list.add(0);
		hero_list.add(0);
		hero_list.add(0);
		DefaultDataPool.HERO_LIST.clear();
		index_select = num_select = 0;
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		thread = new HeroViewThread();	
		thread.setWordFlag(true);
		thread.start();
		b_run = true;
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		thread.setWordFlag(false);
		thread.setFlag(false);
		b_run = false;
	}
	
	public void destroyHeroViewThread(){
		thread.setWordFlag(false);
		thread.setFlag(false);
		b_run = false;
	}
	
	@Override
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
					button_hit.setState(ButtonDrawable.CLICKED);
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
		System.out.println( "hit " + name );
		if( name == "hero_select_ensure" ){
			if( num_select != 2 ){
				Toast.makeText( activity.getApplicationContext(), "亲~~要选择两个英雄呦~~", Toast.LENGTH_SHORT).show();
				return;
			}
			for( int i = 0 ; i < hero_list.size() ; i ++ ){
				if( hero_list.get(i) == 1 )
					DefaultDataPool.HERO_LIST.add( "hero_" + ( i + 1 ) );
			}
			b_run = false;
			thread.setFlag(false);
			activity.current = WHICHVIEW.SOILDER_LEVEL_VIEW;
			activity.sendMessage( 3 );
	
		}
		else if( name == "select" )
			selectHero( index_select );
		else{
			if( name.startsWith("hero_1") )
				index_select = 0;
			else if( name.startsWith("hero_2" ) )
				index_select = 1;
			else
				index_select = 2;
		}
	}
	
	public void selectHero( int index ){
		if( hero_list.get(index) == 1 ){
			hero_list.set( index, 0 );
			num_select --;
		}
		else{
			if( num_select == 2 ){
				Toast.makeText( activity.getApplicationContext(), "亲~~只能选择两个英雄呦~~", Toast.LENGTH_SHORT).show();
				return;
			}
			hero_list.set(index, 1);
			num_select ++;
		}
	} 
	
	public class HeroViewThread extends Thread{
		private boolean b_flag = true;
		private boolean b_work = false;
		private Canvas canvas;
		
		public HeroViewThread(){
			super();
		}
		
		public void setFlag( boolean flag ){
			b_flag = flag;
		}
		
		public void setWordFlag( boolean work ){
			b_work = work;
		}
		
		public void drawHeroSelect(){
			if( !b_run )
				return;
			UIDefaultData.drawable_bmps.getDrawable( 2 + index_select ).draw(canvas, null);
			if( !b_run )
				return;
			for( int i = 0; i < 3; i ++ ){
				if( hero_list.get(i) == 1 ){
					UIDefaultData.container_bmp.getBitmap("choose").draw(canvas, 
							(int)( 170 * UIDefaultData.f_y_scales + 80f / 120 * width ), 
							(int)( ( 126 + i * 155 ) * UIDefaultData.f_y_scales + 80f / 120 * width ), 255);
				}
			}
			if( hero_list.get( index_select ) == 1 && b_run )
				UIDefaultData.drawable_buttons.getDrawable("cansel").draw(canvas, null );
			else if( hero_list.get(index_select) == 0 && b_run )
				UIDefaultData.drawable_buttons.getDrawable("select").draw(canvas, null);
		}
		
		public void draw(){
			canvas = holder.lockCanvas(null);
			try{
				//绘图操作
				if( canvas != null && b_run ){
					for( int i = 0; i < 2; i ++ )
						UIDefaultData.drawable_bmps.getDrawable(i).draw(canvas, null);
					for( int i = 0; i < Constant.skill_button.size() - 1; i ++ ){
						Location loc = Constant.skill_button.get(i);
						UIDefaultData.drawable_buttons.getDrawable( loc.getName() ).draw(canvas, loc);
					}
					drawHeroSelect();
				}
			}
			finally{
				//解锁画布，绘图结束
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
					//控制帧数
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
