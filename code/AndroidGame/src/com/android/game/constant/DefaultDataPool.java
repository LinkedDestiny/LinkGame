
package com.android.game.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.game.ability.AbilityScore;
import com.android.game.ability.AbilityScoreContainer;
import com.android.game.ability.DefaultAbilityScoreContainer;
import com.android.game.databasetest.DatabaseHelper;
import com.android.game.item.DefaultHero;
import com.android.game.item.Hero;
import com.android.game.skill.HeroSkill;
import com.android.game.skill.SkillMode;
import com.android.game.skill.SoilderSkill;


import android.content.Context;

/**
 * 
 * @author star
 *
 * @功能 store the all default data
 */
public class DefaultDataPool {
	public static DatabaseHelper helper;
	
	public static final Map<String , AbilityScoreContainer> SOILDER_ABILITY = new HashMap<String , AbilityScoreContainer>();

	public static Map<String,HeroSkill> HERO_SKILL = new HashMap< String , HeroSkill >(); 
	public static Map<String , List<SkillMode>> SKILL_MODE = new HashMap<String , List<SkillMode>>();
	
	
	public static Map<String , SoilderSkill> SOILDER_SKILL = new HashMap<String , SoilderSkill>();
	
	
	public static Map<String , Integer> SOILDER_LEVEL = new HashMap<String , Integer>();
	
	public static List<String> HERO_LIST = new ArrayList<String>();
	/**
	 * the timershaft
	 */
	public static List<Integer> TIMESHAFT = new ArrayList<Integer>();
	
	public DefaultDataPool( Context context ){
		helper = new DatabaseHelper( context );
	}
	
	
	
	/**
	 * 根据数据库交互对象获取对应的能力值容器
	 * @param dao
	 * 	数据库交互对象
	 * @return
	 * 	AbilityScoreContainer
	 */
	public static AbilityScoreContainer getScores( String name ){
		Map<String , AbilityScore> scores = new HashMap<String , AbilityScore>();
		helper.getAbilityScore(scores, name);
		return new DefaultAbilityScoreContainer( scores );
	}
	
	/**
	 * @功能 从数据库中加载士兵信息
	 */
	public static void loadSoilderAbility(){
		SOILDER_ABILITY.put("Archer", getScores("Archer"));
		SOILDER_ABILITY.put("HeavyRider", getScores("HeavyRider"));
		SOILDER_ABILITY.put("Footman", getScores("Footman"));
		SOILDER_ABILITY.put("Shield", getScores("Shield"));
		SOILDER_ABILITY.put("Monster_1", getScores("Monster_1"));
		SOILDER_ABILITY.put("Monster_2", getScores("Monster_2"));
		SOILDER_ABILITY.put("Castle", getScores("Castle"));
		SOILDER_ABILITY.put("Castle_e", getScores("Castle_e"));
		SOILDER_ABILITY.put("Arrow", getScores("Arrow"));
	}
	
	/**
	 * @功能 加载英雄技能模块
	 * @param hero_1
	 * 第一个英雄的名称
	 * @param hero_2
	 * 第二个英雄的名称
	 */
	public static void loadSkill( String hero_1 , String hero_2 ){
		helper.getHeroSkill(hero_1, hero_2, HERO_SKILL);
		SKILL_MODE.put(hero_1 +"_1" , helper.getHeroSkillMode(hero_1 +"_1"));
		SKILL_MODE.put(hero_1 +"_2" , helper.getHeroSkillMode(hero_1 +"_2"));
		SKILL_MODE.put(hero_2 +"_1" , helper.getHeroSkillMode(hero_2 +"_1"));
		SKILL_MODE.put(hero_2 +"_2" , helper.getHeroSkillMode(hero_2 +"_2"));
	}
	
	/**
	 * @功能 加载士兵的技能
	 */
	public static void loadSoilderSkill(){
		SOILDER_SKILL.put("HeavyRider", helper.getSoilderSkill("HeavyRider"));
		SOILDER_SKILL.put("Archer", helper.getSoilderSkill("Archer"));
		SOILDER_SKILL.put("Footman", helper.getSoilderSkill("Footman"));
		SOILDER_SKILL.put("Shield", helper.getSoilderSkill("Shield"));
	}
	
	public static void loadTimerShaft( int level ){
		helper.getTimerShaft(TIMESHAFT, level);
	}
	
	/**
	 * 根据name获取能力容器
	 * @param name
	 * 人物名称
	 * @return
	 * AbilityScoreContainer
	 */
	public static AbilityScoreContainer getAbilityContainer( String name ){
		return SOILDER_ABILITY.get(name);
	}
	
	
	public static SkillMode getSkillMode( String name , int id ){
		SkillMode mode = (SkillMode)SKILL_MODE.get( name ).get(id);
		return mode;
	}
	
	public static SoilderSkill getSoilderSkill( String name ){
		return SOILDER_SKILL.get(name);
	}
	
	public static Hero getHero( String name ){
		return new DefaultHero( name , 0 , 10 , 10 , 1 , 4 );
	}
	
	
	/****************************************************/
	
	public static void updateSoilderAbility( String name , int level ){
		helper.openDatabase();
		helper.updateSoilderAbility(name , level);
		loadSoilderLevel();
		helper.closeDatabase();
	}
	
	public static void loadSoilderLevel(){
		helper.openDatabase();
		helper.getSoilderLevel(SOILDER_LEVEL);
		helper.closeDatabase();
	}
}
