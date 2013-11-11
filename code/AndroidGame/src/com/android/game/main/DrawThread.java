package com.android.game.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import com.android.game.animation.MyAnimation;
import com.android.game.bitmap.MyBitmap;
import com.android.game.constant.Constant;
import com.android.game.constant.GameInfo;
import com.android.game.constant.Message;
import com.android.game.constant.UIDefaultData;
import com.android.game.controller.GestureController;
import com.android.game.drawable.character.CharacterDrawable;
import com.android.game.drawable.character.CharacterDrawableFactory;
import com.android.game.item.Location;

public class DrawThread  extends Thread{
	
	private SurfaceHolder holder;
	private Canvas canvas;
	private boolean b_run = false;
	private boolean workflag = true;
	private Location loc = new Location( "", 0, 0, 0 );
	private int index = 0;
	private Map<Integer, CharacterDrawable> characters;
	private Rect rec_dst_our, rec_dst_enemy, rec_our, rec_enemy;
	private int right_our, right_enemy, wid, hei;
	
	public DrawThread( SurfaceHolder holder ){
		super();
		this.holder = holder;
		characters = new HashMap<Integer, CharacterDrawable>();
		UIDefaultData.skill_ani_loc = new ArrayList<Location>();
		wid = UIDefaultData.container_bmp.getBitmap("OUR_HEALTH").getWidth();
		hei = UIDefaultData.container_bmp.getBitmap("OUR_HEALTH").getHeight();
		right_our = (int)( 358 * UIDefaultData.f_x_scales ) + wid;
		right_enemy = (int)( 358 * UIDefaultData.f_x_scales ) + wid;
		rec_our = new Rect( 0, 0, wid, hei );
		rec_enemy = new Rect( 0, 0, wid, hei );
		rec_dst_our = new Rect( (int)( 358 * UIDefaultData.f_x_scales ), (int)( 14 * UIDefaultData.f_y_scales ), 
				right_our, (int)( 14 * UIDefaultData.f_y_scales ) + hei );
		rec_dst_enemy = new Rect( (int)( 358 * UIDefaultData.f_x_scales ), (int)( 34 * UIDefaultData.f_y_scales ), 
				right_enemy , (int)( 34 * UIDefaultData.f_y_scales ) + hei );
	}
	
	public void setWorkFlag( boolean workflag ){
		this.workflag = workflag;
	}
	
	public boolean getIsRun(){
		return b_run;
	}
	
	public void setIsRun( boolean run ){
		b_run = run;
	}
	
	public void draw(){
		//锁定SurfaceView的画布，用于画图
		canvas = holder.lockCanvas(null);
		try{
			//绘图操作
			if( canvas != null ){
				drawBattleView();
			}
		}
		finally{
			//解锁画布，绘图结束
			if( canvas != null )
				holder.unlockCanvasAndPost(canvas);
		}
	}
	
	public void drawBattleView(){
		//滚屏
		if( UIDefaultData.f_speed != 0 )
			GestureController.scrollScreen( UIDefaultData.f_speed );
		//画背景图
		for( int i = 0; i < UIDefaultData.drawable_bmps.staticBitmapNum(); i ++ )
			UIDefaultData.drawable_bmps.getDrawable(i).draw(canvas, loc);
		//画城堡
		for( int i = 0; i < 2; i ++ ){
			if( drawCharacter( Constant.soilder_list.get(i), i ) )
				i --;
		}
		//画小地图
		UIDefaultData.drawable_bmps.getDrawable( UIDefaultData.drawable_bmps.staticBitmapNum() + 2 ).draw(canvas, 
			new Location( "", UIDefaultData.i_x_scroll, 0, 0 ) );
		//画角色
		for( int i = 2; i < Constant.soilder_list.size(); i ++ ){
			if( drawCharacter( Constant.soilder_list.get(i), i ) )
				i --;
		}
		//画箭支
		for( int i = 0; i < Constant.arrow_list.size(); i ++ ){
			Location location = Constant.arrow_list.get(i);
			if( location.getState() == Constant.SOILDER_ACTION_DEATH )
				Constant.arrow_list.remove(i);
			else
				UIDefaultData.container_bmp.getBitmap( "Arrow" ).draw(canvas, 
						(int)( location.getX() * UIDefaultData.f_y_scales ), 
						(int)( location.getY() * UIDefaultData.f_y_scales ), 255 );

		}
		UIDefaultData.drawable_bmps.getDrawable( UIDefaultData.drawable_bmps.staticBitmapNum() + 3 ).draw(canvas, 
			new Location( "", UIDefaultData.i_x_scroll, 0, 0 ) );
		//画英雄图标
		for( int i = UIDefaultData.drawable_bmps.staticBitmapNum(); i < UIDefaultData.drawable_bmps.staticBitmapNum() + 2; i ++ ){
			UIDefaultData.drawable_bmps.getDrawable(i).draw(canvas, loc);
		}
		//画按键
		for( int i = 0; i < Constant.skill_button.size(); i ++ ){
			Location location = Constant.skill_button.get(i);
			UIDefaultData.drawable_buttons.getDrawable( location.getName() ).draw(canvas, location);
		}
		//画英雄技能特效
		for( int i = 0; i < UIDefaultData.skill_ani_loc.size(); i ++ ){
			Location location = UIDefaultData.skill_ani_loc.get(i);
			MyAnimation ani = UIDefaultData.container_animation.getAnimation( location.getName() );
			if( ani.isEnd() )
				ani.start();
			ani.draw(canvas, (int)( location.getX() * UIDefaultData.f_y_scales - ani.getWidth() / 2 ), 
					(int)( location.getY() * UIDefaultData.f_y_scales ) );
			if( ani.isEnd() ){
				UIDefaultData.skill_ani_loc.remove(i);
				i --;
			}
		}
		drawData();
	}
	
