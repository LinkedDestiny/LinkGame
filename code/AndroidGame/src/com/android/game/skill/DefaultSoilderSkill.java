package com.android.game.skill;

/**
 * 
 * @author 星陨
 *
 * @功能 士兵技能实体类
 */
public class DefaultSoilderSkill implements SoilderSkill{

	private String name;
	private String belong;
	private float probability;
	private float value;
	private int type;
	private int time;
	
	private boolean usable = false;
	
	public DefaultSoilderSkill( String name , String belong , float probability , float value , int type , boolean usable , int time ){
		this.name = name;
		this.belong = belong;
		this.probability = probability;
		this.value = value;
		this.type = type;
		this.usable = usable;
		this.time = time;
	}
	
	public float useSkill( int type ) {
		if( this.type != type )
			return 0;
		//概率判定
		float result = (float)Math.random();
		if( probability < result ){
			return 0;
		}
		System.out.println( belong + " use the skill which type is " + type );
		return value;
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

	public boolean usable() {
		return usable;
	}

	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	public int getTime() {
		return time;
	}

}
