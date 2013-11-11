package com.android.game.drawable.button;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.game.constant.Constant;
import com.android.game.constant.DefaultDataPool;
import com.android.game.drawable.Drawable;
import com.android.game.item.Location;

public class ButtonDrawableContainer{
	
	private Map<String, ButtonDrawable> buttons;
	
	public ButtonDrawableContainer(){
		buttons = new HashMap<String, ButtonDrawable>();
	}
	
	public void initHelpViewButton(){
		if( !buttons.isEmpty() ){
			buttons.clear();
			Constant.skill_button.clear();
		}
		buttons.put( "help_return", new SimpleButtonDrawable( "help_return", 610, 555 ) );
		Constant.skill_button.add( new Location("help_return", 0, 0, ButtonDrawable.NORMAL ) );
	}
	
	public void initSoilderViewButton(){
		if( !buttons.isEmpty() ){
			buttons.clear();
			Constant.skill_button.clear();
		}
		buttons.put( "Ensure", new StandardButtonDrawable( "Ensure_BUTTON", 780, 570 ) );
		buttons.put( "Footman_levelup", new StandardButtonDrawable( "Footman_levelup_BUTTON", 86, 173 ) );
		buttons.put( "Archer_levelup", new StandardButtonDrawable( "Archer_levelup_BUTTON", 776, 287 ) );
		buttons.put( "Shield_levelup", new StandardButtonDrawable( "Shield_levelup_BUTTON", 40, 405 ) );
		buttons.put( "Rider_levelup", new StandardButtonDrawable( "Rider_levelup_BUTTON", 696, 552 ) );
		
		Constant.skill_button.add( new Location( "Footman_levelup", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Archer_levelup", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Shield_levelup", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Rider_levelup", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Ensure", 0, 0, ButtonDrawable.NORMAL ) );
	}
	
	public void initStartViewButton(){
		if( !buttons.isEmpty() ){
			buttons.clear();
			Constant.skill_button.clear();
		}
		buttons.put( "Start", new SimpleButtonDrawable( "Start_BUTTON", 702, 234 ) );
		buttons.put( "Score", new SimpleButtonDrawable( "Score_BUTTON", 702, 325 ) );
		buttons.put( "Help", new SimpleButtonDrawable( "Help_BUTTON", 702, 416 ) );
		buttons.put( "Exit", new SimpleButtonDrawable( "Exit_BUTTON", 702, 507 ) );
		Constant.skill_button.add( new Location( "Start", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Score", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Help", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Exit", 0, 0, ButtonDrawable.NORMAL ) );
	}

	public void initHeroSelectViewButton(){
		if( !buttons.isEmpty() ){
			buttons.clear();
			Constant.skill_button.clear();
		}
		
		buttons.put("hero_select_ensure", new StandardButtonDrawable( "hero_select_ensure", 750 , 565 ) );
		
		buttons.put("hero_1", new StandardButtonDrawable( "hero_1_select", 170 , 126 ) );
		buttons.put("hero_2", new StandardButtonDrawable( "hero_2_select", 170 , 281 ) );
		buttons.put("hero_3", new StandardButtonDrawable( "hero_3_select", 170 , 436 ) );
		buttons.put( "select", new StandardButtonDrawable( "select", 782, 493 ) );
		buttons.put( "cansel", new StandardButtonDrawable( "cansel", 782, 493 ) );
		
		Constant.skill_button.add( new Location( "hero_select_ensure", 0, 0, ButtonDrawable.NORMAL ) );	
		Constant.skill_button.add( new Location( "hero_1", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "hero_2", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "hero_3", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "select", 0, 0, ButtonDrawable.NORMAL ) );
	}
	
	public void initBatleDrawableContainer( List<String> hero ) {
		if( !buttons.isEmpty() ){
			buttons.clear();
			Constant.skill_button.clear();
		}
		buttons.put( "Menu", new SimpleButtonDrawable( "Menu_BUTTON", 884, 19 ) );
		buttons.put( hero.get(0) + "_1", createButtonDrawable( hero.get(0) + "_1_BUTTON", 868, 101, DefaultDataPool.HERO_SKILL.get(hero.get(0) + "_1").getCDtime() ) );
		buttons.put( hero.get(0) + "_2", createButtonDrawable( hero.get(0) + "_2_BUTTON", 868, 187, DefaultDataPool.HERO_SKILL.get(hero.get(0) + "_2").getCDtime() ) );
		buttons.put( hero.get(1) + "_1", createButtonDrawable( hero.get(1) + "_1_BUTTON", 868, 275, DefaultDataPool.HERO_SKILL.get(hero.get(1) + "_1").getCDtime() ) );
		buttons.put( hero.get(1) + "_2", createButtonDrawable( hero.get(1) + "_2_BUTTON", 868, 362, DefaultDataPool.HERO_SKILL.get(hero.get(1) + "_2").getCDtime() ) );
		initCharacterButton();
		Constant.skill_button.add( new Location( hero.get(0) + "_1", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( hero.get(0) + "_2", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( hero.get(1) + "_1", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( hero.get(1) + "_2", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Menu", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Footman", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Archer", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "Shield", 0, 0, ButtonDrawable.NORMAL ) );
		Constant.skill_button.add( new Location( "HeavyRider", 0, 0, ButtonDrawable.NORMAL ) );
	}
	
	public ButtonDrawable createButtonDrawable( String name, int cx, int cy, int cold ){
		ButtonDrawable button;
		if( name.startsWith("hero_1_1" ) || name.startsWith("hero_1_2") || name.startsWith("hero_3_2") ){
			button = new SolderButtonDrawable( name, cx, cy, cold );
			System.out.println( "create soilder button " + name );
		}
		else
			button = new DraggableButtonDrawable( name, cx, cy, cold );
		return button;
	}
	
	public void initCharacterButton(){
		buttons.put( "Footman", new SolderButtonDrawable( "Footman_BUTTON", 295, 549, 2000 ) );
		buttons.put( "Archer", new SolderButtonDrawable( "Archer_BUTTON", 387, 549, 2000 ) );
		buttons.put( "Shield", new SolderButtonDrawable( "Shield_BUTTON", 479, 549, 2000 ) );
		buttons.put( "HeavyRider", new SolderButtonDrawable( "HeavyRider_BUTTON", 571, 549, 2000 ) );
	}
	
	public int size(){
		return buttons.size();
	}
	
	public Drawable getDrawable(String name) {
		return buttons.get(name);
	}

	public void deleteDrawable(String name) {
		buttons.remove(name);
	}

	public void clear() {
		buttons.clear();
	}

}
