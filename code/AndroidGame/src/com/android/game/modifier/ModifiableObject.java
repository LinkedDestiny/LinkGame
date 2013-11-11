package com.android.game.modifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author 星陨
 * 
 * @功能 可修正对象的实体类
 *
 */
public class ModifiableObject implements Modifiable , ModifierObjectContainer{

	private int baseValue;
	private int modifierValue;
	private Map<ModifierType , Collection<ModifierObject>> modifiers = 
			new HashMap< ModifierType , Collection<ModifierObject> >();
	
	public ModifiableObject( int baseValue ){
		this.baseValue = baseValue;
		this.modifierValue = baseValue;
	}
	public ModifiableObject(){
		this(0);
	}
	
	protected Collection<ModifierObject> getModifiers( ModifierType type ){
		Collection<ModifierObject> typeModifiers = ( Collection<ModifierObject> )modifiers.get(type);
		if( typeModifiers == null ){
			typeModifiers = new ArrayList<ModifierObject>();
		}
		return typeModifiers;
	}
	
	private void updateModifiers( ModifierType type , Collection<ModifierObject> typeModifiers ){
		modifiers.put(type, typeModifiers);
		calculate();
	}
	
	public void addModifierObject(ModifierObject modifierObject) {
		
		ModifierType type = (ModifierType)modifierObject.getModifierType();
		Collection<ModifierObject> typeModifiers = this.getModifiers(type);
		typeModifiers.add(modifierObject);
		this.updateModifiers(type, typeModifiers);
	}

	public void removeModifierObject(ModifierObject modifierObject) {
		System.out.println("remove object");
		ModifierType type = (ModifierType)modifierObject.getModifierType();
		Collection<ModifierObject> typeModifiers = this.getModifiers(type);
		typeModifiers.remove(modifierObject);
		this.updateModifiers(type, typeModifiers);
	}
	
	public Collection<?> getModifierObjects() {
		return modifiers.values();
	}

	public void onModify(long nowTime) {
		boolean flag = false;
		Iterator<ModifierType> iterator = modifiers.keySet().iterator();
		while( iterator.hasNext() ){
			flag = false;
			ModifierType type = (ModifierType)iterator.next();
			Collection<ModifierObject> typeModifier = ( Collection<ModifierObject> )modifiers.get(type);
			Iterator<ModifierObject> modifier = typeModifier.iterator();
			while( modifier.hasNext() ){
				ModifierObject object = ( ModifierObject )modifier.next();
				if( object.onModify(nowTime) ){
					modifier.remove();
					flag = true;
				}
			}
			if( flag )
				this.updateModifiers(type, typeModifier);
		}
	}

	public int getBaseValue() {
		return baseValue;
	}

	public int getModifierValue() {
		return modifierValue;
	}

	public void calculate() {
		int value = baseValue;
		Iterator<ModifierType> iterator = modifiers.keySet().iterator();
		while( iterator.hasNext() ){
			ModifierType type = (ModifierType)iterator.next();
			Collection<ModifierObject> typeModifier = ( Collection<ModifierObject> )modifiers.get(type);
			value += type.calculateModifiers(typeModifier);
		}
		modifierValue = value;
	}

	public void setBaseValue(int value) {
		this.baseValue = value;
	}

}
