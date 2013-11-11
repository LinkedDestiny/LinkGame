/**
 * 
 */
package com.android.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.constant.GameInfo;
import com.android.game.constant.Message;
import com.android.game.item.DefaultSoilder;
import com.android.game.item.Hero;
import com.android.game.item.Soilder;
import com.android.game.main.MainView;

/**
 * @author 星陨
 *
 * @功能 游戏总控制类，用于UI层和底层Controller之间的通信
 */
public class GameController {
	
	MainView view;
	
	ActionController actionController;
	KeyDownController keydownController;
	HeroSkillController heroskillController;
	AIController controller;
	
	SoilderFactory factory;
	
	public GameInfo gameinfo;
	int level;
	
	private List<Hero> herolist = new ArrayList<Hero>();
	//己方士兵列表
	private List<Soilder> soilders = new ArrayList<Soilder>();
	//敌方士兵列表
	private List<Soilder> enemies = new ArrayList<Soilder>();
	
	private List<Soilder> arrow = new ArrayList<Soilder>();
	
	public Soilder castle;
	public Soilder e_castle;
	
	private GameLoop gameLoop;
	
	public GameController( MainView view , int level , List<String> herolist ){
		this.view = view;
		
		this.level = level;
		for( int i = 0 ; i < herolist.size() ; i ++ )
			this.herolist.add( DefaultDataPool.getHero(herolist.get(i)));
		
		
		initlizeGame();
		
		castle = new DefaultSoilder("Castle" , 1 , Constant.CASTLE_X , Constant.CASTLE_Y , 2 , 1 );
		e_castle = new DefaultSoilder("Castle_e" , 2 , Constant.CASTLE_X + Constant.DISTANCE, Constant.CASTLE_Y , 2 , 2 );
		
		actionController = new ActionController( this );
		keydownController = new KeyDownController( this );
		heroskillController = new HeroSkillController( this );
		controller = new AIController( this );
		
		factory = new SoilderFactory( this );
		
		gameLoop = new GameLoop();
		gameLoop.start();
	}
	
	public void initlizeGame(){
		Constant.initlizeGame();
		Message.initlize();
		DefaultDataPool.helper.openDatabase();
		DefaultDataPool.loadTimerShaft(level);
		DefaultDataPool.loadSoilderAbility();
		DefaultDataPool.loadSoilderSkill();
		DefaultDataPool.helper.closeDatabase();
		gameinfo = new GameInfo( this , level );
		GameInfo.initlizeGame();
		System.out.println("initlize succedd");
	}
	
	/**
	 * @function controller the action of soilders
	 */
	public void controllerEntry(){
		int type = gameOver();
		if( type == 0 ){
			keydownController.keyDown();
			actionController.ActionMainLoop();
			controller.AIEntry();
		}else if( type == 1 ){
			System.out.println("game over");
			Win();
		}else if( type == -1 ){
			System.out.println("game over");
			Fail();
		}
	}
	
	public void Win(){
		Message.GAMEOVER = 1;
		
		view.gameOver();
	}
	public void Fail(){
		Message.GAMEOVER = -1;
		
		view.gameOver();
	}
	
	/**
	 * @function the interface of the soilders
	 * @return
	 * List<Soilder>
	 */
	public List<Soilder> getSoilders(){
		return this.soilders;
	}
	
	/**
	 * @function the interface of the enemies
	 * @return
	 * List<Soilder>
	 */
	public List<Soilder> getEnemies(){
		return this.enemies;
	}
	
	public List<Soilder> getArrow(){
		return arrow;
	}
	
	/****************************************************/
	// function to controll the gameLoop
	
	public void startGameLoop(){
		gameLoop.setWorkFlag(true);
	}
	
	public void pauseGameLoop(){
		gameLoop.setWorkFlag(false);
	}
	
	public void stopGameLoop(){
		gameLoop.setFlag(false);
	}
	
	public class GameLoop extends Thread{
		
		private int sleepSpan = 20;
		private boolean flag = true;
		private boolean workFlag = false;
		
		public void setFlag( boolean flag ){
			this.flag = flag;
		}
		public void setWorkFlag( boolean workFlag ){
			this.workFlag = workFlag;
		}
		
		public void run(){
			while( flag ){
				if( workFlag ){
					
					controllerEntry();
					
					try{
						Thread.sleep( sleepSpan  );
					}catch( Exception e ){
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public int gameOver(){
		if( castle.getAbilityScore("HP").getModifierValue() <= 0 ){
			if( Constant.soilder_list.get(0).getState() == 5 ){
				System.out.println(" win ");
				this.pauseGameLoop();
				return 1;
			}else{
				Constant.soilder_list.get(0).setState( Constant.SOILDER_ACTION_DEATH );
				return 0;
			}
		}else if( e_castle.getAbilityScore("HP").getModifierValue() <= 0 ){
			
			if( Constant.soilder_list.get(1).getState() == 5 ){
				System.out.println(" fail ");
				this.pauseGameLoop();
				return -1;
			}else{
				Constant.soilder_list.get(1).setState( Constant.SOILDER_ACTION_DEATH );
				return 0;
			}
		}
		
		return 0;
	}
}