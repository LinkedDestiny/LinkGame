package com.android.game.ability;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class DefaultAbilityScoreContainer implements AbilityScoreContainer{
	
	
	
	private final Map<String , AbilityScore> scores;
	
	public DefaultAbilityScoreContainer( Map< String , AbilityScore > abilityScoreContainer){
		this.scores = new HashMap< String , AbilityScore >( abilityScoreContainer );
	}
	public DefaultAbilityScoreContainer( AbilityScoreContainer container ){
		this.scores = new HashMap< String , AbilityScore >( );
		Iterator<AbilityScore> iterator = container.getAbilityScores().iterator();
		while( iterator.hasNext() ){
			AbilityScore temp = (AbilityScore)iterator.next();
			AbilityScore score = new DefaultAbilityScore(temp);
			scores.put( temp.getAbility().getName() , score );
		}
	}
	
	public AbilityScore getAbilityScore(String name) {
		return (AbilityScore)scores.get(name);
	}

	public AbilityScore getAbilityScore(Ability ability) {
		return (AbilityScore)scores.get(ability.getName());
	}

	public Collection<AbilityScore> getAbilityScores() {
		return scores.values();
	}

	public boolean hasAbility(Ability ability) {
		AbilityScore score = scores.get(ability.getName());
		if( score == null )
			return false;
		else
			return true;
	}

	public Map<String, AbilityScore> getAbilityContainer() {
		return scores;
	}

	public void onModify(long nowTime) {
		Iterator<AbilityScore> iterator = scores.values().iterator();
		while( iterator.hasNext() ){
			AbilityScore score = (AbilityScore)iterator.next();
			if( score.getAbility().getName() != "Ability_HP" ){
				score.onModify(nowTime);
			}
		}
	}
	
}
