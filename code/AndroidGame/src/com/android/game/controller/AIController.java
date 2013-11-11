/**
 * 
 */
package com.android.game.controller;

import java.util.List;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.Message;
import com.android.game.item.DefaultSoilder;
import com.android.game.time.Timer;

/**
 * @author user
 *
 */
public class AIController {
	
	private GameController controller;
	private List<Integer> time_shaft;
	
	private int scores = 0;
	
	private int score ;
	private int game_speed;
	
	private long time = 0;
	private int index = 2;
	
	private ScoreListener listener;
	
	public AIController( GameController controller ){
		this.controller = controller;
		initlizeAI();
	}
	
	public void initlizeAI(){
		time_shaft = DefaultDataPool.TIMESHAFT;
		score = time_shaft.get(0);
		game_speed = time_shaft.get(1);
		
		System.out.println( time_shaft.get(index) + " " + game_speed + " " );
		listener = new ScoreListener( game_speed );
		listener.setStartTime( Timer.getNowTime() );
	}
	public void AIEntry(){
		levelUp();
		getScore();
	}
	
	public void levelUp(){
		if( time >= time_shaft.get(index) ){
			score += 2;
			game_speed -= 100;
			listener.setLimitTime( game_speed );
			listener.setStartTime( Timer.getNowTime() );
			if( index == 5 ){
				return;
			}
			index ++;
			
		}
	}
	public void getScore(){
		if( listener.onListener( Timer.getNowTime() ) ){
			scores += score;
		}
		if( scores >= 20 ){
			scores -= 20;
			double type = Math.random();
			if( type <= 0.6 ){
				Message.new_enemy = new DefaultSoilder("Monster_2" , Constant.SOILDER_ID , 2620 , Constant.SOILDER_Y , 2 , 2 );
				
			}else{
				Message.new_enemy = new DefaultSoilder("Monster_1" , Constant.SOILDER_ID , 2620 , Constant.SOILDER_Y , 2 , 2 );
			}
			Constant.SOILDER_ID += 1;
			System.out.println( Constant.SOILDER_ID + " " );
			controller.getEnemies().add( Message.new_enemy );
		}
	}
	
	public class ScoreListener{
		private long limitTime;
		private long startTime;
		
		public ScoreListener( long limitTime ){
			this.limitTime = limitTime + (long)Math.random() * 500;
		}
		public boolean onListener( long nowTime ){
			if( ( nowTime - startTime ) >= limitTime ){
				time += limitTime;
				startTime = nowTime;
				return true;
			}else{
				return false;
			}
		}
		
		public void setLimitTime( long limitTime ){
			this.limitTime = limitTime + (long)Math.random() * 500;
		}
		public void setStartTime( long nowTime ){
			this.startTime = nowTime;
		}
	}	
}
