package com.jmrapp.terralegion.game.item;

/**
 * Created by Jon on 10/1/15.
 */
public class Item {

	private int typeId;
	private String name;
	private int maxItemStack;
	private ItemCategory category;

	public Item(int typeId, ItemCategory category, String name, int maxItemStack) {
		this.typeId = typeId;
		this.category = category;
		this.name = name;
		this.maxItemStack = maxItemStack;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getName() {
		return name;
	}

	public int getMaxItemStack() {
		return maxItemStack;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public String toString() {
		return "";
	}

}
