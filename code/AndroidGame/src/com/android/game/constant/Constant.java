package com.android.game.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.game.ability.Ability;
import com.android.game.ability.DefaultAbility;
import com.android.game.action.ActionEffect;
import com.android.game.action.AttackEffect;
import com.android.game.action.MoveEffect;
import com.android.game.item.Location;
import com.android.game.modifier.DefaultModifierType;
import com.android.game.modifier.HighestModifierCalculator;
import com.android.game.modifier.ModifierType;
import com.android.game.modifier.StackedModifierCalculator;

public class Constant {
	
	/****************** the data for the interaction between UI and basic data*******************/
	
	//当前点击按键
	public static Location current_button = null;                   //当前点击的按键信息
	public static Location current_soilder = null;                   //当前点击的士兵按键信息

	/**
	 * @name the collection of soilders' location
	 */
	public static Map<Integer , Location> LOCATION = new HashMap<Integer , Location>();
	
	public static List<Location> soilder_list = new ArrayList<Location>();
	
	public static Map<Integer , Location> ARROW_LOCATION = new HashMap<Integer , Location>();
	public static List<Location> arrow_list = new ArrayList<Location>();
	
	/**
	 * @name the locations of hero skills' button
	 */
	public static List<Location> skill_button = new ArrayList<Location>();

	/**
	 * the location when a soilder is created
	 */
	public static int SOILDER_X = 10;
	public static int SOILDER_Y = 506;
	
	public static int ENEMY_X = 100;
	public static int ENEMY_Y = 10;	
	
	public static int CASTLE_X = 0 ;
	public static int CASTLE_Y = 0;
	
	public static int DISTANCE = 2470;
	/**
	 * state of the soilder action
	 */
	
	public static final int SOILDER_ACTION_MOVE = 0;
	public static final int SOILDER_ACTION_ATTACK = 1;
	public static final int SOILDER_ACTION_SKILL = 2;
	public static final int SOILDER_ACTION_DEATH = 3;
	public static final int SOILDER_ACTION_ATTACKOVER = 4;
	
	/***************************** end *******************************/
	
	public static int Level_money = 0;
	public static int level = 1;
	
	/**
	 * @name the collection of soilders' name
	 */
	public static final List<String> SOILDER_NAME = new ArrayList<String>();
	
	
	/**
	 * ID of the soilder
	 */
	public static int SOILDER_ID = 7;
	
	public static int ARROW_ID = 0;
	
	
	/**
	 * @name the type of modifier
	 */
	public static final Map<String , ModifierType> TYPE = new HashMap<String , ModifierType>();
	/**
	 * @name the collection of soilders' ability
	 */
	public static final Map<String , Ability> ABILITY = new HashMap<String , Ability>();
	
	static{
		SOILDER_NAME.add("Footman");
		SOILDER_NAME.add("Archer");
		SOILDER_NAME.add("Shield");
		SOILDER_NAME.add("HeavyRider");
		SOILDER_NAME.add("Monster_1");
		SOILDER_NAME.add("Monster_2");
	}
	/**
	 * ModifierType
	 */
	public static final DefaultModifierType MODIFIER_SPEED = new DefaultModifierType("Modifier_Speed" , new StackedModifierCalculator());
	public static final DefaultModifierType MODIFIER_DEFENCE = new DefaultModifierType("Modifier_Defence" , new HighestModifierCalculator());
	public static final DefaultModifierType MODIFIER_ATTACK = new DefaultModifierType("Modifier_Attack" , new HighestModifierCalculator());
	public static final DefaultModifierType MODIFIER_HP = new DefaultModifierType("Modifier_HP" , new StackedModifierCalculator());
	static{
		TYPE.put(MODIFIER_SPEED.getName(), MODIFIER_SPEED );
		TYPE.put(MODIFIER_DEFENCE.getName(), MODIFIER_DEFENCE );
		TYPE.put(MODIFIER_ATTACK.getName(), MODIFIER_ATTACK );
		TYPE.put(MODIFIER_HP.getName(), MODIFIER_HP );
	}
	/**
	 * @function get the Modifier by the name
	 * @param name
	 * name of Modifier
	 * @return
	 * ModifierType
	 */
	public static ModifierType getType( String name ){
		return ( ModifierType )TYPE.get("Modifier_" + name);
	}
	
	/**
	 * Definition of the Ability
	 */
	public static final Ability ABILITY_HP = new DefaultAbility("Ability_HP");			
	public static final Ability ABILITY_ATTACK = new DefaultAbility("Ability_Attack");			
	public static final Ability ABILITY_DEFENCE = new DefaultAbility("Ability_Defence");		
	public static final Ability ABILITY_DEXTERITY = new DefaultAbility("Ability_Dexterity");	
	public static final Ability ABILITY_SPEED = new DefaultAbility("Ability_Speed");			
	public static final Ability ABILITY_RANGE = new DefaultAbility("Ability_Range");			
	static{
		ABILITY.put( ABILITY_HP.toString() , ABILITY_HP );
		ABILITY.put( ABILITY_ATTACK.toString() , ABILITY_ATTACK );
		ABILITY.put( ABILITY_DEFENCE.toString() , ABILITY_DEFENCE );
		ABILITY.put( ABILITY_DEXTERITY.toString() , ABILITY_DEXTERITY );
		ABILITY.put( ABILITY_SPEED.toString() , ABILITY_SPEED );
		ABILITY.put( ABILITY_RANGE.toString() , ABILITY_RANGE );
	}
	/**
	 * @function get the Ability by the name
	 * @param name
	 * name of the Ability
	 * @return
	 * Ability
	 */
	public static Ability getAbility( String name ){
		return ( Ability )ABILITY.get(name);
	}
	
	public static String getSoilderName( int index ){
		return SOILDER_NAME.get(index);
	}
	
	/**
	 * Definition of the DefaultAction
	 */
	public static final ActionEffect ATTACK_ACTION = new AttackEffect();
	public static final ActionEffect MOVE_ACTION = new MoveEffect();
	
	
	/**
	 * type of the soilder skill
	 */
	public static final int SOILDER_SKILL_ATTACK = 1;
	public static final int SOILDER_SKILL_IMPALE = 2;
	public static final int SOILDER_SKILL_DEFENCE = 3;
	public static final int SOILDER_SKILL_MOVE = 4;
	
	public static void initlizeGame(){
		soilder_list.clear();
		arrow_list.clear();
		LOCATION.clear();
		ARROW_LOCATION.clear();
		ARROW_ID = 0;
		SOILDER_ID = 3;
	}

}
