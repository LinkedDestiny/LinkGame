package com.android.game.drawable.character;

import java.util.HashMap;
import java.util.Map;

import com.android.game.drawable.Drawable;
import com.android.game.drawable.DrawableContainer;

public class CharacterDrawableContainer implements DrawableContainer{

	private Map<String, CharacterDrawable> characters;
	
	public CharacterDrawableContainer(){
		characters = new HashMap<String, CharacterDrawable>();
	}

	public void initDrawableContainer() {
		characters.put( "Footman", new DefaultCharacterDrawable( "Footman" ) );
		characters.put( "Archer", new DefaultCharacterDrawable( "Archer" ) );
		characters.put( "Shield", new DefaultCharacterDrawable( "Shield" ) );
		characters.put( "HeavyRider", new DefaultCharacterDrawable( "HeavyRider" ) );
		characters.put( "Castle", new CastleDrawable( "Castle", 0, 640 ) );
		characters.put( "Castle_e", new CastleDrawable( "Castle_e", 2470, 640 ) );
		characters.put( "Monster_1", new DefaultCharacterDrawable( "Monster_1" ) );
		characters.put( "Monster_2", new DefaultCharacterDrawable( "Monster_2" ) );
	}
	
	public int size(){
		return characters.size();
	}

	public Drawable getDrawable(String name) {
		return characters.get(name);
	}

	public void deleteDrawable(String name) {
		characters.remove(name);
	}

	public void clear() {
		characters.clear();		
	}

}
