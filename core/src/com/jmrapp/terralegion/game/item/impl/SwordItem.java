package com.jmrapp.terralegion.game.item.impl;

import com.jmrapp.terralegion.game.item.ItemType;
import com.jmrapp.terralegion.game.world.block.BlockType;

/**
 * Created by Jon on 10/6/15.
 */
public class SwordItem extends CombatItem {

	public SwordItem(ItemType type, String name, int maxItemStack, float damage, float power, float reach, float useDelay) {
		super(type, name, maxItemStack, damage, power, reach, useDelay);
	}

	public boolean canDamageBlock(BlockType type) {
		return false;
	}

}
