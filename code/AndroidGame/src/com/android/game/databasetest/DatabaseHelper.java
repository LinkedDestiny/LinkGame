package com.android.game.databasetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.android.game.ability.AbilityScore;
import com.android.game.ability.DefaultAbilityScore;
import com.android.game.constant.Constant;
import com.android.game.skill.DefaultHeroSkill;
import com.android.game.skill.DefaultSkillMode;
import com.android.game.skill.DefaultSoilderSkill;
import com.android.game.skill.HeroSkill;
import com.android.game.skill.SkillMode;
import com.android.game.skill.SoilderSkill;

import android.content.Context;
import android.database.Cursor;

/**
 * 
 * @author 星陨
 *
 * @功能 数据库帮助类，用于数据库数据交互
 */
public class DatabaseHelper extends DBManager{

	public DatabaseHelper(Context context) {
		super(context);
		this.openDatabase();
		this.closeDatabase();
	}
	
	/**
	 * @function get the 
	 * @param scores
	 */
	public void getAbilityScore( Map<String , AbilityScore> scores , String name ){
		String sql = "select * from soilder where name='" + name +"'";
		Cursor cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		scores.put( Constant.ABILITY_HP.toString() , new DefaultAbilityScore( Constant.ABILITY_HP , cursor.getInt(1) , name ));
		scores.put( Constant.ABILITY_ATTACK.toString() , new DefaultAbilityScore( Constant.ABILITY_ATTACK , cursor.getInt(2) , name ));
		scores.put( Constant.ABILITY_DEFENCE.toString() , new DefaultAbilityScore( Constant.ABILITY_DEFENCE ,cursor.getInt(3) , name ));
		scores.put( Constant.ABILITY_DEXTERITY.toString() , new DefaultAbilityScore( Constant.ABILITY_DEXTERITY ,cursor.getInt(4) , name ));
		scores.put( Constant.ABILITY_SPEED.toString() , new DefaultAbilityScore( Constant.ABILITY_SPEED , cursor.getInt(5) , name ));
		scores.put( Constant.ABILITY_RANGE.toString() , new DefaultAbilityScore( Constant.ABILITY_RANGE , (int)( cursor.getInt(6) ) , name ));
		cursor.close();
	}
	
	public void getHeroSkill( String hero_1 , String hero_2 , Map<String,HeroSkill> heroskill ){
		String sql = "select * from heroskill where belong='" + hero_1 +"'";
		Cursor cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		HeroSkill skill_1_1 = new DefaultHeroSkill( hero_1+"_1" , hero_1 , cursor.getInt(2),
				cursor.getInt(3),cursor.getInt(4),cursor.getInt(5));
		cursor.moveToNext();
		HeroSkill skill_1_2 = new DefaultHeroSkill( hero_1+"_2" , hero_1 , cursor.getInt(2),
				cursor.getInt(3),cursor.getInt(4),cursor.getInt(5));
		cursor.close();
		sql = "select * from heroskill where belong='" + hero_2 +"'";
		cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		HeroSkill skill_2_1 = new DefaultHeroSkill( hero_2+"_1" , hero_2 , cursor.getInt(2),
				cursor.getInt(3),cursor.getInt(4),cursor.getInt(5));
		cursor.moveToNext();
		HeroSkill skill_2_2 = new DefaultHeroSkill( hero_2+"_2" , hero_2 , cursor.getInt(2),
				cursor.getInt(3),cursor.getInt(4),cursor.getInt(5));
		heroskill.put(hero_1+"_1" , skill_1_1);
		heroskill.put(hero_1+"_2" , skill_1_2);
		heroskill.put(hero_2+"_1" , skill_2_1);
		heroskill.put(hero_2+"_2" , skill_2_2);
		cursor.close();
	}
	
	
	public List<SkillMode> getHeroSkillMode( String belong ){
		String sql = "select * from skillmode where belong='" + belong +"'";
		Cursor cursor = this.rawQuery(sql);
		List<SkillMode> modes = new ArrayList<SkillMode>();
		cursor.moveToFirst();
		System.out.println( belong + " mode size = " + cursor.getCount() );
		do{
			SkillMode mode = new DefaultSkillMode(cursor.getString(0),cursor.getString(1)
					,cursor.getFloat(2),cursor.getInt(3) , cursor.getInt(4));
			System.out.println( mode.getType() );
			modes.add(mode);
		}while( cursor.moveToNext() );
		cursor.close();
		return modes;
	}
	
	public SoilderSkill getSoilderSkill( String name ){
		String sql = "select * from soilderskill where belong='" + name +"'";
		Cursor cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		SoilderSkill skill = new DefaultSoilderSkill( name+"_skill" , name , cursor.getFloat(1), 
				cursor.getFloat(2) , cursor.getInt(4) , 
				( cursor.getInt(5) == 1 ) ? true : false, cursor.getInt(3) );
		cursor.close();
		return skill;
	}
	
	public void getTimerShaft( List<Integer> timeshaft , int level ){
		String sql = "select * from timershaft where level ='" + level +"'";
		Cursor cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		for( int i = 1 ; i < 9 ; i ++ )
			timeshaft.add( cursor.getInt(i) );
		cursor.close();
	}

	
	public void updateSoilderAbility( String name , int level ){
		if( level == 6 )
			return ; 
		String sql = "select * from soilder where name='" + name +"'";
		Cursor cursor = this.rawQuery(sql);
		cursor.moveToFirst();
		int[] temp = new int[6];
		for( int i = 0 ; i < 6 ; i ++ )
			temp[i] = cursor.getInt(i + 1);
		cursor.close();
		String[] update = new String[6];
		update[0] = "UPDATE soilder SET Ability_HP = " + temp[0] * 1.2 +" WHERE name = '" + name + "'";
		update[1] = "UPDATE soilder SET Ability_Attack = " + temp[1] * 1.2 +" WHERE name = '" + name + "'";
		update[2] = "UPDATE soilder SET Ability_Defence = " + temp[2] * 1.2 +" WHERE name = '" + name + "'";
		update[3] = "UPDATE soilder SET Ability_Dexterity = " + temp[3] * 1.2 +" WHERE name = '" + name + "'";
		update[4] = "UPDATE soilder SET Ability_Speed = " + temp[4] * 1.2 +" WHERE name = '" + name + "'";
		update[5] = "UPDATE soilder SET Ability_Range = " + temp[5] * 1.2 +" WHERE name = '" + name + "'";
		for( int i = 0 ; i  < 6 ; i ++ )
			this.execSQL(update[i]);
		if( name == "Archer" ){
			String sql_1 = "UPDATE soilder SET Ability_HP = " + temp[1] * 1.2 +" WHERE name = 'Arrow'";
			this.execSQL( sql_1 );
		}
		String sql_1 = "UPDATE level SET level = " + level +" WHERE name = '" + name + "'";
		this.execSQL(sql_1);
	}
	
	public void getSoilderLevel( Map<String , Integer> soilder_level ){
		soilder_level.clear();
		String sql = "select * from level";
		Cursor cursor = rawQuery(sql);
		if( cursor.moveToFirst() ){
			do{
				soilder_level.put( cursor.getString(0) , cursor.getInt(1) );
			}while( cursor.moveToNext() );
		}
		cursor.close();
	}
}
