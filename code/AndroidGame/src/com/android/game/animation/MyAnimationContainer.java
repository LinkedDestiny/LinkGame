package com.android.game.animation;

import java.util.HashMap;
import java.util.Map;

import com.android.game.constant.UIDefaultData;

public class MyAnimationContainer {
	
	private Map< String, MyAnimation > map_ani;
	
	public MyAnimationContainer(){
		map_ani = new HashMap<String, MyAnimation>();
	}
	
	public void initAnimationContainer(){
		/***********************************刀兵相关动画***************************************/
		map_ani.put( "Footman_MOVE", new DisposableAnimation( "Footman_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "Footman_ATTACK", new DisposableAnimation( "Footman_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Footman_SKILL", new DisposableAnimation( "Footman_SKILL", 
				3, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Footman_DEATH", new DisappearAnimation( "Footman_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );

		/***********************************弓箭手相关动画***************************************/
		map_ani.put( "Archer_MOVE", new DisposableAnimation( "Archer_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "Archer_ATTACK", new DisposableAnimation( "Archer_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME + 1, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Archer_SKILL", new DisposableAnimation( "Archer_SKILL", 
				3, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Archer_DEATH", new DisappearAnimation( "Archer_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );
		
		/***********************************盾兵相关动画***************************************/
		map_ani.put( "Shield_MOVE", new DisposableAnimation( "Shield_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "Shield_ATTACK", new DisposableAnimation( "Shield_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Shield_SKILL", new DisposableAnimation( "Shield_SKILL", 
				3, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Shield_DEATH", new DisappearAnimation( "Shield_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );

		/***********************************重骑兵相关动画***************************************/
		map_ani.put( "HeavyRider_MOVE", new DisposableAnimation( "HeavyRider_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "HeavyRider_ATTACK", new DisposableAnimation( "HeavyRider_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "HeavyRider_SKILL", new DisposableAnimation( "HeavyRider_SKILL", 
				3, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "HeavyRider_DEATH", new DisappearAnimation( "HeavyRider_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );
		
		/***********************************怪兽一相关动画***************************************/
		map_ani.put( "Monster_1_MOVE", new DisposableAnimation( "Monster_1_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_1_ATTACK", new DisposableAnimation( "Monster_1_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_1_SKILL", new DisposableAnimation( "Monster_1_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_1_DEATH", new DisappearAnimation( "Monster_1_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );
		
		/***********************************怪兽二相关动画***************************************/
		map_ani.put( "Monster_2_MOVE", new DisposableAnimation( "Monster_2_MOVE", 
				UIDefaultData.MOVE_ANIMATION_FRAME, 
				UIDefaultData.MOVE_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_2_ATTACK", new DisposableAnimation( "Monster_2_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_2_SKILL", new DisposableAnimation( "Monster_2_ATTACK",
				UIDefaultData.ATTACK_ANIMATION_FRAME, 
				UIDefaultData.ATTACK_ANIMATION_INTERVAL ) );
		map_ani.put( "Monster_2_DEATH", new DisappearAnimation( "Monster_2_Death", 
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL ) );
		
		/***********************************城堡相关动画***************************************/
		map_ani.put( "Castle_Death", new DisappearAnimation( "Castle_Death",
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL));
		map_ani.put( "Castle_e_Death", new DisappearAnimation( "Castle_e_Death",
				UIDefaultData.DEATH_ANIMATION_FRAME, 
				UIDefaultData.DEATH_ANIMATION_INTERVAL));
		
		/*************************************技能动画*****************************************/
		map_ani.put( "hero_1_1", new DisposableAnimation( "hero_1_1", 10 ,100 ) );
		map_ani.put( "hero_1_2", new DisposableAnimation( "hero_1_2", 11, 100 ) );
		map_ani.put( "hero_2_1", new DisposableAnimation( "hero_2_1", 10, 100 ) );
		map_ani.put( "hero_2_2", new DisposableAnimation( "hero_2_2", 12, 100 ) );
		map_ani.put( "hero_3_1", new DisposableAnimation( "hero_3_1", 9, 100 ) );
		map_ani.put( "hero_3_2", new DisposableAnimation( "hero_3_2", 8, 100 ) );
	}
	
	public MyAnimation getAnimation( String name ){
		return map_ani.get( name );
	}
	
	public void addAnimation( MyAnimation ani ){
		map_ani.put( ani.getName(), ani );
	}
	
	public void deleteAnimation( String name ){
		map_ani.remove( name );
	}
	
}
