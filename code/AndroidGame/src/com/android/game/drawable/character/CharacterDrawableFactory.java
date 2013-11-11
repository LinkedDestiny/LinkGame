package com.android.game.drawable.character;

public class CharacterDrawableFactory {

	public static CharacterDrawable createCharacterDrawable( String name ){
		CharacterDrawable character;
		if( name.startsWith( "Castle" ) ){
			if( name == "Castle" )
				character = new CastleDrawable( name, 0, 640 );
			else
				character = new CastleDrawable( name, 2470, 640 );
		}
		else
			character = new DefaultCharacterDrawable( name );
		return character;
	}
	
}
