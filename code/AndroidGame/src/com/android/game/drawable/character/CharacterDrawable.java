package com.android.game.drawable.character;

import com.android.game.drawable.Drawable;

/*
CharacterDrawable游戏角色绘图部分
有若干种状态，每种状态对应一种动画
*/

public interface CharacterDrawable extends Drawable{

	public static final int MOVE = 0;           //移动状态
	public static final int ATTACK = 1;         //攻击状态
	public static final int SKILL = 2;             //技能使用中
	public static final int DEATH = 3;          //死亡状态
	
	public int getState();
	
	public void setState( int state );
	
	public boolean isDead();
	
}