	public void drawData(){
		Paint paint = new Paint();
		paint.setTextSize((int)( 30 * UIDefaultData.f_y_scales ));
		paint.setFakeBoldText(true);
		paint.setColor(Color.BLACK );
		canvas.drawText( GameInfo.money + "", 180 * UIDefaultData.f_x_scales, 600 * UIDefaultData.f_y_scales , paint);
		paint.setColor(Color.WHITE );
		paint.setTextSize( (int)( 25 * UIDefaultData.f_y_scales ) );
		canvas.drawText( GameInfo.level + "", 395 * UIDefaultData.f_x_scales, 45 * UIDefaultData.f_y_scales, paint );

		int real_wid = (int)( UIDefaultData.container_bmp.getBitmap("OUR_HEALTH").getWidth() * 0.75125 );
		rec_our.right = wid - (int)( real_wid * ( 1 - GameInfo.getPercent(1) ) );
		rec_enemy.right = wid - (int)( real_wid * ( 1 - GameInfo.getPercent(2) ) );
		rec_dst_our.right = right_our - (int)( real_wid * ( 1 - GameInfo.getPercent(1) ) );
		rec_dst_enemy.right = right_enemy - (int)( real_wid *  ( 1 - GameInfo.getPercent(2) ) );
		canvas.drawBitmap( UIDefaultData.container_bmp.getBitmap("our_hp").getBitmap(), rec_our, rec_dst_our, null );
		canvas.drawBitmap( UIDefaultData.container_bmp.getBitmap("enemy_hp").getBitmap(), rec_enemy, rec_dst_enemy, null );
	}
	
	//需删除人物则返回true
	public boolean drawCharacter( Location location, int i ){
		if( location.getState() == 5 ){
			System.out.println(" castle is dead " );
			return false;
		}
		//如果当前人物不存在，则创建新人物存在人物列表characters里
		if( location.getIndex() == -1 ){
			CharacterDrawable t_ani = CharacterDrawableFactory.createCharacterDrawable( location.getName() );
			int index = this.index;
			characters.put( index, t_ani );
			location.setIndex(index);
			this.index ++;
		}
		CharacterDrawable character = characters.get(location.getIndex());
		if( character == null )
			return false;
		//如果动画结束，就将其从绘图列表中删除(针对一次性动画)
		if( character.isDead() ){
			characters.remove(location.getIndex());
			if( ( location.getName() == "Castle" ||  location.getName() == "Castle_e" ) ){
				if( location.getState() == 3 ){
					location.setState(5);
					return false;
				}
			}else
				Constant.soilder_list.remove(i);
			return true;
		}
		character.draw(canvas, location);
		//画小地图上的图标
		if( i >= 2 ){
			if( location.getName().startsWith( "Monster" ) )
				UIDefaultData.drawable_bmps.getDrawable( UIDefaultData.drawable_bmps.size() - 1 ).draw(canvas, location);
			else
				UIDefaultData.drawable_bmps.getDrawable( UIDefaultData.drawable_bmps.size() - 2 ).draw(canvas, location );
		}
		return false;
	}
	
	public void drawGameState( int state ){
		MyBitmap bmp;
		if( state == -1 )
			bmp = UIDefaultData.container_bmp.getBitmap("game_over" );
		else
			bmp = UIDefaultData.container_bmp.getBitmap("game_win" );
		bmp.draw(canvas, ( UIDefaultData.i_x_screen - bmp.getWidth() ) / 2, ( UIDefaultData.i_y_screen - bmp.getHeight() ) / 2, 255 );
	}

	public void run() {
		while( b_run ){
			if( workflag ){
				long begin_time = System.currentTimeMillis();
				draw();
				if( Message.GAMEOVER != 0 )
					drawGameState( Message.GAMEOVER );
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