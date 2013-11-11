package com.android.game.ability;

/**
 * 
 * @author 星陨
 *
 * @功能 预定义能力
 */
public class DefaultAbility implements Ability{

	private String name;
	
	public DefaultAbility( String name ){
		this.name = name;
	}
	
	public DefaultAbility( Ability ability ){
		this.name = ability.getName();
	}
	public String toString(){
		return name;
	}
	public String getName() {
		return name;
	}

}
