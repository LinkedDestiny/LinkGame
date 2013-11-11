package com.android.game.skill;

import java.util.Collection;
import java.util.Iterator;
import com.android.game.constant.DefaultDataPool;
import com.android.game.item.Soilder;
import com.android.game.modifier.DefaultModifierListener;
import com.android.game.modifier.ModifierListener;
import com.android.game.modifier.ModifierObject;
import com.android.game.time.Timer;

/**
 * 
 * @author 星陨
 *
 * @功能 英雄技能实体类
 */
public class DefaultHeroSkill implements HeroSkill{

	private String name;
	private String belong;
	private int CDtime;
	private int type;
	private int range;
	private int modeList;//长度代表模块数量
	private int targetType;
	private ModifierListener listener;
	
	
	public DefaultHeroSkill( String name , String belong ,int CDtime , int type , int range , int modeList ){
		this.name = name;
		this.belong = belong;
		this.CDtime = CDtime;
		this.type = type;
		this.range = range;
		this.modeList = modeList;
		this.listener = new DefaultModifierListener( CDtime , 1 );
	}
	
	public String getName() {
		return name;
	}

	public String getBelong() {
		return belong;
	}

	public int getType() {
		return type;
	}

	public void takeAction(Collection<Soilder> target) {
		if( target.isEmpty() ){
			System.out.println("empty");
			return;
		}
		for( int i = 0 ; i < modeList ; i ++ ){
			SkillMode mode = DefaultDataPool.getSkillMode( name , i );
			System.out.println( "SkillMode type = " + mode.getType() );
			ModifierObject modifier = mode.getModifier();
			Iterator<Soilder> iterator = target.iterator();
			while( iterator.hasNext() ){
				Soilder soilder = iterator.next();
				System.out.println( (soilder == null ) + " " + (mode == null) );
				soilder.getAbilityScore( mode.getType() ).addModifierObject(modifier);
			}
		}
		listener.start(Timer.getNowTime());
	}

	public int getCDtime() {
		return CDtime;
	}

	public int getRange() {
		return range;
	}
	
	public boolean onCDListener(long nowTime) {
		if( type == 2 )
			return listener.onModify(nowTime);
		else
			return true;
	}

	public int getTargetType() {
		targetType = DefaultDataPool.SKILL_MODE.get(name).get(0).getTarget();
		return targetType;
	}

}
