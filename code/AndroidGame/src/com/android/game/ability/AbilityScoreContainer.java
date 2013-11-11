package com.android.game.ability;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author 星陨
 * 
 * @功能 定义AbilityScore的容器
 */
public interface AbilityScoreContainer {
	
	/**
	 * @功能 根据名称获取能力值
	 * @param name
	 * 	能力的名称
	 * @return
	 * 	AbilityScore
	 */
	AbilityScore getAbilityScore( String name );
	
	/**
	 * @功能 根据Ability获取能力值
	 * @param ability
	 * 	能力
	 * @return
	 * AbilityScore
	 */
	AbilityScore getAbilityScore( Ability ability );
	
	/**
	 * @功能 获取 AbilityScore 的容器
	 * @return
	 */
	Collection<AbilityScore> getAbilityScores();
	
	/**
	 * @功能 判断是否拥有某项能力
	 * @param ability
	 * 	待检验的能力
	 * @return
	 * 	是否拥有该项能力
	 */
	boolean hasAbility( Ability ability );
	
	/**
	 * @功能 获取能力值的容器
	 * @return
	 * 	Map<Ability , AbilityScore>
	 */
	Map<String , AbilityScore> getAbilityContainer();
	
	/**
	 * @功能 调用监听函数
	 * @param nowTime
	 */
	void onModify( long nowTime );
}
