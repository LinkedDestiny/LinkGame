package com.android.game.bitmap;

import java.util.HashMap;
import java.util.Map;

import com.android.game.R;
import com.android.game.constant.UIDefaultData;

/*
MyBitmapContainer基本位图容器:
以HashMap形式存储大量图片，每张图片对应一个String（Key值），使用时根据String进行匹配
*/

public class MyBitmapContainer {
	
	private Map<String, MyBitmap> list_bmp;
	
	public MyBitmapContainer(){
		list_bmp = new HashMap<String, MyBitmap>();
	}
	
	public void initBitmapContainer(){
		 list_bmp.put( "BACKGROUND",  new HugeBitmap( R.drawable.background_1 ) );
		 list_bmp.put( "Castle", new RelativeBitmap( R.drawable.castle ) );
		 list_bmp.put( "Castle_e", new RelativeBitmap( R.drawable.castle_e ) );
		 list_bmp.put( "Castle_Death", new TransparentRelativeBitmap( R.drawable.castle ) );
		 list_bmp.put( "Castle_e_Death", new TransparentRelativeBitmap( R.drawable.castle_e ) );
		 list_bmp.put( "OUR_HEALTH", new AbsoluteBitmap( R.drawable.our_health ) );
		 list_bmp.put( "ENEMY_HEALTH", new AbsoluteBitmap( R.drawable.enemy_health ) );
		 list_bmp.put( "POINT_NUM", new AbsoluteBitmap( R.drawable.point_num ) );
		 list_bmp.put( "MONEY", new AbsoluteBitmap( R.drawable.money ) );
		 list_bmp.put( "Arrow", new RelativeBitmap( R.drawable.arrow ) );
		 list_bmp.put( "hp", new AbsoluteBitmap( R.drawable.health ) );
		 list_bmp.put( "game_win", new AbsoluteBitmap( R.drawable.game_win ) );
		 list_bmp.put( "game_over", new AbsoluteBitmap( R.drawable.game_over ) );
		 //小地图相关图片
		 list_bmp.put( "MINIMAP", new TransparentAbsoluteBitmap( R.drawable.minimap ) );
		 list_bmp.put( "OUR_LOCATION", new AbsoluteBitmap( R.drawable.our_location ) );
		 list_bmp.put( "ENEMY_LOCATION", new AbsoluteBitmap( R.drawable.enemy_location ) );
		 list_bmp.put( "our_hp", new AbsoluteBitmap( R.drawable.our_hp ) );
		 list_bmp.put( "enemy_hp", new AbsoluteBitmap( R.drawable.enemy_hp ) );
		 if( UIDefaultData.i_x_screen / (float)UIDefaultData.i_y_screen > 0.75 )
			 list_bmp.put( "CURRENT_WINDOW", new AbsoluteBitmap( R.drawable.current_window_16 ) );
		 else
			 list_bmp.put( "CURRENT_WINDOW", new AbsoluteBitmap( R.drawable.current_window ) );
		 
		 /******************************************图标******************************************/
		 //基础技能图标
		 list_bmp.put( "BUTTON_LOCKED",  new AbsoluteBitmap( R.drawable.button_locked ) );
		 list_bmp.put( "BUTTON_CLICKED", new AbsoluteBitmap( R.drawable.button_locked ) );
		 list_bmp.put( "BUTTON_MASK", new TransparentAbsoluteBitmap( R.drawable.button_locked ) );
		 list_bmp.put( "Menu_BUTTON", new AbsoluteBitmap( R.drawable.menu_button_normal ) );
		 //英雄图标及英雄技能图标
		 list_bmp.put( "hero_1", new AbsoluteBitmap( R.drawable.hero_1 ) );
		 list_bmp.put( "hero_2", new AbsoluteBitmap( R.drawable.hero_2 ) );
		 list_bmp.put( "hero_3", new AbsoluteBitmap( R.drawable.hero_3 ) );
		 list_bmp.put( "hero_1_1_BUTTON", new AbsoluteBitmap( R.drawable.hero_1_1 ) );
		 list_bmp.put( "hero_1_2_BUTTON", new AbsoluteBitmap( R.drawable.hero_1_2 ) );
		 list_bmp.put( "hero_2_1_BUTTON", new AbsoluteBitmap( R.drawable.hero_2_1 ) );
		 list_bmp.put( "hero_2_2_BUTTON", new AbsoluteBitmap( R.drawable.hero_2_2 ) );
		 list_bmp.put( "hero_3_1_BUTTON", new AbsoluteBitmap( R.drawable.hero_3_1 ) );
		 list_bmp.put( "hero_3_2_BUTTON", new AbsoluteBitmap( R.drawable.hero_3_2 ) );
		 //士兵生成按键图标
		 list_bmp.put( "Footman_BUTTON", new AbsoluteBitmap( R.drawable.footman_button ) );
		 list_bmp.put( "Archer_BUTTON", new AbsoluteBitmap( R.drawable.archer_button ) );
		 list_bmp.put( "Lancer_BUTTON", new AbsoluteBitmap( R.drawable.lancer_button ) );
		 list_bmp.put( "HeavyRider_BUTTON", new AbsoluteBitmap( R.drawable.heavy_rider_button ) );
		 list_bmp.put( "LightRider_BUTTON", new AbsoluteBitmap( R.drawable.lightrider_button ) );
		 list_bmp.put( "Shield_BUTTON", new AbsoluteBitmap( R.drawable.shield_button ) );
		 
		 /**************************************刀兵相关图片*******************************************/
		 //移动
		 list_bmp.put( "Footman_MOVE_1", new RelativeBitmap( R.drawable.footman_move_1 ) );
		 list_bmp.put( "Footman_MOVE_2", new RelativeBitmap( R.drawable.footman_move_2 ) );
		 list_bmp.put( "Footman_MOVE_3", new RelativeBitmap( R.drawable.footman_move_3 ) );
		 list_bmp.put( "Footman_MOVE_4", new RelativeBitmap( R.drawable.footman_move_4 ) );
		 //攻击
		 list_bmp.put( "Footman_ATTACK_1", new RelativeBitmap( R.drawable.footman_attack_1 ) );
		 list_bmp.put( "Footman_ATTACK_2", new RelativeBitmap( R.drawable.footman_attack_2 ) );
		 //技能
		 list_bmp.put( "Footman_SKILL_1", new RelativeBitmap( R.drawable.footman_move_2 ) );
		 list_bmp.put( "Footman_SKILL_2", new RelativeBitmap( R.drawable.footman_move_2 ) );
		 list_bmp.put( "Footman_SKILL_3", new RelativeBitmap( R.drawable.footman_move_2 ) );
		 //死亡
		 list_bmp.put( "Footman_Death", new TransparentRelativeBitmap( R.drawable.footman_move_1 ) );
		 
		 /*************************************弓箭手相关图片******************************************/
		 //移动
		 list_bmp.put( "Archer_MOVE_1", new RelativeBitmap( R.drawable.archer_move_1 ) );
		 list_bmp.put( "Archer_MOVE_2", new RelativeBitmap( R.drawable.archer_move_2 ) );
		 list_bmp.put( "Archer_MOVE_3", new RelativeBitmap( R.drawable.archer_move_3 ) );
		 list_bmp.put( "Archer_MOVE_4", new RelativeBitmap( R.drawable.archer_move_4 ) );
		 //攻击
		 list_bmp.put( "Archer_ATTACK_1", new RelativeBitmap( R.drawable.archer_attack_1 ) );
		 list_bmp.put( "Archer_ATTACK_2", new RelativeBitmap( R.drawable.archer_attack_2 ) );
		 list_bmp.put( "Archer_ATTACK_3", new RelativeBitmap( R.drawable.archer_attack_3 ) );
		 //技能
		 list_bmp.put( "Archer_SKILL_1", new RelativeBitmap( R.drawable.archer_move_2 ) );
		 list_bmp.put( "Archer_SKILL_2", new RelativeBitmap( R.drawable.archer_move_2 ) );
		 list_bmp.put( "Archer_SKILL_3", new RelativeBitmap( R.drawable.archer_move_2 ) );
		//死亡
		 list_bmp.put( "Archer_Death", new TransparentRelativeBitmap( R.drawable.archer_move_1 ) );
		 
		 /*************************************盾兵相关图片*****************************************/
		 //移动
		 list_bmp.put( "Shield_MOVE_1", new RelativeBitmap( R.drawable.shield_move_1 ) );
		 list_bmp.put( "Shield_MOVE_2", new RelativeBitmap( R.drawable.shield_move_2 ) );
		 list_bmp.put( "Shield_MOVE_3", new RelativeBitmap( R.drawable.shield_move_3 ) );
		 list_bmp.put( "Shield_MOVE_4", new RelativeBitmap( R.drawable.shield_move_4 ) );
		 //攻击
		 list_bmp.put( "Shield_ATTACK_1", new RelativeBitmap( R.drawable.shield_attack_1 ) );
		 list_bmp.put( "Shield_ATTACK_2", new RelativeBitmap( R.drawable.shield_attack_2 ) );
		 //技能
		 list_bmp.put( "Shield_SKILL_1", new RelativeBitmap( R.drawable.shield_move_2 ) );
		 list_bmp.put( "Shield_SKILL_2", new RelativeBitmap( R.drawable.shield_move_2 ) );
		 list_bmp.put( "Shield_SKILL_3", new RelativeBitmap( R.drawable.shield_move_2 ) );
		//死亡
		 list_bmp.put( "Shield_Death", new TransparentRelativeBitmap( R.drawable.shield_move_1 ) );
		 
		 /*************************************重骑兵相关图片***************************************/
		 //移动
		 list_bmp.put( "HeavyRider_MOVE_1", new RelativeBitmap( R.drawable.heavy_rider_move_1 ) );
		 list_bmp.put( "HeavyRider_MOVE_2", new RelativeBitmap( R.drawable.heavy_rider_move_2 ) );
		 list_bmp.put( "HeavyRider_MOVE_3", new RelativeBitmap( R.drawable.heavy_rider_move_3 ) );
		 list_bmp.put( "HeavyRider_MOVE_4", new RelativeBitmap( R.drawable.heavy_rider_move_4 ) );
		 //攻击
		 list_bmp.put( "HeavyRider_ATTACK_1", new RelativeBitmap( R.drawable.heavyrider_attack_1 ) );
		 list_bmp.put( "HeavyRider_ATTACK_2", new RelativeBitmap( R.drawable.heavyrider_attack_2 ) );
		 //技能
		 list_bmp.put( "HeavyRider_SKILL_1", new RelativeBitmap( R.drawable.heavy_rider_move_2 ) );
		 list_bmp.put( "HeavyRider_SKILL_2", new RelativeBitmap( R.drawable.heavy_rider_move_2 ) );
		 list_bmp.put( "HeavyRider_SKILL_3", new RelativeBitmap( R.drawable.heavy_rider_move_2 ) );
		//死亡
		 list_bmp.put( "HeavyRider_Death", new TransparentRelativeBitmap( R.drawable.heavy_rider_move_1 ) );
		 
		 /*************************************怪兽一相关图片***************************************/
		 //移动
		 list_bmp.put( "Monster_1_MOVE_1", new RelativeBitmap( R.drawable.monster_1_move_1 ) );
		 list_bmp.put( "Monster_1_MOVE_2", new RelativeBitmap( R.drawable.monster_1_move_2 ) );
		 list_bmp.put( "Monster_1_MOVE_3", new RelativeBitmap( R.drawable.monster_1_move_3 ) );
		 list_bmp.put( "Monster_1_MOVE_4", new RelativeBitmap( R.drawable.monster_1_move_4 ) );
		 //攻击
		 list_bmp.put( "Monster_1_ATTACK_1", new RelativeBitmap( R.drawable.monster_1_attack_1 ) );
		 list_bmp.put( "Monster_1_ATTACK_2", new RelativeBitmap( R.drawable.monster_1_attack_2 ) );
		 //技能
		 list_bmp.put( "Monster_1_MOVE_1", new RelativeBitmap( R.drawable.monster_1_move_2 ) );
		 list_bmp.put( "Monster_1_MOVE_2", new RelativeBitmap( R.drawable.monster_1_move_2 ) );
		//死亡
		 list_bmp.put( "Monster_1_Death", new TransparentRelativeBitmap( R.drawable.monster_1_move_1 ) );
		 
		 /*************************************怪兽一相关图片***************************************/
		 //移动
		 list_bmp.put( "Monster_2_MOVE_1", new RelativeBitmap( R.drawable.monster_2_move_1 ) );
		 list_bmp.put( "Monster_2_MOVE_2", new RelativeBitmap( R.drawable.monster_2_move_2 ) );
		 list_bmp.put( "Monster_2_MOVE_3", new RelativeBitmap( R.drawable.monster_2_move_3 ) );
		 list_bmp.put( "Monster_2_MOVE_4", new RelativeBitmap( R.drawable.monster_2_move_4 ) );
		 //攻击
		 list_bmp.put( "Monster_2_ATTACK_1", new RelativeBitmap( R.drawable.monster_2_attack_1 ) );
		 list_bmp.put( "Monster_2_ATTACK_2", new RelativeBitmap( R.drawable.monster_2_attack_2 ) );
		 //技能
		 list_bmp.put( "Monster_2_MOVE_1", new RelativeBitmap( R.drawable.monster_2_move_2 ) );
		 list_bmp.put( "Monster_2_MOVE_2", new RelativeBitmap( R.drawable.monster_2_move_2 ) );
		//死亡
		 list_bmp.put( "Monster_2_Death", new TransparentRelativeBitmap( R.drawable.monster_2_move_1 ) );
		 
		 /***********************************技能相关图片****************************************/
		 list_bmp.put( "hero_1_1_1", new AbsoluteBitmap( R.drawable.hero_1_1_1 ) );
		 list_bmp.put( "hero_1_1_2", new AbsoluteBitmap( R.drawable.hero_1_1_2) );
		 list_bmp.put( "hero_1_1_3", new AbsoluteBitmap( R.drawable.hero_1_1_3 ) );
		 list_bmp.put( "hero_1_1_4", new AbsoluteBitmap( R.drawable.hero_1_1_4 ) );
		 list_bmp.put( "hero_1_1_5", new AbsoluteBitmap( R.drawable.hero_1_1_5 ) );
		 list_bmp.put( "hero_1_1_6", new AbsoluteBitmap( R.drawable.hero_1_1_6 ) );
		 list_bmp.put( "hero_1_1_7", new AbsoluteBitmap( R.drawable.hero_1_1_7 ) );
		 list_bmp.put( "hero_1_1_8", new AbsoluteBitmap( R.drawable.hero_1_1_8 ) );
		 list_bmp.put( "hero_1_1_9", new AbsoluteBitmap( R.drawable.hero_1_1_9 ) );
		 list_bmp.put( "hero_1_1_10", new AbsoluteBitmap( R.drawable.hero_1_1_10 ) );
		 
		 list_bmp.put( "hero_1_2_1", new AbsoluteBitmap( R.drawable.hero_1_2_1 ) );
		 list_bmp.put( "hero_1_2_2", new AbsoluteBitmap( R.drawable.hero_1_2_2 ) );
		 list_bmp.put( "hero_1_2_3", new AbsoluteBitmap( R.drawable.hero_1_2_3 ) );
		 list_bmp.put( "hero_1_2_4", new AbsoluteBitmap( R.drawable.hero_1_2_4 ) );
		 list_bmp.put( "hero_1_2_5", new AbsoluteBitmap( R.drawable.hero_1_2_5 ) );
		 list_bmp.put( "hero_1_2_6", new AbsoluteBitmap( R.drawable.hero_1_2_6 ) );
		 list_bmp.put( "hero_1_2_7", new AbsoluteBitmap( R.drawable.hero_1_2_7 ) );
		 list_bmp.put( "hero_1_2_8", new AbsoluteBitmap( R.drawable.hero_1_2_8 ) );
		 list_bmp.put( "hero_1_2_9", new AbsoluteBitmap( R.drawable.hero_1_2_9 ) );
		 list_bmp.put( "hero_1_2_10", new AbsoluteBitmap( R.drawable.hero_1_2_10 ) );
		 list_bmp.put( "hero_1_2_11", new AbsoluteBitmap( R.drawable.hero_1_2_11 ) );
		 
		 list_bmp.put( "hero_2_1_drag", new AbsoluteBitmap( R.drawable.hero_2_1_1 ) );
		 list_bmp.put( "hero_2_1_1", new RelativeBitmap( R.drawable.hero_2_1_1 ) );
		 list_bmp.put( "hero_2_1_2", new RelativeBitmap( R.drawable.hero_2_1_2 ) );
		 list_bmp.put( "hero_2_1_3", new RelativeBitmap( R.drawable.hero_2_1_3 ) );
		 list_bmp.put( "hero_2_1_4", new RelativeBitmap( R.drawable.hero_2_1_4 ) );
		 list_bmp.put( "hero_2_1_5", new RelativeBitmap( R.drawable.hero_2_1_5 ) );
		 list_bmp.put( "hero_2_1_6", new RelativeBitmap( R.drawable.hero_2_1_6 ) );
		 list_bmp.put( "hero_2_1_7", new RelativeBitmap( R.drawable.hero_2_1_7 ) );
		 list_bmp.put( "hero_2_1_8", new RelativeBitmap( R.drawable.hero_2_1_8 ) );
		 list_bmp.put( "hero_2_1_9", new RelativeBitmap( R.drawable.hero_2_1_9 ) );
		 list_bmp.put( "hero_2_1_10", new RelativeBitmap( R.drawable.hero_2_1_10 ) );
		 
		 list_bmp.put( "hero_2_2_drag", new AbsoluteBitmap( R.drawable.hero_2_2_1 ) );
		 list_bmp.put( "hero_2_2_1", new RelativeBitmap( R.drawable.hero_2_2_1 ) );
		 list_bmp.put( "hero_2_2_2", new RelativeBitmap( R.drawable.hero_2_2_2 ) );
		 list_bmp.put( "hero_2_2_3", new RelativeBitmap( R.drawable.hero_2_2_3 ) );
		 list_bmp.put( "hero_2_2_4", new RelativeBitmap( R.drawable.hero_2_2_4 ) );
		 list_bmp.put( "hero_2_2_5", new RelativeBitmap( R.drawable.hero_2_2_5 ) );
		 list_bmp.put( "hero_2_2_6", new RelativeBitmap( R.drawable.hero_2_2_6 ) );
		 list_bmp.put( "hero_2_2_7", new RelativeBitmap( R.drawable.hero_2_2_7 ) );
		 list_bmp.put( "hero_2_2_8", new RelativeBitmap( R.drawable.hero_2_2_8 ) );
		 list_bmp.put( "hero_2_2_9", new RelativeBitmap( R.drawable.hero_2_2_9 ) );
		 list_bmp.put( "hero_2_2_10", new RelativeBitmap( R.drawable.hero_2_2_10 ) );
		 list_bmp.put( "hero_2_2_11", new RelativeBitmap( R.drawable.hero_2_2_11 ) );
		 list_bmp.put( "hero_2_2_12", new RelativeBitmap( R.drawable.hero_2_2_12 ) );
		 
		 list_bmp.put( "hero_3_1_drag", new AbsoluteBitmap( R.drawable.hero_3_1_1 ) );
		 list_bmp.put( "hero_3_1_1", new RelativeBitmap( R.drawable.hero_3_1_1 ) );
		 list_bmp.put( "hero_3_1_2", new RelativeBitmap( R.drawable.hero_3_1_2 ) );
		 list_bmp.put( "hero_3_1_3", new RelativeBitmap( R.drawable.hero_3_1_3 ) );
		 list_bmp.put( "hero_3_1_4", new RelativeBitmap( R.drawable.hero_3_1_4 ) );
		 list_bmp.put( "hero_3_1_5", new RelativeBitmap( R.drawable.hero_3_1_5 ) );
		 list_bmp.put( "hero_3_1_6", new RelativeBitmap( R.drawable.hero_3_1_6 ) );
		 list_bmp.put( "hero_3_1_7", new RelativeBitmap( R.drawable.hero_3_1_7 ) );
		 list_bmp.put( "hero_3_1_8", new RelativeBitmap( R.drawable.hero_3_1_8 ) );
		 list_bmp.put( "hero_3_1_9", new RelativeBitmap( R.drawable.hero_3_1_9 ) );
		 
		 list_bmp.put( "hero_3_2_1", new AbsoluteBitmap( R.drawable.hero_3_2_1 ) );
		 list_bmp.put( "hero_3_2_2", new AbsoluteBitmap( R.drawable.hero_3_2_2 ) );
		 list_bmp.put( "hero_3_2_3", new AbsoluteBitmap( R.drawable.hero_3_2_3 ) );
		 list_bmp.put( "hero_3_2_4", new AbsoluteBitmap( R.drawable.hero_3_2_4 ) );
		 list_bmp.put( "hero_3_2_5", new AbsoluteBitmap( R.drawable.hero_3_2_5 ) );
		 list_bmp.put( "hero_3_2_6", new AbsoluteBitmap( R.drawable.hero_3_2_6 ) );
		 list_bmp.put( "hero_3_2_7", new AbsoluteBitmap( R.drawable.hero_3_2_7 ) );
		 list_bmp.put( "hero_3_2_8", new AbsoluteBitmap( R.drawable.hero_3_2_8 ) );
		 
		 /***********************************开始游戏界面图片**************************************/
		 list_bmp.put( "StartBackground", new AbsoluteBitmap( R.drawable.start_background ) );
		 list_bmp.put( "Start_BUTTON", new AbsoluteBitmap( R.drawable.start_button ) );
		 list_bmp.put( "Score_BUTTON", new AbsoluteBitmap( R.drawable.score_button ) );
		 list_bmp.put( "Help_BUTTON", new AbsoluteBitmap( R.drawable.help_button ) );
		 list_bmp.put( "Exit_BUTTON", new AbsoluteBitmap( R.drawable.exit_button ) );
		 
		 /************************************士兵升级界面图片****************************************/
		 list_bmp.put( "SoilderBackground", new AbsoluteBitmap( R.drawable.soilder_view_background ) );
		 list_bmp.put( "Footman_icon", new TransparentAbsoluteBitmap( R.drawable.footman_icon ) );
		 list_bmp.put( "Archer_icon", new TransparentAbsoluteBitmap( R.drawable.archer_icon ) );
		 list_bmp.put( "Shield_icon", new TransparentAbsoluteBitmap( R.drawable.shield_icon ) );
		 list_bmp.put( "Rider_icon", new TransparentAbsoluteBitmap( R.drawable.rider_icon ) );
		 list_bmp.put( "Ensure_BUTTON", new AbsoluteBitmap( R.drawable.ensure ) );
		 list_bmp.put( "Footman_levelup_BUTTON", new AbsoluteBitmap( R.drawable.levelup ) );
		 list_bmp.put( "Archer_levelup_BUTTON", new AbsoluteBitmap( R.drawable.levelup ) );
		 list_bmp.put( "Shield_levelup_BUTTON", new AbsoluteBitmap( R.drawable.levelup ) );
		 list_bmp.put( "Rider_levelup_BUTTON", new AbsoluteBitmap( R.drawable.levelup ) );
		 
		 /*************************************英雄选择界面********************************************/
		 list_bmp.put("hero_select_background", new AbsoluteBitmap( R.drawable.hero_select_background ) );
		 list_bmp.put("hero_select_ensure", new AbsoluteBitmap( R.drawable.hero_select_ensure ) );
		 list_bmp.put("hero_select_describe", new AbsoluteBitmap( R.drawable.hero_select_decribe ) );
		 list_bmp.put("choose", new AbsoluteBitmap( R.drawable.choose ) );
		 list_bmp.put("select", new AbsoluteBitmap( R.drawable.select ) );
		 list_bmp.put("cansel", new AbsoluteBitmap( R.drawable.cansel ) );
		 
		 list_bmp.put("hero_1_select", new AbsoluteBitmap( R.drawable.hero_1_select ) );
		 list_bmp.put("hero_1_describe", new AbsoluteBitmap( R.drawable.hero_1_decribe ) );
		 list_bmp.put("hero_2_select", new AbsoluteBitmap( R.drawable.hero_2_select ) );
		 list_bmp.put("hero_2_describe", new AbsoluteBitmap( R.drawable.hero_2_decribe ) );
		 list_bmp.put("hero_3_select", new AbsoluteBitmap( R.drawable.hero_3_select ) );
		 list_bmp.put("hero_3_describe", new AbsoluteBitmap( R.drawable.hero_3_decribe ) );
		 
		 /*************************************帮助界面****************************************/
		 list_bmp.put("help_background", new AbsoluteBitmap( R.drawable.help_background ) );
		 list_bmp.put("help_return", new AbsoluteBitmap( R.drawable.help_return ) );
	}
	
	public MyBitmap getBitmap( String name ){
		return list_bmp.get(name);
	}
	
}
